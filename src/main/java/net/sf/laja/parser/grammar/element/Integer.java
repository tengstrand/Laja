package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IInteger;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.ChrData;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Integer implements IInteger, GrammarElement, Refname {
	private String refname;
	private String intval;

	public void setInt(String ival) {
		this.intval = ival;
	}

	public void setRefname(String refname) {
		this.refname = refname;
	}

	public boolean isElementList() {
		return false;
	}

	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		return data.decoratable(phase, var1, var2, var2b, not, output);
	}

	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		if (refname != null) {
			var2 = refname;
		}
		if (genDecl) {
			String output = data.getOutput(phase, var1, var2, var2b, null, not);
			NewStatement newStatement = new NewStatement("Chr", name, new ChrData(intval));
			newStatement.setData(not, cs, output);
			if (statementList != null) {
				statementList.add(new Statement(phase, baseDecl, "Chr", name, newStatement));
			}
		}
	}

	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		if (refname != null) {
			var2 = refname;
		}
		String output = data.getOutput(phase, var1, var2, var2b, null, not);
		NewStatement newStatement = new NewStatement("Chr", name, new ChrData(intval));
		newStatement.setData(not, cs, output);
		return new AddStatement(String.valueOf(intval), newStatement);
	}
}
