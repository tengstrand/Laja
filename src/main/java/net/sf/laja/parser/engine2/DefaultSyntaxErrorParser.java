package net.sf.laja.parser.engine2;

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
public final class DefaultSyntaxErrorParser implements net.sf.laja.parser.engine2.Parser {
	private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
	private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
	private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

	private Data data1;
	private Data data2;
	private IDefaultSyntaxErrorFactory factory1;
	private IDefaultSyntaxErrorFactory factory2;
	private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
	private SyntaxErrorHandler syntaxErrorHandler;

	public static final int PHASE1 = 1;
	public static final int PHASE2 = 2;

	public DefaultSyntaxErrorParser(IDefaultSyntaxErrorFactoryFactory factoryFactory) {
		init(factoryFactory);
	}

	public void init(IDefaultSyntaxErrorFactoryFactory factoryFactory) {
		syntaxErrorHandler = new DefaultSyntaxErrorHandler();
		factory1 = factoryFactory.getFactory(PHASE1);
		factory2 = factoryFactory.getFactory(PHASE2);
		data1 = new Data(factory1);
		data2 = new Data(factory2);
	}

	public DefaultSyntaxErrorParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
		sourceRecorderLogWriter = writer;
		return this;
	}

	public DefaultSyntaxErrorParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
		this.syntaxErrorHandler = syntaxErrorHandler;
		return this;
	}

	public IDefaultSyntaxErrorFactory getFactory1() {
		return factory1;
	}

	public IDefaultSyntaxErrorFactory getFactory() {
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
		Data.DefaultSyntaxErrorRowContent defaultSyntaxErrorRowContent = data2.new DefaultSyntaxErrorRowContent("defaultSyntaxErrorRowContent");
		Data.DefaultSyntaxErrorDefaultSyntaxErrorLine defaultSyntaxErrorDefaultSyntaxErrorLine = data2.new DefaultSyntaxErrorDefaultSyntaxErrorLine("defaultSyntaxErrorDefaultSyntaxErrorLine");

		// *** Declarations and Statements ***
		OrList cr = new OrList(1, "cr");
		ElementList row = new ElementList(2, "row");
		ElementList defaultSyntaxError = new ElementList(3, "defaultSyntaxError");

		// cr = "\r\n" | "\n"
		cr.add(5, new Str(4, "\r\n"));
		cr.add(7, new Str(6, "\n"));

		// row = [!cr+]:content cr
		Optional row_1 = new Optional(8, "row_1", defaultSyntaxErrorRowContent);
		Repeat row_1_1 = new Repeat(9, "row_1_1");
		row_1_1.add(10, cr, NOT);
		row_1.add(11, row_1_1);
		row.add(12, row_1);
		row.add(13, cr);

		// defaultSyntaxError = [row+] [!END+]:line END
		Optional defaultSyntaxError_1 = new Optional(14, "defaultSyntaxError_1");
		Repeat defaultSyntaxError_1_1 = new Repeat(15, "defaultSyntaxError_1_1");
		defaultSyntaxError_1_1.add(16, row);
		defaultSyntaxError_1.add(17, defaultSyntaxError_1_1);
		defaultSyntaxError.add(18, defaultSyntaxError_1);
		Optional defaultSyntaxError_2 = new Optional(19, "defaultSyntaxError_2", defaultSyntaxErrorDefaultSyntaxErrorLine);
		Repeat defaultSyntaxError_2_1 = new Repeat(20, "defaultSyntaxError_2_1");
		defaultSyntaxError_2_1.add(22, new End(21, "defaultSyntaxError_2_1", NOT));
		defaultSyntaxError_2.add(23, defaultSyntaxError_2_1);
		defaultSyntaxError.add(24, defaultSyntaxError_2);
		defaultSyntaxError.add(26, new End(25, "defaultSyntaxError"));


		return new TopElement(data2, defaultSyntaxError);
	}

	private net.sf.laja.parser.engine2.element.Element getGrammar1() {
		// *** Output classes ***

		// *** Declarations and Statements ***
		OrList cr = new OrList(1, "cr");
		ElementList row = new ElementList(2, "row");
		ElementList defaultSyntaxError = new ElementList(3, "defaultSyntaxError");

		// cr = "\r\n" | "\n"
		cr.add(5, new Str(4, "\r\n"));
		cr.add(7, new Str(6, "\n"));

		// row = [!cr+]:content cr
		Optional row_1 = new Optional(8, "row_1");
		Repeat row_1_1 = new Repeat(9, "row_1_1");
		row_1_1.add(10, cr, NOT);
		row_1.add(11, row_1_1);
		row.add(12, row_1);
		row.add(13, cr);

		// defaultSyntaxError = [row+] [!END+]:line END
		Optional defaultSyntaxError_1 = new Optional(14, "defaultSyntaxError_1");
		Repeat defaultSyntaxError_1_1 = new Repeat(15, "defaultSyntaxError_1_1");
		defaultSyntaxError_1_1.add(16, row);
		defaultSyntaxError_1.add(17, defaultSyntaxError_1_1);
		defaultSyntaxError.add(18, defaultSyntaxError_1);
		Optional defaultSyntaxError_2 = new Optional(19, "defaultSyntaxError_2");
		Repeat defaultSyntaxError_2_1 = new Repeat(20, "defaultSyntaxError_2_1");
		defaultSyntaxError_2_1.add(22, new End(21, "defaultSyntaxError_2_1", NOT));
		defaultSyntaxError_2.add(23, defaultSyntaxError_2_1);
		defaultSyntaxError.add(24, defaultSyntaxError_2);
		defaultSyntaxError.add(26, new End(25, "defaultSyntaxError"));


		return new TopElement(data1, defaultSyntaxError);
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
			data.pushDefaultSyntaxError();
			boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
			data.popDefaultSyntaxError();
			return match;
		}
	}

	// *** IDefaultSyntaxErrorFactoryFactory
	public interface IDefaultSyntaxErrorFactoryFactory {
		public IDefaultSyntaxErrorFactory getFactory(int phase);
	}

	// *** IDefaultSyntaxErrorFactory ***
	public interface IDefaultSyntaxErrorFactory {
		DefaultSyntaxErrorParser.IDefaultSyntaxError createDefaultSyntaxError();
	}

	// *** Interfaces ***
	// DefaultSyntaxError
	public interface IDefaultSyntaxError {
		public void setRow(String content, Index idx);
		public void setLine(String line, Index idx);
	}

	// *** Data ***
	public static final class Data {
		private DefaultSyntaxErrorParser.IDefaultSyntaxErrorFactory factory;
		private Stack<IDefaultSyntaxError> defaultSyntaxErrorStack = new Stack<IDefaultSyntaxError>();

		public Data(DefaultSyntaxErrorParser.IDefaultSyntaxErrorFactory factory) {
			this.factory = factory;
		}

		// DefaultSyntaxError
		public void pushDefaultSyntaxError() { defaultSyntaxErrorStack.push(factory.createDefaultSyntaxError()); }
		public DefaultSyntaxErrorParser.IDefaultSyntaxError popDefaultSyntaxError() { return (DefaultSyntaxErrorParser.IDefaultSyntaxError)defaultSyntaxErrorStack.pop(); }
		public DefaultSyntaxErrorParser.IDefaultSyntaxError peekDefaultSyntaxError() {
			if (defaultSyntaxErrorStack.empty()) { return null; }
			return defaultSyntaxErrorStack.peek();
		}

		// DefaultSyntaxError defaultSyntaxError.setRow(String row.content, Index idx);
		public class DefaultSyntaxErrorRowContent implements Output {
			private String name;
			public DefaultSyntaxErrorRowContent(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekDefaultSyntaxError().setRow(source.get(bookmark), source.getIndex(bookmark));
			}
		}

		// defaultSyntaxError.setLine(String line, Index idx);
		public class DefaultSyntaxErrorDefaultSyntaxErrorLine implements Output {
			private String name;
			public DefaultSyntaxErrorDefaultSyntaxErrorLine(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekDefaultSyntaxError().setLine(source.get(bookmark), source.getIndex(bookmark));
			}
		}
	}
}
