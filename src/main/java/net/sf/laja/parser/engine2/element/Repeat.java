package net.sf.laja.parser.engine2.element;

import net.sf.laja.parser.engine2.NoOutput;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.Recorder;
import net.sf.laja.parser.engine2.Repeats;
import net.sf.laja.parser.engine2.source.Source;

public class Repeat implements Element {
	private int id;
	private int minRepeats;
	private int maxRepeats;
	private boolean not;
	private String name;
	private ElementList elementList;
	private Output output;

	public Repeat(int id) {
		this(id, "");
	}

	public Repeat(int id, Repeats repeats) {
		this(id, "", repeats);
	}
	
	public Repeat(int id, String name) {
		this(id, name, new NoOutput());
	}

	public Repeat(int id, String name, Repeats repeats) {
		this(id, name, repeats, new NoOutput());
	}
	
	public Repeat(int id, String name, int flags) {
		this(id, name, flags, new NoOutput());
	}

	public Repeat(int id, String name, int flags, Repeats repeats) {
		this(id, name, flags, repeats, new NoOutput());
	}
	
	public Repeat(int id, String name, Output output) {
		this(id, name, 0, output);
	}

	public Repeat(int id, String name, Repeats repeats, Output output) {
		this(id, name, 0, repeats, output);
	}
	
	public Repeat(int id, String name, int flags, Output output) {
		this(id, name, flags, null, output);
	}

	public Repeat(int id, String name, int flags, Repeats repeats, Output output) {
		this.id = id;
		this.elementList = new ElementList(id, name, flags & ~NOT);
		this.name = name;
		this.output = output;
		this.not = (flags & NOT) > 0;
		if (repeats == null) {
			minRepeats = 0;
			maxRepeats = Integer.MAX_VALUE;
		} else {
			minRepeats = repeats.getMin();
			maxRepeats = repeats.getMax();
		}
	}

	@Override
	public boolean isOptional() {
		return false;
	}
	
	public int getId(){
		return id;
	}

	public String getIdName() {
		return name;
	}
	
	public String getString() {
		return null;
	}

	public boolean isTerminal() {
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public void add(int id, Element element) {
		elementList.add(id, element);
	}

	public void add(int id, Element element, int flags) {
		elementList.add(id, element, flags);
	}

	public void add(int id, Element element, Output output) {
		elementList.add(id, element, output);
	}

	public void add(int id, Element element, int flags, Output output) {
		elementList.add(id, element, flags, output);
	}

	public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
		boolean match;
		boolean firstMatch;

		int bookmark;
		int firstBookmark;

		Recorder recorder = source.getRecorder();
		firstBookmark = bookmark = source.getBookmark();
		
		if (maxRepeats > 0) {
			if (receive) {
				match = firstMatch = recorder.playMatch(elementList, source.getBookmark());
			} else {
				int index = recorder.reserveMatchIndex(level, elementList, source.getBookmark(), parentNot, false);
				match = elementList.parse(level, source, not|parentNot, caseSensitive, false);
				match = firstMatch = (match && source.getBookmark() != bookmark);
				recorder.set(level, source, elementList, bookmark, source.getBookmark(), source.getBestIndex(), index, match, parentNot, false);
			}
		} else {
			match = firstMatch = true;
		}
		
		int repeats = 0;
		
		if (!not) {
			while (match) {
				if (receive) {
					source.setBookmark(bookmark);
					elementList.parse(level, source, not|parentNot, caseSensitive, true);
				}
				if (++repeats >= maxRepeats) {
					break;
				}
				if (source.reachedEnd()) {
					bookmark = source.getBookmark();
					break;
				}
				bookmark = source.getBookmark();

				if (receive) {
					match = recorder.playMatch(elementList, source.getBookmark());
				} else {
					int index = recorder.reserveMatchIndex(level, elementList, source.getBookmark(), parentNot, false);
					int sourceIndex = source.getBestIndex();
					match = elementList.parse(level, source, not|parentNot, caseSensitive, false);
					match = (match && source.getBookmark() != bookmark);
					recorder.set(level, source, elementList, bookmark, source.getBookmark(), sourceIndex, index, match, parentNot, false);
				}
			}
		}

		if (!match) {
			source.setBookmark(bookmark);
		}
		if (repeats < minRepeats) {
			firstMatch = false;
		}
		firstMatch = firstMatch != not;

		if (firstMatch) {
			if (not) {
				source.skipCharacter();
			}
			if (receive || output.receive()) {
				output.init(source);
				output.set(source, firstBookmark);
			}
		}
		return firstMatch;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Repeat:[id=").append(id)
			.append(", not=").append(not)
			.append(", name=").append(name)
			.append(", elementList=").append(elementList)
			.append(", output=").append(output)
			.append("]");
		return sb.toString();
	}
}
