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
 * Auto generated 2013-01-04 by Laja:
 *    http://laja.sf.net
 *
 * Version: laja2-006
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
        Data.MethodMethodVariable methodMethodVariable = data2.new MethodMethodVariable("methodMethodVariable");
        Data.StateMethodStateMethodReturnclass stateMethodStateMethodReturnclass = data2.new StateMethodStateMethodReturnclass("stateMethodStateMethodReturnclass");
        Data.StateMethodStateMethodUname stateMethodStateMethodUname = data2.new StateMethodStateMethodUname("stateMethodStateMethodUname");
        Data.StateMethodStateMethodParameters stateMethodStateMethodParameters = data2.new StateMethodStateMethodParameters("stateMethodStateMethodParameters");
        Data.StateMethodStateMethodImplclass stateMethodStateMethodImplclass = data2.new StateMethodStateMethodImplclass("stateMethodStateMethodImplclass");
        Data.StateMethodStateMethodMethod stateMethodStateMethodMethod = data2.new StateMethodStateMethodMethod("stateMethodStateMethodMethod");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementAttribute classStatementClassStatementAttribute = data2.new ClassStatementClassStatementAttribute("classStatementClassStatementAttribute");
        Data.ClassStatementClassStatementIsvalid classStatementClassStatementIsvalid = data2.new ClassStatementClassStatementIsvalid("classStatementClassStatementIsvalid");
        Data.ClassStatementClassStatementStateMethod classStatementClassStatementStateMethod = data2.new ClassStatementClassStatementStateMethod("classStatementClassStatementStateMethod");
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
        ElementList parameters = new ElementList(24, "parameters");
        ElementList argument = new ElementList(25, "argument");
        ElementList method = new ElementList(26, "method");
        ElementList stateMethod = new ElementList(27, "stateMethod");
        ElementList classStatement = new ElementList(28, "classStatement");
        ElementList stateTemplate = new ElementList(29, "stateTemplate");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(31, new Str(30, "\r\n"));
        newline.add(33, new Str(32, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(34, "comment_1");
        comment_1.add(36, new Str(35, "/*"));
        Optional comment_1_1 = new Optional(37, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(38, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(39, "comment_1_1_1_1");
        comment_1_1_1_1.add(40, comment);
        comment_1_1_1_1.add(42, new Str(41, "*/", NOT));
        comment_1_1_1.add(43, comment_1_1_1_1);
        comment_1_1.add(44, comment_1_1_1);
        comment_1.add(45, comment_1_1);
        comment_1.add(47, new Str(46, "*/"));
        comment.add(48, comment_1);
        ElementList comment_2 = new ElementList(49, "comment_2");
        comment_2.add(51, new Str(50, "//"));
        Optional comment_2_1 = new Optional(52, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(53, "comment_2_1_1");
        comment_2_1_1.add(54, newline, NOT);
        comment_2_1.add(55, comment_2_1_1);
        comment_2.add(56, comment_2_1);
        OrList comment_2_2 = new OrList(57, "comment_2_2");
        comment_2_2.add(58, newline);
        comment_2_2.add(60, new End(59, "comment_2_2"));
        comment_2.add(61, comment_2_2);
        comment.add(62, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(63, "ws_1");
        ws_1.add(64, newline);
        ws_1.add(66, new Str(65, " "));
        ws_1.add(68, new Str(67, "\t"));
        ws_1.add(69, comment);
        ws.add(70, ws_1);

        // s = [ws]
        s.add(71, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(72, ff);
        Repeat str_1 = new Repeat(73, "str_1");
        OrList str_1_1 = new OrList(74, "str_1_1");
        str_1_1.add(76, new Str(75, "\\\""));
        OrList str_1_1_1 = new OrList(77, "str_1_1_1", NOT);
        str_1_1_1.add(78, ff);
        str_1_1_1.add(79, newline);
        str_1_1.add(80, str_1_1_1);
        str_1.add(81, str_1_1);
        str.add(82, str_1);
        str.add(83, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(85, new Range(84, "letter", "a", "z"));
        letter.add(87, new Range(86, "letter", "A", "Z"));
        letter.add(89, new Str(88, "_"));
        letter.add(91, new Str(90, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(92, letter);
        Optional name_1 = new Optional(93, "name_1");
        Repeat name_1_1 = new Repeat(94, "name_1_1");
        OrList name_1_1_1 = new OrList(95, "name_1_1_1");
        name_1_1_1.add(96, letter);
        name_1_1_1.add(97, digit);
        name_1_1.add(98, name_1_1_1);
        name_1.add(99, name_1_1);
        name.add(100, name_1);

        // public = ["public" ws]
        _public.add(102, new Str(101, "public"));
        _public.add(103, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(105, new Str(104, "package"));
        packagestatement.add(106, ws);
        packagestatement.add(107, packagename, stateTemplatePackagestatementPackagename);
        packagestatement.add(108, s);
        packagestatement.add(110, new Str(109, ";"));

        // packagename = name ["." name]+
        packagename.add(111, name);
        Optional packagename_1 = new Optional(112, "packagename_1");
        Repeat packagename_1_1 = new Repeat(113, "packagename_1_1");
        packagename_1_1.add(115, new Str(114, "."));
        packagename_1_1.add(116, name);
        packagename_1.add(117, packagename_1_1);
        packagename.add(118, packagename_1);

        // fullclassname = packagename
        fullclassname.add(119, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";"
        importstatement.add(121, new Str(120, "import"));
        importstatement.add(122, ws);
        Optional importstatement_1 = new Optional(123, "importstatement_1");
        importstatement_1.add(125, new Str(124, "static", importstatementImportstatementStatic));
        importstatement_1.add(126, ws);
        importstatement.add(127, importstatement_1);
        importstatement.add(128, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(129, s);
        importstatement.add(131, new Str(130, ";"));

        // imports = [s importstatement]+
        Repeat imports_1 = new Repeat(132, "imports_1");
        imports_1.add(133, s);
        imports_1.add(134, importstatement, importsImportsImportstatement);
        imports.add(135, imports_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(136, name);
        Optional type_1 = new Optional(137, "type_1");
        type_1.add(138, s);
        type_1.add(140, new Str(139, "<"));
        type_1.add(141, s);
        type_1.add(142, type);
        type_1.add(143, s);
        type_1.add(145, new Str(144, ">"));
        type.add(146, type_1);
        Optional type_2 = new Optional(147, "type_2");
        type_2.add(148, s);
        type_2.add(150, new Str(149, ","));
        type_2.add(151, s);
        type_2.add(152, type);
        type.add(153, type_2);

        // initialValue = "=" s !";"+:value
        initialValue.add(155, new Str(154, "="));
        initialValue.add(156, s);
        Repeat initialValue_1 = new Repeat(157, "initialValue_1", attributeInitialValueValue);
        initialValue_1.add(159, new Str(158, ";", NOT));
        initialValue.add(160, initialValue_1);

        // attribute = type ws name:variable s [initialValue s] ";" attributeComment|s
        attribute.add(161, type, attributeAttributeType);
        attribute.add(162, ws);
        attribute.add(163, name, attributeAttributeVariable);
        attribute.add(164, s);
        Optional attribute_1 = new Optional(165, "attribute_1");
        attribute_1.add(166, initialValue);
        attribute_1.add(167, s);
        attribute.add(168, attribute_1);
        attribute.add(170, new Str(169, ";"));
        OrList attribute_2 = new OrList(171, "attribute_2");
        attribute_2.add(172, attributeComment);
        attribute_2.add(173, s);
        attribute.add(174, attribute_2);

        // attributeComment = ([" " | "\t"]+ "//" [!newline+]):comment newline|END
        ElementList attributeComment_1 = new ElementList(175, "attributeComment_1", attributeAttributeCommentComment);
        Optional attributeComment_1_1 = new Optional(176, "attributeComment_1_1");
        Repeat attributeComment_1_1_1 = new Repeat(177, "attributeComment_1_1_1");
        OrList attributeComment_1_1_1_1 = new OrList(178, "attributeComment_1_1_1_1");
        attributeComment_1_1_1_1.add(180, new Str(179, " "));
        attributeComment_1_1_1_1.add(182, new Str(181, "\t"));
        attributeComment_1_1_1.add(183, attributeComment_1_1_1_1);
        attributeComment_1_1.add(184, attributeComment_1_1_1);
        attributeComment_1.add(185, attributeComment_1_1);
        attributeComment_1.add(187, new Str(186, "//"));
        Optional attributeComment_1_2 = new Optional(188, "attributeComment_1_2");
        Repeat attributeComment_1_2_1 = new Repeat(189, "attributeComment_1_2_1");
        attributeComment_1_2_1.add(190, newline, NOT);
        attributeComment_1_2.add(191, attributeComment_1_2_1);
        attributeComment_1.add(192, attributeComment_1_2);
        attributeComment.add(193, attributeComment_1);
        OrList attributeComment_2 = new OrList(194, "attributeComment_2");
        attributeComment_2.add(195, newline);
        attributeComment_2.add(197, new End(196, "attributeComment_2"));
        attributeComment.add(198, attributeComment_2);

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(200, new Str(199, "{"));
        statement.add(201, s);
        Optional statement_1 = new Optional(202, "statement_1", statementStatementInnerStatement);
        Repeat statement_1_1 = new Repeat(203, "statement_1_1");
        OrList statement_1_1_1 = new OrList(204, "statement_1_1_1");
        statement_1_1_1.add(205, statement, statementStatementStatement);
        statement_1_1_1.add(206, str);
        statement_1_1_1.add(208, new Str(207, "}", NOT));
        statement_1_1.add(209, statement_1_1_1);
        statement_1.add(210, statement_1_1);
        statement.add(211, statement_1);
        statement.add(213, new Str(212, "}"));

        // isvalid = s public "boolean" ws "isValid()" s statement
        isvalid.add(214, s);
        isvalid.add(215, _public);
        isvalid.add(217, new Str(216, "boolean"));
        isvalid.add(218, ws);
        isvalid.add(220, new Str(219, "isValid()"));
        isvalid.add(221, s);
        isvalid.add(222, statement, isvalidIsvalidStatement);

        // uname = "A".."Z" [letter | digit]+
        uname.add(224, new Range(223, "uname", "A", "Z"));
        Optional uname_1 = new Optional(225, "uname_1");
        Repeat uname_1_1 = new Repeat(226, "uname_1_1");
        OrList uname_1_1_1 = new OrList(227, "uname_1_1_1");
        uname_1_1_1.add(228, letter);
        uname_1_1_1.add(229, digit);
        uname_1_1.add(230, uname_1_1_1);
        uname_1.add(231, uname_1_1);
        uname.add(232, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(234, new Str(233, "get"));
        getter.add(235, uname);
        getter.add(236, s);
        getter.add(238, new Str(237, "("));
        getter.add(239, s);
        getter.add(241, new Str(240, ")"));

        // parameters = s [!")"+]
        parameters.add(242, s);
        Optional parameters_1 = new Optional(243, "parameters_1");
        Repeat parameters_1_1 = new Repeat(244, "parameters_1_1");
        parameters_1_1.add(246, new Str(245, ")", NOT));
        parameters_1.add(247, parameters_1_1);
        parameters.add(248, parameters_1);

        // argument = getter | name:variable [s "." s argument]
        OrList argument_1 = new OrList(249, "argument_1");
        argument_1.add(250, getter);
        argument_1.add(251, name);
        argument.add(252, argument_1);
        Optional argument_2 = new Optional(253, "argument_2");
        argument_2.add(254, s);
        argument_2.add(256, new Str(255, "."));
        argument_2.add(257, s);
        argument_2.add(258, argument);
        argument.add(259, argument_2);

        // method = s "." s name:variable s "(" s argument s ")"
        method.add(260, s);
        method.add(262, new Str(261, "."));
        method.add(263, s);
        method.add(264, name, methodMethodVariable);
        method.add(265, s);
        method.add(267, new Str(266, "("));
        method.add(268, s);
        method.add(269, argument);
        method.add(270, s);
        method.add(272, new Str(271, ")"));

        // stateMethod = public name:returnclass ws "state" uname s "(" parameters ")" s "{" s  "return" ws name:implclass s method+ s ";" s "}"
        stateMethod.add(273, _public);
        stateMethod.add(274, name, stateMethodStateMethodReturnclass);
        stateMethod.add(275, ws);
        stateMethod.add(277, new Str(276, "state"));
        stateMethod.add(278, uname, stateMethodStateMethodUname);
        stateMethod.add(279, s);
        stateMethod.add(281, new Str(280, "("));
        stateMethod.add(282, parameters, stateMethodStateMethodParameters);
        stateMethod.add(284, new Str(283, ")"));
        stateMethod.add(285, s);
        stateMethod.add(287, new Str(286, "{"));
        stateMethod.add(288, s);
        stateMethod.add(290, new Str(289, "return"));
        stateMethod.add(291, ws);
        stateMethod.add(292, name, stateMethodStateMethodImplclass);
        stateMethod.add(293, s);
        Repeat stateMethod_1 = new Repeat(294, "stateMethod_1");
        stateMethod_1.add(295, method, stateMethodStateMethodMethod);
        stateMethod.add(296, stateMethod_1);
        stateMethod.add(297, s);
        stateMethod.add(299, new Str(298, ";"));
        stateMethod.add(300, s);
        stateMethod.add(302, new Str(301, "}"));

        // classStatement = public "class" ws name:classname s ["extends" ws name s] "{" [s attribute | isvalid | stateMethod]+ s "}"
        classStatement.add(303, _public);
        classStatement.add(305, new Str(304, "class"));
        classStatement.add(306, ws);
        classStatement.add(307, name, classStatementClassStatementClassname);
        classStatement.add(308, s);
        Optional classStatement_1 = new Optional(309, "classStatement_1");
        classStatement_1.add(311, new Str(310, "extends"));
        classStatement_1.add(312, ws);
        classStatement_1.add(313, name);
        classStatement_1.add(314, s);
        classStatement.add(315, classStatement_1);
        classStatement.add(317, new Str(316, "{"));
        Optional classStatement_2 = new Optional(318, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(319, "classStatement_2_1");
        classStatement_2_1.add(320, s);
        OrList classStatement_2_1_1 = new OrList(321, "classStatement_2_1_1");
        classStatement_2_1_1.add(322, attribute, classStatementClassStatementAttribute);
        classStatement_2_1_1.add(323, isvalid, classStatementClassStatementIsvalid);
        classStatement_2_1_1.add(324, stateMethod, classStatementClassStatementStateMethod);
        classStatement_2_1.add(325, classStatement_2_1_1);
        classStatement_2.add(326, classStatement_2_1);
        classStatement.add(327, classStatement_2);
        classStatement.add(328, s);
        classStatement.add(330, new Str(329, "}"));

        // stateTemplate = s packagestatement s imports s classStatement s
        stateTemplate.add(331, s);
        stateTemplate.add(332, packagestatement);
        stateTemplate.add(333, s);
        stateTemplate.add(334, imports, stateTemplateStateTemplateImports);
        stateTemplate.add(335, s);
        stateTemplate.add(336, classStatement, stateTemplateStateTemplateClassStatement);
        stateTemplate.add(337, s);

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
        ElementList parameters = new ElementList(24, "parameters");
        ElementList argument = new ElementList(25, "argument");
        ElementList method = new ElementList(26, "method");
        ElementList stateMethod = new ElementList(27, "stateMethod");
        ElementList classStatement = new ElementList(28, "classStatement");
        ElementList stateTemplate = new ElementList(29, "stateTemplate");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(31, new Str(30, "\r\n"));
        newline.add(33, new Str(32, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(34, "comment_1");
        comment_1.add(36, new Str(35, "/*"));
        Optional comment_1_1 = new Optional(37, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(38, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(39, "comment_1_1_1_1");
        comment_1_1_1_1.add(40, comment);
        comment_1_1_1_1.add(42, new Str(41, "*/", NOT));
        comment_1_1_1.add(43, comment_1_1_1_1);
        comment_1_1.add(44, comment_1_1_1);
        comment_1.add(45, comment_1_1);
        comment_1.add(47, new Str(46, "*/"));
        comment.add(48, comment_1);
        ElementList comment_2 = new ElementList(49, "comment_2");
        comment_2.add(51, new Str(50, "//"));
        Optional comment_2_1 = new Optional(52, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(53, "comment_2_1_1");
        comment_2_1_1.add(54, newline, NOT);
        comment_2_1.add(55, comment_2_1_1);
        comment_2.add(56, comment_2_1);
        OrList comment_2_2 = new OrList(57, "comment_2_2");
        comment_2_2.add(58, newline);
        comment_2_2.add(60, new End(59, "comment_2_2"));
        comment_2.add(61, comment_2_2);
        comment.add(62, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(63, "ws_1");
        ws_1.add(64, newline);
        ws_1.add(66, new Str(65, " "));
        ws_1.add(68, new Str(67, "\t"));
        ws_1.add(69, comment);
        ws.add(70, ws_1);

        // s = [ws]
        s.add(71, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(72, ff);
        Repeat str_1 = new Repeat(73, "str_1");
        OrList str_1_1 = new OrList(74, "str_1_1");
        str_1_1.add(76, new Str(75, "\\\""));
        OrList str_1_1_1 = new OrList(77, "str_1_1_1", NOT);
        str_1_1_1.add(78, ff);
        str_1_1_1.add(79, newline);
        str_1_1.add(80, str_1_1_1);
        str_1.add(81, str_1_1);
        str.add(82, str_1);
        str.add(83, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(85, new Range(84, "letter", "a", "z"));
        letter.add(87, new Range(86, "letter", "A", "Z"));
        letter.add(89, new Str(88, "_"));
        letter.add(91, new Str(90, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(92, letter);
        Optional name_1 = new Optional(93, "name_1");
        Repeat name_1_1 = new Repeat(94, "name_1_1");
        OrList name_1_1_1 = new OrList(95, "name_1_1_1");
        name_1_1_1.add(96, letter);
        name_1_1_1.add(97, digit);
        name_1_1.add(98, name_1_1_1);
        name_1.add(99, name_1_1);
        name.add(100, name_1);

        // public = ["public" ws]
        _public.add(102, new Str(101, "public"));
        _public.add(103, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(105, new Str(104, "package"));
        packagestatement.add(106, ws);
        packagestatement.add(107, packagename);
        packagestatement.add(108, s);
        packagestatement.add(110, new Str(109, ";"));

        // packagename = name ["." name]+
        packagename.add(111, name);
        Optional packagename_1 = new Optional(112, "packagename_1");
        Repeat packagename_1_1 = new Repeat(113, "packagename_1_1");
        packagename_1_1.add(115, new Str(114, "."));
        packagename_1_1.add(116, name);
        packagename_1.add(117, packagename_1_1);
        packagename.add(118, packagename_1);

        // fullclassname = packagename
        fullclassname.add(119, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";"
        importstatement.add(121, new Str(120, "import"));
        importstatement.add(122, ws);
        Optional importstatement_1 = new Optional(123, "importstatement_1");
        importstatement_1.add(125, new Str(124, "static"));
        importstatement_1.add(126, ws);
        importstatement.add(127, importstatement_1);
        importstatement.add(128, fullclassname);
        importstatement.add(129, s);
        importstatement.add(131, new Str(130, ";"));

        // imports = [s importstatement]+
        Repeat imports_1 = new Repeat(132, "imports_1");
        imports_1.add(133, s);
        imports_1.add(134, importstatement);
        imports.add(135, imports_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(136, name);
        Optional type_1 = new Optional(137, "type_1");
        type_1.add(138, s);
        type_1.add(140, new Str(139, "<"));
        type_1.add(141, s);
        type_1.add(142, type);
        type_1.add(143, s);
        type_1.add(145, new Str(144, ">"));
        type.add(146, type_1);
        Optional type_2 = new Optional(147, "type_2");
        type_2.add(148, s);
        type_2.add(150, new Str(149, ","));
        type_2.add(151, s);
        type_2.add(152, type);
        type.add(153, type_2);

        // initialValue = "=" s !";"+:value
        initialValue.add(155, new Str(154, "="));
        initialValue.add(156, s);
        Repeat initialValue_1 = new Repeat(157, "initialValue_1");
        initialValue_1.add(159, new Str(158, ";", NOT));
        initialValue.add(160, initialValue_1);

        // attribute = type ws name:variable s [initialValue s] ";" attributeComment|s
        attribute.add(161, type);
        attribute.add(162, ws);
        attribute.add(163, name);
        attribute.add(164, s);
        Optional attribute_1 = new Optional(165, "attribute_1");
        attribute_1.add(166, initialValue);
        attribute_1.add(167, s);
        attribute.add(168, attribute_1);
        attribute.add(170, new Str(169, ";"));
        OrList attribute_2 = new OrList(171, "attribute_2");
        attribute_2.add(172, attributeComment);
        attribute_2.add(173, s);
        attribute.add(174, attribute_2);

        // attributeComment = ([" " | "\t"]+ "//" [!newline+]):comment newline|END
        ElementList attributeComment_1 = new ElementList(175, "attributeComment_1");
        Optional attributeComment_1_1 = new Optional(176, "attributeComment_1_1");
        Repeat attributeComment_1_1_1 = new Repeat(177, "attributeComment_1_1_1");
        OrList attributeComment_1_1_1_1 = new OrList(178, "attributeComment_1_1_1_1");
        attributeComment_1_1_1_1.add(180, new Str(179, " "));
        attributeComment_1_1_1_1.add(182, new Str(181, "\t"));
        attributeComment_1_1_1.add(183, attributeComment_1_1_1_1);
        attributeComment_1_1.add(184, attributeComment_1_1_1);
        attributeComment_1.add(185, attributeComment_1_1);
        attributeComment_1.add(187, new Str(186, "//"));
        Optional attributeComment_1_2 = new Optional(188, "attributeComment_1_2");
        Repeat attributeComment_1_2_1 = new Repeat(189, "attributeComment_1_2_1");
        attributeComment_1_2_1.add(190, newline, NOT);
        attributeComment_1_2.add(191, attributeComment_1_2_1);
        attributeComment_1.add(192, attributeComment_1_2);
        attributeComment.add(193, attributeComment_1);
        OrList attributeComment_2 = new OrList(194, "attributeComment_2");
        attributeComment_2.add(195, newline);
        attributeComment_2.add(197, new End(196, "attributeComment_2"));
        attributeComment.add(198, attributeComment_2);

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(200, new Str(199, "{"));
        statement.add(201, s);
        Optional statement_1 = new Optional(202, "statement_1");
        Repeat statement_1_1 = new Repeat(203, "statement_1_1");
        OrList statement_1_1_1 = new OrList(204, "statement_1_1_1");
        statement_1_1_1.add(205, statement);
        statement_1_1_1.add(206, str);
        statement_1_1_1.add(208, new Str(207, "}", NOT));
        statement_1_1.add(209, statement_1_1_1);
        statement_1.add(210, statement_1_1);
        statement.add(211, statement_1);
        statement.add(213, new Str(212, "}"));

        // isvalid = s public "boolean" ws "isValid()" s statement
        isvalid.add(214, s);
        isvalid.add(215, _public);
        isvalid.add(217, new Str(216, "boolean"));
        isvalid.add(218, ws);
        isvalid.add(220, new Str(219, "isValid()"));
        isvalid.add(221, s);
        isvalid.add(222, statement);

        // uname = "A".."Z" [letter | digit]+
        uname.add(224, new Range(223, "uname", "A", "Z"));
        Optional uname_1 = new Optional(225, "uname_1");
        Repeat uname_1_1 = new Repeat(226, "uname_1_1");
        OrList uname_1_1_1 = new OrList(227, "uname_1_1_1");
        uname_1_1_1.add(228, letter);
        uname_1_1_1.add(229, digit);
        uname_1_1.add(230, uname_1_1_1);
        uname_1.add(231, uname_1_1);
        uname.add(232, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(234, new Str(233, "get"));
        getter.add(235, uname);
        getter.add(236, s);
        getter.add(238, new Str(237, "("));
        getter.add(239, s);
        getter.add(241, new Str(240, ")"));

        // parameters = s [!")"+]
        parameters.add(242, s);
        Optional parameters_1 = new Optional(243, "parameters_1");
        Repeat parameters_1_1 = new Repeat(244, "parameters_1_1");
        parameters_1_1.add(246, new Str(245, ")", NOT));
        parameters_1.add(247, parameters_1_1);
        parameters.add(248, parameters_1);

        // argument = getter | name:variable [s "." s argument]
        OrList argument_1 = new OrList(249, "argument_1");
        argument_1.add(250, getter);
        argument_1.add(251, name);
        argument.add(252, argument_1);
        Optional argument_2 = new Optional(253, "argument_2");
        argument_2.add(254, s);
        argument_2.add(256, new Str(255, "."));
        argument_2.add(257, s);
        argument_2.add(258, argument);
        argument.add(259, argument_2);

        // method = s "." s name:variable s "(" s argument s ")"
        method.add(260, s);
        method.add(262, new Str(261, "."));
        method.add(263, s);
        method.add(264, name);
        method.add(265, s);
        method.add(267, new Str(266, "("));
        method.add(268, s);
        method.add(269, argument);
        method.add(270, s);
        method.add(272, new Str(271, ")"));

        // stateMethod = public name:returnclass ws "state" uname s "(" parameters ")" s "{" s  "return" ws name:implclass s method+ s ";" s "}"
        stateMethod.add(273, _public);
        stateMethod.add(274, name);
        stateMethod.add(275, ws);
        stateMethod.add(277, new Str(276, "state"));
        stateMethod.add(278, uname);
        stateMethod.add(279, s);
        stateMethod.add(281, new Str(280, "("));
        stateMethod.add(282, parameters);
        stateMethod.add(284, new Str(283, ")"));
        stateMethod.add(285, s);
        stateMethod.add(287, new Str(286, "{"));
        stateMethod.add(288, s);
        stateMethod.add(290, new Str(289, "return"));
        stateMethod.add(291, ws);
        stateMethod.add(292, name);
        stateMethod.add(293, s);
        Repeat stateMethod_1 = new Repeat(294, "stateMethod_1");
        stateMethod_1.add(295, method);
        stateMethod.add(296, stateMethod_1);
        stateMethod.add(297, s);
        stateMethod.add(299, new Str(298, ";"));
        stateMethod.add(300, s);
        stateMethod.add(302, new Str(301, "}"));

        // classStatement = public "class" ws name:classname s ["extends" ws name s] "{" [s attribute | isvalid | stateMethod]+ s "}"
        classStatement.add(303, _public);
        classStatement.add(305, new Str(304, "class"));
        classStatement.add(306, ws);
        classStatement.add(307, name);
        classStatement.add(308, s);
        Optional classStatement_1 = new Optional(309, "classStatement_1");
        classStatement_1.add(311, new Str(310, "extends"));
        classStatement_1.add(312, ws);
        classStatement_1.add(313, name);
        classStatement_1.add(314, s);
        classStatement.add(315, classStatement_1);
        classStatement.add(317, new Str(316, "{"));
        Optional classStatement_2 = new Optional(318, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(319, "classStatement_2_1");
        classStatement_2_1.add(320, s);
        OrList classStatement_2_1_1 = new OrList(321, "classStatement_2_1_1");
        classStatement_2_1_1.add(322, attribute);
        classStatement_2_1_1.add(323, isvalid);
        classStatement_2_1_1.add(324, stateMethod);
        classStatement_2_1.add(325, classStatement_2_1_1);
        classStatement_2.add(326, classStatement_2_1);
        classStatement.add(327, classStatement_2);
        classStatement.add(328, s);
        classStatement.add(330, new Str(329, "}"));

        // stateTemplate = s packagestatement s imports s classStatement s
        stateTemplate.add(331, s);
        stateTemplate.add(332, packagestatement);
        stateTemplate.add(333, s);
        stateTemplate.add(334, imports);
        stateTemplate.add(335, s);
        stateTemplate.add(336, classStatement);
        stateTemplate.add(337, s);

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
        StateTemplateParser.IMethod createMethod();
        StateTemplateParser.IStateMethod createStateMethod();
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

    // Method
    public interface IMethod {
        public void setVariable(String variable);
    }

    // StateMethod
    public interface IStateMethod {
        public void setReturnclass(String returnclass);
        public void setUname(String uname);
        public void setParameters(String parameters);
        public void setImplClass(String implclass);
        public void addMethod(IMethod imethod, String statement);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void addAttribute(IAttribute iattribute);
        public void setIsValid(IIsValid iisvalid);
        public void addStateMethod(IStateMethod istateMethod);
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
        private Stack<IMethod> methodStack = new Stack<IMethod>();
        private Stack<IStateMethod> stateMethodStack = new Stack<IStateMethod>();
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

        // Method
        public void pushMethod() { methodStack.push(factory.createMethod()); }
        public StateTemplateParser.IMethod popMethod() { return (StateTemplateParser.IMethod)methodStack.pop(); }
        public StateTemplateParser.IMethod peekMethod() {
            if (methodStack.empty()) { return null; }
            return methodStack.peek();
        }

        // StateMethod
        public void pushStateMethod() { stateMethodStack.push(factory.createStateMethod()); }
        public StateTemplateParser.IStateMethod popStateMethod() { return (StateTemplateParser.IStateMethod)stateMethodStack.pop(); }
        public StateTemplateParser.IStateMethod peekStateMethod() {
            if (stateMethodStack.empty()) { return null; }
            return stateMethodStack.peek();
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

        // Method method.setVariable(String variable);
        public class MethodMethodVariable implements Output {
            private String name;
            public MethodMethodVariable(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekMethod().setVariable(source.get(bookmark));
            }
        }

        // StateMethod stateMethod.setReturnclass(String returnclass);
        public class StateMethodStateMethodReturnclass implements Output {
            private String name;
            public StateMethodStateMethodReturnclass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekStateMethod().setReturnclass(source.get(bookmark));
            }
        }

        // stateMethod.setUname(String uname);
        public class StateMethodStateMethodUname implements Output {
            private String name;
            public StateMethodStateMethodUname(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekStateMethod().setUname(source.get(bookmark));
            }
        }

        // stateMethod.setParameters(String parameters);
        public class StateMethodStateMethodParameters implements Output {
            private String name;
            public StateMethodStateMethodParameters(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekStateMethod().setParameters(source.get(bookmark));
            }
        }

        // stateMethod.setImplClass(String implclass);
        public class StateMethodStateMethodImplclass implements Output {
            private String name;
            public StateMethodStateMethodImplclass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekStateMethod().setImplClass(source.get(bookmark));
            }
        }

        // stateMethod.addMethod(Method method, String statement);
        public class StateMethodStateMethodMethod implements Output {
            private String name;
            public StateMethodStateMethodMethod(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMethod(); }
            public void set(Source source, int bookmark) {
                peekStateMethod().addMethod(popMethod(), source.get(bookmark));
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

        // classStatement.addStateMethod(StateMethod stateMethod);
        public class ClassStatementClassStatementStateMethod implements Output {
            private String name;
            public ClassStatementClassStatementStateMethod(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStateMethod(); }
            public void set(Source source, int bookmark) {
                peekClassStatement().addStateMethod(popStateMethod());
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
