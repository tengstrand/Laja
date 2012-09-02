package net.sf.laja.parser.engine2.inspector;

import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.exception.ParserException;
import net.sf.laja.parser.engine2.source.Source;

public interface SyntaxErrorHandler {
	public void writeSyntaxError(boolean success, Source source, Element element) throws ParserException;
}
