package net.sf.laja.parser.engine2.source;

import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.Recorder;

public interface Source {
	public String getType();
	public String getName();
	public void skipCharacter();
	public char getCharacter();
	public String getCharacterAsString();
	public String get(int bookmark);
	public String get(int bookmark, int length);
	public Index getIndex(int bookmark);
	public int getStartIndex();
	public int getEndIndex();
	public boolean reachedEnd();
	public int getBookmark();
	public void setBookmark(int bookmark);
	public int getBestIndex();
	public void setBestIndex();
	public void setBestIndex(int idx);
	public void reset();
	public Recorder getRecorder();
	public Source newSource(int startIndex, int endIndex);
	public boolean match(char[] compare, boolean parentNot, boolean not, boolean caseSensitive);
	public SourceLine getSourceLine(int findIndex);
}
