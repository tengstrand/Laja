package net.sf.laja.parser.examples.expression;

import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression;
import net.sf.laja.parser.examples.expression.ExpressionParser.ITwoArgumentsFunction;

public class TwoArgumentsFunction implements ITwoArgumentsFunction, Calculator {
	private Calculator calculator;
	private double argument1;
	private double argument2;

	@Override
	public double calculate() {
		return calculator.calculate();
	}

	@Override
	public void setArg1(IExpression iexpression) {
		argument1 = ((Calculator)iexpression).calculate();
	}

	@Override
	public void setArg2(IExpression iexpression) {
		argument2 = ((Calculator)iexpression).calculate();
	}

	@Override
	public void setFunctionAtan2() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.atan2(argument1, argument2);
			}
		};
	}

	@Override
	public void setFunctionMax() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.max(argument1, argument2);
			}
		};
	}

	@Override
	public void setFunctionMin() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.min(argument1, argument2);
			}
		};
	}

	@Override
	public void setFunctionPow() {
		calculator = new Calculator() {
			@Override
			public double calculate() {
				return Math.pow(argument1, argument2);
			}
		};
	}
}
