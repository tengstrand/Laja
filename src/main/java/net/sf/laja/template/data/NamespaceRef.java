package net.sf.laja.template.data;

import net.sf.laja.TemplateParser.INamespaceRef;
import net.sf.laja.context.MapContext;
import net.sf.laja.template.Namespaces;

public class NamespaceRef implements INamespaceRef {
	private String namespaceName;
	private Namespaces namespaces;

	public NamespaceRef(Namespaces namespaces) {
		this.namespaces = namespaces;
	}

	public void setNamespace(String namespace) {
		this.namespaceName = namespace;
	}
	
	public String getNamespaceName() {
		return namespaceName;
	}

	public MapContext getNamespaceContextCreateIfNotExists() {
		return namespaces.getNamespaceContextCreateIfNotExists(namespaceName);
	}
	
	@Override
	public String toString() {
		return namespaceName;
	}
}
