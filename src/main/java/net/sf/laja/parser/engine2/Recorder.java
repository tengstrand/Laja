package net.sf.laja.parser.engine2;

import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.source.Source;

public interface Recorder extends MaxSource {
	public void set(int level, Source source, Element element, int beforeSourceIndex, int afterSourceIndex, int bestSourceIndex, int mindex, boolean match, boolean parentNot, boolean not);
	public void set(int level, Source source, Element element, int beforeSourceIndex, int afterSourceIndex, int bestSourceIndex, int mindex, int bindex, boolean match, boolean parentNot, boolean not);
	public int reserveMatchIndex(int level, Element element, int beforeSourceIndex, boolean parentNot, boolean not);
	public int reserveBookmarkIndex();
	public void rewind();
	public boolean playMatch(Element element, int beforeSourceIndex);
	public int playBookmark();
	public int getIndex();
	public void setIndex(int index);
	public void setLogging(Writer writer, int bestSourceIndex);
	public void printLogging(Source source);
}
