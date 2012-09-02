package net.sf.laja.template.condition;

import java.util.HashMap;
import java.util.Map;
import static net.sf.laja.template.condition.OperatorType.*;

public class Conditions {
	private static Map<OperatorType,ConditionEvaluator> evaluators = new HashMap<OperatorType,ConditionEvaluator>();
	
	static {
		evaluators.put(EQUALS, new Equals());
		evaluators.put(NOT_EQUALS, new NotEquals());
		evaluators.put(LESS_THAN, new LessThan());
		evaluators.put(GREATER_THAN, new GreaterThan());
		evaluators.put(GREATER_OR_EQUAL, new GreaterOrEqual());
		evaluators.put(LESS_OR_EQUAL, new LessOrEqual());
	}
	
	public static ConditionEvaluator getEvaluator(OperatorType type) {
		ConditionEvaluator evaluator = evaluators.get(type);
		
		if (evaluator == null) {
			throw new RuntimeException("The operator " + type + " is not implemented!");
		}

		return evaluator;
	}
}
