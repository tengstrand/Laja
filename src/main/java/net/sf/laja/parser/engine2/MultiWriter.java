package net.sf.laja.parser.engine2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MultiWriter implements Writer {

	private Collection<Writer> writers = new ArrayList<Writer>();
	
	public MultiWriter() {
	}
	
	public MultiWriter(Writer... writer) {
		writers.addAll(Arrays.asList(writer));
	}
	
	public void remove(Writer writer) {
		writers.remove(writer);
	}
	
	public void close() {
		for (Writer writer : writers) {
			writer.close();
		}
	}

	public Writer write(Object text) {
		for (Writer writer : writers) {
			writer.write(text);
		}
		return this;
	}

	public Writer write(int value) {
		for (Writer writer : writers) {
			writer.write(String.valueOf(value));
		}
		return this;
	}
	
	
	public Writer writeln(Object text) {
		for (Writer writer : writers) {
			writer.writeln(text);
		}
		return this;
	}
	
	public Writer writeln(int value) {
		for (Writer writer : writers) {
			writer.writeln(String.valueOf(value));
		}
		return this;
	}

	public Writer writeException(Exception e) {
		for (Writer writer : writers) {
			writer.writeException(e);
		}
		return this;
	}
	
	public Writer writeException(String message, Exception e) {
		for (Writer writer : writers) {
			writer.write(message + ". ");
			writer.writeException(e);
		}
		return this;
	}
}
