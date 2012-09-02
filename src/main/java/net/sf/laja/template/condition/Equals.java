package net.sf.laja.template.condition;

public class Equals implements ConditionEvaluator {

	@Override
	public boolean compare(Object left, Object right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.getClass().getCanonicalName().equals(right.getClass().getCanonicalName())) {
			// Ensure the two instances are of the exact same type.
			return left.equals(right);
		}
		
		return left.toString().equals(right.toString());
	}
}
