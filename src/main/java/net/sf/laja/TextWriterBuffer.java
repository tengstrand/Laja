package net.sf.laja;

public class TextWriterBuffer implements TextWriter {
	private StringBuilder builder = new StringBuilder();
	
	@Override
	public String getText() {
		return builder.toString();
	}

	@Override
	public void write(Object object) {
		builder.append(object == null ? "NULL" : object.toString());
	}
}
