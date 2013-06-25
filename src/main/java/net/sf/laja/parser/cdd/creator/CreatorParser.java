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
 * Auto generated 2013-06-25 by Laja:
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
        ElementList annotation = new ElementList(23, "annotation");
        ElementList classStatement = new ElementList(24, "classStatement");
        ElementList manualEnd = new ElementList(25, "manualEnd");
        Str generatedCode = new Str(26, "// ===== Generated code =====");
        Repeat manualCode = new Repeat(27, "manualCode");
        ElementList creator = new ElementList(28, "creator");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(30, new Str(29, "\r\n"));
        newline.add(32, new Str(31, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(33, "comment_1");
        comment_1.add(35, new Str(34, "/*"));
        Optional comment_1_1 = new Optional(36, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(37, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(38, "comment_1_1_1_1");
        comment_1_1_1_1.add(39, comment);
        comment_1_1_1_1.add(41, new Str(40, "*/", NOT));
        comment_1_1_1.add(42, comment_1_1_1_1);
        comment_1_1.add(43, comment_1_1_1);
        comment_1.add(44, comment_1_1);
        comment_1.add(46, new Str(45, "*/"));
        comment.add(47, comment_1);
        ElementList comment_2 = new ElementList(48, "comment_2");
        comment_2.add(50, new Str(49, "//"));
        Optional comment_2_1 = new Optional(51, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(52, "comment_2_1_1");
        comment_2_1_1.add(53, newline, NOT);
        comment_2_1.add(54, comment_2_1_1);
        comment_2.add(55, comment_2_1);
        OrList comment_2_2 = new OrList(56, "comment_2_2");
        comment_2_2.add(57, newline);
        comment_2_2.add(59, new End(58, "comment_2_2"));
        comment_2.add(60, comment_2_2);
        comment.add(61, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(62, "ws_1");
        ws_1.add(63, newline);
        ws_1.add(65, new Str(64, " "));
        ws_1.add(67, new Str(66, "\t"));
        ws_1.add(68, comment);
        ws.add(69, ws_1);

        // s = [ws]
        s.add(70, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(71, ff);
        Repeat str_1 = new Repeat(72, "str_1");
        OrList str_1_1 = new OrList(73, "str_1_1");
        str_1_1.add(75, new Str(74, "\\\""));
        OrList str_1_1_1 = new OrList(76, "str_1_1_1", NOT);
        str_1_1_1.add(77, ff);
        str_1_1_1.add(78, newline);
        str_1_1.add(79, str_1_1_1);
        str_1.add(80, str_1_1);
        str.add(81, str_1);
        str.add(82, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(84, new Range(83, "letter", "a", "z"));
        letter.add(86, new Range(85, "letter", "A", "Z"));
        letter.add(88, new Str(87, "_"));
        letter.add(90, new Str(89, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(91, letter);
        Optional name_1 = new Optional(92, "name_1");
        Repeat name_1_1 = new Repeat(93, "name_1_1");
        OrList name_1_1_1 = new OrList(94, "name_1_1_1");
        name_1_1_1.add(95, letter);
        name_1_1_1.add(96, digit);
        name_1_1.add(97, name_1_1_1);
        name_1.add(98, name_1_1);
        name.add(99, name_1);

        // public = ["public" ws]
        _public.add(101, new Str(100, "public"));
        _public.add(102, ws);

        // packagename = name ["." name|"*"]+
        packagename.add(103, name);
        Optional packagename_1 = new Optional(104, "packagename_1");
        Repeat packagename_1_1 = new Repeat(105, "packagename_1_1");
        packagename_1_1.add(107, new Str(106, "."));
        OrList packagename_1_1_1 = new OrList(108, "packagename_1_1_1");
        packagename_1_1_1.add(109, name);
        packagename_1_1_1.add(111, new Str(110, "*"));
        packagename_1_1.add(112, packagename_1_1_1);
        packagename_1.add(113, packagename_1_1);
        packagename.add(114, packagename_1);

        // packageStatement = "package" ws packagename s ";"
        packageStatement.add(116, new Str(115, "package"));
        packageStatement.add(117, ws);
        packageStatement.add(118, packagename, packageStatementPackageStatementPackagename);
        packageStatement.add(119, s);
        packageStatement.add(121, new Str(120, ";"));

        // fullclassname = packagename
        fullclassname.add(122, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(124, new Str(123, "import"));
        importstatement.add(125, ws);
        Optional importstatement_1 = new Optional(126, "importstatement_1");
        importstatement_1.add(128, new Str(127, "static"));
        importstatement_1.add(129, ws);
        importstatement.add(130, importstatement_1);
        importstatement.add(131, fullclassname);
        importstatement.add(132, s);
        importstatement.add(134, new Str(133, ";"));
        importstatement.add(135, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(136, "imports_1");
        imports_1.add(137, importstatement);
        imports.add(138, imports_1);

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(140, new Str(139, "{"));
        body.add(141, s);
        Optional body_1 = new Optional(142, "body_1");
        Repeat body_1_1 = new Repeat(143, "body_1_1");
        OrList body_1_1_1 = new OrList(144, "body_1_1_1");
        body_1_1_1.add(145, body);
        body_1_1_1.add(146, str);
        body_1_1_1.add(148, new Str(147, "}", NOT));
        body_1_1.add(149, body_1_1_1);
        body_1.add(150, body_1_1);
        body.add(151, body_1);
        body.add(153, new Str(152, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(154, s);
        parameter.add(155, name, parameterParameterType);
        parameter.add(156, ws);
        parameter.add(157, name, parameterParameterVariable);
        parameter.add(158, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(159, "parameters_1");
        parameters_1.add(160, parameter, parametersParametersParameter);
        parameters.add(161, parameters_1);
        Optional parameters_2 = new Optional(162, "parameters_2");
        Repeat parameters_2_1 = new Repeat(163, "parameters_2_1");
        parameters_2_1.add(165, new Str(164, ","));
        parameters_2_1.add(166, s);
        parameters_2_1.add(167, parameter, parametersParametersParameter);
        parameters_2.add(168, parameters_2_1);
        parameters.add(169, parameters_2);

        // asMethod = s:spaces "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s body
        asMethod.add(170, s, asMethodAsMethodSpaces);
        asMethod.add(172, new Str(171, "public"));
        asMethod.add(173, s);
        asMethod.add(174, name, asMethodAsMethodReturnclass);
        asMethod.add(175, ws);
        ElementList asMethod_1 = new ElementList(176, "asMethod_1", asMethodAsMethodMethodName);
        asMethod_1.add(178, new Str(177, "as"));
        asMethod_1.add(179, name);
        asMethod.add(180, asMethod_1);
        asMethod.add(181, s);
        asMethod.add(183, new Str(182, "("));
        asMethod.add(184, s);
        asMethod.add(185, parameters, asMethodAsMethodParameters);
        asMethod.add(186, s);
        asMethod.add(188, new Str(187, ")"));
        asMethod.add(189, s);
        asMethod.add(190, body, asMethodAsMethodBody);

        // aparameterAttr = ("name"|"value"|"next"|"method"|"signature"):variable s "=" s (name|str):value
        OrList aparameterAttr_1 = new OrList(191, "aparameterAttr_1", aparameterAttrAparameterAttrVariable);
        aparameterAttr_1.add(193, new Str(192, "name"));
        aparameterAttr_1.add(195, new Str(194, "value"));
        aparameterAttr_1.add(197, new Str(196, "next"));
        aparameterAttr_1.add(199, new Str(198, "method"));
        aparameterAttr_1.add(201, new Str(200, "signature"));
        aparameterAttr.add(202, aparameterAttr_1);
        aparameterAttr.add(203, s);
        aparameterAttr.add(205, new Str(204, "="));
        aparameterAttr.add(206, s);
        OrList aparameterAttr_2 = new OrList(207, "aparameterAttr_2", aparameterAttrAparameterAttrValue);
        aparameterAttr_2.add(208, name);
        aparameterAttr_2.add(209, str);
        aparameterAttr.add(210, aparameterAttr_2);

        // aparameter = "@Parameter" s "(" s aparameterAttr [s "," s aparameterAttr]+ s ")"
        aparameter.add(212, new Str(211, "@Parameter"));
        aparameter.add(213, s);
        aparameter.add(215, new Str(214, "("));
        aparameter.add(216, s);
        aparameter.add(217, aparameterAttr, aparameterAparameterAparameterAttr);
        Optional aparameter_1 = new Optional(218, "aparameter_1");
        Repeat aparameter_1_1 = new Repeat(219, "aparameter_1_1");
        aparameter_1_1.add(220, s);
        aparameter_1_1.add(222, new Str(221, ","));
        aparameter_1_1.add(223, s);
        aparameter_1_1.add(224, aparameterAttr, aparameterAparameterAparameterAttr);
        aparameter_1.add(225, aparameter_1_1);
        aparameter.add(226, aparameter_1);
        aparameter.add(227, s);
        aparameter.add(229, new Str(228, ")"));

        // aparameters = s "@Parameters" s "(" s "{" s aparameter [s "," s aparameter]+ s "}" s ")"
        aparameters.add(230, s);
        aparameters.add(232, new Str(231, "@Parameters"));
        aparameters.add(233, s);
        aparameters.add(235, new Str(234, "("));
        aparameters.add(236, s);
        aparameters.add(238, new Str(237, "{"));
        aparameters.add(239, s);
        aparameters.add(240, aparameter, aparametersAparametersAparameter);
        Optional aparameters_1 = new Optional(241, "aparameters_1");
        Repeat aparameters_1_1 = new Repeat(242, "aparameters_1_1");
        aparameters_1_1.add(243, s);
        aparameters_1_1.add(245, new Str(244, ","));
        aparameters_1_1.add(246, s);
        aparameters_1_1.add(247, aparameter, aparametersAparametersAparameter);
        aparameters_1.add(248, aparameters_1_1);
        aparameters.add(249, aparameters_1);
        aparameters.add(250, s);
        aparameters.add(252, new Str(251, "}"));
        aparameters.add(253, s);
        aparameters.add(255, new Str(254, ")"));

        // annotation = "@Creator" [s "(" ["main":main] s ")"]
        annotation.add(257, new Str(256, "@Creator"));
        Optional annotation_1 = new Optional(258, "annotation_1");
        annotation_1.add(259, s);
        annotation_1.add(261, new Str(260, "("));
        Optional annotation_1_1 = new Optional(262, "annotation_1_1");
        annotation_1_1.add(264, new Str(263, "main", creatorAnnotationMain));
        annotation_1.add(265, annotation_1_1);
        annotation_1.add(266, s);
        annotation_1.add(268, new Str(267, ")"));
        annotation.add(269, annotation_1);

        // classStatement =
        //   annotation ws public "class" ws name:classname [s "implements" s name [s "," s name]+] s "{" s
        //   "private final" s name:stateClass s "state;" [asMethod|aparameters]+
        classStatement.add(270, annotation);
        classStatement.add(271, ws);
        classStatement.add(272, _public);
        classStatement.add(274, new Str(273, "class"));
        classStatement.add(275, ws);
        classStatement.add(276, name, classStatementClassStatementClassname);
        Optional classStatement_1 = new Optional(277, "classStatement_1");
        classStatement_1.add(278, s);
        classStatement_1.add(280, new Str(279, "implements"));
        classStatement_1.add(281, s);
        classStatement_1.add(282, name);
        Optional classStatement_1_1 = new Optional(283, "classStatement_1_1");
        Repeat classStatement_1_1_1 = new Repeat(284, "classStatement_1_1_1");
        classStatement_1_1_1.add(285, s);
        classStatement_1_1_1.add(287, new Str(286, ","));
        classStatement_1_1_1.add(288, s);
        classStatement_1_1_1.add(289, name);
        classStatement_1_1.add(290, classStatement_1_1_1);
        classStatement_1.add(291, classStatement_1_1);
        classStatement.add(292, classStatement_1);
        classStatement.add(293, s);
        classStatement.add(295, new Str(294, "{"));
        classStatement.add(296, s);
        classStatement.add(298, new Str(297, "private final"));
        classStatement.add(299, s);
        classStatement.add(300, name, classStatementClassStatementStateClass);
        classStatement.add(301, s);
        classStatement.add(303, new Str(302, "state;"));
        Optional classStatement_2 = new Optional(304, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(305, "classStatement_2_1");
        OrList classStatement_2_1_1 = new OrList(306, "classStatement_2_1_1");
        classStatement_2_1_1.add(307, asMethod, classStatementClassStatementAsMethod);
        classStatement_2_1_1.add(308, aparameters, classStatementClassStatementAparameters);
        classStatement_2_1.add(309, classStatement_2_1_1);
        classStatement_2.add(310, classStatement_2_1);
        classStatement.add(311, classStatement_2);

        // manualEnd = ("}" s END)
        manualEnd.add(313, new Str(312, "}"));
        manualEnd.add(314, s);
        manualEnd.add(316, new End(315, "manualEnd"));

        // generatedCode = "// ===== Generated code ====="

        // manualCode = !(manualEnd | generatedCode)+
        OrList manualCode_1 = new OrList(317, "manualCode_1");
        manualCode_1.add(318, manualEnd);
        manualCode_1.add(319, generatedCode);
        manualCode.add(320, manualCode_1, NOT);

        // creator = packageStatement s imports s classStatement manualCode [generatedCode] *
        creator.add(321, packageStatement, creatorCreatorPackageStatement);
        creator.add(322, s);
        creator.add(323, imports, creatorCreatorImports);
        creator.add(324, s);
        creator.add(325, classStatement, creatorCreatorClassStatement);
        creator.add(326, manualCode, creatorCreatorManualCode);
        Optional creator_1 = new Optional(327, "creator_1");
        creator_1.add(328, generatedCode, creatorCreatorGeneratedCode);
        creator.add(329, creator_1);
        creator.add(331, new Complete(330, "creator"));

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
        ElementList annotation = new ElementList(23, "annotation");
        ElementList classStatement = new ElementList(24, "classStatement");
        ElementList manualEnd = new ElementList(25, "manualEnd");
        Str generatedCode = new Str(26, "// ===== Generated code =====");
        Repeat manualCode = new Repeat(27, "manualCode");
        ElementList creator = new ElementList(28, "creator");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(30, new Str(29, "\r\n"));
        newline.add(32, new Str(31, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(33, "comment_1");
        comment_1.add(35, new Str(34, "/*"));
        Optional comment_1_1 = new Optional(36, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(37, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(38, "comment_1_1_1_1");
        comment_1_1_1_1.add(39, comment);
        comment_1_1_1_1.add(41, new Str(40, "*/", NOT));
        comment_1_1_1.add(42, comment_1_1_1_1);
        comment_1_1.add(43, comment_1_1_1);
        comment_1.add(44, comment_1_1);
        comment_1.add(46, new Str(45, "*/"));
        comment.add(47, comment_1);
        ElementList comment_2 = new ElementList(48, "comment_2");
        comment_2.add(50, new Str(49, "//"));
        Optional comment_2_1 = new Optional(51, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(52, "comment_2_1_1");
        comment_2_1_1.add(53, newline, NOT);
        comment_2_1.add(54, comment_2_1_1);
        comment_2.add(55, comment_2_1);
        OrList comment_2_2 = new OrList(56, "comment_2_2");
        comment_2_2.add(57, newline);
        comment_2_2.add(59, new End(58, "comment_2_2"));
        comment_2.add(60, comment_2_2);
        comment.add(61, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(62, "ws_1");
        ws_1.add(63, newline);
        ws_1.add(65, new Str(64, " "));
        ws_1.add(67, new Str(66, "\t"));
        ws_1.add(68, comment);
        ws.add(69, ws_1);

        // s = [ws]
        s.add(70, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(71, ff);
        Repeat str_1 = new Repeat(72, "str_1");
        OrList str_1_1 = new OrList(73, "str_1_1");
        str_1_1.add(75, new Str(74, "\\\""));
        OrList str_1_1_1 = new OrList(76, "str_1_1_1", NOT);
        str_1_1_1.add(77, ff);
        str_1_1_1.add(78, newline);
        str_1_1.add(79, str_1_1_1);
        str_1.add(80, str_1_1);
        str.add(81, str_1);
        str.add(82, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(84, new Range(83, "letter", "a", "z"));
        letter.add(86, new Range(85, "letter", "A", "Z"));
        letter.add(88, new Str(87, "_"));
        letter.add(90, new Str(89, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(91, letter);
        Optional name_1 = new Optional(92, "name_1");
        Repeat name_1_1 = new Repeat(93, "name_1_1");
        OrList name_1_1_1 = new OrList(94, "name_1_1_1");
        name_1_1_1.add(95, letter);
        name_1_1_1.add(96, digit);
        name_1_1.add(97, name_1_1_1);
        name_1.add(98, name_1_1);
        name.add(99, name_1);

        // public = ["public" ws]
        _public.add(101, new Str(100, "public"));
        _public.add(102, ws);

        // packagename = name ["." name|"*"]+
        packagename.add(103, name);
        Optional packagename_1 = new Optional(104, "packagename_1");
        Repeat packagename_1_1 = new Repeat(105, "packagename_1_1");
        packagename_1_1.add(107, new Str(106, "."));
        OrList packagename_1_1_1 = new OrList(108, "packagename_1_1_1");
        packagename_1_1_1.add(109, name);
        packagename_1_1_1.add(111, new Str(110, "*"));
        packagename_1_1.add(112, packagename_1_1_1);
        packagename_1.add(113, packagename_1_1);
        packagename.add(114, packagename_1);

        // packageStatement = "package" ws packagename s ";"
        packageStatement.add(116, new Str(115, "package"));
        packageStatement.add(117, ws);
        packageStatement.add(118, packagename);
        packageStatement.add(119, s);
        packageStatement.add(121, new Str(120, ";"));

        // fullclassname = packagename
        fullclassname.add(122, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(124, new Str(123, "import"));
        importstatement.add(125, ws);
        Optional importstatement_1 = new Optional(126, "importstatement_1");
        importstatement_1.add(128, new Str(127, "static"));
        importstatement_1.add(129, ws);
        importstatement.add(130, importstatement_1);
        importstatement.add(131, fullclassname);
        importstatement.add(132, s);
        importstatement.add(134, new Str(133, ";"));
        importstatement.add(135, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(136, "imports_1");
        imports_1.add(137, importstatement);
        imports.add(138, imports_1);

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(140, new Str(139, "{"));
        body.add(141, s);
        Optional body_1 = new Optional(142, "body_1");
        Repeat body_1_1 = new Repeat(143, "body_1_1");
        OrList body_1_1_1 = new OrList(144, "body_1_1_1");
        body_1_1_1.add(145, body);
        body_1_1_1.add(146, str);
        body_1_1_1.add(148, new Str(147, "}", NOT));
        body_1_1.add(149, body_1_1_1);
        body_1.add(150, body_1_1);
        body.add(151, body_1);
        body.add(153, new Str(152, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(154, s);
        parameter.add(155, name);
        parameter.add(156, ws);
        parameter.add(157, name);
        parameter.add(158, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(159, "parameters_1");
        parameters_1.add(160, parameter);
        parameters.add(161, parameters_1);
        Optional parameters_2 = new Optional(162, "parameters_2");
        Repeat parameters_2_1 = new Repeat(163, "parameters_2_1");
        parameters_2_1.add(165, new Str(164, ","));
        parameters_2_1.add(166, s);
        parameters_2_1.add(167, parameter);
        parameters_2.add(168, parameters_2_1);
        parameters.add(169, parameters_2);

        // asMethod = s:spaces "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s body
        asMethod.add(170, s);
        asMethod.add(172, new Str(171, "public"));
        asMethod.add(173, s);
        asMethod.add(174, name);
        asMethod.add(175, ws);
        ElementList asMethod_1 = new ElementList(176, "asMethod_1");
        asMethod_1.add(178, new Str(177, "as"));
        asMethod_1.add(179, name);
        asMethod.add(180, asMethod_1);
        asMethod.add(181, s);
        asMethod.add(183, new Str(182, "("));
        asMethod.add(184, s);
        asMethod.add(185, parameters);
        asMethod.add(186, s);
        asMethod.add(188, new Str(187, ")"));
        asMethod.add(189, s);
        asMethod.add(190, body);

        // aparameterAttr = ("name"|"value"|"next"|"method"|"signature"):variable s "=" s (name|str):value
        OrList aparameterAttr_1 = new OrList(191, "aparameterAttr_1");
        aparameterAttr_1.add(193, new Str(192, "name"));
        aparameterAttr_1.add(195, new Str(194, "value"));
        aparameterAttr_1.add(197, new Str(196, "next"));
        aparameterAttr_1.add(199, new Str(198, "method"));
        aparameterAttr_1.add(201, new Str(200, "signature"));
        aparameterAttr.add(202, aparameterAttr_1);
        aparameterAttr.add(203, s);
        aparameterAttr.add(205, new Str(204, "="));
        aparameterAttr.add(206, s);
        OrList aparameterAttr_2 = new OrList(207, "aparameterAttr_2");
        aparameterAttr_2.add(208, name);
        aparameterAttr_2.add(209, str);
        aparameterAttr.add(210, aparameterAttr_2);

        // aparameter = "@Parameter" s "(" s aparameterAttr [s "," s aparameterAttr]+ s ")"
        aparameter.add(212, new Str(211, "@Parameter"));
        aparameter.add(213, s);
        aparameter.add(215, new Str(214, "("));
        aparameter.add(216, s);
        aparameter.add(217, aparameterAttr);
        Optional aparameter_1 = new Optional(218, "aparameter_1");
        Repeat aparameter_1_1 = new Repeat(219, "aparameter_1_1");
        aparameter_1_1.add(220, s);
        aparameter_1_1.add(222, new Str(221, ","));
        aparameter_1_1.add(223, s);
        aparameter_1_1.add(224, aparameterAttr);
        aparameter_1.add(225, aparameter_1_1);
        aparameter.add(226, aparameter_1);
        aparameter.add(227, s);
        aparameter.add(229, new Str(228, ")"));

        // aparameters = s "@Parameters" s "(" s "{" s aparameter [s "," s aparameter]+ s "}" s ")"
        aparameters.add(230, s);
        aparameters.add(232, new Str(231, "@Parameters"));
        aparameters.add(233, s);
        aparameters.add(235, new Str(234, "("));
        aparameters.add(236, s);
        aparameters.add(238, new Str(237, "{"));
        aparameters.add(239, s);
        aparameters.add(240, aparameter);
        Optional aparameters_1 = new Optional(241, "aparameters_1");
        Repeat aparameters_1_1 = new Repeat(242, "aparameters_1_1");
        aparameters_1_1.add(243, s);
        aparameters_1_1.add(245, new Str(244, ","));
        aparameters_1_1.add(246, s);
        aparameters_1_1.add(247, aparameter);
        aparameters_1.add(248, aparameters_1_1);
        aparameters.add(249, aparameters_1);
        aparameters.add(250, s);
        aparameters.add(252, new Str(251, "}"));
        aparameters.add(253, s);
        aparameters.add(255, new Str(254, ")"));

        // annotation = "@Creator" [s "(" ["main":main] s ")"]
        annotation.add(257, new Str(256, "@Creator"));
        Optional annotation_1 = new Optional(258, "annotation_1");
        annotation_1.add(259, s);
        annotation_1.add(261, new Str(260, "("));
        Optional annotation_1_1 = new Optional(262, "annotation_1_1");
        annotation_1_1.add(264, new Str(263, "main"));
        annotation_1.add(265, annotation_1_1);
        annotation_1.add(266, s);
        annotation_1.add(268, new Str(267, ")"));
        annotation.add(269, annotation_1);

        // classStatement =
        //   annotation ws public "class" ws name:classname [s "implements" s name [s "," s name]+] s "{" s
        //   "private final" s name:stateClass s "state;" [asMethod|aparameters]+
        classStatement.add(270, annotation);
        classStatement.add(271, ws);
        classStatement.add(272, _public);
        classStatement.add(274, new Str(273, "class"));
        classStatement.add(275, ws);
        classStatement.add(276, name);
        Optional classStatement_1 = new Optional(277, "classStatement_1");
        classStatement_1.add(278, s);
        classStatement_1.add(280, new Str(279, "implements"));
        classStatement_1.add(281, s);
        classStatement_1.add(282, name);
        Optional classStatement_1_1 = new Optional(283, "classStatement_1_1");
        Repeat classStatement_1_1_1 = new Repeat(284, "classStatement_1_1_1");
        classStatement_1_1_1.add(285, s);
        classStatement_1_1_1.add(287, new Str(286, ","));
        classStatement_1_1_1.add(288, s);
        classStatement_1_1_1.add(289, name);
        classStatement_1_1.add(290, classStatement_1_1_1);
        classStatement_1.add(291, classStatement_1_1);
        classStatement.add(292, classStatement_1);
        classStatement.add(293, s);
        classStatement.add(295, new Str(294, "{"));
        classStatement.add(296, s);
        classStatement.add(298, new Str(297, "private final"));
        classStatement.add(299, s);
        classStatement.add(300, name);
        classStatement.add(301, s);
        classStatement.add(303, new Str(302, "state;"));
        Optional classStatement_2 = new Optional(304, "classStatement_2");
        Repeat classStatement_2_1 = new Repeat(305, "classStatement_2_1");
        OrList classStatement_2_1_1 = new OrList(306, "classStatement_2_1_1");
        classStatement_2_1_1.add(307, asMethod);
        classStatement_2_1_1.add(308, aparameters);
        classStatement_2_1.add(309, classStatement_2_1_1);
        classStatement_2.add(310, classStatement_2_1);
        classStatement.add(311, classStatement_2);

        // manualEnd = ("}" s END)
        manualEnd.add(313, new Str(312, "}"));
        manualEnd.add(314, s);
        manualEnd.add(316, new End(315, "manualEnd"));

        // generatedCode = "// ===== Generated code ====="

        // manualCode = !(manualEnd | generatedCode)+
        OrList manualCode_1 = new OrList(317, "manualCode_1");
        manualCode_1.add(318, manualEnd);
        manualCode_1.add(319, generatedCode);
        manualCode.add(320, manualCode_1, NOT);

        // creator = packageStatement s imports s classStatement manualCode [generatedCode] *
        creator.add(321, packageStatement);
        creator.add(322, s);
        creator.add(323, imports);
        creator.add(324, s);
        creator.add(325, classStatement);
        creator.add(326, manualCode);
        Optional creator_1 = new Optional(327, "creator_1");
        creator_1.add(328, generatedCode);
        creator.add(329, creator_1);
        creator.add(331, new Complete(330, "creator"));

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
