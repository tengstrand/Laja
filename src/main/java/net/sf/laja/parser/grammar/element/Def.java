package net.sf.laja.parser.grammar.element;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.parser.GrammarParser.IDef;
import net.sf.laja.parser.GrammarParser.IVal;

public class Def implements IDef {
	private String varName;
	private Val val = null;
	private List<String> statement = new ArrayList<String>();

	public void setVar(String var) {
		varName = var;
	}

	public void setVal(IVal ival, String s) {
		val = (Val) ival;

		while (true) {
			int idx = s.indexOf("\n");
			if (idx >= 0) {
				statement.add(s.substring(0, idx - 1).trim());
				s = s.substring(idx + 1);
			} else {
				statement.add(s.trim());
				break;
			}
		}
	}

	public String getVarName() {
		return varName;
	}

	public Val getVal() {
		return val;
	}

	public List<String> getStatement() {
		return statement;
	}
}
