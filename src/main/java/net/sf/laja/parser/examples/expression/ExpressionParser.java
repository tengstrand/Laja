package net.sf.laja.parser.examples.expression;

import java.util.Stack;

import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.ParsingResult;
import net.sf.laja.parser.engine2.element.AndList;
import net.sf.laja.parser.engine2.element.Chr;
import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.element.ElementList;
import net.sf.laja.parser.engine2.element.End;
import net.sf.laja.parser.engine2.element.FollowedBy;
import net.sf.laja.parser.engine2.element.Complete;
import net.sf.laja.parser.engine2.element.Marker;
import net.sf.laja.parser.engine2.element.Optional;
import net.sf.laja.parser.engine2.element.OrList;
import net.sf.laja.parser.engine2.element.Range;
import net.sf.laja.parser.engine2.element.Repeat;
import net.sf.laja.parser.engine2.element.Str;
import net.sf.laja.parser.engine2.element.Variable;
import net.sf.laja.parser.engine2.exception.ParserException;
import net.sf.laja.parser.engine2.inspector.DefaultSyntaxErrorHandler;
import net.sf.laja.parser.engine2.inspector.SyntaxErrorHandler;
import net.sf.laja.parser.engine2.source.FileSource;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.parser.engine2.source.StringSource;
import net.sf.laja.parser.engine2.source.URLSource;

/**
 * Auto generated 2010-03-26 by Laja:
 *    http://sourceforge.net/projects/laja
 *
 * Parser engine: 1.001-alpha
 */
public final class ExpressionParser implements net.sf.laja.parser.engine2.Parser {
	private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
	private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
	private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

	private Data data1;
	private Data data2;
	private IExpressionFactory factory1;
	private IExpressionFactory factory2;
	private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
	private SyntaxErrorHandler syntaxErrorHandler;

	public static final int PHASE1 = 1;
	public static final int PHASE2 = 2;

	public ExpressionParser(IExpressionFactoryFactory factoryFactory) {
		init(factoryFactory);
	}

	public void init(IExpressionFactoryFactory factoryFactory) {
		syntaxErrorHandler = new DefaultSyntaxErrorHandler();
		factory1 = factoryFactory.getFactory(PHASE1);
		factory2 = factoryFactory.getFactory(PHASE2);
		data1 = new Data(factory1);
		data2 = new Data(factory2);
	}

	public ExpressionParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
		sourceRecorderLogWriter = writer;
		return this;
	}

	public ExpressionParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
		this.syntaxErrorHandler = syntaxErrorHandler;
		return this;
	}

	public IExpressionFactory getFactory1() {
		return factory1;
	}

	public IExpressionFactory getFactory() {
		return factory2;
	}

	// parse string
	public ParsingResult parseString(String string) throws ParserException {
		return parse(new StringSource(string));
	}

	// parse file
	public ParsingResult parseFile(String filename) throws ParserException {
		return parse(new FileSource(filename));
	}

	// parse URL
	public ParsingResult parseURL(String url) throws ParserException {
		return parse(new URLSource(url));
	}

	// parse
	public ParsingResult parse(Source source) throws ParserException {
		net.sf.laja.parser.engine2.element.Element element = getGrammar1();

		boolean match = element.parse(0, source, false, true, false);
		int bestIndex = source.getBestIndex();

		if (match && source.reachedEnd()) {
			source.reset();
			element = getGrammar2();
			match = element.parse(0, source, false, true, true);
			if (!match) {
				throw new IllegalStateException("The parsing result was true in phase 1, but false in phase 2.");
			}
			return new ParsingResult(true, source, syntaxErrorHandler);
		} else if (sourceRecorderLogWriter != null) {
			source.reset();
			source.getRecorder().setLogging(sourceRecorderLogWriter, bestIndex);
			element.parse(0, source, false, true, false);
		}

		return new ParsingResult(false, source, element, syntaxErrorHandler);
	}

	private net.sf.laja.parser.engine2.element.Element getGrammar2() {
		// *** Output classes ***
		Data.OneArgumentFunctionOneArgumentFunctionAbs oneArgumentFunctionOneArgumentFunctionAbs = data2.new OneArgumentFunctionOneArgumentFunctionAbs("oneArgumentFunctionOneArgumentFunctionAbs");
		Data.OneArgumentFunctionOneArgumentFunctionAcos oneArgumentFunctionOneArgumentFunctionAcos = data2.new OneArgumentFunctionOneArgumentFunctionAcos("oneArgumentFunctionOneArgumentFunctionAcos");
		Data.OneArgumentFunctionOneArgumentFunctionAsin oneArgumentFunctionOneArgumentFunctionAsin = data2.new OneArgumentFunctionOneArgumentFunctionAsin("oneArgumentFunctionOneArgumentFunctionAsin");
		Data.OneArgumentFunctionOneArgumentFunctionAtan oneArgumentFunctionOneArgumentFunctionAtan = data2.new OneArgumentFunctionOneArgumentFunctionAtan("oneArgumentFunctionOneArgumentFunctionAtan");
		Data.OneArgumentFunctionOneArgumentFunctionCeil oneArgumentFunctionOneArgumentFunctionCeil = data2.new OneArgumentFunctionOneArgumentFunctionCeil("oneArgumentFunctionOneArgumentFunctionCeil");
		Data.OneArgumentFunctionOneArgumentFunctionCos oneArgumentFunctionOneArgumentFunctionCos = data2.new OneArgumentFunctionOneArgumentFunctionCos("oneArgumentFunctionOneArgumentFunctionCos");
		Data.OneArgumentFunctionOneArgumentFunctionExp oneArgumentFunctionOneArgumentFunctionExp = data2.new OneArgumentFunctionOneArgumentFunctionExp("oneArgumentFunctionOneArgumentFunctionExp");
		Data.OneArgumentFunctionOneArgumentFunctionFloor oneArgumentFunctionOneArgumentFunctionFloor = data2.new OneArgumentFunctionOneArgumentFunctionFloor("oneArgumentFunctionOneArgumentFunctionFloor");
		Data.OneArgumentFunctionOneArgumentFunctionLog oneArgumentFunctionOneArgumentFunctionLog = data2.new OneArgumentFunctionOneArgumentFunctionLog("oneArgumentFunctionOneArgumentFunctionLog");
		Data.OneArgumentFunctionOneArgumentFunctionRint oneArgumentFunctionOneArgumentFunctionRint = data2.new OneArgumentFunctionOneArgumentFunctionRint("oneArgumentFunctionOneArgumentFunctionRint");
		Data.OneArgumentFunctionOneArgumentFunctionRound oneArgumentFunctionOneArgumentFunctionRound = data2.new OneArgumentFunctionOneArgumentFunctionRound("oneArgumentFunctionOneArgumentFunctionRound");
		Data.OneArgumentFunctionOneArgumentFunctionSin oneArgumentFunctionOneArgumentFunctionSin = data2.new OneArgumentFunctionOneArgumentFunctionSin("oneArgumentFunctionOneArgumentFunctionSin");
		Data.OneArgumentFunctionOneArgumentFunctionSqrt oneArgumentFunctionOneArgumentFunctionSqrt = data2.new OneArgumentFunctionOneArgumentFunctionSqrt("oneArgumentFunctionOneArgumentFunctionSqrt");
		Data.OneArgumentFunctionOneArgumentFunctionTan oneArgumentFunctionOneArgumentFunctionTan = data2.new OneArgumentFunctionOneArgumentFunctionTan("oneArgumentFunctionOneArgumentFunctionTan");
		Data.OneArgumentFunctionOneArgumentFunctionToDegrees oneArgumentFunctionOneArgumentFunctionToDegrees = data2.new OneArgumentFunctionOneArgumentFunctionToDegrees("oneArgumentFunctionOneArgumentFunctionToDegrees");
		Data.OneArgumentFunctionOneArgumentFunctionToRadians oneArgumentFunctionOneArgumentFunctionToRadians = data2.new OneArgumentFunctionOneArgumentFunctionToRadians("oneArgumentFunctionOneArgumentFunctionToRadians");
		Data.OneArgumentFunctionOneArgumentFunctionArgument oneArgumentFunctionOneArgumentFunctionArgument = data2.new OneArgumentFunctionOneArgumentFunctionArgument("oneArgumentFunctionOneArgumentFunctionArgument");
		Data.TwoArgumentsFunctionTwoArgumentsFunctionAtan2 twoArgumentsFunctionTwoArgumentsFunctionAtan2 = data2.new TwoArgumentsFunctionTwoArgumentsFunctionAtan2("twoArgumentsFunctionTwoArgumentsFunctionAtan2");
		Data.TwoArgumentsFunctionTwoArgumentsFunctionMax twoArgumentsFunctionTwoArgumentsFunctionMax = data2.new TwoArgumentsFunctionTwoArgumentsFunctionMax("twoArgumentsFunctionTwoArgumentsFunctionMax");
		Data.TwoArgumentsFunctionTwoArgumentsFunctionMin twoArgumentsFunctionTwoArgumentsFunctionMin = data2.new TwoArgumentsFunctionTwoArgumentsFunctionMin("twoArgumentsFunctionTwoArgumentsFunctionMin");
		Data.TwoArgumentsFunctionTwoArgumentsFunctionPow twoArgumentsFunctionTwoArgumentsFunctionPow = data2.new TwoArgumentsFunctionTwoArgumentsFunctionPow("twoArgumentsFunctionTwoArgumentsFunctionPow");
		Data.TwoArgumentsFunctionTwoArgumentsFunctionArg1 twoArgumentsFunctionTwoArgumentsFunctionArg1 = data2.new TwoArgumentsFunctionTwoArgumentsFunctionArg1("twoArgumentsFunctionTwoArgumentsFunctionArg1");
		Data.TwoArgumentsFunctionTwoArgumentsFunctionArg2 twoArgumentsFunctionTwoArgumentsFunctionArg2 = data2.new TwoArgumentsFunctionTwoArgumentsFunctionArg2("twoArgumentsFunctionTwoArgumentsFunctionArg2");
		Data.Expression1Expression1Random expression1Expression1Random = data2.new Expression1Expression1Random("expression1Expression1Random");
		Data.Expression1Expression1OneArgumentFunction expression1Expression1OneArgumentFunction = data2.new Expression1Expression1OneArgumentFunction("expression1Expression1OneArgumentFunction");
		Data.Expression1Expression1TwoArgumentsFunction expression1Expression1TwoArgumentsFunction = data2.new Expression1Expression1TwoArgumentsFunction("expression1Expression1TwoArgumentsFunction");
		Data.Expression1Expression1Number expression1Expression1Number = data2.new Expression1Expression1Number("expression1Expression1Number");
		Data.Expression1Expression1Expression expression1Expression1Expression = data2.new Expression1Expression1Expression("expression1Expression1Expression");
		Data.Expression2Expression2Expression1 expression2Expression2Expression1 = data2.new Expression2Expression2Expression1("expression2Expression2Expression1");
		Data.Expression2Expression2Expo expression2Expression2Expo = data2.new Expression2Expression2Expo("expression2Expression2Expo");
		Data.Expression3Expression3Plus expression3Expression3Plus = data2.new Expression3Expression3Plus("expression3Expression3Plus");
		Data.Expression3Expression3Expression2 expression3Expression3Expression2 = data2.new Expression3Expression3Expression2("expression3Expression3Expression2");
		Data.Expression3Expression3Mul expression3Expression3Mul = data2.new Expression3Expression3Mul("expression3Expression3Mul");
		Data.Expression3Expression3Div expression3Expression3Div = data2.new Expression3Expression3Div("expression3Expression3Div");
		Data.Expression3Expression3Mod expression3Expression3Mod = data2.new Expression3Expression3Mod("expression3Expression3Mod");
		Data.ExpressionExpressionExpression3 expressionExpressionExpression3 = data2.new ExpressionExpressionExpression3("expressionExpressionExpression3");
		Data.ExpressionExpressionPlus expressionExpressionPlus = data2.new ExpressionExpressionPlus("expressionExpressionPlus");
		Data.ExpressionExpressionMinus expressionExpressionMinus = data2.new ExpressionExpressionMinus("expressionExpressionMinus");

		// *** Declarations and Statements ***
		Repeat integer = new Repeat(1, "integer");
		ElementList number = new ElementList(2, "number");
		ElementList oneArgumentFunction = new ElementList(3, "oneArgumentFunction");
		ElementList twoArgumentsFunction = new ElementList(4, "twoArgumentsFunction");
		OrList expression1 = new OrList(5, "expression1");
		ElementList expression2 = new ElementList(6, "expression2");
		ElementList expression3 = new ElementList(7, "expression3");
		ElementList expression = new ElementList(8, "expression");

		// integer = "0".."9"+
		integer.add(10, new Range(9, "integer", "0", "9"));

		// number = integer ["." integer]
		number.add(11, integer);
		Optional number_1 = new Optional(12, "number_1");
		number_1.add(14, new Str(13, "."));
		number_1.add(15, integer);
		number.add(16, number_1);

		// oneArgumentFunction =
		//   ("abs":abs | "acos":acos | "asin":asin | "atan":atan |
		//   "ceil":ceil | "cos":cos | "exp":exp | "floor":floor | "log":log |
		//   "rint":rint | "round":round | "sin":sin | "sqrt":sqrt |
		//   "tan":tan | "toDegrees":toDegrees | "toRadians":toRadians) "(" expression:argument ")"
		OrList oneArgumentFunction_1 = new OrList(17, "oneArgumentFunction_1");
		oneArgumentFunction_1.add(19, new Str(18, "abs", oneArgumentFunctionOneArgumentFunctionAbs));
		oneArgumentFunction_1.add(21, new Str(20, "acos", oneArgumentFunctionOneArgumentFunctionAcos));
		oneArgumentFunction_1.add(23, new Str(22, "asin", oneArgumentFunctionOneArgumentFunctionAsin));
		oneArgumentFunction_1.add(25, new Str(24, "atan", oneArgumentFunctionOneArgumentFunctionAtan));
		oneArgumentFunction_1.add(27, new Str(26, "ceil", oneArgumentFunctionOneArgumentFunctionCeil));
		oneArgumentFunction_1.add(29, new Str(28, "cos", oneArgumentFunctionOneArgumentFunctionCos));
		oneArgumentFunction_1.add(31, new Str(30, "exp", oneArgumentFunctionOneArgumentFunctionExp));
		oneArgumentFunction_1.add(33, new Str(32, "floor", oneArgumentFunctionOneArgumentFunctionFloor));
		oneArgumentFunction_1.add(35, new Str(34, "log", oneArgumentFunctionOneArgumentFunctionLog));
		oneArgumentFunction_1.add(37, new Str(36, "rint", oneArgumentFunctionOneArgumentFunctionRint));
		oneArgumentFunction_1.add(39, new Str(38, "round", oneArgumentFunctionOneArgumentFunctionRound));
		oneArgumentFunction_1.add(41, new Str(40, "sin", oneArgumentFunctionOneArgumentFunctionSin));
		oneArgumentFunction_1.add(43, new Str(42, "sqrt", oneArgumentFunctionOneArgumentFunctionSqrt));
		oneArgumentFunction_1.add(45, new Str(44, "tan", oneArgumentFunctionOneArgumentFunctionTan));
		oneArgumentFunction_1.add(47, new Str(46, "toDegrees", oneArgumentFunctionOneArgumentFunctionToDegrees));
		oneArgumentFunction_1.add(49, new Str(48, "toRadians", oneArgumentFunctionOneArgumentFunctionToRadians));
		oneArgumentFunction.add(50, oneArgumentFunction_1);
		oneArgumentFunction.add(52, new Str(51, "("));
		oneArgumentFunction.add(53, expression, oneArgumentFunctionOneArgumentFunctionArgument);
		oneArgumentFunction.add(55, new Str(54, ")"));

		// twoArgumentsFunction =
		//   ("atan2":atan2 | "IEEEremainder":ieeeRemainder | "max":max | "min":min |
		//   "pow":pow) "(" expression:arg1 "," expression:arg2 ")"
		OrList twoArgumentsFunction_1 = new OrList(56, "twoArgumentsFunction_1");
		twoArgumentsFunction_1.add(58, new Str(57, "atan2", twoArgumentsFunctionTwoArgumentsFunctionAtan2));
		twoArgumentsFunction_1.add(60, new Str(59, "IEEEremainder"));
		twoArgumentsFunction_1.add(62, new Str(61, "max", twoArgumentsFunctionTwoArgumentsFunctionMax));
		twoArgumentsFunction_1.add(64, new Str(63, "min", twoArgumentsFunctionTwoArgumentsFunctionMin));
		twoArgumentsFunction_1.add(66, new Str(65, "pow", twoArgumentsFunctionTwoArgumentsFunctionPow));
		twoArgumentsFunction.add(67, twoArgumentsFunction_1);
		twoArgumentsFunction.add(69, new Str(68, "("));
		twoArgumentsFunction.add(70, expression, twoArgumentsFunctionTwoArgumentsFunctionArg1);
		twoArgumentsFunction.add(72, new Str(71, ","));
		twoArgumentsFunction.add(73, expression, twoArgumentsFunctionTwoArgumentsFunctionArg2);
		twoArgumentsFunction.add(75, new Str(74, ")"));

		// expression1 = "random()":random | oneArgumentFunction | twoArgumentsFunction | number | ("(" expression ")")
		expression1.add(77, new Str(76, "random()", expression1Expression1Random));
		expression1.add(78, oneArgumentFunction, expression1Expression1OneArgumentFunction);
		expression1.add(79, twoArgumentsFunction, expression1Expression1TwoArgumentsFunction);
		expression1.add(80, number, expression1Expression1Number);
		ElementList expression1_1 = new ElementList(81, "expression1_1");
		expression1_1.add(83, new Str(82, "("));
		expression1_1.add(84, expression, expression1Expression1Expression);
		expression1_1.add(86, new Str(85, ")"));
		expression1.add(87, expression1_1);

		// expression2 = expression1 ["^":expo expression1]+
		expression2.add(88, expression1, expression2Expression2Expression1);
		Optional expression2_1 = new Optional(89, "expression2_1");
		Repeat expression2_1_1 = new Repeat(90, "expression2_1_1");
		expression2_1_1.add(92, new Str(91, "^", expression2Expression2Expo));
		expression2_1_1.add(93, expression1, expression2Expression2Expression1);
		expression2_1.add(94, expression2_1_1);
		expression2.add(95, expression2_1);

		// expression3 = :plus expression2 ["*":mul | "/":div | "%":mod expression2]+
		expression3.add(97, new Marker(96, "plus", expression3Expression3Plus));
		expression3.add(98, expression2, expression3Expression3Expression2);
		Optional expression3_1 = new Optional(99, "expression3_1");
		Repeat expression3_1_1 = new Repeat(100, "expression3_1_1");
		OrList expression3_1_1_1 = new OrList(101, "expression3_1_1_1");
		expression3_1_1_1.add(103, new Str(102, "*", expression3Expression3Mul));
		expression3_1_1_1.add(105, new Str(104, "/", expression3Expression3Div));
		expression3_1_1_1.add(107, new Str(106, "%", expression3Expression3Mod));
		expression3_1_1.add(108, expression3_1_1_1);
		expression3_1_1.add(109, expression2, expression3Expression3Expression2);
		expression3_1.add(110, expression3_1_1);
		expression3.add(111, expression3_1);

		// expression = expression3 ["+":plus | "-":minus expression3]+
		expression.add(112, expression3, expressionExpressionExpression3);
		Optional expression_1 = new Optional(113, "expression_1");
		Repeat expression_1_1 = new Repeat(114, "expression_1_1");
		OrList expression_1_1_1 = new OrList(115, "expression_1_1_1");
		expression_1_1_1.add(117, new Str(116, "+", expressionExpressionPlus));
		expression_1_1_1.add(119, new Str(118, "-", expressionExpressionMinus));
		expression_1_1.add(120, expression_1_1_1);
		expression_1_1.add(121, expression3, expressionExpressionExpression3);
		expression_1.add(122, expression_1_1);
		expression.add(123, expression_1);


		return new TopElement(data2, expression);
	}

	private net.sf.laja.parser.engine2.element.Element getGrammar1() {
		// *** Output classes ***

		// *** Declarations and Statements ***
		Repeat integer = new Repeat(1, "integer");
		ElementList number = new ElementList(2, "number");
		ElementList oneArgumentFunction = new ElementList(3, "oneArgumentFunction");
		ElementList twoArgumentsFunction = new ElementList(4, "twoArgumentsFunction");
		OrList expression1 = new OrList(5, "expression1");
		ElementList expression2 = new ElementList(6, "expression2");
		ElementList expression3 = new ElementList(7, "expression3");
		ElementList expression = new ElementList(8, "expression");

		// integer = "0".."9"+
		integer.add(10, new Range(9, "integer", "0", "9"));

		// number = integer ["." integer]
		number.add(11, integer);
		Optional number_1 = new Optional(12, "number_1");
		number_1.add(14, new Str(13, "."));
		number_1.add(15, integer);
		number.add(16, number_1);

		// oneArgumentFunction =
		//   ("abs":abs | "acos":acos | "asin":asin | "atan":atan |
		//   "ceil":ceil | "cos":cos | "exp":exp | "floor":floor | "log":log |
		//   "rint":rint | "round":round | "sin":sin | "sqrt":sqrt |
		//   "tan":tan | "toDegrees":toDegrees | "toRadians":toRadians) "(" expression:argument ")"
		OrList oneArgumentFunction_1 = new OrList(17, "oneArgumentFunction_1");
		oneArgumentFunction_1.add(19, new Str(18, "abs"));
		oneArgumentFunction_1.add(21, new Str(20, "acos"));
		oneArgumentFunction_1.add(23, new Str(22, "asin"));
		oneArgumentFunction_1.add(25, new Str(24, "atan"));
		oneArgumentFunction_1.add(27, new Str(26, "ceil"));
		oneArgumentFunction_1.add(29, new Str(28, "cos"));
		oneArgumentFunction_1.add(31, new Str(30, "exp"));
		oneArgumentFunction_1.add(33, new Str(32, "floor"));
		oneArgumentFunction_1.add(35, new Str(34, "log"));
		oneArgumentFunction_1.add(37, new Str(36, "rint"));
		oneArgumentFunction_1.add(39, new Str(38, "round"));
		oneArgumentFunction_1.add(41, new Str(40, "sin"));
		oneArgumentFunction_1.add(43, new Str(42, "sqrt"));
		oneArgumentFunction_1.add(45, new Str(44, "tan"));
		oneArgumentFunction_1.add(47, new Str(46, "toDegrees"));
		oneArgumentFunction_1.add(49, new Str(48, "toRadians"));
		oneArgumentFunction.add(50, oneArgumentFunction_1);
		oneArgumentFunction.add(52, new Str(51, "("));
		oneArgumentFunction.add(53, expression);
		oneArgumentFunction.add(55, new Str(54, ")"));

		// twoArgumentsFunction =
		//   ("atan2":atan2 | "IEEEremainder":ieeeRemainder | "max":max | "min":min |
		//   "pow":pow) "(" expression:arg1 "," expression:arg2 ")"
		OrList twoArgumentsFunction_1 = new OrList(56, "twoArgumentsFunction_1");
		twoArgumentsFunction_1.add(58, new Str(57, "atan2"));
		twoArgumentsFunction_1.add(60, new Str(59, "IEEEremainder"));
		twoArgumentsFunction_1.add(62, new Str(61, "max"));
		twoArgumentsFunction_1.add(64, new Str(63, "min"));
		twoArgumentsFunction_1.add(66, new Str(65, "pow"));
		twoArgumentsFunction.add(67, twoArgumentsFunction_1);
		twoArgumentsFunction.add(69, new Str(68, "("));
		twoArgumentsFunction.add(70, expression);
		twoArgumentsFunction.add(72, new Str(71, ","));
		twoArgumentsFunction.add(73, expression);
		twoArgumentsFunction.add(75, new Str(74, ")"));

		// expression1 = "random()":random | oneArgumentFunction | twoArgumentsFunction | number | ("(" expression ")")
		expression1.add(77, new Str(76, "random()"));
		expression1.add(78, oneArgumentFunction);
		expression1.add(79, twoArgumentsFunction);
		expression1.add(80, number);
		ElementList expression1_1 = new ElementList(81, "expression1_1");
		expression1_1.add(83, new Str(82, "("));
		expression1_1.add(84, expression);
		expression1_1.add(86, new Str(85, ")"));
		expression1.add(87, expression1_1);

		// expression2 = expression1 ["^":expo expression1]+
		expression2.add(88, expression1);
		Optional expression2_1 = new Optional(89, "expression2_1");
		Repeat expression2_1_1 = new Repeat(90, "expression2_1_1");
		expression2_1_1.add(92, new Str(91, "^"));
		expression2_1_1.add(93, expression1);
		expression2_1.add(94, expression2_1_1);
		expression2.add(95, expression2_1);

		// expression3 = :plus expression2 ["*":mul | "/":div | "%":mod expression2]+
		expression3.add(97, new Marker(96, "plus"));
		expression3.add(98, expression2);
		Optional expression3_1 = new Optional(99, "expression3_1");
		Repeat expression3_1_1 = new Repeat(100, "expression3_1_1");
		OrList expression3_1_1_1 = new OrList(101, "expression3_1_1_1");
		expression3_1_1_1.add(103, new Str(102, "*"));
		expression3_1_1_1.add(105, new Str(104, "/"));
		expression3_1_1_1.add(107, new Str(106, "%"));
		expression3_1_1.add(108, expression3_1_1_1);
		expression3_1_1.add(109, expression2);
		expression3_1.add(110, expression3_1_1);
		expression3.add(111, expression3_1);

		// expression = expression3 ["+":plus | "-":minus expression3]+
		expression.add(112, expression3);
		Optional expression_1 = new Optional(113, "expression_1");
		Repeat expression_1_1 = new Repeat(114, "expression_1_1");
		OrList expression_1_1_1 = new OrList(115, "expression_1_1_1");
		expression_1_1_1.add(117, new Str(116, "+"));
		expression_1_1_1.add(119, new Str(118, "-"));
		expression_1_1.add(120, expression_1_1_1);
		expression_1_1.add(121, expression3);
		expression_1.add(122, expression_1_1);
		expression.add(123, expression_1);


		return new TopElement(data1, expression);
	}

	// *** TopElement ***
	public static class TopElement implements net.sf.laja.parser.engine2.element.Element {
		private Data data;
		private net.sf.laja.parser.engine2.element.Element element;

		public TopElement(Data data, net.sf.laja.parser.engine2.element.Element element) {
			this.data = data;
			this.element = element;
		}
		public int getId() { return element.getId(); }
		public String getName() { return element.getName(); }
		public String getString() { return element.getString(); }
		public String getIdName() { return element.getIdName(); }
		public boolean isTerminal() { return element.isTerminal(); }
		public boolean isOptional() { return false; }
		public boolean parse(int level, Source source, boolean parentNot, boolean caseSensitive, boolean receive) {
			data.pushExpression();
			boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
			data.popExpression();
			return match;
		}
	}

	// *** IExpressionFactoryFactory
	public interface IExpressionFactoryFactory {
		public IExpressionFactory getFactory(int phase);
	}

	// *** IExpressionFactory ***
	public interface IExpressionFactory {
		ExpressionParser.IOneArgumentFunction createOneArgumentFunction();
		ExpressionParser.ITwoArgumentsFunction createTwoArgumentsFunction();
		ExpressionParser.IExpression1 createExpression1();
		ExpressionParser.IExpression2 createExpression2();
		ExpressionParser.IExpression3 createExpression3();
		ExpressionParser.IExpression createExpression();
	}

	// *** Interfaces ***
	// OneArgumentFunction
	public interface IOneArgumentFunction {
		public void setFunctionAbs();
		public void setFunctionAcos();
		public void setFunctionAsin();
		public void setFunctionAtan();
		public void setFunctionCeil();
		public void setFunctionCos();
		public void setFunctionExp();
		public void setFunctionFloor();
		public void setFunctionLog();
		public void setFunctionRint();
		public void setFunctionRound();
		public void setFunctionSin();
		public void setFunctionSqrt();
		public void setFunctionTan();
		public void setFunctionToDegrees();
		public void setFunctionToRadians();
		public void setExpression(IExpression iargument);
	}

	// TwoArgumentsFunction
	public interface ITwoArgumentsFunction {
		public void setFunctionAtan2();
		public void setFunctionMax();
		public void setFunctionMin();
		public void setFunctionPow();
		public void setArg1(IExpression iarg1);
		public void setArg2(IExpression iarg2);
	}

	// Expression1
	public interface IExpression1 {
		public void setRandom();
		public void setOneArgumentFunction(IOneArgumentFunction ioneArgumentFunction);
		public void setTwoArgumentsFunction(ITwoArgumentsFunction itwoArgumentsFunction);
		public void setNumber(String number);
		public void setExpression(IExpression iexpression);
	}

	// Expression2
	public interface IExpression2 {
		public void setExpression1(IExpression1 iexpression1);
		public void setExpo();
	}

	// Expression3
	public interface IExpression3 {
		public void setExpression2(IExpression2 iexpression2);
		public void setOperatorPlus();
		public void setOperatorMul();
		public void setOperatorDiv();
		public void setOperatorMod();
	}

	// Expression
	public interface IExpression {
		public void setExpression3(IExpression3 iexpression3);
		public void setOperatorPlus();
		public void setOperatorMinus();
	}

	// *** Data ***
	public static final class Data {
		private ExpressionParser.IExpressionFactory factory;
		private Stack<IOneArgumentFunction> oneArgumentFunctionStack = new Stack<IOneArgumentFunction>();
		private Stack<ITwoArgumentsFunction> twoArgumentsFunctionStack = new Stack<ITwoArgumentsFunction>();
		private Stack<IExpression1> expression1Stack = new Stack<IExpression1>();
		private Stack<IExpression2> expression2Stack = new Stack<IExpression2>();
		private Stack<IExpression3> expression3Stack = new Stack<IExpression3>();
		private Stack<IExpression> expressionStack = new Stack<IExpression>();

		public Data(ExpressionParser.IExpressionFactory factory) {
			this.factory = factory;
		}

		// OneArgumentFunction
		public void pushOneArgumentFunction() { oneArgumentFunctionStack.push(factory.createOneArgumentFunction()); }
		public ExpressionParser.IOneArgumentFunction popOneArgumentFunction() { return (ExpressionParser.IOneArgumentFunction)oneArgumentFunctionStack.pop(); }
		public ExpressionParser.IOneArgumentFunction peekOneArgumentFunction() {
			if (oneArgumentFunctionStack.empty()) { return null; }
			return oneArgumentFunctionStack.peek();
		}

		// TwoArgumentsFunction
		public void pushTwoArgumentsFunction() { twoArgumentsFunctionStack.push(factory.createTwoArgumentsFunction()); }
		public ExpressionParser.ITwoArgumentsFunction popTwoArgumentsFunction() { return (ExpressionParser.ITwoArgumentsFunction)twoArgumentsFunctionStack.pop(); }
		public ExpressionParser.ITwoArgumentsFunction peekTwoArgumentsFunction() {
			if (twoArgumentsFunctionStack.empty()) { return null; }
			return twoArgumentsFunctionStack.peek();
		}

		// Expression1
		public void pushExpression1() { expression1Stack.push(factory.createExpression1()); }
		public ExpressionParser.IExpression1 popExpression1() { return (ExpressionParser.IExpression1)expression1Stack.pop(); }
		public ExpressionParser.IExpression1 peekExpression1() {
			if (expression1Stack.empty()) { return null; }
			return expression1Stack.peek();
		}

		// Expression2
		public void pushExpression2() { expression2Stack.push(factory.createExpression2()); }
		public ExpressionParser.IExpression2 popExpression2() { return (ExpressionParser.IExpression2)expression2Stack.pop(); }
		public ExpressionParser.IExpression2 peekExpression2() {
			if (expression2Stack.empty()) { return null; }
			return expression2Stack.peek();
		}

		// Expression3
		public void pushExpression3() { expression3Stack.push(factory.createExpression3()); }
		public ExpressionParser.IExpression3 popExpression3() { return (ExpressionParser.IExpression3)expression3Stack.pop(); }
		public ExpressionParser.IExpression3 peekExpression3() {
			if (expression3Stack.empty()) { return null; }
			return expression3Stack.peek();
		}

		// Expression
		public void pushExpression() { expressionStack.push(factory.createExpression()); }
		public ExpressionParser.IExpression popExpression() { return (ExpressionParser.IExpression)expressionStack.pop(); }
		public ExpressionParser.IExpression peekExpression() {
			if (expressionStack.empty()) { return null; }
			return expressionStack.peek();
		}

		// OneArgumentFunction oneArgumentFunction.setFunctionAbs(void abs);
		public class OneArgumentFunctionOneArgumentFunctionAbs implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionAbs(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionAbs();
			}
		}

		// oneArgumentFunction.setFunctionAcos(void acos);
		public class OneArgumentFunctionOneArgumentFunctionAcos implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionAcos(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionAcos();
			}
		}

		// oneArgumentFunction.setFunctionAsin(void asin);
		public class OneArgumentFunctionOneArgumentFunctionAsin implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionAsin(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionAsin();
			}
		}

		// oneArgumentFunction.setFunctionAtan(void atan);
		public class OneArgumentFunctionOneArgumentFunctionAtan implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionAtan(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionAtan();
			}
		}

		// oneArgumentFunction.setFunctionCeil(void ceil);
		public class OneArgumentFunctionOneArgumentFunctionCeil implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionCeil(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionCeil();
			}
		}

		// oneArgumentFunction.setFunctionCos(void cos);
		public class OneArgumentFunctionOneArgumentFunctionCos implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionCos(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionCos();
			}
		}

		// oneArgumentFunction.setFunctionExp(void exp);
		public class OneArgumentFunctionOneArgumentFunctionExp implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionExp(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionExp();
			}
		}

		// oneArgumentFunction.setFunctionFloor(void floor);
		public class OneArgumentFunctionOneArgumentFunctionFloor implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionFloor(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionFloor();
			}
		}

		// oneArgumentFunction.setFunctionLog(void log);
		public class OneArgumentFunctionOneArgumentFunctionLog implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionLog(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionLog();
			}
		}

		// oneArgumentFunction.setFunctionRint(void rint);
		public class OneArgumentFunctionOneArgumentFunctionRint implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionRint(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionRint();
			}
		}

		// oneArgumentFunction.setFunctionRound(void round);
		public class OneArgumentFunctionOneArgumentFunctionRound implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionRound(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionRound();
			}
		}

		// oneArgumentFunction.setFunctionSin(void sin);
		public class OneArgumentFunctionOneArgumentFunctionSin implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionSin(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionSin();
			}
		}

		// oneArgumentFunction.setFunctionSqrt(void sqrt);
		public class OneArgumentFunctionOneArgumentFunctionSqrt implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionSqrt(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionSqrt();
			}
		}

		// oneArgumentFunction.setFunctionTan(void tan);
		public class OneArgumentFunctionOneArgumentFunctionTan implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionTan(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionTan();
			}
		}

		// oneArgumentFunction.setFunctionToDegrees(void toDegrees);
		public class OneArgumentFunctionOneArgumentFunctionToDegrees implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionToDegrees(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionToDegrees();
			}
		}

		// oneArgumentFunction.setFunctionToRadians(void toRadians);
		public class OneArgumentFunctionOneArgumentFunctionToRadians implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionToRadians(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setFunctionToRadians();
			}
		}

		// oneArgumentFunction.setExpression(Expression argument);
		public class OneArgumentFunctionOneArgumentFunctionArgument implements Output {
			private String name;
			public OneArgumentFunctionOneArgumentFunctionArgument(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { pushExpression(); }
			public void set(Source source, int bookmark) {
				peekOneArgumentFunction().setExpression(popExpression());
			}
		}

		// TwoArgumentsFunction twoArgumentsFunction.setFunctionAtan2(void atan2);
		public class TwoArgumentsFunctionTwoArgumentsFunctionAtan2 implements Output {
			private String name;
			public TwoArgumentsFunctionTwoArgumentsFunctionAtan2(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTwoArgumentsFunction().setFunctionAtan2();
			}
		}

		// twoArgumentsFunction.setFunctionMax(void max);
		public class TwoArgumentsFunctionTwoArgumentsFunctionMax implements Output {
			private String name;
			public TwoArgumentsFunctionTwoArgumentsFunctionMax(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTwoArgumentsFunction().setFunctionMax();
			}
		}

		// twoArgumentsFunction.setFunctionMin(void min);
		public class TwoArgumentsFunctionTwoArgumentsFunctionMin implements Output {
			private String name;
			public TwoArgumentsFunctionTwoArgumentsFunctionMin(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTwoArgumentsFunction().setFunctionMin();
			}
		}

		// twoArgumentsFunction.setFunctionPow(void pow);
		public class TwoArgumentsFunctionTwoArgumentsFunctionPow implements Output {
			private String name;
			public TwoArgumentsFunctionTwoArgumentsFunctionPow(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTwoArgumentsFunction().setFunctionPow();
			}
		}

		// twoArgumentsFunction.setArg1(Expression arg1);
		public class TwoArgumentsFunctionTwoArgumentsFunctionArg1 implements Output {
			private String name;
			public TwoArgumentsFunctionTwoArgumentsFunctionArg1(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { pushExpression(); }
			public void set(Source source, int bookmark) {
				peekTwoArgumentsFunction().setArg1(popExpression());
			}
		}

		// twoArgumentsFunction.setArg2(Expression arg2);
		public class TwoArgumentsFunctionTwoArgumentsFunctionArg2 implements Output {
			private String name;
			public TwoArgumentsFunctionTwoArgumentsFunctionArg2(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { pushExpression(); }
			public void set(Source source, int bookmark) {
				peekTwoArgumentsFunction().setArg2(popExpression());
			}
		}

		// Expression1 expression1.setRandom(void random);
		public class Expression1Expression1Random implements Output {
			private String name;
			public Expression1Expression1Random(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekExpression1().setRandom();
			}
		}

		// expression1.setOneArgumentFunction(OneArgumentFunction oneArgumentFunction);
		public class Expression1Expression1OneArgumentFunction implements Output {
			private String name;
			public Expression1Expression1OneArgumentFunction(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { pushOneArgumentFunction(); }
			public void set(Source source, int bookmark) {
				peekExpression1().setOneArgumentFunction(popOneArgumentFunction());
			}
		}

		// expression1.setTwoArgumentsFunction(TwoArgumentsFunction twoArgumentsFunction);
		public class Expression1Expression1TwoArgumentsFunction implements Output {
			private String name;
			public Expression1Expression1TwoArgumentsFunction(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { pushTwoArgumentsFunction(); }
			public void set(Source source, int bookmark) {
				peekExpression1().setTwoArgumentsFunction(popTwoArgumentsFunction());
			}
		}

		// expression1.setNumber(String number);
		public class Expression1Expression1Number implements Output {
			private String name;
			public Expression1Expression1Number(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekExpression1().setNumber(source.get(bookmark));
			}
		}

		// expression1.setExpression(Expression expression);
		public class Expression1Expression1Expression implements Output {
			private String name;
			public Expression1Expression1Expression(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { pushExpression(); }
			public void set(Source source, int bookmark) {
				peekExpression1().setExpression(popExpression());
			}
		}

		// Expression2 expression2.setExpression1(Expression1 expression1);
		public class Expression2Expression2Expression1 implements Output {
			private String name;
			public Expression2Expression2Expression1(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { pushExpression1(); }
			public void set(Source source, int bookmark) {
				peekExpression2().setExpression1(popExpression1());
			}
		}

		// expression2.setExpo(void expo);
		public class Expression2Expression2Expo implements Output {
			private String name;
			public Expression2Expression2Expo(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekExpression2().setExpo();
			}
		}

		// expression3.setOperatorPlus(void plus);
		public class Expression3Expression3Plus implements Output {
			private String name;
			public Expression3Expression3Plus(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekExpression3().setOperatorPlus();
			}
		}

		// Expression3 expression3.setExpression2(Expression2 expression2);
		public class Expression3Expression3Expression2 implements Output {
			private String name;
			public Expression3Expression3Expression2(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { pushExpression2(); }
			public void set(Source source, int bookmark) {
				peekExpression3().setExpression2(popExpression2());
			}
		}

		// expression3.setOperatorMul(void mul);
		public class Expression3Expression3Mul implements Output {
			private String name;
			public Expression3Expression3Mul(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekExpression3().setOperatorMul();
			}
		}

		// expression3.setOperatorDiv(void div);
		public class Expression3Expression3Div implements Output {
			private String name;
			public Expression3Expression3Div(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekExpression3().setOperatorDiv();
			}
		}

		// expression3.setOperatorMod(void mod);
		public class Expression3Expression3Mod implements Output {
			private String name;
			public Expression3Expression3Mod(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekExpression3().setOperatorMod();
			}
		}

		// Expression expression.setExpression3(Expression3 expression3);
		public class ExpressionExpressionExpression3 implements Output {
			private String name;
			public ExpressionExpressionExpression3(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { pushExpression3(); }
			public void set(Source source, int bookmark) {
				peekExpression().setExpression3(popExpression3());
			}
		}

		// expression.setOperatorPlus(void plus);
		public class ExpressionExpressionPlus implements Output {
			private String name;
			public ExpressionExpressionPlus(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekExpression().setOperatorPlus();
			}
		}

		// expression.setOperatorMinus(void minus);
		public class ExpressionExpressionMinus implements Output {
			private String name;
			public ExpressionExpressionMinus(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekExpression().setOperatorMinus();
			}
		}
	}
}
