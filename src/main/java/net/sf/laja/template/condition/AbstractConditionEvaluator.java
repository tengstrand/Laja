package net.sf.laja.template.condition;

public abstract class AbstractConditionEvaluator implements ConditionEvaluator {
	public abstract String getOperator();
	
	public int compareTo(Object left, Object right) {
		if (left == null || right == null) {
			throw new IllegalArgumentException("Cannot compare null values with operator " + getOperator() + ": " + left + ", " + right);
		}
		if (left instanceof Comparable && right instanceof Comparable) {
			if (left.getClass().getCanonicalName().equals(right.getClass().getCanonicalName())) {
				return ((Comparable)left).compareTo((Comparable)right);
			}
			// Allow comparition between String and Number
			if (left instanceof String && right instanceof Number) {
				left = new Double(((String)left));
			}
			// Allow comparition between String and Number
			if (right instanceof String && left instanceof Number) {
				right = new Double((String)right);
			}
			// Allow comparition between different Numbers, e.g: compare Short with Integer, Integer with Double...
			if (left instanceof Number && right instanceof Number) {
				double result = ((Number)left).doubleValue() - ((Number)right).doubleValue();
				return (int)Math.signum(result);
			}
			throw new IllegalArgumentException("Cannot perform the comparition: " + left.getClass().getCanonicalName() + " " + getOperator() + " " + right +
				". They are not of same type.");
		}
		throw new IllegalArgumentException("Cannot perform the comparition: " + left.getClass().getCanonicalName() + " " + getOperator() + " " + right +
				". Both types must implement the Comparable interface.");
	}
}
