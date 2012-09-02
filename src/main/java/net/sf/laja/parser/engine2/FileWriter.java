package net.sf.laja.parser.engine2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import net.sf.laja.parser.engine2.exception.ParserException;

public class FileWriter implements Writer {
	private String filename;
	private FileOutputStream outputStream;
	private BufferedWriter writer;

	public FileWriter(String filename) throws ParserException {
		this.filename = filename;
		try {
			outputStream = new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			throw new ParserException();
		}
		writer = new BufferedWriter(new OutputStreamWriter(outputStream));
	}

	public void finalize() throws Throwable {
		super.finalize();
		close();
	}

	public Writer write(Object text) throws ParserException {
		try {
			writer.write(text.toString());
		} catch (IOException e) {
			throw new ParserException(e);
		}
		return this;
	}

	public Writer write(int value) throws ParserException {
		try {
			writer.write(String.valueOf(value));
		} catch (IOException e) {
			throw new ParserException(e);
		}
		return this;
	}
	
	public Writer writeln(Object text) throws ParserException {
		try {
			writer.write(text.toString());
			writer.newLine();
		} catch (IOException e) {
			throw new ParserException(e);
		}
		return this;
	}

	public Writer writeln(int value) throws ParserException {
		try {
			writer.write(String.valueOf(value));
			writer.newLine();
		} catch (IOException e) {
			throw new ParserException(e);
		}
		return this;
	}
	
	public void close() throws ParserException {
		if (writer != null && outputStream != null) {
			try {
				writer.flush();
				writer.close();
				outputStream.close();
			} catch (IOException e) {
				throw new ParserException(e);
			}
		}
		writer = null;
		outputStream = null;
	}
	
	public String toString() {
		return "filename=\"" + filename + "\"";
	}


	public Writer writeException(Exception e) throws ParserException {
		return writeException(null, e);
	}
	
	public Writer writeException(String message, Exception e) throws ParserException {
		try {
			if (message != null) {
				writer.write(message + ". ");
			}
			writer.write(e.getMessage() + e.getStackTrace());
		} catch (IOException e1) {
			throw new ParserException(e1);
		}
		
		for (StackTraceElement element : e.getStackTrace()) {
			writeln(element);
		}
		return this;
	}
}