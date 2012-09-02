package net.sf.laja.parser.grammar.element;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.sf.laja.parser.GeneratorResult;
import net.sf.laja.parser.GrammarParser;
import net.sf.laja.parser.ParsingSettings;
import net.sf.laja.parser.GrammarParser.IDef;
import net.sf.laja.parser.GrammarParser.IOutputclass;
import net.sf.laja.parser.GrammarParser.IOutputmethod;
import net.sf.laja.parser.GrammarParser.IOutputvar;
import net.sf.laja.parser.engine2.EmptyWriter;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.Writer;
import net.sf.laja.parser.grammar.DefList;
import net.sf.laja.parser.grammar.GrammarData;
import net.sf.laja.parser.grammar.OmList;
import net.sf.laja.parser.grammar.Omarg;
import net.sf.laja.parser.grammar.Output;
import net.sf.laja.parser.grammar.OutputList;
import net.sf.laja.parser.grammar.OutputvarSet;
import net.sf.laja.parser.grammar.Ref;
import net.sf.laja.parser.grammar.RefList;
import net.sf.laja.parser.grammar.Row;
import net.sf.laja.parser.template.Out;
import net.sf.laja.parser.template.StatementList;
import net.sf.laja.parser.template.Varclass;

import org.apache.commons.lang.StringUtils;

//TODO: Format this file and others to use tab length=4 and only spaces.
public class Grammar implements GrammarParser.IGrammar, Row {
	private int row = 1;
	private boolean outputIsDefined = false;
	private String grammarName;
	private RefList refList = new RefList();
	private OmList omList = new OmList();
	private OutputvarSet ovSet;
	private OutputList outputList;
	private DefList defList;
	private String upperCaseGrammarName;
	private String className;
	private Writer writer;

	public Grammar(Writer writer) {
		this.writer = writer;
		defList = new DefList();
		ovSet = new OutputvarSet(writer);
		outputList = new OutputList(omList, refList, ovSet);
	}

	public void addRow(Index idx) {
		row++;
	}

	public int getRow() {
		return row;
	}

	public String getGrammarName() {
		return grammarName;
	}
	
	public void setGrammarName(String name) {
		grammarName = name;
	}

	public void setDef(IDef idef) {
		Def def = (Def) idef;
		if (!defList.add(def)) {
			writer.writeln("\n  Error. The variable \"" + def.getVarName() + "\" should be declared only once.");
		}
	}

	public void setOutputclass(IOutputclass outputclass) {
		outputIsDefined = true;
		Outputclass c = (Outputclass) outputclass;
		refList.add(c.getClassName(), c.getConstructor(), c.getVariableName());
	}

	public void setOutputmethod(IOutputmethod outputmethod) {
		outputIsDefined = true;
		Outputmethod m = (Outputmethod) outputmethod;
		omList.add(m);
		if (m.getClassName() != null) {
			refList.add(m.getClassName(), m.getConstructor(), m.getRefname());
		}
	}

	public void setOutputvar(IOutputvar ioutputvar) {
		outputIsDefined = true;
		Outputvar outputvar = (Outputvar) ioutputvar;
		if (!ovSet.add(outputvar)) {
			writer.write("\n Error. Variable " + outputvar + " already defined");
		}
	}
	
	public String getUppercaseGrammarName() {
		if (upperCaseGrammarName == null) {
			upperCaseGrammarName = StringUtils.capitalize(grammarName);
		}
		return upperCaseGrammarName;
	}
	
	public String getClassName() {
		if (className == null) {
			className = getUppercaseGrammarName() + "Parser"; 
		}
		return className;
	}
	
	public OmList getOmList() {
		return omList;
	}
    
	public GeneratorResult getGeneratorResult(ParsingSettings parsingSettings) {
		Ref ref = refList.getRef(grammarName);
		if (ref == null) {
			if (outputIsDefined) {
				writer.writeln("\n  Error. The variable \"" + grammarName + "\" must be declared.");
				return null;
			}
			// Add the definition manually.
			refList.add(getUppercaseGrammarName(), null, grammarName);
			ref = refList.getRef(grammarName);
		}

		boolean ok = true;

		// Fill in missing class names.
		outer:
		for (Outputmethod om : omList.getFullList()) {
			if (om.getClassName() == null) {
				for (Iterator i = refList.iterator(); i.hasNext();) {
					ref = (Ref) i.next();
					if (ref.getRefname().equals(om.getRefname())) {
						om.setClassDefinition(ref.getClassName());
						continue outer;
					}
				}
				writer.writeln("Error. Missing declaration for reference \"" + om.getRefname() + "\".");
				return null;
			}
		}

		for (Outputvar ov : ovSet.getSet()) {
			for (Iterator i = refList.iterator(); i.hasNext();) {
				ref = (Ref) i.next();
				if (ref.getRefname().equals(ov.getRef())) {
					ov.setClassName(ref.getClassName());
				}
			}
		}

		// ---
		// --- 2. Grammar definition.
		// ---
		GrammarData grammarData = new GrammarData(defList, omList, ovSet);
		omList.setData(refList, ovSet, outputList);
		ok = defList.generateGrammar(true, false, 1, grammarName, omList, ovSet, outputList, grammarData, new EmptyWriter(), parsingSettings, null);
		outputList.init();

		boolean ok2 = omList.initReferences(writer);
		if (ok) {
			ok = ok2;
		}

		StatementList statementList = new StatementList();
		defList.generateGrammar(false, false, 1, grammarName, omList, ovSet, outputList, grammarData, writer, parsingSettings, statementList);
		ok = defList.generateGrammar(false, false, 2, grammarName, omList, ovSet, outputList, grammarData, writer, parsingSettings, statementList);

		// ---
		// --- 4. Interfaces.
		// ---
		for (Iterator i = refList.iterator(); i.hasNext();) {
			ref = (Ref) i.next();

			Set<String> signatureSet = new HashSet<String>();
			for (Iterator j = omList.iterator(); j.hasNext();) {
				Outputmethod om = (Outputmethod)j.next();
				if (om.getClassName().equals(ref.getClassName())) {
					List<Omarg> omargList = om.getOmargList();
					String signature = om.getMethodSignature();

					if (signatureSet.contains(signature)) {
						writer.writeln("Error in row " + om.getRow() + ". Duplicate method signature:\n  " + om.getStatement());
						ok = false;
						break;
					}
					signatureSet.add(signature);
					
					ref.addOutputmethod(om);

					String name = om.getArgName();
					for (Omarg omarg : omargList) {
						if (omarg.getArg().equals(name)) {
							writer.writeln("Error in row " + om.getRow() + ". The variable names in the argument list must be unique:\n  " + om.getStatement());
							ok = false;
						}
					}
				}
			}
		}

		// TODO: Lägg in felmeddelande om class inte är deklarerad.
		// Fill in missing class names.
		for (Iterator i = omList.iterator(); i.hasNext();) {
			Outputmethod om = (Outputmethod) i.next();
			if (om.getClassName() == null) {
				for (Iterator it = refList.iterator(); it.hasNext();) {
					ref = (Ref) it.next();
					if (ref.getRefname().equals(om.getRefname())) {
						om.setClass(ref.getClassName());
					}
				}
			}
		}

		// ---
		// --- 7. Output implementations.
		// ---
		List<Out> outList = new ArrayList<Out>();
		for (Output output : outputList.getList()) {
			for (int phase = 1; phase <= 2; phase++) {
				if (!output.isOutputClassUniqe(phase)) {
					continue;
				}
				List<Outputmethod> odlist = output.getList(phase);
				List<String> commentList = new ArrayList<String>();
				for (Outputmethod om : odlist) {
					if (output.isDefined()) {
						commentList.add(om.getStatement());
					}
				}
				Out out = new Out(phase, output.getClassName(phase), output.getArgClass(), commentList, output.isReceive(phase), output.isPushPop(phase));
				outList.add(out);
				
				output.writeSetStatement(phase, out);
			}
		}

		// ---
		// --- 8. Generate "variable" classes.
		// ---
		List<Varclass> varclassList = new ArrayList<Varclass>();
		for (Outputvar ov : ovSet.getSet()) {
			if (ref != null) {
				Varclass varclass = new Varclass(
						ov.isBoolean(),
						ov.getClassname(),
						ref.getClassName(),
						ov.getMethod());
				varclassList.add(varclass);
			}
		}

		return new GeneratorResult(grammarName, this, outputList.getList(), 
				statementList.getList(), ovSet.getSet(), refList.getList(), outList, varclassList);
	}
}
