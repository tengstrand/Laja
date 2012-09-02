package net.sf.laja.parser.engine2.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import net.sf.laja.parser.engine2.Recorder;
import net.sf.laja.parser.engine2.exception.ParserException;
import net.sf.laja.parser.engine2.exception.ParserIOException;

public class FileSource extends AbstractSource {
	private String filename;

	public FileSource(String filename) throws ParserException {
		super(filename);
	}

	private FileSource(Recorder recorder, String filename, char[] characters, int startIndex, int endIndex) {
		super(recorder, startIndex, endIndex, characters);
		this.filename = filename;
	}

	@Override
	public InitResult init(String sourceName) {
		filename = sourceName;

		try {
			File file = new File(filename);
			int size = (int)file.length();
			char[] characters = new char[size];

			FileInputStream inputStream = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			reader.read(characters);
			reader.close();
			inputStream.close();
			return new InitResult(0, size, characters);
		} catch (IOException e) {
			throw new ParserIOException(e);
		}
	}

	public Source newSource(int startIndex, int endIndex) {
		return new FileSource(getRecorder(), filename, getCharacters(), startIndex, endIndex);
	}
	
	public String getType() {
		return "file";
	}

	public String getName() {
		return filename;
	}
}
