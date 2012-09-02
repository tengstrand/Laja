package net.sf.laja.parser.grammar;

import net.sf.laja.parser.grammar.element.Outputvar;

public class GrammarData {
	private DefList defList;
	private OmList omList;
	private OutputvarSet ovSet;

	public GrammarData(DefList defList, OmList omList, OutputvarSet ovSet) {
		this.defList = defList;
		this.omList = omList;
		this.ovSet = ovSet;
	}

	public void addLocalVariable(String name, int row) {
		defList.addLocalVariable(name, row);
	}

	public String addNewVarname(String name) {
		return defList.addNewVarname(name);
	}

	public boolean decoratable(int phase, String var1, String var2, String var2b, boolean not, String output) {
		return omList.decoratable(phase, var1, var2, var2b, not, output);
	}

	public String getOutput(int phase, String var1, String var2, String var2b, String origVar, boolean not) {
		return omList.getOutput(phase, var1, var2, var2b, origVar);
	}
	
	public Outputvar getOutputvar(String var) {
		return ovSet.getOutputvar(var);
	}

	public boolean isRefContainsVar(String ref) {
		return ovSet.isReference(ref);
	}
}
