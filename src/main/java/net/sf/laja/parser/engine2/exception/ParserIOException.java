package net.sf.laja.parser.engine2.exception;

public class ParserIOException extends ParserException {
	private static final long serialVersionUID = 1L;

	public ParserIOException() {
		super();
	}

	public ParserIOException(String message) {
		super(message);
	}

	public ParserIOException(Throwable cause) {
		super(cause);
	}

	public ParserIOException(String message, Throwable cause) {
		super(message, cause);
	}
}
