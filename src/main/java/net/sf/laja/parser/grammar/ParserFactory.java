package net.sf.laja.parser.grammar;

import net.sf.laja.parser.GrammarParser.IClassvar;
import net.sf.laja.parser.GrammarParser.IConstructor;
import net.sf.laja.parser.GrammarParser.IDef;
import net.sf.laja.parser.GrammarParser.IEnd;
import net.sf.laja.parser.GrammarParser.IComplete;
import net.sf.laja.parser.GrammarParser.IGrammar;
import net.sf.laja.parser.GrammarParser.IGrammarFactory;
import net.sf.laja.parser.GrammarParser.IInteger;
import net.sf.laja.parser.GrammarParser.IMarker;
import net.sf.laja.parser.GrammarParser.IOmarg;
import net.sf.laja.parser.GrammarParser.IOutputclass;
import net.sf.laja.parser.GrammarParser.IOutputmethod;
import net.sf.laja.parser.GrammarParser.IOutputvar;
import net.sf.laja.parser.GrammarParser.IRange;
import net.sf.laja.parser.GrammarParser.IRange1;
import net.sf.laja.parser.GrammarParser.IReference;
import net.sf.laja.parser.GrammarParser.IRepeats;
import net.sf.laja.parser.GrammarParser.IStr;
import net.sf.laja.parser.GrammarParser.IVal;
import net.sf.laja.parser.GrammarParser.IValand;
import net.sf.laja.parser.GrammarParser.IValopt;
import net.sf.laja.parser.GrammarParser.IValor;
import net.sf.laja.parser.GrammarParser.IValpar;
import net.sf.laja.parser.GrammarParser.IValprim;
import net.sf.laja.parser.GrammarParser.IValstmt;
import net.sf.laja.parser.GrammarParser.IValx;
import net.sf.laja.parser.GrammarParser.IVariable;
import net.sf.laja.parser.engine2.Writer;
import net.sf.laja.parser.grammar.element.Classvar;
import net.sf.laja.parser.grammar.element.Constructor;
import net.sf.laja.parser.grammar.element.Def;
import net.sf.laja.parser.grammar.element.End;
import net.sf.laja.parser.grammar.element.Complete;
import net.sf.laja.parser.grammar.element.Integer;
import net.sf.laja.parser.grammar.element.Marker;
import net.sf.laja.parser.grammar.element.Outputclass;
import net.sf.laja.parser.grammar.element.Outputmethod;
import net.sf.laja.parser.grammar.element.Outputvar;
import net.sf.laja.parser.grammar.element.Range;
import net.sf.laja.parser.grammar.element.Range1;
import net.sf.laja.parser.grammar.element.Reference;
import net.sf.laja.parser.grammar.element.Repeats;
import net.sf.laja.parser.grammar.element.Str;
import net.sf.laja.parser.grammar.element.Val;
import net.sf.laja.parser.grammar.element.Valand;
import net.sf.laja.parser.grammar.element.Valopt;
import net.sf.laja.parser.grammar.element.Valor;
import net.sf.laja.parser.grammar.element.Valpar;
import net.sf.laja.parser.grammar.element.Valprim;
import net.sf.laja.parser.grammar.element.Valstmt;
import net.sf.laja.parser.grammar.element.Valx;
import net.sf.laja.parser.grammar.element.Variable;

public class ParserFactory implements IGrammarFactory {
	private final Writer writer;
	private net.sf.laja.parser.grammar.element.Grammar grammar;

	public ParserFactory(Writer writer) {
		this.writer = writer;
	}

	public net.sf.laja.parser.grammar.element.Grammar getGrammar() {
		return grammar;
	}

	@Override
	public IGrammar createGrammar() {
		return grammar = new net.sf.laja.parser.grammar.element.Grammar(writer);
	}

	@Override
	public IRange createRange() {
		return new Range();
	}

	@Override
	public IRange1 createRange1() {
		return new Range1();
	}

	@Override
	public IStr createStr() {
		return new Str();
	}

	@Override
	public IDef createDef() {
		return new Def();
	}

	@Override
	public IClassvar createClassvar() {
		return new Classvar();
	}

	@Override
	public IConstructor createConstructor() {
		return new Constructor();
	}

	@Override
	public IOutputclass createOutputclass() {
		return new Outputclass();
	}

	@Override
	public IOmarg createOmarg() {
		return new Omarg();
	}

	@Override
	public IOutputmethod createOutputmethod(IGrammar grammar) {
		return new Outputmethod((Row)grammar);
	}

	@Override
	public IOutputvar createOutputvar() {
		return new Outputvar();
	}

	@Override
	public IVal createVal() {
		return new Val();
	}

	@Override
	public IValstmt createValstmt() {
		return new Valstmt();
	}

	@Override
	public IValx createValx() {
		return new Valx();
	}
	
	@Override
	public IRepeats createRepeats() {
		return new Repeats();
	}

	@Override
	public IValand createValand() {
		return new Valand();
	}
	
	@Override
	public IValprim createValprim() {
		return new Valprim();
	}

	@Override
	public IValpar createValpar() {
		return new Valpar();
	}

	@Override
	public IValor createValor() {
		return new Valor();
	}

	@Override
	public IValopt createValopt() {
		return new Valopt();
	}

	@Override
	public IInteger createInteger() {
		return new Integer();
	}

	@Override
	public IEnd createEnd() {
		return new End();
	}

	@Override
	public IMarker createMarker() {
		return new Marker();
	}

	@Override
	public IReference createReference(IGrammar grammar) {
		return new Reference((Row)grammar);
	}

	@Override
	public IVariable createVariable() {
		return new Variable();
	}

	@Override
	public IComplete createComplete() {
		return new Complete();
	}

}
