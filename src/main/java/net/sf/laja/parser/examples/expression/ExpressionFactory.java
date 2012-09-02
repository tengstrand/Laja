package net.sf.laja.parser.examples.expression;

import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression1;
import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression2;
import net.sf.laja.parser.examples.expression.ExpressionParser.IExpression3;
import net.sf.laja.parser.examples.expression.ExpressionParser.IExpressionFactory;
import net.sf.laja.parser.examples.expression.ExpressionParser.IOneArgumentFunction;
import net.sf.laja.parser.examples.expression.ExpressionParser.ITwoArgumentsFunction;

public class ExpressionFactory implements IExpressionFactory {
	private Expression expression;

	public Expression createExpression() {
		if (expression == null) {
			// Save the base element.
			return expression = new Expression();
		}
		return new Expression();
	}

	public Expression getExp() {
		return expression;
	}

	public IExpression1 createExpression1() {
		return new Expression1();
	}

	public IExpression2 createExpression2() {
		return new Expression2();
	}

	public IExpression3 createExpression3() {
		return new Expression3();
	}

	public IOneArgumentFunction createOneArgumentFunction() {
		return new OneArgumentFunction();
	}

	public ITwoArgumentsFunction createTwoArgumentsFunction() {
		return new TwoArgumentsFunction();
	}
}
