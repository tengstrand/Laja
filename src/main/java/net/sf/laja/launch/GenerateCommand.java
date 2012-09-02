package net.sf.laja.launch;

import groovy.lang.GroovyClassLoader;
import net.sf.laja.Laja;
import net.sf.laja.template.Template;

public class GenerateCommand {
	private String filename;
	private Settings settings;
	private GroovyClassLoader groovyClassLoader;
	
	GenerateCommand(Settings settings, String filename) throws InargumentException {
		this.settings = settings;
		groovyClassLoader = new GroovyClassLoader(getClass().getClassLoader());
		
		if (filename.startsWith("\"")) {
			if (filename.endsWith("\"")) {
				this.filename = addSuffixIfMissing(filename.substring(1, filename.length()-1));
				return;
			}
			throw new InargumentException("Illegal format in filename, must end with quotation mark: " + filename);
		}
		if (filename.endsWith("\"")) {
			throw new InargumentException("Illegal format in filename, must start with quotation mark: " + filename);
		}
		this.filename = addSuffixIfMissing(filename);
	}

	private String addSuffixIfMissing(String filename) {
		if (!filename.endsWith(".laja")) {
			return filename + ".laja";
		}
		return filename;
	}

	public Template parseTemplate(String systemImportsFilename) {
		System.out.println("Reading file \"" + filename + "\"");
		return Laja.parserFile(systemImportsFilename, filename, settings.getNamespaces(), settings.getTemplateTextWriter(), settings.getClasses(), groovyClassLoader);
	}
	
	@Override
	public boolean equals(Object obj) {
		return filename.equals(((GenerateCommand)obj).filename);
	}
}
