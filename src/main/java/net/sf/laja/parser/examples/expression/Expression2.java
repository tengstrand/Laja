package net.sf.laja.parser.examples.expression;

import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression1;
import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression2;

public class Expression2 implements IExpression2, Calculator {

	private boolean expo = false;
	private double result = 0;

	@Override
	public double calculate() {
		return result;
	}
	
	@Override
	public void setExpression1(IExpression1 exp1) {
		double val = ((Calculator)exp1).calculate();

		if (expo) {
			result = Math.pow(result, val);
		} else {
			result = val;
		}
	}

	@Override
	public void setExpo() {
		expo = true;
	}
}
