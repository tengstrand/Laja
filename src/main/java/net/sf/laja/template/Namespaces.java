package net.sf.laja.template;

import static net.sf.laja.template.Namespace.DEFAULT_NAMESPACE;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.laja.TemplateTextWriter;
import net.sf.laja.context.Context;
import net.sf.laja.context.MapContext;
import net.sf.laja.exception.LajaException;

public class Namespaces {
	private TemplateTextWriter templateTextWriter;
	private Map<String,MapContext> namespaces;

	public Namespaces(TemplateTextWriter templateTextWriter) {
		this.templateTextWriter = templateTextWriter;
		namespaces = new HashMap<String,MapContext>();
		MapContext defaultContext = new MapContext(DEFAULT_NAMESPACE, this, templateTextWriter);
		namespaces.put(DEFAULT_NAMESPACE, defaultContext);
	}

	public Set<String> getNames() {
		return namespaces.keySet();
	}

	public MapContext getNamespaceContextCreateIfNotExists(String name) {
		if (getNamespaceContext(name) == null) {
			createNamespace(name);
		}
		return getNamespaceContext(name);
	}
	
	
	private MapContext createNamespace(String name) {
		MapContext context = new MapContext(name, this, templateTextWriter);
		namespaces.put(name, context);

		return context;
	}
	
	public boolean namespaceExists(String name) {
		return namespaces.containsKey(name);
	}
	
	public MapContext getNamespaceContext(String name) {
		return namespaces.get(name);
	}

	public MapContext getDefaultNamespace() {
		return namespaces.get(DEFAULT_NAMESPACE);
	}

	public boolean isDefaultNamespace(Context context) {
		return context == getDefaultNamespace();
	}
	
	@Override
	public String toString() {
		return "namespaces{namespaces=" + namespaces + "}";
	}
}
