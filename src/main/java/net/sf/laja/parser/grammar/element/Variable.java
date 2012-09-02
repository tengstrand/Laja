package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IVariable;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Variable implements IVariable, GrammarElement, Refname {
	private String name;
	private String refname;

	public void setName(String name) {
		this.name = name;
	}

	public void setRefname(String refname) {
		//TODO: Remove refname?
		this.refname = refname;
	}

	public boolean isElementList() {
		return false;
	}

	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		return false;
	}

	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		Outputvar ov = data.getOutputvar(this.name);

		if (ov != null) {
			String output = data.getOutput(phase, var1, var2, var2b, null, not);
			if (statementList != null) {
				NewStatement newStatement = new NewStatement("Variable", name);
				newStatement.setData(not, cs, output);
				statementList.add(new Statement(phase, baseDecl, "Variable", name, newStatement));
			}
		}
	}

	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		Outputvar ov = data.getOutputvar(this.name);
		if (ov != null) {
			String output = data.getOutput(phase, var1, var2, var2b, null, not);
			NewStatement newStatement = new NewStatement("Variable", name, ov.getClassVariableName());
			newStatement.setData(not, cs, output);
			return new AddStatement(name, newStatement);
		}
		return null;
	}
}
