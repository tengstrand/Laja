package net.sf.laja.parser.engine2;

public interface Writer {
	public Writer write(Object text);
	public Writer write(int value);
	public Writer writeln(Object text);
	public Writer writeln(int value);
	public Writer writeException(Exception exception);
	public Writer writeException(String message, Exception exception);
	public void close();
}
