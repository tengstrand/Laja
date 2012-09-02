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
 * Auto generated 2012-07-03 by Laja:
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
        Data.ConvertMethodConvertMethodType convertMethodConvertMethodType = data2.new ConvertMethodConvertMethodType("convertMethodConvertMethodType");
        Data.ConvertMethodConvertMethodVariable convertMethodConvertMethodVariable = data2.new ConvertMethodConvertMethodVariable("convertMethodConvertMethodVariable");
        Data.ConvertMethodConvertMethodStatement convertMethodConvertMethodStatement = data2.new ConvertMethodConvertMethodStatement("convertMethodConvertMethodStatement");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementAttribute classStatementClassStatementAttribute = data2.new ClassStatementClassStatementAttribute("classStatementClassStatementAttribute");
        Data.ClassStatementClassStatementIsvalid classStatementClassStatementIsvalid = data2.new ClassStatementClassStatementIsvalid("classStatementClassStatementIsvalid");
        Data.ClassStatementClassStatementConvertMethod classStatementClassStatementConvertMethod = data2.new ClassStatementClassStatementConvertMethod("classStatementClassStatementConvertMethod");
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
        ElementList convertMethod = new ElementList(28, "convertMethod");
        ElementList classStatement = new ElementList(29, "classStatement");
        ElementList stateTemplate = new ElementList(30, "stateTemplate");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(32, new Str(31, "\r\n"));
        newline.add(34, new Str(33, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(35, "comment_1");
        comment_1.add(37, new Str(36, "/*"));
        Optional comment_1_1 = new Optional(38, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(39, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(40, "comment_1_1_1_1");
        comment_1_1_1_1.add(41, comment);
        comment_1_1_1_1.add(43, new Str(42, "*/", NOT));
        comment_1_1_1.add(44, comment_1_1_1_1);
        comment_1_1.add(45, comment_1_1_1);
        comment_1.add(46, comment_1_1);
        comment_1.add(48, new Str(47, "*/"));
        comment.add(49, comment_1);
        ElementList comment_2 = new ElementList(50, "comment_2");
        comment_2.add(52, new Str(51, "//"));
        Optional comment_2_1 = new Optional(53, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(54, "comment_2_1_1");
        comment_2_1_1.add(55, newline, NOT);
        comment_2_1.add(56, comment_2_1_1);
        comment_2.add(57, comment_2_1);
        OrList comment_2_2 = new OrList(58, "comment_2_2");
        comment_2_2.add(59, newline);
        comment_2_2.add(61, new End(60, "comment_2_2"));
        comment_2.add(62, comment_2_2);
        comment.add(63, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(64, "ws_1");
        ws_1.add(65, newline);
        ws_1.add(67, new Str(66, " "));
        ws_1.add(69, new Str(68, "\t"));
        ws_1.add(70, comment);
        ws.add(71, ws_1);

        // s = [ws]
        s.add(72, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(73, ff);
        Repeat str_1 = new Repeat(74, "str_1");
        OrList str_1_1 = new OrList(75, "str_1_1");
        str_1_1.add(77, new Str(76, "\\\""));
        OrList str_1_1_1 = new OrList(78, "str_1_1_1", NOT);
        str_1_1_1.add(79, ff);
        str_1_1_1.add(80, newline);
        str_1_1.add(81, str_1_1_1);
        str_1.add(82, str_1_1);
        str.add(83, str_1);
        str.add(84, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(86, new Range(85, "letter", "a", "z"));
        letter.add(88, new Range(87, "letter", "A", "Z"));
        letter.add(90, new Str(89, "_"));
        letter.add(92, new Str(91, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(93, letter);
        Optional name_1 = new Optional(94, "name_1");
        Repeat name_1_1 = new Repeat(95, "name_1_1");
        OrList name_1_1_1 = new OrList(96, "name_1_1_1");
        name_1_1_1.add(97, letter);
        name_1_1_1.add(98, digit);
        name_1_1.add(99, name_1_1_1);
        name_1.add(100, name_1_1);
        name.add(101, name_1);

        // public = ["public" ws]
        _public.add(103, new Str(102, "public"));
        _public.add(104, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(106, new Str(105, "package"));
        packagestatement.add(107, ws);
        packagestatement.add(108, packagename, stateTemplatePackagestatementPackagename);
        packagestatement.add(109, s);
        packagestatement.add(111, new Str(110, ";"));

        // packagename = name ["." name]+
        packagename.add(112, name);
        Optional packagename_1 = new Optional(113, "packagename_1");
        Repeat packagename_1_1 = new Repeat(114, "packagename_1_1");
        packagename_1_1.add(116, new Str(115, "."));
        packagename_1_1.add(117, name);
        packagename_1.add(118, packagename_1_1);
        packagename.add(119, packagename_1);

        // fullclassname = packagename
        fullclassname.add(120, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";"
        importstatement.add(122, new Str(121, "import"));
        importstatement.add(123, ws);
        Optional importstatement_1 = new Optional(124, "importstatement_1");
        importstatement_1.add(126, new Str(125, "static", importstatementImportstatementStatic));
        importstatement_1.add(127, ws);
        importstatement.add(128, importstatement_1);
        importstatement.add(129, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(130, s);
        importstatement.add(132, new Str(131, ";"));

        // imports = [s importstatement]+
        Repeat imports_1 = new Repeat(133, "imports_1");
        imports_1.add(134, s);
        imports_1.add(135, importstatement, importsImportsImportstatement);
        imports.add(136, imports_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(137, name);
        Optional type_1 = new Optional(138, "type_1");
        type_1.add(139, s);
        type_1.add(141, new Str(140, "<"));
        type_1.add(142, s);
        type_1.add(143, type);
        type_1.add(144, s);
        type_1.add(146, new Str(145, ">"));
        type.add(147, type_1);
        Optional type_2 = new Optional(148, "type_2");
        type_2.add(149, s);
        type_2.add(151, new Str(150, ","));
        type_2.add(152, s);
        type_2.add(153, type);
        type.add(154, type_2);

        // initialValue = "=" s !";"+:value
        initialValue.add(156, new Str(155, "="));
        initialValue.add(157, s);
        Repeat initialValue_1 = new Repeat(158, "initialValue_1", attributeInitialValueValue);
        initialValue_1.add(160, new Str(159, ";", NOT));
        initialValue.add(161, initialValue_1);

        // attribute = type ws name:variable s [initialValue s] ";" attributeComment|s
        attribute.add(162, type, attributeAttributeType);
        attribute.add(163, ws);
        attribute.add(164, name, attributeAttributeVariable);
        attribute.add(165, s);
        Optional attribute_1 = new Optional(166, "attribute_1");
        attribute_1.add(167, initialValue);
        attribute_1.add(168, s);
        attribute.add(169, attribute_1);
        attribute.add(171, new Str(170, ";"));
        OrList attribute_2 = new OrList(172, "attribute_2");
        attribute_2.add(173, attributeComment);
        attribute_2.add(174, s);
        attribute.add(175, attribute_2);

        // attributeComment = ([" " | "\t"]+ "//" [!newline+]):comment newline|END
        ElementList attributeComment_1 = new ElementList(176, "attributeComment_1", attributeAttributeCommentComment);
        Optional attributeComment_1_1 = new Optional(177, "attributeComment_1_1");
        Repeat attributeComment_1_1_1 = new Repeat(178, "attributeComment_1_1_1");
        OrList attributeComment_1_1_1_1 = new OrList(179, "attributeComment_1_1_1_1");
        attributeComment_1_1_1_1.add(181, new Str(180, " "));
        attributeComment_1_1_1_1.add(183, new Str(182, "\t"));
        attributeComment_1_1_1.add(184, attributeComment_1_1_1_1);
        attributeComment_1_1.add(185, attributeComment_1_1_1);
        attributeComment_1.add(186, attributeComment_1_1);
        attributeComment_1.add(188, new Str(187, "//"));
        Optional attributeComment_1_2 = new Optional(189, "attributeComment_1_2");
        Repeat attributeComment_1_2_1 = new Repeat(190, "attributeComment_1_2_1");
        attributeComment_1_2_1.add(191, newline, NOT);
        attributeComment_1_2.add(192, attributeComment_1_2_1);
        attributeComment_1.add(193, attributeComment_1_2);
        attributeComment.add(194, attributeComment_1);
        OrList attributeComment_2 = new OrList(195, "attributeComment_2");
        attributeComment_2.add(196, newline);
        attributeComment_2.add(198, new End(197, "attributeComment_2"));
        attributeComment.add(199, attributeComment_2);

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(201, new Str(200, "{"));
        statement.add(202, s);
        Optional statement_1 = new Optional(203, "statement_1", statementStatementInnerStatement);
        Repeat statement_1_1 = new Repeat(204, "statement_1_1");
        OrList statement_1_1_1 = new OrList(205, "statement_1_1_1");
        statement_1_1_1.add(206, statement, statementStatementStatement);
        statement_1_1_1.add(207, str);
        statement_1_1_1.add(209, new Str(208, "}", NOT));
        statement_1_1.add(210, statement_1_1_1);
        statement_1.add(211, statement_1_1);
        statement.add(212, statement_1);
        statement.add(214, new Str(213, "}"));

        // isvalid = s public "boolean" ws "isValid()" s statement
        isvalid.add(215, s);
        isvalid.add(216, _public);
        isvalid.add(218, new Str(217, "boolean"));
        isvalid.add(219, ws);
        isvalid.add(221, new Str(220, "isValid()"));
        isvalid.add(222, s);
        isvalid.add(223, statement, isvalidIsvalidStatement);

        // uname = "A".."Z" [letter | digit]+
        uname.add(225, new Range(224, "uname", "A", "Z"));
        Optional uname_1 = new Optional(226, "uname_1");
        Repeat uname_1_1 = new Repeat(227, "uname_1_1");
        OrList uname_1_1_1 = new OrList(228, "uname_1_1_1");
        uname_1_1_1.add(229, letter);
        uname_1_1_1.add(230, digit);
        uname_1_1.add(231, uname_1_1_1);
        uname_1.add(232, uname_1_1);
        uname.add(233, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(235, new Str(234, "get"));
        getter.add(236, uname);
        getter.add(237, s);
        getter.add(239, new Str(238, "("));
        getter.add(240, s);
        getter.add(242, new Str(241, ")"));

        // parameters = s [!")"+]
        parameters.add(243, s);
        Optional parameters_1 = new Optional(244, "parameters_1");
        Repeat parameters_1_1 = new Repeat(245, "parameters_1_1");
        parameters_1_1.add(247, new Str(246, ")", NOT));
        parameters_1.add(248, parameters_1_1);
        parameters.add(249, parameters_1);

        // argument = getter | name:variable [s "." s argument]
        OrList argument_1 = new OrList(250, "argument_1");
        argument_1.add(251, getter);
        argument_1.add(252, name);
        argument.add(253, argument_1);
        Optional argument_2 = new Optional(254, "argument_2");
        argument_2.add(255, s);
        argument_2.add(257, new Str(256, "."));
        argument_2.add(258, s);
        argument_2.add(259, argument);
        argument.add(260, argument_2);

        // method = s "." s name:variable s "(" s argument s ")"
        method.add(261, s);
        method.add(263, new Str(262, "."));
        method.add(264, s);
        method.add(265, name, methodMethodVariable);
        method.add(266, s);
        method.add(268, new Str(267, "("));
        method.add(269, s);
        method.add(270, argument);
        method.add(271, s);
        method.add(273, new Str(272, ")"));

        // stateMethod = public name:returnclass ws "state" uname s "(" parameters ")" s "{" s  "return" ws name:implclass s method+ s ";" s "}"
        stateMethod.add(274, _public);
        stateMethod.add(275, name, stateMethodStateMethodReturnclass);
        stateMethod.add(276, ws);
        stateMethod.add(278, new Str(277, "state"));
        stateMethod.add(279, uname, stateMethodStateMethodUname);
        stateMethod.add(280, s);
        stateMethod.add(282, new Str(281, "("));
        stateMethod.add(283, parameters, stateMethodStateMethodParameters);
        stateMethod.add(285, new Str(284, ")"));
        stateMethod.add(286, s);
        stateMethod.add(288, new Str(287, "{"));
        stateMethod.add(289, s);
        stateMethod.add(291, new Str(290, "return"));
        stateMethod.add(292, ws);
        stateMethod.add(293, name, stateMethodStateMethodImplclass);
        stateMethod.add(294, s);
        Repeat stateMethod_1 = new Repeat(295, "stateMethod_1");
        stateMethod_1.add(296, method, stateMethodStateMethodMethod);
        stateMethod.add(297, stateMethod_1);
        stateMethod.add(298, s);
        stateMethod.add(300, new Str(299, ";"));
        stateMethod.add(301, s);
        stateMethod.add(303, new Str(302, "}"));

        // convertMethod = public name ws "convert" [uname] s "(" s name:type ws name:variable s ")" s "{" s "return" ws !";"+:statement ";" s "}"
        convertMethod.add(304, _public);
        convertMethod.add(305, name);
        convertMethod.add(306, ws);
        convertMethod.add(308, new Str(307, "convert"));
        Optional convertMethod_1 = new Optional(309, "convertMethod_1");
        convertMethod_1.add(310, uname);
        convertMethod.add(311, convertMethod_1);
        convertMethod.add(312, s);
        convertMethod.add(314, new Str(313, "("));
        convertMethod.add(315, s);
        convertMethod.add(316, name, convertMethodConvertMethodType);
        convertMethod.add(317, ws);
        convertMethod.add(318, name, convertMethodConvertMethodVariable);
        convertMethod.add(319, s);
        convertMethod.add(321, new Str(320, ")"));
        convertMethod.add(322, s);
        convertMethod.add(324, new Str(323, "{"));
        convertMethod.add(325, s);
        convertMethod.add(327, new Str(326, "return"));
        convertMethod.add(328, ws);
        Repeat convertMethod_2 = new Repeat(329, "convertMethod_2", convertMethodConvertMethodStatement);
        convertMethod_2.add(331, new Str(330, ";", NOT));
        convertMethod.add(332, convertMethod_2);
        convertMethod.add(334, new Str(333, ";"));
        convertMethod.add(335, s);
        convertMethod.add(337, new Str(336, "}"));

        // classStatement = public "class" ws name:classname s ["extends" ws name s] "{" [s attribute | isvalid | convertMethod | stateMethod]+ s "}"
        classStatement.add(338, _public);
        classStatement.add(340, new Str(339, "class"));
        classStatement.add(341, ws);
        classStatement.add(342, name, classStatementClassStatementClassname);
        classStatement.add(343, s);
        Optional classStatement_1 = new Optional(344, "classStatement_1");
        classStatement_1.add(346, new Str(345, "extends"));
        classStatement_1.add(347, ws);
        classStatement_1.add(348, name);
        classStatement_1.add(349, s);
        classStatement.add(350, classStatement_1);
        classStatement.add(352, new Str(351, "{"));
        Optional classStatement_2 = new Optional(353, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(354, "classStatement_2_1");
        classStatement_2_1.add(355, s);
        OrList classStatement_2_1_1 = new OrList(356, "classStatement_2_1_1");
        classStatement_2_1_1.add(357, attribute, classStatementClassStatementAttribute);
        classStatement_2_1_1.add(358, isvalid, classStatementClassStatementIsvalid);
        classStatement_2_1_1.add(359, convertMethod, classStatementClassStatementConvertMethod);
        classStatement_2_1_1.add(360, stateMethod, classStatementClassStatementStateMethod);
        classStatement_2_1.add(361, classStatement_2_1_1);
        classStatement_2.add(362, classStatement_2_1);
        classStatement.add(363, classStatement_2);
        classStatement.add(364, s);
        classStatement.add(366, new Str(365, "}"));

        // stateTemplate = s packagestatement s imports s classStatement s
        stateTemplate.add(367, s);
        stateTemplate.add(368, packagestatement);
        stateTemplate.add(369, s);
        stateTemplate.add(370, imports, stateTemplateStateTemplateImports);
        stateTemplate.add(371, s);
        stateTemplate.add(372, classStatement, stateTemplateStateTemplateClassStatement);
        stateTemplate.add(373, s);

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
        ElementList convertMethod = new ElementList(28, "convertMethod");
        ElementList classStatement = new ElementList(29, "classStatement");
        ElementList stateTemplate = new ElementList(30, "stateTemplate");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(32, new Str(31, "\r\n"));
        newline.add(34, new Str(33, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(35, "comment_1");
        comment_1.add(37, new Str(36, "/*"));
        Optional comment_1_1 = new Optional(38, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(39, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(40, "comment_1_1_1_1");
        comment_1_1_1_1.add(41, comment);
        comment_1_1_1_1.add(43, new Str(42, "*/", NOT));
        comment_1_1_1.add(44, comment_1_1_1_1);
        comment_1_1.add(45, comment_1_1_1);
        comment_1.add(46, comment_1_1);
        comment_1.add(48, new Str(47, "*/"));
        comment.add(49, comment_1);
        ElementList comment_2 = new ElementList(50, "comment_2");
        comment_2.add(52, new Str(51, "//"));
        Optional comment_2_1 = new Optional(53, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(54, "comment_2_1_1");
        comment_2_1_1.add(55, newline, NOT);
        comment_2_1.add(56, comment_2_1_1);
        comment_2.add(57, comment_2_1);
        OrList comment_2_2 = new OrList(58, "comment_2_2");
        comment_2_2.add(59, newline);
        comment_2_2.add(61, new End(60, "comment_2_2"));
        comment_2.add(62, comment_2_2);
        comment.add(63, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(64, "ws_1");
        ws_1.add(65, newline);
        ws_1.add(67, new Str(66, " "));
        ws_1.add(69, new Str(68, "\t"));
        ws_1.add(70, comment);
        ws.add(71, ws_1);

        // s = [ws]
        s.add(72, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(73, ff);
        Repeat str_1 = new Repeat(74, "str_1");
        OrList str_1_1 = new OrList(75, "str_1_1");
        str_1_1.add(77, new Str(76, "\\\""));
        OrList str_1_1_1 = new OrList(78, "str_1_1_1", NOT);
        str_1_1_1.add(79, ff);
        str_1_1_1.add(80, newline);
        str_1_1.add(81, str_1_1_1);
        str_1.add(82, str_1_1);
        str.add(83, str_1);
        str.add(84, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(86, new Range(85, "letter", "a", "z"));
        letter.add(88, new Range(87, "letter", "A", "Z"));
        letter.add(90, new Str(89, "_"));
        letter.add(92, new Str(91, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(93, letter);
        Optional name_1 = new Optional(94, "name_1");
        Repeat name_1_1 = new Repeat(95, "name_1_1");
        OrList name_1_1_1 = new OrList(96, "name_1_1_1");
        name_1_1_1.add(97, letter);
        name_1_1_1.add(98, digit);
        name_1_1.add(99, name_1_1_1);
        name_1.add(100, name_1_1);
        name.add(101, name_1);

        // public = ["public" ws]
        _public.add(103, new Str(102, "public"));
        _public.add(104, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(106, new Str(105, "package"));
        packagestatement.add(107, ws);
        packagestatement.add(108, packagename);
        packagestatement.add(109, s);
        packagestatement.add(111, new Str(110, ";"));

        // packagename = name ["." name]+
        packagename.add(112, name);
        Optional packagename_1 = new Optional(113, "packagename_1");
        Repeat packagename_1_1 = new Repeat(114, "packagename_1_1");
        packagename_1_1.add(116, new Str(115, "."));
        packagename_1_1.add(117, name);
        packagename_1.add(118, packagename_1_1);
        packagename.add(119, packagename_1);

        // fullclassname = packagename
        fullclassname.add(120, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";"
        importstatement.add(122, new Str(121, "import"));
        importstatement.add(123, ws);
        Optional importstatement_1 = new Optional(124, "importstatement_1");
        importstatement_1.add(126, new Str(125, "static"));
        importstatement_1.add(127, ws);
        importstatement.add(128, importstatement_1);
        importstatement.add(129, fullclassname);
        importstatement.add(130, s);
        importstatement.add(132, new Str(131, ";"));

        // imports = [s importstatement]+
        Repeat imports_1 = new Repeat(133, "imports_1");
        imports_1.add(134, s);
        imports_1.add(135, importstatement);
        imports.add(136, imports_1);

        // type = name [s "<" s type s ">"] [ s "," s type ]
        type.add(137, name);
        Optional type_1 = new Optional(138, "type_1");
        type_1.add(139, s);
        type_1.add(141, new Str(140, "<"));
        type_1.add(142, s);
        type_1.add(143, type);
        type_1.add(144, s);
        type_1.add(146, new Str(145, ">"));
        type.add(147, type_1);
        Optional type_2 = new Optional(148, "type_2");
        type_2.add(149, s);
        type_2.add(151, new Str(150, ","));
        type_2.add(152, s);
        type_2.add(153, type);
        type.add(154, type_2);

        // initialValue = "=" s !";"+:value
        initialValue.add(156, new Str(155, "="));
        initialValue.add(157, s);
        Repeat initialValue_1 = new Repeat(158, "initialValue_1");
        initialValue_1.add(160, new Str(159, ";", NOT));
        initialValue.add(161, initialValue_1);

        // attribute = type ws name:variable s [initialValue s] ";" attributeComment|s
        attribute.add(162, type);
        attribute.add(163, ws);
        attribute.add(164, name);
        attribute.add(165, s);
        Optional attribute_1 = new Optional(166, "attribute_1");
        attribute_1.add(167, initialValue);
        attribute_1.add(168, s);
        attribute.add(169, attribute_1);
        attribute.add(171, new Str(170, ";"));
        OrList attribute_2 = new OrList(172, "attribute_2");
        attribute_2.add(173, attributeComment);
        attribute_2.add(174, s);
        attribute.add(175, attribute_2);

        // attributeComment = ([" " | "\t"]+ "//" [!newline+]):comment newline|END
        ElementList attributeComment_1 = new ElementList(176, "attributeComment_1");
        Optional attributeComment_1_1 = new Optional(177, "attributeComment_1_1");
        Repeat attributeComment_1_1_1 = new Repeat(178, "attributeComment_1_1_1");
        OrList attributeComment_1_1_1_1 = new OrList(179, "attributeComment_1_1_1_1");
        attributeComment_1_1_1_1.add(181, new Str(180, " "));
        attributeComment_1_1_1_1.add(183, new Str(182, "\t"));
        attributeComment_1_1_1.add(184, attributeComment_1_1_1_1);
        attributeComment_1_1.add(185, attributeComment_1_1_1);
        attributeComment_1.add(186, attributeComment_1_1);
        attributeComment_1.add(188, new Str(187, "//"));
        Optional attributeComment_1_2 = new Optional(189, "attributeComment_1_2");
        Repeat attributeComment_1_2_1 = new Repeat(190, "attributeComment_1_2_1");
        attributeComment_1_2_1.add(191, newline, NOT);
        attributeComment_1_2.add(192, attributeComment_1_2_1);
        attributeComment_1.add(193, attributeComment_1_2);
        attributeComment.add(194, attributeComment_1);
        OrList attributeComment_2 = new OrList(195, "attributeComment_2");
        attributeComment_2.add(196, newline);
        attributeComment_2.add(198, new End(197, "attributeComment_2"));
        attributeComment.add(199, attributeComment_2);

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(201, new Str(200, "{"));
        statement.add(202, s);
        Optional statement_1 = new Optional(203, "statement_1");
        Repeat statement_1_1 = new Repeat(204, "statement_1_1");
        OrList statement_1_1_1 = new OrList(205, "statement_1_1_1");
        statement_1_1_1.add(206, statement);
        statement_1_1_1.add(207, str);
        statement_1_1_1.add(209, new Str(208, "}", NOT));
        statement_1_1.add(210, statement_1_1_1);
        statement_1.add(211, statement_1_1);
        statement.add(212, statement_1);
        statement.add(214, new Str(213, "}"));

        // isvalid = s public "boolean" ws "isValid()" s statement
        isvalid.add(215, s);
        isvalid.add(216, _public);
        isvalid.add(218, new Str(217, "boolean"));
        isvalid.add(219, ws);
        isvalid.add(221, new Str(220, "isValid()"));
        isvalid.add(222, s);
        isvalid.add(223, statement);

        // uname = "A".."Z" [letter | digit]+
        uname.add(225, new Range(224, "uname", "A", "Z"));
        Optional uname_1 = new Optional(226, "uname_1");
        Repeat uname_1_1 = new Repeat(227, "uname_1_1");
        OrList uname_1_1_1 = new OrList(228, "uname_1_1_1");
        uname_1_1_1.add(229, letter);
        uname_1_1_1.add(230, digit);
        uname_1_1.add(231, uname_1_1_1);
        uname_1.add(232, uname_1_1);
        uname.add(233, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(235, new Str(234, "get"));
        getter.add(236, uname);
        getter.add(237, s);
        getter.add(239, new Str(238, "("));
        getter.add(240, s);
        getter.add(242, new Str(241, ")"));

        // parameters = s [!")"+]
        parameters.add(243, s);
        Optional parameters_1 = new Optional(244, "parameters_1");
        Repeat parameters_1_1 = new Repeat(245, "parameters_1_1");
        parameters_1_1.add(247, new Str(246, ")", NOT));
        parameters_1.add(248, parameters_1_1);
        parameters.add(249, parameters_1);

        // argument = getter | name:variable [s "." s argument]
        OrList argument_1 = new OrList(250, "argument_1");
        argument_1.add(251, getter);
        argument_1.add(252, name);
        argument.add(253, argument_1);
        Optional argument_2 = new Optional(254, "argument_2");
        argument_2.add(255, s);
        argument_2.add(257, new Str(256, "."));
        argument_2.add(258, s);
        argument_2.add(259, argument);
        argument.add(260, argument_2);

        // method = s "." s name:variable s "(" s argument s ")"
        method.add(261, s);
        method.add(263, new Str(262, "."));
        method.add(264, s);
        method.add(265, name);
        method.add(266, s);
        method.add(268, new Str(267, "("));
        method.add(269, s);
        method.add(270, argument);
        method.add(271, s);
        method.add(273, new Str(272, ")"));

        // stateMethod = public name:returnclass ws "state" uname s "(" parameters ")" s "{" s  "return" ws name:implclass s method+ s ";" s "}"
        stateMethod.add(274, _public);
        stateMethod.add(275, name);
        stateMethod.add(276, ws);
        stateMethod.add(278, new Str(277, "state"));
        stateMethod.add(279, uname);
        stateMethod.add(280, s);
        stateMethod.add(282, new Str(281, "("));
        stateMethod.add(283, parameters);
        stateMethod.add(285, new Str(284, ")"));
        stateMethod.add(286, s);
        stateMethod.add(288, new Str(287, "{"));
        stateMethod.add(289, s);
        stateMethod.add(291, new Str(290, "return"));
        stateMethod.add(292, ws);
        stateMethod.add(293, name);
        stateMethod.add(294, s);
        Repeat stateMethod_1 = new Repeat(295, "stateMethod_1");
        stateMethod_1.add(296, method);
        stateMethod.add(297, stateMethod_1);
        stateMethod.add(298, s);
        stateMethod.add(300, new Str(299, ";"));
        stateMethod.add(301, s);
        stateMethod.add(303, new Str(302, "}"));

        // convertMethod = public name ws "convert" [uname] s "(" s name:type ws name:variable s ")" s "{" s "return" ws !";"+:statement ";" s "}"
        convertMethod.add(304, _public);
        convertMethod.add(305, name);
        convertMethod.add(306, ws);
        convertMethod.add(308, new Str(307, "convert"));
        Optional convertMethod_1 = new Optional(309, "convertMethod_1");
        convertMethod_1.add(310, uname);
        convertMethod.add(311, convertMethod_1);
        convertMethod.add(312, s);
        convertMethod.add(314, new Str(313, "("));
        convertMethod.add(315, s);
        convertMethod.add(316, name);
        convertMethod.add(317, ws);
        convertMethod.add(318, name);
        convertMethod.add(319, s);
        convertMethod.add(321, new Str(320, ")"));
        convertMethod.add(322, s);
        convertMethod.add(324, new Str(323, "{"));
        convertMethod.add(325, s);
        convertMethod.add(327, new Str(326, "return"));
        convertMethod.add(328, ws);
        Repeat convertMethod_2 = new Repeat(329, "convertMethod_2");
        convertMethod_2.add(331, new Str(330, ";", NOT));
        convertMethod.add(332, convertMethod_2);
        convertMethod.add(334, new Str(333, ";"));
        convertMethod.add(335, s);
        convertMethod.add(337, new Str(336, "}"));

        // classStatement = public "class" ws name:classname s ["extends" ws name s] "{" [s attribute | isvalid | convertMethod | stateMethod]+ s "}"
        classStatement.add(338, _public);
        classStatement.add(340, new Str(339, "class"));
        classStatement.add(341, ws);
        classStatement.add(342, name);
        classStatement.add(343, s);
        Optional classStatement_1 = new Optional(344, "classStatement_1");
        classStatement_1.add(346, new Str(345, "extends"));
        classStatement_1.add(347, ws);
        classStatement_1.add(348, name);
        classStatement_1.add(349, s);
        classStatement.add(350, classStatement_1);
        classStatement.add(352, new Str(351, "{"));
        Optional classStatement_2 = new Optional(353, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(354, "classStatement_2_1");
        classStatement_2_1.add(355, s);
        OrList classStatement_2_1_1 = new OrList(356, "classStatement_2_1_1");
        classStatement_2_1_1.add(357, attribute);
        classStatement_2_1_1.add(358, isvalid);
        classStatement_2_1_1.add(359, convertMethod);
        classStatement_2_1_1.add(360, stateMethod);
        classStatement_2_1.add(361, classStatement_2_1_1);
        classStatement_2.add(362, classStatement_2_1);
        classStatement.add(363, classStatement_2);
        classStatement.add(364, s);
        classStatement.add(366, new Str(365, "}"));

        // stateTemplate = s packagestatement s imports s classStatement s
        stateTemplate.add(367, s);
        stateTemplate.add(368, packagestatement);
        stateTemplate.add(369, s);
        stateTemplate.add(370, imports);
        stateTemplate.add(371, s);
        stateTemplate.add(372, classStatement);
        stateTemplate.add(373, s);

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
        StateTemplateParser.IConvertMethod createConvertMethod();
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

    // ConvertMethod
    public interface IConvertMethod {
        public void setType(String type);
        public void setVariable(String variable);
        public void setStatement(String statement);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void addAttribute(IAttribute iattribute);
        public void setIsValid(IIsValid iisvalid);
        public void addStateMethod(IStateMethod istateMethod);
        public void addConvertMethod(IConvertMethod iconvertMethod);
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
        private Stack<IConvertMethod> convertMethodStack = new Stack<IConvertMethod>();
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

        // ConvertMethod
        public void pushConvertMethod() { convertMethodStack.push(factory.createConvertMethod()); }
        public StateTemplateParser.IConvertMethod popConvertMethod() { return (StateTemplateParser.IConvertMethod)convertMethodStack.pop(); }
        public StateTemplateParser.IConvertMethod peekConvertMethod() {
            if (convertMethodStack.empty()) { return null; }
            return convertMethodStack.peek();
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

        // ConvertMethod convertMethod.setType(String type);
        public class ConvertMethodConvertMethodType implements Output {
            private String name;
            public ConvertMethodConvertMethodType(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekConvertMethod().setType(source.get(bookmark));
            }
        }

        // convertMethod.setVariable(String variable);
        public class ConvertMethodConvertMethodVariable implements Output {
            private String name;
            public ConvertMethodConvertMethodVariable(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekConvertMethod().setVariable(source.get(bookmark));
            }
        }

        // convertMethod.setStatement(String statement);
        public class ConvertMethodConvertMethodStatement implements Output {
            private String name;
            public ConvertMethodConvertMethodStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStatement(); }
            public void set(Source source, int bookmark) {
                popStatement();
                peekConvertMethod().setStatement(source.get(bookmark));
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

        // classStatement.addConvertMethod(ConvertMethod convertMethod);
        public class ClassStatementClassStatementConvertMethod implements Output {
            private String name;
            public ClassStatementClassStatementConvertMethod(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushConvertMethod(); }
            public void set(Source source, int bookmark) {
                peekClassStatement().addConvertMethod(popConvertMethod());
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
