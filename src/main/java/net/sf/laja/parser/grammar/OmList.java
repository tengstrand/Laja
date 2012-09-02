package net.sf.laja.parser.grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.laja.parser.engine2.Writer;
import net.sf.laja.parser.grammar.element.Classvar;
import net.sf.laja.parser.grammar.element.Constructor;
import net.sf.laja.parser.grammar.element.Outputmethod;

public class OmList implements Iterable {
	private boolean firstCall;
	private boolean onlyMarkedOutput;

	private boolean init;

	private ArrayList<Outputmethod> list = new ArrayList<Outputmethod>();
	private ArrayList<Outputmethod> list2 = new ArrayList<Outputmethod>();
	private ArrayList<Outputmethod> list3;
	private RefList refList;
	private OutputvarSet ovSet;
	private OutputList outputList; // H�ller information f�r det som sedan ska bli Output-klasserna.

	// Inneh�ller alla referenser som inte har n�gon Output-metod definierad.
	private Map<Refdata, Refdata> refdataMap = new HashMap<Refdata, Refdata>();

	public class Refdata {
		private int hashCode;
		private String var1;
		private String origVar;

		public Refdata(String var1, String origVar) {
			this.var1 = var1;
			this.origVar = origVar;
			hashCode = (var1 + "@" + origVar).hashCode();
		}

		public String getVar1() {
			return var1;
		}

		public String getOrigVar() {
			return origVar;
		}

		public String toString() {
			return var1 + " : " + origVar;
		}

		public int hashCode() {
			return hashCode;
		}

		public boolean equals(Object obj) {
			Refdata ir = (Refdata) obj;
			return ir.var1.equals(var1) && ir.origVar.equals(origVar);
		}
	}

	public OmList() {
	}

	public Map<Refdata, Refdata> getRefdataMap() {
		return refdataMap;
	}

	public void setOutputFlags(boolean firstCall, boolean onlyMarkedOutput) {
		this.firstCall = firstCall;
		this.onlyMarkedOutput = onlyMarkedOutput;
	}

	public Iterator<Outputmethod> iterator() {
		return list.iterator();
	}

	public List<Outputmethod> getFullList() {
		list3 = new ArrayList<Outputmethod>();
		list3.addAll(list);
		list3.addAll(list2);
		return list3;
	}

	public String getOutput(int phase, String var1, String var2, String var2b, String origVar) {
		if (var2 == null) {
			var2 = "";
		}
		if (var2b == null) {
			var2b = "";
		}

		if (firstCall) {
			Outputmethod om = getOutputmethod(var1, var2, var2b, origVar, true);
			if (om != null) {
				outputList.add(om, var1, var2, var2b);
			} else {
				if (origVar != null && var2.length() > 0 && !var2.equals("*")) {
					Refdata rd = new Refdata(var1, origVar);
					Refdata refdata = refdataMap.get(rd);
					if (refdata == null) {
						refdata = rd;
						refdataMap.put(refdata, refdata);
					}
				}
			}
			return "";
		}

		return outputList.getOutputVarName(phase, var1, var2, var2b, origVar);
	}

	public Outputmethod get(String refname) {
		for (Outputmethod om : list) {
			if (om.getRefname().equals(refname)) {
				return om;
			}
		}
		return null;
	}

	public Outputmethod getOutputmethod(String var1, String var2, String var2b, String origVar, boolean init) {
		for (Outputmethod om : list) {
			if (om.getCargName().equals(var1)) {
				if (om.getArgName().equals(var2)) {
					if (init) {
						om.setIdentifier(var2);
						om.setOrigArgName(origVar);
					}
					return om;
				}
				if (om.getArgName().equals(var2b)) {
					if (init) {
						om.setIdentifier(var2b);
						om.setOrigArgName(origVar);
					}
					return om;
				}
			}
		}
		return null;
	}

	public void setData(RefList refList, OutputvarSet ovSet, OutputList outputSet) {
		this.refList = refList;
		this.ovSet = ovSet;
		this.outputList = outputSet;
	}

	public boolean decoratable(int phase, String var1, String var2, String var2b, boolean not, String output) {
		String output2 = getOutput(phase, var1, var2, var2b, null);
		// TODO: Kolla om detta kan st�mma!
		boolean notdecoratable = (output.length() == output2.length() && !output.equals(output2));
		return !notdecoratable;
	}

	public boolean initReferences(Writer writer) {
		for (Outputmethod om : list) {
			if (!om.isReferenced()) {
				for (Outputmethod compare : list) {
					if (om != compare && compare.isReferenced() && om.getCargName().equals(compare.getCargName()) && om.getArgName().equals(compare.getArgName())) {
						om.setShareOutput();
					}
				}
			}
		}

		// Check for duplicated definitions.
		for (int i = 0; i < list.size(); i++) {
			Outputmethod om = list.get(i);
			if (om.isClassDefinition()) {
				for (int j = i + 1; j < list.size(); j++) {
					Outputmethod om2 = list.get(j);
					if (om2.isClassDefinition() && om.getClassName().equals(om2.getClassName())) {
						writer.writeln("\n\"" + om.getClassName() + "\" already defined in row " + om.getRow() + ". Error in row " + om2.getRow() + ":\n" + om.getRow() + ". " + om.getStatement() + "\n" + om2.getRow() + ". " + om2.getStatement());
						return false;
					}
				}
			}
		}

		// Check for duplicated method signatures.
		for (int i = 0; i < list.size(); i++) {
			Outputmethod om = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				Outputmethod om2 = list.get(j);
				if (om.getArgumentSignature().equals(om2.getArgumentSignature())) {
					writer.writeln("\nElement \"" + om.getArgName() + "\" already defined for \"" + om.getCargName() + "\" in row " + om.getRow() + "\nwith the same argument signature, error in row " + om2.getRow() + ":\n" + om.getRow() + ". " + om + "\n" + om2.getRow() + ". " + om2);
					return false;
				}
			}
		}

		// Check for unreferenced method arguments in outputmethod's.
		for (Outputmethod om : list) {
			if (!om.isReferenced() && !om.isShareOutput()) {
				writer.writeln("Element \"" + om.getArgName() + "\" not found in \"" + om.getCargName() + "\", error in row " + om.getRow() + ":\n   " + om.getStatement());
				return false;
			}
		}
		return true;
	}

	public boolean isRefClassDeclared(String refname) {
		for (Outputmethod om : list) {
			if (om.getArgName().equals(refname)) {
				if (om.isClass()) {
					return true;
				}
				Constructor constructor = om.getConstructor();
				if (constructor != null) {
					List<Classvar> classvarList = constructor.getClassvarList();
					for (Classvar classvar : classvarList) {
						if (classvar.getVarName().equals(refname)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public boolean isArgClassVariableSetter(Outputmethod omarg) {
		String classname = omarg.getArgClass() == null ? omarg.getClassRef() : omarg.getArgClass(); 
        if (classname != null) {
			for (Outputmethod om : list) {
				if (classname.equals(om.getClassName()) && om.isVariableSetter()) {
					return true;
				}
			}
		}
		return false;
	}

	public void add(Outputmethod om) {
		list.add(om);
	}

	public boolean isVariableSetter(String ref) {
		for (Outputmethod om : list) {
			if (om.getRefname().equals(ref) && om.isVariableSetter()) {
				return true;
			}
		}
		return false;
	}
}
