package net.sf.laja.template.condition;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IComparition;
import net.sf.laja.TemplateParser.IData;
import net.sf.laja.TemplateParser.IOperator;
import net.sf.laja.context.Context;
import net.sf.laja.template.BooleanEvaluator;
import net.sf.laja.template.Evaluator;
import net.sf.laja.template.Operator;
import net.sf.laja.template.data.Data;

public class Comparition implements IComparition, BooleanEvaluator, Evaluator {
	private Operator operator;
	private Data leftOperand;
	private Data rightOperand;

	@Override
	public void setOperator(IOperator ioperator) {
		this.operator = (Operator)ioperator;
	}

	@Override
	public void setLeftOperand(IData ileftOperand) {
		this.leftOperand = (Data)ileftOperand;
	}

	@Override
	public void setRightOperand(IData irightOperand) {
		this.rightOperand = (Data)irightOperand;
	}

	@Override
	public boolean evaluateBoolean() {
		Object left = leftOperand.evaluate();
		Object right = rightOperand.evaluate();
		ConditionEvaluator evaluator = Conditions.getEvaluator(operator.getType());

		return evaluator.compare(left, right);
	}
	
	public String toString() {
		return "OperatorCondition[leftOperand=" + leftOperand + ", operator=" + operator + ", rightOperand=" + rightOperand + "]";
	}

	@Override
	public Object evaluate() {
		return evaluateBoolean();
	}

	@Override
	public String getDataType() {
		return "Comparision";
	}

	@Override
	public boolean isLazy() {
		return false;
	}

	@Override
	public void setAttribute(String attributeName, Context parentContext) {
		parentContext.set(attributeName, evaluateBoolean());
	}
	
	@Override
	public void print(SyntaxPrinter printer) {
		leftOperand.print(printer);
		printer.print(" ");
		operator.print(printer);
		printer.print(" ");
		rightOperand.print(printer);
	}
}
