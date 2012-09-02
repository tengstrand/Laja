package net.sf.laja.template.data;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IIntegerData;
import net.sf.laja.context.Context;
import net.sf.laja.exception.NumberOverflowException;
import net.sf.laja.template.Evaluator;

public class IntegerData implements IIntegerData, Evaluator {
	private Number number;

	public void setNumber(String number) {
		try {
			this.number = new java.lang.Integer(number);
		} catch (NumberFormatException e) {
			try {
				this.number = new java.lang.Long(number);
			} catch (NumberFormatException e2) {
				throw new NumberOverflowException(number, java.lang.Long.MIN_VALUE, java.lang.Long.MAX_VALUE);
			}
		}
	}

	public Object evaluate() {
		return number;
	}
	
	public boolean isLazy() {
		return false;
	}

	public void setAttribute(String attributeName, Context parentContext) {
		parentContext.set(attributeName, evaluate());
	}

	public String getDataType() {
		return "Integer";
	}
	
	public void print(SyntaxPrinter printer) {
		printer.print(number.toString());
	}
	
	@Override
	public String toString() {
		return number.toString();
	}
}
