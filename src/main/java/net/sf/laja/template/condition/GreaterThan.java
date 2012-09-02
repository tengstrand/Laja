package net.sf.laja.template.condition;

public class GreaterThan extends AbstractConditionEvaluator {
	
	@Override
	public String getOperator() {
		return OperatorType.GREATER_THAN.name();
	}
	
	@Override
	public boolean compare(Object left, Object right) {
		return compareTo(left, right) == 1;
	}
}
