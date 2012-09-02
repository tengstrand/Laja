package net.sf.laja.parser;

import java.util.Map;

import net.sf.laja.parser.GrammarParser.IGrammarFactory;
import net.sf.laja.parser.GrammarParser.IGrammarFactoryFactory;
import net.sf.laja.parser.engine2.ParsingResult;
import net.sf.laja.parser.engine2.PrintWriter;
import net.sf.laja.parser.engine2.Util;
import net.sf.laja.parser.engine2.Writer;
import net.sf.laja.parser.engine2.exception.ParserException;
import net.sf.laja.parser.grammar.ParserFactory;
import net.sf.laja.parser.grammar.element.Grammar;

public class Parser {

	public static void parseGrammar(Map<String,Object> context, String grammarFile, boolean forwardRef) {
		GeneratorResult generatorResult = execute(grammarFile, true);

		context.put("grammar", generatorResult.getGrammar());
		context.put("outList", generatorResult.getOut());
		context.put("outputList", generatorResult.getOutput());
		context.put("outputvarList", generatorResult.getOutputvar());
		context.put("refList", generatorResult.getRef());
		context.put("statementList", generatorResult.getStatement());
		context.put("varclassList", generatorResult.getVarclass());
	}
	
	/**
	 * Reads a grammar file and populates the context.
	 * 
	 * @param context
	 * @return
	 */
	private static GeneratorResult execute(String grammarFile, final boolean forwardRef) {
		final Writer writer = new PrintWriter();
		
		// TODO: Fix this!
		ParsingSettings parsingSettings = new ParsingSettings() {
			@Override
			public boolean isForwardRef() {
				return forwardRef;
			}
		};
		grammarFile = Util.replaceSlash(grammarFile);
		
		writer.writeln("  Reading grammar \"" + grammarFile + "\"");
		
		GrammarParser parser = new GrammarParser(new IGrammarFactoryFactory() {
			public IGrammarFactory getFactory(int phase) {
				return new ParserFactory(writer);
			}}
		);
	
		ParsingResult result = parser.parseFile(grammarFile);

		if (result.success()) {
			Grammar grammar = ((ParserFactory)parser.getFactory()).getGrammar();
			return grammar.getGeneratorResult(parsingSettings);
		}
		throw new ParserException("Could not generate grammar: " + result);
	}
}
