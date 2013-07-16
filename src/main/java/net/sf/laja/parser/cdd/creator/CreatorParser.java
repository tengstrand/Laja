package net.sf.laja.parser.cdd.creator;

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
 * Auto generated 2013-07-16 by Laja:
 *    http://laja.sf.net
 *
 * Version: laja2-006-alpha
 */
public final class CreatorParser implements net.sf.laja.parser.engine2.Parser {
    private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
    private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
    private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

    private Data data1;
    private Data data2;
    private ICreatorFactory factory1;
    private ICreatorFactory factory2;
    private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
    private SyntaxErrorHandler syntaxErrorHandler;

    public static final int PHASE1 = 1;
    public static final int PHASE2 = 2;

    public CreatorParser(ICreatorFactoryFactory factoryFactory) {
        init(factoryFactory);
    }

    public void init(ICreatorFactoryFactory factoryFactory) {
        syntaxErrorHandler = new DefaultSyntaxErrorHandler();
        factory1 = factoryFactory.getFactory(PHASE1);
        factory2 = factoryFactory.getFactory(PHASE2);
        data1 = new Data(factory1);
        data2 = new Data(factory2);
    }

    public CreatorParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
        sourceRecorderLogWriter = writer;
        return this;
    }

    public CreatorParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
        this.syntaxErrorHandler = syntaxErrorHandler;
        return this;
    }

    public ICreatorFactory getFactory1() {
        return factory1;
    }

    public ICreatorFactory getFactory() {
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
        Data.PackageStatementPackageStatement packageStatementPackageStatement = data2.new PackageStatementPackageStatement("packageStatementPackageStatement");
        Data.AparametersAparameters aparametersAparameters = data2.new AparametersAparameters("aparametersAparameters");
        Data.PackageStatementPackageStatementPackagename packageStatementPackageStatementPackagename = data2.new PackageStatementPackageStatementPackagename("packageStatementPackageStatementPackagename");
        Data.ParameterParameterType parameterParameterType = data2.new ParameterParameterType("parameterParameterType");
        Data.ParameterParameterVariable parameterParameterVariable = data2.new ParameterParameterVariable("parameterParameterVariable");
        Data.ParametersParametersParameter parametersParametersParameter = data2.new ParametersParametersParameter("parametersParametersParameter");
        Data.AsMethodAsMethodSpaces asMethodAsMethodSpaces = data2.new AsMethodAsMethodSpaces("asMethodAsMethodSpaces");
        Data.AsMethodAsMethodReturnclass asMethodAsMethodReturnclass = data2.new AsMethodAsMethodReturnclass("asMethodAsMethodReturnclass");
        Data.AsMethodAsMethodMethodName asMethodAsMethodMethodName = data2.new AsMethodAsMethodMethodName("asMethodAsMethodMethodName");
        Data.AsMethodAsMethodParameters asMethodAsMethodParameters = data2.new AsMethodAsMethodParameters("asMethodAsMethodParameters");
        Data.AsMethodAsMethodBody asMethodAsMethodBody = data2.new AsMethodAsMethodBody("asMethodAsMethodBody");
        Data.AparameterAttrAparameterAttrVariable aparameterAttrAparameterAttrVariable = data2.new AparameterAttrAparameterAttrVariable("aparameterAttrAparameterAttrVariable");
        Data.AparameterAttrAparameterAttrValue aparameterAttrAparameterAttrValue = data2.new AparameterAttrAparameterAttrValue("aparameterAttrAparameterAttrValue");
        Data.AparameterAparameterAparameterAttr aparameterAparameterAparameterAttr = data2.new AparameterAparameterAparameterAttr("aparameterAparameterAparameterAttr");
        Data.AparametersAparametersAparameter aparametersAparametersAparameter = data2.new AparametersAparametersAparameter("aparametersAparametersAparameter");
        Data.CreatorAnnotationMain creatorAnnotationMain = data2.new CreatorAnnotationMain("creatorAnnotationMain");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementStateClass classStatementClassStatementStateClass = data2.new ClassStatementClassStatementStateClass("classStatementClassStatementStateClass");
        Data.ClassStatementClassStatementAsMethod classStatementClassStatementAsMethod = data2.new ClassStatementClassStatementAsMethod("classStatementClassStatementAsMethod");
        Data.ClassStatementClassStatementAparameters classStatementClassStatementAparameters = data2.new ClassStatementClassStatementAparameters("classStatementClassStatementAparameters");
        Data.CreatorCreatorPackageStatement creatorCreatorPackageStatement = data2.new CreatorCreatorPackageStatement("creatorCreatorPackageStatement");
        Data.CreatorCreatorImports creatorCreatorImports = data2.new CreatorCreatorImports("creatorCreatorImports");
        Data.CreatorCreatorClassStatement creatorCreatorClassStatement = data2.new CreatorCreatorClassStatement("creatorCreatorClassStatement");
        Data.CreatorCreatorManualCode creatorCreatorManualCode = data2.new CreatorCreatorManualCode("creatorCreatorManualCode");
        Data.CreatorCreatorGeneratedCode creatorCreatorGeneratedCode = data2.new CreatorCreatorGeneratedCode("creatorCreatorGeneratedCode");

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
        ElementList packagename = new ElementList(11, "packagename");
        ElementList packageStatement = new ElementList(12, "packageStatement", packageStatementPackageStatement);
        ElementList fullclassname = new ElementList(13, "fullclassname");
        ElementList importstatement = new ElementList(14, "importstatement");
        Optional imports = new Optional(15, "imports");
        ElementList body = new ElementList(16, "body");
        ElementList parameter = new ElementList(17, "parameter");
        ElementList parameters = new ElementList(18, "parameters");
        ElementList asMethod = new ElementList(19, "asMethod");
        ElementList aparameterAttr = new ElementList(20, "aparameterAttr");
        ElementList aparameter = new ElementList(21, "aparameter");
        ElementList aparameters = new ElementList(22, "aparameters", aparametersAparameters);
        Optional keywords = new Optional(23, "keywords");
        ElementList annotation = new ElementList(24, "annotation");
        ElementList classStatement = new ElementList(25, "classStatement");
        ElementList manualEnd = new ElementList(26, "manualEnd");
        Str generatedCode = new Str(27, "// ===== Generated code =====");
        Repeat manualCode = new Repeat(28, "manualCode");
        ElementList creator = new ElementList(29, "creator");

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

        // packagename = name ["." name|"*"]+
        packagename.add(104, name);
        Optional packagename_1 = new Optional(105, "packagename_1");
        Repeat packagename_1_1 = new Repeat(106, "packagename_1_1");
        packagename_1_1.add(108, new Str(107, "."));
        OrList packagename_1_1_1 = new OrList(109, "packagename_1_1_1");
        packagename_1_1_1.add(110, name);
        packagename_1_1_1.add(112, new Str(111, "*"));
        packagename_1_1.add(113, packagename_1_1_1);
        packagename_1.add(114, packagename_1_1);
        packagename.add(115, packagename_1);

        // packageStatement = "package" ws packagename s ";"
        packageStatement.add(117, new Str(116, "package"));
        packageStatement.add(118, ws);
        packageStatement.add(119, packagename, packageStatementPackageStatementPackagename);
        packageStatement.add(120, s);
        packageStatement.add(122, new Str(121, ";"));

        // fullclassname = packagename
        fullclassname.add(123, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(125, new Str(124, "import"));
        importstatement.add(126, ws);
        Optional importstatement_1 = new Optional(127, "importstatement_1");
        importstatement_1.add(129, new Str(128, "static"));
        importstatement_1.add(130, ws);
        importstatement.add(131, importstatement_1);
        importstatement.add(132, fullclassname);
        importstatement.add(133, s);
        importstatement.add(135, new Str(134, ";"));
        importstatement.add(136, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(137, "imports_1");
        imports_1.add(138, importstatement);
        imports.add(139, imports_1);

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(141, new Str(140, "{"));
        body.add(142, s);
        Optional body_1 = new Optional(143, "body_1");
        Repeat body_1_1 = new Repeat(144, "body_1_1");
        OrList body_1_1_1 = new OrList(145, "body_1_1_1");
        body_1_1_1.add(146, body);
        body_1_1_1.add(147, str);
        body_1_1_1.add(149, new Str(148, "}", NOT));
        body_1_1.add(150, body_1_1_1);
        body_1.add(151, body_1_1);
        body.add(152, body_1);
        body.add(154, new Str(153, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(155, s);
        parameter.add(156, name, parameterParameterType);
        parameter.add(157, ws);
        parameter.add(158, name, parameterParameterVariable);
        parameter.add(159, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(160, "parameters_1");
        parameters_1.add(161, parameter, parametersParametersParameter);
        parameters.add(162, parameters_1);
        Optional parameters_2 = new Optional(163, "parameters_2");
        Repeat parameters_2_1 = new Repeat(164, "parameters_2_1");
        parameters_2_1.add(166, new Str(165, ","));
        parameters_2_1.add(167, s);
        parameters_2_1.add(168, parameter, parametersParametersParameter);
        parameters_2.add(169, parameters_2_1);
        parameters.add(170, parameters_2);

        // asMethod = s:spaces "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s body
        asMethod.add(171, s, asMethodAsMethodSpaces);
        asMethod.add(173, new Str(172, "public"));
        asMethod.add(174, s);
        asMethod.add(175, name, asMethodAsMethodReturnclass);
        asMethod.add(176, ws);
        ElementList asMethod_1 = new ElementList(177, "asMethod_1", asMethodAsMethodMethodName);
        asMethod_1.add(179, new Str(178, "as"));
        asMethod_1.add(180, name);
        asMethod.add(181, asMethod_1);
        asMethod.add(182, s);
        asMethod.add(184, new Str(183, "("));
        asMethod.add(185, s);
        asMethod.add(186, parameters, asMethodAsMethodParameters);
        asMethod.add(187, s);
        asMethod.add(189, new Str(188, ")"));
        asMethod.add(190, s);
        asMethod.add(191, body, asMethodAsMethodBody);

        // aparameterAttr = name:variable s "=" s (name|str):value
        aparameterAttr.add(192, name, aparameterAttrAparameterAttrVariable);
        aparameterAttr.add(193, s);
        aparameterAttr.add(195, new Str(194, "="));
        aparameterAttr.add(196, s);
        OrList aparameterAttr_1 = new OrList(197, "aparameterAttr_1", aparameterAttrAparameterAttrValue);
        aparameterAttr_1.add(198, name);
        aparameterAttr_1.add(199, str);
        aparameterAttr.add(200, aparameterAttr_1);

        // aparameter = "@Parameter" s "(" s aparameterAttr [s "," s aparameterAttr]+ s ")"
        aparameter.add(202, new Str(201, "@Parameter"));
        aparameter.add(203, s);
        aparameter.add(205, new Str(204, "("));
        aparameter.add(206, s);
        aparameter.add(207, aparameterAttr, aparameterAparameterAparameterAttr);
        Optional aparameter_1 = new Optional(208, "aparameter_1");
        Repeat aparameter_1_1 = new Repeat(209, "aparameter_1_1");
        aparameter_1_1.add(210, s);
        aparameter_1_1.add(212, new Str(211, ","));
        aparameter_1_1.add(213, s);
        aparameter_1_1.add(214, aparameterAttr, aparameterAparameterAparameterAttr);
        aparameter_1.add(215, aparameter_1_1);
        aparameter.add(216, aparameter_1);
        aparameter.add(217, s);
        aparameter.add(219, new Str(218, ")"));

        // aparameters = s "@Parameters" s "(" s "{" s aparameter [s "," s aparameter]+ s "}" s ")"
        aparameters.add(220, s);
        aparameters.add(222, new Str(221, "@Parameters"));
        aparameters.add(223, s);
        aparameters.add(225, new Str(224, "("));
        aparameters.add(226, s);
        aparameters.add(228, new Str(227, "{"));
        aparameters.add(229, s);
        aparameters.add(230, aparameter, aparametersAparametersAparameter);
        Optional aparameters_1 = new Optional(231, "aparameters_1");
        Repeat aparameters_1_1 = new Repeat(232, "aparameters_1_1");
        aparameters_1_1.add(233, s);
        aparameters_1_1.add(235, new Str(234, ","));
        aparameters_1_1.add(236, s);
        aparameters_1_1.add(237, aparameter, aparametersAparametersAparameter);
        aparameters_1.add(238, aparameters_1_1);
        aparameters.add(239, aparameters_1);
        aparameters.add(240, s);
        aparameters.add(242, new Str(241, "}"));
        aparameters.add(243, s);
        aparameters.add(245, new Str(244, ")"));

        // keywords = ["private"|"public"|"static"|"final" s]+
        Repeat keywords_1 = new Repeat(246, "keywords_1");
        OrList keywords_1_1 = new OrList(247, "keywords_1_1");
        keywords_1_1.add(249, new Str(248, "private"));
        keywords_1_1.add(251, new Str(250, "public"));
        keywords_1_1.add(253, new Str(252, "static"));
        keywords_1_1.add(255, new Str(254, "final"));
        keywords_1.add(256, keywords_1_1);
        keywords_1.add(257, s);
        keywords.add(258, keywords_1);

        // annotation = "@Creator" [s "(" ["main":main] s ")"]
        annotation.add(260, new Str(259, "@Creator"));
        Optional annotation_1 = new Optional(261, "annotation_1");
        annotation_1.add(262, s);
        annotation_1.add(264, new Str(263, "("));
        Optional annotation_1_1 = new Optional(265, "annotation_1_1");
        annotation_1_1.add(267, new Str(266, "main", creatorAnnotationMain));
        annotation_1.add(268, annotation_1_1);
        annotation_1.add(269, s);
        annotation_1.add(271, new Str(270, ")"));
        annotation.add(272, annotation_1);

        // classStatement =
        //   [annotation ws] public "class" ws name:classname [s "implements" s name [s "," s name]+] s "{" s
        //   keywords s [name s "." s] name:stateClass s "state;" [asMethod|aparameters]+
        Optional classStatement_1 = new Optional(273, "classStatement_1");
        classStatement_1.add(274, annotation);
        classStatement_1.add(275, ws);
        classStatement.add(276, classStatement_1);
        classStatement.add(277, _public);
        classStatement.add(279, new Str(278, "class"));
        classStatement.add(280, ws);
        classStatement.add(281, name, classStatementClassStatementClassname);
        Optional classStatement_2 = new Optional(282, "classStatement_2");
        classStatement_2.add(283, s);
        classStatement_2.add(285, new Str(284, "implements"));
        classStatement_2.add(286, s);
        classStatement_2.add(287, name);
        Optional classStatement_2_1 = new Optional(288, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(289, "classStatement_2_1_1");
        classStatement_2_1_1.add(290, s);
        classStatement_2_1_1.add(292, new Str(291, ","));
        classStatement_2_1_1.add(293, s);
        classStatement_2_1_1.add(294, name);
        classStatement_2_1.add(295, classStatement_2_1_1);
        classStatement_2.add(296, classStatement_2_1);
        classStatement.add(297, classStatement_2);
        classStatement.add(298, s);
        classStatement.add(300, new Str(299, "{"));
        classStatement.add(301, s);
        classStatement.add(302, keywords);
        classStatement.add(303, s);
        Optional classStatement_3 = new Optional(304, "classStatement_3");
        classStatement_3.add(305, name);
        classStatement_3.add(306, s);
        classStatement_3.add(308, new Str(307, "."));
        classStatement_3.add(309, s);
        classStatement.add(310, classStatement_3);
        classStatement.add(311, name, classStatementClassStatementStateClass);
        classStatement.add(312, s);
        classStatement.add(314, new Str(313, "state;"));
        Optional classStatement_4 = new Optional(315, "classStatement_4");
        Repeat classStatement_4_1 = new Repeat(316, "classStatement_4_1");
        OrList classStatement_4_1_1 = new OrList(317, "classStatement_4_1_1");
        classStatement_4_1_1.add(318, asMethod, classStatementClassStatementAsMethod);
        classStatement_4_1_1.add(319, aparameters, classStatementClassStatementAparameters);
        classStatement_4_1.add(320, classStatement_4_1_1);
        classStatement_4.add(321, classStatement_4_1);
        classStatement.add(322, classStatement_4);

        // manualEnd = ("}" s END)
        manualEnd.add(324, new Str(323, "}"));
        manualEnd.add(325, s);
        manualEnd.add(327, new End(326, "manualEnd"));

        // generatedCode = "// ===== Generated code ====="

        // manualCode = !(manualEnd | generatedCode)+
        OrList manualCode_1 = new OrList(328, "manualCode_1");
        manualCode_1.add(329, manualEnd);
        manualCode_1.add(330, generatedCode);
        manualCode.add(331, manualCode_1, NOT);

        // creator = packageStatement s imports s classStatement manualCode [generatedCode] *
        creator.add(332, packageStatement, creatorCreatorPackageStatement);
        creator.add(333, s);
        creator.add(334, imports, creatorCreatorImports);
        creator.add(335, s);
        creator.add(336, classStatement, creatorCreatorClassStatement);
        creator.add(337, manualCode, creatorCreatorManualCode);
        Optional creator_1 = new Optional(338, "creator_1");
        creator_1.add(339, generatedCode, creatorCreatorGeneratedCode);
        creator.add(340, creator_1);
        creator.add(342, new Complete(341, "creator"));

        return new TopElement(data2, creator);
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
        ElementList packagename = new ElementList(11, "packagename");
        ElementList packageStatement = new ElementList(12, "packageStatement");
        ElementList fullclassname = new ElementList(13, "fullclassname");
        ElementList importstatement = new ElementList(14, "importstatement");
        Optional imports = new Optional(15, "imports");
        ElementList body = new ElementList(16, "body");
        ElementList parameter = new ElementList(17, "parameter");
        ElementList parameters = new ElementList(18, "parameters");
        ElementList asMethod = new ElementList(19, "asMethod");
        ElementList aparameterAttr = new ElementList(20, "aparameterAttr");
        ElementList aparameter = new ElementList(21, "aparameter");
        ElementList aparameters = new ElementList(22, "aparameters");
        Optional keywords = new Optional(23, "keywords");
        ElementList annotation = new ElementList(24, "annotation");
        ElementList classStatement = new ElementList(25, "classStatement");
        ElementList manualEnd = new ElementList(26, "manualEnd");
        Str generatedCode = new Str(27, "// ===== Generated code =====");
        Repeat manualCode = new Repeat(28, "manualCode");
        ElementList creator = new ElementList(29, "creator");

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

        // packagename = name ["." name|"*"]+
        packagename.add(104, name);
        Optional packagename_1 = new Optional(105, "packagename_1");
        Repeat packagename_1_1 = new Repeat(106, "packagename_1_1");
        packagename_1_1.add(108, new Str(107, "."));
        OrList packagename_1_1_1 = new OrList(109, "packagename_1_1_1");
        packagename_1_1_1.add(110, name);
        packagename_1_1_1.add(112, new Str(111, "*"));
        packagename_1_1.add(113, packagename_1_1_1);
        packagename_1.add(114, packagename_1_1);
        packagename.add(115, packagename_1);

        // packageStatement = "package" ws packagename s ";"
        packageStatement.add(117, new Str(116, "package"));
        packageStatement.add(118, ws);
        packageStatement.add(119, packagename);
        packageStatement.add(120, s);
        packageStatement.add(122, new Str(121, ";"));

        // fullclassname = packagename
        fullclassname.add(123, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(125, new Str(124, "import"));
        importstatement.add(126, ws);
        Optional importstatement_1 = new Optional(127, "importstatement_1");
        importstatement_1.add(129, new Str(128, "static"));
        importstatement_1.add(130, ws);
        importstatement.add(131, importstatement_1);
        importstatement.add(132, fullclassname);
        importstatement.add(133, s);
        importstatement.add(135, new Str(134, ";"));
        importstatement.add(136, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(137, "imports_1");
        imports_1.add(138, importstatement);
        imports.add(139, imports_1);

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(141, new Str(140, "{"));
        body.add(142, s);
        Optional body_1 = new Optional(143, "body_1");
        Repeat body_1_1 = new Repeat(144, "body_1_1");
        OrList body_1_1_1 = new OrList(145, "body_1_1_1");
        body_1_1_1.add(146, body);
        body_1_1_1.add(147, str);
        body_1_1_1.add(149, new Str(148, "}", NOT));
        body_1_1.add(150, body_1_1_1);
        body_1.add(151, body_1_1);
        body.add(152, body_1);
        body.add(154, new Str(153, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(155, s);
        parameter.add(156, name);
        parameter.add(157, ws);
        parameter.add(158, name);
        parameter.add(159, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(160, "parameters_1");
        parameters_1.add(161, parameter);
        parameters.add(162, parameters_1);
        Optional parameters_2 = new Optional(163, "parameters_2");
        Repeat parameters_2_1 = new Repeat(164, "parameters_2_1");
        parameters_2_1.add(166, new Str(165, ","));
        parameters_2_1.add(167, s);
        parameters_2_1.add(168, parameter);
        parameters_2.add(169, parameters_2_1);
        parameters.add(170, parameters_2);

        // asMethod = s:spaces "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s body
        asMethod.add(171, s);
        asMethod.add(173, new Str(172, "public"));
        asMethod.add(174, s);
        asMethod.add(175, name);
        asMethod.add(176, ws);
        ElementList asMethod_1 = new ElementList(177, "asMethod_1");
        asMethod_1.add(179, new Str(178, "as"));
        asMethod_1.add(180, name);
        asMethod.add(181, asMethod_1);
        asMethod.add(182, s);
        asMethod.add(184, new Str(183, "("));
        asMethod.add(185, s);
        asMethod.add(186, parameters);
        asMethod.add(187, s);
        asMethod.add(189, new Str(188, ")"));
        asMethod.add(190, s);
        asMethod.add(191, body);

        // aparameterAttr = name:variable s "=" s (name|str):value
        aparameterAttr.add(192, name);
        aparameterAttr.add(193, s);
        aparameterAttr.add(195, new Str(194, "="));
        aparameterAttr.add(196, s);
        OrList aparameterAttr_1 = new OrList(197, "aparameterAttr_1");
        aparameterAttr_1.add(198, name);
        aparameterAttr_1.add(199, str);
        aparameterAttr.add(200, aparameterAttr_1);

        // aparameter = "@Parameter" s "(" s aparameterAttr [s "," s aparameterAttr]+ s ")"
        aparameter.add(202, new Str(201, "@Parameter"));
        aparameter.add(203, s);
        aparameter.add(205, new Str(204, "("));
        aparameter.add(206, s);
        aparameter.add(207, aparameterAttr);
        Optional aparameter_1 = new Optional(208, "aparameter_1");
        Repeat aparameter_1_1 = new Repeat(209, "aparameter_1_1");
        aparameter_1_1.add(210, s);
        aparameter_1_1.add(212, new Str(211, ","));
        aparameter_1_1.add(213, s);
        aparameter_1_1.add(214, aparameterAttr);
        aparameter_1.add(215, aparameter_1_1);
        aparameter.add(216, aparameter_1);
        aparameter.add(217, s);
        aparameter.add(219, new Str(218, ")"));

        // aparameters = s "@Parameters" s "(" s "{" s aparameter [s "," s aparameter]+ s "}" s ")"
        aparameters.add(220, s);
        aparameters.add(222, new Str(221, "@Parameters"));
        aparameters.add(223, s);
        aparameters.add(225, new Str(224, "("));
        aparameters.add(226, s);
        aparameters.add(228, new Str(227, "{"));
        aparameters.add(229, s);
        aparameters.add(230, aparameter);
        Optional aparameters_1 = new Optional(231, "aparameters_1");
        Repeat aparameters_1_1 = new Repeat(232, "aparameters_1_1");
        aparameters_1_1.add(233, s);
        aparameters_1_1.add(235, new Str(234, ","));
        aparameters_1_1.add(236, s);
        aparameters_1_1.add(237, aparameter);
        aparameters_1.add(238, aparameters_1_1);
        aparameters.add(239, aparameters_1);
        aparameters.add(240, s);
        aparameters.add(242, new Str(241, "}"));
        aparameters.add(243, s);
        aparameters.add(245, new Str(244, ")"));

        // keywords = ["private"|"public"|"static"|"final" s]+
        Repeat keywords_1 = new Repeat(246, "keywords_1");
        OrList keywords_1_1 = new OrList(247, "keywords_1_1");
        keywords_1_1.add(249, new Str(248, "private"));
        keywords_1_1.add(251, new Str(250, "public"));
        keywords_1_1.add(253, new Str(252, "static"));
        keywords_1_1.add(255, new Str(254, "final"));
        keywords_1.add(256, keywords_1_1);
        keywords_1.add(257, s);
        keywords.add(258, keywords_1);

        // annotation = "@Creator" [s "(" ["main":main] s ")"]
        annotation.add(260, new Str(259, "@Creator"));
        Optional annotation_1 = new Optional(261, "annotation_1");
        annotation_1.add(262, s);
        annotation_1.add(264, new Str(263, "("));
        Optional annotation_1_1 = new Optional(265, "annotation_1_1");
        annotation_1_1.add(267, new Str(266, "main"));
        annotation_1.add(268, annotation_1_1);
        annotation_1.add(269, s);
        annotation_1.add(271, new Str(270, ")"));
        annotation.add(272, annotation_1);

        // classStatement =
        //   [annotation ws] public "class" ws name:classname [s "implements" s name [s "," s name]+] s "{" s
        //   keywords s [name s "." s] name:stateClass s "state;" [asMethod|aparameters]+
        Optional classStatement_1 = new Optional(273, "classStatement_1");
        classStatement_1.add(274, annotation);
        classStatement_1.add(275, ws);
        classStatement.add(276, classStatement_1);
        classStatement.add(277, _public);
        classStatement.add(279, new Str(278, "class"));
        classStatement.add(280, ws);
        classStatement.add(281, name);
        Optional classStatement_2 = new Optional(282, "classStatement_2");
        classStatement_2.add(283, s);
        classStatement_2.add(285, new Str(284, "implements"));
        classStatement_2.add(286, s);
        classStatement_2.add(287, name);
        Optional classStatement_2_1 = new Optional(288, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(289, "classStatement_2_1_1");
        classStatement_2_1_1.add(290, s);
        classStatement_2_1_1.add(292, new Str(291, ","));
        classStatement_2_1_1.add(293, s);
        classStatement_2_1_1.add(294, name);
        classStatement_2_1.add(295, classStatement_2_1_1);
        classStatement_2.add(296, classStatement_2_1);
        classStatement.add(297, classStatement_2);
        classStatement.add(298, s);
        classStatement.add(300, new Str(299, "{"));
        classStatement.add(301, s);
        classStatement.add(302, keywords);
        classStatement.add(303, s);
        Optional classStatement_3 = new Optional(304, "classStatement_3");
        classStatement_3.add(305, name);
        classStatement_3.add(306, s);
        classStatement_3.add(308, new Str(307, "."));
        classStatement_3.add(309, s);
        classStatement.add(310, classStatement_3);
        classStatement.add(311, name);
        classStatement.add(312, s);
        classStatement.add(314, new Str(313, "state;"));
        Optional classStatement_4 = new Optional(315, "classStatement_4");
        Repeat classStatement_4_1 = new Repeat(316, "classStatement_4_1");
        OrList classStatement_4_1_1 = new OrList(317, "classStatement_4_1_1");
        classStatement_4_1_1.add(318, asMethod);
        classStatement_4_1_1.add(319, aparameters);
        classStatement_4_1.add(320, classStatement_4_1_1);
        classStatement_4.add(321, classStatement_4_1);
        classStatement.add(322, classStatement_4);

        // manualEnd = ("}" s END)
        manualEnd.add(324, new Str(323, "}"));
        manualEnd.add(325, s);
        manualEnd.add(327, new End(326, "manualEnd"));

        // generatedCode = "// ===== Generated code ====="

        // manualCode = !(manualEnd | generatedCode)+
        OrList manualCode_1 = new OrList(328, "manualCode_1");
        manualCode_1.add(329, manualEnd);
        manualCode_1.add(330, generatedCode);
        manualCode.add(331, manualCode_1, NOT);

        // creator = packageStatement s imports s classStatement manualCode [generatedCode] *
        creator.add(332, packageStatement);
        creator.add(333, s);
        creator.add(334, imports);
        creator.add(335, s);
        creator.add(336, classStatement);
        creator.add(337, manualCode);
        Optional creator_1 = new Optional(338, "creator_1");
        creator_1.add(339, generatedCode);
        creator.add(340, creator_1);
        creator.add(342, new Complete(341, "creator"));

        return new TopElement(data1, creator);
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
            data.pushCreator();
            boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
            data.popCreator();
            return match;
        }
    }

    // *** ICreatorFactoryFactory
    public interface ICreatorFactoryFactory {
        public ICreatorFactory getFactory(int phase);
    }

    // *** ICreatorFactory ***
    public interface ICreatorFactory {
        CreatorParser.IPackageStatement createPackageStatement();
        CreatorParser.IParameter createParameter();
        CreatorParser.IParameters createParameters();
        CreatorParser.IAsMethod createAsMethod();
        CreatorParser.IAparameterAttr createAparameterAttr();
        CreatorParser.IAparameter createAparameter();
        CreatorParser.IAparameters createAparameters();
        CreatorParser.IClassStatement createClassStatement();
        CreatorParser.ICreator createCreator();
    }

    // *** Interfaces ***
    // PackageStatement
    public interface IPackageStatement {
        public void setPackagename(String packagename);
        public void setContent(String packageStatement);
    }

    // Parameter
    public interface IParameter {
        public void setType(String type);
        public void setVariable(String variable);
    }

    // Parameters
    public interface IParameters {
        public void addParameter(IParameter iparameter);
    }

    // AsMethod
    public interface IAsMethod {
        public void setSpaces(String spaces);
        public void setReturnclass(String returnclass);
        public void setMethodName(String methodName);
        public void setParameters(IParameters iparameters);
        public void setBody(String body);
    }

    // AparameterAttr
    public interface IAparameterAttr {
        public void setVariable(String variable);
        public void setValue(String value);
    }

    // Aparameter
    public interface IAparameter {
        public void addParameterAttr(IAparameterAttr iaparameterAttr);
    }

    // Aparameters
    public interface IAparameters {
        public void addParameter(IAparameter iaparameter);
        public void setContent(String aparameters);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void setStateClass(String stateClass);
        public void addAsMethod(IAsMethod iasMethod);
        public void setAParameters(IAparameters iaparameters);
    }

    // Creator
    public interface ICreator {
        public void setPackageStatement(IPackageStatement ipackageStatement);
        public void setImports(String imports);
        public void setClassStatement(IClassStatement iclassStatement);
        public void setManualCode(String manualCode);
        public void setGeneratedCode();
        public void setIsMainCreator();
    }

    // *** Data ***
    public static final class Data {
        private CreatorParser.ICreatorFactory factory;
        private Stack<IPackageStatement> packageStatementStack = new Stack<IPackageStatement>();
        private Stack<IParameter> parameterStack = new Stack<IParameter>();
        private Stack<IParameters> parametersStack = new Stack<IParameters>();
        private Stack<IAsMethod> asMethodStack = new Stack<IAsMethod>();
        private Stack<IAparameterAttr> aparameterAttrStack = new Stack<IAparameterAttr>();
        private Stack<IAparameter> aparameterStack = new Stack<IAparameter>();
        private Stack<IAparameters> aparametersStack = new Stack<IAparameters>();
        private Stack<IClassStatement> classStatementStack = new Stack<IClassStatement>();
        private Stack<ICreator> creatorStack = new Stack<ICreator>();

        public Data(CreatorParser.ICreatorFactory factory) {
            this.factory = factory;
        }

        // PackageStatement
        public void pushPackageStatement() { packageStatementStack.push(factory.createPackageStatement()); }
        public CreatorParser.IPackageStatement popPackageStatement() { return (CreatorParser.IPackageStatement)packageStatementStack.pop(); }
        public CreatorParser.IPackageStatement peekPackageStatement() {
            if (packageStatementStack.empty()) { return null; }
            return packageStatementStack.peek();
        }

        // Parameter
        public void pushParameter() { parameterStack.push(factory.createParameter()); }
        public CreatorParser.IParameter popParameter() { return (CreatorParser.IParameter)parameterStack.pop(); }
        public CreatorParser.IParameter peekParameter() {
            if (parameterStack.empty()) { return null; }
            return parameterStack.peek();
        }

        // Parameters
        public void pushParameters() { parametersStack.push(factory.createParameters()); }
        public CreatorParser.IParameters popParameters() { return (CreatorParser.IParameters)parametersStack.pop(); }
        public CreatorParser.IParameters peekParameters() {
            if (parametersStack.empty()) { return null; }
            return parametersStack.peek();
        }

        // AsMethod
        public void pushAsMethod() { asMethodStack.push(factory.createAsMethod()); }
        public CreatorParser.IAsMethod popAsMethod() { return (CreatorParser.IAsMethod)asMethodStack.pop(); }
        public CreatorParser.IAsMethod peekAsMethod() {
            if (asMethodStack.empty()) { return null; }
            return asMethodStack.peek();
        }

        // AparameterAttr
        public void pushAparameterAttr() { aparameterAttrStack.push(factory.createAparameterAttr()); }
        public CreatorParser.IAparameterAttr popAparameterAttr() { return (CreatorParser.IAparameterAttr)aparameterAttrStack.pop(); }
        public CreatorParser.IAparameterAttr peekAparameterAttr() {
            if (aparameterAttrStack.empty()) { return null; }
            return aparameterAttrStack.peek();
        }

        // Aparameter
        public void pushAparameter() { aparameterStack.push(factory.createAparameter()); }
        public CreatorParser.IAparameter popAparameter() { return (CreatorParser.IAparameter)aparameterStack.pop(); }
        public CreatorParser.IAparameter peekAparameter() {
            if (aparameterStack.empty()) { return null; }
            return aparameterStack.peek();
        }

        // Aparameters
        public void pushAparameters() { aparametersStack.push(factory.createAparameters()); }
        public CreatorParser.IAparameters popAparameters() { return (CreatorParser.IAparameters)aparametersStack.pop(); }
        public CreatorParser.IAparameters peekAparameters() {
            if (aparametersStack.empty()) { return null; }
            return aparametersStack.peek();
        }

        // ClassStatement
        public void pushClassStatement() { classStatementStack.push(factory.createClassStatement()); }
        public CreatorParser.IClassStatement popClassStatement() { return (CreatorParser.IClassStatement)classStatementStack.pop(); }
        public CreatorParser.IClassStatement peekClassStatement() {
            if (classStatementStack.empty()) { return null; }
            return classStatementStack.peek();
        }

        // Creator
        public void pushCreator() { creatorStack.push(factory.createCreator()); }
        public CreatorParser.ICreator popCreator() { return (CreatorParser.ICreator)creatorStack.pop(); }
        public CreatorParser.ICreator peekCreator() {
            if (creatorStack.empty()) { return null; }
            return creatorStack.peek();
        }

        // packageStatement.setContent(String *);
        public class PackageStatementPackageStatement implements Output {
            private String name;
            public PackageStatementPackageStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekPackageStatement().setContent(source.get(bookmark));
            }
        }

        // aparameters.setContent(String *);
        public class AparametersAparameters implements Output {
            private String name;
            public AparametersAparameters(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAparameters().setContent(source.get(bookmark));
            }
        }

        // PackageStatement packageStatement.setPackagename(String packagename);
        public class PackageStatementPackageStatementPackagename implements Output {
            private String name;
            public PackageStatementPackageStatementPackagename(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekPackageStatement().setPackagename(source.get(bookmark));
            }
        }

        // Parameter parameter.setType(String type);
        public class ParameterParameterType implements Output {
            private String name;
            public ParameterParameterType(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekParameter().setType(source.get(bookmark));
            }
        }

        // parameter.setVariable(String variable);
        public class ParameterParameterVariable implements Output {
            private String name;
            public ParameterParameterVariable(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekParameter().setVariable(source.get(bookmark));
            }
        }

        // Parameters parameters.addParameter(Parameter parameter);
        public class ParametersParametersParameter implements Output {
            private String name;
            public ParametersParametersParameter(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushParameter(); }
            public void set(Source source, int bookmark) {
                peekParameters().addParameter(popParameter());
            }
        }

        // AsMethod asMethod.setSpaces(String spaces);
        public class AsMethodAsMethodSpaces implements Output {
            private String name;
            public AsMethodAsMethodSpaces(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAsMethod().setSpaces(source.get(bookmark));
            }
        }

        // asMethod.setReturnclass(String returnclass);
        public class AsMethodAsMethodReturnclass implements Output {
            private String name;
            public AsMethodAsMethodReturnclass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAsMethod().setReturnclass(source.get(bookmark));
            }
        }

        // asMethod.setMethodName(String methodName);
        public class AsMethodAsMethodMethodName implements Output {
            private String name;
            public AsMethodAsMethodMethodName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAsMethod().setMethodName(source.get(bookmark));
            }
        }

        // asMethod.setParameters(Parameters parameters);
        public class AsMethodAsMethodParameters implements Output {
            private String name;
            public AsMethodAsMethodParameters(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushParameters(); }
            public void set(Source source, int bookmark) {
                peekAsMethod().setParameters(popParameters());
            }
        }

        // asMethod.setBody(String body);
        public class AsMethodAsMethodBody implements Output {
            private String name;
            public AsMethodAsMethodBody(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAsMethod().setBody(source.get(bookmark));
            }
        }

        // AparameterAttr aparameterAttr.setVariable(String variable);
        public class AparameterAttrAparameterAttrVariable implements Output {
            private String name;
            public AparameterAttrAparameterAttrVariable(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAparameterAttr().setVariable(source.get(bookmark));
            }
        }

        // aparameterAttr.setValue(String value);
        public class AparameterAttrAparameterAttrValue implements Output {
            private String name;
            public AparameterAttrAparameterAttrValue(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAparameterAttr().setValue(source.get(bookmark));
            }
        }

        // Aparameter aparameter.addParameterAttr(AparameterAttr aparameterAttr);
        public class AparameterAparameterAparameterAttr implements Output {
            private String name;
            public AparameterAparameterAparameterAttr(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAparameterAttr(); }
            public void set(Source source, int bookmark) {
                peekAparameter().addParameterAttr(popAparameterAttr());
            }
        }

        // Aparameters aparameters.addParameter(Aparameter aparameter);
        public class AparametersAparametersAparameter implements Output {
            private String name;
            public AparametersAparametersAparameter(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAparameter(); }
            public void set(Source source, int bookmark) {
                peekAparameters().addParameter(popAparameter());
            }
        }

        // creator.setIsMainCreator(void annotation.main);
        public class CreatorAnnotationMain implements Output {
            private String name;
            public CreatorAnnotationMain(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekCreator().setIsMainCreator();
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

        // classStatement.setStateClass(String stateClass);
        public class ClassStatementClassStatementStateClass implements Output {
            private String name;
            public ClassStatementClassStatementStateClass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassStatement().setStateClass(source.get(bookmark));
            }
        }

        // classStatement.addAsMethod(AsMethod asMethod);
        public class ClassStatementClassStatementAsMethod implements Output {
            private String name;
            public ClassStatementClassStatementAsMethod(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAsMethod(); }
            public void set(Source source, int bookmark) {
                peekClassStatement().addAsMethod(popAsMethod());
            }
        }

        // classStatement.setAParameters(Aparameters aparameters);
        public class ClassStatementClassStatementAparameters implements Output {
            private String name;
            public ClassStatementClassStatementAparameters(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAparameters(); }
            public void set(Source source, int bookmark) {
                peekClassStatement().setAParameters(popAparameters());
            }
        }

        // Creator creator.setPackageStatement(PackageStatement packageStatement);
        public class CreatorCreatorPackageStatement implements Output {
            private String name;
            public CreatorCreatorPackageStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushPackageStatement(); }
            public void set(Source source, int bookmark) {
                peekCreator().setPackageStatement(popPackageStatement());
            }
        }

        // creator.setImports(String imports);
        public class CreatorCreatorImports implements Output {
            private String name;
            public CreatorCreatorImports(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekCreator().setImports(source.get(bookmark));
            }
        }

        // creator.setClassStatement(ClassStatement classStatement);
        public class CreatorCreatorClassStatement implements Output {
            private String name;
            public CreatorCreatorClassStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushClassStatement(); }
            public void set(Source source, int bookmark) {
                peekCreator().setClassStatement(popClassStatement());
            }
        }

        // creator.setManualCode(String manualCode);
        public class CreatorCreatorManualCode implements Output {
            private String name;
            public CreatorCreatorManualCode(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekCreator().setManualCode(source.get(bookmark));
            }
        }

        // creator.setGeneratedCode(void generatedCode);
        public class CreatorCreatorGeneratedCode implements Output {
            private String name;
            public CreatorCreatorGeneratedCode(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekCreator().setGeneratedCode();
            }
        }
    }
}
