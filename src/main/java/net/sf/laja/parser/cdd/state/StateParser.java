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
        Data.AttributeAnnotationsAnnotation attributeAnnotationsAnnotation = data2.new AttributeAnnotationsAnnotation("attributeAnnotationsAnnotation");
        Data.AttributeAttributeAnnotations attributeAttributeAnnotations = data2.new AttributeAttributeAnnotations("attributeAttributeAnnotations");
        Data.AttributeAttributeType attributeAttributeType = data2.new AttributeAttributeType("attributeAttributeType");
        Data.AttributeAttributeVariable attributeAttributeVariable = data2.new AttributeAttributeVariable("attributeAttributeVariable");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementAttribute classStatementClassStatementAttribute = data2.new ClassStatementClassStatementAttribute("classStatementClassStatementAttribute");
        Data.ClassStatementClassStatementManualCode classStatementClassStatementManualCode = data2.new ClassStatementClassStatementManualCode("classStatementClassStatementManualCode");
        Data.ClassStatementClassStatementGeneratedEnd classStatementClassStatementGeneratedEnd = data2.new ClassStatementClassStatementGeneratedEnd("classStatementClassStatementGeneratedEnd");
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
        Optional annotations = new Optional(16, "annotations");
        Optional keywords = new Optional(17, "keywords");
        ElementList type = new ElementList(18, "type");
        ElementList attribute = new ElementList(19, "attribute");
        ElementList uname = new ElementList(20, "uname");
        ElementList getter = new ElementList(21, "getter");
        ElementList body = new ElementList(22, "body");
        ElementList manualEnd = new ElementList(23, "manualEnd");
        ElementList generatedEnd = new ElementList(24, "generatedEnd");
        Repeat manualCode = new Repeat(25, "manualCode");
        ElementList classStatement = new ElementList(26, "classStatement");
        ElementList state = new ElementList(27, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(29, new Str(28, "\r\n"));
        newline.add(31, new Str(30, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(32, "comment_1");
        comment_1.add(34, new Str(33, "/*"));
        Optional comment_1_1 = new Optional(35, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(36, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(37, "comment_1_1_1_1");
        comment_1_1_1_1.add(38, comment);
        comment_1_1_1_1.add(40, new Str(39, "*/", NOT));
        comment_1_1_1.add(41, comment_1_1_1_1);
        comment_1_1.add(42, comment_1_1_1);
        comment_1.add(43, comment_1_1);
        comment_1.add(45, new Str(44, "*/"));
        comment.add(46, comment_1);
        ElementList comment_2 = new ElementList(47, "comment_2");
        comment_2.add(49, new Str(48, "//"));
        Optional comment_2_1 = new Optional(50, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(51, "comment_2_1_1");
        comment_2_1_1.add(52, newline, NOT);
        comment_2_1.add(53, comment_2_1_1);
        comment_2.add(54, comment_2_1);
        OrList comment_2_2 = new OrList(55, "comment_2_2");
        comment_2_2.add(56, newline);
        comment_2_2.add(58, new End(57, "comment_2_2"));
        comment_2.add(59, comment_2_2);
        comment.add(60, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(61, "ws_1");
        ws_1.add(62, newline);
        ws_1.add(64, new Str(63, " "));
        ws_1.add(66, new Str(65, "\t"));
        ws_1.add(67, comment);
        ws.add(68, ws_1);

        // s = [ws]
        s.add(69, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(70, ff);
        Repeat str_1 = new Repeat(71, "str_1");
        OrList str_1_1 = new OrList(72, "str_1_1");
        str_1_1.add(74, new Str(73, "\\\""));
        OrList str_1_1_1 = new OrList(75, "str_1_1_1", NOT);
        str_1_1_1.add(76, ff);
        str_1_1_1.add(77, newline);
        str_1_1.add(78, str_1_1_1);
        str_1.add(79, str_1_1);
        str.add(80, str_1);
        str.add(81, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(83, new Range(82, "letter", "a", "z"));
        letter.add(85, new Range(84, "letter", "A", "Z"));
        letter.add(87, new Str(86, "_"));
        letter.add(89, new Str(88, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(90, letter);
        Optional name_1 = new Optional(91, "name_1");
        Repeat name_1_1 = new Repeat(92, "name_1_1");
        OrList name_1_1_1 = new OrList(93, "name_1_1_1");
        name_1_1_1.add(94, letter);
        name_1_1_1.add(95, digit);
        name_1_1.add(96, name_1_1_1);
        name_1.add(97, name_1_1);
        name.add(98, name_1);

        // public = ["public" ws]
        _public.add(100, new Str(99, "public"));
        _public.add(101, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(103, new Str(102, "package"));
        packagestatement.add(104, ws);
        packagestatement.add(105, packagename, statePackagestatementPackagename);
        packagestatement.add(106, s);
        packagestatement.add(108, new Str(107, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(109, name);
        Optional packagename_1 = new Optional(110, "packagename_1");
        Repeat packagename_1_1 = new Repeat(111, "packagename_1_1");
        packagename_1_1.add(113, new Str(112, "."));
        OrList packagename_1_1_1 = new OrList(114, "packagename_1_1_1");
        packagename_1_1_1.add(115, name);
        packagename_1_1_1.add(117, new Str(116, "*"));
        packagename_1_1.add(118, packagename_1_1_1);
        packagename_1.add(119, packagename_1_1);
        packagename.add(120, packagename_1);

        // fullclassname = packagename
        fullclassname.add(121, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(123, new Str(122, "import"));
        importstatement.add(124, ws);
        Optional importstatement_1 = new Optional(125, "importstatement_1");
        importstatement_1.add(127, new Str(126, "static", importstatementImportstatementStatic));
        importstatement_1.add(128, ws);
        importstatement.add(129, importstatement_1);
        importstatement.add(130, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(131, s);
        importstatement.add(133, new Str(132, ";"));
        importstatement.add(134, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(135, "imports_1");
        imports_1.add(136, importstatement, importsImportsImportstatement);
        imports.add(137, imports_1);

        // annotations = [("@" name s):annotation]+
        Repeat annotations_1 = new Repeat(138, "annotations_1");
        annotations_1.add(140, new Str(139, "@"));
        annotations_1.add(141, name);
        annotations_1.add(142, s);
        annotations.add(143, annotations_1);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(144, "keywords_1");
        OrList keywords_1_1 = new OrList(145, "keywords_1_1");
        keywords_1_1.add(147, new Str(146, "public "));
        keywords_1_1.add(149, new Str(148, "private "));
        keywords_1_1.add(151, new Str(150, "final "));
        keywords_1.add(152, keywords_1_1);
        keywords_1.add(153, s);
        keywords.add(154, keywords_1);

        // type = name [s "<" s type s ">"] [s "," s type]
        type.add(155, name);
        Optional type_1 = new Optional(156, "type_1");
        type_1.add(157, s);
        type_1.add(159, new Str(158, "<"));
        type_1.add(160, s);
        type_1.add(161, type);
        type_1.add(162, s);
        type_1.add(164, new Str(163, ">"));
        type.add(165, type_1);
        Optional type_2 = new Optional(166, "type_2");
        type_2.add(167, s);
        type_2.add(169, new Str(168, ","));
        type_2.add(170, s);
        type_2.add(171, type);
        type.add(172, type_2);

        // attribute = s annotations keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(173, s);
        attribute.add(174, annotations, attributeAttributeAnnotations);
        attribute.add(175, keywords);
        attribute.add(176, s);
        attribute.add(177, type, attributeAttributeType);
        attribute.add(178, ws);
        attribute.add(179, name, attributeAttributeVariable);
        attribute.add(180, s);
        attribute.add(182, new Str(181, ";"));
        Optional attribute_1 = new Optional(183, "attribute_1");
        Repeat attribute_1_1 = new Repeat(184, "attribute_1_1");
        attribute_1_1.add(185, newline, NOT);
        attribute_1.add(186, attribute_1_1);
        attribute.add(187, attribute_1);
        attribute.add(188, newline);

        // uname = "A".."Z" [letter | digit]+
        uname.add(190, new Range(189, "uname", "A", "Z"));
        Optional uname_1 = new Optional(191, "uname_1");
        Repeat uname_1_1 = new Repeat(192, "uname_1_1");
        OrList uname_1_1_1 = new OrList(193, "uname_1_1_1");
        uname_1_1_1.add(194, letter);
        uname_1_1_1.add(195, digit);
        uname_1_1.add(196, uname_1_1_1);
        uname_1.add(197, uname_1_1);
        uname.add(198, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(200, new Str(199, "get"));
        getter.add(201, uname);
        getter.add(202, s);
        getter.add(204, new Str(203, "("));
        getter.add(205, s);
        getter.add(207, new Str(206, ")"));

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(209, new Str(208, "{"));
        body.add(210, s);
        Optional body_1 = new Optional(211, "body_1");
        Repeat body_1_1 = new Repeat(212, "body_1_1");
        OrList body_1_1_1 = new OrList(213, "body_1_1_1");
        body_1_1_1.add(214, body);
        body_1_1_1.add(215, str);
        body_1_1_1.add(217, new Str(216, "}", NOT));
        body_1_1.add(218, body_1_1_1);
        body_1.add(219, body_1_1);
        body.add(220, body_1);
        body.add(222, new Str(221, "}"));

        // manualEnd = ("}" s END)
        manualEnd.add(224, new Str(223, "}"));
        manualEnd.add(225, s);
        manualEnd.add(227, new End(226, "manualEnd"));

        // generatedEnd = ("// Generated" *)
        generatedEnd.add(229, new Str(228, "// Generated"));
        generatedEnd.add(231, new Complete(230, "generatedEnd"));

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(232, "manualCode_1");
        manualCode_1.add(233, manualEnd);
        manualCode_1.add(234, generatedEnd);
        manualCode.add(235, manualCode_1, NOT);

        // classStatement =
        //   "@State" ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ manualCode
        //   manualEnd|generatedEnd *
        classStatement.add(237, new Str(236, "@State"));
        classStatement.add(238, ws);
        classStatement.add(239, _public);
        classStatement.add(241, new Str(240, "class"));
        classStatement.add(242, ws);
        classStatement.add(243, name, classStatementClassStatementClassname);
        classStatement.add(244, s);
        Optional classStatement_1 = new Optional(245, "classStatement_1");
        classStatement_1.add(247, new Str(246, "extends"));
        classStatement_1.add(248, ws);
        classStatement_1.add(249, name);
        classStatement_1.add(250, s);
        classStatement.add(251, classStatement_1);
        Optional classStatement_2 = new Optional(252, "classStatement_2");
        classStatement_2.add(254, new Str(253, "implements"));
        classStatement_2.add(255, ws);
        classStatement_2.add(256, name);
        Optional classStatement_2_1 = new Optional(257, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(258, "classStatement_2_1_1");
        classStatement_2_1_1.add(259, s);
        classStatement_2_1_1.add(261, new Str(260, ","));
        classStatement_2_1_1.add(262, s);
        classStatement_2_1_1.add(263, name);
        classStatement_2_1.add(264, classStatement_2_1_1);
        classStatement_2.add(265, classStatement_2_1);
        classStatement_2.add(266, s);
        classStatement.add(267, classStatement_2);
        classStatement.add(269, new Str(268, "{"));
        classStatement.add(270, s);
        Optional classStatement_3 = new Optional(271, "classStatement_3");
        Repeat classStatement_3_1 = new Repeat(272, "classStatement_3_1");
        classStatement_3_1.add(273, attribute, classStatementClassStatementAttribute);
        classStatement_3.add(274, classStatement_3_1);
        classStatement.add(275, classStatement_3);
        classStatement.add(276, manualCode, classStatementClassStatementManualCode);
        OrList classStatement_4 = new OrList(277, "classStatement_4");
        classStatement_4.add(278, manualEnd);
        classStatement_4.add(279, generatedEnd, classStatementClassStatementGeneratedEnd);
        classStatement.add(280, classStatement_4);
        classStatement.add(282, new Complete(281, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(283, s);
        state.add(284, packagestatement);
        state.add(285, s);
        state.add(286, imports, stateStateImports);
        state.add(287, s);
        state.add(288, classStatement, stateStateClassStatement);
        state.add(289, s);

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
        Optional annotations = new Optional(16, "annotations");
        Optional keywords = new Optional(17, "keywords");
        ElementList type = new ElementList(18, "type");
        ElementList attribute = new ElementList(19, "attribute");
        ElementList uname = new ElementList(20, "uname");
        ElementList getter = new ElementList(21, "getter");
        ElementList body = new ElementList(22, "body");
        ElementList manualEnd = new ElementList(23, "manualEnd");
        ElementList generatedEnd = new ElementList(24, "generatedEnd");
        Repeat manualCode = new Repeat(25, "manualCode");
        ElementList classStatement = new ElementList(26, "classStatement");
        ElementList state = new ElementList(27, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(29, new Str(28, "\r\n"));
        newline.add(31, new Str(30, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(32, "comment_1");
        comment_1.add(34, new Str(33, "/*"));
        Optional comment_1_1 = new Optional(35, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(36, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(37, "comment_1_1_1_1");
        comment_1_1_1_1.add(38, comment);
        comment_1_1_1_1.add(40, new Str(39, "*/", NOT));
        comment_1_1_1.add(41, comment_1_1_1_1);
        comment_1_1.add(42, comment_1_1_1);
        comment_1.add(43, comment_1_1);
        comment_1.add(45, new Str(44, "*/"));
        comment.add(46, comment_1);
        ElementList comment_2 = new ElementList(47, "comment_2");
        comment_2.add(49, new Str(48, "//"));
        Optional comment_2_1 = new Optional(50, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(51, "comment_2_1_1");
        comment_2_1_1.add(52, newline, NOT);
        comment_2_1.add(53, comment_2_1_1);
        comment_2.add(54, comment_2_1);
        OrList comment_2_2 = new OrList(55, "comment_2_2");
        comment_2_2.add(56, newline);
        comment_2_2.add(58, new End(57, "comment_2_2"));
        comment_2.add(59, comment_2_2);
        comment.add(60, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(61, "ws_1");
        ws_1.add(62, newline);
        ws_1.add(64, new Str(63, " "));
        ws_1.add(66, new Str(65, "\t"));
        ws_1.add(67, comment);
        ws.add(68, ws_1);

        // s = [ws]
        s.add(69, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(70, ff);
        Repeat str_1 = new Repeat(71, "str_1");
        OrList str_1_1 = new OrList(72, "str_1_1");
        str_1_1.add(74, new Str(73, "\\\""));
        OrList str_1_1_1 = new OrList(75, "str_1_1_1", NOT);
        str_1_1_1.add(76, ff);
        str_1_1_1.add(77, newline);
        str_1_1.add(78, str_1_1_1);
        str_1.add(79, str_1_1);
        str.add(80, str_1);
        str.add(81, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(83, new Range(82, "letter", "a", "z"));
        letter.add(85, new Range(84, "letter", "A", "Z"));
        letter.add(87, new Str(86, "_"));
        letter.add(89, new Str(88, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(90, letter);
        Optional name_1 = new Optional(91, "name_1");
        Repeat name_1_1 = new Repeat(92, "name_1_1");
        OrList name_1_1_1 = new OrList(93, "name_1_1_1");
        name_1_1_1.add(94, letter);
        name_1_1_1.add(95, digit);
        name_1_1.add(96, name_1_1_1);
        name_1.add(97, name_1_1);
        name.add(98, name_1);

        // public = ["public" ws]
        _public.add(100, new Str(99, "public"));
        _public.add(101, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(103, new Str(102, "package"));
        packagestatement.add(104, ws);
        packagestatement.add(105, packagename);
        packagestatement.add(106, s);
        packagestatement.add(108, new Str(107, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(109, name);
        Optional packagename_1 = new Optional(110, "packagename_1");
        Repeat packagename_1_1 = new Repeat(111, "packagename_1_1");
        packagename_1_1.add(113, new Str(112, "."));
        OrList packagename_1_1_1 = new OrList(114, "packagename_1_1_1");
        packagename_1_1_1.add(115, name);
        packagename_1_1_1.add(117, new Str(116, "*"));
        packagename_1_1.add(118, packagename_1_1_1);
        packagename_1.add(119, packagename_1_1);
        packagename.add(120, packagename_1);

        // fullclassname = packagename
        fullclassname.add(121, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(123, new Str(122, "import"));
        importstatement.add(124, ws);
        Optional importstatement_1 = new Optional(125, "importstatement_1");
        importstatement_1.add(127, new Str(126, "static"));
        importstatement_1.add(128, ws);
        importstatement.add(129, importstatement_1);
        importstatement.add(130, fullclassname);
        importstatement.add(131, s);
        importstatement.add(133, new Str(132, ";"));
        importstatement.add(134, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(135, "imports_1");
        imports_1.add(136, importstatement);
        imports.add(137, imports_1);

        // annotations = [("@" name s):annotation]+
        Repeat annotations_1 = new Repeat(138, "annotations_1");
        annotations_1.add(140, new Str(139, "@"));
        annotations_1.add(141, name);
        annotations_1.add(142, s);
        annotations.add(143, annotations_1);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(144, "keywords_1");
        OrList keywords_1_1 = new OrList(145, "keywords_1_1");
        keywords_1_1.add(147, new Str(146, "public "));
        keywords_1_1.add(149, new Str(148, "private "));
        keywords_1_1.add(151, new Str(150, "final "));
        keywords_1.add(152, keywords_1_1);
        keywords_1.add(153, s);
        keywords.add(154, keywords_1);

        // type = name [s "<" s type s ">"] [s "," s type]
        type.add(155, name);
        Optional type_1 = new Optional(156, "type_1");
        type_1.add(157, s);
        type_1.add(159, new Str(158, "<"));
        type_1.add(160, s);
        type_1.add(161, type);
        type_1.add(162, s);
        type_1.add(164, new Str(163, ">"));
        type.add(165, type_1);
        Optional type_2 = new Optional(166, "type_2");
        type_2.add(167, s);
        type_2.add(169, new Str(168, ","));
        type_2.add(170, s);
        type_2.add(171, type);
        type.add(172, type_2);

        // attribute = s annotations keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(173, s);
        attribute.add(174, annotations);
        attribute.add(175, keywords);
        attribute.add(176, s);
        attribute.add(177, type);
        attribute.add(178, ws);
        attribute.add(179, name);
        attribute.add(180, s);
        attribute.add(182, new Str(181, ";"));
        Optional attribute_1 = new Optional(183, "attribute_1");
        Repeat attribute_1_1 = new Repeat(184, "attribute_1_1");
        attribute_1_1.add(185, newline, NOT);
        attribute_1.add(186, attribute_1_1);
        attribute.add(187, attribute_1);
        attribute.add(188, newline);

        // uname = "A".."Z" [letter | digit]+
        uname.add(190, new Range(189, "uname", "A", "Z"));
        Optional uname_1 = new Optional(191, "uname_1");
        Repeat uname_1_1 = new Repeat(192, "uname_1_1");
        OrList uname_1_1_1 = new OrList(193, "uname_1_1_1");
        uname_1_1_1.add(194, letter);
        uname_1_1_1.add(195, digit);
        uname_1_1.add(196, uname_1_1_1);
        uname_1.add(197, uname_1_1);
        uname.add(198, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(200, new Str(199, "get"));
        getter.add(201, uname);
        getter.add(202, s);
        getter.add(204, new Str(203, "("));
        getter.add(205, s);
        getter.add(207, new Str(206, ")"));

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(209, new Str(208, "{"));
        body.add(210, s);
        Optional body_1 = new Optional(211, "body_1");
        Repeat body_1_1 = new Repeat(212, "body_1_1");
        OrList body_1_1_1 = new OrList(213, "body_1_1_1");
        body_1_1_1.add(214, body);
        body_1_1_1.add(215, str);
        body_1_1_1.add(217, new Str(216, "}", NOT));
        body_1_1.add(218, body_1_1_1);
        body_1.add(219, body_1_1);
        body.add(220, body_1);
        body.add(222, new Str(221, "}"));

        // manualEnd = ("}" s END)
        manualEnd.add(224, new Str(223, "}"));
        manualEnd.add(225, s);
        manualEnd.add(227, new End(226, "manualEnd"));

        // generatedEnd = ("// Generated" *)
        generatedEnd.add(229, new Str(228, "// Generated"));
        generatedEnd.add(231, new Complete(230, "generatedEnd"));

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(232, "manualCode_1");
        manualCode_1.add(233, manualEnd);
        manualCode_1.add(234, generatedEnd);
        manualCode.add(235, manualCode_1, NOT);

        // classStatement =
        //   "@State" ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ manualCode
        //   manualEnd|generatedEnd *
        classStatement.add(237, new Str(236, "@State"));
        classStatement.add(238, ws);
        classStatement.add(239, _public);
        classStatement.add(241, new Str(240, "class"));
        classStatement.add(242, ws);
        classStatement.add(243, name);
        classStatement.add(244, s);
        Optional classStatement_1 = new Optional(245, "classStatement_1");
        classStatement_1.add(247, new Str(246, "extends"));
        classStatement_1.add(248, ws);
        classStatement_1.add(249, name);
        classStatement_1.add(250, s);
        classStatement.add(251, classStatement_1);
        Optional classStatement_2 = new Optional(252, "classStatement_2");
        classStatement_2.add(254, new Str(253, "implements"));
        classStatement_2.add(255, ws);
        classStatement_2.add(256, name);
        Optional classStatement_2_1 = new Optional(257, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(258, "classStatement_2_1_1");
        classStatement_2_1_1.add(259, s);
        classStatement_2_1_1.add(261, new Str(260, ","));
        classStatement_2_1_1.add(262, s);
        classStatement_2_1_1.add(263, name);
        classStatement_2_1.add(264, classStatement_2_1_1);
        classStatement_2.add(265, classStatement_2_1);
        classStatement_2.add(266, s);
        classStatement.add(267, classStatement_2);
        classStatement.add(269, new Str(268, "{"));
        classStatement.add(270, s);
        Optional classStatement_3 = new Optional(271, "classStatement_3");
        Repeat classStatement_3_1 = new Repeat(272, "classStatement_3_1");
        classStatement_3_1.add(273, attribute);
        classStatement_3.add(274, classStatement_3_1);
        classStatement.add(275, classStatement_3);
        classStatement.add(276, manualCode);
        OrList classStatement_4 = new OrList(277, "classStatement_4");
        classStatement_4.add(278, manualEnd);
        classStatement_4.add(279, generatedEnd);
        classStatement.add(280, classStatement_4);
        classStatement.add(282, new Complete(281, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(283, s);
        state.add(284, packagestatement);
        state.add(285, s);
        state.add(286, imports);
        state.add(287, s);
        state.add(288, classStatement);
        state.add(289, s);

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
        public void setAnnotations(String annotations);
        public void addAnnotation(String annotation);
        public void setType(String type);
        public void setVariable(String variable);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void addAttribute(IAttribute iattribute);
        public void setManualCode(String manualCode);
        public void setGeneratedEnd();
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

        // attribute.addAnnotation(String annotations.annotation);
        public class AttributeAnnotationsAnnotation implements Output {
            private String name;
            public AttributeAnnotationsAnnotation(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAttribute().addAnnotation(source.get(bookmark));
            }
        }

        // Attribute attribute.setAnnotations(String annotations);
        public class AttributeAttributeAnnotations implements Output {
            private String name;
            public AttributeAttributeAnnotations(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAttribute().setAnnotations(source.get(bookmark));
            }
        }

        // attribute.setType(String type);
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

        // classStatement.setGeneratedEnd(void generatedEnd);
        public class ClassStatementClassStatementGeneratedEnd implements Output {
            private String name;
            public ClassStatementClassStatementGeneratedEnd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassStatement().setGeneratedEnd();
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
