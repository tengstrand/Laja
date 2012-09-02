package net.sf.laja.parser.examples.expression;

import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression;
import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression3;

public class Expression implements IExpression, Calculator {
	private OneArgumentCalculator calculator;
	private double result = 0;

	public Expression() {
		setOperatorPlus();
	}
	
	@Override
	public double calculate() {
		return result;
	}
	
	@Override
	public void setExpression3(IExpression3 expression3) {
		result = calculator.calculate(((Calculator)expression3).calculate());
	}

	@Override
	public void setOperatorMinus() {
		calculator = new OneArgumentCalculator() {
			@Override
			public double calculate(double operand) {
				return result - operand;
			}
		};
	}

	@Override
	public void setOperatorPlus() {
		calculator = new OneArgumentCalculator() {
			@Override
			public double calculate(double operand) {
				return result + operand;
			}
		};
	}
}
