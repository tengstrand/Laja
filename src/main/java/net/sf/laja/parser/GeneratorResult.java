package net.sf.laja.parser;

import java.util.List;
import java.util.Set;

import net.sf.laja.parser.grammar.Output;
import net.sf.laja.parser.grammar.Ref;
import net.sf.laja.parser.grammar.element.Grammar;
import net.sf.laja.parser.grammar.element.Outputvar;
import net.sf.laja.parser.template.GrammarData;
import net.sf.laja.parser.template.Out;
import net.sf.laja.parser.template.Statement;
import net.sf.laja.parser.template.Varclass;

public class GeneratorResult {
	private GrammarData grammarData;
	private List<Output> outputList;
	private List<Statement> statementList;
	private Set<Outputvar> outputVars;
	private List<Ref> refList;
	private List<Out> outList;
	private List<Varclass> varclassList;
	
	public GeneratorResult(String grammarName, Grammar grammar, List<Output> outputList,
				List<Statement> statementList, Set<Outputvar> outputVars,
				List<Ref> refList, List<Out> outList, List<Varclass> varclassList) {
		this.grammarData = new GrammarData(grammar, grammarName, refList);
		this.outputList = outputList;
		this.statementList = statementList;
		this.outputVars = outputVars;
		this.refList = refList;
		this.outList = outList;
		this.varclassList = varclassList;
	}

	public GrammarData getGrammar() {
		return grammarData;
	}

	public List<Output> getOutput() {
		return outputList;
	}

	public List<Statement> getStatement() {
		return statementList;
	}

	public Set<Outputvar> getOutputvar() {
		return outputVars;
	}

	public List<Ref> getRef() {
		return refList;
	}

	public List<Out> getOut() {
		return outList;
	}

	public List<Varclass> getVarclass() {
		return varclassList;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[")
			.append("general=").append(grammarData)
			.append(", outputList").append(outputList)
			.append(", statementList").append(statementList)
			.append(", outputVars").append(outputVars)
			.append(", refList").append(refList)
			.append(", outList").append(outList)
			.append(", varclassList").append(varclassList)
			.append("]");
		return builder.toString();
	}
}
