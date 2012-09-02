package net.sf.laja.template;

import java.io.File;
import java.io.IOException;

import net.sf.laja.TemplateParser.IReference;
import net.sf.laja.TemplateParser.IStringref;
import net.sf.laja.exception.InterpretationException;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.source.FileSource;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.data.Reference;

public class Stringref implements IStringref {
	private Reference reference;
	private String directory;
	
	private Source source;
	private int indexInSource;
	
	public Stringref(Source source) {
		this.source = source;
	}

	public void setBegin(Index begin) {
		indexInSource = begin.getStartIndex();
	}
	
	public void setCurrentdir() {
		if (!(source instanceof FileSource)) {
			throw new InterpretationException(source, indexInSource, "The source must be of type " + FileSource.class.getName() + " when using $dir");
		}
		directory = getDirectory(getFilenamePath(((FileSource)source).getName()));
	}

	public void setParentDir() {
		if (!(source instanceof FileSource)) {
			throw new InterpretationException(source, indexInSource, "The source must be of type " + FileSource.class.getName() + " when using $dir");
		}
		directory = getParentDirectory(((FileSource)source).getName());
	}
	
	public void setReference(IReference ireference) {
		reference = (Reference)ireference;
	}

	public String getDirectory() {
		return directory;
	}
	
	public Reference getReference() {
		return reference;
	}

	private String getDirectory(String filename) {
		for (int i=filename.length()-1; i>=0; i--) {
			if (filename.charAt(i) == '\\' || filename.charAt(i) == '/') {
				return filename.substring(0, i);
			}
		}
		return filename;
	}

	private String getParentDirectory(String filename) {
		String path = null;
		try {
			String canonicalPath = (new File(filename)).getCanonicalPath();
			File currentDir = new File(canonicalPath).getParentFile();
			File parentDir = null;
			if (currentDir != null) {
				parentDir = currentDir.getParentFile();
			}
			if (parentDir != null) {
				path = parentDir.getCanonicalPath().replace('\\', '/');
			} else {
				throw new InterpretationException(source, indexInSource, "No parent directory exists: " + filename);
			}
		} catch (IOException e) {
			throw new InterpretationException(source, indexInSource, "Could not find path for parent directory of: " + filename);
		}
		return path;
	}
	
	private String getFilenamePath(String filename) {
		File directory = new File(filename);
		String filenamePath = "";
		try {
			filenamePath = directory.getCanonicalPath();
		} catch (IOException e) {
			throw new InterpretationException(source, indexInSource, "Could not find path for: " + filename);
		}
		
		return  filenamePath.replace('\\', '/');
	}

	@Override
	public String toString() {
		return "Stringref{reference=" + reference + "}";
	}
}
