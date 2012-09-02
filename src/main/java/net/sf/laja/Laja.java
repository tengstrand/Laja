package net.sf.laja;

import groovy.lang.GroovyClassLoader;
import net.sf.laja.TemplateParser.ITemplateFactory;
import net.sf.laja.TemplateParser.ITemplateFactoryFactory;
import net.sf.laja.exception.LajaException;
import net.sf.laja.parser.engine2.ParsingResult;
import net.sf.laja.parser.engine2.source.FileSource;
import net.sf.laja.parser.engine2.source.StringSource;
import net.sf.laja.template.Classes;
import net.sf.laja.template.Namespaces;
import net.sf.laja.template.Template;

public class Laja {
	
	public static Object evaluate(Namespaces namespaces, Classes classes, GroovyClassLoader groovyClassLoader, String statement) {
		throw new IllegalStateException("Not implemented yet!");
	}
	
	public static Template parseStatement(String statement, final TemplateTextWriter templateTextWriter, final Namespaces namespaces, final Classes classes, final GroovyClassLoader groovyClassLoader) {
		final StringSource sourceString = new StringSource("statement");
		
		TemplateParser parser = new TemplateParser(new ITemplateFactoryFactory() {
			public ITemplateFactory getFactory(int phase) {
				return new TemplateFactory(sourceString, templateTextWriter, namespaces, classes, groovyClassLoader);
			}
		});
		
		StringSource source = new StringSource(statement);
		ParsingResult result = parser.parse(source);

		if (!result.success()) {
			throw new LajaException("Could not parse statement \"" + statement + "\"");
		}

		TemplateFactory templateFactory = (TemplateFactory)parser.getFactory(); 
		return templateFactory.getBaseTemplate();
	}
	
	/**
	 * This is the main method for generating a template.
	 * Parses the template file and insert an #import "LAJA_HOME/template/system-imports.laja"
	 * as the first statement.
	 * 
	 * @param templateFilename the Laja template file to be loaded, parsed and executed.
	 * @param namespaces all namespaces
	 * @param classes alll classes loaded by Groovy.
	 * @param groovyClassLoader Groovy class loader
	 * @return the loaded and parsed template
	 */
 	public static Template parserFile(String systemImportsFilename, String templateFilename, Namespaces namespaces, TemplateTextWriter templateTextWriter, Classes classes, GroovyClassLoader groovyClassLoader) {
		Template template = parseFile(templateFilename, templateTextWriter, namespaces, classes, groovyClassLoader);
		template.insertSystemImportsAsFirstStatement(systemImportsFilename);
		
		return template;
	}

	public static Template parseFile(final String filename, final TemplateTextWriter templateTextWriter, final Namespaces namespaces, final Classes classes, final GroovyClassLoader groovyClassLoader) {
		final FileSource sourceFile = new FileSource(filename);
		
		TemplateParser parser = new TemplateParser(new ITemplateFactoryFactory() {
			public ITemplateFactory getFactory(int phase) {
				return new TemplateFactory(sourceFile, templateTextWriter, namespaces, classes, groovyClassLoader);
			}
		});

		ParsingResult result = parser.parseFile(filename);

		if (!result.success()) {
			throw new LajaException("Could not parse template  \"" + filename + "\"");
		}

		TemplateFactory templateFactory = (TemplateFactory)parser.getFactory(); 
		return templateFactory.getBaseTemplate();
	}
}
