package net.sf.laja.template;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.ICondition;
import net.sf.laja.TemplateParser.IConditionAnd;

public class Condition implements ICondition, BooleanEvaluator {
	private List<ConditionAnd> conditionAnds = new ArrayList<ConditionAnd>();

	public void addConditionAnd(IConditionAnd iconditionAnd) {
		conditionAnds.add((ConditionAnd)iconditionAnd);
	}

	/**
	 * This is an OR-list, return true on the first true element!
	 */
	public boolean evaluateBoolean() {
		for (ConditionAnd conditionAnd : conditionAnds) {
			if (conditionAnd.evaluateBoolean()) {
				return true;
			}
		}
		return false;
	}

	public void print(SyntaxPrinter printer) {
		String or = "";
		for (ConditionAnd conditionAnd : conditionAnds) {
			printer.print(or);
			conditionAnd.print(printer);
			or = " || ";
		}
	}
}
