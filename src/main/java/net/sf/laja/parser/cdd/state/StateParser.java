package net.sf.laja.parser.cdd.state;

import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.ParsingResult;
import net.sf.laja.parser.engine2.element.Complete;
import net.sf.laja.parser.engine2.element.ElementList;
import net.sf.laja.parser.engine2.element.End;
import net.sf.laja.parser.engine2.element.Optional;
import net.sf.laja.parser.engine2.element.OrList;
import net.sf.laja.parser.engine2.element.Range;
import net.sf.laja.parser.engine2.element.Repeat;
import net.sf.laja.parser.engine2.element.Str;
import net.sf.laja.parser.engine2.exception.ParserException;
import net.sf.laja.parser.engine2.inspector.DefaultSyntaxErrorHandler;
import net.sf.laja.parser.engine2.inspector.SyntaxErrorHandler;
import net.sf.laja.parser.engine2.source.FileSource;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.parser.engine2.source.StringSource;
import net.sf.laja.parser.engine2.source.URLSource;

import java.util.Stack;

/**
 * Auto generated 2013-05-09 by Laja:
 *    http://laja.sf.net
 *
 * Version: laja2-006-alpha
 */
public final class StateParser implements net.sf.laja.parser.engine2.Parser {
    private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
    private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
    private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

    private Data data1;
    private Data data2;
    private IStateFactory factory1;
    private IStateFactory factory2;
    private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
    private SyntaxErrorHandler syntaxErrorHandler;

    public static final int PHASE1 = 1;
    public static final int PHASE2 = 2;

    public StateParser(IStateFactoryFactory factoryFactory) {
        init(factoryFactory);
    }

    public void init(IStateFactoryFactory factoryFactory) {
        syntaxErrorHandler = new DefaultSyntaxErrorHandler();
        factory1 = factoryFactory.getFactory(PHASE1);
        factory2 = factoryFactory.getFactory(PHASE2);
        data1 = new Data(factory1);
        data2 = new Data(factory2);
    }

    public StateParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
        sourceRecorderLogWriter = writer;
        return this;
    }

    public StateParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
        this.syntaxErrorHandler = syntaxErrorHandler;
        return this;
    }

    public IStateFactory getFactory1() {
        return factory1;
    }

    public IStateFactory getFactory() {
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
        Data.ImportstatementImportstatement importstatementImportstatement = data2.new ImportstatementImportstatement("importstatementImportstatement");
        Data.StatePackagestatementPackagename statePackagestatementPackagename = data2.new StatePackagestatementPackagename("statePackagestatementPackagename");
        Data.ImportstatementImportstatementStatic importstatementImportstatementStatic = data2.new ImportstatementImportstatementStatic("importstatementImportstatementStatic");
        Data.ImportstatementImportstatementFullclassname importstatementImportstatementFullclassname = data2.new ImportstatementImportstatementFullclassname("importstatementImportstatementFullclassname");
        Data.ImportsImportsImportstatement importsImportsImportstatement = data2.new ImportsImportsImportstatement("importsImportsImportstatement");
        Data.AttributeAttributeType attributeAttributeType = data2.new AttributeAttributeType("attributeAttributeType");
        Data.AttributeAttributeVariable attributeAttributeVariable = data2.new AttributeAttributeVariable("attributeAttributeVariable");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementAttribute classStatementClassStatementAttribute = data2.new ClassStatementClassStatementAttribute("classStatementClassStatementAttribute");
        Data.ClassStatementClassStatementManualCode classStatementClassStatementManualCode = data2.new ClassStatementClassStatementManualCode("classStatementClassStatementManualCode");
        Data.StateStateImports stateStateImports = data2.new StateStateImports("stateStateImports");
        Data.StateStateClassStatement stateStateClassStatement = data2.new StateStateClassStatement("stateStateClassStatement");

        // *** Declarations ***
        OrList newline = new OrList(1, "newline");
        OrList comment = new OrList(2, "comment");
        Repeat ws = new Repeat(3, "ws");
        Optional s = new Optional(4, "s");
        Str ff = new Str(5, "\"");
        ElementList str = new ElementList(6, "str");
        OrList letter = new OrList(7, "letter");
        Range digit = new Range(8, "digit", "0", "9");
        ElementList name = new ElementList(9, "name");
        Optional _public = new Optional(10, "public");
        ElementList packagestatement = new ElementList(11, "packagestatement");
        ElementList packagename = new ElementList(12, "packagename");
        ElementList fullclassname = new ElementList(13, "fullclassname");
        ElementList importstatement = new ElementList(14, "importstatement", importstatementImportstatement);
        Optional imports = new Optional(15, "imports");
        Optional keywords = new Optional(16, "keywords");
        ElementList type = new ElementList(17, "type");
        ElementList attribute = new ElementList(18, "attribute");
        ElementList uname = new ElementList(19, "uname");
        ElementList getter = new ElementList(20, "getter");
        ElementList body = new ElementList(21, "body");
        Repeat manualCode = new Repeat(22, "manualCode");
        ElementList classStatement = new ElementList(23, "classStatement");
        ElementList state = new ElementList(24, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(26, new Str(25, "\r\n"));
        newline.add(28, new Str(27, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(29, "comment_1");
        comment_1.add(31, new Str(30, "/*"));
        Optional comment_1_1 = new Optional(32, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(33, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(34, "comment_1_1_1_1");
        comment_1_1_1_1.add(35, comment);
        comment_1_1_1_1.add(37, new Str(36, "*/", NOT));
        comment_1_1_1.add(38, comment_1_1_1_1);
        comment_1_1.add(39, comment_1_1_1);
        comment_1.add(40, comment_1_1);
        comment_1.add(42, new Str(41, "*/"));
        comment.add(43, comment_1);
        ElementList comment_2 = new ElementList(44, "comment_2");
        comment_2.add(46, new Str(45, "//"));
        Optional comment_2_1 = new Optional(47, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(48, "comment_2_1_1");
        comment_2_1_1.add(49, newline, NOT);
        comment_2_1.add(50, comment_2_1_1);
        comment_2.add(51, comment_2_1);
        OrList comment_2_2 = new OrList(52, "comment_2_2");
        comment_2_2.add(53, newline);
        comment_2_2.add(55, new End(54, "comment_2_2"));
        comment_2.add(56, comment_2_2);
        comment.add(57, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(58, "ws_1");
        ws_1.add(59, newline);
        ws_1.add(61, new Str(60, " "));
        ws_1.add(63, new Str(62, "\t"));
        ws_1.add(64, comment);
        ws.add(65, ws_1);

        // s = [ws]
        s.add(66, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(67, ff);
        Repeat str_1 = new Repeat(68, "str_1");
        OrList str_1_1 = new OrList(69, "str_1_1");
        str_1_1.add(71, new Str(70, "\\\""));
        OrList str_1_1_1 = new OrList(72, "str_1_1_1", NOT);
        str_1_1_1.add(73, ff);
        str_1_1_1.add(74, newline);
        str_1_1.add(75, str_1_1_1);
        str_1.add(76, str_1_1);
        str.add(77, str_1);
        str.add(78, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(80, new Range(79, "letter", "a", "z"));
        letter.add(82, new Range(81, "letter", "A", "Z"));
        letter.add(84, new Str(83, "_"));
        letter.add(86, new Str(85, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(87, letter);
        Optional name_1 = new Optional(88, "name_1");
        Repeat name_1_1 = new Repeat(89, "name_1_1");
        OrList name_1_1_1 = new OrList(90, "name_1_1_1");
        name_1_1_1.add(91, letter);
        name_1_1_1.add(92, digit);
        name_1_1.add(93, name_1_1_1);
        name_1.add(94, name_1_1);
        name.add(95, name_1);

        // public = ["public" ws]
        _public.add(97, new Str(96, "public"));
        _public.add(98, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(100, new Str(99, "package"));
        packagestatement.add(101, ws);
        packagestatement.add(102, packagename, statePackagestatementPackagename);
        packagestatement.add(103, s);
        packagestatement.add(105, new Str(104, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(106, name);
        Optional packagename_1 = new Optional(107, "packagename_1");
        Repeat packagename_1_1 = new Repeat(108, "packagename_1_1");
        packagename_1_1.add(110, new Str(109, "."));
        OrList packagename_1_1_1 = new OrList(111, "packagename_1_1_1");
        packagename_1_1_1.add(112, name);
        packagename_1_1_1.add(114, new Str(113, "*"));
        packagename_1_1.add(115, packagename_1_1_1);
        packagename_1.add(116, packagename_1_1);
        packagename.add(117, packagename_1);

        // fullclassname = packagename
        fullclassname.add(118, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(120, new Str(119, "import"));
        importstatement.add(121, ws);
        Optional importstatement_1 = new Optional(122, "importstatement_1");
        importstatement_1.add(124, new Str(123, "static", importstatementImportstatementStatic));
        importstatement_1.add(125, ws);
        importstatement.add(126, importstatement_1);
        importstatement.add(127, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(128, s);
        importstatement.add(130, new Str(129, ";"));
        importstatement.add(131, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(132, "imports_1");
        imports_1.add(133, importstatement, importsImportsImportstatement);
        imports.add(134, imports_1);

        // keywords = [s "public "|"private "|"final "]+
        Repeat keywords_1 = new Repeat(135, "keywords_1");
        keywords_1.add(136, s);
        OrList keywords_1_1 = new OrList(137, "keywords_1_1");
        keywords_1_1.add(139, new Str(138, "public "));
        keywords_1_1.add(141, new Str(140, "private "));
        keywords_1_1.add(143, new Str(142, "final "));
        keywords_1.add(144, keywords_1_1);
        keywords.add(145, keywords_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(146, name);
        Optional type_1 = new Optional(147, "type_1");
        type_1.add(148, s);
        type_1.add(150, new Str(149, "<"));
        type_1.add(151, s);
        type_1.add(152, type);
        type_1.add(153, s);
        type_1.add(155, new Str(154, ">"));
        type.add(156, type_1);
        Optional type_2 = new Optional(157, "type_2");
        type_2.add(158, s);
        type_2.add(160, new Str(159, ","));
        type_2.add(161, s);
        type_2.add(162, type);
        type.add(163, type_2);

        // attribute = keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(164, keywords);
        attribute.add(165, s);
        attribute.add(166, type, attributeAttributeType);
        attribute.add(167, ws);
        attribute.add(168, name, attributeAttributeVariable);
        attribute.add(169, s);
        attribute.add(171, new Str(170, ";"));
        Optional attribute_1 = new Optional(172, "attribute_1");
        Repeat attribute_1_1 = new Repeat(173, "attribute_1_1");
        attribute_1_1.add(174, newline, NOT);
        attribute_1.add(175, attribute_1_1);
        attribute.add(176, attribute_1);
        attribute.add(177, newline);

        // uname = "A".."Z" [letter | digit]+
        uname.add(179, new Range(178, "uname", "A", "Z"));
        Optional uname_1 = new Optional(180, "uname_1");
        Repeat uname_1_1 = new Repeat(181, "uname_1_1");
        OrList uname_1_1_1 = new OrList(182, "uname_1_1_1");
        uname_1_1_1.add(183, letter);
        uname_1_1_1.add(184, digit);
        uname_1_1.add(185, uname_1_1_1);
        uname_1.add(186, uname_1_1);
        uname.add(187, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(189, new Str(188, "get"));
        getter.add(190, uname);
        getter.add(191, s);
        getter.add(193, new Str(192, "("));
        getter.add(194, s);
        getter.add(196, new Str(195, ")"));

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(198, new Str(197, "{"));
        body.add(199, s);
        Optional body_1 = new Optional(200, "body_1");
        Repeat body_1_1 = new Repeat(201, "body_1_1");
        OrList body_1_1_1 = new OrList(202, "body_1_1_1");
        body_1_1_1.add(203, body);
        body_1_1_1.add(204, str);
        body_1_1_1.add(206, new Str(205, "}", NOT));
        body_1_1.add(207, body_1_1_1);
        body_1.add(208, body_1_1);
        body.add(209, body_1);
        body.add(211, new Str(210, "}"));

        // manualCode = !(("}" s END) | ("// Generated" *))+
        OrList manualCode_1 = new OrList(212, "manualCode_1");
        ElementList manualCode_1_1 = new ElementList(213, "manualCode_1_1");
        manualCode_1_1.add(215, new Str(214, "}"));
        manualCode_1_1.add(216, s);
        manualCode_1_1.add(218, new End(217, "manualCode_1_1"));
        manualCode_1.add(219, manualCode_1_1);
        ElementList manualCode_1_2 = new ElementList(220, "manualCode_1_2");
        manualCode_1_2.add(222, new Str(221, "// Generated"));
        manualCode_1_2.add(224, new Complete(223, "manualCode_1_2"));
        manualCode_1.add(225, manualCode_1_2);
        manualCode.add(226, manualCode_1, NOT);

        // classStatement =
        //   public "class" ws name:classname s ["extends" ws name s] "{" [s attribute]+
        //   manualCode *
        classStatement.add(227, _public);
        classStatement.add(229, new Str(228, "class"));
        classStatement.add(230, ws);
        classStatement.add(231, name, classStatementClassStatementClassname);
        classStatement.add(232, s);
        Optional classStatement_1 = new Optional(233, "classStatement_1");
        classStatement_1.add(235, new Str(234, "extends"));
        classStatement_1.add(236, ws);
        classStatement_1.add(237, name);
        classStatement_1.add(238, s);
        classStatement.add(239, classStatement_1);
        classStatement.add(241, new Str(240, "{"));
        Optional classStatement_2 = new Optional(242, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(243, "classStatement_2_1");
        classStatement_2_1.add(244, s);
        classStatement_2_1.add(245, attribute, classStatementClassStatementAttribute);
        classStatement_2.add(246, classStatement_2_1);
        classStatement.add(247, classStatement_2);
        classStatement.add(248, manualCode, classStatementClassStatementManualCode);
        classStatement.add(250, new Complete(249, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(251, s);
        state.add(252, packagestatement);
        state.add(253, s);
        state.add(254, imports, stateStateImports);
        state.add(255, s);
        state.add(256, classStatement, stateStateClassStatement);
        state.add(257, s);

        return new TopElement(data2, state);
    }

    private net.sf.laja.parser.engine2.element.Element getGrammar1() {
        // *** Output classes ***

        // *** Declarations ***
        OrList newline = new OrList(1, "newline");
        OrList comment = new OrList(2, "comment");
        Repeat ws = new Repeat(3, "ws");
        Optional s = new Optional(4, "s");
        Str ff = new Str(5, "\"");
        ElementList str = new ElementList(6, "str");
        OrList letter = new OrList(7, "letter");
        Range digit = new Range(8, "digit", "0", "9");
        ElementList name = new ElementList(9, "name");
        Optional _public = new Optional(10, "public");
        ElementList packagestatement = new ElementList(11, "packagestatement");
        ElementList packagename = new ElementList(12, "packagename");
        ElementList fullclassname = new ElementList(13, "fullclassname");
        ElementList importstatement = new ElementList(14, "importstatement");
        Optional imports = new Optional(15, "imports");
        Optional keywords = new Optional(16, "keywords");
        ElementList type = new ElementList(17, "type");
        ElementList attribute = new ElementList(18, "attribute");
        ElementList uname = new ElementList(19, "uname");
        ElementList getter = new ElementList(20, "getter");
        ElementList body = new ElementList(21, "body");
        Repeat manualCode = new Repeat(22, "manualCode");
        ElementList classStatement = new ElementList(23, "classStatement");
        ElementList state = new ElementList(24, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(26, new Str(25, "\r\n"));
        newline.add(28, new Str(27, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(29, "comment_1");
        comment_1.add(31, new Str(30, "/*"));
        Optional comment_1_1 = new Optional(32, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(33, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(34, "comment_1_1_1_1");
        comment_1_1_1_1.add(35, comment);
        comment_1_1_1_1.add(37, new Str(36, "*/", NOT));
        comment_1_1_1.add(38, comment_1_1_1_1);
        comment_1_1.add(39, comment_1_1_1);
        comment_1.add(40, comment_1_1);
        comment_1.add(42, new Str(41, "*/"));
        comment.add(43, comment_1);
        ElementList comment_2 = new ElementList(44, "comment_2");
        comment_2.add(46, new Str(45, "//"));
        Optional comment_2_1 = new Optional(47, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(48, "comment_2_1_1");
        comment_2_1_1.add(49, newline, NOT);
        comment_2_1.add(50, comment_2_1_1);
        comment_2.add(51, comment_2_1);
        OrList comment_2_2 = new OrList(52, "comment_2_2");
        comment_2_2.add(53, newline);
        comment_2_2.add(55, new End(54, "comment_2_2"));
        comment_2.add(56, comment_2_2);
        comment.add(57, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(58, "ws_1");
        ws_1.add(59, newline);
        ws_1.add(61, new Str(60, " "));
        ws_1.add(63, new Str(62, "\t"));
        ws_1.add(64, comment);
        ws.add(65, ws_1);

        // s = [ws]
        s.add(66, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(67, ff);
        Repeat str_1 = new Repeat(68, "str_1");
        OrList str_1_1 = new OrList(69, "str_1_1");
        str_1_1.add(71, new Str(70, "\\\""));
        OrList str_1_1_1 = new OrList(72, "str_1_1_1", NOT);
        str_1_1_1.add(73, ff);
        str_1_1_1.add(74, newline);
        str_1_1.add(75, str_1_1_1);
        str_1.add(76, str_1_1);
        str.add(77, str_1);
        str.add(78, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(80, new Range(79, "letter", "a", "z"));
        letter.add(82, new Range(81, "letter", "A", "Z"));
        letter.add(84, new Str(83, "_"));
        letter.add(86, new Str(85, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(87, letter);
        Optional name_1 = new Optional(88, "name_1");
        Repeat name_1_1 = new Repeat(89, "name_1_1");
        OrList name_1_1_1 = new OrList(90, "name_1_1_1");
        name_1_1_1.add(91, letter);
        name_1_1_1.add(92, digit);
        name_1_1.add(93, name_1_1_1);
        name_1.add(94, name_1_1);
        name.add(95, name_1);

        // public = ["public" ws]
        _public.add(97, new Str(96, "public"));
        _public.add(98, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(100, new Str(99, "package"));
        packagestatement.add(101, ws);
        packagestatement.add(102, packagename);
        packagestatement.add(103, s);
        packagestatement.add(105, new Str(104, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(106, name);
        Optional packagename_1 = new Optional(107, "packagename_1");
        Repeat packagename_1_1 = new Repeat(108, "packagename_1_1");
        packagename_1_1.add(110, new Str(109, "."));
        OrList packagename_1_1_1 = new OrList(111, "packagename_1_1_1");
        packagename_1_1_1.add(112, name);
        packagename_1_1_1.add(114, new Str(113, "*"));
        packagename_1_1.add(115, packagename_1_1_1);
        packagename_1.add(116, packagename_1_1);
        packagename.add(117, packagename_1);

        // fullclassname = packagename
        fullclassname.add(118, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(120, new Str(119, "import"));
        importstatement.add(121, ws);
        Optional importstatement_1 = new Optional(122, "importstatement_1");
        importstatement_1.add(124, new Str(123, "static"));
        importstatement_1.add(125, ws);
        importstatement.add(126, importstatement_1);
        importstatement.add(127, fullclassname);
        importstatement.add(128, s);
        importstatement.add(130, new Str(129, ";"));
        importstatement.add(131, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(132, "imports_1");
        imports_1.add(133, importstatement);
        imports.add(134, imports_1);

        // keywords = [s "public "|"private "|"final "]+
        Repeat keywords_1 = new Repeat(135, "keywords_1");
        keywords_1.add(136, s);
        OrList keywords_1_1 = new OrList(137, "keywords_1_1");
        keywords_1_1.add(139, new Str(138, "public "));
        keywords_1_1.add(141, new Str(140, "private "));
        keywords_1_1.add(143, new Str(142, "final "));
        keywords_1.add(144, keywords_1_1);
        keywords.add(145, keywords_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(146, name);
        Optional type_1 = new Optional(147, "type_1");
        type_1.add(148, s);
        type_1.add(150, new Str(149, "<"));
        type_1.add(151, s);
        type_1.add(152, type);
        type_1.add(153, s);
        type_1.add(155, new Str(154, ">"));
        type.add(156, type_1);
        Optional type_2 = new Optional(157, "type_2");
        type_2.add(158, s);
        type_2.add(160, new Str(159, ","));
        type_2.add(161, s);
        type_2.add(162, type);
        type.add(163, type_2);

        // attribute = keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(164, keywords);
        attribute.add(165, s);
        attribute.add(166, type);
        attribute.add(167, ws);
        attribute.add(168, name);
        attribute.add(169, s);
        attribute.add(171, new Str(170, ";"));
        Optional attribute_1 = new Optional(172, "attribute_1");
        Repeat attribute_1_1 = new Repeat(173, "attribute_1_1");
        attribute_1_1.add(174, newline, NOT);
        attribute_1.add(175, attribute_1_1);
        attribute.add(176, attribute_1);
        attribute.add(177, newline);

        // uname = "A".."Z" [letter | digit]+
        uname.add(179, new Range(178, "uname", "A", "Z"));
        Optional uname_1 = new Optional(180, "uname_1");
        Repeat uname_1_1 = new Repeat(181, "uname_1_1");
        OrList uname_1_1_1 = new OrList(182, "uname_1_1_1");
        uname_1_1_1.add(183, letter);
        uname_1_1_1.add(184, digit);
        uname_1_1.add(185, uname_1_1_1);
        uname_1.add(186, uname_1_1);
        uname.add(187, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(189, new Str(188, "get"));
        getter.add(190, uname);
        getter.add(191, s);
        getter.add(193, new Str(192, "("));
        getter.add(194, s);
        getter.add(196, new Str(195, ")"));

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(198, new Str(197, "{"));
        body.add(199, s);
        Optional body_1 = new Optional(200, "body_1");
        Repeat body_1_1 = new Repeat(201, "body_1_1");
        OrList body_1_1_1 = new OrList(202, "body_1_1_1");
        body_1_1_1.add(203, body);
        body_1_1_1.add(204, str);
        body_1_1_1.add(206, new Str(205, "}", NOT));
        body_1_1.add(207, body_1_1_1);
        body_1.add(208, body_1_1);
        body.add(209, body_1);
        body.add(211, new Str(210, "}"));

        // manualCode = !(("}" s END) | ("// Generated" *))+
        OrList manualCode_1 = new OrList(212, "manualCode_1");
        ElementList manualCode_1_1 = new ElementList(213, "manualCode_1_1");
        manualCode_1_1.add(215, new Str(214, "}"));
        manualCode_1_1.add(216, s);
        manualCode_1_1.add(218, new End(217, "manualCode_1_1"));
        manualCode_1.add(219, manualCode_1_1);
        ElementList manualCode_1_2 = new ElementList(220, "manualCode_1_2");
        manualCode_1_2.add(222, new Str(221, "// Generated"));
        manualCode_1_2.add(224, new Complete(223, "manualCode_1_2"));
        manualCode_1.add(225, manualCode_1_2);
        manualCode.add(226, manualCode_1, NOT);

        // classStatement =
        //   public "class" ws name:classname s ["extends" ws name s] "{" [s attribute]+
        //   manualCode *
        classStatement.add(227, _public);
        classStatement.add(229, new Str(228, "class"));
        classStatement.add(230, ws);
        classStatement.add(231, name);
        classStatement.add(232, s);
        Optional classStatement_1 = new Optional(233, "classStatement_1");
        classStatement_1.add(235, new Str(234, "extends"));
        classStatement_1.add(236, ws);
        classStatement_1.add(237, name);
        classStatement_1.add(238, s);
        classStatement.add(239, classStatement_1);
        classStatement.add(241, new Str(240, "{"));
        Optional classStatement_2 = new Optional(242, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(243, "classStatement_2_1");
        classStatement_2_1.add(244, s);
        classStatement_2_1.add(245, attribute);
        classStatement_2.add(246, classStatement_2_1);
        classStatement.add(247, classStatement_2);
        classStatement.add(248, manualCode);
        classStatement.add(250, new Complete(249, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(251, s);
        state.add(252, packagestatement);
        state.add(253, s);
        state.add(254, imports);
        state.add(255, s);
        state.add(256, classStatement);
        state.add(257, s);

        return new TopElement(data1, state);
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
            data.pushState();
            boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
            data.popState();
            return match;
        }
    }

    // *** IStateFactoryFactory
    public interface IStateFactoryFactory {
        public IStateFactory getFactory(int phase);
    }

    // *** IStateFactory ***
    public interface IStateFactory {
        StateParser.IImportstatement createImportstatement();
        StateParser.IImports createImports();
        StateParser.IAttribute createAttribute();
        StateParser.IClassStatement createClassStatement();
        StateParser.IState createState();
    }

    // *** Interfaces ***
    // Importstatement
    public interface IImportstatement {
        public void setStatement(String importstatement);
        public void setStatic();
        public void setFullclassname(String fullclassname);
    }

    // Imports
    public interface IImports {
        public void addImportstatement(IImportstatement iimportstatement);
    }

    // Attribute
    public interface IAttribute {
        public void setType(String type);
        public void setVariable(String variable);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void addAttribute(IAttribute iattribute);
        public void setManualCode(String manualCode);
    }

    // State
    public interface IState {
        public void setPackagename(String packagename);
        public void setImports(IImports iimports);
        public void setClassStatement(IClassStatement iclassStatement);
    }

    // *** Data ***
    public static final class Data {
        private StateParser.IStateFactory factory;
        private Stack<IImportstatement> importstatementStack = new Stack<IImportstatement>();
        private Stack<IImports> importsStack = new Stack<IImports>();
        private Stack<IAttribute> attributeStack = new Stack<IAttribute>();
        private Stack<IClassStatement> classStatementStack = new Stack<IClassStatement>();
        private Stack<IState> stateStack = new Stack<IState>();

        public Data(StateParser.IStateFactory factory) {
            this.factory = factory;
        }

        // Importstatement
        public void pushImportstatement() { importstatementStack.push(factory.createImportstatement()); }
        public StateParser.IImportstatement popImportstatement() { return (StateParser.IImportstatement)importstatementStack.pop(); }
        public StateParser.IImportstatement peekImportstatement() {
            if (importstatementStack.empty()) { return null; }
            return importstatementStack.peek();
        }

        // Imports
        public void pushImports() { importsStack.push(factory.createImports()); }
        public StateParser.IImports popImports() { return (StateParser.IImports)importsStack.pop(); }
        public StateParser.IImports peekImports() {
            if (importsStack.empty()) { return null; }
            return importsStack.peek();
        }

        // Attribute
        public void pushAttribute() { attributeStack.push(factory.createAttribute()); }
        public StateParser.IAttribute popAttribute() { return (StateParser.IAttribute)attributeStack.pop(); }
        public StateParser.IAttribute peekAttribute() {
            if (attributeStack.empty()) { return null; }
            return attributeStack.peek();
        }

        // ClassStatement
        public void pushClassStatement() { classStatementStack.push(factory.createClassStatement()); }
        public StateParser.IClassStatement popClassStatement() { return (StateParser.IClassStatement)classStatementStack.pop(); }
        public StateParser.IClassStatement peekClassStatement() {
            if (classStatementStack.empty()) { return null; }
            return classStatementStack.peek();
        }

        // State
        public void pushState() { stateStack.push(factory.createState()); }
        public StateParser.IState popState() { return (StateParser.IState)stateStack.pop(); }
        public StateParser.IState peekState() {
            if (stateStack.empty()) { return null; }
            return stateStack.peek();
        }

        // Importstatement importstatement.setStatement(String *);
        public class ImportstatementImportstatement implements Output {
            private String name;
            public ImportstatementImportstatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekImportstatement().setStatement(source.get(bookmark));
            }
        }

        // State state.setPackagename(String packagestatement.packagename);
        public class StatePackagestatementPackagename implements Output {
            private String name;
            public StatePackagestatementPackagename(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekState().setPackagename(source.get(bookmark));
            }
        }

        // importstatement.setStatic(void static);
        public class ImportstatementImportstatementStatic implements Output {
            private String name;
            public ImportstatementImportstatementStatic(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekImportstatement().setStatic();
            }
        }

        // importstatement.setFullclassname(String fullclassname);
        public class ImportstatementImportstatementFullclassname implements Output {
            private String name;
            public ImportstatementImportstatementFullclassname(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekImportstatement().setFullclassname(source.get(bookmark));
            }
        }

        // Imports imports.addImportstatement(Importstatement importstatement);
        public class ImportsImportsImportstatement implements Output {
            private String name;
            public ImportsImportsImportstatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushImportstatement(); }
            public void set(Source source, int bookmark) {
                peekImports().addImportstatement(popImportstatement());
            }
        }

        // Attribute attribute.setType(String type);
        public class AttributeAttributeType implements Output {
            private String name;
            public AttributeAttributeType(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAttribute().setType(source.get(bookmark));
            }
        }

        // attribute.setVariable(String variable);
        public class AttributeAttributeVariable implements Output {
            private String name;
            public AttributeAttributeVariable(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAttribute().setVariable(source.get(bookmark));
            }
        }

        // ClassStatement classStatement.setClassname(String classname);
        public class ClassStatementClassStatementClassname implements Output {
            private String name;
            public ClassStatementClassStatementClassname(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassStatement().setClassname(source.get(bookmark));
            }
        }

        // classStatement.addAttribute(Attribute attribute);
        public class ClassStatementClassStatementAttribute implements Output {
            private String name;
            public ClassStatementClassStatementAttribute(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAttribute(); }
            public void set(Source source, int bookmark) {
                peekClassStatement().addAttribute(popAttribute());
            }
        }

        // classStatement.setManualCode(String manualCode);
        public class ClassStatementClassStatementManualCode implements Output {
            private String name;
            public ClassStatementClassStatementManualCode(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassStatement().setManualCode(source.get(bookmark));
            }
        }

        // state.setImports(Imports imports);
        public class StateStateImports implements Output {
            private String name;
            public StateStateImports(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushImports(); }
            public void set(Source source, int bookmark) {
                peekState().setImports(popImports());
            }
        }

        // state.setClassStatement(ClassStatement classStatement);
        public class StateStateClassStatement implements Output {
            private String name;
            public StateStateClassStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushClassStatement(); }
            public void set(Source source, int bookmark) {
                peekState().setClassStatement(popClassStatement());
            }
        }
    }
}
