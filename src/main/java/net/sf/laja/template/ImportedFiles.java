package net.sf.laja.template;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.template.data.StringExp;

public class ImportedFiles {
	private List<StringExp> files = new ArrayList<StringExp>();

	public ImportedFiles() {
	}
	
	public ImportedFiles(StringExp filename) {
		addFile(filename);
	}
	
	public void addFile(StringExp filename) {
		files.add(filename);
	}
}
