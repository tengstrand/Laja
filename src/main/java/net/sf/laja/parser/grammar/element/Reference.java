package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.grammar.Row;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.RefStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Reference implements GrammarParser.IReference, GrammarElement, Refname {
	private static final int PHASE2 = 2;
	
	private int row;
	private String refname;
	private String elementName;

	public Reference(Row row) {
		this.row = row.getRow();
	}

	public void setName(String name) {
		elementName = refname = name;
	}

	public void setRefname(String refname) {
		this.refname = refname;
	}

	public boolean isDecoratable(boolean not, boolean cs, boolean name, boolean repeat) {
		return false;
	}

	public boolean isElementList() {
		return false;
	}

	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		if (refname != null) {
			if (var2 == null || !var2.equals("*")) {
				String output2 = data.getOutput(PHASE2, var1, var2, var2b, elementName, not);
				String output3 = data.getOutput(PHASE2, var1, refname, var2b, elementName, not);
				if (output2.length() > 0 && output3.length() > 0) {
					return false;
				}
			}
			var2 = refname;
		}

		return data.decoratable(phase, var1, var2, var2b, not, output);
	}

	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		if (genDecl) {
			if (statementList != null) {
				NewStatement newStatement = new NewStatement("ElementList", name);
				statementList.add(new Statement(phase, baseDecl, "ElementList", name, newStatement));
			}
		}
		if (genStat) {
			String output = data.getOutput(phase, var1, var2, var2b, elementName, not);
			if (output.length() == 0) {
				output = data.getOutput(phase, var1, refname, var2b, elementName, not);
			}
			if (statementList != null) {
				RefStatement refStatement = new RefStatement(elementName);
				refStatement.setData(not, cs, output);
				AddStatement addStatement = new AddStatement(elementName, refStatement);
				statementList.add(new Statement(phase, false, name, addStatement));
			}
		}
	}

	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		String output = data.getOutput(phase, var1, var2, var2b, elementName, not);
		if (output.length() == 0) {
			output = data.getOutput(phase, var1, refname, var2b, elementName, not);
		}
		data.addLocalVariable(elementName, row);

		RefStatement refStatement = new RefStatement(elementName);

		refStatement.setData(not, cs, output);
		return new AddStatement(elementName, refStatement);
	}

	public String toString() {
		return elementName;
	}
}
