package net.sf.laja.parser.engine2.source;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import net.sf.laja.parser.engine2.Recorder;
import net.sf.laja.parser.engine2.exception.ParserException;

public class URLSource extends AbstractSource {
	private String urlString;
	
	public URLSource(String urlString) throws ParserException {
		super(urlString);
	}

	private URLSource(Recorder recorder, int startIndex, int endIndex, char[] characters) {
		super(recorder, startIndex, endIndex, characters);
	}
	
	public String getType() {
		return "URL";
	}

	public String getName() {
		return urlString;
	}

	@Override
	public InitResult init(String name) {
		this.urlString = name;

		URL url;
	    URLConnection con;
	    
		try {
			url = new URL(urlString);
			con = url.openConnection();
			int size = con.getContentLength();
		    char[] characters = new char[size];  
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			in.read(characters);
			in.close();
			return new InitResult(0, size, characters);
		} catch (Exception e) {
			throw new ParserException(e);
		}
	}

	@Override
	public Source newSource(int startIndex, int endIndex) {
		return new URLSource(getRecorder(), startIndex, endIndex, getCharacters());
	}
}
