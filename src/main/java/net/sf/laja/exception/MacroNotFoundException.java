package net.sf.laja.exception;

import net.sf.laja.parser.engine2.source.Source;

public class MacroNotFoundException extends InterpretationException {
	public MacroNotFoundException(Source source, int indexInSource) {
		super(source, indexInSource);
	}

	public MacroNotFoundException(Source source, int indexInSource, String message) {
		super(source, indexInSource, message);
	}
	
	public MacroNotFoundException(Source source, int indexInSource, Throwable cause) {
		super(source, indexInSource, cause);
	}
}
