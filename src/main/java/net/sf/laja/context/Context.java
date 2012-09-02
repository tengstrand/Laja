package net.sf.laja.context;

import java.util.List;

import net.sf.laja.TemplateTextWriter;
import net.sf.laja.template.Macro;
import net.sf.laja.template.Namespaces;
import net.sf.laja.template.data.AttributeRef;
import net.sf.laja.template.data.AttributeRefs;

public abstract class Context {
	abstract public String getName();
	abstract public boolean contains(String attributeName);
	abstract public void set(String attributeName, Object value);
	abstract public boolean isLazy(AttributeRef attributeRef);
	abstract public Object evaluate(AttributeRef attributeRef);
	abstract public Object evaluateMacro(AttributeRef attributeRef);
	abstract public Macro getMacro(String macroName);
	abstract public void addMacro(Macro macro);

	private Namespaces namespaces;
	private TemplateTextWriter templateTextWriter;
	private ContextFactory contextFactory;

	public Context(Namespaces namespaces, TemplateTextWriter templateTextWriter) {
		this.namespaces = namespaces;
		this.templateTextWriter = templateTextWriter;
		contextFactory = new ContextFactory(namespaces, templateTextWriter);
	}

	public Namespaces getNamespaces() {
		return namespaces;
	}

	public Context createContext(Object attribute, AttributeRef attributeRef) {
		return contextFactory.createContext(attribute, attributeRef);
	}
	
	public TemplateTextWriter getTemplateTextWriter() {
		return templateTextWriter;
	}
	
	public Object get(String attributeName) {
		// FIX!
//		Attribute attribute = new Attribute();
//		attribute.setName(attributeName);
//		return evaluate(Arrays.asList(attribute));
		return null;
	}
	
	public boolean isList(Object object) {
		return object != null && (object instanceof List || object.getClass().isArray());
	}

//	public Object evaluateNextAttribute(Object object, String objectName, AttributeRefs nextAttributeRefs) {
//		if (object == null || !nextAttributeRefs.hasAttributes()) {
//			return object;
//		}		
//		if (isList(object)) {
//			throw new RuntimeException("Lists not supported yet!");
////			return contextFactory.getContext(object, objectName, nextAttributeRefs).evaluate(nextAttributeRefs);
//		}
//		
////		throw new RuntimeException("Attributes not supported yet!");
////		return contextFactory.getContext(object, objectName, nextAttributeRefs).evaluate(attributes.subList(1, attributes.size()));
//		
//		Context context = contextFactory.getContext(object, objectName, nextAttributeRefs);
//		
//		return context.evaluateNextAttribute(object, objectName, nextAttributeRefs);
//	}
	
	
//	public boolean contains(Object object, String objectName, List<Attribute> attributes) {
//		if (isList(object)) {
//			return contextFactory.getContext(object, objectName, attributes).contains(attributes.get(0).getName());
//		}
//		if (object == null || attributes.size() <= 1) {
//			return object != null;
//		}
//		return contextFactory.getContext(object, objectName, attributes).contains(attributes.get(1).getName());
//	}
}
