package net.sf.laja.parser.grammar;

import java.util.ArrayList;
import java.util.List;

import net.sf.laja.parser.grammar.OmList.Refdata;
import net.sf.laja.parser.grammar.element.Outputmethod;
import net.sf.laja.parser.template.Out;
import net.sf.laja.parser.template.OutDatatype;
import net.sf.laja.parser.template.PeekStatement;
import net.sf.laja.parser.template.PopDeclStatement;
import net.sf.laja.parser.template.PopStatement;

public class Output {
	// private int phase;
	// private boolean isOutputClass;
	private Refdata refdata;

	private int cnt1; // Count "$"-marked output-classes.
	private int cnt2; // Count none "$"-marked output-classes.
	private String postfix;
	private OmList omList;
	private OutputvarSet ovSet;
	private RefList refList;
	// private List<Outputmethod> list;
	private List<Outputmethod> fulllist = new ArrayList<Outputmethod>();

	public Output(OmList omList, OutputvarSet ovSet, RefList refList, Outputmethod om) {
		this.omList = omList;
		this.ovSet = ovSet;
		this.refList = refList;
		add(om);
	}

	public Output(OmList omList, OutputvarSet ovSet, RefList refList, Outputmethod om, Refdata refdata) {
		this(omList, ovSet, refList, om);
		this.refdata = refdata;
	}

	public boolean isOutput(int phase, String var1, String origVar) {
		return isOutputClass(phase) && refdata != null && refdata.getVar1().equals(var1) && refdata.getOrigVar().equals(origVar);
	}

	public void print() {
		for (Outputmethod om : fulllist) {
			System.out.println("  # " + om);
		}
	}

	public void add(Outputmethod om) {
		if (!fulllist.contains(om)) {
			fulllist.add(om);
		}
	}

	public String getVariableName(int phase) {
		String name = getFirstOutputmethod().getOutputVarName();
		if (cnt1 > 0 && cnt2 > 0) {
			return "_" + phase + name;
		}
		return name;
	}

	public String getClassName(int phase) {
		if (cnt1 > 0 && cnt2 > 0) {
			return "_" + phase + getFirstOutputmethod().getOutputClassName();
		}
		return getFirstOutputmethod().getOutputClassName();
	}

	/*
	 * Om cnt1 > 0 && cnt2 > 0, postfix = 1 och 2. Annars, inget postfix.
	 * 
	 */
	public void init() {
		cnt1 = 0;
		cnt2 = 0;
		for (Outputmethod om : fulllist) {
			if (isOutputclass(om)) {
				cnt1++;
			} else {
				cnt2++;
			}
		}
	}

	// public void initPhase(int phase) {
	// this.phase = phase;
	// isOutputClass = false;
	//
	// list = new ArrayList<Outputmethod>();
	// for (Outputmethod om : fulllist) {
	// if (isOutputclass(phase, om)) {
	// list.add(om);
	// isOutputClass = true;
	// }
	// }
	// }

	public boolean isOutputClass(int phase) {
		for (Outputmethod om : fulllist) {
			if (isOutputclass(phase, om)) {
				return true;
			}
		}
		return false;
	}

	// refdata != null
	private boolean isOutputclass(Outputmethod om) {
		return om.isVariableSetter() || omList.isArgClassVariableSetter(om) || ovSet.isArgClassVariableDef(om);
	}

	private boolean isOutputclass(int phase, Outputmethod om) {
		return phase == 2 || isOutputclass(om);
	}

	public boolean isOutputClassUniqe(int phase) {
		if (phase == 1) {
			return cnt1 > 0 && cnt2 > 0;
		}
		return true;
	}

	/**
	 * Returns the outputmethod list for the given phase.
	 * 
	 * @param phase
	 * @return output methods
	 */
	public List<Outputmethod> getList(int phase) {
		List list = new ArrayList<Outputmethod>();
		for (Outputmethod om : fulllist) {
			if (isOutputclass(phase, om)) {
				list.add(om);
			}
		}
		return list;
	}

	private Outputmethod getOutputmethod(int phase) {
		List<Outputmethod> list = getList(phase);

		for (Outputmethod om : list) {
			if (om.isClass()) {
				return om;
			}
		}
		return null;
	}

	public boolean isPushPop(int phase) {
		List<Outputmethod> list = getList(phase);

		for (Outputmethod om : list) {
			String str = om.toString();
			if (om.isClass() || om.isClassRef()) {
				return true;
			}
		}
		return false;
	}

	private boolean isClassOrClassRef(int phase) {
		List<Outputmethod> list = getList(phase);

		for (Outputmethod om : list) {
			if (om.isClass() || om.isClassRef()) {
				return true;
			}
		}
		return false;
	}

	public int cntClasses(int phase) {
		List<Outputmethod> list = getList(phase);

		int cnt = 0;
		for (Outputmethod om : list) {
			String txt = om.toString();
			if (om.isClass() || om.isClassRef()) {
				cnt++;
			}
		}
		return cnt;
	}

	public boolean isVariableSetter() {
		return cnt1 > 0;
	}

	public boolean isReceive(int phase) {
		String arg = getFirstOutputmethod().getOrigArgName();
		return isVariableSetter() || isArgVariableSetter(phase) || (isClassOrClassRef(phase) && (omList.isVariableSetter(arg) || ovSet.isReference(arg)));
	}

	public boolean isArgVariableSetter(int phase) {
		List<Outputmethod> list = getList(phase);

		if (list != null) {
			for (Outputmethod om : list) {
				if (om.isClass()) {
					return omList.isArgClassVariableSetter(om);
				}
			}
		}
		return false;
	}

	public String getArgClass() {
		Outputmethod om = getFirstOutputmethod();
		String argClass = getFirstOutputmethod().getArgClass();
		if (argClass != null) {
			return argClass;
		}
		if (om.isClassRef()) {
			return om.getClassRef();
		}
		return null;
	}

	public boolean isDefined() {
		return getFirstOutputmethod().isDefined();
	}

	public boolean isArgClassVariableSetter() {
		return omList.isArgClassVariableSetter(getFirstOutputmethod());
	}

	public boolean isArgClassVariableDef() {
		return ovSet.isArgClassVariableDef(getFirstOutputmethod());
	}

	public boolean isSameOutputclass(Outputmethod compare) {
		Outputmethod om = getFirstOutputmethod();
		return om.isSameOutputclass(compare);
	}

	public void writeSetStatement(int phase, Out out) {
		List<Outputmethod> list = getList(phase);

		int cntClasses = cntClasses(phase);
		
		Outputmethod om2 = getFirstOutputmethod();
		if (cntClasses <= 1 && !((om2.getRefname().equals(om2.getCargName()) && 
			om2.getRefname().equals(om2.getArgName())))) {
			for (Outputmethod om : list) {
				if (om.isClass()) {
					if (om.isDefined()) {
                        PeekStatement peekStatement = new PeekStatement(om.getClassName(), om.getMethodName(), OutDatatype.CLASS, om.getOmargList());
                        peekStatement.setArgClass(om.getArgClass());
                        out.addStatement(peekStatement);
					} else if (refdata != null) {
                        PopStatement popStatement = new PopStatement(refList.getRef(refdata.getOrigVar()).getClassName());
                        out.addStatement(popStatement);
					}
				} else {
					if (om.isClassRef()) {
                        PopStatement popStatement = new PopStatement(om.getClassRef());
                        out.addStatement(popStatement);
					}
					if (om.isStr()) {
                        out.addStatement(new PeekStatement(om.getClassName(), om.getMethodName(), OutDatatype.STRING, om.getOmargList()));
					} else if (om.isIndex()) {
                        out.addStatement(new PeekStatement(om.getClassName(), om.getMethodName(), OutDatatype.INDEX, om.getOmargList()));
					} else if (om.isVoid()) {
                        out.addStatement(new PeekStatement(om.getClassName(), om.getMethodName(), OutDatatype.VOID, om.getOmargList()));
					}
				}
			}
		} else {
			boolean first = true;
			for (Outputmethod om : list) {
				if (om.isClass()) {
					// TODO: Klass-instansen måste läggas i en separat variabel.
					String c = om.getArgClass(); // OBS!!! - lägg in översättning
					String v = om.getArgName(); // OBS!! - översätt
					if (first) {
						first = false;
                        out.addStatement(new PopDeclStatement(om.getArgClass(), om.getArgName(), om.getArgClass()));
					}
                    PeekStatement peekStatement = new PeekStatement(om.getClassName(), om.getMethodName(), OutDatatype.VARIABLE, null);
                    peekStatement.setVariableName(v);
                    out.addStatement(peekStatement);
				}
			}
		}
	}

	// Used when executing the method List<Output>.contains().
	public boolean equals(Object o) {
		Outputmethod om = ((Output) o).getFirstOutputmethod();
		return getFirstOutputmethod().equals(om);
	}

	public Outputmethod getFirstOutputmethod() {
		return fulllist.iterator().next();
	}

	public String toString() {
		return getFirstOutputmethod().toString();
	}
}
