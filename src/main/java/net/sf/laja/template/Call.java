package net.sf.laja.template;

import java.util.Map;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.ICall;
import net.sf.laja.TemplateParser.ICallReference;
import net.sf.laja.context.Context;
import net.sf.laja.exception.InterpretationException;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.data.Reference;

public class Call implements ICall, Generator {
	private int indexInSource;
	private Reference reference;
	private Source source;
	private Context context;
	private Namespaces namespaces;
	private TemplateTextWriter templateTextWriter;

	private String targetNamespace;
	private String targetVariable;
	
	public Call(Source source, Context context, Namespaces namespaces, TemplateTextWriter templateTextWriter) {
		this.source = source;
		this.context = context;
		this.namespaces = namespaces;
		this.templateTextWriter = templateTextWriter;
	}
	
	public void setBegin(Index begin) {
		indexInSource = begin.getStartIndex();
	}
	
	public void setReference(ICallReference icallreference) {
		this.reference = (Reference)icallreference;
	}

	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}

	public void setTargetVariable(String targetVariable) {
		this.targetVariable = targetVariable;
	}
	
	private boolean isInsertingIntoVariableOrNamespace() {
		return targetNamespace != null || targetVariable != null;
	}

	public Object generate() {
		if (!isInsertingIntoVariableOrNamespace()) {
			reference.generate();
			return null;
		}

		Object returnedValue = reference.evaluate();
		
		if (targetNamespace != null) {
			if (!namespaces.namespaceExists(targetNamespace)) {
				throw new InterpretationException(source, indexInSource, "Could not find namespace '" + targetNamespace + "'");
			}
			if (returnedValue instanceof Map) {
				Map returnedMap = (Map)returnedValue;
				Context targetContext = namespaces.getNamespaceContext(targetNamespace);
				
				for (Object key : returnedMap.keySet()) {
					targetContext.set(key.toString(), returnedMap.get(key));
				}
			} else {
				throw new InterpretationException(source, indexInSource, "Returned value must implement the interface 'java.util.Map'");
			}
		} else if (targetVariable != null) {
			context.set(targetVariable, returnedValue);
		} else {
			throw new IllegalStateException("We shold nevere get here!");
		}
		return null;
	}

//	private Object callMacro() {
//		RuntimeException macroException = null;
//		
//		Macro macro = null;
//		try {
//			macro = macroref.getMacro();
//		} catch (MacroNotFoundException e) {
//			macroException = e;
//		}
//		
//		if (macro != null) {
//			if (macroref.getMacro().isFunction()) {
//				return macroref.evaluate();
//			}
//			return macroref.generate();
//		}
//			
//		if (macroref.getNamespace() == null) {
//			throw macroException;
//		}
//		
//		// The macro could not be found. Try call methods on the java.util.Map
//		// instance in the given namespace, e.g:
//		//    $.putAll( {a: "a" })
//		MapContext mapContext = (MapContext)namespaces.getNamespaceContext(macroref.getNamespace());
//		if (mapContext == null) {
//			throw new InterpretationException(source, indexInSource, "Could not find namespace $" + macroref.getNamespace());
//		}
//		Context objectContext = new ObjectContext(namespaces, templateTextWriter, mapContext.getMap());
//
//		Attribute attribute = new Attribute();
//		attribute.setName(macroref.getName());
//		attribute.setArgs(macroref.getArgs());
//		
//		return objectContext.evaluate(Arrays.asList(attribute));
//	}
	
	public void print(SyntaxPrinter printer) {
//		printer.printWithTabs("#");
		printer.printlnWithTabs("#call ");
		
		
//		if (macroref != null) {
//			macroref.print(printer);
//		} else {
//			reference.print(printer);
//		}

//		reference.print(printer);
//		
//		if (targetNamespace != null) {
//			printer.print(" into $");
//			printer.print(targetNamespace);
//		}
//		if (targetVariable != null) {
//			printer.print(" into ");
//			printer.print(targetVariable);
//		}
//		printer.println();
	}
	
	@Override
	public String toString() {
//		return "Call{macroref=" + macroref + ", reference=" + reference + "}";
		return "Call{reference=" + reference + "}";
	}
}
