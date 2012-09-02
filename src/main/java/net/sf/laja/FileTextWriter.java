package net.sf.laja;

public interface FileTextWriter {
	public void open();
	public void close(boolean ok);
	public void write(Object object);
}
