package net.sf.laja.parser.engine2;

import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.source.Source;

public interface RecorderLogging {
	public void reserveId(Element element, int mindex, int beforeSourceIndex, boolean not);
	public void setId(Source source, Element element, int beforeSourceIndex, int afterSourceIndex, int bestSourceIndex, int mindex, boolean match, boolean not);
	public void printTrace(Source source);
}
