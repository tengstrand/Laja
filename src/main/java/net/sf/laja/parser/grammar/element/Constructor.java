package net.sf.laja.parser.grammar.element;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.parser.GrammarParser.IClassvar;
import net.sf.laja.parser.GrammarParser.IConstructor;

public class Constructor implements IConstructor {
	public List<Classvar> classvarList = new ArrayList<Classvar>();

	public void addClassvar(IClassvar iclassvar) {
		classvarList.add((Classvar) iclassvar);
	}

	public List<Classvar> getClassvarList() {
		return classvarList;
	}
	
	public String toString() {
		String str = "[";
		String comma = "";
		for (Classvar classvar : classvarList) {
			str += comma + classvar.toString();
			comma = ", ";
		}
		return str + "]";
	}
}
