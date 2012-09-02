package net.sf.laja.template.condition;

public class NotEquals implements ConditionEvaluator {
	private Equals equals = new Equals();
	
	@Override
	public boolean compare(Object left, Object right) {
		return !equals.compare(left, right);
	}
}
