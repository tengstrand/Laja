package net.sf.laja.parser.engine2.source;

import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.Recorder;
import net.sf.laja.parser.engine2.RecorderImpl;

public abstract class AbstractSource implements Source {
	private int index;
	private int startIndex;
	private int endIndex;
	private int bestIndex = -1;
	private char[] characters;
	private Recorder recorder;

	private static final char EOF = (char)-1;
	private static final char HORIZONTAL_TABULATION = 9;
	private static final char LINE_FEED = 10;
	private static final char FORM_FEED = 13;
	
	public static class InitResult {
		public int startIndex;
		public int endIndex;
		public char[] characters;
		
		public InitResult(int startIndex, int endIndex, char[] characters) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.characters = characters;
		}
	}
	
	public AbstractSource(String sourceName) {
		InitResult result = init(sourceName);
		startIndex = result.startIndex;
		endIndex = result.endIndex;
		characters = result.characters;
		recorder = new RecorderImpl(endIndex-startIndex);
	}

	public AbstractSource(Recorder recorder, int startIndex, int endIndex, char[] characters) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.characters = characters;
		this.recorder = recorder;
		
		this.index = startIndex;
		this.bestIndex = -1;
	}
	
	public abstract InitResult init(String sourceName);

	@Override
	public void reset() {
		index = startIndex;
		bestIndex = -1;
		recorder.rewind();
	}
	
	@Override
	public int getStartIndex() {
		return startIndex;
	}
	
	@Override
	public int getEndIndex() {
		return endIndex;
	}

	public char[] getCharacters() {
		return characters;
	}
	
	@Override
	public String get(int bookmark) {
		return String.valueOf(characters, bookmark, index - bookmark);
	}

	@Override
	public String get(int bookmark, int length) {
		if (bookmark > endIndex) {
			return "";
		}
		int end = bookmark + length;
		if (end > endIndex) {
			length = endIndex - bookmark;
		}
		return String.valueOf(characters, bookmark, length);
	}

	@Override
	public void skipCharacter() {
		if (!reachedEnd()) {
			index++;
		}
		return;
	}
	
	@Override
	public char getCharacter() {
		if (index >= endIndex) {
			return (char)EOF;
		}

		return characters[index++];
	}
	
	@Override
	public String getCharacterAsString() {
		int len = 1;
		if (index >= endIndex) {
			return "";
		}

		return String.valueOf(characters, index++, len);
	}

	@Override
	public Index getIndex(int bookmark) {
		return new Index(bookmark, index);
	}
	
	@Override
	public boolean reachedEnd() {
		return index == endIndex;
	}

	@Override
	public int getBookmark() {
		return index;
	}
	
	@Override
	public void setBookmark(int bookmark) {
		index = bookmark;
	}

	@Override
	public void setBestIndex() {
		if (index > bestIndex) {
			bestIndex = index;
		}
	}

	@Override
	public int getBestIndex() {
		return bestIndex;
	}
	
	@Override
	public void setBestIndex(int idx) {
		bestIndex = idx;
	}
	
	@Override
	public Recorder getRecorder() {
		return recorder;
	}
	
	@Override
	public boolean match(char[] compare, boolean parentNot, boolean not, boolean caseSensitive) {
		int maxIdx = index + compare.length;
		
		if (maxIdx > endIndex) {
			return false;
		}
		
		boolean eq = true;

		int startIdx = index;
		index--;
		int ci = -1;

		// The logic is fetched (with small modifications) from java.lang.String.regionMatches(boolean ignoreCase, ...).
		while (++index < maxIdx) {
			ci++;
			if (characters[index] == compare[ci]) {
				continue;
			}
			if (!caseSensitive) {
				char u1 = Character.toUpperCase(characters[index]);
				char u2 = Character.toUpperCase(compare[ci]);
				if (u1 == u2) {
					continue;
				}
				// Unfortunately, conversion to uppercase does not work properly
				// for the Georgian alphabet, which has strange rules about case
				// conversion. So we need to make one last check before
				// exiting.
				if (Character.toLowerCase(u1) == Character.toLowerCase(u2)) {
					continue;
				}
			}
			eq = false;
			break;
		}

		eq = eq != not;

		if (eq) {
			if (not) {
				index = startIdx + 1;
			}
			if (!parentNot) {
				setBestIndex();
			}
		}

		return eq;
	}

	
	/**
	 * Returns the corresponding row and column for a given index in the source.
	 * Probably most used when pointing out a syntax error in a source.
	 * 
	 * Also return the line and a cursor pointing at the column, example:
	 * 
	 * #import thefile"        <-- line
	 *         ^               <-- column
	 * 
	 * @param findIndex
	 * @return the line matching for given index
	 */
	public SourceLine getSourceLine(int findIndex) {
		int row = 1;
		int column = 1;
		char character;
		String line = "";
		String cursor = "";
		
		reset();

		outer:
		while (true) {
			character = getCharacter();
			
			if (character == EOF) {
				break;
			}
			
			if (index > findIndex) {
				// Add the rest of the line.
				while (true) {
					if (character == HORIZONTAL_TABULATION) {
						line += "\\t";
					} else {
						line += character;
					}
					
					character = getCharacter();
					
					if (character == EOF ||
					    character == LINE_FEED ||
					    character == FORM_FEED) {
						break outer;
					}
				}
			}

			if (character == FORM_FEED) {
			} else if (character == LINE_FEED) {
				line = "";
				cursor = "";
				row++;
				column = 1;
			} else {
				column++;
				if (character == HORIZONTAL_TABULATION) {
					line += character;
					cursor += character;
				} else {
					line += character;
					cursor += " ";
				}
			}
		}
		
		return new SourceLine(row, column, findIndex, line, cursor + "^");
	}
}
