package net.sf.laja.parser.cdd.state;

import net.sf.laja.parser.engine2.Output;
import net.sf.laja.parser.engine2.ParsingResult;
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
 * Auto generated 2013-05-08 by Laja:
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
        Data.AttributeAttributeCommentComment attributeAttributeCommentComment = data2.new AttributeAttributeCommentComment("attributeAttributeCommentComment");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementAttribute classStatementClassStatementAttribute = data2.new ClassStatementClassStatementAttribute("classStatementClassStatementAttribute");
        Data.ClassStatementClassStatementDefaults classStatementClassStatementDefaults = data2.new ClassStatementClassStatementDefaults("classStatementClassStatementDefaults");
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
        ElementList attributeComment = new ElementList(19, "attributeComment");
        ElementList uname = new ElementList(20, "uname");
        ElementList getter = new ElementList(21, "getter");
        ElementList statement = new ElementList(22, "statement");
        ElementList defaults = new ElementList(23, "defaults");
        ElementList classStatement = new ElementList(24, "classStatement");
        ElementList state = new ElementList(25, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(27, new Str(26, "\r\n"));
        newline.add(29, new Str(28, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(30, "comment_1");
        comment_1.add(32, new Str(31, "/*"));
        Optional comment_1_1 = new Optional(33, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(34, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(35, "comment_1_1_1_1");
        comment_1_1_1_1.add(36, comment);
        comment_1_1_1_1.add(38, new Str(37, "*/", NOT));
        comment_1_1_1.add(39, comment_1_1_1_1);
        comment_1_1.add(40, comment_1_1_1);
        comment_1.add(41, comment_1_1);
        comment_1.add(43, new Str(42, "*/"));
        comment.add(44, comment_1);
        ElementList comment_2 = new ElementList(45, "comment_2");
        comment_2.add(47, new Str(46, "//"));
        Optional comment_2_1 = new Optional(48, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(49, "comment_2_1_1");
        comment_2_1_1.add(50, newline, NOT);
        comment_2_1.add(51, comment_2_1_1);
        comment_2.add(52, comment_2_1);
        OrList comment_2_2 = new OrList(53, "comment_2_2");
        comment_2_2.add(54, newline);
        comment_2_2.add(56, new End(55, "comment_2_2"));
        comment_2.add(57, comment_2_2);
        comment.add(58, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(59, "ws_1");
        ws_1.add(60, newline);
        ws_1.add(62, new Str(61, " "));
        ws_1.add(64, new Str(63, "\t"));
        ws_1.add(65, comment);
        ws.add(66, ws_1);

        // s = [ws]
        s.add(67, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(68, ff);
        Repeat str_1 = new Repeat(69, "str_1");
        OrList str_1_1 = new OrList(70, "str_1_1");
        str_1_1.add(72, new Str(71, "\\\""));
        OrList str_1_1_1 = new OrList(73, "str_1_1_1", NOT);
        str_1_1_1.add(74, ff);
        str_1_1_1.add(75, newline);
        str_1_1.add(76, str_1_1_1);
        str_1.add(77, str_1_1);
        str.add(78, str_1);
        str.add(79, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(81, new Range(80, "letter", "a", "z"));
        letter.add(83, new Range(82, "letter", "A", "Z"));
        letter.add(85, new Str(84, "_"));
        letter.add(87, new Str(86, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(88, letter);
        Optional name_1 = new Optional(89, "name_1");
        Repeat name_1_1 = new Repeat(90, "name_1_1");
        OrList name_1_1_1 = new OrList(91, "name_1_1_1");
        name_1_1_1.add(92, letter);
        name_1_1_1.add(93, digit);
        name_1_1.add(94, name_1_1_1);
        name_1.add(95, name_1_1);
        name.add(96, name_1);

        // public = ["public" ws]
        _public.add(98, new Str(97, "public"));
        _public.add(99, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(101, new Str(100, "package"));
        packagestatement.add(102, ws);
        packagestatement.add(103, packagename, statePackagestatementPackagename);
        packagestatement.add(104, s);
        packagestatement.add(106, new Str(105, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(107, name);
        Optional packagename_1 = new Optional(108, "packagename_1");
        Repeat packagename_1_1 = new Repeat(109, "packagename_1_1");
        packagename_1_1.add(111, new Str(110, "."));
        OrList packagename_1_1_1 = new OrList(112, "packagename_1_1_1");
        packagename_1_1_1.add(113, name);
        packagename_1_1_1.add(115, new Str(114, "*"));
        packagename_1_1.add(116, packagename_1_1_1);
        packagename_1.add(117, packagename_1_1);
        packagename.add(118, packagename_1);

        // fullclassname = packagename
        fullclassname.add(119, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(121, new Str(120, "import"));
        importstatement.add(122, ws);
        Optional importstatement_1 = new Optional(123, "importstatement_1");
        importstatement_1.add(125, new Str(124, "static", importstatementImportstatementStatic));
        importstatement_1.add(126, ws);
        importstatement.add(127, importstatement_1);
        importstatement.add(128, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(129, s);
        importstatement.add(131, new Str(130, ";"));
        importstatement.add(132, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(133, "imports_1");
        imports_1.add(134, importstatement, importsImportsImportstatement);
        imports.add(135, imports_1);

        // keywords = [s "public "|"private "|"final "]+
        Repeat keywords_1 = new Repeat(136, "keywords_1");
        keywords_1.add(137, s);
        OrList keywords_1_1 = new OrList(138, "keywords_1_1");
        keywords_1_1.add(140, new Str(139, "public "));
        keywords_1_1.add(142, new Str(141, "private "));
        keywords_1_1.add(144, new Str(143, "final "));
        keywords_1.add(145, keywords_1_1);
        keywords.add(146, keywords_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(147, name);
        Optional type_1 = new Optional(148, "type_1");
        type_1.add(149, s);
        type_1.add(151, new Str(150, "<"));
        type_1.add(152, s);
        type_1.add(153, type);
        type_1.add(154, s);
        type_1.add(156, new Str(155, ">"));
        type.add(157, type_1);
        Optional type_2 = new Optional(158, "type_2");
        type_2.add(159, s);
        type_2.add(161, new Str(160, ","));
        type_2.add(162, s);
        type_2.add(163, type);
        type.add(164, type_2);

        // attribute = keywords s type ws name:variable s ";" attributeComment|s
        attribute.add(165, keywords);
        attribute.add(166, s);
        attribute.add(167, type, attributeAttributeType);
        attribute.add(168, ws);
        attribute.add(169, name, attributeAttributeVariable);
        attribute.add(170, s);
        attribute.add(172, new Str(171, ";"));
        OrList attribute_1 = new OrList(173, "attribute_1");
        attribute_1.add(174, attributeComment);
        attribute_1.add(175, s);
        attribute.add(176, attribute_1);

        // attributeComment = ([" " | "\t"]+ "//" [!newline+]):comment newline|END
        ElementList attributeComment_1 = new ElementList(177, "attributeComment_1", attributeAttributeCommentComment);
        Optional attributeComment_1_1 = new Optional(178, "attributeComment_1_1");
        Repeat attributeComment_1_1_1 = new Repeat(179, "attributeComment_1_1_1");
        OrList attributeComment_1_1_1_1 = new OrList(180, "attributeComment_1_1_1_1");
        attributeComment_1_1_1_1.add(182, new Str(181, " "));
        attributeComment_1_1_1_1.add(184, new Str(183, "\t"));
        attributeComment_1_1_1.add(185, attributeComment_1_1_1_1);
        attributeComment_1_1.add(186, attributeComment_1_1_1);
        attributeComment_1.add(187, attributeComment_1_1);
        attributeComment_1.add(189, new Str(188, "//"));
        Optional attributeComment_1_2 = new Optional(190, "attributeComment_1_2");
        Repeat attributeComment_1_2_1 = new Repeat(191, "attributeComment_1_2_1");
        attributeComment_1_2_1.add(192, newline, NOT);
        attributeComment_1_2.add(193, attributeComment_1_2_1);
        attributeComment_1.add(194, attributeComment_1_2);
        attributeComment.add(195, attributeComment_1);
        OrList attributeComment_2 = new OrList(196, "attributeComment_2");
        attributeComment_2.add(197, newline);
        attributeComment_2.add(199, new End(198, "attributeComment_2"));
        attributeComment.add(200, attributeComment_2);

        // uname = "A".."Z" [letter | digit]+
        uname.add(202, new Range(201, "uname", "A", "Z"));
        Optional uname_1 = new Optional(203, "uname_1");
        Repeat uname_1_1 = new Repeat(204, "uname_1_1");
        OrList uname_1_1_1 = new OrList(205, "uname_1_1_1");
        uname_1_1_1.add(206, letter);
        uname_1_1_1.add(207, digit);
        uname_1_1.add(208, uname_1_1_1);
        uname_1.add(209, uname_1_1);
        uname.add(210, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(212, new Str(211, "get"));
        getter.add(213, uname);
        getter.add(214, s);
        getter.add(216, new Str(215, "("));
        getter.add(217, s);
        getter.add(219, new Str(218, ")"));

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(221, new Str(220, "{"));
        statement.add(222, s);
        Optional statement_1 = new Optional(223, "statement_1");
        Repeat statement_1_1 = new Repeat(224, "statement_1_1");
        OrList statement_1_1_1 = new OrList(225, "statement_1_1_1");
        statement_1_1_1.add(226, statement);
        statement_1_1_1.add(227, str);
        statement_1_1_1.add(229, new Str(228, "}", NOT));
        statement_1_1.add(230, statement_1_1_1);
        statement_1.add(231, statement_1_1);
        statement.add(232, statement_1);
        statement.add(234, new Str(233, "}"));

        // defaults = "private static void setDefaults(" !")"+ ")" s statement
        defaults.add(236, new Str(235, "private static void setDefaults("));
        Repeat defaults_1 = new Repeat(237, "defaults_1");
        defaults_1.add(239, new Str(238, ")", NOT));
        defaults.add(240, defaults_1);
        defaults.add(242, new Str(241, ")"));
        defaults.add(243, s);
        defaults.add(244, statement);

        // classStatement =
        //   public "class" ws name:classname s ["extends" ws name s] "{" [s attribute]+ s
        //   [defaults] s "}"
        classStatement.add(245, _public);
        classStatement.add(247, new Str(246, "class"));
        classStatement.add(248, ws);
        classStatement.add(249, name, classStatementClassStatementClassname);
        classStatement.add(250, s);
        Optional classStatement_1 = new Optional(251, "classStatement_1");
        classStatement_1.add(253, new Str(252, "extends"));
        classStatement_1.add(254, ws);
        classStatement_1.add(255, name);
        classStatement_1.add(256, s);
        classStatement.add(257, classStatement_1);
        classStatement.add(259, new Str(258, "{"));
        Optional classStatement_2 = new Optional(260, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(261, "classStatement_2_1");
        classStatement_2_1.add(262, s);
        classStatement_2_1.add(263, attribute, classStatementClassStatementAttribute);
        classStatement_2.add(264, classStatement_2_1);
        classStatement.add(265, classStatement_2);
        classStatement.add(266, s);
        Optional classStatement_3 = new Optional(267, "classStatement_3");
        classStatement_3.add(268, defaults, classStatementClassStatementDefaults);
        classStatement.add(269, classStatement_3);
        classStatement.add(270, s);
        classStatement.add(272, new Str(271, "}"));

        // state = s packagestatement s imports s classStatement s
        state.add(273, s);
        state.add(274, packagestatement);
        state.add(275, s);
        state.add(276, imports, stateStateImports);
        state.add(277, s);
        state.add(278, classStatement, stateStateClassStatement);
        state.add(279, s);

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
        ElementList attributeComment = new ElementList(19, "attributeComment");
        ElementList uname = new ElementList(20, "uname");
        ElementList getter = new ElementList(21, "getter");
        ElementList statement = new ElementList(22, "statement");
        ElementList defaults = new ElementList(23, "defaults");
        ElementList classStatement = new ElementList(24, "classStatement");
        ElementList state = new ElementList(25, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(27, new Str(26, "\r\n"));
        newline.add(29, new Str(28, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(30, "comment_1");
        comment_1.add(32, new Str(31, "/*"));
        Optional comment_1_1 = new Optional(33, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(34, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(35, "comment_1_1_1_1");
        comment_1_1_1_1.add(36, comment);
        comment_1_1_1_1.add(38, new Str(37, "*/", NOT));
        comment_1_1_1.add(39, comment_1_1_1_1);
        comment_1_1.add(40, comment_1_1_1);
        comment_1.add(41, comment_1_1);
        comment_1.add(43, new Str(42, "*/"));
        comment.add(44, comment_1);
        ElementList comment_2 = new ElementList(45, "comment_2");
        comment_2.add(47, new Str(46, "//"));
        Optional comment_2_1 = new Optional(48, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(49, "comment_2_1_1");
        comment_2_1_1.add(50, newline, NOT);
        comment_2_1.add(51, comment_2_1_1);
        comment_2.add(52, comment_2_1);
        OrList comment_2_2 = new OrList(53, "comment_2_2");
        comment_2_2.add(54, newline);
        comment_2_2.add(56, new End(55, "comment_2_2"));
        comment_2.add(57, comment_2_2);
        comment.add(58, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(59, "ws_1");
        ws_1.add(60, newline);
        ws_1.add(62, new Str(61, " "));
        ws_1.add(64, new Str(63, "\t"));
        ws_1.add(65, comment);
        ws.add(66, ws_1);

        // s = [ws]
        s.add(67, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(68, ff);
        Repeat str_1 = new Repeat(69, "str_1");
        OrList str_1_1 = new OrList(70, "str_1_1");
        str_1_1.add(72, new Str(71, "\\\""));
        OrList str_1_1_1 = new OrList(73, "str_1_1_1", NOT);
        str_1_1_1.add(74, ff);
        str_1_1_1.add(75, newline);
        str_1_1.add(76, str_1_1_1);
        str_1.add(77, str_1_1);
        str.add(78, str_1);
        str.add(79, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(81, new Range(80, "letter", "a", "z"));
        letter.add(83, new Range(82, "letter", "A", "Z"));
        letter.add(85, new Str(84, "_"));
        letter.add(87, new Str(86, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(88, letter);
        Optional name_1 = new Optional(89, "name_1");
        Repeat name_1_1 = new Repeat(90, "name_1_1");
        OrList name_1_1_1 = new OrList(91, "name_1_1_1");
        name_1_1_1.add(92, letter);
        name_1_1_1.add(93, digit);
        name_1_1.add(94, name_1_1_1);
        name_1.add(95, name_1_1);
        name.add(96, name_1);

        // public = ["public" ws]
        _public.add(98, new Str(97, "public"));
        _public.add(99, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(101, new Str(100, "package"));
        packagestatement.add(102, ws);
        packagestatement.add(103, packagename);
        packagestatement.add(104, s);
        packagestatement.add(106, new Str(105, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(107, name);
        Optional packagename_1 = new Optional(108, "packagename_1");
        Repeat packagename_1_1 = new Repeat(109, "packagename_1_1");
        packagename_1_1.add(111, new Str(110, "."));
        OrList packagename_1_1_1 = new OrList(112, "packagename_1_1_1");
        packagename_1_1_1.add(113, name);
        packagename_1_1_1.add(115, new Str(114, "*"));
        packagename_1_1.add(116, packagename_1_1_1);
        packagename_1.add(117, packagename_1_1);
        packagename.add(118, packagename_1);

        // fullclassname = packagename
        fullclassname.add(119, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(121, new Str(120, "import"));
        importstatement.add(122, ws);
        Optional importstatement_1 = new Optional(123, "importstatement_1");
        importstatement_1.add(125, new Str(124, "static"));
        importstatement_1.add(126, ws);
        importstatement.add(127, importstatement_1);
        importstatement.add(128, fullclassname);
        importstatement.add(129, s);
        importstatement.add(131, new Str(130, ";"));
        importstatement.add(132, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(133, "imports_1");
        imports_1.add(134, importstatement);
        imports.add(135, imports_1);

        // keywords = [s "public "|"private "|"final "]+
        Repeat keywords_1 = new Repeat(136, "keywords_1");
        keywords_1.add(137, s);
        OrList keywords_1_1 = new OrList(138, "keywords_1_1");
        keywords_1_1.add(140, new Str(139, "public "));
        keywords_1_1.add(142, new Str(141, "private "));
        keywords_1_1.add(144, new Str(143, "final "));
        keywords_1.add(145, keywords_1_1);
        keywords.add(146, keywords_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(147, name);
        Optional type_1 = new Optional(148, "type_1");
        type_1.add(149, s);
        type_1.add(151, new Str(150, "<"));
        type_1.add(152, s);
        type_1.add(153, type);
        type_1.add(154, s);
        type_1.add(156, new Str(155, ">"));
        type.add(157, type_1);
        Optional type_2 = new Optional(158, "type_2");
        type_2.add(159, s);
        type_2.add(161, new Str(160, ","));
        type_2.add(162, s);
        type_2.add(163, type);
        type.add(164, type_2);

        // attribute = keywords s type ws name:variable s ";" attributeComment|s
        attribute.add(165, keywords);
        attribute.add(166, s);
        attribute.add(167, type);
        attribute.add(168, ws);
        attribute.add(169, name);
        attribute.add(170, s);
        attribute.add(172, new Str(171, ";"));
        OrList attribute_1 = new OrList(173, "attribute_1");
        attribute_1.add(174, attributeComment);
        attribute_1.add(175, s);
        attribute.add(176, attribute_1);

        // attributeComment = ([" " | "\t"]+ "//" [!newline+]):comment newline|END
        ElementList attributeComment_1 = new ElementList(177, "attributeComment_1");
        Optional attributeComment_1_1 = new Optional(178, "attributeComment_1_1");
        Repeat attributeComment_1_1_1 = new Repeat(179, "attributeComment_1_1_1");
        OrList attributeComment_1_1_1_1 = new OrList(180, "attributeComment_1_1_1_1");
        attributeComment_1_1_1_1.add(182, new Str(181, " "));
        attributeComment_1_1_1_1.add(184, new Str(183, "\t"));
        attributeComment_1_1_1.add(185, attributeComment_1_1_1_1);
        attributeComment_1_1.add(186, attributeComment_1_1_1);
        attributeComment_1.add(187, attributeComment_1_1);
        attributeComment_1.add(189, new Str(188, "//"));
        Optional attributeComment_1_2 = new Optional(190, "attributeComment_1_2");
        Repeat attributeComment_1_2_1 = new Repeat(191, "attributeComment_1_2_1");
        attributeComment_1_2_1.add(192, newline, NOT);
        attributeComment_1_2.add(193, attributeComment_1_2_1);
        attributeComment_1.add(194, attributeComment_1_2);
        attributeComment.add(195, attributeComment_1);
        OrList attributeComment_2 = new OrList(196, "attributeComment_2");
        attributeComment_2.add(197, newline);
        attributeComment_2.add(199, new End(198, "attributeComment_2"));
        attributeComment.add(200, attributeComment_2);

        // uname = "A".."Z" [letter | digit]+
        uname.add(202, new Range(201, "uname", "A", "Z"));
        Optional uname_1 = new Optional(203, "uname_1");
        Repeat uname_1_1 = new Repeat(204, "uname_1_1");
        OrList uname_1_1_1 = new OrList(205, "uname_1_1_1");
        uname_1_1_1.add(206, letter);
        uname_1_1_1.add(207, digit);
        uname_1_1.add(208, uname_1_1_1);
        uname_1.add(209, uname_1_1);
        uname.add(210, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(212, new Str(211, "get"));
        getter.add(213, uname);
        getter.add(214, s);
        getter.add(216, new Str(215, "("));
        getter.add(217, s);
        getter.add(219, new Str(218, ")"));

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(221, new Str(220, "{"));
        statement.add(222, s);
        Optional statement_1 = new Optional(223, "statement_1");
        Repeat statement_1_1 = new Repeat(224, "statement_1_1");
        OrList statement_1_1_1 = new OrList(225, "statement_1_1_1");
        statement_1_1_1.add(226, statement);
        statement_1_1_1.add(227, str);
        statement_1_1_1.add(229, new Str(228, "}", NOT));
        statement_1_1.add(230, statement_1_1_1);
        statement_1.add(231, statement_1_1);
        statement.add(232, statement_1);
        statement.add(234, new Str(233, "}"));

        // defaults = "private static void setDefaults(" !")"+ ")" s statement
        defaults.add(236, new Str(235, "private static void setDefaults("));
        Repeat defaults_1 = new Repeat(237, "defaults_1");
        defaults_1.add(239, new Str(238, ")", NOT));
        defaults.add(240, defaults_1);
        defaults.add(242, new Str(241, ")"));
        defaults.add(243, s);
        defaults.add(244, statement);

        // classStatement =
        //   public "class" ws name:classname s ["extends" ws name s] "{" [s attribute]+ s
        //   [defaults] s "}"
        classStatement.add(245, _public);
        classStatement.add(247, new Str(246, "class"));
        classStatement.add(248, ws);
        classStatement.add(249, name);
        classStatement.add(250, s);
        Optional classStatement_1 = new Optional(251, "classStatement_1");
        classStatement_1.add(253, new Str(252, "extends"));
        classStatement_1.add(254, ws);
        classStatement_1.add(255, name);
        classStatement_1.add(256, s);
        classStatement.add(257, classStatement_1);
        classStatement.add(259, new Str(258, "{"));
        Optional classStatement_2 = new Optional(260, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(261, "classStatement_2_1");
        classStatement_2_1.add(262, s);
        classStatement_2_1.add(263, attribute);
        classStatement_2.add(264, classStatement_2_1);
        classStatement.add(265, classStatement_2);
        classStatement.add(266, s);
        Optional classStatement_3 = new Optional(267, "classStatement_3");
        classStatement_3.add(268, defaults);
        classStatement.add(269, classStatement_3);
        classStatement.add(270, s);
        classStatement.add(272, new Str(271, "}"));

        // state = s packagestatement s imports s classStatement s
        state.add(273, s);
        state.add(274, packagestatement);
        state.add(275, s);
        state.add(276, imports);
        state.add(277, s);
        state.add(278, classStatement);
        state.add(279, s);

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
        public void setComment(String comment);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void addAttribute(IAttribute iattribute);
        public void setDefaultsMethod(String defaults);
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

        // attribute.setComment(String attributeComment.comment);
        public class AttributeAttributeCommentComment implements Output {
            private String name;
            public AttributeAttributeCommentComment(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAttribute().setComment(source.get(bookmark));
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

        // classStatement.setDefaultsMethod(String defaults);
        public class ClassStatementClassStatementDefaults implements Output {
            private String name;
            public ClassStatementClassStatementDefaults(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassStatement().setDefaultsMethod(source.get(bookmark));
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
