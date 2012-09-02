package net.sf.laja.parser.engine2;

public class EmptyWriter implements Writer {
	public void close() {
	}

	public Writer write(Object text) {
		return this;
	}

	public Writer write(int value) {
		return this;
	}

	public Writer writeln(Object text) {
		return this;
	}

	public Writer writeln(int value) {
		return this;
	}

	public Writer writeException(Exception exception) {
		return this;
	}
	
	public Writer writeException(String message, Exception exception) {
		return this;
	}
}
