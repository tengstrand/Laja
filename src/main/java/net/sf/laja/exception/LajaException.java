package net.sf.laja.exception;

public class LajaException extends RuntimeException {

	public LajaException() {
	}

	public LajaException(String message) {
		super(message);
	}

	public LajaException(Throwable cause) {
		super(cause);
	}

	public LajaException(String message, Throwable cause) {
		super(message, cause);
	}
}
