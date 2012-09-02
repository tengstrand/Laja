package net.sf.laja.template.data;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IFloatData;
import net.sf.laja.context.Context;
import net.sf.laja.exception.NumberOverflowException;
import net.sf.laja.template.Evaluator;

public class FloatData implements IFloatData, Evaluator {
	private Double value;
	
	public FloatData() {
	}
	
	public void setNumber(String number) {
		try {
			value = new Double(number);
		} catch (NumberFormatException e) {
			throw new NumberOverflowException(number, java.lang.Double.MIN_VALUE, java.lang.Double.MAX_VALUE);
		}
	}
	
	public Object evaluate() {
		return value;
	}

	public boolean isLazy() {
		return false;
	}
	
	public void setAttribute(String attributeName, Context parentContext) {
		parentContext.set(attributeName, evaluate());
	}

	public String getDataType() {
		return "Double";
	}
	
	public void print(SyntaxPrinter printer) {
		printer.print(value.toString());
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
