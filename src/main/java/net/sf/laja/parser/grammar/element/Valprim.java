package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IEnd;
import net.sf.laja.parser.GrammarParser.IComplete;
import net.sf.laja.parser.GrammarParser.IInteger;
import net.sf.laja.parser.GrammarParser.IRange;
import net.sf.laja.parser.GrammarParser.IReference;
import net.sf.laja.parser.GrammarParser.IStr;
import net.sf.laja.parser.GrammarParser.IValprim;
import net.sf.laja.parser.GrammarParser.IValx;
import net.sf.laja.parser.GrammarParser.IVariable;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Valprim implements IValprim, GrammarElement {
	private boolean not;
	private boolean repeat;
	private String refname;
	private Repeats repeats;
	private GrammarElement element;

	private Valpar valpar;
	
	@Override
	public void setNot() {
		not = true;
	}

	@Override
	public void setRange(IRange r) {
		element = (GrammarElement) r;
	}

	@Override
	public void setInteger(IInteger i) {
		element = (GrammarElement) i;
	}

	@Override
	public void setStr(IStr s) {
		element = (GrammarElement) s;
	}

	@Override
	public void setReference(IReference reference) {
		element = (GrammarElement) reference;
	}

	@Override
	public void setVariable(IVariable variable) {
		element = (GrammarElement) variable;
	}

	@Override
	public void setComplete(IComplete complete) {
		element = (GrammarElement)complete;
	}
	
	@Override
	public void setEnd(IEnd end) {
		element = (GrammarElement) end;
	}

	@Override
	public void setValx(IValx ivalx) {
		Valx valx = (Valx)ivalx;

		// If more attributes are set, also update method createValpar!
		repeat = valx.isRepeat();
		repeats = valx.getRepeats();
		if (repeat && valx.getVarName() != null) {
			refname = valx.getVarName();
		} else {
			if (valx.getVarName() != null) {
				((Refname)element).setRefname(valx.getVarName());
			}
		}
		if (valx.getRepeatName() != null) {
			replaceValprimWithValpar(valx);
			return;
		}
	}

	/**
	 * Converts statements (e.g):
	 *   a:x#3:y to (a:x#3):y
	 *   a:x+:y  to (a:x+):y
	 *   
	 * Yes, this is a little bit ugly solution, but it is the most stable solution right now!
	 * It adds dependencies to the instance variables of Valprim and also to the grammar.
	 */
	private void replaceValprimWithValpar(Valx valx) {
		Val val = new Val();
		Valstmt valstmt = new Valstmt();
		Valor valor = new Valor();
		Valprim valprim = new Valprim();
		valpar = new Valpar();

		Valx valparValx = new Valx();
		valparValx.setVarname(valx.getRepeatName());
		valx.setRepeatName(null);

		if (not) {
			valprim.setNot();
			valprim.repeat = repeat;
			valprim.repeats = repeats;
			valprim.refname = refname;
		}
		valprim.element = element;
		valprim.setValx(valx);
		
		valor.addValprim(valprim);
		valstmt.addValor(valor);
		val.setValstmt(valstmt);
		
		valpar.setVal(val);
		valpar.setValx(valparValx);
	}
	
	@Override
	public boolean isElementList() {
		return element.isElementList();
	}

	@Override
	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		if (valpar != null) {
			return valpar.decoratable(phase, not, cs, output, var1, var2, var2b, data);
		}
		if (not && this.not) {
			return false;
		}
		if (repeat) {
			return true;
		}

		return element.decoratable(phase, not, cs, output, var1, var2, var2b, data);
	}

	@Override
	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		if (valpar != null) {
			valpar.generate(phase, baseDecl, genDecl, genStat, not, cs, name, var1, var2, var2b, data, statementList);
			return;
		}
		if (!repeat) {
			if (this.not) {
				not = this.not;
			}
			element.generate(phase, baseDecl, genDecl, genStat, not, cs, name, var1, var2, var2b, data, statementList);
		} else {
			if (genDecl) {
				String output = data.getOutput(phase, var1, var2, var2b, null, not);
				if (statementList != null) {
					NewStatement newStatement = new NewStatement("Repeat", name);
					newStatement.setData(not, cs, output, repeats);
					statementList.add(new Statement(phase, baseDecl, "Repeat", name, newStatement));
				}
			}
			if (genStat) {
				AddStatement addStatement = element.getStatement(phase, name, this.not, null, var1, refname, refname, data);
				if (statementList != null) {
					statementList.add(new Statement(phase, false, name, addStatement));
				}
			}
		}
	}

	@Override
	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		if (valpar != null) {
			return valpar.getStatement(phase, name, not, cs, var1, var2, var2b, data);
		}
		if (repeat) {
			return null;
		}
		if (this.not) {
			not = this.not;
		}
		if (refname != null) {
			var2 = refname;
		}
		return element.getStatement(phase, name, not, cs, var1, var2, var2b, data);
	}
}
