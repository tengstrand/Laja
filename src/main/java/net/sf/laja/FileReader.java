package net.sf.laja;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

	public String readFile(String filename) throws IOException {
		File file = new File(filename);
		StringBuffer contents = new StringBuffer();
		BufferedReader reader = null;

		final String newLine = System.getProperty("line.separator");
		
		try {
			reader = new BufferedReader(new java.io.FileReader(file));
			String text;

			// repeat until all lines is read
			while ((text = reader.readLine()) != null) {
				contents.append(text).append(newLine);
			}
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}

		return contents.toString();
	}
}
