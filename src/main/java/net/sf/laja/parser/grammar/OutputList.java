package net.sf.laja.parser.grammar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.laja.parser.grammar.OmList.Refdata;
import net.sf.laja.parser.grammar.element.Outputmethod;

public class OutputList {
	private OmList omList;
	private RefList refList;
	private OutputvarSet ovSet;
	private List<Output> list = new ArrayList<Output>();

	public OutputList(OmList omList, RefList refList, OutputvarSet ovSet) {
		this.omList = omList;
		this.refList = refList;
		this.ovSet = ovSet;
	}

	public List<Output> getList() {
		return list;
	}

	private void add(Outputmethod om) {
		Output output = new Output(omList, ovSet, refList, om);
		if (!list.contains(output)) {
			list.add(output);
		}
	}

	public void add(Outputmethod om, String var1, String var2, String var2b) {
		if (om != null) {
			om.setReferenced();
			add(om);
		} else {
			Ref ref1 = refList.getRef(var1);
			Ref ref2 = refList.getRef(var2);
			if (ref2 == null) {
				ref2 = refList.getRef(var2b);
			}
			if (ref1 != null && ref2 != null) {
				om = new Outputmethod();
				om.setRef(var1);
				om.setArg(ref2.getRefname());

				String argClass = ref2.getClassName();
				if (argClass == null) {
					argClass = refList.getArgClass(ref2.getRefname());
					if (argClass == null) {
						return;
					}
				}

				om.setClass(ref1.getClassName());
				om.setArgClass(argClass);
				om.setReferenced();
				ref2.setReferenced(true);
				add(om);
			}
		}
	}


	public String getOutputVarName(int phase, String var1, String var2, String var2b, String origVar) {
		Outputmethod om1 = new Outputmethod();
		Outputmethod om2 = new Outputmethod();

		om1.setRef(var1);
		om1.setArg(var2);
		om2.setRef(var1);
		om2.setArg(var2b);

		for (Output output : list) {
			if (output.isSameOutputclass(om1) || output.isSameOutputclass(om2)) {
				if (output.isOutputClass(phase)) {
					return output.getVariableName(phase);
				} else {
					return "";
				}
			}
		}
		// Leta efter i definitionsfilen saknade set-metoder
		for (Output output : list) {
			if (var2.length() > 0 && output.isOutput(phase, var1, origVar)) {
				return output.getVariableName(phase);
			}
		}

		return "";
	}
	
	public void print(int phase) {
		for (Output output : list) {
			Outputmethod om = output.getFirstOutputmethod();
			String setter = om.isVariableSetter() ? "$ " : "";
			System.out.println("# " + setter + om + ", argClass=" + om.getArgClass() + ", argVariableSetter=" + output.isArgVariableSetter(phase) + ", variableSetter=" + output.isVariableSetter() + ", argClassVariableSetter=" + output.isArgClassVariableSetter() + ", argClassVariableDef="
					+ output.isArgClassVariableDef());
			output.print();
		}
	}

	public void init() {
		for (Output output : list) {
			Outputmethod om = output.getFirstOutputmethod();
			if (!om.isDefined()) {
				if (ovSet.isReference(om.getArgName())) {
					output.getFirstOutputmethod().setVariableSetter();
				}
			}
			// Markera alla primitiva set-metoder som refererar till klasser.
			Ref ref = refList.getRef(om.getOrigArgName());
			if (om.isDefined() && !om.isClass() && ref != null) {
				om.setClassRef(ref.getClassName());
			}
			for (Iterator i = omList.iterator(); i.hasNext();) {
				Outputmethod om2 = (Outputmethod) i.next();
				if (om.isSameOutputclass(om2)) {
					output.add(om2);
				}
			}
		}

		// Sätt flagga "hasOutputMethod" om metod finns deklarerad.
		for (Iterator<Ref> i = refList.iterator(); i.hasNext();) {
			Ref ref = i.next();
			if (omList.get(ref.getRefname()) != null) {
				ref.setHasOutputMethod(true);
			}
		}

		Map<Refdata, Refdata> refdataMap = omList.getRefdataMap();
		for (Refdata refdata : refdataMap.values()) {
			Ref ref = refList.getRef(refdata.getOrigVar());
			if (ref != null && ref.isHasOutputMethod()) {
				// Nu har vi hittat en referens som är ett objekt med metoder,
				// t ex:
				// valx = ... integer ...;
				// Integer integer.setInt(String *);
				// Då integer i valx-definitionen är ett objekt, kommer
				// Outputklassen för Integer att göra "peekInteger().setInt(..),
				// därför måste antingen en set-metod för valx.integer vara
				// definierad, detta kan göras åt användare då det inte ska vara
				// tvingande, exempel:
				// valx.setInteger(Integer integer);
				// Observera att man måste ta hänsyn till hur variabeln refereras,
				// T ex ska satsen...
				// kalle = (integer:idx1):idx2 integer;
				// ...refereras både med idx2 och integer.
				Outputmethod om = new Outputmethod();
				om.setRef(refdata.getVar1());
				om.setArgClass(ref.getClassName());
				om.setArg(ref.getRefname());
				Ref varRef = refList.getRef(refdata.getVar1());
				if (varRef == null) {
					System.out.println("Error. The variable '" + refdata.getVar1() +
									    "' must be declared, e.g: " + StringUtils.capitalize(refdata.getVar1()) + " " + refdata.getVar1() + ";");
				} else {
					om.setClass(varRef.getClassName());
				}

				Output output = new Output(omList, ovSet, refList, om, refdata);
				list.add(output);
			}
		}

		for (Output output : list) {
			output.init();
		}
	}
}
