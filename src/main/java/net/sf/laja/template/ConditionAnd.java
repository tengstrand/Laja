package net.sf.laja.template;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IConditionAnd;
import net.sf.laja.TemplateParser.IConditionBase;

public class ConditionAnd implements IConditionAnd, BooleanEvaluator, SyntaxPrintable {
	private List<ConditionBase> conditionBases = new ArrayList<ConditionBase>();

	public void addConditionBase(IConditionBase iconditionBase) {
		conditionBases.add((ConditionBase)iconditionBase);
	}

	public boolean evaluateBoolean() {
		for (ConditionBase conditionBase : conditionBases) {
			if (!conditionBase.evaluateBoolean()) {
				return false;
			}
		}
		return true;
	}

	public void print(SyntaxPrinter printer) {
		String and = "";
		
		for (ConditionBase conditionBase : conditionBases) {
			printer.print(and);
			conditionBase.print(printer);
			and = " && ";
		}
	}
}
