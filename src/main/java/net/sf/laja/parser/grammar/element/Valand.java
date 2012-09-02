package net.sf.laja.parser.grammar.element;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.parser.GrammarParser.IValand;
import net.sf.laja.parser.GrammarParser.IValopt;
import net.sf.laja.parser.GrammarParser.IValor;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.RefStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Valand implements IValand, GrammarElement {
	private GrammarElement mainAnd;
	private List<GrammarElement> andElements = new ArrayList<GrammarElement>();

	@Override
	public void setMainAnd(IValor imainAnd) {
		mainAnd = (GrammarElement)imainAnd;
	}

	@Override
	public void addAndValopt(IValopt ivalopt) {
		andElements.add((GrammarElement)ivalopt);
	}

	@Override
	public void addAndValor(IValor ivalor) {
		andElements.add((GrammarElement)ivalor);
	}

	@Override
	public boolean isElementList() {
		return false;
	}
	
	@Override
	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		return false;
	}

	@Override
	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		String output = data.getOutput(phase, var1, var2, var2, null, not);
		if (genDecl) {
			output = data.getOutput(phase, var1, var2, var2b, null, not);
			if (statementList != null) {
				NewStatement newStatement = new NewStatement("AndList", name);
				newStatement.setData(not, cs, output);
				statementList.add(new Statement(phase, baseDecl, "AndList", name, newStatement));
			}
		}
		if (genStat) {
			generateStatement(mainAnd, "mainAnd", phase, not, name, var1, data, statementList);
			for (GrammarElement pipeTo : andElements) {
				generateStatement(pipeTo, "and", phase, not, name, var1, data, statementList);
			}
		}
	}

	private void generateStatement(GrammarElement pipeElement, String method, int phase, boolean not, String name, String var1, GrammarData data, StatementList statementList) {
		AddStatement addStatement = pipeElement.getStatement(phase, name, not, null, var1, null, null, data);
		if (addStatement != null) {
			addStatement.setMehtod(method);
			if (statementList != null) {
				statementList.add(new Statement(phase, false, name, addStatement));
			}
		} else {
			String elementName = data.addNewVarname(name);
			pipeElement.generate(phase, false, true, true, not, null, elementName, var1, null, null, data, statementList);
			if (statementList != null) {
				addStatement = new AddStatement(elementName, new RefStatement(elementName));
				addStatement.setMehtod(method);
				statementList.add(new Statement(phase, false, name, addStatement));
			}
		}
	}

	@Override
	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		return null;
	}
}
