package net.sf.laja.exception;

import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.parser.engine2.source.SourceLine;

public class InterpretationException extends RuntimeException {
	public InterpretationException(Source source, int indexInSource) {
		super(getMessage(source, indexInSource));
	}

	public InterpretationException(Source source, int indexInSource, String message) {
		super(getMessage(source, indexInSource, message));
	}
	
	public InterpretationException(Source source, int indexInSource, Throwable cause) {
		super(getMessage(source, indexInSource, cause), cause);
	}

	private static String getMessage(Source source, int indexInSource, String message) {
		return message + "\n" + getMessage(source, indexInSource);
	}
	
	private static String getMessage(Source source, int indexInSource, Throwable cause) {
		return cause.getMessage() + "\n" + getMessage(source, indexInSource);
	}
	
	private static String getMessage(Source source, int indexInSource) {
		SourceLine sourceLine = source.getSourceLine(indexInSource);
		return "Error in " + source.getType() + " \"" + source.getName() + "\", row " + sourceLine.getRow() + 
			", column " + sourceLine.getColumn() + ":\n" +
			sourceLine.getLine() + "\n" +
			sourceLine.getCursor() + "\n";
	}
}
