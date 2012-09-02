package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IComplete;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Complete implements IComplete, GrammarElement, Refname {
	private String refname;

	@Override
	public void setRefname(String refname) {
		this.refname = refname;
	}

	@Override
	public boolean isElementList() {
		return false;
	}

	@Override
	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		return data.decoratable(phase, var1, var2, var2b, not, output);
	}

	@Override
	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		if (refname != null) {
			var2 = refname;
		}
		if (genDecl) {
			String output = data.getOutput(phase, var1, var2, var2b, null, not);
			if (statementList != null) {
				NewStatement newStatement = new NewStatement("Complete", name);
				newStatement.setData(not, cs, output);
				statementList.add(new Statement(phase, baseDecl, "Complete", name, newStatement));
			}
		}
	}

	@Override
	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		if (refname != null) {
			var2 = refname;
		}
		String output = data.getOutput(phase, var1, var2, var2, null, not);
		NewStatement newStatement = new NewStatement("Complete", name);
		newStatement.setData(not, cs, output);
		return new AddStatement(name, newStatement);
	}
}
