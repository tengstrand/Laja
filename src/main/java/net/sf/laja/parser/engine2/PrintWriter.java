package net.sf.laja.parser.engine2;

public class PrintWriter implements Writer {

	public void close() {
	}

	public Writer write(Object text) {
		System.out.print(text);
		return this;
	}

	public Writer write(int value) {
		System.out.print(String.valueOf(value));
		return this;
	}
	
	public Writer writeln(Object text) {
		System.out.println(text);
		return this;
	}

	public Writer writeln(int value) {
		System.out.print(String.valueOf(value));
		return this;
	}

	public Writer writeException(Exception e) {
		writeln(e.getMessage());
		
		for (StackTraceElement element : e.getStackTrace()) {
			writeln(element);
		}
		return this;
	}
	
	public Writer writeException(String message, Exception e) {
		writeln(e.getMessage());
		writeException(e);
		
		return this;
	}
}
