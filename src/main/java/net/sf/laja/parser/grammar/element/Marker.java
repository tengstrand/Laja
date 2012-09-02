package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IMarker;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Marker implements IMarker, GrammarElement {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isElementList() {
		return false;
	}

	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		return true;
	}

	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		if (genDecl) {
			String output = data.getOutput(phase, var1, this.name, var2b, null, not);
			// Only handle output, do not handle "not", "cs" and "length".
			if (statementList != null) {
				NewStatement newStatement = new NewStatement("Marker", name);
				newStatement.setOutput(output);
				statementList.add(new Statement(phase, baseDecl, "Marker", name, newStatement));
			}
		}
	}

	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		String output = data.getOutput(phase, var1, this.name, var2b, null, not);
		NewStatement newStatement = new NewStatement("Marker", name);
		newStatement.setData(not, cs, output);
		return new AddStatement(this.name, newStatement);
	}
}
