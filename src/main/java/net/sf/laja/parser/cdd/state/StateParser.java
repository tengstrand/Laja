package net.sf.laja.parser.cdd.state;

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
 * Auto generated 2013-04-24 by Laja:
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
        ElementList classStatement = new ElementList(22, "classStatement");
        ElementList state = new ElementList(23, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(25, new Str(24, "\r\n"));
        newline.add(27, new Str(26, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(28, "comment_1");
        comment_1.add(30, new Str(29, "/*"));
        Optional comment_1_1 = new Optional(31, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(32, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(33, "comment_1_1_1_1");
        comment_1_1_1_1.add(34, comment);
        comment_1_1_1_1.add(36, new Str(35, "*/", NOT));
        comment_1_1_1.add(37, comment_1_1_1_1);
        comment_1_1.add(38, comment_1_1_1);
        comment_1.add(39, comment_1_1);
        comment_1.add(41, new Str(40, "*/"));
        comment.add(42, comment_1);
        ElementList comment_2 = new ElementList(43, "comment_2");
        comment_2.add(45, new Str(44, "//"));
        Optional comment_2_1 = new Optional(46, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(47, "comment_2_1_1");
        comment_2_1_1.add(48, newline, NOT);
        comment_2_1.add(49, comment_2_1_1);
        comment_2.add(50, comment_2_1);
        OrList comment_2_2 = new OrList(51, "comment_2_2");
        comment_2_2.add(52, newline);
        comment_2_2.add(54, new End(53, "comment_2_2"));
        comment_2.add(55, comment_2_2);
        comment.add(56, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(57, "ws_1");
        ws_1.add(58, newline);
        ws_1.add(60, new Str(59, " "));
        ws_1.add(62, new Str(61, "\t"));
        ws_1.add(63, comment);
        ws.add(64, ws_1);

        // s = [ws]
        s.add(65, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(66, ff);
        Repeat str_1 = new Repeat(67, "str_1");
        OrList str_1_1 = new OrList(68, "str_1_1");
        str_1_1.add(70, new Str(69, "\\\""));
        OrList str_1_1_1 = new OrList(71, "str_1_1_1", NOT);
        str_1_1_1.add(72, ff);
        str_1_1_1.add(73, newline);
        str_1_1.add(74, str_1_1_1);
        str_1.add(75, str_1_1);
        str.add(76, str_1);
        str.add(77, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(79, new Range(78, "letter", "a", "z"));
        letter.add(81, new Range(80, "letter", "A", "Z"));
        letter.add(83, new Str(82, "_"));
        letter.add(85, new Str(84, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(86, letter);
        Optional name_1 = new Optional(87, "name_1");
        Repeat name_1_1 = new Repeat(88, "name_1_1");
        OrList name_1_1_1 = new OrList(89, "name_1_1_1");
        name_1_1_1.add(90, letter);
        name_1_1_1.add(91, digit);
        name_1_1.add(92, name_1_1_1);
        name_1.add(93, name_1_1);
        name.add(94, name_1);

        // public = ["public" ws]
        _public.add(96, new Str(95, "public"));
        _public.add(97, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(99, new Str(98, "package"));
        packagestatement.add(100, ws);
        packagestatement.add(101, packagename, statePackagestatementPackagename);
        packagestatement.add(102, s);
        packagestatement.add(104, new Str(103, ";"));

        // packagename = name ["." name]+
        packagename.add(105, name);
        Optional packagename_1 = new Optional(106, "packagename_1");
        Repeat packagename_1_1 = new Repeat(107, "packagename_1_1");
        packagename_1_1.add(109, new Str(108, "."));
        packagename_1_1.add(110, name);
        packagename_1.add(111, packagename_1_1);
        packagename.add(112, packagename_1);

        // fullclassname = packagename
        fullclassname.add(113, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";"
        importstatement.add(115, new Str(114, "import"));
        importstatement.add(116, ws);
        Optional importstatement_1 = new Optional(117, "importstatement_1");
        importstatement_1.add(119, new Str(118, "static", importstatementImportstatementStatic));
        importstatement_1.add(120, ws);
        importstatement.add(121, importstatement_1);
        importstatement.add(122, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(123, s);
        importstatement.add(125, new Str(124, ";"));

        // imports = [s importstatement]+
        Repeat imports_1 = new Repeat(126, "imports_1");
        imports_1.add(127, s);
        imports_1.add(128, importstatement, importsImportsImportstatement);
        imports.add(129, imports_1);

        // keywords = [s "public "|"private "|"final "]+
        Repeat keywords_1 = new Repeat(130, "keywords_1");
        keywords_1.add(131, s);
        OrList keywords_1_1 = new OrList(132, "keywords_1_1");
        keywords_1_1.add(134, new Str(133, "public "));
        keywords_1_1.add(136, new Str(135, "private "));
        keywords_1_1.add(138, new Str(137, "final "));
        keywords_1.add(139, keywords_1_1);
        keywords.add(140, keywords_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(141, name);
        Optional type_1 = new Optional(142, "type_1");
        type_1.add(143, s);
        type_1.add(145, new Str(144, "<"));
        type_1.add(146, s);
        type_1.add(147, type);
        type_1.add(148, s);
        type_1.add(150, new Str(149, ">"));
        type.add(151, type_1);
        Optional type_2 = new Optional(152, "type_2");
        type_2.add(153, s);
        type_2.add(155, new Str(154, ","));
        type_2.add(156, s);
        type_2.add(157, type);
        type.add(158, type_2);

        // attribute = keywords s type ws name:variable s ";" attributeComment|s
        attribute.add(159, keywords);
        attribute.add(160, s);
        attribute.add(161, type, attributeAttributeType);
        attribute.add(162, ws);
        attribute.add(163, name, attributeAttributeVariable);
        attribute.add(164, s);
        attribute.add(166, new Str(165, ";"));
        OrList attribute_1 = new OrList(167, "attribute_1");
        attribute_1.add(168, attributeComment);
        attribute_1.add(169, s);
        attribute.add(170, attribute_1);

        // attributeComment = ([" " | "\t"]+ "//" [!newline+]):comment newline|END
        ElementList attributeComment_1 = new ElementList(171, "attributeComment_1", attributeAttributeCommentComment);
        Optional attributeComment_1_1 = new Optional(172, "attributeComment_1_1");
        Repeat attributeComment_1_1_1 = new Repeat(173, "attributeComment_1_1_1");
        OrList attributeComment_1_1_1_1 = new OrList(174, "attributeComment_1_1_1_1");
        attributeComment_1_1_1_1.add(176, new Str(175, " "));
        attributeComment_1_1_1_1.add(178, new Str(177, "\t"));
        attributeComment_1_1_1.add(179, attributeComment_1_1_1_1);
        attributeComment_1_1.add(180, attributeComment_1_1_1);
        attributeComment_1.add(181, attributeComment_1_1);
        attributeComment_1.add(183, new Str(182, "//"));
        Optional attributeComment_1_2 = new Optional(184, "attributeComment_1_2");
        Repeat attributeComment_1_2_1 = new Repeat(185, "attributeComment_1_2_1");
        attributeComment_1_2_1.add(186, newline, NOT);
        attributeComment_1_2.add(187, attributeComment_1_2_1);
        attributeComment_1.add(188, attributeComment_1_2);
        attributeComment.add(189, attributeComment_1);
        OrList attributeComment_2 = new OrList(190, "attributeComment_2");
        attributeComment_2.add(191, newline);
        attributeComment_2.add(193, new End(192, "attributeComment_2"));
        attributeComment.add(194, attributeComment_2);

        // uname = "A".."Z" [letter | digit]+
        uname.add(196, new Range(195, "uname", "A", "Z"));
        Optional uname_1 = new Optional(197, "uname_1");
        Repeat uname_1_1 = new Repeat(198, "uname_1_1");
        OrList uname_1_1_1 = new OrList(199, "uname_1_1_1");
        uname_1_1_1.add(200, letter);
        uname_1_1_1.add(201, digit);
        uname_1_1.add(202, uname_1_1_1);
        uname_1.add(203, uname_1_1);
        uname.add(204, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(206, new Str(205, "get"));
        getter.add(207, uname);
        getter.add(208, s);
        getter.add(210, new Str(209, "("));
        getter.add(211, s);
        getter.add(213, new Str(212, ")"));

        // classStatement = public "class" ws name:classname s ["extends" ws name s] "{" [s attribute]+ s "}"
        classStatement.add(214, _public);
        classStatement.add(216, new Str(215, "class"));
        classStatement.add(217, ws);
        classStatement.add(218, name, classStatementClassStatementClassname);
        classStatement.add(219, s);
        Optional classStatement_1 = new Optional(220, "classStatement_1");
        classStatement_1.add(222, new Str(221, "extends"));
        classStatement_1.add(223, ws);
        classStatement_1.add(224, name);
        classStatement_1.add(225, s);
        classStatement.add(226, classStatement_1);
        classStatement.add(228, new Str(227, "{"));
        Optional classStatement_2 = new Optional(229, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(230, "classStatement_2_1");
        classStatement_2_1.add(231, s);
        classStatement_2_1.add(232, attribute, classStatementClassStatementAttribute);
        classStatement_2.add(233, classStatement_2_1);
        classStatement.add(234, classStatement_2);
        classStatement.add(235, s);
        classStatement.add(237, new Str(236, "}"));

        // state = s packagestatement s imports s classStatement s
        state.add(238, s);
        state.add(239, packagestatement);
        state.add(240, s);
        state.add(241, imports, stateStateImports);
        state.add(242, s);
        state.add(243, classStatement, stateStateClassStatement);
        state.add(244, s);

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
        ElementList classStatement = new ElementList(22, "classStatement");
        ElementList state = new ElementList(23, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(25, new Str(24, "\r\n"));
        newline.add(27, new Str(26, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(28, "comment_1");
        comment_1.add(30, new Str(29, "/*"));
        Optional comment_1_1 = new Optional(31, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(32, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(33, "comment_1_1_1_1");
        comment_1_1_1_1.add(34, comment);
        comment_1_1_1_1.add(36, new Str(35, "*/", NOT));
        comment_1_1_1.add(37, comment_1_1_1_1);
        comment_1_1.add(38, comment_1_1_1);
        comment_1.add(39, comment_1_1);
        comment_1.add(41, new Str(40, "*/"));
        comment.add(42, comment_1);
        ElementList comment_2 = new ElementList(43, "comment_2");
        comment_2.add(45, new Str(44, "//"));
        Optional comment_2_1 = new Optional(46, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(47, "comment_2_1_1");
        comment_2_1_1.add(48, newline, NOT);
        comment_2_1.add(49, comment_2_1_1);
        comment_2.add(50, comment_2_1);
        OrList comment_2_2 = new OrList(51, "comment_2_2");
        comment_2_2.add(52, newline);
        comment_2_2.add(54, new End(53, "comment_2_2"));
        comment_2.add(55, comment_2_2);
        comment.add(56, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(57, "ws_1");
        ws_1.add(58, newline);
        ws_1.add(60, new Str(59, " "));
        ws_1.add(62, new Str(61, "\t"));
        ws_1.add(63, comment);
        ws.add(64, ws_1);

        // s = [ws]
        s.add(65, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(66, ff);
        Repeat str_1 = new Repeat(67, "str_1");
        OrList str_1_1 = new OrList(68, "str_1_1");
        str_1_1.add(70, new Str(69, "\\\""));
        OrList str_1_1_1 = new OrList(71, "str_1_1_1", NOT);
        str_1_1_1.add(72, ff);
        str_1_1_1.add(73, newline);
        str_1_1.add(74, str_1_1_1);
        str_1.add(75, str_1_1);
        str.add(76, str_1);
        str.add(77, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(79, new Range(78, "letter", "a", "z"));
        letter.add(81, new Range(80, "letter", "A", "Z"));
        letter.add(83, new Str(82, "_"));
        letter.add(85, new Str(84, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(86, letter);
        Optional name_1 = new Optional(87, "name_1");
        Repeat name_1_1 = new Repeat(88, "name_1_1");
        OrList name_1_1_1 = new OrList(89, "name_1_1_1");
        name_1_1_1.add(90, letter);
        name_1_1_1.add(91, digit);
        name_1_1.add(92, name_1_1_1);
        name_1.add(93, name_1_1);
        name.add(94, name_1);

        // public = ["public" ws]
        _public.add(96, new Str(95, "public"));
        _public.add(97, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(99, new Str(98, "package"));
        packagestatement.add(100, ws);
        packagestatement.add(101, packagename);
        packagestatement.add(102, s);
        packagestatement.add(104, new Str(103, ";"));

        // packagename = name ["." name]+
        packagename.add(105, name);
        Optional packagename_1 = new Optional(106, "packagename_1");
        Repeat packagename_1_1 = new Repeat(107, "packagename_1_1");
        packagename_1_1.add(109, new Str(108, "."));
        packagename_1_1.add(110, name);
        packagename_1.add(111, packagename_1_1);
        packagename.add(112, packagename_1);

        // fullclassname = packagename
        fullclassname.add(113, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";"
        importstatement.add(115, new Str(114, "import"));
        importstatement.add(116, ws);
        Optional importstatement_1 = new Optional(117, "importstatement_1");
        importstatement_1.add(119, new Str(118, "static"));
        importstatement_1.add(120, ws);
        importstatement.add(121, importstatement_1);
        importstatement.add(122, fullclassname);
        importstatement.add(123, s);
        importstatement.add(125, new Str(124, ";"));

        // imports = [s importstatement]+
        Repeat imports_1 = new Repeat(126, "imports_1");
        imports_1.add(127, s);
        imports_1.add(128, importstatement);
        imports.add(129, imports_1);

        // keywords = [s "public "|"private "|"final "]+
        Repeat keywords_1 = new Repeat(130, "keywords_1");
        keywords_1.add(131, s);
        OrList keywords_1_1 = new OrList(132, "keywords_1_1");
        keywords_1_1.add(134, new Str(133, "public "));
        keywords_1_1.add(136, new Str(135, "private "));
        keywords_1_1.add(138, new Str(137, "final "));
        keywords_1.add(139, keywords_1_1);
        keywords.add(140, keywords_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(141, name);
        Optional type_1 = new Optional(142, "type_1");
        type_1.add(143, s);
        type_1.add(145, new Str(144, "<"));
        type_1.add(146, s);
        type_1.add(147, type);
        type_1.add(148, s);
        type_1.add(150, new Str(149, ">"));
        type.add(151, type_1);
        Optional type_2 = new Optional(152, "type_2");
        type_2.add(153, s);
        type_2.add(155, new Str(154, ","));
        type_2.add(156, s);
        type_2.add(157, type);
        type.add(158, type_2);

        // attribute = keywords s type ws name:variable s ";" attributeComment|s
        attribute.add(159, keywords);
        attribute.add(160, s);
        attribute.add(161, type);
        attribute.add(162, ws);
        attribute.add(163, name);
        attribute.add(164, s);
        attribute.add(166, new Str(165, ";"));
        OrList attribute_1 = new OrList(167, "attribute_1");
        attribute_1.add(168, attributeComment);
        attribute_1.add(169, s);
        attribute.add(170, attribute_1);

        // attributeComment = ([" " | "\t"]+ "//" [!newline+]):comment newline|END
        ElementList attributeComment_1 = new ElementList(171, "attributeComment_1");
        Optional attributeComment_1_1 = new Optional(172, "attributeComment_1_1");
        Repeat attributeComment_1_1_1 = new Repeat(173, "attributeComment_1_1_1");
        OrList attributeComment_1_1_1_1 = new OrList(174, "attributeComment_1_1_1_1");
        attributeComment_1_1_1_1.add(176, new Str(175, " "));
        attributeComment_1_1_1_1.add(178, new Str(177, "\t"));
        attributeComment_1_1_1.add(179, attributeComment_1_1_1_1);
        attributeComment_1_1.add(180, attributeComment_1_1_1);
        attributeComment_1.add(181, attributeComment_1_1);
        attributeComment_1.add(183, new Str(182, "//"));
        Optional attributeComment_1_2 = new Optional(184, "attributeComment_1_2");
        Repeat attributeComment_1_2_1 = new Repeat(185, "attributeComment_1_2_1");
        attributeComment_1_2_1.add(186, newline, NOT);
        attributeComment_1_2.add(187, attributeComment_1_2_1);
        attributeComment_1.add(188, attributeComment_1_2);
        attributeComment.add(189, attributeComment_1);
        OrList attributeComment_2 = new OrList(190, "attributeComment_2");
        attributeComment_2.add(191, newline);
        attributeComment_2.add(193, new End(192, "attributeComment_2"));
        attributeComment.add(194, attributeComment_2);

        // uname = "A".."Z" [letter | digit]+
        uname.add(196, new Range(195, "uname", "A", "Z"));
        Optional uname_1 = new Optional(197, "uname_1");
        Repeat uname_1_1 = new Repeat(198, "uname_1_1");
        OrList uname_1_1_1 = new OrList(199, "uname_1_1_1");
        uname_1_1_1.add(200, letter);
        uname_1_1_1.add(201, digit);
        uname_1_1.add(202, uname_1_1_1);
        uname_1.add(203, uname_1_1);
        uname.add(204, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(206, new Str(205, "get"));
        getter.add(207, uname);
        getter.add(208, s);
        getter.add(210, new Str(209, "("));
        getter.add(211, s);
        getter.add(213, new Str(212, ")"));

        // classStatement = public "class" ws name:classname s ["extends" ws name s] "{" [s attribute]+ s "}"
        classStatement.add(214, _public);
        classStatement.add(216, new Str(215, "class"));
        classStatement.add(217, ws);
        classStatement.add(218, name);
        classStatement.add(219, s);
        Optional classStatement_1 = new Optional(220, "classStatement_1");
        classStatement_1.add(222, new Str(221, "extends"));
        classStatement_1.add(223, ws);
        classStatement_1.add(224, name);
        classStatement_1.add(225, s);
        classStatement.add(226, classStatement_1);
        classStatement.add(228, new Str(227, "{"));
        Optional classStatement_2 = new Optional(229, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(230, "classStatement_2_1");
        classStatement_2_1.add(231, s);
        classStatement_2_1.add(232, attribute);
        classStatement_2.add(233, classStatement_2_1);
        classStatement.add(234, classStatement_2);
        classStatement.add(235, s);
        classStatement.add(237, new Str(236, "}"));

        // state = s packagestatement s imports s classStatement s
        state.add(238, s);
        state.add(239, packagestatement);
        state.add(240, s);
        state.add(241, imports);
        state.add(242, s);
        state.add(243, classStatement);
        state.add(244, s);

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
