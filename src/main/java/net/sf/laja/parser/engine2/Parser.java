package net.sf.laja.parser.engine2;

import net.sf.laja.parser.engine2.source.Source;

public interface Parser {
	public ParsingResult parse(Source source) throws Exception;
}
