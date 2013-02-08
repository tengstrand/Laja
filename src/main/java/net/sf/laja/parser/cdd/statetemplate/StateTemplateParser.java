package net.sf.laja.parser.cdd.statetemplate;

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
 * Auto generated 2013-02-07 by Laja:
 *    http://laja.sf.net
 *
 * Version: laja2-006-alpha
 */
public final class StateTemplateParser implements net.sf.laja.parser.engine2.Parser {
    private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
    private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
    private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

    private Data data1;
    private Data data2;
    private IStateTemplateFactory factory1;
    private IStateTemplateFactory factory2;
    private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
    private SyntaxErrorHandler syntaxErrorHandler;

    public static final int PHASE1 = 1;
    public static final int PHASE2 = 2;

    public StateTemplateParser(IStateTemplateFactoryFactory factoryFactory) {
        init(factoryFactory);
    }

    public void init(IStateTemplateFactoryFactory factoryFactory) {
        syntaxErrorHandler = new DefaultSyntaxErrorHandler();
        factory1 = factoryFactory.getFactory(PHASE1);
        factory2 = factoryFactory.getFactory(PHASE2);
        data1 = new Data(factory1);
        data2 = new Data(factory2);
    }

    public StateTemplateParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
        sourceRecorderLogWriter = writer;
        return this;
    }

    public StateTemplateParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
        this.syntaxErrorHandler = syntaxErrorHandler;
        return this;
    }

    public IStateTemplateFactory getFactory1() {
        return factory1;
    }

    public IStateTemplateFactory getFactory() {
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
        Data.StateTemplatePackagestatementPackagename stateTemplatePackagestatementPackagename = data2.new StateTemplatePackagestatementPackagename("stateTemplatePackagestatementPackagename");
        Data.ImportstatementImportstatementStatic importstatementImportstatementStatic = data2.new ImportstatementImportstatementStatic("importstatementImportstatementStatic");
        Data.ImportstatementImportstatementFullclassname importstatementImportstatementFullclassname = data2.new ImportstatementImportstatementFullclassname("importstatementImportstatementFullclassname");
        Data.ImportsImportsImportstatement importsImportsImportstatement = data2.new ImportsImportsImportstatement("importsImportsImportstatement");
        Data.AttributeInitialValueValue attributeInitialValueValue = data2.new AttributeInitialValueValue("attributeInitialValueValue");
        Data.AttributeAttributeType attributeAttributeType = data2.new AttributeAttributeType("attributeAttributeType");
        Data.AttributeAttributeVariable attributeAttributeVariable = data2.new AttributeAttributeVariable("attributeAttributeVariable");
        Data.AttributeAttributeCommentComment attributeAttributeCommentComment = data2.new AttributeAttributeCommentComment("attributeAttributeCommentComment");
        Data.StatementStatementInnerStatement statementStatementInnerStatement = data2.new StatementStatementInnerStatement("statementStatementInnerStatement");
        Data.StatementStatementStatement statementStatementStatement = data2.new StatementStatementStatement("statementStatementStatement");
        Data.IsvalidIsvalidStatement isvalidIsvalidStatement = data2.new IsvalidIsvalidStatement("isvalidIsvalidStatement");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementAttribute classStatementClassStatementAttribute = data2.new ClassStatementClassStatementAttribute("classStatementClassStatementAttribute");
        Data.ClassStatementClassStatementIsvalid classStatementClassStatementIsvalid = data2.new ClassStatementClassStatementIsvalid("classStatementClassStatementIsvalid");
        Data.StateTemplateStateTemplateImports stateTemplateStateTemplateImports = data2.new StateTemplateStateTemplateImports("stateTemplateStateTemplateImports");
        Data.StateTemplateStateTemplateClassStatement stateTemplateStateTemplateClassStatement = data2.new StateTemplateStateTemplateClassStatement("stateTemplateStateTemplateClassStatement");

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
        ElementList type = new ElementList(16, "type");
        ElementList initialValue = new ElementList(17, "initialValue");
        ElementList attribute = new ElementList(18, "attribute");
        ElementList attributeComment = new ElementList(19, "attributeComment");
        ElementList statement = new ElementList(20, "statement");
        ElementList isvalid = new ElementList(21, "isvalid");
        ElementList uname = new ElementList(22, "uname");
        ElementList getter = new ElementList(23, "getter");
        ElementList classStatement = new ElementList(24, "classStatement");
        ElementList stateTemplate = new ElementList(25, "stateTemplate");

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
        packagestatement.add(103, packagename, stateTemplatePackagestatementPackagename);
        packagestatement.add(104, s);
        packagestatement.add(106, new Str(105, ";"));

        // packagename = name ["." name]+
        packagename.add(107, name);
        Optional packagename_1 = new Optional(108, "packagename_1");
        Repeat packagename_1_1 = new Repeat(109, "packagename_1_1");
        packagename_1_1.add(111, new Str(110, "."));
        packagename_1_1.add(112, name);
        packagename_1.add(113, packagename_1_1);
        packagename.add(114, packagename_1);

        // fullclassname = packagename
        fullclassname.add(115, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";"
        importstatement.add(117, new Str(116, "import"));
        importstatement.add(118, ws);
        Optional importstatement_1 = new Optional(119, "importstatement_1");
        importstatement_1.add(121, new Str(120, "static", importstatementImportstatementStatic));
        importstatement_1.add(122, ws);
        importstatement.add(123, importstatement_1);
        importstatement.add(124, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(125, s);
        importstatement.add(127, new Str(126, ";"));

        // imports = [s importstatement]+
        Repeat imports_1 = new Repeat(128, "imports_1");
        imports_1.add(129, s);
        imports_1.add(130, importstatement, importsImportsImportstatement);
        imports.add(131, imports_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(132, name);
        Optional type_1 = new Optional(133, "type_1");
        type_1.add(134, s);
        type_1.add(136, new Str(135, "<"));
        type_1.add(137, s);
        type_1.add(138, type);
        type_1.add(139, s);
        type_1.add(141, new Str(140, ">"));
        type.add(142, type_1);
        Optional type_2 = new Optional(143, "type_2");
        type_2.add(144, s);
        type_2.add(146, new Str(145, ","));
        type_2.add(147, s);
        type_2.add(148, type);
        type.add(149, type_2);

        // initialValue = "=" s !";"+:value
        initialValue.add(151, new Str(150, "="));
        initialValue.add(152, s);
        Repeat initialValue_1 = new Repeat(153, "initialValue_1", attributeInitialValueValue);
        initialValue_1.add(155, new Str(154, ";", NOT));
        initialValue.add(156, initialValue_1);

        // attribute = type ws name:variable s [initialValue s] ";" attributeComment|s
        attribute.add(157, type, attributeAttributeType);
        attribute.add(158, ws);
        attribute.add(159, name, attributeAttributeVariable);
        attribute.add(160, s);
        Optional attribute_1 = new Optional(161, "attribute_1");
        attribute_1.add(162, initialValue);
        attribute_1.add(163, s);
        attribute.add(164, attribute_1);
        attribute.add(166, new Str(165, ";"));
        OrList attribute_2 = new OrList(167, "attribute_2");
        attribute_2.add(168, attributeComment);
        attribute_2.add(169, s);
        attribute.add(170, attribute_2);

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

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(196, new Str(195, "{"));
        statement.add(197, s);
        Optional statement_1 = new Optional(198, "statement_1", statementStatementInnerStatement);
        Repeat statement_1_1 = new Repeat(199, "statement_1_1");
        OrList statement_1_1_1 = new OrList(200, "statement_1_1_1");
        statement_1_1_1.add(201, statement, statementStatementStatement);
        statement_1_1_1.add(202, str);
        statement_1_1_1.add(204, new Str(203, "}", NOT));
        statement_1_1.add(205, statement_1_1_1);
        statement_1.add(206, statement_1_1);
        statement.add(207, statement_1);
        statement.add(209, new Str(208, "}"));

        // isvalid = s public "boolean" ws "isValid()" s statement
        isvalid.add(210, s);
        isvalid.add(211, _public);
        isvalid.add(213, new Str(212, "boolean"));
        isvalid.add(214, ws);
        isvalid.add(216, new Str(215, "isValid()"));
        isvalid.add(217, s);
        isvalid.add(218, statement, isvalidIsvalidStatement);

        // uname = "A".."Z" [letter | digit]+
        uname.add(220, new Range(219, "uname", "A", "Z"));
        Optional uname_1 = new Optional(221, "uname_1");
        Repeat uname_1_1 = new Repeat(222, "uname_1_1");
        OrList uname_1_1_1 = new OrList(223, "uname_1_1_1");
        uname_1_1_1.add(224, letter);
        uname_1_1_1.add(225, digit);
        uname_1_1.add(226, uname_1_1_1);
        uname_1.add(227, uname_1_1);
        uname.add(228, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(230, new Str(229, "get"));
        getter.add(231, uname);
        getter.add(232, s);
        getter.add(234, new Str(233, "("));
        getter.add(235, s);
        getter.add(237, new Str(236, ")"));

        // classStatement = public "class" ws name:classname s ["extends" ws name s] "{" [s attribute | isvalid]+ s "}"
        classStatement.add(238, _public);
        classStatement.add(240, new Str(239, "class"));
        classStatement.add(241, ws);
        classStatement.add(242, name, classStatementClassStatementClassname);
        classStatement.add(243, s);
        Optional classStatement_1 = new Optional(244, "classStatement_1");
        classStatement_1.add(246, new Str(245, "extends"));
        classStatement_1.add(247, ws);
        classStatement_1.add(248, name);
        classStatement_1.add(249, s);
        classStatement.add(250, classStatement_1);
        classStatement.add(252, new Str(251, "{"));
        Optional classStatement_2 = new Optional(253, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(254, "classStatement_2_1");
        classStatement_2_1.add(255, s);
        OrList classStatement_2_1_1 = new OrList(256, "classStatement_2_1_1");
        classStatement_2_1_1.add(257, attribute, classStatementClassStatementAttribute);
        classStatement_2_1_1.add(258, isvalid, classStatementClassStatementIsvalid);
        classStatement_2_1.add(259, classStatement_2_1_1);
        classStatement_2.add(260, classStatement_2_1);
        classStatement.add(261, classStatement_2);
        classStatement.add(262, s);
        classStatement.add(264, new Str(263, "}"));

        // stateTemplate = s packagestatement s imports s classStatement s
        stateTemplate.add(265, s);
        stateTemplate.add(266, packagestatement);
        stateTemplate.add(267, s);
        stateTemplate.add(268, imports, stateTemplateStateTemplateImports);
        stateTemplate.add(269, s);
        stateTemplate.add(270, classStatement, stateTemplateStateTemplateClassStatement);
        stateTemplate.add(271, s);

        return new TopElement(data2, stateTemplate);
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
        ElementList type = new ElementList(16, "type");
        ElementList initialValue = new ElementList(17, "initialValue");
        ElementList attribute = new ElementList(18, "attribute");
        ElementList attributeComment = new ElementList(19, "attributeComment");
        ElementList statement = new ElementList(20, "statement");
        ElementList isvalid = new ElementList(21, "isvalid");
        ElementList uname = new ElementList(22, "uname");
        ElementList getter = new ElementList(23, "getter");
        ElementList classStatement = new ElementList(24, "classStatement");
        ElementList stateTemplate = new ElementList(25, "stateTemplate");

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

        // packagename = name ["." name]+
        packagename.add(107, name);
        Optional packagename_1 = new Optional(108, "packagename_1");
        Repeat packagename_1_1 = new Repeat(109, "packagename_1_1");
        packagename_1_1.add(111, new Str(110, "."));
        packagename_1_1.add(112, name);
        packagename_1.add(113, packagename_1_1);
        packagename.add(114, packagename_1);

        // fullclassname = packagename
        fullclassname.add(115, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";"
        importstatement.add(117, new Str(116, "import"));
        importstatement.add(118, ws);
        Optional importstatement_1 = new Optional(119, "importstatement_1");
        importstatement_1.add(121, new Str(120, "static"));
        importstatement_1.add(122, ws);
        importstatement.add(123, importstatement_1);
        importstatement.add(124, fullclassname);
        importstatement.add(125, s);
        importstatement.add(127, new Str(126, ";"));

        // imports = [s importstatement]+
        Repeat imports_1 = new Repeat(128, "imports_1");
        imports_1.add(129, s);
        imports_1.add(130, importstatement);
        imports.add(131, imports_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(132, name);
        Optional type_1 = new Optional(133, "type_1");
        type_1.add(134, s);
        type_1.add(136, new Str(135, "<"));
        type_1.add(137, s);
        type_1.add(138, type);
        type_1.add(139, s);
        type_1.add(141, new Str(140, ">"));
        type.add(142, type_1);
        Optional type_2 = new Optional(143, "type_2");
        type_2.add(144, s);
        type_2.add(146, new Str(145, ","));
        type_2.add(147, s);
        type_2.add(148, type);
        type.add(149, type_2);

        // initialValue = "=" s !";"+:value
        initialValue.add(151, new Str(150, "="));
        initialValue.add(152, s);
        Repeat initialValue_1 = new Repeat(153, "initialValue_1");
        initialValue_1.add(155, new Str(154, ";", NOT));
        initialValue.add(156, initialValue_1);

        // attribute = type ws name:variable s [initialValue s] ";" attributeComment|s
        attribute.add(157, type);
        attribute.add(158, ws);
        attribute.add(159, name);
        attribute.add(160, s);
        Optional attribute_1 = new Optional(161, "attribute_1");
        attribute_1.add(162, initialValue);
        attribute_1.add(163, s);
        attribute.add(164, attribute_1);
        attribute.add(166, new Str(165, ";"));
        OrList attribute_2 = new OrList(167, "attribute_2");
        attribute_2.add(168, attributeComment);
        attribute_2.add(169, s);
        attribute.add(170, attribute_2);

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

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(196, new Str(195, "{"));
        statement.add(197, s);
        Optional statement_1 = new Optional(198, "statement_1");
        Repeat statement_1_1 = new Repeat(199, "statement_1_1");
        OrList statement_1_1_1 = new OrList(200, "statement_1_1_1");
        statement_1_1_1.add(201, statement);
        statement_1_1_1.add(202, str);
        statement_1_1_1.add(204, new Str(203, "}", NOT));
        statement_1_1.add(205, statement_1_1_1);
        statement_1.add(206, statement_1_1);
        statement.add(207, statement_1);
        statement.add(209, new Str(208, "}"));

        // isvalid = s public "boolean" ws "isValid()" s statement
        isvalid.add(210, s);
        isvalid.add(211, _public);
        isvalid.add(213, new Str(212, "boolean"));
        isvalid.add(214, ws);
        isvalid.add(216, new Str(215, "isValid()"));
        isvalid.add(217, s);
        isvalid.add(218, statement);

        // uname = "A".."Z" [letter | digit]+
        uname.add(220, new Range(219, "uname", "A", "Z"));
        Optional uname_1 = new Optional(221, "uname_1");
        Repeat uname_1_1 = new Repeat(222, "uname_1_1");
        OrList uname_1_1_1 = new OrList(223, "uname_1_1_1");
        uname_1_1_1.add(224, letter);
        uname_1_1_1.add(225, digit);
        uname_1_1.add(226, uname_1_1_1);
        uname_1.add(227, uname_1_1);
        uname.add(228, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(230, new Str(229, "get"));
        getter.add(231, uname);
        getter.add(232, s);
        getter.add(234, new Str(233, "("));
        getter.add(235, s);
        getter.add(237, new Str(236, ")"));

        // classStatement = public "class" ws name:classname s ["extends" ws name s] "{" [s attribute | isvalid]+ s "}"
        classStatement.add(238, _public);
        classStatement.add(240, new Str(239, "class"));
        classStatement.add(241, ws);
        classStatement.add(242, name);
        classStatement.add(243, s);
        Optional classStatement_1 = new Optional(244, "classStatement_1");
        classStatement_1.add(246, new Str(245, "extends"));
        classStatement_1.add(247, ws);
        classStatement_1.add(248, name);
        classStatement_1.add(249, s);
        classStatement.add(250, classStatement_1);
        classStatement.add(252, new Str(251, "{"));
        Optional classStatement_2 = new Optional(253, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(254, "classStatement_2_1");
        classStatement_2_1.add(255, s);
        OrList classStatement_2_1_1 = new OrList(256, "classStatement_2_1_1");
        classStatement_2_1_1.add(257, attribute);
        classStatement_2_1_1.add(258, isvalid);
        classStatement_2_1.add(259, classStatement_2_1_1);
        classStatement_2.add(260, classStatement_2_1);
        classStatement.add(261, classStatement_2);
        classStatement.add(262, s);
        classStatement.add(264, new Str(263, "}"));

        // stateTemplate = s packagestatement s imports s classStatement s
        stateTemplate.add(265, s);
        stateTemplate.add(266, packagestatement);
        stateTemplate.add(267, s);
        stateTemplate.add(268, imports);
        stateTemplate.add(269, s);
        stateTemplate.add(270, classStatement);
        stateTemplate.add(271, s);

        return new TopElement(data1, stateTemplate);
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
            data.pushStateTemplate();
            boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
            data.popStateTemplate();
            return match;
        }
    }

    // *** IStateTemplateFactoryFactory
    public interface IStateTemplateFactoryFactory {
        public IStateTemplateFactory getFactory(int phase);
    }

    // *** IStateTemplateFactory ***
    public interface IStateTemplateFactory {
        StateTemplateParser.IStatement createStatement();
        StateTemplateParser.IIsValid createIsValid();
        StateTemplateParser.IImportstatement createImportstatement();
        StateTemplateParser.IImports createImports();
        StateTemplateParser.IAttribute createAttribute();
        StateTemplateParser.IClassStatement createClassStatement();
        StateTemplateParser.IStateTemplate createStateTemplate();
    }

    // *** Interfaces ***
    // Statement
    public interface IStatement {
        public void setInnerStatement(String innerStatement);
        public void setStatement(IStatement istatement);
    }

    // IsValid
    public interface IIsValid {
        public void setStatement(IStatement istatement);
    }

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
        public void setInitialValue(String value);
        public void setComment(String comment);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void addAttribute(IAttribute iattribute);
        public void setIsValid(IIsValid iisvalid);
    }

    // StateTemplate
    public interface IStateTemplate {
        public void setPackagename(String packagename);
        public void setImports(IImports iimports);
        public void setClassStatement(IClassStatement iclassStatement);
    }

    // *** Data ***
    public static final class Data {
        private StateTemplateParser.IStateTemplateFactory factory;
        private Stack<IStatement> statementStack = new Stack<IStatement>();
        private Stack<IIsValid> isvalidStack = new Stack<IIsValid>();
        private Stack<IImportstatement> importstatementStack = new Stack<IImportstatement>();
        private Stack<IImports> importsStack = new Stack<IImports>();
        private Stack<IAttribute> attributeStack = new Stack<IAttribute>();
        private Stack<IClassStatement> classStatementStack = new Stack<IClassStatement>();
        private Stack<IStateTemplate> stateTemplateStack = new Stack<IStateTemplate>();

        public Data(StateTemplateParser.IStateTemplateFactory factory) {
            this.factory = factory;
        }

        // Statement
        public void pushStatement() { statementStack.push(factory.createStatement()); }
        public StateTemplateParser.IStatement popStatement() { return (StateTemplateParser.IStatement)statementStack.pop(); }
        public StateTemplateParser.IStatement peekStatement() {
            if (statementStack.empty()) { return null; }
            return statementStack.peek();
        }

        // IsValid
        public void pushIsValid() { isvalidStack.push(factory.createIsValid()); }
        public StateTemplateParser.IIsValid popIsValid() { return (StateTemplateParser.IIsValid)isvalidStack.pop(); }
        public StateTemplateParser.IIsValid peekIsValid() {
            if (isvalidStack.empty()) { return null; }
            return isvalidStack.peek();
        }

        // Importstatement
        public void pushImportstatement() { importstatementStack.push(factory.createImportstatement()); }
        public StateTemplateParser.IImportstatement popImportstatement() { return (StateTemplateParser.IImportstatement)importstatementStack.pop(); }
        public StateTemplateParser.IImportstatement peekImportstatement() {
            if (importstatementStack.empty()) { return null; }
            return importstatementStack.peek();
        }

        // Imports
        public void pushImports() { importsStack.push(factory.createImports()); }
        public StateTemplateParser.IImports popImports() { return (StateTemplateParser.IImports)importsStack.pop(); }
        public StateTemplateParser.IImports peekImports() {
            if (importsStack.empty()) { return null; }
            return importsStack.peek();
        }

        // Attribute
        public void pushAttribute() { attributeStack.push(factory.createAttribute()); }
        public StateTemplateParser.IAttribute popAttribute() { return (StateTemplateParser.IAttribute)attributeStack.pop(); }
        public StateTemplateParser.IAttribute peekAttribute() {
            if (attributeStack.empty()) { return null; }
            return attributeStack.peek();
        }

        // ClassStatement
        public void pushClassStatement() { classStatementStack.push(factory.createClassStatement()); }
        public StateTemplateParser.IClassStatement popClassStatement() { return (StateTemplateParser.IClassStatement)classStatementStack.pop(); }
        public StateTemplateParser.IClassStatement peekClassStatement() {
            if (classStatementStack.empty()) { return null; }
            return classStatementStack.peek();
        }

        // StateTemplate
        public void pushStateTemplate() { stateTemplateStack.push(factory.createStateTemplate()); }
        public StateTemplateParser.IStateTemplate popStateTemplate() { return (StateTemplateParser.IStateTemplate)stateTemplateStack.pop(); }
        public StateTemplateParser.IStateTemplate peekStateTemplate() {
            if (stateTemplateStack.empty()) { return null; }
            return stateTemplateStack.peek();
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

        // StateTemplate stateTemplate.setPackagename(String packagestatement.packagename);
        public class StateTemplatePackagestatementPackagename implements Output {
            private String name;
            public StateTemplatePackagestatementPackagename(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekStateTemplate().setPackagename(source.get(bookmark));
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

        // attribute.setInitialValue(String initialValue.value);
        public class AttributeInitialValueValue implements Output {
            private String name;
            public AttributeInitialValueValue(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAttribute().setInitialValue(source.get(bookmark));
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

        // Statement statement.setInnerStatement(String innerStatement);
        public class StatementStatementInnerStatement implements Output {
            private String name;
            public StatementStatementInnerStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekStatement().setInnerStatement(source.get(bookmark));
            }
        }

        // statement.setStatement(Statement statement);
        public class StatementStatementStatement implements Output {
            private String name;
            public StatementStatementStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStatement(); }
            public void set(Source source, int bookmark) {
                IStatement statement = popStatement();
                peekStatement().setStatement(statement);
            }
        }

        // IsValid isvalid.setStatement(Statement statement);
        public class IsvalidIsvalidStatement implements Output {
            private String name;
            public IsvalidIsvalidStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStatement(); }
            public void set(Source source, int bookmark) {
                peekIsValid().setStatement(popStatement());
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

        // classStatement.setIsValid(IsValid isvalid);
        public class ClassStatementClassStatementIsvalid implements Output {
            private String name;
            public ClassStatementClassStatementIsvalid(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushIsValid(); }
            public void set(Source source, int bookmark) {
                peekClassStatement().setIsValid(popIsValid());
            }
        }

        // stateTemplate.setImports(Imports imports);
        public class StateTemplateStateTemplateImports implements Output {
            private String name;
            public StateTemplateStateTemplateImports(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushImports(); }
            public void set(Source source, int bookmark) {
                peekStateTemplate().setImports(popImports());
            }
        }

        // stateTemplate.setClassStatement(ClassStatement classStatement);
        public class StateTemplateStateTemplateClassStatement implements Output {
            private String name;
            public StateTemplateStateTemplateClassStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushClassStatement(); }
            public void set(Source source, int bookmark) {
                peekStateTemplate().setClassStatement(popClassStatement());
            }
        }
    }
}
