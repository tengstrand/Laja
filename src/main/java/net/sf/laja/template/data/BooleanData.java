package net.sf.laja.template.data;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IBooleanData;
import net.sf.laja.context.Context;
import net.sf.laja.template.BooleanEvaluator;
import net.sf.laja.template.Evaluator;

public class BooleanData implements IBooleanData, Evaluator, BooleanEvaluator {
	private Boolean value;

	public void setBoolean(String booleanData) {
		value = new Boolean(booleanData);
	}

	public Object evaluate() {
		return value;
	}

	public boolean isLazy() {
		return false;
	}
	
	public boolean evaluateBoolean() {
		return value;
	}
	
	public String getDataType() {
		return "Boolean";
	}

	public void setAttribute(String attributeName, Context parentContext) {
		parentContext.set(attributeName, value);
	}

	public void print(SyntaxPrinter printer) {
		printer.print(value.toString());
	}
	
	public String toString() {
		return "BooleanData[value=" + value + "]";
	}
}
