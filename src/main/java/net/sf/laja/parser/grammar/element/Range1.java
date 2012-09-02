package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser;

public class Range1 implements GrammarParser.IRange1 {
	private String integer;
	private Str str;

	public void setInteger(String i) {
		integer = i;
	}

	public void setStr(GrammarParser.IStr s) {
		str = (Str) s;
	}
	
	public String getString() {
		return str == null ? null : str.getStrval();
	}
	
	public java.lang.Integer getInteger() {
		return integer == null ? null : new java.lang.Integer(integer);
	}
	
	public String getStatement() {
		if (integer != null) {
			return integer;
		}
		return "\"" + str.getStrval() + "\"";
	}
}
