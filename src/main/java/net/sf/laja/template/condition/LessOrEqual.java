package net.sf.laja.template.condition;

public class LessOrEqual extends AbstractConditionEvaluator {

	@Override
	public String getOperator() {
		return OperatorType.LESS_OR_EQUAL.name();
	}

	@Override
	public boolean compare(Object left, Object right) {
		return compareTo(left, right) <= 0;
	}
}
