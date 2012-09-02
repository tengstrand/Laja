package net.sf.laja.template;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.INamespace;

public class Namespace implements INamespace, Generator {
	private String name;
	private Namespaces namespaces;
	
	public static final String NAMESPACE_PREFIX = "$";
	public static final String DEFAULT_NAMESPACE = "";

	public Namespace(Namespaces namespaces) {
		this.namespaces = namespaces;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static boolean isDefaultNamespace(String namespaceName) {
		return namespaceName.length() == 0;
	}

	public Object generate() {
		namespaces.getNamespaceContextCreateIfNotExists(name);
		return null;
	}
	
	public void print(SyntaxPrinter printer) {
		if (name.length() > 0) {
			printer.print("#namespace ");
			printer.println(name);
			printer.println();
		}
	}
	
	@Override
	public String toString() {
		return "Namespace{name=" + name + "}";
	}
}
