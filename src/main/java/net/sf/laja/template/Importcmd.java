package net.sf.laja.template;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

import net.sf.laja.FileReader;
import net.sf.laja.Laja;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IImportcmd;
import net.sf.laja.TemplateParser.IStringExp;
import net.sf.laja.context.Context;
import net.sf.laja.exception.InterpretationException;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.data.StringExp;

public class Importcmd implements IImportcmd, Generator {
	private int indexInSource;
	private boolean isText;
	private StringExp filename;
	private ImportedFiles importedFiles;
	private TemplateTextWriter templateTextWriter;
	private Source source;
	private Namespaces namespaces;
	private Classes classes;
	private Context context;

	private Template template;
	private GroovyClassLoader groovyClassLoader;
	private GroovyObject groovyObject;

	public static final String READERS = "readers";
	
	public Importcmd(ImportedFiles importedFiles, TemplateTextWriter templateTextWriter, Source source, Namespaces namespaces, Classes classes, Context context, GroovyClassLoader groovyClassLoader) {
		this.importedFiles = importedFiles;
		this.templateTextWriter = templateTextWriter;
		this.source = source;
		this.namespaces = namespaces;
		this.classes = classes;
		this.context = context;
		this.groovyClassLoader = groovyClassLoader;
	}
	
	public void setBegin(Index begin) {
		indexInSource = begin.getStartIndex();
	}
	
	public void setFilename(IStringExp ifilename) {
		filename = (StringExp)ifilename;
		importedFiles.addFile(filename);
	}

	public void setAsText() {
		isText = true;
	}
	
	public Object generate() {
		String filename = this.filename.evaluate();
		if (isText) {
			importTextFile(filename);
		} else {
			if (filename.endsWith(".groovy")) {
				importGroovyClass(filename);
			} else if (filename.endsWith(".laja")) {
				importTemplateFile(filename);
			} else {
				importTextFile(filename);
			}
		}
		return null;
	}

	private void importTextFile(String filename) {
		try {
			String result = new FileReader().readFile(filename);
			templateTextWriter.write(result);
		} catch (IOException e) {
			throw new InterpretationException(source, indexInSource, "Could not import file: " + filename + ". Error: " + e.getMessage());
		}
	}
	
	private void importGroovyClass(String filename) {
		if (groovyObject == null) {
			try {
				Class groovyClass = groovyClassLoader.parseClass(new File(filename));
				classes.addClass(groovyClass);
			} catch (Exception e) {
				throw new InterpretationException(source, indexInSource, "Could not import file: " + filename + ". Error: " + e.getMessage());
			}
		}
	}

	private void importTemplateFile(String filename) {
		if (template == null) {
			// Only import the file once.
			template = Laja.parseFile(filename, templateTextWriter, namespaces, classes, groovyClassLoader);
		}
		template.generate();
	}

	public void print(SyntaxPrinter printer) {
		printer.printWithTabs("#import ");
		filename.print(printer);
		printer.println();
	}
	
	@Override
	public String toString() {
		return "Importcmd{filename=" + filename + "}";
	}
}
