package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IConstructor;
import net.sf.laja.parser.GrammarParser.IOutputclass;

public class Outputclass implements IOutputclass {
	private String className;
	private String variableName;
	private Constructor constructor;

	public String getClassName() {
		return className;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setClass(String c) {
		className = c;
	}

	public void setVar(String var) {
		variableName = var;
	}

	public void setConstructor(IConstructor iconstructor) {
		constructor = (Constructor) iconstructor;
	}

	public Constructor getConstructor() {
		return constructor;
	}
}
