package net.sf.laja.launch;

import groovy.lang.GroovyClassLoader;

import java.io.File;

import net.sf.laja.Laja;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.template.Classes;
import net.sf.laja.template.Namespaces;
import net.sf.laja.template.Template;

/**
 * Settings used when launching Laja.
 */
public class Settings {
	private static final String LAJA_HOME = "LAJA_HOME";
	public static final String DEFULT_TEMPLATE_FILE = "generate.laja";
	
	private Classes classes;
	private Namespaces namespaces;
	private TemplateTextWriter templateTextWriter;
	private GroovyClassLoader groovyClassLoader;
	
	private String systemImportsFilename;
	
	public Settings() {
		classes = new Classes();
		templateTextWriter = new TemplateTextWriter();
		namespaces = new Namespaces(templateTextWriter);
		groovyClassLoader = new GroovyClassLoader(getClass().getClassLoader());
		systemImportsFilename = getLajaHome() + File.separator + "template/system-imports.laja";
	}

	private String getLajaHome() {
		String lajaHome = System.getenv(LAJA_HOME);
		
		if (lajaHome == null) {
			throw new IllegalStateException("The environment variable LAJA_HOME must be set");
		}
		return lajaHome;
	}
	
	public String getSystemImportsFilename() {
		return systemImportsFilename;
	}
	
	public void setSystemImportsFilename(String filename) {
		systemImportsFilename = filename;
	}
	
	public Classes getClasses() {
		return classes;
	}
	
	public Namespaces getNamespaces() {
		return namespaces;
	}

	public TemplateTextWriter getTemplateTextWriter() {
		return templateTextWriter;
	}
	
	public void setValue(String attributeName, String value) {
		if (value != null && value.startsWith("'") && value.endsWith("'")) {
			value = "\"" + value.substring(1, value.length()-1) + "\"";
		}
		String statement = "#set (" + attributeName + "=" + value + ")";
		try {
			Template template = Laja.parseStatement(statement, templateTextWriter, namespaces, classes, groovyClassLoader);
			template.generate();
		} catch (RuntimeException e) {
			System.out.println("Could not set value: " + statement);
		}
	}
}
