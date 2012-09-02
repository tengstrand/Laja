package net.sf.laja.template.data;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IAttributeMethodRef;
import net.sf.laja.TemplateParser.IAttributeRef;
import net.sf.laja.TemplateParser.IAttributeVariableRef;
import net.sf.laja.TemplateParser.ICallReference;
import net.sf.laja.TemplateParser.IFloatData;
import net.sf.laja.TemplateParser.IIntegerData;
import net.sf.laja.TemplateParser.INamespaceRef;
import net.sf.laja.TemplateParser.IReference;
import net.sf.laja.TemplateParser.IStringExp;
import net.sf.laja.context.Context;
import net.sf.laja.context.MapContext;
import net.sf.laja.exception.InterpretationException;
import net.sf.laja.exception.LajaException;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.AbstractIntegerEvaluator;
import net.sf.laja.template.BooleanEvaluator;
import net.sf.laja.template.Evaluator;
import net.sf.laja.template.Generator;
import net.sf.laja.template.Macro;
import net.sf.laja.template.Namespaces;

public class Reference extends AbstractIntegerEvaluator implements IReference, ICallReference, Generator, BooleanEvaluator {
	private static final String NULL = "NULL";

	private int indexInSource;
	private NamespaceRef namespaceRef;
	protected AttributeRef attributeRef;
	private AttributeRefs nextAttributeRefs = new AttributeRefs();

	private Evaluator primitive;
	private String primitiveName;
	private Source source;
	protected Context context;
	private TemplateTextWriter templateTextWriter;
	private Namespaces namespaces;

	public Reference(Source source, Context context, TemplateTextWriter templateTextWriter, Namespaces namespaces) {
		this.source = source;
		this.context = context;
		this.templateTextWriter = templateTextWriter;
		this.namespaces = namespaces;
	}

	public void setBegin(Index begin) {
		indexInSource = begin.getStartIndex();
	}

	public void setNamespaceRef(INamespaceRef inamespaceRef) {
		namespaceRef = (NamespaceRef) inamespaceRef;
	}

	public void setAttributeRef(IAttributeRef iattributeRef) {
		attributeRef = (AttributeRef) iattributeRef;
	}

	public void setAttributeRef(IAttributeMethodRef iattributeMethodRef) {
		attributeRef = (AttributeRef) iattributeMethodRef;
	}

	public void setAttributeRef(IAttributeVariableRef iattributeVariableRef) {
		attributeRef = (AttributeRef) iattributeVariableRef;
	}
	
	public void addNextAttributeRef(IAttributeRef inextAttributeRef) {
		nextAttributeRefs.add((AttributeRef) inextAttributeRef);
	}

	public void setFloatData(IFloatData ifloatData, String name) {
		primitive = (Evaluator) ifloatData;
		primitiveName = name;
	}

	public void setIntegerData(IIntegerData iintegerData, String name) {
		primitive = (Evaluator) iintegerData;
		primitiveName = name;
	}

	public void setStringExp(IStringExp istringExp, String name) {
		primitive = (Evaluator) istringExp;
		primitiveName = name;
	}

	public Object evaluate() {
		Object attribute = null;

		try {
			if (primitive != null) {
				attribute = primitive.evaluate();
			} else if (isNamespaceRef()) {
				String namespaceName = namespaceRef.getNamespaceName();
				MapContext namespaceContext = namespaces.getNamespaceContext(namespaceName);
				if (namespaceContext == null) {
					throw new InterpretationException(source, indexInSource, "Could not find namespace '" + namespaceName + "'");
				}
				attribute = namespaceContext.getMap();
			} else if (namespaceRef == null) {
				attribute = getResultFromCurrentOrDefaultNamespace();
			} else {
				attribute = getResultFromSpecifiedNamespace();
			}
		} catch (InterpretationException e) {
			throw e;
		} catch (Exception e) {
			throw new InterpretationException(source, indexInSource, e);
		}
		try {
			attribute = evaluateExceptionAndListIndex(attribute);
			return nextAttributeRefs.evaluateNextAttributes(getContext(), attribute);
		} catch (Exception e) {
			throw new InterpretationException(source, indexInSource, e);
		}
	}

	private Object evaluateExceptionAndListIndex(Object attribute) {
		if (attribute instanceof Exception) {
			throw new InterpretationException(source, indexInSource, (Exception) attribute);
		}
		if (attributeRef != null && attributeRef.hasListIndex()) {
			attribute = attributeRef.evaluateArrayOrList(attribute);
		}
		return attribute;
	}
	
	private Object getResultFromSpecifiedNamespace() {
		Context context = namespaceRef.getNamespaceContextCreateIfNotExists();
		return context.evaluate(attributeRef);
	}

	private Object getResultFromCurrentOrDefaultNamespace() {
		if (attributeRef.isMethodRef()) {
			Macro macro = context.getMacro(attributeRef.getMethodName());
			
			if (macro == null && !namespaces.isDefaultNamespace(context)) {
				return namespaces.getDefaultNamespace().evaluateMacro(attributeRef);
			}
			
			return context.evaluateMacro(attributeRef);
		}
		Object result = context.evaluate(attributeRef);

		if (result == null && !namespaces.isDefaultNamespace(context) && !context.contains(attributeRef.getName())) {
			// Try find the value in default namespace if not found in current namespace.
			result = namespaces.getDefaultNamespace().evaluate(attributeRef);
		}

		return result;
	}

	public AttributeRef getAttributeRef() {
		return attributeRef;
	}

	public AttributeRefs getAttributesRefs() {
		return nextAttributeRefs;
	}

	public Context getSpecifiedContext(Context parentContext) {
		if (namespaceRef != null && attributeRef != null) {
			return namespaceRef.getNamespaceContextCreateIfNotExists();
		}
		return parentContext;
	}

	public Context getContext() {
		if (namespaceRef == null) {
			return context;
		}
		return namespaces.getNamespaceContextCreateIfNotExists(namespaceRef.getNamespaceName());
	}

	public boolean isLazy() {
		if (primitive != null) {
			return false;
		}
		return getContext().isLazy(attributeRef);
	}

	public boolean evaluateBoolean() {
		return BooleanHelper.toBoolean(evaluate(), source, indexInSource);
	}

	public String getDataType() {
		return "Object";
	}

	public void setAttribute(String attributeName, Context parentContext) {
		parentContext.set(attributeName, evaluate());
	}

	public boolean isNamespaceRef() {
		return namespaceRef != null && attributeRef == null;
	}

	public boolean isMethodRef() {
		return attributeRef != null && attributeRef.isMethodRef();
	}

	public boolean hasAttributes() {
		return nextAttributeRefs.hasAttributes();
	}

	public String getNamespaceName() {
		return namespaceRef.getNamespaceName();
	}
	
	public String getVariableName() {
		return attributeRef.getVariableName();
	}

	public Object generate() {
		if (attributeRef != null && attributeRef.isMacro(getContext())) {
			generateMacro();
		} else if (attributeRef != null && attributeRef.isFunction(context)) {
			Object result = evaluateFunction();
			templateTextWriter.write(result == null ? NULL : result.toString());
		} else {
			Object result = evaluate();
			templateTextWriter.write(result == null ? NULL : result.toString());
		}
		
		return null;
	}
	
	protected Object generateMacro() {
		if (nextAttributeRefs.hasAttributes()) {
			throw new InterpretationException(source, indexInSource, "Accessing attributes or methods on macros not supported. Use #set or #function");
		}
		Macro macro = attributeRef.getMacro(getContext());

		if (macro == null) {
			throw new InterpretationException(source, indexInSource, "Could not find macro '" + attributeRef.getMethodName() + "'");
		}
		
		if (attributeRef.hasMethodArguments()) {
			macro.populateDataArguments(attributeRef.getMethodArguments().getArguments());
		}

		if (macro.getBlock() != null) {
			macro.getBlock().generate();
		}
		return null;
	}

	protected Object evaluateFunction() {
		Macro macro = attributeRef.getMacro(getContext());

		if (macro == null) {
			throw new InterpretationException(source, indexInSource, "Could not find macro '" + attributeRef.getMethodName() + "'");
		}
		
		if (attributeRef.hasMethodArguments()) {
			macro.populateDataArguments(attributeRef.getMethodArguments().getArguments());
		}

		if (macro.getBlock() == null) {
			 throw new InterpretationException(source, indexInSource, "Missing return statement for function '" + macro.getName() + "'");
		}
		Object attribute = macro.getBlock().generate();
		
		if (!macro.getBlock().hasReturnBeenExecuted()) {
			throw new LajaException("No value was returned from macro '" + macro.getName() + "'");
		}

		attribute = evaluateExceptionAndListIndex(attribute);
		return nextAttributeRefs.evaluateNextAttributes(getContext(), attribute);
	}

	public void print(SyntaxPrinter printer) {
		// String dot = "";
		//		
		// if (namespace != null) {
		// printer.print("$" + namespace);
		// dot = ".";
		// }
		//
		// if (primitive != null) {
		// primitive.print(printer);
		// dot = ".";
		// }
		//		
		// for (Attribute attribute : attributes) {
		// printer.print(dot);
		// attribute.print(printer);
		// dot = ".";
		// }
	}

	public String toString() {
		return "Reference{namespaceRef=" + namespaceRef + ", attributeRef=" + attributeRef + ", primitiveName=" + primitiveName + ", nextAttributeRefs="
				+ nextAttributeRefs + "}";
	}
}
