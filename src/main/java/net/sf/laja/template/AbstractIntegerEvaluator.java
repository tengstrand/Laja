package net.sf.laja.template;

import net.sf.laja.exception.NumberOverflowException;

public abstract class AbstractIntegerEvaluator implements Evaluator, IntegerEvaluator {

	@Override
	public int evaluateInteger() {
		Object result = evaluate();
		if (result instanceof Number) {
			Number number = (Number)result;
			return number.intValue();
		}
		String number = result.toString();
		try {
			return java.lang.Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new NumberOverflowException(number, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
	}
}
