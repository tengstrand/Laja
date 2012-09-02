package net.sf.laja.template.data;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.INullData;
import net.sf.laja.context.Context;
import net.sf.laja.template.Evaluator;

public class NullData implements INullData, Evaluator {

	public Object evaluate() {
		return null;
	}
	
	public boolean isLazy() {
		return false;
	}

	public String getDataType() {
		return "null";
	}

	public void setAttribute(String attributeName, Context parentContext) {
		parentContext.set(attributeName, null);
	}
	
	public void print(SyntaxPrinter printer) {
		printer.print("null");
	}
	
	public String toString() {
		return "null";
	}
}
