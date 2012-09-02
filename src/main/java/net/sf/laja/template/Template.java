package net.sf.laja.template;

import groovy.lang.GroovyClassLoader;
import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IBlock;
import net.sf.laja.TemplateParser.INamespace;
import net.sf.laja.TemplateParser.ITemplate;
import net.sf.laja.context.Context;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.data.StringExp;

public class Template implements ITemplate, Generator, SyntaxPrintable {
	private Context context;
	private Block block;
	private Namespace namespace;
	private ImportedFiles importedFiles;
	private Namespaces namespaces;
	private TemplateTextWriter templateTextWriter;
	private Source source;
	private Classes classes;
	private GroovyClassLoader groovyClassLoader;
	
	public Template(ImportedFiles importedFiles, Namespaces namespaces, TemplateTextWriter templateTextWriter,
			Source source, Classes classes, GroovyClassLoader groovyClassLoader) {
		this.importedFiles = importedFiles;
		this.namespaces = namespaces;
		this.templateTextWriter = templateTextWriter;
		this.source = source;
		this.classes = classes;
		this.groovyClassLoader = groovyClassLoader;
	}

	public void setNamespace(INamespace inamespace) {
		namespace = (Namespace)inamespace;
		setNamespace(namespace);
	}

	public void setDefaultNamespace() {
		namespace = new Namespace(namespaces);
		namespace.setName(Namespace.DEFAULT_NAMESPACE);
		
		setNamespace(namespace);
	}
	
	private void setNamespace(Namespace namespace) {
		context = namespaces.getNamespaceContextCreateIfNotExists(namespace.getName());
	}
	
	public void setBlock(IBlock iblock) {
		this.block = (Block)iblock;
	}

	public void insertSystemImportsAsFirstStatement(String systemImportsFile) {
		Importcmd systemImports = new Importcmd(importedFiles, templateTextWriter, source, namespaces, classes, context, groovyClassLoader);
		StringExp filename = new StringExp();
		filename.addText(systemImportsFile);
		systemImports.setFilename(filename);
		block.insertFirst(systemImports);
	}
	
	public String getNamespaceName() {
		return namespace.getName();
	}
	
	public Context getContext() {
		return context;
	}
	
	/**
	 * The following steps is performed:
	 *   - The process is started with parsing a template file resulting in
	 *     an instance of Template that is populated via the methods
	 *     addCommand(), addStringref(), addTemplatemacroref and addText() by the TemplateParser.
	 *     When we have a populated instance of Template, then the
	 *     method generate() performs the code generation.
	 *   - If a #write command is encountered, a file is opened for writing
	 *     and all content within this command is written to this file.
	 *   - All other content is written to opened files.
	 */
	public Object generate() {
		block.generate();
		return null;
	}

	public void print(SyntaxPrinter printer) {
		namespace.print(printer);
		block.print(printer);
	}
	
	@Override
	public String toString() {
		return "Template{context=" + context + ", block=" + block + "}";
	}
}
