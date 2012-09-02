package net.sf.laja.parser;

import java.util.Stack;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.ParsingResult;
import net.sf.laja.parser.engine2.Repeats;
import net.sf.laja.parser.engine2.element.AndList;
import net.sf.laja.parser.engine2.element.Chr;
import net.sf.laja.parser.engine2.element.Complete;
import net.sf.laja.parser.engine2.element.Element;
import net.sf.laja.parser.engine2.element.ElementList;
import net.sf.laja.parser.engine2.element.End;
import net.sf.laja.parser.engine2.element.FollowedBy;
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
 * Auto generated 2010-11-26 by Laja:
 *    http://laja.sf.net
 *
 * Version: laja2-005-beta
 */
public final class GrammarParser implements net.sf.laja.parser.engine2.Parser {
    private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
    private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
    private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

    private Data data1;
    private Data data2;
    private IGrammarFactory factory1;
    private IGrammarFactory factory2;
    private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
    private SyntaxErrorHandler syntaxErrorHandler;

    public static final int PHASE1 = 1;
    public static final int PHASE2 = 2;

    public GrammarParser(IGrammarFactoryFactory factoryFactory) {
        init(factoryFactory);
    }

    public void init(IGrammarFactoryFactory factoryFactory) {
        syntaxErrorHandler = new DefaultSyntaxErrorHandler();
        factory1 = factoryFactory.getFactory(PHASE1);
        factory2 = factoryFactory.getFactory(PHASE2);
        data1 = new Data(factory1);
        data2 = new Data(factory2);
    }

    public GrammarParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
        sourceRecorderLogWriter = writer;
        return this;
    }

    public GrammarParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
        this.syntaxErrorHandler = syntaxErrorHandler;
        return this;
    }

    public IGrammarFactory getFactory1() {
        return factory1;
    }

    public IGrammarFactory getFactory() {
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
        Data.GrammarNewline grammarNewline = data2.new GrammarNewline("grammarNewline");
        Data.IntegerInteger integerInteger = data2.new IntegerInteger("integerInteger");
        Data.StrStrStrval strStrStrval = data2.new StrStrStrval("strStrStrval");
        Data.ReferenceReference referenceReference = data2.new ReferenceReference("referenceReference");
        Data.VariableVariableName variableVariableName = data2.new VariableVariableName("variableVariableName");
        Data.Range1Range1Integer range1Range1Integer = data2.new Range1Range1Integer("range1Range1Integer");
        Data.Range1Range1Str range1Range1Str = data2.new Range1Range1Str("range1Range1Str");
        Data.RangeRangeRange1 rangeRangeRange1 = data2.new RangeRangeRange1("rangeRangeRange1");
        Data.RepeatsRepeatsMin repeatsRepeatsMin = data2.new RepeatsRepeatsMin("repeatsRepeatsMin");
        Data.RepeatsRepeatsMax repeatsRepeatsMax = data2.new RepeatsRepeatsMax("repeatsRepeatsMax");
        Data.ValxValxVarname valxValxVarname = data2.new ValxValxVarname("valxValxVarname");
        Data.ValxValxRepeat valxValxRepeat = data2.new ValxValxRepeat("valxValxRepeat");
        Data.ValxValxRepeats valxValxRepeats = data2.new ValxValxRepeats("valxValxRepeats");
        Data.ValxValxRepeatName valxValxRepeatName = data2.new ValxValxRepeatName("valxValxRepeatName");
        Data.MarkerMarkerName markerMarkerName = data2.new MarkerMarkerName("markerMarkerName");
        Data.ValprimValprimNot valprimValprimNot = data2.new ValprimValprimNot("valprimValprimNot");
        Data.ValprimValprimRange valprimValprimRange = data2.new ValprimValprimRange("valprimValprimRange");
        Data.ValprimValprimInteger valprimValprimInteger = data2.new ValprimValprimInteger("valprimValprimInteger");
        Data.ValprimValprimStr valprimValprimStr = data2.new ValprimValprimStr("valprimValprimStr");
        Data.ValprimValprimReference valprimValprimReference = data2.new ValprimValprimReference("valprimValprimReference");
        Data.ValprimValprimVariable valprimValprimVariable = data2.new ValprimValprimVariable("valprimValprimVariable");
        Data.ValprimValprimComplete valprimValprimComplete = data2.new ValprimValprimComplete("valprimValprimComplete");
        Data.ValprimValprimEnd valprimValprimEnd = data2.new ValprimValprimEnd("valprimValprimEnd");
        Data.ValprimValprimValx valprimValprimValx = data2.new ValprimValprimValx("valprimValprimValx");
        Data.ValparValparNot valparValparNot = data2.new ValparValparNot("valparValparNot");
        Data.ValparValparCs valparValparCs = data2.new ValparValparCs("valparValparCs");
        Data.ValparValparCi valparValparCi = data2.new ValparValparCi("valparValparCi");
        Data.ValparValparVal valparValparVal = data2.new ValparValparVal("valparValparVal");
        Data.ValparValparValx valparValparValx = data2.new ValparValparValx("valparValparValx");
        Data.ValorValorValprim valorValorValprim = data2.new ValorValorValprim("valorValorValprim");
        Data.ValorValorValpar valorValorValpar = data2.new ValorValorValpar("valorValorValpar");
        Data.ValoptValoptVal valoptValoptVal = data2.new ValoptValoptVal("valoptValoptVal");
        Data.ValoptValoptValx valoptValoptValx = data2.new ValoptValoptValx("valoptValoptValx");
        Data.ValandValandMainAnd valandValandMainAnd = data2.new ValandValandMainAnd("valandValandMainAnd");
        Data.ValandValandValor valandValandValor = data2.new ValandValandValor("valandValandValor");
        Data.ValandValandValopt valandValandValopt = data2.new ValandValandValopt("valandValandValopt");
        Data.ValstmtValstmtValand valstmtValstmtValand = data2.new ValstmtValstmtValand("valstmtValstmtValand");
        Data.ValstmtValstmtValor valstmtValstmtValor = data2.new ValstmtValstmtValor("valstmtValstmtValor");
        Data.ValstmtValstmtValopt valstmtValstmtValopt = data2.new ValstmtValstmtValopt("valstmtValstmtValopt");
        Data.ValstmtValstmtMarker valstmtValstmtMarker = data2.new ValstmtValstmtMarker("valstmtValstmtMarker");
        Data.ValValValstmt valValValstmt = data2.new ValValValstmt("valValValstmt");
        Data.ValValFollowedby valValFollowedby = data2.new ValValFollowedby("valValFollowedby");
        Data.DefDefVar defDefVar = data2.new DefDefVar("defDefVar");
        Data.DefDefVal defDefVal = data2.new DefDefVal("defDefVal");
        Data.ClassvarClassvarClass classvarClassvarClass = data2.new ClassvarClassvarClass("classvarClassvarClass");
        Data.ClassvarClassvarVar classvarClassvarVar = data2.new ClassvarClassvarVar("classvarClassvarVar");
        Data.ConstructorConstructorClassvar constructorConstructorClassvar = data2.new ConstructorConstructorClassvar("constructorConstructorClassvar");
        Data.OutputclassOutputclassClass outputclassOutputclassClass = data2.new OutputclassOutputclassClass("outputclassOutputclassClass");
        Data.OutputclassOutputclassConstructor outputclassOutputclassConstructor = data2.new OutputclassOutputclassConstructor("outputclassOutputclassConstructor");
        Data.OutputclassOutputclassVar outputclassOutputclassVar = data2.new OutputclassOutputclassVar("outputclassOutputclassVar");
        Data.OmargOmargStr omargOmargStr = data2.new OmargOmargStr("omargOmargStr");
        Data.OmargOmargIndex omargOmargIndex = data2.new OmargOmargIndex("omargOmargIndex");
        Data.OmargOmargArg omargOmargArg = data2.new OmargOmargArg("omargOmargArg");
        Data.OutputmethodOutputmethodClass outputmethodOutputmethodClass = data2.new OutputmethodOutputmethodClass("outputmethodOutputmethodClass");
        Data.OutputmethodOutputmethodConstructor outputmethodOutputmethodConstructor = data2.new OutputmethodOutputmethodConstructor("outputmethodOutputmethodConstructor");
        Data.OutputmethodOutputmethodSetter outputmethodOutputmethodSetter = data2.new OutputmethodOutputmethodSetter("outputmethodOutputmethodSetter");
        Data.OutputmethodOutputmethodRef outputmethodOutputmethodRef = data2.new OutputmethodOutputmethodRef("outputmethodOutputmethodRef");
        Data.OutputmethodOutputmethodMethod outputmethodOutputmethodMethod = data2.new OutputmethodOutputmethodMethod("outputmethodOutputmethodMethod");
        Data.OutputmethodOutputmethodVoid outputmethodOutputmethodVoid = data2.new OutputmethodOutputmethodVoid("outputmethodOutputmethodVoid");
        Data.OutputmethodOutputmethodStr outputmethodOutputmethodStr = data2.new OutputmethodOutputmethodStr("outputmethodOutputmethodStr");
        Data.OutputmethodOutputmethodIndex outputmethodOutputmethodIndex = data2.new OutputmethodOutputmethodIndex("outputmethodOutputmethodIndex");
        Data.OutputmethodOutputmethodArgclass outputmethodOutputmethodArgclass = data2.new OutputmethodOutputmethodArgclass("outputmethodOutputmethodArgclass");
        Data.OutputmethodOutputmethodCarg outputmethodOutputmethodCarg = data2.new OutputmethodOutputmethodCarg("outputmethodOutputmethodCarg");
        Data.OutputmethodOutputmethodArg outputmethodOutputmethodArg = data2.new OutputmethodOutputmethodArg("outputmethodOutputmethodArg");
        Data.OutputmethodOutputmethodOmarg outputmethodOutputmethodOmarg = data2.new OutputmethodOutputmethodOmarg("outputmethodOutputmethodOmarg");
        Data.OutputvarOutputvarVariable outputvarOutputvarVariable = data2.new OutputvarOutputvarVariable("outputvarOutputvarVariable");
        Data.OutputvarOutputvarBool outputvarOutputvarBool = data2.new OutputvarOutputvarBool("outputvarOutputvarBool");
        Data.OutputvarOutputvarStr outputvarOutputvarStr = data2.new OutputvarOutputvarStr("outputvarOutputvarStr");
        Data.OutputvarOutputvarRef outputvarOutputvarRef = data2.new OutputvarOutputvarRef("outputvarOutputvarRef");
        Data.OutputvarOutputvarMethod outputvarOutputvarMethod = data2.new OutputvarOutputvarMethod("outputvarOutputvarMethod");
        Data.GrammarGrammarGrammarname grammarGrammarGrammarname = data2.new GrammarGrammarGrammarname("grammarGrammarGrammarname");
        Data.GrammarGrammarDef grammarGrammarDef = data2.new GrammarGrammarDef("grammarGrammarDef");
        Data.GrammarGrammarOutputclass grammarGrammarOutputclass = data2.new GrammarGrammarOutputclass("grammarGrammarOutputclass");
        Data.GrammarGrammarOutputmethod grammarGrammarOutputmethod = data2.new GrammarGrammarOutputmethod("grammarGrammarOutputmethod");
        Data.GrammarGrammarOutputvar grammarGrammarOutputvar = data2.new GrammarGrammarOutputvar("grammarGrammarOutputvar");
        Data.RepeatsRepeatsInteger repeatsRepeatsInteger = data2.new RepeatsRepeatsInteger("repeatsRepeatsInteger");

        // *** Declarations ***
        OrList newline = new OrList(1, "newline", grammarNewline);
        OrList comment = new OrList(2, "comment");
        Repeat ws = new Repeat(3, "ws");
        Optional s = new Optional(4, "s");
        Range digit = new Range(5, "digit", "0", "9");
        Repeat integer = new Repeat(6, "integer", integerInteger);
        Range lower = new Range(7, "lower", "a", "z");
        Range upper = new Range(8, "upper", "A", "Z");
        Optional xname = new Optional(9, "xname");
        ElementList lname = new ElementList(10, "lname");
        ElementList uname = new ElementList(11, "uname");
        Str ff = new Str(12, "\"");
        ElementList str = new ElementList(13, "str");
        ElementList reference = new ElementList(14, "reference");
        ElementList variable = new ElementList(15, "variable");
        OrList range1 = new OrList(16, "range1");
        ElementList range = new ElementList(17, "range");
        Str end = new Str(18, "END");
        Str complete = new Str(19, "*");
        ElementList repeats = new ElementList(20, "repeats");
        ElementList valx = new ElementList(21, "valx");
        ElementList marker = new ElementList(22, "marker");
        ElementList valprim = new ElementList(23, "valprim");
        ElementList valpar = new ElementList(24, "valpar");
        ElementList valor = new ElementList(25, "valor");
        ElementList valopt = new ElementList(26, "valopt");
        ElementList valand = new ElementList(27, "valand");
        Repeat valstmt = new Repeat(28, "valstmt");
        ElementList val = new ElementList(29, "val");
        ElementList def = new ElementList(30, "def");
        ElementList classvar = new ElementList(31, "classvar");
        ElementList constructor = new ElementList(32, "constructor");
        ElementList outputclass = new ElementList(33, "outputclass");
        ElementList omarg = new ElementList(34, "omarg");
        ElementList outputmethod = new ElementList(35, "outputmethod");
        ElementList outputvar = new ElementList(36, "outputvar");
        ElementList grammar = new ElementList(37, "grammar");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(39, new Str(38, "\r\n"));
        newline.add(41, new Str(40, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(42, "comment_1");
        comment_1.add(44, new Str(43, "/*"));
        Optional comment_1_1 = new Optional(45, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(46, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(47, "comment_1_1_1_1");
        comment_1_1_1_1.add(48, comment);
        comment_1_1_1_1.add(50, new Str(49, "*/", NOT));
        comment_1_1_1.add(51, comment_1_1_1_1);
        comment_1_1.add(52, comment_1_1_1);
        comment_1.add(53, comment_1_1);
        comment_1.add(55, new Str(54, "*/"));
        comment.add(56, comment_1);
        ElementList comment_2 = new ElementList(57, "comment_2");
        comment_2.add(59, new Str(58, "//"));
        Optional comment_2_1 = new Optional(60, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(61, "comment_2_1_1");
        comment_2_1_1.add(62, newline, NOT);
        comment_2_1.add(63, comment_2_1_1);
        comment_2.add(64, comment_2_1);
        OrList comment_2_2 = new OrList(65, "comment_2_2");
        comment_2_2.add(66, newline);
        comment_2_2.add(68, new End(67, "comment_2_2"));
        comment_2.add(69, comment_2_2);
        comment.add(70, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(71, "ws_1");
        ws_1.add(72, newline);
        ws_1.add(74, new Str(73, " "));
        ws_1.add(76, new Str(75, "\t"));
        ws_1.add(77, comment);
        ws.add(78, ws_1);

        // s = [ws]
        s.add(79, ws);

        // digit = "0".."9"

        // integer = digit+
        integer.add(80, digit);

        // lower = "a".."z"

        // upper = "A".."Z"

        // xname = [lower|upper|digit]+
        Repeat xname_1 = new Repeat(81, "xname_1");
        OrList xname_1_1 = new OrList(82, "xname_1_1");
        xname_1_1.add(83, lower);
        xname_1_1.add(84, upper);
        xname_1_1.add(85, digit);
        xname_1.add(86, xname_1_1);
        xname.add(87, xname_1);

        // lname = lower xname
        lname.add(88, lower);
        lname.add(89, xname);

        // uname = upper xname
        uname.add(90, upper);
        uname.add(91, xname);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(92, ff);
        Repeat str_1 = new Repeat(93, "str_1", strStrStrval);
        OrList str_1_1 = new OrList(94, "str_1_1");
        str_1_1.add(96, new Str(95, "\\\""));
        OrList str_1_1_1 = new OrList(97, "str_1_1_1", NOT);
        str_1_1_1.add(98, ff);
        str_1_1_1.add(99, newline);
        str_1_1.add(100, str_1_1_1);
        str_1.add(101, str_1_1);
        str.add(102, str_1);
        str.add(103, ff);

        // reference = lname
        reference.add(104, lname, referenceReference);

        // variable = "$" lname:name
        variable.add(106, new Str(105, "$"));
        variable.add(107, lname, variableVariableName);

        // range1 = integer|str
        range1.add(108, integer, range1Range1Integer);
        range1.add(109, str, range1Range1Str);

        // range = range1 ".." range1
        range.add(110, range1, rangeRangeRange1);
        range.add(112, new Str(111, ".."));
        range.add(113, range1, rangeRangeRange1);

        // end = "END"

        // complete = "*"

        // repeats = "#" integer:min [".." (integer|"*"):max]
        repeats.add(115, new Str(114, "#"));
        repeats.add(116, integer, repeatsRepeatsMin);
        Optional repeats_1 = new Optional(117, "repeats_1");
        repeats_1.add(119, new Str(118, ".."));
        OrList repeats_1_1 = new OrList(120, "repeats_1_1", repeatsRepeatsMax);
        repeats_1_1.add(121, integer, repeatsRepeatsInteger);
        repeats_1_1.add(123, new Str(122, "*"));
        repeats_1.add(124, repeats_1_1);
        repeats.add(125, repeats_1);

        // valx = [":" lname:varname] ["+":repeat|repeats [":" lname:repeatName]]
        Optional valx_1 = new Optional(126, "valx_1");
        valx_1.add(128, new Str(127, ":"));
        valx_1.add(129, lname, valxValxVarname);
        valx.add(130, valx_1);
        Optional valx_2 = new Optional(131, "valx_2");
        OrList valx_2_1 = new OrList(132, "valx_2_1");
        valx_2_1.add(134, new Str(133, "+", valxValxRepeat));
        valx_2_1.add(135, repeats, valxValxRepeats);
        valx_2.add(136, valx_2_1);
        Optional valx_2_2 = new Optional(137, "valx_2_2");
        valx_2_2.add(139, new Str(138, ":"));
        valx_2_2.add(140, lname, valxValxRepeatName);
        valx_2.add(141, valx_2_2);
        valx.add(142, valx_2);

        // marker = ":" lname:name
        marker.add(144, new Str(143, ":"));
        marker.add(145, lname, markerMarkerName);

        // valprim = s ["!":not s] range|integer|str|reference|variable|complete|end valx
        valprim.add(146, s);
        Optional valprim_1 = new Optional(147, "valprim_1");
        valprim_1.add(149, new Str(148, "!", valprimValprimNot));
        valprim_1.add(150, s);
        valprim.add(151, valprim_1);
        OrList valprim_2 = new OrList(152, "valprim_2");
        valprim_2.add(153, range, valprimValprimRange);
        valprim_2.add(154, integer, valprimValprimInteger);
        valprim_2.add(155, str, valprimValprimStr);
        valprim_2.add(156, reference, valprimValprimReference);
        valprim_2.add(157, variable, valprimValprimVariable);
        valprim_2.add(158, complete, valprimValprimComplete);
        valprim_2.add(159, end, valprimValprimEnd);
        valprim.add(160, valprim_2);
        valprim.add(161, valx, valprimValprimValx);

        // valpar = s ["!":not s] ["CS":cs|"CI":ci s] "(" s val s ")" valx
        valpar.add(162, s);
        Optional valpar_1 = new Optional(163, "valpar_1");
        valpar_1.add(165, new Str(164, "!", valparValparNot));
        valpar_1.add(166, s);
        valpar.add(167, valpar_1);
        Optional valpar_2 = new Optional(168, "valpar_2");
        OrList valpar_2_1 = new OrList(169, "valpar_2_1");
        valpar_2_1.add(171, new Str(170, "CS", valparValparCs));
        valpar_2_1.add(173, new Str(172, "CI", valparValparCi));
        valpar_2.add(174, valpar_2_1);
        valpar_2.add(175, s);
        valpar.add(176, valpar_2);
        valpar.add(178, new Str(177, "("));
        valpar.add(179, s);
        valpar.add(180, val, valparValparVal);
        valpar.add(181, s);
        valpar.add(183, new Str(182, ")"));
        valpar.add(184, valx, valparValparValx);

        // valor = s valprim|valpar [s "|" s valprim|valpar]+
        valor.add(185, s);
        OrList valor_1 = new OrList(186, "valor_1");
        valor_1.add(187, valprim, valorValorValprim);
        valor_1.add(188, valpar, valorValorValpar);
        valor.add(189, valor_1);
        Optional valor_2 = new Optional(190, "valor_2");
        Repeat valor_2_1 = new Repeat(191, "valor_2_1");
        valor_2_1.add(192, s);
        valor_2_1.add(194, new Str(193, "|"));
        valor_2_1.add(195, s);
        OrList valor_2_1_1 = new OrList(196, "valor_2_1_1");
        valor_2_1_1.add(197, valprim, valorValorValprim);
        valor_2_1_1.add(198, valpar, valorValorValpar);
        valor_2_1.add(199, valor_2_1_1);
        valor_2.add(200, valor_2_1);
        valor.add(201, valor_2);

        // valopt = s "[" s val s "]" valx
        valopt.add(202, s);
        valopt.add(204, new Str(203, "["));
        valopt.add(205, s);
        valopt.add(206, val, valoptValoptVal);
        valopt.add(207, s);
        valopt.add(209, new Str(208, "]"));
        valopt.add(210, valx, valoptValoptValx);

        // valand = valor:mainAnd s "&" s valor|valopt [s "&" s valor|valopt]+
        valand.add(211, valor, valandValandMainAnd);
        valand.add(212, s);
        valand.add(214, new Str(213, "&"));
        valand.add(215, s);
        OrList valand_1 = new OrList(216, "valand_1");
        valand_1.add(217, valor, valandValandValor);
        valand_1.add(218, valopt, valandValandValopt);
        valand.add(219, valand_1);
        Optional valand_2 = new Optional(220, "valand_2");
        Repeat valand_2_1 = new Repeat(221, "valand_2_1");
        valand_2_1.add(222, s);
        valand_2_1.add(224, new Str(223, "&"));
        valand_2_1.add(225, s);
        OrList valand_2_1_1 = new OrList(226, "valand_2_1_1");
        valand_2_1_1.add(227, valor, valandValandValor);
        valand_2_1_1.add(228, valopt, valandValandValopt);
        valand_2_1.add(229, valand_2_1_1);
        valand_2.add(230, valand_2_1);
        valand.add(231, valand_2);

        // valstmt = (s valand|valor|valopt|marker)+
        valstmt.add(232, s);
        OrList valstmt_1 = new OrList(233, "valstmt_1");
        valstmt_1.add(234, valand, valstmtValstmtValand);
        valstmt_1.add(235, valor, valstmtValstmtValor);
        valstmt_1.add(236, valopt, valstmtValstmtValopt);
        valstmt_1.add(237, marker, valstmtValstmtMarker);
        valstmt.add(238, valstmt_1);

        // val = valstmt [s 92 s valstmt:followedby]
        val.add(239, valstmt, valValValstmt);
        Optional val_1 = new Optional(240, "val_1");
        val_1.add(241, s);
        val_1.add(243, new Chr(242, (char)92));
        val_1.add(244, s);
        val_1.add(245, valstmt, valValFollowedby);
        val.add(246, val_1);

        // def = lname:var s "=" s val s ";"
        def.add(247, lname, defDefVar);
        def.add(248, s);
        def.add(250, new Str(249, "="));
        def.add(251, s);
        def.add(252, val, defDefVal);
        def.add(253, s);
        def.add(255, new Str(254, ";"));

        // classvar = uname:class ws lname:var
        classvar.add(256, uname, classvarClassvarClass);
        classvar.add(257, ws);
        classvar.add(258, lname, classvarClassvarVar);

        // constructor = "(" s classvar s ["," s classvar s]+ ")"
        constructor.add(260, new Str(259, "("));
        constructor.add(261, s);
        constructor.add(262, classvar, constructorConstructorClassvar);
        constructor.add(263, s);
        Optional constructor_1 = new Optional(264, "constructor_1");
        Repeat constructor_1_1 = new Repeat(265, "constructor_1_1");
        constructor_1_1.add(267, new Str(266, ","));
        constructor_1_1.add(268, s);
        constructor_1_1.add(269, classvar, constructorConstructorClassvar);
        constructor_1_1.add(270, s);
        constructor_1.add(271, constructor_1_1);
        constructor.add(272, constructor_1);
        constructor.add(274, new Str(273, ")"));

        // outputclass = uname:class [constructor] ws lname:var s ";"
        outputclass.add(275, uname, outputclassOutputclassClass);
        Optional outputclass_1 = new Optional(276, "outputclass_1");
        outputclass_1.add(277, constructor, outputclassOutputclassConstructor);
        outputclass.add(278, outputclass_1);
        outputclass.add(279, ws);
        outputclass.add(280, lname, outputclassOutputclassVar);
        outputclass.add(281, s);
        outputclass.add(283, new Str(282, ";"));

        // omarg = s "," s "String":str | "Index":index ws lname:arg
        omarg.add(284, s);
        omarg.add(286, new Str(285, ","));
        omarg.add(287, s);
        OrList omarg_1 = new OrList(288, "omarg_1");
        omarg_1.add(290, new Str(289, "String", omargOmargStr));
        omarg_1.add(292, new Str(291, "Index", omargOmargIndex));
        omarg.add(293, omarg_1);
        omarg.add(294, ws);
        omarg.add(295, lname, omargOmargArg);

        // outputmethod =
        //   [uname:class [constructor] ws] ["$":setter ws] lname:ref "." lname:method s "(" s
        //   (("void":void ws) | ("String":str ws) | ("Index":index ws) | (uname:argclass ws)
        //   [lname:carg "."] (lname|"*"):arg)
        //   [omarg+] s ")" s ";"
        Optional outputmethod_1 = new Optional(296, "outputmethod_1");
        outputmethod_1.add(297, uname, outputmethodOutputmethodClass);
        Optional outputmethod_1_1 = new Optional(298, "outputmethod_1_1");
        outputmethod_1_1.add(299, constructor, outputmethodOutputmethodConstructor);
        outputmethod_1.add(300, outputmethod_1_1);
        outputmethod_1.add(301, ws);
        outputmethod.add(302, outputmethod_1);
        Optional outputmethod_2 = new Optional(303, "outputmethod_2");
        outputmethod_2.add(305, new Str(304, "$", outputmethodOutputmethodSetter));
        outputmethod_2.add(306, ws);
        outputmethod.add(307, outputmethod_2);
        outputmethod.add(308, lname, outputmethodOutputmethodRef);
        outputmethod.add(310, new Str(309, "."));
        outputmethod.add(311, lname, outputmethodOutputmethodMethod);
        outputmethod.add(312, s);
        outputmethod.add(314, new Str(313, "("));
        outputmethod.add(315, s);
        ElementList outputmethod_3 = new ElementList(316, "outputmethod_3");
        OrList outputmethod_3_1 = new OrList(317, "outputmethod_3_1");
        ElementList outputmethod_3_1_1 = new ElementList(318, "outputmethod_3_1_1");
        outputmethod_3_1_1.add(320, new Str(319, "void", outputmethodOutputmethodVoid));
        outputmethod_3_1_1.add(321, ws);
        outputmethod_3_1.add(322, outputmethod_3_1_1);
        ElementList outputmethod_3_1_2 = new ElementList(323, "outputmethod_3_1_2");
        outputmethod_3_1_2.add(325, new Str(324, "String", outputmethodOutputmethodStr));
        outputmethod_3_1_2.add(326, ws);
        outputmethod_3_1.add(327, outputmethod_3_1_2);
        ElementList outputmethod_3_1_3 = new ElementList(328, "outputmethod_3_1_3");
        outputmethod_3_1_3.add(330, new Str(329, "Index", outputmethodOutputmethodIndex));
        outputmethod_3_1_3.add(331, ws);
        outputmethod_3_1.add(332, outputmethod_3_1_3);
        ElementList outputmethod_3_1_4 = new ElementList(333, "outputmethod_3_1_4");
        outputmethod_3_1_4.add(334, uname, outputmethodOutputmethodArgclass);
        outputmethod_3_1_4.add(335, ws);
        outputmethod_3_1.add(336, outputmethod_3_1_4);
        outputmethod_3.add(337, outputmethod_3_1);
        Optional outputmethod_3_2 = new Optional(338, "outputmethod_3_2");
        outputmethod_3_2.add(339, lname, outputmethodOutputmethodCarg);
        outputmethod_3_2.add(341, new Str(340, "."));
        outputmethod_3.add(342, outputmethod_3_2);
        OrList outputmethod_3_3 = new OrList(343, "outputmethod_3_3", outputmethodOutputmethodArg);
        outputmethod_3_3.add(344, lname);
        outputmethod_3_3.add(346, new Str(345, "*"));
        outputmethod_3.add(347, outputmethod_3_3);
        outputmethod.add(348, outputmethod_3);
        Optional outputmethod_4 = new Optional(349, "outputmethod_4");
        Repeat outputmethod_4_1 = new Repeat(350, "outputmethod_4_1");
        outputmethod_4_1.add(351, omarg, outputmethodOutputmethodOmarg);
        outputmethod_4.add(352, outputmethod_4_1);
        outputmethod.add(353, outputmethod_4);
        outputmethod.add(354, s);
        outputmethod.add(356, new Str(355, ")"));
        outputmethod.add(357, s);
        outputmethod.add(359, new Str(358, ";"));

        // outputvar =
        //   "$" lname:variable ws "boolean":bool | "String":str ws
        //   lname:ref "." lname:method s "()" s ";"
        outputvar.add(361, new Str(360, "$"));
        outputvar.add(362, lname, outputvarOutputvarVariable);
        outputvar.add(363, ws);
        OrList outputvar_1 = new OrList(364, "outputvar_1");
        outputvar_1.add(366, new Str(365, "boolean", outputvarOutputvarBool));
        outputvar_1.add(368, new Str(367, "String", outputvarOutputvarStr));
        outputvar.add(369, outputvar_1);
        outputvar.add(370, ws);
        outputvar.add(371, lname, outputvarOutputvarRef);
        outputvar.add(373, new Str(372, "."));
        outputvar.add(374, lname, outputvarOutputvarMethod);
        outputvar.add(375, s);
        outputvar.add(377, new Str(376, "()"));
        outputvar.add(378, s);
        outputvar.add(380, new Str(379, ";"));

        // grammar = s "grammar" ws lname:grammarname s "{" s (def|outputclass|outputmethod|outputvar s)+ "}" s
        grammar.add(381, s);
        grammar.add(383, new Str(382, "grammar"));
        grammar.add(384, ws);
        grammar.add(385, lname, grammarGrammarGrammarname);
        grammar.add(386, s);
        grammar.add(388, new Str(387, "{"));
        grammar.add(389, s);
        Repeat grammar_1 = new Repeat(390, "grammar_1");
        OrList grammar_1_1 = new OrList(391, "grammar_1_1");
        grammar_1_1.add(392, def, grammarGrammarDef);
        grammar_1_1.add(393, outputclass, grammarGrammarOutputclass);
        grammar_1_1.add(394, outputmethod, grammarGrammarOutputmethod);
        grammar_1_1.add(395, outputvar, grammarGrammarOutputvar);
        grammar_1.add(396, grammar_1_1);
        grammar_1.add(397, s);
        grammar.add(398, grammar_1);
        grammar.add(400, new Str(399, "}"));
        grammar.add(401, s);

        return new TopElement(data2, grammar);
    }

    private net.sf.laja.parser.engine2.element.Element getGrammar1() {
        // *** Output classes ***

        // *** Declarations ***
        OrList newline = new OrList(1, "newline");
        OrList comment = new OrList(2, "comment");
        Repeat ws = new Repeat(3, "ws");
        Optional s = new Optional(4, "s");
        Range digit = new Range(5, "digit", "0", "9");
        Repeat integer = new Repeat(6, "integer");
        Range lower = new Range(7, "lower", "a", "z");
        Range upper = new Range(8, "upper", "A", "Z");
        Optional xname = new Optional(9, "xname");
        ElementList lname = new ElementList(10, "lname");
        ElementList uname = new ElementList(11, "uname");
        Str ff = new Str(12, "\"");
        ElementList str = new ElementList(13, "str");
        ElementList reference = new ElementList(14, "reference");
        ElementList variable = new ElementList(15, "variable");
        OrList range1 = new OrList(16, "range1");
        ElementList range = new ElementList(17, "range");
        Str end = new Str(18, "END");
        Str complete = new Str(19, "*");
        ElementList repeats = new ElementList(20, "repeats");
        ElementList valx = new ElementList(21, "valx");
        ElementList marker = new ElementList(22, "marker");
        ElementList valprim = new ElementList(23, "valprim");
        ElementList valpar = new ElementList(24, "valpar");
        ElementList valor = new ElementList(25, "valor");
        ElementList valopt = new ElementList(26, "valopt");
        ElementList valand = new ElementList(27, "valand");
        Repeat valstmt = new Repeat(28, "valstmt");
        ElementList val = new ElementList(29, "val");
        ElementList def = new ElementList(30, "def");
        ElementList classvar = new ElementList(31, "classvar");
        ElementList constructor = new ElementList(32, "constructor");
        ElementList outputclass = new ElementList(33, "outputclass");
        ElementList omarg = new ElementList(34, "omarg");
        ElementList outputmethod = new ElementList(35, "outputmethod");
        ElementList outputvar = new ElementList(36, "outputvar");
        ElementList grammar = new ElementList(37, "grammar");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(39, new Str(38, "\r\n"));
        newline.add(41, new Str(40, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(42, "comment_1");
        comment_1.add(44, new Str(43, "/*"));
        Optional comment_1_1 = new Optional(45, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(46, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(47, "comment_1_1_1_1");
        comment_1_1_1_1.add(48, comment);
        comment_1_1_1_1.add(50, new Str(49, "*/", NOT));
        comment_1_1_1.add(51, comment_1_1_1_1);
        comment_1_1.add(52, comment_1_1_1);
        comment_1.add(53, comment_1_1);
        comment_1.add(55, new Str(54, "*/"));
        comment.add(56, comment_1);
        ElementList comment_2 = new ElementList(57, "comment_2");
        comment_2.add(59, new Str(58, "//"));
        Optional comment_2_1 = new Optional(60, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(61, "comment_2_1_1");
        comment_2_1_1.add(62, newline, NOT);
        comment_2_1.add(63, comment_2_1_1);
        comment_2.add(64, comment_2_1);
        OrList comment_2_2 = new OrList(65, "comment_2_2");
        comment_2_2.add(66, newline);
        comment_2_2.add(68, new End(67, "comment_2_2"));
        comment_2.add(69, comment_2_2);
        comment.add(70, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(71, "ws_1");
        ws_1.add(72, newline);
        ws_1.add(74, new Str(73, " "));
        ws_1.add(76, new Str(75, "\t"));
        ws_1.add(77, comment);
        ws.add(78, ws_1);

        // s = [ws]
        s.add(79, ws);

        // digit = "0".."9"

        // integer = digit+
        integer.add(80, digit);

        // lower = "a".."z"

        // upper = "A".."Z"

        // xname = [lower|upper|digit]+
        Repeat xname_1 = new Repeat(81, "xname_1");
        OrList xname_1_1 = new OrList(82, "xname_1_1");
        xname_1_1.add(83, lower);
        xname_1_1.add(84, upper);
        xname_1_1.add(85, digit);
        xname_1.add(86, xname_1_1);
        xname.add(87, xname_1);

        // lname = lower xname
        lname.add(88, lower);
        lname.add(89, xname);

        // uname = upper xname
        uname.add(90, upper);
        uname.add(91, xname);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(92, ff);
        Repeat str_1 = new Repeat(93, "str_1");
        OrList str_1_1 = new OrList(94, "str_1_1");
        str_1_1.add(96, new Str(95, "\\\""));
        OrList str_1_1_1 = new OrList(97, "str_1_1_1", NOT);
        str_1_1_1.add(98, ff);
        str_1_1_1.add(99, newline);
        str_1_1.add(100, str_1_1_1);
        str_1.add(101, str_1_1);
        str.add(102, str_1);
        str.add(103, ff);

        // reference = lname
        reference.add(104, lname);

        // variable = "$" lname:name
        variable.add(106, new Str(105, "$"));
        variable.add(107, lname);

        // range1 = integer|str
        range1.add(108, integer);
        range1.add(109, str);

        // range = range1 ".." range1
        range.add(110, range1);
        range.add(112, new Str(111, ".."));
        range.add(113, range1);

        // end = "END"

        // complete = "*"

        // repeats = "#" integer:min [".." (integer|"*"):max]
        repeats.add(115, new Str(114, "#"));
        repeats.add(116, integer);
        Optional repeats_1 = new Optional(117, "repeats_1");
        repeats_1.add(119, new Str(118, ".."));
        OrList repeats_1_1 = new OrList(120, "repeats_1_1");
        repeats_1_1.add(121, integer);
        repeats_1_1.add(123, new Str(122, "*"));
        repeats_1.add(124, repeats_1_1);
        repeats.add(125, repeats_1);

        // valx = [":" lname:varname] ["+":repeat|repeats [":" lname:repeatName]]
        Optional valx_1 = new Optional(126, "valx_1");
        valx_1.add(128, new Str(127, ":"));
        valx_1.add(129, lname);
        valx.add(130, valx_1);
        Optional valx_2 = new Optional(131, "valx_2");
        OrList valx_2_1 = new OrList(132, "valx_2_1");
        valx_2_1.add(134, new Str(133, "+"));
        valx_2_1.add(135, repeats);
        valx_2.add(136, valx_2_1);
        Optional valx_2_2 = new Optional(137, "valx_2_2");
        valx_2_2.add(139, new Str(138, ":"));
        valx_2_2.add(140, lname);
        valx_2.add(141, valx_2_2);
        valx.add(142, valx_2);

        // marker = ":" lname:name
        marker.add(144, new Str(143, ":"));
        marker.add(145, lname);

        // valprim = s ["!":not s] range|integer|str|reference|variable|complete|end valx
        valprim.add(146, s);
        Optional valprim_1 = new Optional(147, "valprim_1");
        valprim_1.add(149, new Str(148, "!"));
        valprim_1.add(150, s);
        valprim.add(151, valprim_1);
        OrList valprim_2 = new OrList(152, "valprim_2");
        valprim_2.add(153, range);
        valprim_2.add(154, integer);
        valprim_2.add(155, str);
        valprim_2.add(156, reference);
        valprim_2.add(157, variable);
        valprim_2.add(158, complete);
        valprim_2.add(159, end);
        valprim.add(160, valprim_2);
        valprim.add(161, valx);

        // valpar = s ["!":not s] ["CS":cs|"CI":ci s] "(" s val s ")" valx
        valpar.add(162, s);
        Optional valpar_1 = new Optional(163, "valpar_1");
        valpar_1.add(165, new Str(164, "!"));
        valpar_1.add(166, s);
        valpar.add(167, valpar_1);
        Optional valpar_2 = new Optional(168, "valpar_2");
        OrList valpar_2_1 = new OrList(169, "valpar_2_1");
        valpar_2_1.add(171, new Str(170, "CS"));
        valpar_2_1.add(173, new Str(172, "CI"));
        valpar_2.add(174, valpar_2_1);
        valpar_2.add(175, s);
        valpar.add(176, valpar_2);
        valpar.add(178, new Str(177, "("));
        valpar.add(179, s);
        valpar.add(180, val);
        valpar.add(181, s);
        valpar.add(183, new Str(182, ")"));
        valpar.add(184, valx);

        // valor = s valprim|valpar [s "|" s valprim|valpar]+
        valor.add(185, s);
        OrList valor_1 = new OrList(186, "valor_1");
        valor_1.add(187, valprim);
        valor_1.add(188, valpar);
        valor.add(189, valor_1);
        Optional valor_2 = new Optional(190, "valor_2");
        Repeat valor_2_1 = new Repeat(191, "valor_2_1");
        valor_2_1.add(192, s);
        valor_2_1.add(194, new Str(193, "|"));
        valor_2_1.add(195, s);
        OrList valor_2_1_1 = new OrList(196, "valor_2_1_1");
        valor_2_1_1.add(197, valprim);
        valor_2_1_1.add(198, valpar);
        valor_2_1.add(199, valor_2_1_1);
        valor_2.add(200, valor_2_1);
        valor.add(201, valor_2);

        // valopt = s "[" s val s "]" valx
        valopt.add(202, s);
        valopt.add(204, new Str(203, "["));
        valopt.add(205, s);
        valopt.add(206, val);
        valopt.add(207, s);
        valopt.add(209, new Str(208, "]"));
        valopt.add(210, valx);

        // valand = valor:mainAnd s "&" s valor|valopt [s "&" s valor|valopt]+
        valand.add(211, valor);
        valand.add(212, s);
        valand.add(214, new Str(213, "&"));
        valand.add(215, s);
        OrList valand_1 = new OrList(216, "valand_1");
        valand_1.add(217, valor);
        valand_1.add(218, valopt);
        valand.add(219, valand_1);
        Optional valand_2 = new Optional(220, "valand_2");
        Repeat valand_2_1 = new Repeat(221, "valand_2_1");
        valand_2_1.add(222, s);
        valand_2_1.add(224, new Str(223, "&"));
        valand_2_1.add(225, s);
        OrList valand_2_1_1 = new OrList(226, "valand_2_1_1");
        valand_2_1_1.add(227, valor);
        valand_2_1_1.add(228, valopt);
        valand_2_1.add(229, valand_2_1_1);
        valand_2.add(230, valand_2_1);
        valand.add(231, valand_2);

        // valstmt = (s valand|valor|valopt|marker)+
        valstmt.add(232, s);
        OrList valstmt_1 = new OrList(233, "valstmt_1");
        valstmt_1.add(234, valand);
        valstmt_1.add(235, valor);
        valstmt_1.add(236, valopt);
        valstmt_1.add(237, marker);
        valstmt.add(238, valstmt_1);

        // val = valstmt [s 92 s valstmt:followedby]
        val.add(239, valstmt);
        Optional val_1 = new Optional(240, "val_1");
        val_1.add(241, s);
        val_1.add(243, new Chr(242, (char)92));
        val_1.add(244, s);
        val_1.add(245, valstmt);
        val.add(246, val_1);

        // def = lname:var s "=" s val s ";"
        def.add(247, lname);
        def.add(248, s);
        def.add(250, new Str(249, "="));
        def.add(251, s);
        def.add(252, val);
        def.add(253, s);
        def.add(255, new Str(254, ";"));

        // classvar = uname:class ws lname:var
        classvar.add(256, uname);
        classvar.add(257, ws);
        classvar.add(258, lname);

        // constructor = "(" s classvar s ["," s classvar s]+ ")"
        constructor.add(260, new Str(259, "("));
        constructor.add(261, s);
        constructor.add(262, classvar);
        constructor.add(263, s);
        Optional constructor_1 = new Optional(264, "constructor_1");
        Repeat constructor_1_1 = new Repeat(265, "constructor_1_1");
        constructor_1_1.add(267, new Str(266, ","));
        constructor_1_1.add(268, s);
        constructor_1_1.add(269, classvar);
        constructor_1_1.add(270, s);
        constructor_1.add(271, constructor_1_1);
        constructor.add(272, constructor_1);
        constructor.add(274, new Str(273, ")"));

        // outputclass = uname:class [constructor] ws lname:var s ";"
        outputclass.add(275, uname);
        Optional outputclass_1 = new Optional(276, "outputclass_1");
        outputclass_1.add(277, constructor);
        outputclass.add(278, outputclass_1);
        outputclass.add(279, ws);
        outputclass.add(280, lname);
        outputclass.add(281, s);
        outputclass.add(283, new Str(282, ";"));

        // omarg = s "," s "String":str | "Index":index ws lname:arg
        omarg.add(284, s);
        omarg.add(286, new Str(285, ","));
        omarg.add(287, s);
        OrList omarg_1 = new OrList(288, "omarg_1");
        omarg_1.add(290, new Str(289, "String"));
        omarg_1.add(292, new Str(291, "Index"));
        omarg.add(293, omarg_1);
        omarg.add(294, ws);
        omarg.add(295, lname);

        // outputmethod =
        //   [uname:class [constructor] ws] ["$":setter ws] lname:ref "." lname:method s "(" s
        //   (("void":void ws) | ("String":str ws) | ("Index":index ws) | (uname:argclass ws)
        //   [lname:carg "."] (lname|"*"):arg)
        //   [omarg+] s ")" s ";"
        Optional outputmethod_1 = new Optional(296, "outputmethod_1");
        outputmethod_1.add(297, uname);
        Optional outputmethod_1_1 = new Optional(298, "outputmethod_1_1");
        outputmethod_1_1.add(299, constructor);
        outputmethod_1.add(300, outputmethod_1_1);
        outputmethod_1.add(301, ws);
        outputmethod.add(302, outputmethod_1);
        Optional outputmethod_2 = new Optional(303, "outputmethod_2");
        outputmethod_2.add(305, new Str(304, "$"));
        outputmethod_2.add(306, ws);
        outputmethod.add(307, outputmethod_2);
        outputmethod.add(308, lname);
        outputmethod.add(310, new Str(309, "."));
        outputmethod.add(311, lname);
        outputmethod.add(312, s);
        outputmethod.add(314, new Str(313, "("));
        outputmethod.add(315, s);
        ElementList outputmethod_3 = new ElementList(316, "outputmethod_3");
        OrList outputmethod_3_1 = new OrList(317, "outputmethod_3_1");
        ElementList outputmethod_3_1_1 = new ElementList(318, "outputmethod_3_1_1");
        outputmethod_3_1_1.add(320, new Str(319, "void"));
        outputmethod_3_1_1.add(321, ws);
        outputmethod_3_1.add(322, outputmethod_3_1_1);
        ElementList outputmethod_3_1_2 = new ElementList(323, "outputmethod_3_1_2");
        outputmethod_3_1_2.add(325, new Str(324, "String"));
        outputmethod_3_1_2.add(326, ws);
        outputmethod_3_1.add(327, outputmethod_3_1_2);
        ElementList outputmethod_3_1_3 = new ElementList(328, "outputmethod_3_1_3");
        outputmethod_3_1_3.add(330, new Str(329, "Index"));
        outputmethod_3_1_3.add(331, ws);
        outputmethod_3_1.add(332, outputmethod_3_1_3);
        ElementList outputmethod_3_1_4 = new ElementList(333, "outputmethod_3_1_4");
        outputmethod_3_1_4.add(334, uname);
        outputmethod_3_1_4.add(335, ws);
        outputmethod_3_1.add(336, outputmethod_3_1_4);
        outputmethod_3.add(337, outputmethod_3_1);
        Optional outputmethod_3_2 = new Optional(338, "outputmethod_3_2");
        outputmethod_3_2.add(339, lname);
        outputmethod_3_2.add(341, new Str(340, "."));
        outputmethod_3.add(342, outputmethod_3_2);
        OrList outputmethod_3_3 = new OrList(343, "outputmethod_3_3");
        outputmethod_3_3.add(344, lname);
        outputmethod_3_3.add(346, new Str(345, "*"));
        outputmethod_3.add(347, outputmethod_3_3);
        outputmethod.add(348, outputmethod_3);
        Optional outputmethod_4 = new Optional(349, "outputmethod_4");
        Repeat outputmethod_4_1 = new Repeat(350, "outputmethod_4_1");
        outputmethod_4_1.add(351, omarg);
        outputmethod_4.add(352, outputmethod_4_1);
        outputmethod.add(353, outputmethod_4);
        outputmethod.add(354, s);
        outputmethod.add(356, new Str(355, ")"));
        outputmethod.add(357, s);
        outputmethod.add(359, new Str(358, ";"));

        // outputvar =
        //   "$" lname:variable ws "boolean":bool | "String":str ws
        //   lname:ref "." lname:method s "()" s ";"
        outputvar.add(361, new Str(360, "$"));
        outputvar.add(362, lname);
        outputvar.add(363, ws);
        OrList outputvar_1 = new OrList(364, "outputvar_1");
        outputvar_1.add(366, new Str(365, "boolean"));
        outputvar_1.add(368, new Str(367, "String"));
        outputvar.add(369, outputvar_1);
        outputvar.add(370, ws);
        outputvar.add(371, lname);
        outputvar.add(373, new Str(372, "."));
        outputvar.add(374, lname);
        outputvar.add(375, s);
        outputvar.add(377, new Str(376, "()"));
        outputvar.add(378, s);
        outputvar.add(380, new Str(379, ";"));

        // grammar = s "grammar" ws lname:grammarname s "{" s (def|outputclass|outputmethod|outputvar s)+ "}" s
        grammar.add(381, s);
        grammar.add(383, new Str(382, "grammar"));
        grammar.add(384, ws);
        grammar.add(385, lname);
        grammar.add(386, s);
        grammar.add(388, new Str(387, "{"));
        grammar.add(389, s);
        Repeat grammar_1 = new Repeat(390, "grammar_1");
        OrList grammar_1_1 = new OrList(391, "grammar_1_1");
        grammar_1_1.add(392, def);
        grammar_1_1.add(393, outputclass);
        grammar_1_1.add(394, outputmethod);
        grammar_1_1.add(395, outputvar);
        grammar_1.add(396, grammar_1_1);
        grammar_1.add(397, s);
        grammar.add(398, grammar_1);
        grammar.add(400, new Str(399, "}"));
        grammar.add(401, s);

        return new TopElement(data1, grammar);
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
            data.pushGrammar();
            boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
            data.popGrammar();
            return match;
        }
    }

    // *** IGrammarFactoryFactory
    public interface IGrammarFactoryFactory {
        public IGrammarFactory getFactory(int phase);
    }

    // *** IGrammarFactory ***
    public interface IGrammarFactory {
        GrammarParser.IGrammar createGrammar();
        GrammarParser.IValstmt createValstmt();
        GrammarParser.IVal createVal();
        GrammarParser.IValprim createValprim();
        GrammarParser.IValpar createValpar();
        GrammarParser.IValor createValor();
        GrammarParser.IValopt createValopt();
        GrammarParser.IValand createValand();
        GrammarParser.IRange1 createRange1();
        GrammarParser.IRange createRange();
        GrammarParser.IStr createStr();
        GrammarParser.IInteger createInteger();
        GrammarParser.IReference createReference(IGrammar grammar);
        GrammarParser.IVariable createVariable();
        GrammarParser.IEnd createEnd();
        GrammarParser.IComplete createComplete();
        GrammarParser.IMarker createMarker();
        GrammarParser.IRepeats createRepeats();
        GrammarParser.IValx createValx();
        GrammarParser.IDef createDef();
        GrammarParser.IClassvar createClassvar();
        GrammarParser.IConstructor createConstructor();
        GrammarParser.IOutputclass createOutputclass();
        GrammarParser.IOmarg createOmarg();
        GrammarParser.IOutputvar createOutputvar();
        GrammarParser.IOutputmethod createOutputmethod(IGrammar grammar);
    }

    // *** Interfaces ***
    // Grammar
    public interface IGrammar {
        public void setGrammarName(String grammarname);
        public void setDef(IDef idef);
        public void setOutputclass(IOutputclass ioutputclass);
        public void setOutputmethod(IOutputmethod ioutputmethod);
        public void setOutputvar(IOutputvar ioutputvar);
        public void addRow(Index newline);
    }

    // Valstmt
    public interface IValstmt {
        public void addValand(IValand ivaland);
        public void addValor(IValor ivalor);
        public void addValopt(IValopt ivalopt);
        public void addMarker(IMarker imarker);
    }

    // Val
    public interface IVal {
        public void setValstmt(IValstmt ivalstmt);
        public void setFollowedby(IValstmt ifollowedby);
    }

    // Valprim
    public interface IValprim {
        public void setNot();
        public void setRange(IRange irange);
        public void setInteger(IInteger iinteger);
        public void setStr(IStr istr);
        public void setReference(IReference ireference);
        public void setVariable(IVariable ivariable);
        public void setEnd(IEnd iend);
        public void setComplete(IComplete icomplete);
        public void setValx(IValx ivalx);
    }

    // Valpar
    public interface IValpar {
        public void setNot();
        public void setCs();
        public void setCi();
        public void setVal(IVal ival);
        public void setValx(IValx ivalx);
    }

    // Valor
    public interface IValor {
        public void addValprim(IValprim ivalprim);
        public void addValpar(IValpar ivalpar);
    }

    // Valopt
    public interface IValopt {
        public void setVal(IVal ival);
        public void setValx(IValx ivalx);
    }

    // Valand
    public interface IValand {
        public void setMainAnd(IValor imainAnd);
        public void addAndValor(IValor ivalor);
        public void addAndValopt(IValopt ivalopt);
    }

    // Range1
    public interface IRange1 {
        public void setInteger(String integer);
        public void setStr(IStr istr);
    }

    // Range
    public interface IRange {
        public void setRange1(IRange1 irange1);
    }

    // Str
    public interface IStr {
        public void setStrval(String strval);
    }

    // Integer
    public interface IInteger {
        public void setInt(String integer);
    }

    // Reference
    public interface IReference {
        public void setName(String reference);
    }

    // Variable
    public interface IVariable {
        public void setName(String name);
    }

    // End
    public interface IEnd {
    }

    // Complete
    public interface IComplete {
    }

    // Marker
    public interface IMarker {
        public void setName(String name);
    }

    // Repeats
    public interface IRepeats {
        public void setMin(String min);
        public void setMax(String max);
    }

    // Valx
    public interface IValx {
        public void setVarname(String varname);
        public void setRepeat();
        public void setRepeats(IRepeats irepeats);
        public void setRepeatName(String repeatName);
    }

    // Def
    public interface IDef {
        public void setVar(String var);
        public void setVal(IVal ival, String sval);
    }

    // Classvar
    public interface IClassvar {
        public void setClass(String _class);
        public void setVar(String var);
    }

    // Constructor
    public interface IConstructor {
        public void addClassvar(IClassvar iclassvar);
    }

    // Outputclass
    public interface IOutputclass {
        public void setClass(String _class);
        public void setConstructor(IConstructor iconstructor);
        public void setVar(String var);
    }

    // Omarg
    public interface IOmarg {
        public void setStr();
        public void setIndex();
        public void setArg(String arg);
    }

    // Outputvar
    public interface IOutputvar {
        public void setVariable(String variable);
        public void setDatatypeBool();
        public void setDatatypeString();
        public void setRef(String ref);
        public void setMethod(String method);
    }

    // Outputmethod
    public interface IOutputmethod {
        public void setClass(String _class);
        public void setConstructor(IConstructor iconstructor);
        public void setVariableSetter();
        public void setRef(String ref);
        public void setMethod(String method);
        public void setStr();
        public void setIndex();
        public void setArgClass(String argclass);
        public void setCarg(String carg);
        public void setArg(String arg);
        public void setVoid();
        public void setOmarg(IOmarg iomarg);
    }

    // *** Data ***
    public static final class Data {
        private GrammarParser.IGrammarFactory factory;
        private Stack<IGrammar> grammarStack = new Stack<IGrammar>();
        private Stack<IValstmt> valstmtStack = new Stack<IValstmt>();
        private Stack<IVal> valStack = new Stack<IVal>();
        private Stack<IValprim> valprimStack = new Stack<IValprim>();
        private Stack<IValpar> valparStack = new Stack<IValpar>();
        private Stack<IValor> valorStack = new Stack<IValor>();
        private Stack<IValopt> valoptStack = new Stack<IValopt>();
        private Stack<IValand> valandStack = new Stack<IValand>();
        private Stack<IRange1> range1Stack = new Stack<IRange1>();
        private Stack<IRange> rangeStack = new Stack<IRange>();
        private Stack<IStr> strStack = new Stack<IStr>();
        private Stack<IInteger> integerStack = new Stack<IInteger>();
        private Stack<IReference> referenceStack = new Stack<IReference>();
        private Stack<IVariable> variableStack = new Stack<IVariable>();
        private Stack<IEnd> endStack = new Stack<IEnd>();
        private Stack<IComplete> completeStack = new Stack<IComplete>();
        private Stack<IMarker> markerStack = new Stack<IMarker>();
        private Stack<IRepeats> repeatsStack = new Stack<IRepeats>();
        private Stack<IValx> valxStack = new Stack<IValx>();
        private Stack<IDef> defStack = new Stack<IDef>();
        private Stack<IClassvar> classvarStack = new Stack<IClassvar>();
        private Stack<IConstructor> constructorStack = new Stack<IConstructor>();
        private Stack<IOutputclass> outputclassStack = new Stack<IOutputclass>();
        private Stack<IOmarg> omargStack = new Stack<IOmarg>();
        private Stack<IOutputvar> outputvarStack = new Stack<IOutputvar>();
        private Stack<IOutputmethod> outputmethodStack = new Stack<IOutputmethod>();

        public Data(GrammarParser.IGrammarFactory factory) {
            this.factory = factory;
        }

        // Grammar
        public void pushGrammar() { grammarStack.push(factory.createGrammar()); }
        public GrammarParser.IGrammar popGrammar() { return (GrammarParser.IGrammar)grammarStack.pop(); }
        public GrammarParser.IGrammar peekGrammar() {
            if (grammarStack.empty()) { return null; }
            return grammarStack.peek();
        }

        // Valstmt
        public void pushValstmt() { valstmtStack.push(factory.createValstmt()); }
        public GrammarParser.IValstmt popValstmt() { return (GrammarParser.IValstmt)valstmtStack.pop(); }
        public GrammarParser.IValstmt peekValstmt() {
            if (valstmtStack.empty()) { return null; }
            return valstmtStack.peek();
        }

        // Val
        public void pushVal() { valStack.push(factory.createVal()); }
        public GrammarParser.IVal popVal() { return (GrammarParser.IVal)valStack.pop(); }
        public GrammarParser.IVal peekVal() {
            if (valStack.empty()) { return null; }
            return valStack.peek();
        }

        // Valprim
        public void pushValprim() { valprimStack.push(factory.createValprim()); }
        public GrammarParser.IValprim popValprim() { return (GrammarParser.IValprim)valprimStack.pop(); }
        public GrammarParser.IValprim peekValprim() {
            if (valprimStack.empty()) { return null; }
            return valprimStack.peek();
        }

        // Valpar
        public void pushValpar() { valparStack.push(factory.createValpar()); }
        public GrammarParser.IValpar popValpar() { return (GrammarParser.IValpar)valparStack.pop(); }
        public GrammarParser.IValpar peekValpar() {
            if (valparStack.empty()) { return null; }
            return valparStack.peek();
        }

        // Valor
        public void pushValor() { valorStack.push(factory.createValor()); }
        public GrammarParser.IValor popValor() { return (GrammarParser.IValor)valorStack.pop(); }
        public GrammarParser.IValor peekValor() {
            if (valorStack.empty()) { return null; }
            return valorStack.peek();
        }

        // Valopt
        public void pushValopt() { valoptStack.push(factory.createValopt()); }
        public GrammarParser.IValopt popValopt() { return (GrammarParser.IValopt)valoptStack.pop(); }
        public GrammarParser.IValopt peekValopt() {
            if (valoptStack.empty()) { return null; }
            return valoptStack.peek();
        }

        // Valand
        public void pushValand() { valandStack.push(factory.createValand()); }
        public GrammarParser.IValand popValand() { return (GrammarParser.IValand)valandStack.pop(); }
        public GrammarParser.IValand peekValand() {
            if (valandStack.empty()) { return null; }
            return valandStack.peek();
        }

        // Range1
        public void pushRange1() { range1Stack.push(factory.createRange1()); }
        public GrammarParser.IRange1 popRange1() { return (GrammarParser.IRange1)range1Stack.pop(); }
        public GrammarParser.IRange1 peekRange1() {
            if (range1Stack.empty()) { return null; }
            return range1Stack.peek();
        }

        // Range
        public void pushRange() { rangeStack.push(factory.createRange()); }
        public GrammarParser.IRange popRange() { return (GrammarParser.IRange)rangeStack.pop(); }
        public GrammarParser.IRange peekRange() {
            if (rangeStack.empty()) { return null; }
            return rangeStack.peek();
        }

        // Str
        public void pushStr() { strStack.push(factory.createStr()); }
        public GrammarParser.IStr popStr() { return (GrammarParser.IStr)strStack.pop(); }
        public GrammarParser.IStr peekStr() {
            if (strStack.empty()) { return null; }
            return strStack.peek();
        }

        // Integer
        public void pushInteger() { integerStack.push(factory.createInteger()); }
        public GrammarParser.IInteger popInteger() { return (GrammarParser.IInteger)integerStack.pop(); }
        public GrammarParser.IInteger peekInteger() {
            if (integerStack.empty()) { return null; }
            return integerStack.peek();
        }

        // Reference
        public void pushReference() { referenceStack.push(factory.createReference(peekGrammar())); }
        public GrammarParser.IReference popReference() { return (GrammarParser.IReference)referenceStack.pop(); }
        public GrammarParser.IReference peekReference() {
            if (referenceStack.empty()) { return null; }
            return referenceStack.peek();
        }

        // Variable
        public void pushVariable() { variableStack.push(factory.createVariable()); }
        public GrammarParser.IVariable popVariable() { return (GrammarParser.IVariable)variableStack.pop(); }
        public GrammarParser.IVariable peekVariable() {
            if (variableStack.empty()) { return null; }
            return variableStack.peek();
        }

        // End
        public void pushEnd() { endStack.push(factory.createEnd()); }
        public GrammarParser.IEnd popEnd() { return (GrammarParser.IEnd)endStack.pop(); }
        public GrammarParser.IEnd peekEnd() {
            if (endStack.empty()) { return null; }
            return endStack.peek();
        }

        // Complete
        public void pushComplete() { completeStack.push(factory.createComplete()); }
        public GrammarParser.IComplete popComplete() { return (GrammarParser.IComplete)completeStack.pop(); }
        public GrammarParser.IComplete peekComplete() {
            if (completeStack.empty()) { return null; }
            return completeStack.peek();
        }

        // Marker
        public void pushMarker() { markerStack.push(factory.createMarker()); }
        public GrammarParser.IMarker popMarker() { return (GrammarParser.IMarker)markerStack.pop(); }
        public GrammarParser.IMarker peekMarker() {
            if (markerStack.empty()) { return null; }
            return markerStack.peek();
        }

        // Repeats
        public void pushRepeats() { repeatsStack.push(factory.createRepeats()); }
        public GrammarParser.IRepeats popRepeats() { return (GrammarParser.IRepeats)repeatsStack.pop(); }
        public GrammarParser.IRepeats peekRepeats() {
            if (repeatsStack.empty()) { return null; }
            return repeatsStack.peek();
        }

        // Valx
        public void pushValx() { valxStack.push(factory.createValx()); }
        public GrammarParser.IValx popValx() { return (GrammarParser.IValx)valxStack.pop(); }
        public GrammarParser.IValx peekValx() {
            if (valxStack.empty()) { return null; }
            return valxStack.peek();
        }

        // Def
        public void pushDef() { defStack.push(factory.createDef()); }
        public GrammarParser.IDef popDef() { return (GrammarParser.IDef)defStack.pop(); }
        public GrammarParser.IDef peekDef() {
            if (defStack.empty()) { return null; }
            return defStack.peek();
        }

        // Classvar
        public void pushClassvar() { classvarStack.push(factory.createClassvar()); }
        public GrammarParser.IClassvar popClassvar() { return (GrammarParser.IClassvar)classvarStack.pop(); }
        public GrammarParser.IClassvar peekClassvar() {
            if (classvarStack.empty()) { return null; }
            return classvarStack.peek();
        }

        // Constructor
        public void pushConstructor() { constructorStack.push(factory.createConstructor()); }
        public GrammarParser.IConstructor popConstructor() { return (GrammarParser.IConstructor)constructorStack.pop(); }
        public GrammarParser.IConstructor peekConstructor() {
            if (constructorStack.empty()) { return null; }
            return constructorStack.peek();
        }

        // Outputclass
        public void pushOutputclass() { outputclassStack.push(factory.createOutputclass()); }
        public GrammarParser.IOutputclass popOutputclass() { return (GrammarParser.IOutputclass)outputclassStack.pop(); }
        public GrammarParser.IOutputclass peekOutputclass() {
            if (outputclassStack.empty()) { return null; }
            return outputclassStack.peek();
        }

        // Omarg
        public void pushOmarg() { omargStack.push(factory.createOmarg()); }
        public GrammarParser.IOmarg popOmarg() { return (GrammarParser.IOmarg)omargStack.pop(); }
        public GrammarParser.IOmarg peekOmarg() {
            if (omargStack.empty()) { return null; }
            return omargStack.peek();
        }

        // Outputvar
        public void pushOutputvar() { outputvarStack.push(factory.createOutputvar()); }
        public GrammarParser.IOutputvar popOutputvar() { return (GrammarParser.IOutputvar)outputvarStack.pop(); }
        public GrammarParser.IOutputvar peekOutputvar() {
            if (outputvarStack.empty()) { return null; }
            return outputvarStack.peek();
        }

        // Outputmethod
        public void pushOutputmethod() { outputmethodStack.push(factory.createOutputmethod(peekGrammar())); }
        public GrammarParser.IOutputmethod popOutputmethod() { return (GrammarParser.IOutputmethod)outputmethodStack.pop(); }
        public GrammarParser.IOutputmethod peekOutputmethod() {
            if (outputmethodStack.empty()) { return null; }
            return outputmethodStack.peek();
        }

        // grammar.addRow(Index newline.*);
        public class GrammarNewline implements Output {
            private String name;
            public GrammarNewline(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekGrammar().addRow(source.getIndex(bookmark));
            }
        }

        // Integer integer.setInt(String *);
        public class IntegerInteger implements Output {
            private String name;
            public IntegerInteger(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekInteger().setInt(source.get(bookmark));
            }
        }

        // Str str.setStrval(String strval);
        public class StrStrStrval implements Output {
            private String name;
            public StrStrStrval(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekStr().setStrval(source.get(bookmark));
            }
        }

        // Reference reference.setName(String *);
        public class ReferenceReference implements Output {
            private String name;
            public ReferenceReference(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekReference().setName(source.get(bookmark));
            }
        }

        // Variable variable.setName(String name);
        public class VariableVariableName implements Output {
            private String name;
            public VariableVariableName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekVariable().setName(source.get(bookmark));
            }
        }

        // Range1 range1.setInteger(String integer);
        public class Range1Range1Integer implements Output {
            private String name;
            public Range1Range1Integer(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushInteger(); }
            public void set(Source source, int bookmark) {
                popInteger();
                peekRange1().setInteger(source.get(bookmark));
            }
        }

        // range1.setStr(Str str);
        public class Range1Range1Str implements Output {
            private String name;
            public Range1Range1Str(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStr(); }
            public void set(Source source, int bookmark) {
                peekRange1().setStr(popStr());
            }
        }

        // Range range.setRange1(Range1 range1);
        public class RangeRangeRange1 implements Output {
            private String name;
            public RangeRangeRange1(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushRange1(); }
            public void set(Source source, int bookmark) {
                peekRange().setRange1(popRange1());
            }
        }

        // Repeats repeats.setMin(String min);
        public class RepeatsRepeatsMin implements Output {
            private String name;
            public RepeatsRepeatsMin(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushInteger(); }
            public void set(Source source, int bookmark) {
                popInteger();
                peekRepeats().setMin(source.get(bookmark));
            }
        }

        // repeats.setMax(String max);
        public class RepeatsRepeatsMax implements Output {
            private String name;
            public RepeatsRepeatsMax(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekRepeats().setMax(source.get(bookmark));
            }
        }

        // Valx valx.setVarname(String varname);
        public class ValxValxVarname implements Output {
            private String name;
            public ValxValxVarname(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekValx().setVarname(source.get(bookmark));
            }
        }

        // valx.setRepeat(void repeat);
        public class ValxValxRepeat implements Output {
            private String name;
            public ValxValxRepeat(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekValx().setRepeat();
            }
        }

        // valx.setRepeats(Repeats repeats);
        public class ValxValxRepeats implements Output {
            private String name;
            public ValxValxRepeats(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushRepeats(); }
            public void set(Source source, int bookmark) {
                peekValx().setRepeats(popRepeats());
            }
        }

        // valx.setRepeatName(String repeatName);
        public class ValxValxRepeatName implements Output {
            private String name;
            public ValxValxRepeatName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekValx().setRepeatName(source.get(bookmark));
            }
        }

        // Marker marker.setName(String name);
        public class MarkerMarkerName implements Output {
            private String name;
            public MarkerMarkerName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekMarker().setName(source.get(bookmark));
            }
        }

        // Valprim valprim.setNot(void not);
        public class ValprimValprimNot implements Output {
            private String name;
            public ValprimValprimNot(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekValprim().setNot();
            }
        }

        // valprim.setRange(Range range);
        public class ValprimValprimRange implements Output {
            private String name;
            public ValprimValprimRange(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushRange(); }
            public void set(Source source, int bookmark) {
                peekValprim().setRange(popRange());
            }
        }

        // valprim.setInteger(Integer integer);
        public class ValprimValprimInteger implements Output {
            private String name;
            public ValprimValprimInteger(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushInteger(); }
            public void set(Source source, int bookmark) {
                peekValprim().setInteger(popInteger());
            }
        }

        // valprim.setStr(Str str);
        public class ValprimValprimStr implements Output {
            private String name;
            public ValprimValprimStr(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStr(); }
            public void set(Source source, int bookmark) {
                peekValprim().setStr(popStr());
            }
        }

        // valprim.setReference(Reference reference);
        public class ValprimValprimReference implements Output {
            private String name;
            public ValprimValprimReference(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushReference(); }
            public void set(Source source, int bookmark) {
                peekValprim().setReference(popReference());
            }
        }

        // valprim.setVariable(Variable variable);
        public class ValprimValprimVariable implements Output {
            private String name;
            public ValprimValprimVariable(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushVariable(); }
            public void set(Source source, int bookmark) {
                peekValprim().setVariable(popVariable());
            }
        }

        // valprim.setComplete(Complete complete);
        public class ValprimValprimComplete implements Output {
            private String name;
            public ValprimValprimComplete(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushComplete(); }
            public void set(Source source, int bookmark) {
                peekValprim().setComplete(popComplete());
            }
        }

        // valprim.setEnd(End end);
        public class ValprimValprimEnd implements Output {
            private String name;
            public ValprimValprimEnd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushEnd(); }
            public void set(Source source, int bookmark) {
                peekValprim().setEnd(popEnd());
            }
        }

        // valprim.setValx(Valx valx);
        public class ValprimValprimValx implements Output {
            private String name;
            public ValprimValprimValx(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValx(); }
            public void set(Source source, int bookmark) {
                peekValprim().setValx(popValx());
            }
        }

        // Valpar valpar.setNot(void not);
        public class ValparValparNot implements Output {
            private String name;
            public ValparValparNot(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekValpar().setNot();
            }
        }

        // valpar.setCs(void cs);
        public class ValparValparCs implements Output {
            private String name;
            public ValparValparCs(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekValpar().setCs();
            }
        }

        // valpar.setCi(void ci);
        public class ValparValparCi implements Output {
            private String name;
            public ValparValparCi(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekValpar().setCi();
            }
        }

        // valpar.setVal(Val val);
        public class ValparValparVal implements Output {
            private String name;
            public ValparValparVal(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushVal(); }
            public void set(Source source, int bookmark) {
                peekValpar().setVal(popVal());
            }
        }

        // valpar.setValx(Valx valx);
        public class ValparValparValx implements Output {
            private String name;
            public ValparValparValx(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValx(); }
            public void set(Source source, int bookmark) {
                peekValpar().setValx(popValx());
            }
        }

        // Valor valor.addValprim(Valprim valprim);
        public class ValorValorValprim implements Output {
            private String name;
            public ValorValorValprim(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValprim(); }
            public void set(Source source, int bookmark) {
                peekValor().addValprim(popValprim());
            }
        }

        // valor.addValpar(Valpar valpar);
        public class ValorValorValpar implements Output {
            private String name;
            public ValorValorValpar(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValpar(); }
            public void set(Source source, int bookmark) {
                peekValor().addValpar(popValpar());
            }
        }

        // Valopt valopt.setVal(Val val);
        public class ValoptValoptVal implements Output {
            private String name;
            public ValoptValoptVal(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushVal(); }
            public void set(Source source, int bookmark) {
                peekValopt().setVal(popVal());
            }
        }

        // valopt.setValx(Valx valx);
        public class ValoptValoptValx implements Output {
            private String name;
            public ValoptValoptValx(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValx(); }
            public void set(Source source, int bookmark) {
                peekValopt().setValx(popValx());
            }
        }

        // Valand valand.setMainAnd(Valor mainAnd);
        public class ValandValandMainAnd implements Output {
            private String name;
            public ValandValandMainAnd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValor(); }
            public void set(Source source, int bookmark) {
                peekValand().setMainAnd(popValor());
            }
        }

        // valand.addAndValor(Valor valor);
        public class ValandValandValor implements Output {
            private String name;
            public ValandValandValor(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValor(); }
            public void set(Source source, int bookmark) {
                peekValand().addAndValor(popValor());
            }
        }

        // valand.addAndValopt(Valopt valopt);
        public class ValandValandValopt implements Output {
            private String name;
            public ValandValandValopt(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValopt(); }
            public void set(Source source, int bookmark) {
                peekValand().addAndValopt(popValopt());
            }
        }

        // Valstmt valstmt.addValand(Valand valand);
        public class ValstmtValstmtValand implements Output {
            private String name;
            public ValstmtValstmtValand(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValand(); }
            public void set(Source source, int bookmark) {
                peekValstmt().addValand(popValand());
            }
        }

        // valstmt.addValor(Valor valor);
        public class ValstmtValstmtValor implements Output {
            private String name;
            public ValstmtValstmtValor(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValor(); }
            public void set(Source source, int bookmark) {
                peekValstmt().addValor(popValor());
            }
        }

        // valstmt.addValopt(Valopt valopt);
        public class ValstmtValstmtValopt implements Output {
            private String name;
            public ValstmtValstmtValopt(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValopt(); }
            public void set(Source source, int bookmark) {
                peekValstmt().addValopt(popValopt());
            }
        }

        // valstmt.addMarker(Marker marker);
        public class ValstmtValstmtMarker implements Output {
            private String name;
            public ValstmtValstmtMarker(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMarker(); }
            public void set(Source source, int bookmark) {
                peekValstmt().addMarker(popMarker());
            }
        }

        // Val val.setValstmt(Valstmt valstmt);
        public class ValValValstmt implements Output {
            private String name;
            public ValValValstmt(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValstmt(); }
            public void set(Source source, int bookmark) {
                peekVal().setValstmt(popValstmt());
            }
        }

        // val.setFollowedby(Valstmt followedby);
        public class ValValFollowedby implements Output {
            private String name;
            public ValValFollowedby(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushValstmt(); }
            public void set(Source source, int bookmark) {
                peekVal().setFollowedby(popValstmt());
            }
        }

        // Def def.setVar(String var);
        public class DefDefVar implements Output {
            private String name;
            public DefDefVar(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekDef().setVar(source.get(bookmark));
            }
        }

        // def.setVal(Val val, String sval);
        public class DefDefVal implements Output {
            private String name;
            public DefDefVal(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushVal(); }
            public void set(Source source, int bookmark) {
                peekDef().setVal(popVal(), source.get(bookmark));
            }
        }

        // Classvar classvar.setClass(String class);
        public class ClassvarClassvarClass implements Output {
            private String name;
            public ClassvarClassvarClass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassvar().setClass(source.get(bookmark));
            }
        }

        // classvar.setVar(String var);
        public class ClassvarClassvarVar implements Output {
            private String name;
            public ClassvarClassvarVar(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassvar().setVar(source.get(bookmark));
            }
        }

        // Constructor constructor.addClassvar(Classvar classvar);
        public class ConstructorConstructorClassvar implements Output {
            private String name;
            public ConstructorConstructorClassvar(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushClassvar(); }
            public void set(Source source, int bookmark) {
                peekConstructor().addClassvar(popClassvar());
            }
        }

        // Outputclass outputclass.setClass(String class);
        public class OutputclassOutputclassClass implements Output {
            private String name;
            public OutputclassOutputclassClass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputclass().setClass(source.get(bookmark));
            }
        }

        // outputclass.setConstructor(Constructor constructor);
        public class OutputclassOutputclassConstructor implements Output {
            private String name;
            public OutputclassOutputclassConstructor(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushConstructor(); }
            public void set(Source source, int bookmark) {
                peekOutputclass().setConstructor(popConstructor());
            }
        }

        // outputclass.setVar(String var);
        public class OutputclassOutputclassVar implements Output {
            private String name;
            public OutputclassOutputclassVar(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputclass().setVar(source.get(bookmark));
            }
        }

        // Omarg omarg.setStr(void str);
        public class OmargOmargStr implements Output {
            private String name;
            public OmargOmargStr(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStr(); }
            public void set(Source source, int bookmark) {
                popStr();
                peekOmarg().setStr();
            }
        }

        // omarg.setIndex(void index);
        public class OmargOmargIndex implements Output {
            private String name;
            public OmargOmargIndex(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOmarg().setIndex();
            }
        }

        // omarg.setArg(String arg);
        public class OmargOmargArg implements Output {
            private String name;
            public OmargOmargArg(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOmarg().setArg(source.get(bookmark));
            }
        }

        // Outputmethod outputmethod.setClass(String class);
        public class OutputmethodOutputmethodClass implements Output {
            private String name;
            public OutputmethodOutputmethodClass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setClass(source.get(bookmark));
            }
        }

        // outputmethod.setConstructor(Constructor constructor);
        public class OutputmethodOutputmethodConstructor implements Output {
            private String name;
            public OutputmethodOutputmethodConstructor(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushConstructor(); }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setConstructor(popConstructor());
            }
        }

        // outputmethod.setVariableSetter(void setter);
        public class OutputmethodOutputmethodSetter implements Output {
            private String name;
            public OutputmethodOutputmethodSetter(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setVariableSetter();
            }
        }

        // outputmethod.setRef(String ref);
        public class OutputmethodOutputmethodRef implements Output {
            private String name;
            public OutputmethodOutputmethodRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setRef(source.get(bookmark));
            }
        }

        // outputmethod.setMethod(String method);
        public class OutputmethodOutputmethodMethod implements Output {
            private String name;
            public OutputmethodOutputmethodMethod(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setMethod(source.get(bookmark));
            }
        }

        // outputmethod.setVoid(void void);
        public class OutputmethodOutputmethodVoid implements Output {
            private String name;
            public OutputmethodOutputmethodVoid(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setVoid();
            }
        }

        // outputmethod.setStr(void str);
        public class OutputmethodOutputmethodStr implements Output {
            private String name;
            public OutputmethodOutputmethodStr(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStr(); }
            public void set(Source source, int bookmark) {
                popStr();
                peekOutputmethod().setStr();
            }
        }

        // outputmethod.setIndex(void index);
        public class OutputmethodOutputmethodIndex implements Output {
            private String name;
            public OutputmethodOutputmethodIndex(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setIndex();
            }
        }

        // outputmethod.setArgClass(String argclass);
        public class OutputmethodOutputmethodArgclass implements Output {
            private String name;
            public OutputmethodOutputmethodArgclass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setArgClass(source.get(bookmark));
            }
        }

        // outputmethod.setCarg(String carg);
        public class OutputmethodOutputmethodCarg implements Output {
            private String name;
            public OutputmethodOutputmethodCarg(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setCarg(source.get(bookmark));
            }
        }

        // outputmethod.setArg(String arg);
        public class OutputmethodOutputmethodArg implements Output {
            private String name;
            public OutputmethodOutputmethodArg(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setArg(source.get(bookmark));
            }
        }

        // outputmethod.setOmarg(Omarg omarg);
        public class OutputmethodOutputmethodOmarg implements Output {
            private String name;
            public OutputmethodOutputmethodOmarg(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushOmarg(); }
            public void set(Source source, int bookmark) {
                peekOutputmethod().setOmarg(popOmarg());
            }
        }

        // Outputvar outputvar.setVariable(String variable);
        public class OutputvarOutputvarVariable implements Output {
            private String name;
            public OutputvarOutputvarVariable(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputvar().setVariable(source.get(bookmark));
            }
        }

        // outputvar.setDatatypeBool(void bool);
        public class OutputvarOutputvarBool implements Output {
            private String name;
            public OutputvarOutputvarBool(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputvar().setDatatypeBool();
            }
        }

        // outputvar.setDatatypeString(void str);
        public class OutputvarOutputvarStr implements Output {
            private String name;
            public OutputvarOutputvarStr(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStr(); }
            public void set(Source source, int bookmark) {
                popStr();
                peekOutputvar().setDatatypeString();
            }
        }

        // outputvar.setRef(String ref);
        public class OutputvarOutputvarRef implements Output {
            private String name;
            public OutputvarOutputvarRef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputvar().setRef(source.get(bookmark));
            }
        }

        // outputvar.setMethod(String method);
        public class OutputvarOutputvarMethod implements Output {
            private String name;
            public OutputvarOutputvarMethod(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekOutputvar().setMethod(source.get(bookmark));
            }
        }

        // Grammar grammar.setGrammarName(String grammarname);
        public class GrammarGrammarGrammarname implements Output {
            private String name;
            public GrammarGrammarGrammarname(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekGrammar().setGrammarName(source.get(bookmark));
            }
        }

        // grammar.setDef(Def def);
        public class GrammarGrammarDef implements Output {
            private String name;
            public GrammarGrammarDef(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushDef(); }
            public void set(Source source, int bookmark) {
                peekGrammar().setDef(popDef());
            }
        }

        // grammar.setOutputclass(Outputclass outputclass);
        public class GrammarGrammarOutputclass implements Output {
            private String name;
            public GrammarGrammarOutputclass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushOutputclass(); }
            public void set(Source source, int bookmark) {
                peekGrammar().setOutputclass(popOutputclass());
            }
        }

        // grammar.setOutputmethod(Outputmethod outputmethod);
        public class GrammarGrammarOutputmethod implements Output {
            private String name;
            public GrammarGrammarOutputmethod(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushOutputmethod(); }
            public void set(Source source, int bookmark) {
                peekGrammar().setOutputmethod(popOutputmethod());
            }
        }

        // grammar.setOutputvar(Outputvar outputvar);
        public class GrammarGrammarOutputvar implements Output {
            private String name;
            public GrammarGrammarOutputvar(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushOutputvar(); }
            public void set(Source source, int bookmark) {
                peekGrammar().setOutputvar(popOutputvar());
            }
        }

        public class RepeatsRepeatsInteger implements Output {
            private String name;
            public RepeatsRepeatsInteger(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushInteger(); }
            public void set(Source source, int bookmark) {
                popInteger();
            }
        }
    }
}
