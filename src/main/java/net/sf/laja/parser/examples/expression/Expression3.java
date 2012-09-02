package net.sf.laja.parser.examples.expression;

import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression2;
import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression3;

public class Expression3 implements IExpression3, Calculator {
	private OneArgumentCalculator calculator;
	private double result = 0;

	private interface OneArgumentCalculator {
		public double calculate(double operand);
	}
	
	@Override
	public double calculate() {
		return result;
	}
	
	@Override
	public void setExpression2(IExpression2 exp2) {
		result = calculator.calculate(((Calculator)exp2).calculate());
	}

	@Override
	public void setOperatorDiv() {
		calculator = new OneArgumentCalculator() {
			@Override
			public double calculate(double operand) {
				return result / operand;
			}
		};
	}

	@Override
	public void setOperatorMod() {
		calculator = new OneArgumentCalculator() {
			@Override
			public double calculate(double operand) {
				return result % operand;
			}
		};
	}

	@Override
	public void setOperatorMul() {
		calculator = new OneArgumentCalculator() {
			@Override
			public double calculate(double operand) {
				return result * operand;
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
