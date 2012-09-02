package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IClassvar;

public class Classvar implements IClassvar {
	private String className;
	private String varName;

	public void setClass(String c) {
		className = c;
	}

	public void setVar(String var) {
		varName = var;
	}

	public String getClassName() {
		return className;
	}

	public String getVarName() {
		return varName;
	}

	public String toString() {
		return "[className=" + className + ", varName=" + varName + "]";
	}
}
