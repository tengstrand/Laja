package net.sf.laja.parser.grammar.element;

import java.util.ArrayList;
import java.util.Iterator;

import net.sf.laja.parser.GrammarParser.IMarker;
import net.sf.laja.parser.GrammarParser.IValand;
import net.sf.laja.parser.GrammarParser.IValopt;
import net.sf.laja.parser.GrammarParser.IValor;
import net.sf.laja.parser.GrammarParser.IValstmt;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.RefStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Valstmt implements IValstmt, GrammarElement {
	private ArrayList<GrammarElement> elementList = new ArrayList<GrammarElement>();

	@Override
	public void addValand(IValand ivaland) {
		elementList.add((GrammarElement)ivaland);
	}
	
	@Override
	public void addValor(IValor ivalor) {
		elementList.add((GrammarElement)ivalor);
	}

	@Override
	public void addValopt(IValopt ivalopt) {
		elementList.add((GrammarElement)ivalopt);
	}
	
	@Override
	public void addMarker(IMarker imarker) {
		elementList.add((GrammarElement)imarker);
	}

	@Override
	public boolean isElementList() {
		if (elementList.size() == 1) {
			GrammarElement element = elementList.iterator().next();
			return element.isElementList();
		}
		return true;
	}

	@Override
	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		if (elementList.size() == 1) {
			GrammarElement element = elementList.iterator().next();
			return element.decoratable(phase, not, cs, output, var1, var2, var2b, data);
		}
		return data.decoratable(phase, var1, var2, var2b, not, output);
	}

	@Override
	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		if (elementList.size() == 1) {
			GrammarElement element = elementList.iterator().next();
			element.generate(phase, baseDecl, genDecl, genStat, not, cs, name, var1, var2, var2b, data, statementList);
		} else {
			if (genDecl) {
				String output = data.getOutput(phase, var1, var2, var2b, null, not);
				if (statementList != null) {
					NewStatement newStatement = new NewStatement("ElementList", name);
					newStatement.setData(not, cs, output);
					statementList.add(new Statement(phase, baseDecl, "ElementList", name, newStatement));
				}
			}
			if (genStat) {
				for (Iterator i = elementList.iterator(); i.hasNext();) {
					GrammarElement grammarElement = (GrammarElement) i.next();
					AddStatement addStatement = grammarElement.getStatement(phase, name, false, null, var1, null, null, data);
					if (addStatement != null) {
						if (statementList != null) {
							statementList.add(new Statement(phase, false, name, addStatement));
						}
					} else {
						String elementName = data.addNewVarname(name);
						grammarElement.generate(phase, false, true, true, false, null, elementName, var1, null, null, data, statementList);
						if (statementList != null) {
							statementList.add(new Statement(phase, false, name, new AddStatement(elementName, new RefStatement(elementName))));
						}
					}
				}
			}
		}
	}

	@Override
	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		if (elementList.size() == 1) {
			GrammarElement element = elementList.iterator().next();
			return element.getStatement(phase, name, not, cs, var1, var2, var2b, data);
		}
		return null;
	}
}
