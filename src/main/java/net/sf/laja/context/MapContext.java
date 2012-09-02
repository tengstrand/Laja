package net.sf.laja.context;

import java.util.HashMap;
import java.util.Map;

import net.sf.laja.TemplateTextWriter;
import net.sf.laja.exception.LajaException;
import net.sf.laja.template.Evaluator;
import net.sf.laja.template.Macro;
import net.sf.laja.template.Namespaces;
import net.sf.laja.template.data.AttributeRef;

public class MapContext extends Context {
	private String name;
	private Map<String, Object> map;
	private Map<String, Macro> macros;

	public MapContext(String name, Namespaces namespaces, TemplateTextWriter templateTextWriter) {
		this(name, namespaces, templateTextWriter, new HashMap<String, Object>());
	}

	public MapContext(String name, Namespaces namespaces, TemplateTextWriter templateTextWriter, Map<String, Object> map) {
		super(namespaces, templateTextWriter);
		this.name = name;
		this.map = map;
		macros = new HashMap<String, Macro>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Macro getMacro(String macroName) {
		return macros.get(macroName);
	}

	@Override
	public void addMacro(Macro macro) {
		macros.put(macro.getName(), macro);
	}

	@Override
	public boolean contains(String attributeName) {
		return map.containsKey(attributeName);
	}

	@Override
	public void set(String attributeName, Object value) {
		map.put(attributeName, value);
	}

	@Override
	public boolean isLazy(AttributeRef attributeRef) {
		if (attributeRef == null) {
			return false;
		}
		return attributeRef.isMacro(this);
	}

	@Override
	public Object evaluate(AttributeRef attributeRef) {
		if (attributeRef.isMethodRef()) {
			Context objectContext = new ObjectContext(getNamespaces(), getTemplateTextWriter(), map);
			return objectContext.evaluate(attributeRef);
		}

		String objectName = attributeRef.getVariableName();

		Object result = map.get(objectName);

		if (result instanceof Evaluator) {
			Evaluator evaluator = (Evaluator) result;
			result = evaluator.evaluate();
		}

		return result;
	}

	public Object evaluateMacro(AttributeRef attributeRef) {
		Macro macro = getMacro(attributeRef.getMethodName());

		if (macro == null) {
			throw new LajaException("Could not find macro '" + attributeRef.getMethodName() + "'");
		}

		getTemplateTextWriter().pushTextWriter();

		if (attributeRef.getMethodArguments() != null) {
			macro.populateDataArguments(attributeRef.getMethodArguments().getArguments());
		}

		Object result = null;

		if (macro.getBlock() != null) {
			if (macro.isFunction()) {
				if (macro.getBlock() == null) {
					throw new LajaException("Missing return statement for function '" + macro.getName() + "'");
				} else {
					result = macro.getBlock().generate();
					if (!macro.getBlock().hasReturnBeenExecuted()) {
						throw new LajaException("No value was returned from macro '" + macro.getName() + "'");
					}
					getTemplateTextWriter().popTextWriter();
					return result;
				}
			} else {
				macro.getBlock().generate();
				result = getTemplateTextWriter().popTextWriter();
			}
		}

		return result;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	@Override
	public String toString() {
		return "MapContext{macros=" + macros + ", map=" + map + "}";
	}
}
