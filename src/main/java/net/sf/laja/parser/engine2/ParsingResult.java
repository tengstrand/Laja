package net.sf.laja.parser.engine2;

import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.inspector.SyntaxErrorHandler;
import net.sf.laja.parser.engine2.source.Source;

public class ParsingResult {
	private boolean success;
	private int bestIdx;

	public ParsingResult(boolean success, Source source, SyntaxErrorHandler syntaxErrorHandler) {
		this(success, source, null, syntaxErrorHandler);
	}
	
	public ParsingResult(boolean success, Source source, Element element, SyntaxErrorHandler syntaxErrorHandler) {
		this.success = success;
		this.bestIdx = source.getBestIndex();
		
		if (!success && syntaxErrorHandler != null) {
			syntaxErrorHandler.writeSyntaxError(success, source, element);
		}
	}

	public boolean success() {
		return success;
	}
	
	public int getBestIndex() {
		return bestIdx;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[")
			.append("success=").append(success)
			.append(", bestIdx=").append(bestIdx)
			.append("]");
		return sb.toString();
	}
}
