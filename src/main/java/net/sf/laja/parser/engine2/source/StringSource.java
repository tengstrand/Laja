package net.sf.laja.parser.engine2.source;

import net.sf.laja.parser.engine2.Recorder;

public class StringSource extends AbstractSource {
	public StringSource(String stringSource) {
		super(stringSource);
	}

	private StringSource(Recorder recorder, int startIndex, int endIndex, char[] characters) {
		super(recorder, startIndex, endIndex, characters);
	}
	
	public String getType() {
		return "string";
	}

	public String getName() {
		return null;
	}

	@Override
	public InitResult init(String sourceName) {
		char[] characters = sourceName.toCharArray();
		return new InitResult(0, characters.length, characters);
	}

	@Override
	public Source newSource(int startIndex, int endIndex) {
		return new StringSource(getRecorder(), startIndex, endIndex, getCharacters());
	}
}
