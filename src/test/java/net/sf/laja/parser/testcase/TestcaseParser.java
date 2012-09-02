package net.sf.laja.parser.testcase;

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
public final class TestcaseParser implements net.sf.laja.parser.engine2.Parser {
	private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
	private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
	private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

	private Data data1;
	private Data data2;
	private ITestcaseFactory factory1;
	private ITestcaseFactory factory2;
	private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
	private SyntaxErrorHandler syntaxErrorHandler;

	public static final int PHASE1 = 1;
	public static final int PHASE2 = 2;

	public TestcaseParser(ITestcaseFactoryFactory factoryFactory) {
		init(factoryFactory);
	}

	public void init(ITestcaseFactoryFactory factoryFactory) {
		syntaxErrorHandler = new DefaultSyntaxErrorHandler();
		factory1 = factoryFactory.getFactory(PHASE1);
		factory2 = factoryFactory.getFactory(PHASE2);
		data1 = new Data(factory1);
		data2 = new Data(factory2);
	}

	public TestcaseParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
		sourceRecorderLogWriter = writer;
		return this;
	}

	public TestcaseParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
		this.syntaxErrorHandler = syntaxErrorHandler;
		return this;
	}

	public ITestcaseFactory getFactory1() {
		return factory1;
	}

	public ITestcaseFactory getFactory() {
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
		Data.TestcaseT121Ab testcaseT121Ab = data2.new TestcaseT121Ab("testcaseT121Ab");
		Data.TestcaseT122Ab testcaseT122Ab = data2.new TestcaseT122Ab("testcaseT122Ab");
		Data.TestcaseT131X testcaseT131X = data2.new TestcaseT131X("testcaseT131X");
		Data.TestcaseT131Ab testcaseT131Ab = data2.new TestcaseT131Ab("testcaseT131Ab");
		Data.TestcaseT132X testcaseT132X = data2.new TestcaseT132X("testcaseT132X");
		Data.TestcaseT133X testcaseT133X = data2.new TestcaseT133X("testcaseT133X");
		Data.TestcaseT134X testcaseT134X = data2.new TestcaseT134X("testcaseT134X");
		Data.TestcaseT165X testcaseT165X = data2.new TestcaseT165X("testcaseT165X");
		Data.TestcaseT111Ab testcaseT111Ab = data2.new TestcaseT111Ab("testcaseT111Ab");
		Data.TestcaseT112Ab testcaseT112Ab = data2.new TestcaseT112Ab("testcaseT112Ab");
		Data.TestcaseT113Ab testcaseT113Ab = data2.new TestcaseT113Ab("testcaseT113Ab");
		Data.TestcaseT114Notab testcaseT114Notab = data2.new TestcaseT114Notab("testcaseT114Notab");
		Data.TestcaseT123Ab testcaseT123Ab = data2.new TestcaseT123Ab("testcaseT123Ab");
		Data.TestcaseT124Notab testcaseT124Notab = data2.new TestcaseT124Notab("testcaseT124Notab");
		Data.TestcaseT132A testcaseT132A = data2.new TestcaseT132A("testcaseT132A");
		Data.TestcaseT141X testcaseT141X = data2.new TestcaseT141X("testcaseT141X");
		Data.TestcaseT141Notab testcaseT141Notab = data2.new TestcaseT141Notab("testcaseT141Notab");
		Data.TestcaseT141Ab testcaseT141Ab = data2.new TestcaseT141Ab("testcaseT141Ab");
		Data.TestcaseT142X testcaseT142X = data2.new TestcaseT142X("testcaseT142X");
		Data.TestcaseT142A testcaseT142A = data2.new TestcaseT142A("testcaseT142A");
		Data.TestcaseT143X testcaseT143X = data2.new TestcaseT143X("testcaseT143X");
		Data.TestcaseT143Notab testcaseT143Notab = data2.new TestcaseT143Notab("testcaseT143Notab");
		Data.TestcaseT143Ab testcaseT143Ab = data2.new TestcaseT143Ab("testcaseT143Ab");
		Data.TestcaseT144X testcaseT144X = data2.new TestcaseT144X("testcaseT144X");
		Data.TestcaseT144A testcaseT144A = data2.new TestcaseT144A("testcaseT144A");
		Data.TestcaseT151Ab testcaseT151Ab = data2.new TestcaseT151Ab("testcaseT151Ab");
		Data.TestcaseT152Notab testcaseT152Notab = data2.new TestcaseT152Notab("testcaseT152Notab");
		Data.TestcaseT153Ab testcaseT153Ab = data2.new TestcaseT153Ab("testcaseT153Ab");
		Data.TestcaseT154Notab testcaseT154Notab = data2.new TestcaseT154Notab("testcaseT154Notab");
		Data.TestcaseT161Ab testcaseT161Ab = data2.new TestcaseT161Ab("testcaseT161Ab");
		Data.TestcaseT162Notab testcaseT162Notab = data2.new TestcaseT162Notab("testcaseT162Notab");
		Data.TestcaseT163Ab testcaseT163Ab = data2.new TestcaseT163Ab("testcaseT163Ab");
		Data.TestcaseT164Notab testcaseT164Notab = data2.new TestcaseT164Notab("testcaseT164Notab");
		Data.TestcaseT211Ab testcaseT211Ab = data2.new TestcaseT211Ab("testcaseT211Ab");
		Data.TestcaseT211Cd testcaseT211Cd = data2.new TestcaseT211Cd("testcaseT211Cd");
		Data.TestcaseT212Ab testcaseT212Ab = data2.new TestcaseT212Ab("testcaseT212Ab");
		Data.TestcaseT212Cd testcaseT212Cd = data2.new TestcaseT212Cd("testcaseT212Cd");
		Data.TestcaseT213Ab testcaseT213Ab = data2.new TestcaseT213Ab("testcaseT213Ab");
		Data.TestcaseT213Cd testcaseT213Cd = data2.new TestcaseT213Cd("testcaseT213Cd");
		Data.TestcaseT214Ab testcaseT214Ab = data2.new TestcaseT214Ab("testcaseT214Ab");
		Data.TestcaseT214Cd testcaseT214Cd = data2.new TestcaseT214Cd("testcaseT214Cd");
		Data.TestcaseT311A testcaseT311A = data2.new TestcaseT311A("testcaseT311A");
		Data.TestcaseT312A testcaseT312A = data2.new TestcaseT312A("testcaseT312A");
		Data.TestcaseT313T313a testcaseT313T313a = data2.new TestcaseT313T313a("testcaseT313T313a");
		Data.TestcaseT411X testcaseT411X = data2.new TestcaseT411X("testcaseT411X");
		Data.TestcaseT411A testcaseT411A = data2.new TestcaseT411A("testcaseT411A");
		Data.TestcaseT411Y testcaseT411Y = data2.new TestcaseT411Y("testcaseT411Y");
		Data.TestcaseT511T511a testcaseT511T511a = data2.new TestcaseT511T511a("testcaseT511T511a");
		Data.TestcaseTestcaseT111 testcaseTestcaseT111 = data2.new TestcaseTestcaseT111("testcaseTestcaseT111");
		Data.TestcaseTestcaseT112 testcaseTestcaseT112 = data2.new TestcaseTestcaseT112("testcaseTestcaseT112");
		Data.TestcaseTestcaseT113 testcaseTestcaseT113 = data2.new TestcaseTestcaseT113("testcaseTestcaseT113");
		Data.TestcaseTestcaseT114 testcaseTestcaseT114 = data2.new TestcaseTestcaseT114("testcaseTestcaseT114");
		Data.TestcaseTestcaseT121 testcaseTestcaseT121 = data2.new TestcaseTestcaseT121("testcaseTestcaseT121");
		Data.TestcaseTestcaseT122 testcaseTestcaseT122 = data2.new TestcaseTestcaseT122("testcaseTestcaseT122");
		Data.TestcaseTestcaseT123 testcaseTestcaseT123 = data2.new TestcaseTestcaseT123("testcaseTestcaseT123");
		Data.TestcaseTestcaseT124 testcaseTestcaseT124 = data2.new TestcaseTestcaseT124("testcaseTestcaseT124");
		Data.TestcaseTestcaseT133 testcaseTestcaseT133 = data2.new TestcaseTestcaseT133("testcaseTestcaseT133");
		Data.TestcaseTestcaseT134 testcaseTestcaseT134 = data2.new TestcaseTestcaseT134("testcaseTestcaseT134");
		Data.TestcaseTestcaseT141 testcaseTestcaseT141 = data2.new TestcaseTestcaseT141("testcaseTestcaseT141");
		Data.TestcaseTestcaseT142 testcaseTestcaseT142 = data2.new TestcaseTestcaseT142("testcaseTestcaseT142");
		Data.TestcaseTestcaseT143 testcaseTestcaseT143 = data2.new TestcaseTestcaseT143("testcaseTestcaseT143");
		Data.TestcaseTestcaseT144 testcaseTestcaseT144 = data2.new TestcaseTestcaseT144("testcaseTestcaseT144");
		Data.TestcaseTestcaseT151empty testcaseTestcaseT151empty = data2.new TestcaseTestcaseT151empty("testcaseTestcaseT151empty");
		Data.TestcaseTestcaseT151 testcaseTestcaseT151 = data2.new TestcaseTestcaseT151("testcaseTestcaseT151");
		Data.TestcaseTestcaseT152empty testcaseTestcaseT152empty = data2.new TestcaseTestcaseT152empty("testcaseTestcaseT152empty");
		Data.TestcaseTestcaseT152 testcaseTestcaseT152 = data2.new TestcaseTestcaseT152("testcaseTestcaseT152");
		Data.TestcaseTestcaseT153empty testcaseTestcaseT153empty = data2.new TestcaseTestcaseT153empty("testcaseTestcaseT153empty");
		Data.TestcaseTestcaseT153 testcaseTestcaseT153 = data2.new TestcaseTestcaseT153("testcaseTestcaseT153");
		Data.TestcaseTestcaseT154empty testcaseTestcaseT154empty = data2.new TestcaseTestcaseT154empty("testcaseTestcaseT154empty");
		Data.TestcaseTestcaseT154 testcaseTestcaseT154 = data2.new TestcaseTestcaseT154("testcaseTestcaseT154");
		Data.TestcaseTestcaseT161empty testcaseTestcaseT161empty = data2.new TestcaseTestcaseT161empty("testcaseTestcaseT161empty");
		Data.TestcaseTestcaseT161 testcaseTestcaseT161 = data2.new TestcaseTestcaseT161("testcaseTestcaseT161");
		Data.TestcaseTestcaseT162empty testcaseTestcaseT162empty = data2.new TestcaseTestcaseT162empty("testcaseTestcaseT162empty");
		Data.TestcaseTestcaseT162 testcaseTestcaseT162 = data2.new TestcaseTestcaseT162("testcaseTestcaseT162");
		Data.TestcaseTestcaseT163empty testcaseTestcaseT163empty = data2.new TestcaseTestcaseT163empty("testcaseTestcaseT163empty");
		Data.TestcaseTestcaseT163 testcaseTestcaseT163 = data2.new TestcaseTestcaseT163("testcaseTestcaseT163");
		Data.TestcaseTestcaseT164empty testcaseTestcaseT164empty = data2.new TestcaseTestcaseT164empty("testcaseTestcaseT164empty");
		Data.TestcaseTestcaseT164 testcaseTestcaseT164 = data2.new TestcaseTestcaseT164("testcaseTestcaseT164");
		Data.TestcaseTestcaseT211 testcaseTestcaseT211 = data2.new TestcaseTestcaseT211("testcaseTestcaseT211");
		Data.TestcaseTestcaseT212 testcaseTestcaseT212 = data2.new TestcaseTestcaseT212("testcaseTestcaseT212");
		Data.TestcaseTestcaseT213empty testcaseTestcaseT213empty = data2.new TestcaseTestcaseT213empty("testcaseTestcaseT213empty");
		Data.TestcaseTestcaseT213 testcaseTestcaseT213 = data2.new TestcaseTestcaseT213("testcaseTestcaseT213");
		Data.TestcaseTestcaseT214empty testcaseTestcaseT214empty = data2.new TestcaseTestcaseT214empty("testcaseTestcaseT214empty");
		Data.TestcaseTestcaseT214 testcaseTestcaseT214 = data2.new TestcaseTestcaseT214("testcaseTestcaseT214");
		Data.TestcaseTestcaseEnd testcaseTestcaseEnd = data2.new TestcaseTestcaseEnd("testcaseTestcaseEnd");
		Data.False_getFalse false_getFalse = data2.new False_getFalse();
		Data.True_getTrue true_getTrue = data2.new True_getTrue();
		Data.X_getT511a x_getT511a = data2.new X_getT511a();

		// *** Declarations and Statements ***
		OrList cr = new OrList(1, "cr");
		OrList comment = new OrList(2, "comment");
		Repeat ws = new Repeat(3, "ws");
		Optional s = new Optional(4, "s");
		Str a = new Str(5, "a");
		Str b = new Str(6, "b");
		Str c = new Str(7, "c");
		Str d = new Str(8, "d");
		Str ab = new Str(9, "ab");
		Str cd = new Str(10, "cd");
		Repeat ar = new Repeat(11, "ar");
		Repeat br = new Repeat(12, "br");
		Repeat dr = new Repeat(13, "dr");
		Repeat er = new Repeat(14, "er");
		ElementList t111 = new ElementList(15, "t111");
		ElementList t112 = new ElementList(16, "t112");
		Repeat t113 = new Repeat(17, "t113");
		ElementList t114 = new ElementList(18, "t114");
		ElementList t121 = new ElementList(19, "t121");
		ElementList t122 = new ElementList(20, "t122");
		Repeat t123 = new Repeat(21, "t123");
		ElementList t124 = new ElementList(22, "t124");
		ElementList t131 = new ElementList(23, "t131", NOT, testcaseT131X);
		ElementList t132 = new ElementList(24, "t132", NOT, testcaseT132X);
		Repeat t133 = new Repeat(25, "t133", NOT, testcaseT133X);
		ElementList t134 = new ElementList(26, "t134", NOT, testcaseT134X);
		ElementList t141 = new ElementList(27, "t141");
		Repeat t142 = new Repeat(28, "t142");
		ElementList t143 = new ElementList(29, "t143");
		Repeat t144 = new Repeat(30, "t144");
		Optional t151 = new Optional(31, "t151");
		ElementList t152 = new ElementList(32, "t152");
		Optional t153 = new Optional(33, "t153");
		ElementList t154 = new ElementList(34, "t154");
		Optional t161 = new Optional(35, "t161");
		ElementList t162 = new ElementList(36, "t162");
		Optional t163 = new Optional(37, "t163");
		ElementList t164 = new ElementList(38, "t164");
		Optional t165 = new Optional(39, "t165", testcaseT165X);
		ElementList t211 = new ElementList(40, "t211");
		ElementList t212 = new ElementList(41, "t212");
		Optional t213 = new Optional(42, "t213");
		Optional t214 = new Optional(43, "t214");
		Repeat t311 = new Repeat(44, "t311", new net.sf.laja.parser.engine2.Repeats(3));
		Repeat t312 = new Repeat(45, "t312", new net.sf.laja.parser.engine2.Repeats(3,5));
		ElementList t313a = new ElementList(46, "t313a");
		Repeat t313 = new Repeat(47, "t313", new net.sf.laja.parser.engine2.Repeats(2));
		ElementList t411 = new ElementList(48, "t411");
		Repeat t511a = new Repeat(49, "t511a");
		ElementList t511 = new ElementList(50, "t511");
		ElementList t512 = new ElementList(51, "t512");
		ElementList testcase = new ElementList(52, "testcase");

		// cr = ("\r" ["\n"]) | "\n"
		ElementList cr_1 = new ElementList(53, "cr_1");
		cr_1.add(55, new Str(54, "\r"));
		Optional cr_1_1 = new Optional(56, "cr_1_1");
		cr_1_1.add(58, new Str(57, "\n"));
		cr_1.add(59, cr_1_1);
		cr.add(60, cr_1);
		cr.add(62, new Str(61, "\n"));

		// comment = ("/*" [!"*/"+] "*/") | ("//" [!(cr|END)+] cr|END)
		ElementList comment_1 = new ElementList(63, "comment_1");
		comment_1.add(65, new Str(64, "/*"));
		Optional comment_1_1 = new Optional(66, "comment_1_1");
		Repeat comment_1_1_1 = new Repeat(67, "comment_1_1_1");
		comment_1_1_1.add(69, new Str(68, "*/", NOT));
		comment_1_1.add(70, comment_1_1_1);
		comment_1.add(71, comment_1_1);
		comment_1.add(73, new Str(72, "*/"));
		comment.add(74, comment_1);
		ElementList comment_2 = new ElementList(75, "comment_2");
		comment_2.add(77, new Str(76, "//"));
		Optional comment_2_1 = new Optional(78, "comment_2_1");
		Repeat comment_2_1_1 = new Repeat(79, "comment_2_1_1");
		OrList comment_2_1_1_1 = new OrList(80, "comment_2_1_1_1");
		comment_2_1_1_1.add(81, cr);
		comment_2_1_1_1.add(83, new End(82, "comment_2_1_1_1"));
		comment_2_1_1.add(84, comment_2_1_1_1, NOT);
		comment_2_1.add(85, comment_2_1_1);
		comment_2.add(86, comment_2_1);
		OrList comment_2_2 = new OrList(87, "comment_2_2");
		comment_2_2.add(88, cr);
		comment_2_2.add(90, new End(89, "comment_2_2"));
		comment_2.add(91, comment_2_2);
		comment.add(92, comment_2);

		// ws = (cr | " " | "\t" | comment)+
		OrList ws_1 = new OrList(93, "ws_1");
		ws_1.add(94, cr);
		ws_1.add(96, new Str(95, " "));
		ws_1.add(98, new Str(97, "\t"));
		ws_1.add(99, comment);
		ws.add(100, ws_1);

		// s = [ws]
		s.add(101, ws);

		// a = "a"

		// b = "b"

		// c = "c"

		// d = "d"

		// ab = "ab"

		// cd = "cd"

		// ar = "a"+
		ar.add(103, new Str(102, "a"));

		// br = "b"+
		br.add(105, new Str(104, "b"));

		// dr = "d"+
		dr.add(107, new Str(106, "d"));

		// er = "e"+
		er.add(109, new Str(108, "e"));

		// t111 = ab
		t111.add(110, ab, testcaseT111Ab);

		// t112 = !ab
		t112.add(111, ab, NOT, testcaseT112Ab);

		// t113 = ab+
		t113.add(112, ab, testcaseT113Ab);

		// t114 = !ab:notab+ ab
		Repeat t114_1 = new Repeat(113, "t114_1");
		t114_1.add(114, ab, NOT, testcaseT114Notab);
		t114.add(115, t114_1);
		t114.add(116, ab);

		// t121 = (ab)
		t121.add(117, ab, testcaseT121Ab);

		// t122 = (!ab)
		t122.add(118, ab, NOT, testcaseT122Ab);

		// t123 = (ab+)
		t123.add(119, ab, testcaseT123Ab);

		// t124 = (!ab:notab+) ab
		Repeat t124_1 = new Repeat(120, "t124_1");
		t124_1.add(121, ab, NOT, testcaseT124Notab);
		t124.add(122, t124_1);
		t124.add(123, ab);

		// t131 = !(ab):x
		t131.add(124, ab, testcaseT131Ab);

		// t132 = !(!a):x
		t132.add(125, a, NOT, testcaseT132A);

		// t133 = !(ab+):x
		t133.add(126, ab);

		// t134 = !(!a+):x
		Repeat t134_1 = new Repeat(127, "t134_1");
		t134_1.add(128, a, NOT);
		t134.add(129, t134_1);

		// t141 = !(ab:notab):x+ ab
		Repeat t141_1 = new Repeat(130, "t141_1");
		ElementList t141_1_1 = new ElementList(131, "t141_1_1");
		t141_1_1.add(132, ab, testcaseT141Notab);
		t141_1.add(133, t141_1_1, NOT, testcaseT141X);
		t141.add(134, t141_1);
		t141.add(135, ab, testcaseT141Ab);

		// t142 = !(!a):x+
		ElementList t142_1 = new ElementList(136, "t142_1");
		t142_1.add(137, a, NOT, testcaseT142A);
		t142.add(138, t142_1, NOT, testcaseT142X);

		// t143 = !(ab:notab+):x+ ab
		Repeat t143_1 = new Repeat(139, "t143_1");
		Repeat t143_1_1 = new Repeat(140, "t143_1_1");
		t143_1_1.add(141, ab, testcaseT143Notab);
		t143_1.add(142, t143_1_1, NOT, testcaseT143X);
		t143.add(143, t143_1);
		t143.add(144, ab, testcaseT143Ab);

		// t144 = !(!a+):x+
		Repeat t144_1 = new Repeat(145, "t144_1");
		t144_1.add(146, a, NOT, testcaseT144A);
		t144.add(147, t144_1, NOT, testcaseT144X);

		// t151 = [ab]
		t151.add(148, ab, testcaseT151Ab);

		// t152 = [!ab:notab] ab
		Optional t152_1 = new Optional(149, "t152_1");
		t152_1.add(150, ab, NOT, testcaseT152Notab);
		t152.add(151, t152_1);
		t152.add(152, ab);

		// t153 = [ab+]
		Repeat t153_1 = new Repeat(153, "t153_1");
		t153_1.add(154, ab, testcaseT153Ab);
		t153.add(155, t153_1);

		// t154 = [!ab:notab+] ab
		Optional t154_1 = new Optional(156, "t154_1");
		Repeat t154_1_1 = new Repeat(157, "t154_1_1");
		t154_1_1.add(158, ab, NOT, testcaseT154Notab);
		t154_1.add(159, t154_1_1);
		t154.add(160, t154_1);
		t154.add(161, ab);

		// t161 = [ab]+
		Repeat t161_1 = new Repeat(162, "t161_1");
		t161_1.add(163, ab, testcaseT161Ab);
		t161.add(164, t161_1);

		// t162 = [!ab:notab]+ ab
		Optional t162_1 = new Optional(165, "t162_1");
		Repeat t162_1_1 = new Repeat(166, "t162_1_1");
		t162_1_1.add(167, ab, NOT, testcaseT162Notab);
		t162_1.add(168, t162_1_1);
		t162.add(169, t162_1);
		t162.add(170, ab);

		// t163 = [ab+]+
		Repeat t163_1 = new Repeat(171, "t163_1");
		Repeat t163_1_1 = new Repeat(172, "t163_1_1");
		t163_1_1.add(173, ab, testcaseT163Ab);
		t163_1.add(174, t163_1_1);
		t163.add(175, t163_1);

		// t164 = [!ab:notab+]+ ab
		Optional t164_1 = new Optional(176, "t164_1");
		Repeat t164_1_1 = new Repeat(177, "t164_1_1");
		Repeat t164_1_1_1 = new Repeat(178, "t164_1_1_1");
		t164_1_1_1.add(179, ab, NOT, testcaseT164Notab);
		t164_1_1.add(180, t164_1_1_1);
		t164_1.add(181, t164_1_1);
		t164.add(182, t164_1);
		t164.add(183, ab);

		// t165 = [ab]:x
		t165.add(184, ab);

		// t211 = ab cd
		t211.add(185, ab, testcaseT211Ab);
		t211.add(186, cd, testcaseT211Cd);

		// t212 = (ab cd)
		t212.add(187, ab, testcaseT212Ab);
		t212.add(188, cd, testcaseT212Cd);

		// t213 = [ab cd]
		t213.add(189, ab, testcaseT213Ab);
		t213.add(190, cd, testcaseT213Cd);

		// t214 = [ab cd]+
		Repeat t214_1 = new Repeat(191, "t214_1");
		t214_1.add(192, ab, testcaseT214Ab);
		t214_1.add(193, cd, testcaseT214Cd);
		t214.add(194, t214_1);

		// t311 = a#3
		t311.add(195, a, testcaseT311A);

		// t312 = a#3..5
		t312.add(196, a, testcaseT312A);

		// t313a = a
		t313a.add(197, a);

		// t313 = t313a#2
		t313.add(198, t313a, testcaseT313T313a);

		// t411 = :x a :y
		t411.add(200, new Marker(199, "x", testcaseT411X));
		t411.add(201, a, testcaseT411A);
		t411.add(203, new Marker(202, "y", testcaseT411Y));

		// t511a = a+
		t511a.add(204, a);

		// t511 = t511a "." $x
		t511.add(205, t511a, testcaseT511T511a);
		t511.add(207, new Str(206, "."));
		t511.add(209, new Variable(208, "t511", x_getT511a));

		// t512 = a $true !$false
		t512.add(210, a);
		t512.add(212, new Variable(211, "t512", true_getTrue));
		t512.add(214, new Variable(213, "t512", false_getFalse, NOT));

		// testcase =
		//   "111. " t111 cr
		//   "112. " t112 cr
		//   "113. " t113 cr
		//   "114. " t114 cr
		//   
		//   "121. " t121 cr
		//   "122. " t122 cr
		//   "123. " t123 cr
		//   "124. " t124 cr
		//   
		//   "131. " t131 cr
		//   "132. " t132 cr
		//   "133. " t133 cr
		//   "134. " t134 cr
		//   
		//   "141. " t141 cr
		//   "142. " t142 cr
		//   "143. " t143 cr
		//   "144. " t144 cr
		//   
		//   "151a. " t151:t151empty cr
		//   "151b. " t151 cr
		//   "152a. " t152:t152empty cr
		//   "152b. " t152 cr
		//   "153a. " t153:t153empty cr
		//   "153b. " t153 cr
		//   "154a. " t154:t154empty cr
		//   "154b. " t154 cr
		//   
		//   "161a. " t161:t161empty cr
		//   "161b. " t161 cr
		//   "162a. " t162:t162empty cr
		//   "162b. " t162 cr
		//   "163a. " t163:t163empty cr
		//   "163b. " t163 cr
		//   "164a. " t164:t164empty cr
		//   "164b. " t164 cr
		//   "165. " t165 cr
		//   
		//   "211. " t211 cr
		//   "212. " t212 cr
		//   "213a. " t213:t213empty cr
		//   "213b. " t213 cr
		//   "214a. " t214:t214empty cr
		//   "214b. " t214 cr
		//   
		//   "311. " t311 cr
		//   "312. " t312 cr
		//   "313. " t313 cr
		//   
		//   "411. " t411 cr
		//   
		//   "511. " t511 cr
		//   "512. " t512 cr
		//   
		//   ".":end
		testcase.add(216, new Str(215, "111. "));
		testcase.add(217, t111, testcaseTestcaseT111);
		testcase.add(218, cr);
		testcase.add(220, new Str(219, "112. "));
		testcase.add(221, t112, testcaseTestcaseT112);
		testcase.add(222, cr);
		testcase.add(224, new Str(223, "113. "));
		testcase.add(225, t113, testcaseTestcaseT113);
		testcase.add(226, cr);
		testcase.add(228, new Str(227, "114. "));
		testcase.add(229, t114, testcaseTestcaseT114);
		testcase.add(230, cr);
		testcase.add(232, new Str(231, "121. "));
		testcase.add(233, t121, testcaseTestcaseT121);
		testcase.add(234, cr);
		testcase.add(236, new Str(235, "122. "));
		testcase.add(237, t122, testcaseTestcaseT122);
		testcase.add(238, cr);
		testcase.add(240, new Str(239, "123. "));
		testcase.add(241, t123, testcaseTestcaseT123);
		testcase.add(242, cr);
		testcase.add(244, new Str(243, "124. "));
		testcase.add(245, t124, testcaseTestcaseT124);
		testcase.add(246, cr);
		testcase.add(248, new Str(247, "131. "));
		testcase.add(249, t131);
		testcase.add(250, cr);
		testcase.add(252, new Str(251, "132. "));
		testcase.add(253, t132);
		testcase.add(254, cr);
		testcase.add(256, new Str(255, "133. "));
		testcase.add(257, t133, testcaseTestcaseT133);
		testcase.add(258, cr);
		testcase.add(260, new Str(259, "134. "));
		testcase.add(261, t134, testcaseTestcaseT134);
		testcase.add(262, cr);
		testcase.add(264, new Str(263, "141. "));
		testcase.add(265, t141, testcaseTestcaseT141);
		testcase.add(266, cr);
		testcase.add(268, new Str(267, "142. "));
		testcase.add(269, t142, testcaseTestcaseT142);
		testcase.add(270, cr);
		testcase.add(272, new Str(271, "143. "));
		testcase.add(273, t143, testcaseTestcaseT143);
		testcase.add(274, cr);
		testcase.add(276, new Str(275, "144. "));
		testcase.add(277, t144, testcaseTestcaseT144);
		testcase.add(278, cr);
		testcase.add(280, new Str(279, "151a. "));
		testcase.add(281, t151, testcaseTestcaseT151empty);
		testcase.add(282, cr);
		testcase.add(284, new Str(283, "151b. "));
		testcase.add(285, t151, testcaseTestcaseT151);
		testcase.add(286, cr);
		testcase.add(288, new Str(287, "152a. "));
		testcase.add(289, t152, testcaseTestcaseT152empty);
		testcase.add(290, cr);
		testcase.add(292, new Str(291, "152b. "));
		testcase.add(293, t152, testcaseTestcaseT152);
		testcase.add(294, cr);
		testcase.add(296, new Str(295, "153a. "));
		testcase.add(297, t153, testcaseTestcaseT153empty);
		testcase.add(298, cr);
		testcase.add(300, new Str(299, "153b. "));
		testcase.add(301, t153, testcaseTestcaseT153);
		testcase.add(302, cr);
		testcase.add(304, new Str(303, "154a. "));
		testcase.add(305, t154, testcaseTestcaseT154empty);
		testcase.add(306, cr);
		testcase.add(308, new Str(307, "154b. "));
		testcase.add(309, t154, testcaseTestcaseT154);
		testcase.add(310, cr);
		testcase.add(312, new Str(311, "161a. "));
		testcase.add(313, t161, testcaseTestcaseT161empty);
		testcase.add(314, cr);
		testcase.add(316, new Str(315, "161b. "));
		testcase.add(317, t161, testcaseTestcaseT161);
		testcase.add(318, cr);
		testcase.add(320, new Str(319, "162a. "));
		testcase.add(321, t162, testcaseTestcaseT162empty);
		testcase.add(322, cr);
		testcase.add(324, new Str(323, "162b. "));
		testcase.add(325, t162, testcaseTestcaseT162);
		testcase.add(326, cr);
		testcase.add(328, new Str(327, "163a. "));
		testcase.add(329, t163, testcaseTestcaseT163empty);
		testcase.add(330, cr);
		testcase.add(332, new Str(331, "163b. "));
		testcase.add(333, t163, testcaseTestcaseT163);
		testcase.add(334, cr);
		testcase.add(336, new Str(335, "164a. "));
		testcase.add(337, t164, testcaseTestcaseT164empty);
		testcase.add(338, cr);
		testcase.add(340, new Str(339, "164b. "));
		testcase.add(341, t164, testcaseTestcaseT164);
		testcase.add(342, cr);
		testcase.add(344, new Str(343, "165. "));
		testcase.add(345, t165);
		testcase.add(346, cr);
		testcase.add(348, new Str(347, "211. "));
		testcase.add(349, t211, testcaseTestcaseT211);
		testcase.add(350, cr);
		testcase.add(352, new Str(351, "212. "));
		testcase.add(353, t212, testcaseTestcaseT212);
		testcase.add(354, cr);
		testcase.add(356, new Str(355, "213a. "));
		testcase.add(357, t213, testcaseTestcaseT213empty);
		testcase.add(358, cr);
		testcase.add(360, new Str(359, "213b. "));
		testcase.add(361, t213, testcaseTestcaseT213);
		testcase.add(362, cr);
		testcase.add(364, new Str(363, "214a. "));
		testcase.add(365, t214, testcaseTestcaseT214empty);
		testcase.add(366, cr);
		testcase.add(368, new Str(367, "214b. "));
		testcase.add(369, t214, testcaseTestcaseT214);
		testcase.add(370, cr);
		testcase.add(372, new Str(371, "311. "));
		testcase.add(373, t311);
		testcase.add(374, cr);
		testcase.add(376, new Str(375, "312. "));
		testcase.add(377, t312);
		testcase.add(378, cr);
		testcase.add(380, new Str(379, "313. "));
		testcase.add(381, t313);
		testcase.add(382, cr);
		testcase.add(384, new Str(383, "411. "));
		testcase.add(385, t411);
		testcase.add(386, cr);
		testcase.add(388, new Str(387, "511. "));
		testcase.add(389, t511);
		testcase.add(390, cr);
		testcase.add(392, new Str(391, "512. "));
		testcase.add(393, t512);
		testcase.add(394, cr);
		testcase.add(396, new Str(395, ".", testcaseTestcaseEnd));


		return new TopElement(data2, testcase);
	}

	private net.sf.laja.parser.engine2.element.Element getGrammar1() {
		// *** Output classes ***
		Data.TestcaseT511T511a testcaseT511T511a = data1.new TestcaseT511T511a("testcaseT511T511a");
		Data.False_getFalse false_getFalse = data1.new False_getFalse();
		Data.True_getTrue true_getTrue = data1.new True_getTrue();
		Data.X_getT511a x_getT511a = data1.new X_getT511a();

		// *** Declarations and Statements ***
		OrList cr = new OrList(1, "cr");
		OrList comment = new OrList(2, "comment");
		Repeat ws = new Repeat(3, "ws");
		Optional s = new Optional(4, "s");
		Str a = new Str(5, "a");
		Str b = new Str(6, "b");
		Str c = new Str(7, "c");
		Str d = new Str(8, "d");
		Str ab = new Str(9, "ab");
		Str cd = new Str(10, "cd");
		Repeat ar = new Repeat(11, "ar");
		Repeat br = new Repeat(12, "br");
		Repeat dr = new Repeat(13, "dr");
		Repeat er = new Repeat(14, "er");
		ElementList t111 = new ElementList(15, "t111");
		ElementList t112 = new ElementList(16, "t112");
		Repeat t113 = new Repeat(17, "t113");
		ElementList t114 = new ElementList(18, "t114");
		ElementList t121 = new ElementList(19, "t121");
		ElementList t122 = new ElementList(20, "t122");
		Repeat t123 = new Repeat(21, "t123");
		ElementList t124 = new ElementList(22, "t124");
		ElementList t131 = new ElementList(23, "t131", NOT);
		ElementList t132 = new ElementList(24, "t132", NOT);
		Repeat t133 = new Repeat(25, "t133", NOT);
		ElementList t134 = new ElementList(26, "t134", NOT);
		ElementList t141 = new ElementList(27, "t141");
		Repeat t142 = new Repeat(28, "t142");
		ElementList t143 = new ElementList(29, "t143");
		Repeat t144 = new Repeat(30, "t144");
		Optional t151 = new Optional(31, "t151");
		ElementList t152 = new ElementList(32, "t152");
		Optional t153 = new Optional(33, "t153");
		ElementList t154 = new ElementList(34, "t154");
		Optional t161 = new Optional(35, "t161");
		ElementList t162 = new ElementList(36, "t162");
		Optional t163 = new Optional(37, "t163");
		ElementList t164 = new ElementList(38, "t164");
		Optional t165 = new Optional(39, "t165");
		ElementList t211 = new ElementList(40, "t211");
		ElementList t212 = new ElementList(41, "t212");
		Optional t213 = new Optional(42, "t213");
		Optional t214 = new Optional(43, "t214");
		Repeat t311 = new Repeat(44, "t311", new net.sf.laja.parser.engine2.Repeats(3));
		Repeat t312 = new Repeat(45, "t312", new net.sf.laja.parser.engine2.Repeats(3,5));
		ElementList t313a = new ElementList(46, "t313a");
		Repeat t313 = new Repeat(47, "t313", new net.sf.laja.parser.engine2.Repeats(2));
		ElementList t411 = new ElementList(48, "t411");
		Repeat t511a = new Repeat(49, "t511a");
		ElementList t511 = new ElementList(50, "t511");
		ElementList t512 = new ElementList(51, "t512");
		ElementList testcase = new ElementList(52, "testcase");

		// cr = ("\r" ["\n"]) | "\n"
		ElementList cr_1 = new ElementList(53, "cr_1");
		cr_1.add(55, new Str(54, "\r"));
		Optional cr_1_1 = new Optional(56, "cr_1_1");
		cr_1_1.add(58, new Str(57, "\n"));
		cr_1.add(59, cr_1_1);
		cr.add(60, cr_1);
		cr.add(62, new Str(61, "\n"));

		// comment = ("/*" [!"*/"+] "*/") | ("//" [!(cr|END)+] cr|END)
		ElementList comment_1 = new ElementList(63, "comment_1");
		comment_1.add(65, new Str(64, "/*"));
		Optional comment_1_1 = new Optional(66, "comment_1_1");
		Repeat comment_1_1_1 = new Repeat(67, "comment_1_1_1");
		comment_1_1_1.add(69, new Str(68, "*/", NOT));
		comment_1_1.add(70, comment_1_1_1);
		comment_1.add(71, comment_1_1);
		comment_1.add(73, new Str(72, "*/"));
		comment.add(74, comment_1);
		ElementList comment_2 = new ElementList(75, "comment_2");
		comment_2.add(77, new Str(76, "//"));
		Optional comment_2_1 = new Optional(78, "comment_2_1");
		Repeat comment_2_1_1 = new Repeat(79, "comment_2_1_1");
		OrList comment_2_1_1_1 = new OrList(80, "comment_2_1_1_1");
		comment_2_1_1_1.add(81, cr);
		comment_2_1_1_1.add(83, new End(82, "comment_2_1_1_1"));
		comment_2_1_1.add(84, comment_2_1_1_1, NOT);
		comment_2_1.add(85, comment_2_1_1);
		comment_2.add(86, comment_2_1);
		OrList comment_2_2 = new OrList(87, "comment_2_2");
		comment_2_2.add(88, cr);
		comment_2_2.add(90, new End(89, "comment_2_2"));
		comment_2.add(91, comment_2_2);
		comment.add(92, comment_2);

		// ws = (cr | " " | "\t" | comment)+
		OrList ws_1 = new OrList(93, "ws_1");
		ws_1.add(94, cr);
		ws_1.add(96, new Str(95, " "));
		ws_1.add(98, new Str(97, "\t"));
		ws_1.add(99, comment);
		ws.add(100, ws_1);

		// s = [ws]
		s.add(101, ws);

		// a = "a"

		// b = "b"

		// c = "c"

		// d = "d"

		// ab = "ab"

		// cd = "cd"

		// ar = "a"+
		ar.add(103, new Str(102, "a"));

		// br = "b"+
		br.add(105, new Str(104, "b"));

		// dr = "d"+
		dr.add(107, new Str(106, "d"));

		// er = "e"+
		er.add(109, new Str(108, "e"));

		// t111 = ab
		t111.add(110, ab);

		// t112 = !ab
		t112.add(111, ab, NOT);

		// t113 = ab+
		t113.add(112, ab);

		// t114 = !ab:notab+ ab
		Repeat t114_1 = new Repeat(113, "t114_1");
		t114_1.add(114, ab, NOT);
		t114.add(115, t114_1);
		t114.add(116, ab);

		// t121 = (ab)
		t121.add(117, ab);

		// t122 = (!ab)
		t122.add(118, ab, NOT);

		// t123 = (ab+)
		t123.add(119, ab);

		// t124 = (!ab:notab+) ab
		Repeat t124_1 = new Repeat(120, "t124_1");
		t124_1.add(121, ab, NOT);
		t124.add(122, t124_1);
		t124.add(123, ab);

		// t131 = !(ab):x
		t131.add(124, ab);

		// t132 = !(!a):x
		t132.add(125, a, NOT);

		// t133 = !(ab+):x
		t133.add(126, ab);

		// t134 = !(!a+):x
		Repeat t134_1 = new Repeat(127, "t134_1");
		t134_1.add(128, a, NOT);
		t134.add(129, t134_1);

		// t141 = !(ab:notab):x+ ab
		Repeat t141_1 = new Repeat(130, "t141_1");
		ElementList t141_1_1 = new ElementList(131, "t141_1_1");
		t141_1_1.add(132, ab);
		t141_1.add(133, t141_1_1, NOT);
		t141.add(134, t141_1);
		t141.add(135, ab);

		// t142 = !(!a):x+
		ElementList t142_1 = new ElementList(136, "t142_1");
		t142_1.add(137, a, NOT);
		t142.add(138, t142_1, NOT);

		// t143 = !(ab:notab+):x+ ab
		Repeat t143_1 = new Repeat(139, "t143_1");
		Repeat t143_1_1 = new Repeat(140, "t143_1_1");
		t143_1_1.add(141, ab);
		t143_1.add(142, t143_1_1, NOT);
		t143.add(143, t143_1);
		t143.add(144, ab);

		// t144 = !(!a+):x+
		Repeat t144_1 = new Repeat(145, "t144_1");
		t144_1.add(146, a, NOT);
		t144.add(147, t144_1, NOT);

		// t151 = [ab]
		t151.add(148, ab);

		// t152 = [!ab:notab] ab
		Optional t152_1 = new Optional(149, "t152_1");
		t152_1.add(150, ab, NOT);
		t152.add(151, t152_1);
		t152.add(152, ab);

		// t153 = [ab+]
		Repeat t153_1 = new Repeat(153, "t153_1");
		t153_1.add(154, ab);
		t153.add(155, t153_1);

		// t154 = [!ab:notab+] ab
		Optional t154_1 = new Optional(156, "t154_1");
		Repeat t154_1_1 = new Repeat(157, "t154_1_1");
		t154_1_1.add(158, ab, NOT);
		t154_1.add(159, t154_1_1);
		t154.add(160, t154_1);
		t154.add(161, ab);

		// t161 = [ab]+
		Repeat t161_1 = new Repeat(162, "t161_1");
		t161_1.add(163, ab);
		t161.add(164, t161_1);

		// t162 = [!ab:notab]+ ab
		Optional t162_1 = new Optional(165, "t162_1");
		Repeat t162_1_1 = new Repeat(166, "t162_1_1");
		t162_1_1.add(167, ab, NOT);
		t162_1.add(168, t162_1_1);
		t162.add(169, t162_1);
		t162.add(170, ab);

		// t163 = [ab+]+
		Repeat t163_1 = new Repeat(171, "t163_1");
		Repeat t163_1_1 = new Repeat(172, "t163_1_1");
		t163_1_1.add(173, ab);
		t163_1.add(174, t163_1_1);
		t163.add(175, t163_1);

		// t164 = [!ab:notab+]+ ab
		Optional t164_1 = new Optional(176, "t164_1");
		Repeat t164_1_1 = new Repeat(177, "t164_1_1");
		Repeat t164_1_1_1 = new Repeat(178, "t164_1_1_1");
		t164_1_1_1.add(179, ab, NOT);
		t164_1_1.add(180, t164_1_1_1);
		t164_1.add(181, t164_1_1);
		t164.add(182, t164_1);
		t164.add(183, ab);

		// t165 = [ab]:x
		t165.add(184, ab);

		// t211 = ab cd
		t211.add(185, ab);
		t211.add(186, cd);

		// t212 = (ab cd)
		t212.add(187, ab);
		t212.add(188, cd);

		// t213 = [ab cd]
		t213.add(189, ab);
		t213.add(190, cd);

		// t214 = [ab cd]+
		Repeat t214_1 = new Repeat(191, "t214_1");
		t214_1.add(192, ab);
		t214_1.add(193, cd);
		t214.add(194, t214_1);

		// t311 = a#3
		t311.add(195, a);

		// t312 = a#3..5
		t312.add(196, a);

		// t313a = a
		t313a.add(197, a);

		// t313 = t313a#2
		t313.add(198, t313a);

		// t411 = :x a :y
		t411.add(200, new Marker(199, "x"));
		t411.add(201, a);
		t411.add(203, new Marker(202, "y"));

		// t511a = a+
		t511a.add(204, a);

		// t511 = t511a "." $x
		t511.add(205, t511a, testcaseT511T511a);
		t511.add(207, new Str(206, "."));
		t511.add(209, new Variable(208, "t511", x_getT511a));

		// t512 = a $true !$false
		t512.add(210, a);
		t512.add(212, new Variable(211, "t512", true_getTrue));
		t512.add(214, new Variable(213, "t512", false_getFalse, NOT));

		// testcase =
		//   "111. " t111 cr
		//   "112. " t112 cr
		//   "113. " t113 cr
		//   "114. " t114 cr
		//   
		//   "121. " t121 cr
		//   "122. " t122 cr
		//   "123. " t123 cr
		//   "124. " t124 cr
		//   
		//   "131. " t131 cr
		//   "132. " t132 cr
		//   "133. " t133 cr
		//   "134. " t134 cr
		//   
		//   "141. " t141 cr
		//   "142. " t142 cr
		//   "143. " t143 cr
		//   "144. " t144 cr
		//   
		//   "151a. " t151:t151empty cr
		//   "151b. " t151 cr
		//   "152a. " t152:t152empty cr
		//   "152b. " t152 cr
		//   "153a. " t153:t153empty cr
		//   "153b. " t153 cr
		//   "154a. " t154:t154empty cr
		//   "154b. " t154 cr
		//   
		//   "161a. " t161:t161empty cr
		//   "161b. " t161 cr
		//   "162a. " t162:t162empty cr
		//   "162b. " t162 cr
		//   "163a. " t163:t163empty cr
		//   "163b. " t163 cr
		//   "164a. " t164:t164empty cr
		//   "164b. " t164 cr
		//   "165. " t165 cr
		//   
		//   "211. " t211 cr
		//   "212. " t212 cr
		//   "213a. " t213:t213empty cr
		//   "213b. " t213 cr
		//   "214a. " t214:t214empty cr
		//   "214b. " t214 cr
		//   
		//   "311. " t311 cr
		//   "312. " t312 cr
		//   "313. " t313 cr
		//   
		//   "411. " t411 cr
		//   
		//   "511. " t511 cr
		//   "512. " t512 cr
		//   
		//   ".":end
		testcase.add(216, new Str(215, "111. "));
		testcase.add(217, t111);
		testcase.add(218, cr);
		testcase.add(220, new Str(219, "112. "));
		testcase.add(221, t112);
		testcase.add(222, cr);
		testcase.add(224, new Str(223, "113. "));
		testcase.add(225, t113);
		testcase.add(226, cr);
		testcase.add(228, new Str(227, "114. "));
		testcase.add(229, t114);
		testcase.add(230, cr);
		testcase.add(232, new Str(231, "121. "));
		testcase.add(233, t121);
		testcase.add(234, cr);
		testcase.add(236, new Str(235, "122. "));
		testcase.add(237, t122);
		testcase.add(238, cr);
		testcase.add(240, new Str(239, "123. "));
		testcase.add(241, t123);
		testcase.add(242, cr);
		testcase.add(244, new Str(243, "124. "));
		testcase.add(245, t124);
		testcase.add(246, cr);
		testcase.add(248, new Str(247, "131. "));
		testcase.add(249, t131);
		testcase.add(250, cr);
		testcase.add(252, new Str(251, "132. "));
		testcase.add(253, t132);
		testcase.add(254, cr);
		testcase.add(256, new Str(255, "133. "));
		testcase.add(257, t133);
		testcase.add(258, cr);
		testcase.add(260, new Str(259, "134. "));
		testcase.add(261, t134);
		testcase.add(262, cr);
		testcase.add(264, new Str(263, "141. "));
		testcase.add(265, t141);
		testcase.add(266, cr);
		testcase.add(268, new Str(267, "142. "));
		testcase.add(269, t142);
		testcase.add(270, cr);
		testcase.add(272, new Str(271, "143. "));
		testcase.add(273, t143);
		testcase.add(274, cr);
		testcase.add(276, new Str(275, "144. "));
		testcase.add(277, t144);
		testcase.add(278, cr);
		testcase.add(280, new Str(279, "151a. "));
		testcase.add(281, t151);
		testcase.add(282, cr);
		testcase.add(284, new Str(283, "151b. "));
		testcase.add(285, t151);
		testcase.add(286, cr);
		testcase.add(288, new Str(287, "152a. "));
		testcase.add(289, t152);
		testcase.add(290, cr);
		testcase.add(292, new Str(291, "152b. "));
		testcase.add(293, t152);
		testcase.add(294, cr);
		testcase.add(296, new Str(295, "153a. "));
		testcase.add(297, t153);
		testcase.add(298, cr);
		testcase.add(300, new Str(299, "153b. "));
		testcase.add(301, t153);
		testcase.add(302, cr);
		testcase.add(304, new Str(303, "154a. "));
		testcase.add(305, t154);
		testcase.add(306, cr);
		testcase.add(308, new Str(307, "154b. "));
		testcase.add(309, t154);
		testcase.add(310, cr);
		testcase.add(312, new Str(311, "161a. "));
		testcase.add(313, t161);
		testcase.add(314, cr);
		testcase.add(316, new Str(315, "161b. "));
		testcase.add(317, t161);
		testcase.add(318, cr);
		testcase.add(320, new Str(319, "162a. "));
		testcase.add(321, t162);
		testcase.add(322, cr);
		testcase.add(324, new Str(323, "162b. "));
		testcase.add(325, t162);
		testcase.add(326, cr);
		testcase.add(328, new Str(327, "163a. "));
		testcase.add(329, t163);
		testcase.add(330, cr);
		testcase.add(332, new Str(331, "163b. "));
		testcase.add(333, t163);
		testcase.add(334, cr);
		testcase.add(336, new Str(335, "164a. "));
		testcase.add(337, t164);
		testcase.add(338, cr);
		testcase.add(340, new Str(339, "164b. "));
		testcase.add(341, t164);
		testcase.add(342, cr);
		testcase.add(344, new Str(343, "165. "));
		testcase.add(345, t165);
		testcase.add(346, cr);
		testcase.add(348, new Str(347, "211. "));
		testcase.add(349, t211);
		testcase.add(350, cr);
		testcase.add(352, new Str(351, "212. "));
		testcase.add(353, t212);
		testcase.add(354, cr);
		testcase.add(356, new Str(355, "213a. "));
		testcase.add(357, t213);
		testcase.add(358, cr);
		testcase.add(360, new Str(359, "213b. "));
		testcase.add(361, t213);
		testcase.add(362, cr);
		testcase.add(364, new Str(363, "214a. "));
		testcase.add(365, t214);
		testcase.add(366, cr);
		testcase.add(368, new Str(367, "214b. "));
		testcase.add(369, t214);
		testcase.add(370, cr);
		testcase.add(372, new Str(371, "311. "));
		testcase.add(373, t311);
		testcase.add(374, cr);
		testcase.add(376, new Str(375, "312. "));
		testcase.add(377, t312);
		testcase.add(378, cr);
		testcase.add(380, new Str(379, "313. "));
		testcase.add(381, t313);
		testcase.add(382, cr);
		testcase.add(384, new Str(383, "411. "));
		testcase.add(385, t411);
		testcase.add(386, cr);
		testcase.add(388, new Str(387, "511. "));
		testcase.add(389, t511);
		testcase.add(390, cr);
		testcase.add(392, new Str(391, "512. "));
		testcase.add(393, t512);
		testcase.add(394, cr);
		testcase.add(396, new Str(395, "."));


		return new TopElement(data1, testcase);
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
			data.pushTestcase();
			boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
			data.popTestcase();
			return match;
		}
	}

	// *** ITestcaseFactoryFactory
	public interface ITestcaseFactoryFactory {
		public ITestcaseFactory getFactory(int phase);
	}

	// *** ITestcaseFactory ***
	public interface ITestcaseFactory {
		TestcaseParser.ITestcase createTestcase();
	}

	// *** Interfaces ***
	// Testcase
	public interface ITestcase {
		public void setT111ab(String ab);
		public void setT111all(String t111);
		public void setT112notab(String ab);
		public void setT112all(String t112);
		public void setT113ab(String ab);
		public void setT113all(String t113);
		public void setT114notab(String notab);
		public void setT114all(String t114);
		public void setT121ab(String ab);
		public void setT121all(String t121);
		public void setT122notab(String ab);
		public void setT122all(String t122);
		public void setT123ab(String ab);
		public void setT123all(String t123);
		public void setT124notab(String notab);
		public void setT124all(String t124);
		public void setT131ab(String ab);
		public void setT131x(String x);
		public void setT132a(String a);
		public void setT132x(String x);
		public void setT133x(String x);
		public void setT133all(String t133);
		public void setT134x(String x);
		public void setT134all(String t134);
		public void setT141notab(String notab);
		public void setT141x(String x);
		public void setT141ab(String ab);
		public void setT141all(String t141);
		public void setT142a(String a);
		public void setT142x(String x);
		public void setT142all(String t142);
		public void setT143notab(String notab);
		public void setT143x(String x);
		public void setT143ab(String ab);
		public void setT143all(String t143);
		public void setT144a(String a);
		public void setT144x(String x);
		public void setT144all(String t144);
		public void setT151empty(String t151empty);
		public void setT151ab(String ab);
		public void setT151all(String t151);
		public void setT152empty(String t152empty);
		public void setT152notab(String notab);
		public void setT152all(String t152);
		public void setT153ab(String ab);
		public void setT153empty(String t153empty);
		public void setT153all(String t153);
		public void setT154empty(String t154empty);
		public void setT154notab(String notab);
		public void setT154all(String t154);
		public void setT161ab(String ab);
		public void setT161empty(String t161empty);
		public void setT161all(String t161);
		public void setT162empty(String t162empty);
		public void setT162notab(String notab);
		public void setT162all(String t162);
		public void setT163empty(String t163empty);
		public void setT163ab(String ab);
		public void setT163all(String t163);
		public void setT164empty(String t164empty);
		public void setT164notab(String notab);
		public void setT164all(String t164);
		public void setT165(String x);
		public void setT211ab(String ab);
		public void setT211cd(String cd);
		public void setT211all(String t211);
		public void setT212ab(String ab);
		public void setT212cd(String cd);
		public void setT212all(String t212);
		public void setT213empty(String t213empty);
		public void setT213ab(String ab);
		public void setT213cd(String cd);
		public void setT213all(String t213);
		public void setT214empty(String t214empty);
		public void setT214ab(String ab);
		public void setT214cd(String cd);
		public void setT214all(String t214);
		public void setT311(String a);
		public void setT312(String a);
		public void setT313(String t313a);
		public void setT411x(String x);
		public void setT411a(String a);
		public void setT411y(String y);
		public void setT511a(String t511a);
		public void setEnd();
		public boolean getFalse();
		public boolean getTrue();
		public String getT511a();
	}

	// *** Data ***
	public static final class Data {
		private TestcaseParser.ITestcaseFactory factory;
		private Stack<ITestcase> testcaseStack = new Stack<ITestcase>();

		public Data(TestcaseParser.ITestcaseFactory factory) {
			this.factory = factory;
		}

		// Testcase
		public void pushTestcase() { testcaseStack.push(factory.createTestcase()); }
		public TestcaseParser.ITestcase popTestcase() { return (TestcaseParser.ITestcase)testcaseStack.pop(); }
		public TestcaseParser.ITestcase peekTestcase() {
			if (testcaseStack.empty()) { return null; }
			return testcaseStack.peek();
		}

		// testcase.setT121ab(String t121.ab);
		public class TestcaseT121Ab implements Output {
			private String name;
			public TestcaseT121Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT121ab(source.get(bookmark));
			}
		}

		// testcase.setT122notab(String t122.ab);
		public class TestcaseT122Ab implements Output {
			private String name;
			public TestcaseT122Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT122notab(source.get(bookmark));
			}
		}

		// testcase.setT131x(String t131.x);
		public class TestcaseT131X implements Output {
			private String name;
			public TestcaseT131X(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT131x(source.get(bookmark));
			}
		}

		// testcase.setT131ab(String t131.ab);
		public class TestcaseT131Ab implements Output {
			private String name;
			public TestcaseT131Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT131ab(source.get(bookmark));
			}
		}

		// testcase.setT132x(String t132.x);
		public class TestcaseT132X implements Output {
			private String name;
			public TestcaseT132X(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT132x(source.get(bookmark));
			}
		}

		// testcase.setT133x(String t133.x);
		public class TestcaseT133X implements Output {
			private String name;
			public TestcaseT133X(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT133x(source.get(bookmark));
			}
		}

		// testcase.setT134x(String t134.x);
		public class TestcaseT134X implements Output {
			private String name;
			public TestcaseT134X(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT134x(source.get(bookmark));
			}
		}

		// testcase.setT165(String t165.x);
		public class TestcaseT165X implements Output {
			private String name;
			public TestcaseT165X(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT165(source.get(bookmark));
			}
		}

		// testcase.setT111ab(String t111.ab);
		public class TestcaseT111Ab implements Output {
			private String name;
			public TestcaseT111Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT111ab(source.get(bookmark));
			}
		}

		// testcase.setT112notab(String t112.ab);
		public class TestcaseT112Ab implements Output {
			private String name;
			public TestcaseT112Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT112notab(source.get(bookmark));
			}
		}

		// testcase.setT113ab(String t113.ab);
		public class TestcaseT113Ab implements Output {
			private String name;
			public TestcaseT113Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT113ab(source.get(bookmark));
			}
		}

		// testcase.setT114notab(String t114.notab);
		public class TestcaseT114Notab implements Output {
			private String name;
			public TestcaseT114Notab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT114notab(source.get(bookmark));
			}
		}

		// testcase.setT123ab(String t123.ab);
		public class TestcaseT123Ab implements Output {
			private String name;
			public TestcaseT123Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT123ab(source.get(bookmark));
			}
		}

		// testcase.setT124notab(String t124.notab);
		public class TestcaseT124Notab implements Output {
			private String name;
			public TestcaseT124Notab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT124notab(source.get(bookmark));
			}
		}

		// testcase.setT132a(String t132.a);
		public class TestcaseT132A implements Output {
			private String name;
			public TestcaseT132A(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT132a(source.get(bookmark));
			}
		}

		// testcase.setT141x(String t141.x);
		public class TestcaseT141X implements Output {
			private String name;
			public TestcaseT141X(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT141x(source.get(bookmark));
			}
		}

		// testcase.setT141notab(String t141.notab);
		public class TestcaseT141Notab implements Output {
			private String name;
			public TestcaseT141Notab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT141notab(source.get(bookmark));
			}
		}

		// testcase.setT141ab(String t141.ab);
		public class TestcaseT141Ab implements Output {
			private String name;
			public TestcaseT141Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT141ab(source.get(bookmark));
			}
		}

		// testcase.setT142x(String t142.x);
		public class TestcaseT142X implements Output {
			private String name;
			public TestcaseT142X(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT142x(source.get(bookmark));
			}
		}

		// testcase.setT142a(String t142.a);
		public class TestcaseT142A implements Output {
			private String name;
			public TestcaseT142A(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT142a(source.get(bookmark));
			}
		}

		// testcase.setT143x(String t143.x);
		public class TestcaseT143X implements Output {
			private String name;
			public TestcaseT143X(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT143x(source.get(bookmark));
			}
		}

		// testcase.setT143notab(String t143.notab);
		public class TestcaseT143Notab implements Output {
			private String name;
			public TestcaseT143Notab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT143notab(source.get(bookmark));
			}
		}

		// testcase.setT143ab(String t143.ab);
		public class TestcaseT143Ab implements Output {
			private String name;
			public TestcaseT143Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT143ab(source.get(bookmark));
			}
		}

		// testcase.setT144x(String t144.x);
		public class TestcaseT144X implements Output {
			private String name;
			public TestcaseT144X(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT144x(source.get(bookmark));
			}
		}

		// testcase.setT144a(String t144.a);
		public class TestcaseT144A implements Output {
			private String name;
			public TestcaseT144A(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT144a(source.get(bookmark));
			}
		}

		// testcase.setT151ab(String t151.ab);
		public class TestcaseT151Ab implements Output {
			private String name;
			public TestcaseT151Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT151ab(source.get(bookmark));
			}
		}

		// testcase.setT152notab(String t152.notab);
		public class TestcaseT152Notab implements Output {
			private String name;
			public TestcaseT152Notab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT152notab(source.get(bookmark));
			}
		}

		// testcase.setT153ab(String t153.ab);
		public class TestcaseT153Ab implements Output {
			private String name;
			public TestcaseT153Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT153ab(source.get(bookmark));
			}
		}

		// testcase.setT154notab(String t154.notab);
		public class TestcaseT154Notab implements Output {
			private String name;
			public TestcaseT154Notab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT154notab(source.get(bookmark));
			}
		}

		// testcase.setT161ab(String t161.ab);
		public class TestcaseT161Ab implements Output {
			private String name;
			public TestcaseT161Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT161ab(source.get(bookmark));
			}
		}

		// testcase.setT162notab(String t162.notab);
		public class TestcaseT162Notab implements Output {
			private String name;
			public TestcaseT162Notab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT162notab(source.get(bookmark));
			}
		}

		// testcase.setT163ab(String t163.ab);
		public class TestcaseT163Ab implements Output {
			private String name;
			public TestcaseT163Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT163ab(source.get(bookmark));
			}
		}

		// testcase.setT164notab(String t164.notab);
		public class TestcaseT164Notab implements Output {
			private String name;
			public TestcaseT164Notab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT164notab(source.get(bookmark));
			}
		}

		// testcase.setT211ab(String t211.ab);
		public class TestcaseT211Ab implements Output {
			private String name;
			public TestcaseT211Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT211ab(source.get(bookmark));
			}
		}

		// testcase.setT211cd(String t211.cd);
		public class TestcaseT211Cd implements Output {
			private String name;
			public TestcaseT211Cd(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT211cd(source.get(bookmark));
			}
		}

		// testcase.setT212ab(String t212.ab);
		public class TestcaseT212Ab implements Output {
			private String name;
			public TestcaseT212Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT212ab(source.get(bookmark));
			}
		}

		// testcase.setT212cd(String t212.cd);
		public class TestcaseT212Cd implements Output {
			private String name;
			public TestcaseT212Cd(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT212cd(source.get(bookmark));
			}
		}

		// testcase.setT213ab(String t213.ab);
		public class TestcaseT213Ab implements Output {
			private String name;
			public TestcaseT213Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT213ab(source.get(bookmark));
			}
		}

		// testcase.setT213cd(String t213.cd);
		public class TestcaseT213Cd implements Output {
			private String name;
			public TestcaseT213Cd(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT213cd(source.get(bookmark));
			}
		}

		// testcase.setT214ab(String t214.ab);
		public class TestcaseT214Ab implements Output {
			private String name;
			public TestcaseT214Ab(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT214ab(source.get(bookmark));
			}
		}

		// testcase.setT214cd(String t214.cd);
		public class TestcaseT214Cd implements Output {
			private String name;
			public TestcaseT214Cd(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT214cd(source.get(bookmark));
			}
		}

		// testcase.setT311(String t311.a);
		public class TestcaseT311A implements Output {
			private String name;
			public TestcaseT311A(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT311(source.get(bookmark));
			}
		}

		// testcase.setT312(String t312.a);
		public class TestcaseT312A implements Output {
			private String name;
			public TestcaseT312A(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT312(source.get(bookmark));
			}
		}

		// testcase.setT313(String t313.t313a);
		public class TestcaseT313T313a implements Output {
			private String name;
			public TestcaseT313T313a(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT313(source.get(bookmark));
			}
		}

		// testcase.setT411x(String t411.x);
		public class TestcaseT411X implements Output {
			private String name;
			public TestcaseT411X(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT411x(source.get(bookmark));
			}
		}

		// testcase.setT411a(String t411.a);
		public class TestcaseT411A implements Output {
			private String name;
			public TestcaseT411A(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT411a(source.get(bookmark));
			}
		}

		// testcase.setT411y(String t411.y);
		public class TestcaseT411Y implements Output {
			private String name;
			public TestcaseT411Y(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT411y(source.get(bookmark));
			}
		}

		// $ testcase.setT511a(String t511.t511a);
		public class TestcaseT511T511a implements Output {
			private String name;
			public TestcaseT511T511a(String name) { this.name = name; }
			public boolean receive() { return true; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT511a(source.get(bookmark));
			}
		}

		// testcase.setT111all(String t111);
		public class TestcaseTestcaseT111 implements Output {
			private String name;
			public TestcaseTestcaseT111(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT111all(source.get(bookmark));
			}
		}

		// testcase.setT112all(String t112);
		public class TestcaseTestcaseT112 implements Output {
			private String name;
			public TestcaseTestcaseT112(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT112all(source.get(bookmark));
			}
		}

		// testcase.setT113all(String t113);
		public class TestcaseTestcaseT113 implements Output {
			private String name;
			public TestcaseTestcaseT113(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT113all(source.get(bookmark));
			}
		}

		// testcase.setT114all(String t114);
		public class TestcaseTestcaseT114 implements Output {
			private String name;
			public TestcaseTestcaseT114(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT114all(source.get(bookmark));
			}
		}

		// testcase.setT121all(String t121);
		public class TestcaseTestcaseT121 implements Output {
			private String name;
			public TestcaseTestcaseT121(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT121all(source.get(bookmark));
			}
		}

		// testcase.setT122all(String t122);
		public class TestcaseTestcaseT122 implements Output {
			private String name;
			public TestcaseTestcaseT122(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT122all(source.get(bookmark));
			}
		}

		// testcase.setT123all(String t123);
		public class TestcaseTestcaseT123 implements Output {
			private String name;
			public TestcaseTestcaseT123(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT123all(source.get(bookmark));
			}
		}

		// testcase.setT124all(String t124);
		public class TestcaseTestcaseT124 implements Output {
			private String name;
			public TestcaseTestcaseT124(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT124all(source.get(bookmark));
			}
		}

		// testcase.setT133all(String t133);
		public class TestcaseTestcaseT133 implements Output {
			private String name;
			public TestcaseTestcaseT133(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT133all(source.get(bookmark));
			}
		}

		// testcase.setT134all(String t134);
		public class TestcaseTestcaseT134 implements Output {
			private String name;
			public TestcaseTestcaseT134(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT134all(source.get(bookmark));
			}
		}

		// testcase.setT141all(String t141);
		public class TestcaseTestcaseT141 implements Output {
			private String name;
			public TestcaseTestcaseT141(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT141all(source.get(bookmark));
			}
		}

		// testcase.setT142all(String t142);
		public class TestcaseTestcaseT142 implements Output {
			private String name;
			public TestcaseTestcaseT142(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT142all(source.get(bookmark));
			}
		}

		// testcase.setT143all(String t143);
		public class TestcaseTestcaseT143 implements Output {
			private String name;
			public TestcaseTestcaseT143(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT143all(source.get(bookmark));
			}
		}

		// testcase.setT144all(String t144);
		public class TestcaseTestcaseT144 implements Output {
			private String name;
			public TestcaseTestcaseT144(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT144all(source.get(bookmark));
			}
		}

		// testcase.setT151empty(String t151empty);
		public class TestcaseTestcaseT151empty implements Output {
			private String name;
			public TestcaseTestcaseT151empty(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT151empty(source.get(bookmark));
			}
		}

		// testcase.setT151all(String t151);
		public class TestcaseTestcaseT151 implements Output {
			private String name;
			public TestcaseTestcaseT151(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT151all(source.get(bookmark));
			}
		}

		// testcase.setT152empty(String t152empty);
		public class TestcaseTestcaseT152empty implements Output {
			private String name;
			public TestcaseTestcaseT152empty(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT152empty(source.get(bookmark));
			}
		}

		// testcase.setT152all(String t152);
		public class TestcaseTestcaseT152 implements Output {
			private String name;
			public TestcaseTestcaseT152(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT152all(source.get(bookmark));
			}
		}

		// testcase.setT153empty(String t153empty);
		public class TestcaseTestcaseT153empty implements Output {
			private String name;
			public TestcaseTestcaseT153empty(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT153empty(source.get(bookmark));
			}
		}

		// testcase.setT153all(String t153);
		public class TestcaseTestcaseT153 implements Output {
			private String name;
			public TestcaseTestcaseT153(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT153all(source.get(bookmark));
			}
		}

		// testcase.setT154empty(String t154empty);
		public class TestcaseTestcaseT154empty implements Output {
			private String name;
			public TestcaseTestcaseT154empty(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT154empty(source.get(bookmark));
			}
		}

		// testcase.setT154all(String t154);
		public class TestcaseTestcaseT154 implements Output {
			private String name;
			public TestcaseTestcaseT154(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT154all(source.get(bookmark));
			}
		}

		// testcase.setT161empty(String t161empty);
		public class TestcaseTestcaseT161empty implements Output {
			private String name;
			public TestcaseTestcaseT161empty(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT161empty(source.get(bookmark));
			}
		}

		// testcase.setT161all(String t161);
		public class TestcaseTestcaseT161 implements Output {
			private String name;
			public TestcaseTestcaseT161(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT161all(source.get(bookmark));
			}
		}

		// testcase.setT162empty(String t162empty);
		public class TestcaseTestcaseT162empty implements Output {
			private String name;
			public TestcaseTestcaseT162empty(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT162empty(source.get(bookmark));
			}
		}

		// testcase.setT162all(String t162);
		public class TestcaseTestcaseT162 implements Output {
			private String name;
			public TestcaseTestcaseT162(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT162all(source.get(bookmark));
			}
		}

		// testcase.setT163empty(String t163empty);
		public class TestcaseTestcaseT163empty implements Output {
			private String name;
			public TestcaseTestcaseT163empty(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT163empty(source.get(bookmark));
			}
		}

		// testcase.setT163all(String t163);
		public class TestcaseTestcaseT163 implements Output {
			private String name;
			public TestcaseTestcaseT163(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT163all(source.get(bookmark));
			}
		}

		// testcase.setT164empty(String t164empty);
		public class TestcaseTestcaseT164empty implements Output {
			private String name;
			public TestcaseTestcaseT164empty(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT164empty(source.get(bookmark));
			}
		}

		// testcase.setT164all(String t164);
		public class TestcaseTestcaseT164 implements Output {
			private String name;
			public TestcaseTestcaseT164(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT164all(source.get(bookmark));
			}
		}

		// testcase.setT211all(String t211);
		public class TestcaseTestcaseT211 implements Output {
			private String name;
			public TestcaseTestcaseT211(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT211all(source.get(bookmark));
			}
		}

		// testcase.setT212all(String t212);
		public class TestcaseTestcaseT212 implements Output {
			private String name;
			public TestcaseTestcaseT212(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT212all(source.get(bookmark));
			}
		}

		// testcase.setT213empty(String t213empty);
		public class TestcaseTestcaseT213empty implements Output {
			private String name;
			public TestcaseTestcaseT213empty(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT213empty(source.get(bookmark));
			}
		}

		// testcase.setT213all(String t213);
		public class TestcaseTestcaseT213 implements Output {
			private String name;
			public TestcaseTestcaseT213(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT213all(source.get(bookmark));
			}
		}

		// testcase.setT214empty(String t214empty);
		public class TestcaseTestcaseT214empty implements Output {
			private String name;
			public TestcaseTestcaseT214empty(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT214empty(source.get(bookmark));
			}
		}

		// testcase.setT214all(String t214);
		public class TestcaseTestcaseT214 implements Output {
			private String name;
			public TestcaseTestcaseT214(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setT214all(source.get(bookmark));
			}
		}

		// testcase.setEnd(void end);
		public class TestcaseTestcaseEnd implements Output {
			private String name;
			public TestcaseTestcaseEnd(String name) { this.name = name; }
			public boolean receive() { return false; }
			public void init(Source source) { }
			public void set(Source source, int bookmark) {
				peekTestcase().setEnd();
			}
		}

		public class False_getFalse implements net.sf.laja.parser.engine2.element.Variable.Condition {
			public boolean isTrue() {
				return peekTestcase().getFalse();
			}
		}

		public class True_getTrue implements net.sf.laja.parser.engine2.element.Variable.Condition {
			public boolean isTrue() {
				return peekTestcase().getTrue();
			}
		}

		public class X_getT511a implements net.sf.laja.parser.engine2.element.Variable.Value {
			public String getValue() {
				return peekTestcase().getT511a();
			}
		}
	}
}
