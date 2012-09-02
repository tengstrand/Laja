package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IVal;
import net.sf.laja.parser.GrammarParser.IValopt;
import net.sf.laja.parser.GrammarParser.IValx;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.RefStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Valopt implements IValopt, GrammarElement {
	private String varname;
	private Valpar valpar = new Valpar();

	public void setVal(IVal ival) {
		valpar.setVal(ival);
	}

	public void setValx(IValx ivalx) {
		Valx valx = (Valx) ivalx;
		varname = valx.getVarName();
		valx.setVarname(null);
		valpar.setValx(valx);
	}

	public boolean isElementList() {
		return false;
	}

	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		// Not possible to decorate Optional whith not.
		if (not) {
			return false;
		}
		return data.decoratable(phase, var1, var2, var2b, not, output);
	}

	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		if (varname != null) {
			var2 = varname;
		}
		if (genDecl) {
			String output = data.getOutput(phase, var1, var2, var2b, null, not);
			if (statementList != null) {
				NewStatement newStatement = new NewStatement("Optional", name);
				newStatement.setData(false, cs, output);
				statementList.add(new Statement(phase, baseDecl, "Optional", name, newStatement));
			}
		}
		if (genStat) {
			var2 = "";
			var2b = "";
			AddStatement addStatement = valpar.getStatement(phase, name, false, null, var1, var2, var2b, data);
			if (addStatement != null) {
				if (statementList != null) {
					statementList.add(new Statement(phase, false, name, addStatement));
				}
			} else {
				if (valpar.isElementList()) {
					valpar.generate(phase, false, false, true, false, null, name, var1, var2, var2b, data, statementList);
				} else {
					String elementName = data.addNewVarname(name);
					valpar.generate(phase, false, true, true, false, null, elementName, var1, null, null, data, statementList);
					if (statementList != null) {
						addStatement = new AddStatement(elementName, new RefStatement(elementName));
						statementList.add(new Statement(phase, false, name, addStatement));
					}
				}
			}
		}
	}

	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		return null;
	}

}
