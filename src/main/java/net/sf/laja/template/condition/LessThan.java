package net.sf.laja.template.condition;

public class LessThan extends AbstractConditionEvaluator {

	@Override
	public String getOperator() {
		return OperatorType.LESS_THAN.name();
	}
	
	@Override
	public boolean compare(Object left, Object right) {
		return compareTo(left, right) == -1;
	}
}
