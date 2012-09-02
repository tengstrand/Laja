package net.sf.laja.template;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.ICondition;
import net.sf.laja.TemplateParser.IConditionBase;
import net.sf.laja.TemplateParser.IConditionElement;

public class ConditionBase implements IConditionBase, BooleanEvaluator {
	private boolean paranthese;
	private BooleanEvaluator booleanEvaluator;

	public void setCondition(ICondition icondition) {
		paranthese = true;
		booleanEvaluator = (BooleanEvaluator)icondition;
	}

	public void setConditionElement(IConditionElement iconditionElement) {
		booleanEvaluator = (BooleanEvaluator)iconditionElement;
	}

	public boolean evaluateBoolean() {
		return booleanEvaluator.evaluateBoolean();
	}

	public void print(SyntaxPrinter printer) {
		if (paranthese) {
			printer.print("(");
			booleanEvaluator.print(printer);
			printer.print(")");
		} else {
			booleanEvaluator.print(printer);
		}
	}
}
