package net.sf.laja.parser.examples.expression;

import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression;
import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression1;
import net.sf.laja.parser.examples.expression.ExpressionParser.IOneArgumentFunction;
import net.sf.laja.parser.examples.expression.ExpressionParser.ITwoArgumentsFunction;

public class Expression1 implements IExpression1, Calculator {
	double result;

	@Override
	public double calculate() {
		return result;
	}
	
	@Override
	public void setNumber(String number) {
		result = Double.parseDouble(number);
	}

	@Override
	public void setExpression(IExpression iexpression) {
		result = ((Calculator)iexpression).calculate();
	}

	@Override
	public void setRandom() {
		result = Math.random();
	}

	@Override
	public void setOneArgumentFunction(IOneArgumentFunction ifunction) {
		result = ((Calculator)ifunction).calculate();
	}

	@Override
	public void setTwoArgumentsFunction(ITwoArgumentsFunction ifunction) {
		result = ((Calculator)ifunction).calculate();
	}
}
