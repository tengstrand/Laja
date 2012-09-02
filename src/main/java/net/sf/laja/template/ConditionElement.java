package net.sf.laja.template;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IBooleanData;
import net.sf.laja.TemplateParser.IComparition;
import net.sf.laja.TemplateParser.IConditionElement;
import net.sf.laja.TemplateParser.IReference;

public class ConditionElement implements IConditionElement, BooleanEvaluator {
	private boolean not;
	private BooleanEvaluator booleanEvaluator;

	public void setNot() {
		not = true;
	}
	
	public void setComparition(IComparition icomparition) {
		booleanEvaluator = (BooleanEvaluator)icomparition;
	}
	
	public void setBoolean(IBooleanData ibooleanCondition) {
		booleanEvaluator = (BooleanEvaluator)ibooleanCondition;
	}

	public void setReference(IReference ireference) {
		booleanEvaluator = (BooleanEvaluator)ireference;
	}
	
	/**
	 * Performs a condition, e.g:
	 *   !true
	 *   true
	 *   flag
	 *   a == 10
	 *   a > 10
	 *   a <= 20
	 *
	 * @return true if the condition was true, otherwise false
	 */
	public boolean evaluateBoolean() {
		return booleanEvaluator.evaluateBoolean() != not;
	}

	public void print(SyntaxPrinter printer) {
		if (not) {
			printer.print("!");
		}
		booleanEvaluator.print(printer);
	}
	
	@Override
	public String toString() {
		return "Condition{booleanEvaluator=" + booleanEvaluator + "}";
	}
}
