package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.RangeData;
import net.sf.laja.parser.template.RangeLimit;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Range implements GrammarParser.IRange, GrammarElement, Refname {
	private String refname;
	private Range1 range1;
	private Range1 range2;
	
	public void setRange1(GrammarParser.IRange1 r1) {
		if (range1 == null) {
			range1 = (Range1) r1;
		} else {
			range2 = (Range1) r1;
		}
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
			if (statementList != null) {
				RangeData rangeData = new RangeData(new RangeLimit(range1), new RangeLimit(range2));
				NewStatement newStatement = new NewStatement("Range", name, rangeData);
				newStatement.setData(not, cs, output);
				statementList.add(new Statement(phase, baseDecl, "Range", name, newStatement));
			}
		}
	}

	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		if (refname != null) {
			var2 = refname;
		}
		String output = data.getOutput(phase, var1, var2, var2b, null, not);
		RangeData rangeData = new RangeData(new RangeLimit(range1), new RangeLimit(range2));
		NewStatement newStatement = new NewStatement("Range", name, rangeData);
		newStatement.setData(not, cs, output);
		return new AddStatement(name, newStatement);
	}
}
