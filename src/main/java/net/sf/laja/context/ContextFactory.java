package net.sf.laja.context;

import java.util.Map;

import net.sf.laja.TemplateTextWriter;
import net.sf.laja.template.Namespaces;
import net.sf.laja.template.data.AttributeRef;

public class ContextFactory {
	private Namespaces namespaces;
	private TemplateTextWriter templateTextWriter;
	
	public ContextFactory(Namespaces namespaces, TemplateTextWriter templateTextWriter) {
		this.namespaces = namespaces;
		this.templateTextWriter = templateTextWriter;
	}
	
	/**
	 * This is an adapter factory that creates Context objects.
	 * 
	 * @param attribute
	 * @return context
	 */
	public Context createContext(Object attribute, AttributeRef attributeRef) {
		if (attribute instanceof Context) {
			return (Context)attribute;
		}
		if (attribute instanceof Map) {
			return new MapContext(attributeRef.getName(), namespaces, templateTextWriter, (Map)attribute);
		}
		return new ObjectContext(namespaces, templateTextWriter, attribute);
	}
}
