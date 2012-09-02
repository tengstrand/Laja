package net.sf.laja.template;

import static net.sf.laja.template.condition.OperatorType.EQUALS;
import static net.sf.laja.template.condition.OperatorType.GREATER_OR_EQUAL;
import static net.sf.laja.template.condition.OperatorType.GREATER_THAN;
import static net.sf.laja.template.condition.OperatorType.LESS_OR_EQUAL;
import static net.sf.laja.template.condition.OperatorType.LESS_THAN;
import static net.sf.laja.template.condition.OperatorType.NOT_EQUALS;
import net.sf.laja.SyntaxPrintable;
import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IOperator;
import net.sf.laja.template.condition.OperatorType;

public class Operator implements IOperator, SyntaxPrintable {
	private OperatorType type;

	public void setEquals() {
		type = EQUALS;
	}

	public void setNotEquals() {
		type = NOT_EQUALS;
	}

	public void setLessThan() {
		type = LESS_THAN;
	}

	public void setLessOrEqual() {
		type = LESS_OR_EQUAL;
	}
	
	public void setGreaterThan() {
		type = GREATER_THAN;
	}
	
	public void setGreaterOrEqual() {
		type = GREATER_OR_EQUAL;
	}

	public OperatorType getType() {
		return type;
	}

	public void print(SyntaxPrinter printer) {
		printer.print(type.name());
	}
	
	public String toString() {
		return "Operator{" + type + "}";
	}
}
