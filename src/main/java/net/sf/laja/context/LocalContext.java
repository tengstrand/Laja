package net.sf.laja.context;

import net.sf.laja.TemplateTextWriter;
import net.sf.laja.template.Macro;
import net.sf.laja.template.Namespaces;
import net.sf.laja.template.data.AttributeRef;

public class LocalContext extends Context {
	private String name;
	private Context context;
	private Context localContext;

	public LocalContext(String name, Namespaces namespaces, TemplateTextWriter templateTextWriter, Context context) {
		super(namespaces, templateTextWriter);
		this.name = name;
		this.context = context;
		localContext = new MapContext(name, namespaces, templateTextWriter);
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public boolean contains(String attributeName) {
		return localContext.contains(attributeName) || context.contains(attributeName);
	}

	@Override
	public boolean isLazy(AttributeRef attributeRef) {
		if (localContext.contains(attributeRef.getName())) {
			return localContext.isLazy(attributeRef);
		}
		return context.isLazy(attributeRef);
	}

	public Object evaluateMacro(AttributeRef attributeRef) {
		return context.evaluateMacro(attributeRef);
	}
	
	@Override
	public Object evaluate(AttributeRef attributeRef) {
		if (attributeRef.isMethodRef()) {
			throw new RuntimeException("Reference to methods not supported");
		}
		if (localContext.contains(attributeRef.getVariableName())) {
			return localContext.evaluate(attributeRef);
		}
		return context.evaluate(attributeRef);
	}

	@Override
	public Macro getMacro(String macroName) {
		return context.getMacro(macroName);
	}

	@Override
	public void set(String attributeName, Object value) {
		localContext.set(attributeName, value);
	}

	@Override
	public void addMacro(Macro macro) {
		context.addMacro(macro);
	}
	
	public void setLocalVariables(Context localContext) {
		this.localContext = localContext;
	}

	@Override
	public String toString() {
		return "LocalContext{name=" + name + ", context=" + context + ", localContext=" + localContext + "}";
	}
}
