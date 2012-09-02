package net.sf.laja.parser.grammar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.sf.laja.parser.ParsingSettings;
import net.sf.laja.parser.engine2.Writer;
import net.sf.laja.parser.grammar.element.Def;
import net.sf.laja.parser.grammar.element.GrammarElement;
import net.sf.laja.parser.template.Comments;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.StatementList;

public class DefList {
	private List<Def> defList = new ArrayList<Def>();
	private List<String> nameList = new ArrayList<String>();
	private Set<Varinfo> localVars = new HashSet<Varinfo>();

	private int nameListSize;

	static class Varinfo {
		public String var;
		public int row;

		public Varinfo(String var, int row) {
			this.var = var;
			this.row = row;
		}
	}

	public boolean add(Def def) {
		if (nameList.contains(def.getVarName())) {
			return false;
		}

		defList.add(def);
		nameList.add(def.getVarName());

		return true;
	}

	public String addNewVarname(String name) {
		int i = 1;
		while (nameList.contains(name + "_" + i)) {
			i++;
		}

		name += "_" + i;
		nameList.add(name);

		return name;
	}

	public void addLocalVariable(String name, int row) {
		localVars.add(new Varinfo(name, row));
	}

	public Def getDef(String name) {
		for (Def def : defList) {
			if (name.equals(def.getVarName())) {
				return def;
			}
		}
		return null;
	}

	public boolean generateGrammar(boolean firstCall, boolean onlyMarkedOutput, int phase, String grammarName, OmList omList, OutputvarSet ovSet, OutputList outputList, GrammarData grammarData, Writer writer, ParsingSettings parsingSettings, StatementList statementList) {
		// 1. Declarations.
		boolean ok = true;

		omList.setOutputFlags(firstCall, onlyMarkedOutput);

		initNameListAndRemoveElementsIfNotFirstCall(firstCall);
		generateDeclarationsIfForwardRef(phase, grammarData, parsingSettings, statementList);

		boolean generateDeclarations = !parsingSettings.isForwardRef();
		generateStatements(phase, grammarData, statementList, generateDeclarations);

		// Check if local variables are declared.
		for (Varinfo varinfo : localVars) {
			boolean found = false;
			for (Iterator<Def> j = defList.iterator(); j.hasNext();) {
				Def def = j.next();
				String name = def.getVarName();
				if (varinfo.var.equals(name)) {
					found = true;
					break;
				}
			}

			if (!found) {
				writer.writeln("Undefined variable \"" + varinfo.var + "\". Error in row " + varinfo.row + "\n");
				ok = false;
				break;
			}
		}

		return ok;
	}

	private void initNameListAndRemoveElementsIfNotFirstCall(boolean firstCall) {
		if (firstCall) {
			nameListSize = nameList.size();
		} else {
			while (nameList.size() > nameListSize) {
				nameList.remove(nameList.size() - 1);
			}
		}
	}
	
	private void generateStatements(int phase, GrammarData grammarData,
			StatementList statementList, boolean generateDeclarations) {
		for (Def def : defList) {
			Comments comments = new Comments();

			// Show the definition.
			List<String> statement = def.getStatement();
			String defname = def.getVarName() + " = ";
			boolean tab = false;
			if (statement.size() > 1) {
				comments.add(tab, defname.trim());	// Add comment.
				defname = "";
				tab = true;
			}
			for (String s : statement) {
				comments.add(tab, defname + s);
				defname = "";
			}
			if (statementList != null && comments.hasElements()) {
				statementList.add(new Statement(phase, comments));
			}
			String name = def.getVarName();
			GrammarElement grammarElement = def.getVal();
			grammarElement.generate(phase, false, generateDeclarations, true, false, null, name, name, "*", "*", grammarData, statementList);
		}
	}

	private void generateDeclarationsIfForwardRef(int phase, GrammarData grammarData, 
			ParsingSettings parsingSettings, StatementList statementList) {
		if (parsingSettings.isForwardRef()) {
			for (Def def : defList) {
				String name = def.getVarName();
				GrammarElement grammarElement = def.getVal();
				grammarElement.generate(phase, true, true, false, false, null, name, name, "*", "*", grammarData, statementList);
			}
		}
	}
}
