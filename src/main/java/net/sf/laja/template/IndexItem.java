package net.sf.laja.template;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IIndexItem;
import net.sf.laja.TemplateParser.IReference;
import net.sf.laja.exception.NumberOverflowException;

public class IndexItem implements IIndexItem, IntegerEvaluator {
	private String number;
	private IntegerEvaluator integerEvaluator;

	public void setNumber(final String number) {
		this.number = number;
		integerEvaluator = new IntegerEvaluator() {
			public int evaluateInteger() {
				try {
					return java.lang.Integer.parseInt(number);
				} catch (NumberFormatException e) {
					throw new NumberOverflowException(number, java.lang.Integer.MIN_VALUE, java.lang.Integer.MAX_VALUE);
				}
			}

			public void print(SyntaxPrinter printer) {
				printer.print(number);
			}
		};
	}

	public void setReference(IReference ireference) {
		integerEvaluator = (IntegerEvaluator)ireference;
	}

	public int evaluateInteger() {
		return integerEvaluator.evaluateInteger();
	}
	
	public String getNumber() {
		return number;
	}

	public void print(SyntaxPrinter printer) {
		integerEvaluator.print(printer);
	}
	
	@Override
	public String toString() {
		return number;
	}
}
