package net.sf.laja.parser.grammar;

import java.util.Set;
import java.util.TreeSet;

import net.sf.laja.parser.engine2.Writer;
import net.sf.laja.parser.grammar.element.Outputmethod;
import net.sf.laja.parser.grammar.element.Outputvar;

public class OutputvarSet {
	private TreeSet<Outputvar> outputvarSet = new TreeSet<Outputvar>();
	private Writer writer;

	public OutputvarSet(Writer writer) {
		this.writer = writer;
	}

	public boolean add(Outputvar outputvar) {
		return outputvarSet.add(outputvar);
	}

	public Set<Outputvar> getSet() {
		return outputvarSet;
	}

	public Outputvar getOutputvar(String var) {
		for (Outputvar outputvar : outputvarSet) {
			if (outputvar.getVariable().equals(var)) {
				return outputvar;
			}
		}
		writer.writeln("Error. Could not find a definition for variable $" + var);
		return null;
	}

	/**
	 * Kolla om referensen finns.
	 * 
	 * @param ref
	 * @return true if is a reference
	 */
	public boolean isReference(String ref) {
		for (Outputvar outputvar : outputvarSet) {
			if (outputvar.getRef().equals(ref)) {
				return true;
			}
		}
		return false;
	}

	public boolean isArgClassVariableDef(Outputmethod om) {
		for (Outputvar ov : outputvarSet) {
			if (ov.getClassName() != null && 
                (ov.getClassName().equals(om.getArgClass()) || ov.getClassName().equals(om.getClassRef()))) {
				return true;
			}
		}
		return false;
	}
}
