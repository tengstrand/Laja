package net.sf.laja.parser.grammar.element;

import net.sf.laja.parser.GrammarParser.IVal;
import net.sf.laja.parser.GrammarParser.IValpar;
import net.sf.laja.parser.GrammarParser.IValx;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.template.AddStatement;
import net.sf.laja.parser.template.NewStatement;
import net.sf.laja.parser.template.RefStatement;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class Valpar implements IValpar, GrammarElement {
	private boolean not;
	private boolean repeat;
	private Repeats repeats;
	private Boolean cs;
	private GrammarElement element;
	private String varname;

	@Override
	public void setNot() {
		not = true;
	}

	@Override
	public void setCs() {
		cs = true;
	}

	@Override
	public void setCi() {
		cs = false;
	}

	@Override
	public void setVal(IVal ival) {
		element = (GrammarElement) ival;
	}

	@Override
	public void setValx(IValx ivalx) {
		Valx valx = (Valx)ivalx;
		repeat = valx.isRepeat();
		repeats = valx.getRepeats();
		varname = valx.getVarName();
	}

	@Override
	public boolean isElementList() {
		return !repeat && element.isElementList();
	}

	@Override
	public boolean decoratable(int phase, boolean not, Boolean cs, String output, String var1, String var2, String var2b, GrammarData data) {
		if (repeat) {
			return data.decoratable(phase, var1, var2, var2b, not, output);
		}
		return element.decoratable(phase, not, cs, output, var1, var2, var2b, data);
	}

	@Override
	public void generate(int phase, boolean baseDecl, boolean genDecl, boolean genStat, boolean not, Boolean cs, String name, String var1, String var2, String var2b, GrammarData data, StatementList statementList) {
		if (this.cs != null) {
			cs = this.cs;
		}
		if (!repeat) {
			if (varname != null) {
				var2 = varname;
			}
			boolean not1, not2;

			if (not) {
				not1 = not;
				not2 = this.not;
			} else {
				not1 = this.not;
				not2 = not;
			}
			String output = data.getOutput(phase, var1, var2, var2, null, not1);
			boolean decoratable = decoratable(phase, not1, cs, output, var1, var2, var2b, data);

			if (decoratable) {
				if (not1) {
					not2 = true;
				}
				element.generate(phase, baseDecl, genDecl, genStat, not2, cs, name, var1, var2, var2b, data, statementList);
			} else {
				if (genDecl) {
					output = data.getOutput(phase, var1, var2, var2b, null, not1);
					if (statementList != null) {
						NewStatement newStatement = new NewStatement("ElementList", name);
						newStatement.setData(not1, cs, output);
						statementList.add(new Statement(phase, baseDecl, "ElementList", name, newStatement));
					}
				}
				if (genStat) {
					AddStatement addStatement = element.getStatement(phase, name, not2, null, var1, null, null, data);
					if (addStatement != null) {
						if (statementList != null) {
							statementList.add(new Statement(phase, false, name, addStatement));
						}
					} else {
						String elementName = data.addNewVarname(name);
						element.generate(phase, false, true, true, not2, null, elementName, var1, null, null, data, statementList);
						if (statementList != null) {
							statementList.add(new Statement(phase, false, name, new AddStatement(elementName, new RefStatement(elementName))));
						}
					}
				}
			}
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
				String output = data.getOutput(phase, var1, var2, varname, null, this.not);
				boolean decoratable = element.decoratable(phase, this.not, null, output, var1, varname, var2b, data);

				AddStatement addStatement = element.getStatement(phase, name, this.not, null, var1, varname, "", data);

				if (decoratable && addStatement != null) {
					if (statementList != null) {
						statementList.add(new Statement(phase, false, name, addStatement));
					}
				} else if (decoratable && element.isElementList()) {
					element.generate(phase, false, false, true, this.not, null, name, var1, varname, "", data, statementList);
				} else {
					String newName = data.addNewVarname(name);
					output = data.getOutput(phase, var1, varname, "", null, this.not);
					element.generate(phase, false, true, true, false, null, newName, var1, null, "", data, statementList);
					if (statementList != null) {
						RefStatement refStatement = new RefStatement(newName);
						refStatement.setData(this.not, cs, output);
						statementList.add(new Statement(phase, false, name, new AddStatement(newName, refStatement)));
					}
				}
			}
		}
	}

	@Override
	public AddStatement getStatement(int phase, String name, boolean not, Boolean cs, String var1, String var2, String var2b, GrammarData data) {
		if (repeat) {
			return null;
		}
		if (this.not) {
			not = true;
		}
		if (varname != null) {
			var2 = varname;
		}
		if (this.cs != null) {
			cs = this.cs;
		}
		return element.getStatement(phase, name, not, cs, var1, var2, var2b, data);
	}
}
