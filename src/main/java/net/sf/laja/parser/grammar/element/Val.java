package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IVal;
import net.sf.laja.parser.GrammarParser.IValstmt;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.RefStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Val implements IVal, GrammarElement {
	private Valstmt valstmt;
	private Valstmt followedby;
	
	@Override
	public void setValstmt(IValstmt ivalstmt) {
		valstmt = (Valstmt)ivalstmt;
	}
	
	@Override
	public void setFollowedby(IValstmt ifollowedby) {
		followedby = (Valstmt)ifollowedby;
	}

	@Override
	public boolean isElementList() {
		if (followedby == null) {
			return valstmt.isElementList();
		} else {
			return false;
		}
	}

	@Override
	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		if (followedby == null) {
			return valstmt.decoratable(phase, not, cs, output, var1, var2, var2b, data);
		} else {
			return false;
		}
	}

	@Override
	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		if (followedby == null) {
			valstmt.generate(phase, baseDecl, genDecl, genStat, not, cs, name, var1, var2, var2b, data, statementList);
		} else {
			if (genDecl) {
				String output = data.getOutput(phase, var1, var2, var2b, null, not);
				if (statementList != null) {
					NewStatement newStatement = new NewStatement("FollowedBy", name);
					newStatement.setData(not, cs, output);
					statementList.add(new Statement(phase, baseDecl, "FollowedBy", name, newStatement));
				}
			}
			if (genStat) {
				generateStatement(valstmt, "setElement", phase, not, name, var1, data, statementList);
				generateStatement(followedby, "followedby", phase, not, name, var1, data, statementList);
			}
		}
	}

	// Duplicerad från Valand!!! (har ändrat pipeElement till element)
	private void generateStatement(GrammarElement element, String method, int phase, boolean not, String name, String var1, GrammarData data, StatementList statementList) {
		AddStatement addStatement = element.getStatement(phase, name, not, null, var1, null, null, data);
		if (addStatement != null) {
			addStatement.setMehtod(method);
			if (statementList != null) {
				statementList.add(new Statement(phase, false, name, addStatement));
			}
		} else {
			String elementName = data.addNewVarname(name);
			element.generate(phase, false, true, true, not, null, elementName, var1, null, null, data, statementList);
			if (statementList != null) {
				addStatement = new AddStatement(elementName, new RefStatement(elementName));
				addStatement.setMehtod(method);
				statementList.add(new Statement(phase, false, name, addStatement));
			}
		}
	}
	
	@Override
	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		if (followedby == null) {
			return valstmt.getStatement(phase, name, not, cs, var1, var2, var2b, data);
		} else {
			return null;
		}
	}
}
