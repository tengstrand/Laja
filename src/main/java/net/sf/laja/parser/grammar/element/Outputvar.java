package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IOutputvar;

public class Outputvar implements IOutputvar, Comparable<Outputvar> {
	private boolean isBoolean;
	private String variable;
	private String ref;
	private String method;
	private String className;

	@Override
	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public void setRef(String ref) {
		this.ref = ref;
	}

	@Override
	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public void setDatatypeBool() {
		isBoolean = true;
	}

	@Override
	public void setDatatypeString() {
		isBoolean = false;
	}
	
	public String getVariable() {
		return variable;
	}

	public String getMethod() {
		return method;
	}

	public String getRef() {
		return ref;
	}

	public String getClassname() {
		return variable.substring(0, 1).toUpperCase() + variable.substring(1) + "_" + method;
	}

	public String getClassVariableName() {
		return variable + "_" + method;
	}
	
	public boolean isBoolean() {
		return isBoolean;
	}

	@Override
	public int compareTo(Outputvar outputvar) {
		if (outputvar == null) {
			return -1;
		}
		return variable.compareTo(outputvar.getVariable());
	}
	
	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public boolean equals(Object o) {
		if (o == null) {
			throw new IllegalArgumentException();
		}
		return variable.equals(((Outputvar)o).getVariable());
	}

	public String toString() {
		String dt = isBoolean ? "boolean" : "String";
		return "$" + variable + " " + dt + " " + ref + "." + method + "()";
	}
}
