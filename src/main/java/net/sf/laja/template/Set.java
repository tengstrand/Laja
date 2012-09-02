package net.sf.laja.template;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateTextWriter;
import net.sf.laja.TemplateParser.IComparition;
import net.sf.laja.TemplateParser.IData;
import net.sf.laja.TemplateParser.ILocal;
import net.sf.laja.TemplateParser.IReference;
import net.sf.laja.TemplateParser.ISet;
import net.sf.laja.context.Context;
import net.sf.laja.context.ContextFactory;
import net.sf.laja.exception.InterpretationException;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.condition.Comparition;
import net.sf.laja.template.data.AttributeRef;
import net.sf.laja.template.data.AttributeRefs;
import net.sf.laja.template.data.Data;
import net.sf.laja.template.data.Reference;

public class Set implements ISet, ILocal, Generator {
	private int indexInSource;
	private Macro macro;
	private Context context;
	private Source source;
	private Namespaces namespaces;
	private ContextFactory contextFactory;

	private Reference target;
	private Data data;
	
	public Set(Source source, Namespaces namespaces, TemplateTextWriter templateTextWriter, Macro macro, Context context) {
		this.macro = macro;
		this.context = context;
		this.source = source;
		this.namespaces = namespaces;
		this.contextFactory = new ContextFactory(namespaces, templateTextWriter);
	}

	public void setBegin(Index begin) {
		indexInSource = begin.getStartIndex();
	}
	
	public void setTarget(IReference itarget) {
		target = (Reference)itarget;
		setContextToMacroLocalContextIfVariableExistsInParamaterList();
	}

	private void setContextToMacroLocalContextIfVariableExistsInParamaterList() {
		AttributeRef attributeRef = target.getAttributeRef();
		
		if (attributeRef != null) {
			String variableToSet = attributeRef.getVariableName();
			
			if (macro != null && macro.getParameters().contains(variableToSet)) {
				context = macro.getLocalContext();
			} else if (target.isNamespaceRef()) {
				throw new RuntimeException("Setting namespaces not implemented.");
			}
		}
	}
	
	public void setData(IData idata) {
		data = (Data)idata;
	}

	public void setComparition(IComparition icomparition) {
		data = new Data();
		data.setComparision((Comparition)icomparition);
	}
	
	public Object generate() {
		if (target.isNamespaceRef()) {
			// e.g: #set ($x = $y)
			throw new InterpretationException(source, indexInSource, "Not possible to set namespace variable $" + target.getNamespaceName());
		}
		if (target.isMethodRef()) {
			// e.g: #set (a() = 123)
			throw new InterpretationException(source, indexInSource, "Not possible to set a method, function or macro");
		}
		if (!target.hasAttributes()) {
			// e.g: #set (x = "1") or #set ($n.x = "1")
			data.setAttribute(target.getVariableName(), target.getSpecifiedContext(context));
		} else {
			// e.g: #set (x.a = "1") or #set ($n.x.a = "1") or #set (a.b.c.d = 1)
			AttributeRefs targetAttributeRefs = target.getAttributesRefs();
			
			AttributeRef targetAttributeRef = targetAttributeRefs.getLastAttribute();
			String targetAttributeName = targetAttributeRef.getName();
			
			Object targetObject = target.getContext().evaluate(target.getAttributeRef());
			
			if (targetObject == null) {
				throw new InterpretationException(source, indexInSource, "Can not set value, the target was null '" + target.getAttributeRef().getName() + "'");
			}

			targetAttributeRefs = targetAttributeRefs.createAttributesSkipLast();
			
			if (targetAttributeRefs.hasAttributes()) {
				targetObject = targetAttributeRefs.evaluateNextAttributes(target.getContext(), targetObject);
			}
			
			Context targetContext = contextFactory.createContext(targetObject, targetAttributeRef);
			data.setAttribute(targetAttributeName, targetContext);
		}
		return null;
	}

	public void print(SyntaxPrinter printer) {
		printer.printWithTabs("#set (");
		target.print(printer);
		printer.print(" = ");
		data.print(printer);
		printer.println(")");
	}
	
	@Override
	public String toString() {
		return "Set{target=" + target + ", data=" + data + "}";
	}
}
