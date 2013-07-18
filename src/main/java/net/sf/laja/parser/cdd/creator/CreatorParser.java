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
 * Auto generated 2013-07-18 by Laja:
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
        Data.ParameterArgClassParameterArgClassAdd parameterArgClassParameterArgClassAdd = data2.new ParameterArgClassParameterArgClassAdd("parameterArgClassParameterArgClassAdd");
        Data.ParameterArgClassParameterArgClassMethod parameterArgClassParameterArgClassMethod = data2.new ParameterArgClassParameterArgClassMethod("parameterArgClassParameterArgClassMethod");
        Data.ParameterArgClassParameterArgClassParameters parameterArgClassParameterArgClassParameters = data2.new ParameterArgClassParameterArgClassParameters("parameterArgClassParameterArgClassParameters");
        Data.ParameterArgClassParameterArgClassValue parameterArgClassParameterArgClassValue = data2.new ParameterArgClassParameterArgClassValue("parameterArgClassParameterArgClassValue");
        Data.ParameterClassParameterClassAttribute parameterClassParameterClassAttribute = data2.new ParameterClassParameterClassAttribute("parameterClassParameterClassAttribute");
        Data.ParameterClassParameterClassParameterArgClass parameterClassParameterClassParameterArgClass = data2.new ParameterClassParameterClassParameterArgClass("parameterClassParameterClassParameterArgClass");
        Data.CreatorCreatorPackageStatement creatorCreatorPackageStatement = data2.new CreatorCreatorPackageStatement("creatorCreatorPackageStatement");
        Data.CreatorCreatorImports creatorCreatorImports = data2.new CreatorCreatorImports("creatorCreatorImports");
        Data.CreatorCreatorClassStatement creatorCreatorClassStatement = data2.new CreatorCreatorClassStatement("creatorCreatorClassStatement");
        Data.CreatorCreatorManualCode creatorCreatorManualCode = data2.new CreatorCreatorManualCode("creatorCreatorManualCode");
        Data.CreatorCreatorGeneratedCode creatorCreatorGeneratedCode = data2.new CreatorCreatorGeneratedCode("creatorCreatorGeneratedCode");
        Data.CreatorCreatorPclass creatorCreatorPclass = data2.new CreatorCreatorPclass("creatorCreatorPclass");
        Data.CreatorCreatorParameterClass creatorCreatorParameterClass = data2.new CreatorCreatorParameterClass("creatorCreatorParameterClass");

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
        ElementList parameterArgClass = new ElementList(29, "parameterArgClass");
        ElementList parameterClass = new ElementList(30, "parameterClass");
        ElementList creator = new ElementList(31, "creator");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(33, new Str(32, "\r\n"));
        newline.add(35, new Str(34, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(36, "comment_1");
        comment_1.add(38, new Str(37, "/*"));
        Optional comment_1_1 = new Optional(39, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(40, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(41, "comment_1_1_1_1");
        comment_1_1_1_1.add(42, comment);
        comment_1_1_1_1.add(44, new Str(43, "*/", NOT));
        comment_1_1_1.add(45, comment_1_1_1_1);
        comment_1_1.add(46, comment_1_1_1);
        comment_1.add(47, comment_1_1);
        comment_1.add(49, new Str(48, "*/"));
        comment.add(50, comment_1);
        ElementList comment_2 = new ElementList(51, "comment_2");
        comment_2.add(53, new Str(52, "//"));
        Optional comment_2_1 = new Optional(54, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(55, "comment_2_1_1");
        comment_2_1_1.add(56, newline, NOT);
        comment_2_1.add(57, comment_2_1_1);
        comment_2.add(58, comment_2_1);
        OrList comment_2_2 = new OrList(59, "comment_2_2");
        comment_2_2.add(60, newline);
        comment_2_2.add(62, new End(61, "comment_2_2"));
        comment_2.add(63, comment_2_2);
        comment.add(64, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(65, "ws_1");
        ws_1.add(66, newline);
        ws_1.add(68, new Str(67, " "));
        ws_1.add(70, new Str(69, "\t"));
        ws_1.add(71, comment);
        ws.add(72, ws_1);

        // s = [ws]
        s.add(73, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(74, ff);
        Repeat str_1 = new Repeat(75, "str_1");
        OrList str_1_1 = new OrList(76, "str_1_1");
        str_1_1.add(78, new Str(77, "\\\""));
        OrList str_1_1_1 = new OrList(79, "str_1_1_1", NOT);
        str_1_1_1.add(80, ff);
        str_1_1_1.add(81, newline);
        str_1_1.add(82, str_1_1_1);
        str_1.add(83, str_1_1);
        str.add(84, str_1);
        str.add(85, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(87, new Range(86, "letter", "a", "z"));
        letter.add(89, new Range(88, "letter", "A", "Z"));
        letter.add(91, new Str(90, "_"));
        letter.add(93, new Str(92, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(94, letter);
        Optional name_1 = new Optional(95, "name_1");
        Repeat name_1_1 = new Repeat(96, "name_1_1");
        OrList name_1_1_1 = new OrList(97, "name_1_1_1");
        name_1_1_1.add(98, letter);
        name_1_1_1.add(99, digit);
        name_1_1.add(100, name_1_1_1);
        name_1.add(101, name_1_1);
        name.add(102, name_1);

        // public = ["public" ws]
        _public.add(104, new Str(103, "public"));
        _public.add(105, ws);

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

        // packageStatement = "package" ws packagename s ";"
        packageStatement.add(119, new Str(118, "package"));
        packageStatement.add(120, ws);
        packageStatement.add(121, packagename, packageStatementPackageStatementPackagename);
        packageStatement.add(122, s);
        packageStatement.add(124, new Str(123, ";"));

        // fullclassname = packagename
        fullclassname.add(125, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(127, new Str(126, "import"));
        importstatement.add(128, ws);
        Optional importstatement_1 = new Optional(129, "importstatement_1");
        importstatement_1.add(131, new Str(130, "static"));
        importstatement_1.add(132, ws);
        importstatement.add(133, importstatement_1);
        importstatement.add(134, fullclassname);
        importstatement.add(135, s);
        importstatement.add(137, new Str(136, ";"));
        importstatement.add(138, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(139, "imports_1");
        imports_1.add(140, importstatement);
        imports.add(141, imports_1);

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(143, new Str(142, "{"));
        body.add(144, s);
        Optional body_1 = new Optional(145, "body_1");
        Repeat body_1_1 = new Repeat(146, "body_1_1");
        OrList body_1_1_1 = new OrList(147, "body_1_1_1");
        body_1_1_1.add(148, body);
        body_1_1_1.add(149, str);
        body_1_1_1.add(151, new Str(150, "}", NOT));
        body_1_1.add(152, body_1_1_1);
        body_1.add(153, body_1_1);
        body.add(154, body_1);
        body.add(156, new Str(155, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(157, s);
        parameter.add(158, name, parameterParameterType);
        parameter.add(159, ws);
        parameter.add(160, name, parameterParameterVariable);
        parameter.add(161, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(162, "parameters_1");
        parameters_1.add(163, parameter, parametersParametersParameter);
        parameters.add(164, parameters_1);
        Optional parameters_2 = new Optional(165, "parameters_2");
        Repeat parameters_2_1 = new Repeat(166, "parameters_2_1");
        parameters_2_1.add(168, new Str(167, ","));
        parameters_2_1.add(169, s);
        parameters_2_1.add(170, parameter, parametersParametersParameter);
        parameters_2.add(171, parameters_2_1);
        parameters.add(172, parameters_2);

        // asMethod = s:spaces "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s body
        asMethod.add(173, s, asMethodAsMethodSpaces);
        asMethod.add(175, new Str(174, "public"));
        asMethod.add(176, s);
        asMethod.add(177, name, asMethodAsMethodReturnclass);
        asMethod.add(178, ws);
        ElementList asMethod_1 = new ElementList(179, "asMethod_1", asMethodAsMethodMethodName);
        asMethod_1.add(181, new Str(180, "as"));
        asMethod_1.add(182, name);
        asMethod.add(183, asMethod_1);
        asMethod.add(184, s);
        asMethod.add(186, new Str(185, "("));
        asMethod.add(187, s);
        asMethod.add(188, parameters, asMethodAsMethodParameters);
        asMethod.add(189, s);
        asMethod.add(191, new Str(190, ")"));
        asMethod.add(192, s);
        asMethod.add(193, body, asMethodAsMethodBody);

        // aparameterAttr = name:variable s "=" s (name|str):value
        aparameterAttr.add(194, name, aparameterAttrAparameterAttrVariable);
        aparameterAttr.add(195, s);
        aparameterAttr.add(197, new Str(196, "="));
        aparameterAttr.add(198, s);
        OrList aparameterAttr_1 = new OrList(199, "aparameterAttr_1", aparameterAttrAparameterAttrValue);
        aparameterAttr_1.add(200, name);
        aparameterAttr_1.add(201, str);
        aparameterAttr.add(202, aparameterAttr_1);

        // aparameter = "@Parameter" s "(" s aparameterAttr [s "," s aparameterAttr]+ s ")"
        aparameter.add(204, new Str(203, "@Parameter"));
        aparameter.add(205, s);
        aparameter.add(207, new Str(206, "("));
        aparameter.add(208, s);
        aparameter.add(209, aparameterAttr, aparameterAparameterAparameterAttr);
        Optional aparameter_1 = new Optional(210, "aparameter_1");
        Repeat aparameter_1_1 = new Repeat(211, "aparameter_1_1");
        aparameter_1_1.add(212, s);
        aparameter_1_1.add(214, new Str(213, ","));
        aparameter_1_1.add(215, s);
        aparameter_1_1.add(216, aparameterAttr, aparameterAparameterAparameterAttr);
        aparameter_1.add(217, aparameter_1_1);
        aparameter.add(218, aparameter_1);
        aparameter.add(219, s);
        aparameter.add(221, new Str(220, ")"));

        // aparameters = s "@Parameters" s "(" s "{" s aparameter [s "," s aparameter]+ s "}" s ")"
        aparameters.add(222, s);
        aparameters.add(224, new Str(223, "@Parameters"));
        aparameters.add(225, s);
        aparameters.add(227, new Str(226, "("));
        aparameters.add(228, s);
        aparameters.add(230, new Str(229, "{"));
        aparameters.add(231, s);
        aparameters.add(232, aparameter, aparametersAparametersAparameter);
        Optional aparameters_1 = new Optional(233, "aparameters_1");
        Repeat aparameters_1_1 = new Repeat(234, "aparameters_1_1");
        aparameters_1_1.add(235, s);
        aparameters_1_1.add(237, new Str(236, ","));
        aparameters_1_1.add(238, s);
        aparameters_1_1.add(239, aparameter, aparametersAparametersAparameter);
        aparameters_1.add(240, aparameters_1_1);
        aparameters.add(241, aparameters_1);
        aparameters.add(242, s);
        aparameters.add(244, new Str(243, "}"));
        aparameters.add(245, s);
        aparameters.add(247, new Str(246, ")"));

        // keywords = ["private"|"public"|"static"|"final" s]+
        Repeat keywords_1 = new Repeat(248, "keywords_1");
        OrList keywords_1_1 = new OrList(249, "keywords_1_1");
        keywords_1_1.add(251, new Str(250, "private"));
        keywords_1_1.add(253, new Str(252, "public"));
        keywords_1_1.add(255, new Str(254, "static"));
        keywords_1_1.add(257, new Str(256, "final"));
        keywords_1.add(258, keywords_1_1);
        keywords_1.add(259, s);
        keywords.add(260, keywords_1);

        // annotation = "@Creator" [s "(" ["main":main] s ")"]
        annotation.add(262, new Str(261, "@Creator"));
        Optional annotation_1 = new Optional(263, "annotation_1");
        annotation_1.add(264, s);
        annotation_1.add(266, new Str(265, "("));
        Optional annotation_1_1 = new Optional(267, "annotation_1_1");
        annotation_1_1.add(269, new Str(268, "main", creatorAnnotationMain));
        annotation_1.add(270, annotation_1_1);
        annotation_1.add(271, s);
        annotation_1.add(273, new Str(272, ")"));
        annotation.add(274, annotation_1);

        // classStatement =
        //   [annotation ws] public "class" ws name:classname [s "implements" s name [s "," s name]+] s "{" s
        //   keywords s [name s "." s] name:stateClass s "state;" [asMethod|aparameters]+
        Optional classStatement_1 = new Optional(275, "classStatement_1");
        classStatement_1.add(276, annotation);
        classStatement_1.add(277, ws);
        classStatement.add(278, classStatement_1);
        classStatement.add(279, _public);
        classStatement.add(281, new Str(280, "class"));
        classStatement.add(282, ws);
        classStatement.add(283, name, classStatementClassStatementClassname);
        Optional classStatement_2 = new Optional(284, "classStatement_2");
        classStatement_2.add(285, s);
        classStatement_2.add(287, new Str(286, "implements"));
        classStatement_2.add(288, s);
        classStatement_2.add(289, name);
        Optional classStatement_2_1 = new Optional(290, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(291, "classStatement_2_1_1");
        classStatement_2_1_1.add(292, s);
        classStatement_2_1_1.add(294, new Str(293, ","));
        classStatement_2_1_1.add(295, s);
        classStatement_2_1_1.add(296, name);
        classStatement_2_1.add(297, classStatement_2_1_1);
        classStatement_2.add(298, classStatement_2_1);
        classStatement.add(299, classStatement_2);
        classStatement.add(300, s);
        classStatement.add(302, new Str(301, "{"));
        classStatement.add(303, s);
        classStatement.add(304, keywords);
        classStatement.add(305, s);
        Optional classStatement_3 = new Optional(306, "classStatement_3");
        classStatement_3.add(307, name);
        classStatement_3.add(308, s);
        classStatement_3.add(310, new Str(309, "."));
        classStatement_3.add(311, s);
        classStatement.add(312, classStatement_3);
        classStatement.add(313, name, classStatementClassStatementStateClass);
        classStatement.add(314, s);
        classStatement.add(316, new Str(315, "state;"));
        Optional classStatement_4 = new Optional(317, "classStatement_4");
        Repeat classStatement_4_1 = new Repeat(318, "classStatement_4_1");
        OrList classStatement_4_1_1 = new OrList(319, "classStatement_4_1_1");
        classStatement_4_1_1.add(320, asMethod, classStatementClassStatementAsMethod);
        classStatement_4_1_1.add(321, aparameters, classStatementClassStatementAparameters);
        classStatement_4_1.add(322, classStatement_4_1_1);
        classStatement_4.add(323, classStatement_4_1);
        classStatement.add(324, classStatement_4);

        // manualEnd = ("}" s END)
        manualEnd.add(326, new Str(325, "}"));
        manualEnd.add(327, s);
        manualEnd.add(329, new End(328, "manualEnd"));

        // generatedCode = "// ===== Generated code ====="

        // manualCode = !(manualEnd | generatedCode)+
        OrList manualCode_1 = new OrList(330, "manualCode_1");
        manualCode_1.add(331, manualEnd);
        manualCode_1.add(332, generatedCode);
        manualCode.add(333, manualCode_1, NOT);

        // parameterArgClass =
        //   [newline | " " | "\t"]+ ["// add":add] s "public " name " " name:method
        //   "(" s parameters s ")" s "{" s "state." name " = " (!";"+):value ";" [!"}"+] "}"
        Optional parameterArgClass_1 = new Optional(334, "parameterArgClass_1");
        Repeat parameterArgClass_1_1 = new Repeat(335, "parameterArgClass_1_1");
        OrList parameterArgClass_1_1_1 = new OrList(336, "parameterArgClass_1_1_1");
        parameterArgClass_1_1_1.add(337, newline);
        parameterArgClass_1_1_1.add(339, new Str(338, " "));
        parameterArgClass_1_1_1.add(341, new Str(340, "\t"));
        parameterArgClass_1_1.add(342, parameterArgClass_1_1_1);
        parameterArgClass_1.add(343, parameterArgClass_1_1);
        parameterArgClass.add(344, parameterArgClass_1);
        Optional parameterArgClass_2 = new Optional(345, "parameterArgClass_2");
        parameterArgClass_2.add(347, new Str(346, "// add", parameterArgClassParameterArgClassAdd));
        parameterArgClass.add(348, parameterArgClass_2);
        parameterArgClass.add(349, s);
        parameterArgClass.add(351, new Str(350, "public "));
        parameterArgClass.add(352, name);
        parameterArgClass.add(354, new Str(353, " "));
        parameterArgClass.add(355, name, parameterArgClassParameterArgClassMethod);
        parameterArgClass.add(357, new Str(356, "("));
        parameterArgClass.add(358, s);
        parameterArgClass.add(359, parameters, parameterArgClassParameterArgClassParameters);
        parameterArgClass.add(360, s);
        parameterArgClass.add(362, new Str(361, ")"));
        parameterArgClass.add(363, s);
        parameterArgClass.add(365, new Str(364, "{"));
        parameterArgClass.add(366, s);
        parameterArgClass.add(368, new Str(367, "state."));
        parameterArgClass.add(369, name);
        parameterArgClass.add(371, new Str(370, " = "));
        Repeat parameterArgClass_3 = new Repeat(372, "parameterArgClass_3", parameterArgClassParameterArgClassValue);
        parameterArgClass_3.add(374, new Str(373, ";", NOT));
        parameterArgClass.add(375, parameterArgClass_3);
        parameterArgClass.add(377, new Str(376, ";"));
        Optional parameterArgClass_4 = new Optional(378, "parameterArgClass_4");
        Repeat parameterArgClass_4_1 = new Repeat(379, "parameterArgClass_4_1");
        parameterArgClass_4_1.add(381, new Str(380, "}", NOT));
        parameterArgClass_4.add(382, parameterArgClass_4_1);
        parameterArgClass.add(383, parameterArgClass_4);
        parameterArgClass.add(385, new Str(384, "}"));

        // parameterClass = "// " name:attribute s "public class " name " {" parameterArgClass+ s "}"
        parameterClass.add(387, new Str(386, "// "));
        parameterClass.add(388, name, parameterClassParameterClassAttribute);
        parameterClass.add(389, s);
        parameterClass.add(391, new Str(390, "public class "));
        parameterClass.add(392, name);
        parameterClass.add(394, new Str(393, " {"));
        Repeat parameterClass_1 = new Repeat(395, "parameterClass_1");
        parameterClass_1.add(396, parameterArgClass, parameterClassParameterClassParameterArgClass);
        parameterClass.add(397, parameterClass_1);
        parameterClass.add(398, s);
        parameterClass.add(400, new Str(399, "}"));

        // creator = packageStatement s imports s classStatement manualCode [generatedCode [!parameterClass+ parameterClass:pclass]+] *
        creator.add(401, packageStatement, creatorCreatorPackageStatement);
        creator.add(402, s);
        creator.add(403, imports, creatorCreatorImports);
        creator.add(404, s);
        creator.add(405, classStatement, creatorCreatorClassStatement);
        creator.add(406, manualCode, creatorCreatorManualCode);
        Optional creator_1 = new Optional(407, "creator_1");
        creator_1.add(408, generatedCode, creatorCreatorGeneratedCode);
        Optional creator_1_1 = new Optional(409, "creator_1_1");
        Repeat creator_1_1_1 = new Repeat(410, "creator_1_1_1");
        Repeat creator_1_1_1_1 = new Repeat(411, "creator_1_1_1_1");
        creator_1_1_1_1.add(412, parameterClass, NOT, creatorCreatorParameterClass);
        creator_1_1_1.add(413, creator_1_1_1_1);
        creator_1_1_1.add(414, parameterClass, creatorCreatorPclass);
        creator_1_1.add(415, creator_1_1_1);
        creator_1.add(416, creator_1_1);
        creator.add(417, creator_1);
        creator.add(419, new Complete(418, "creator"));

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
        ElementList parameterArgClass = new ElementList(29, "parameterArgClass");
        ElementList parameterClass = new ElementList(30, "parameterClass");
        ElementList creator = new ElementList(31, "creator");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(33, new Str(32, "\r\n"));
        newline.add(35, new Str(34, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(36, "comment_1");
        comment_1.add(38, new Str(37, "/*"));
        Optional comment_1_1 = new Optional(39, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(40, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(41, "comment_1_1_1_1");
        comment_1_1_1_1.add(42, comment);
        comment_1_1_1_1.add(44, new Str(43, "*/", NOT));
        comment_1_1_1.add(45, comment_1_1_1_1);
        comment_1_1.add(46, comment_1_1_1);
        comment_1.add(47, comment_1_1);
        comment_1.add(49, new Str(48, "*/"));
        comment.add(50, comment_1);
        ElementList comment_2 = new ElementList(51, "comment_2");
        comment_2.add(53, new Str(52, "//"));
        Optional comment_2_1 = new Optional(54, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(55, "comment_2_1_1");
        comment_2_1_1.add(56, newline, NOT);
        comment_2_1.add(57, comment_2_1_1);
        comment_2.add(58, comment_2_1);
        OrList comment_2_2 = new OrList(59, "comment_2_2");
        comment_2_2.add(60, newline);
        comment_2_2.add(62, new End(61, "comment_2_2"));
        comment_2.add(63, comment_2_2);
        comment.add(64, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(65, "ws_1");
        ws_1.add(66, newline);
        ws_1.add(68, new Str(67, " "));
        ws_1.add(70, new Str(69, "\t"));
        ws_1.add(71, comment);
        ws.add(72, ws_1);

        // s = [ws]
        s.add(73, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(74, ff);
        Repeat str_1 = new Repeat(75, "str_1");
        OrList str_1_1 = new OrList(76, "str_1_1");
        str_1_1.add(78, new Str(77, "\\\""));
        OrList str_1_1_1 = new OrList(79, "str_1_1_1", NOT);
        str_1_1_1.add(80, ff);
        str_1_1_1.add(81, newline);
        str_1_1.add(82, str_1_1_1);
        str_1.add(83, str_1_1);
        str.add(84, str_1);
        str.add(85, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(87, new Range(86, "letter", "a", "z"));
        letter.add(89, new Range(88, "letter", "A", "Z"));
        letter.add(91, new Str(90, "_"));
        letter.add(93, new Str(92, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(94, letter);
        Optional name_1 = new Optional(95, "name_1");
        Repeat name_1_1 = new Repeat(96, "name_1_1");
        OrList name_1_1_1 = new OrList(97, "name_1_1_1");
        name_1_1_1.add(98, letter);
        name_1_1_1.add(99, digit);
        name_1_1.add(100, name_1_1_1);
        name_1.add(101, name_1_1);
        name.add(102, name_1);

        // public = ["public" ws]
        _public.add(104, new Str(103, "public"));
        _public.add(105, ws);

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

        // packageStatement = "package" ws packagename s ";"
        packageStatement.add(119, new Str(118, "package"));
        packageStatement.add(120, ws);
        packageStatement.add(121, packagename);
        packageStatement.add(122, s);
        packageStatement.add(124, new Str(123, ";"));

        // fullclassname = packagename
        fullclassname.add(125, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(127, new Str(126, "import"));
        importstatement.add(128, ws);
        Optional importstatement_1 = new Optional(129, "importstatement_1");
        importstatement_1.add(131, new Str(130, "static"));
        importstatement_1.add(132, ws);
        importstatement.add(133, importstatement_1);
        importstatement.add(134, fullclassname);
        importstatement.add(135, s);
        importstatement.add(137, new Str(136, ";"));
        importstatement.add(138, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(139, "imports_1");
        imports_1.add(140, importstatement);
        imports.add(141, imports_1);

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(143, new Str(142, "{"));
        body.add(144, s);
        Optional body_1 = new Optional(145, "body_1");
        Repeat body_1_1 = new Repeat(146, "body_1_1");
        OrList body_1_1_1 = new OrList(147, "body_1_1_1");
        body_1_1_1.add(148, body);
        body_1_1_1.add(149, str);
        body_1_1_1.add(151, new Str(150, "}", NOT));
        body_1_1.add(152, body_1_1_1);
        body_1.add(153, body_1_1);
        body.add(154, body_1);
        body.add(156, new Str(155, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(157, s);
        parameter.add(158, name);
        parameter.add(159, ws);
        parameter.add(160, name);
        parameter.add(161, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(162, "parameters_1");
        parameters_1.add(163, parameter);
        parameters.add(164, parameters_1);
        Optional parameters_2 = new Optional(165, "parameters_2");
        Repeat parameters_2_1 = new Repeat(166, "parameters_2_1");
        parameters_2_1.add(168, new Str(167, ","));
        parameters_2_1.add(169, s);
        parameters_2_1.add(170, parameter);
        parameters_2.add(171, parameters_2_1);
        parameters.add(172, parameters_2);

        // asMethod = s:spaces "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s body
        asMethod.add(173, s);
        asMethod.add(175, new Str(174, "public"));
        asMethod.add(176, s);
        asMethod.add(177, name);
        asMethod.add(178, ws);
        ElementList asMethod_1 = new ElementList(179, "asMethod_1");
        asMethod_1.add(181, new Str(180, "as"));
        asMethod_1.add(182, name);
        asMethod.add(183, asMethod_1);
        asMethod.add(184, s);
        asMethod.add(186, new Str(185, "("));
        asMethod.add(187, s);
        asMethod.add(188, parameters);
        asMethod.add(189, s);
        asMethod.add(191, new Str(190, ")"));
        asMethod.add(192, s);
        asMethod.add(193, body);

        // aparameterAttr = name:variable s "=" s (name|str):value
        aparameterAttr.add(194, name);
        aparameterAttr.add(195, s);
        aparameterAttr.add(197, new Str(196, "="));
        aparameterAttr.add(198, s);
        OrList aparameterAttr_1 = new OrList(199, "aparameterAttr_1");
        aparameterAttr_1.add(200, name);
        aparameterAttr_1.add(201, str);
        aparameterAttr.add(202, aparameterAttr_1);

        // aparameter = "@Parameter" s "(" s aparameterAttr [s "," s aparameterAttr]+ s ")"
        aparameter.add(204, new Str(203, "@Parameter"));
        aparameter.add(205, s);
        aparameter.add(207, new Str(206, "("));
        aparameter.add(208, s);
        aparameter.add(209, aparameterAttr);
        Optional aparameter_1 = new Optional(210, "aparameter_1");
        Repeat aparameter_1_1 = new Repeat(211, "aparameter_1_1");
        aparameter_1_1.add(212, s);
        aparameter_1_1.add(214, new Str(213, ","));
        aparameter_1_1.add(215, s);
        aparameter_1_1.add(216, aparameterAttr);
        aparameter_1.add(217, aparameter_1_1);
        aparameter.add(218, aparameter_1);
        aparameter.add(219, s);
        aparameter.add(221, new Str(220, ")"));

        // aparameters = s "@Parameters" s "(" s "{" s aparameter [s "," s aparameter]+ s "}" s ")"
        aparameters.add(222, s);
        aparameters.add(224, new Str(223, "@Parameters"));
        aparameters.add(225, s);
        aparameters.add(227, new Str(226, "("));
        aparameters.add(228, s);
        aparameters.add(230, new Str(229, "{"));
        aparameters.add(231, s);
        aparameters.add(232, aparameter);
        Optional aparameters_1 = new Optional(233, "aparameters_1");
        Repeat aparameters_1_1 = new Repeat(234, "aparameters_1_1");
        aparameters_1_1.add(235, s);
        aparameters_1_1.add(237, new Str(236, ","));
        aparameters_1_1.add(238, s);
        aparameters_1_1.add(239, aparameter);
        aparameters_1.add(240, aparameters_1_1);
        aparameters.add(241, aparameters_1);
        aparameters.add(242, s);
        aparameters.add(244, new Str(243, "}"));
        aparameters.add(245, s);
        aparameters.add(247, new Str(246, ")"));

        // keywords = ["private"|"public"|"static"|"final" s]+
        Repeat keywords_1 = new Repeat(248, "keywords_1");
        OrList keywords_1_1 = new OrList(249, "keywords_1_1");
        keywords_1_1.add(251, new Str(250, "private"));
        keywords_1_1.add(253, new Str(252, "public"));
        keywords_1_1.add(255, new Str(254, "static"));
        keywords_1_1.add(257, new Str(256, "final"));
        keywords_1.add(258, keywords_1_1);
        keywords_1.add(259, s);
        keywords.add(260, keywords_1);

        // annotation = "@Creator" [s "(" ["main":main] s ")"]
        annotation.add(262, new Str(261, "@Creator"));
        Optional annotation_1 = new Optional(263, "annotation_1");
        annotation_1.add(264, s);
        annotation_1.add(266, new Str(265, "("));
        Optional annotation_1_1 = new Optional(267, "annotation_1_1");
        annotation_1_1.add(269, new Str(268, "main"));
        annotation_1.add(270, annotation_1_1);
        annotation_1.add(271, s);
        annotation_1.add(273, new Str(272, ")"));
        annotation.add(274, annotation_1);

        // classStatement =
        //   [annotation ws] public "class" ws name:classname [s "implements" s name [s "," s name]+] s "{" s
        //   keywords s [name s "." s] name:stateClass s "state;" [asMethod|aparameters]+
        Optional classStatement_1 = new Optional(275, "classStatement_1");
        classStatement_1.add(276, annotation);
        classStatement_1.add(277, ws);
        classStatement.add(278, classStatement_1);
        classStatement.add(279, _public);
        classStatement.add(281, new Str(280, "class"));
        classStatement.add(282, ws);
        classStatement.add(283, name);
        Optional classStatement_2 = new Optional(284, "classStatement_2");
        classStatement_2.add(285, s);
        classStatement_2.add(287, new Str(286, "implements"));
        classStatement_2.add(288, s);
        classStatement_2.add(289, name);
        Optional classStatement_2_1 = new Optional(290, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(291, "classStatement_2_1_1");
        classStatement_2_1_1.add(292, s);
        classStatement_2_1_1.add(294, new Str(293, ","));
        classStatement_2_1_1.add(295, s);
        classStatement_2_1_1.add(296, name);
        classStatement_2_1.add(297, classStatement_2_1_1);
        classStatement_2.add(298, classStatement_2_1);
        classStatement.add(299, classStatement_2);
        classStatement.add(300, s);
        classStatement.add(302, new Str(301, "{"));
        classStatement.add(303, s);
        classStatement.add(304, keywords);
        classStatement.add(305, s);
        Optional classStatement_3 = new Optional(306, "classStatement_3");
        classStatement_3.add(307, name);
        classStatement_3.add(308, s);
        classStatement_3.add(310, new Str(309, "."));
        classStatement_3.add(311, s);
        classStatement.add(312, classStatement_3);
        classStatement.add(313, name);
        classStatement.add(314, s);
        classStatement.add(316, new Str(315, "state;"));
        Optional classStatement_4 = new Optional(317, "classStatement_4");
        Repeat classStatement_4_1 = new Repeat(318, "classStatement_4_1");
        OrList classStatement_4_1_1 = new OrList(319, "classStatement_4_1_1");
        classStatement_4_1_1.add(320, asMethod);
        classStatement_4_1_1.add(321, aparameters);
        classStatement_4_1.add(322, classStatement_4_1_1);
        classStatement_4.add(323, classStatement_4_1);
        classStatement.add(324, classStatement_4);

        // manualEnd = ("}" s END)
        manualEnd.add(326, new Str(325, "}"));
        manualEnd.add(327, s);
        manualEnd.add(329, new End(328, "manualEnd"));

        // generatedCode = "// ===== Generated code ====="

        // manualCode = !(manualEnd | generatedCode)+
        OrList manualCode_1 = new OrList(330, "manualCode_1");
        manualCode_1.add(331, manualEnd);
        manualCode_1.add(332, generatedCode);
        manualCode.add(333, manualCode_1, NOT);

        // parameterArgClass =
        //   [newline | " " | "\t"]+ ["// add":add] s "public " name " " name:method
        //   "(" s parameters s ")" s "{" s "state." name " = " (!";"+):value ";" [!"}"+] "}"
        Optional parameterArgClass_1 = new Optional(334, "parameterArgClass_1");
        Repeat parameterArgClass_1_1 = new Repeat(335, "parameterArgClass_1_1");
        OrList parameterArgClass_1_1_1 = new OrList(336, "parameterArgClass_1_1_1");
        parameterArgClass_1_1_1.add(337, newline);
        parameterArgClass_1_1_1.add(339, new Str(338, " "));
        parameterArgClass_1_1_1.add(341, new Str(340, "\t"));
        parameterArgClass_1_1.add(342, parameterArgClass_1_1_1);
        parameterArgClass_1.add(343, parameterArgClass_1_1);
        parameterArgClass.add(344, parameterArgClass_1);
        Optional parameterArgClass_2 = new Optional(345, "parameterArgClass_2");
        parameterArgClass_2.add(347, new Str(346, "// add"));
        parameterArgClass.add(348, parameterArgClass_2);
        parameterArgClass.add(349, s);
        parameterArgClass.add(351, new Str(350, "public "));
        parameterArgClass.add(352, name);
        parameterArgClass.add(354, new Str(353, " "));
        parameterArgClass.add(355, name);
        parameterArgClass.add(357, new Str(356, "("));
        parameterArgClass.add(358, s);
        parameterArgClass.add(359, parameters);
        parameterArgClass.add(360, s);
        parameterArgClass.add(362, new Str(361, ")"));
        parameterArgClass.add(363, s);
        parameterArgClass.add(365, new Str(364, "{"));
        parameterArgClass.add(366, s);
        parameterArgClass.add(368, new Str(367, "state."));
        parameterArgClass.add(369, name);
        parameterArgClass.add(371, new Str(370, " = "));
        Repeat parameterArgClass_3 = new Repeat(372, "parameterArgClass_3");
        parameterArgClass_3.add(374, new Str(373, ";", NOT));
        parameterArgClass.add(375, parameterArgClass_3);
        parameterArgClass.add(377, new Str(376, ";"));
        Optional parameterArgClass_4 = new Optional(378, "parameterArgClass_4");
        Repeat parameterArgClass_4_1 = new Repeat(379, "parameterArgClass_4_1");
        parameterArgClass_4_1.add(381, new Str(380, "}", NOT));
        parameterArgClass_4.add(382, parameterArgClass_4_1);
        parameterArgClass.add(383, parameterArgClass_4);
        parameterArgClass.add(385, new Str(384, "}"));

        // parameterClass = "// " name:attribute s "public class " name " {" parameterArgClass+ s "}"
        parameterClass.add(387, new Str(386, "// "));
        parameterClass.add(388, name);
        parameterClass.add(389, s);
        parameterClass.add(391, new Str(390, "public class "));
        parameterClass.add(392, name);
        parameterClass.add(394, new Str(393, " {"));
        Repeat parameterClass_1 = new Repeat(395, "parameterClass_1");
        parameterClass_1.add(396, parameterArgClass);
        parameterClass.add(397, parameterClass_1);
        parameterClass.add(398, s);
        parameterClass.add(400, new Str(399, "}"));

        // creator = packageStatement s imports s classStatement manualCode [generatedCode [!parameterClass+ parameterClass:pclass]+] *
        creator.add(401, packageStatement);
        creator.add(402, s);
        creator.add(403, imports);
        creator.add(404, s);
        creator.add(405, classStatement);
        creator.add(406, manualCode);
        Optional creator_1 = new Optional(407, "creator_1");
        creator_1.add(408, generatedCode);
        Optional creator_1_1 = new Optional(409, "creator_1_1");
        Repeat creator_1_1_1 = new Repeat(410, "creator_1_1_1");
        Repeat creator_1_1_1_1 = new Repeat(411, "creator_1_1_1_1");
        creator_1_1_1_1.add(412, parameterClass, NOT);
        creator_1_1_1.add(413, creator_1_1_1_1);
        creator_1_1_1.add(414, parameterClass);
        creator_1_1.add(415, creator_1_1_1);
        creator_1.add(416, creator_1_1);
        creator.add(417, creator_1);
        creator.add(419, new Complete(418, "creator"));

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
        CreatorParser.IParameterArgClass createParameterArgClass();
        CreatorParser.IParameterClass createParameterClass();
        CreatorParser.IParameterClasses createParameterClasses();
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

    // ParameterArgClass
    public interface IParameterArgClass {
        public void setAdd();
        public void setMethod(String method);
        public void setMethodSignature(String parameters);
        public void setValue(String value);
    }

    // ParameterClass
    public interface IParameterClass {
        public void setAttribute(String attribute);
        public void addArgument(IParameterArgClass iparameterArgClass);
    }

    // ParameterClasses
    public interface IParameterClasses {
    }

    // Creator
    public interface ICreator {
        public void setPackageStatement(IPackageStatement ipackageStatement);
        public void setImports(String imports);
        public void setClassStatement(IClassStatement iclassStatement);
        public void setManualCode(String manualCode);
        public void setGeneratedCode();
        public void setIsMainCreator();
        public void addParameterClass(IParameterClass ipclass);
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
        private Stack<IParameterArgClass> parameterArgClassStack = new Stack<IParameterArgClass>();
        private Stack<IParameterClass> parameterClassStack = new Stack<IParameterClass>();
        private Stack<IParameterClasses> parameterClassesStack = new Stack<IParameterClasses>();
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

        // ParameterArgClass
        public void pushParameterArgClass() { parameterArgClassStack.push(factory.createParameterArgClass()); }
        public CreatorParser.IParameterArgClass popParameterArgClass() { return (CreatorParser.IParameterArgClass)parameterArgClassStack.pop(); }
        public CreatorParser.IParameterArgClass peekParameterArgClass() {
            if (parameterArgClassStack.empty()) { return null; }
            return parameterArgClassStack.peek();
        }

        // ParameterClass
        public void pushParameterClass() { parameterClassStack.push(factory.createParameterClass()); }
        public CreatorParser.IParameterClass popParameterClass() { return (CreatorParser.IParameterClass)parameterClassStack.pop(); }
        public CreatorParser.IParameterClass peekParameterClass() {
            if (parameterClassStack.empty()) { return null; }
            return parameterClassStack.peek();
        }

        // ParameterClasses
        public void pushParameterClasses() { parameterClassesStack.push(factory.createParameterClasses()); }
        public CreatorParser.IParameterClasses popParameterClasses() { return (CreatorParser.IParameterClasses)parameterClassesStack.pop(); }
        public CreatorParser.IParameterClasses peekParameterClasses() {
            if (parameterClassesStack.empty()) { return null; }
            return parameterClassesStack.peek();
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

        // ParameterArgClass parameterArgClass.setAdd(void add);
        public class ParameterArgClassParameterArgClassAdd implements Output {
            private String name;
            public ParameterArgClassParameterArgClassAdd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekParameterArgClass().setAdd();
            }
        }

        // parameterArgClass.setMethod(String method);
        public class ParameterArgClassParameterArgClassMethod implements Output {
            private String name;
            public ParameterArgClassParameterArgClassMethod(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekParameterArgClass().setMethod(source.get(bookmark));
            }
        }

        // parameterArgClass.setMethodSignature(String parameters);
        public class ParameterArgClassParameterArgClassParameters implements Output {
            private String name;
            public ParameterArgClassParameterArgClassParameters(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushParameters(); }
            public void set(Source source, int bookmark) {
                popParameters();
                peekParameterArgClass().setMethodSignature(source.get(bookmark));
            }
        }

        // parameterArgClass.setValue(String value);
        public class ParameterArgClassParameterArgClassValue implements Output {
            private String name;
            public ParameterArgClassParameterArgClassValue(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekParameterArgClass().setValue(source.get(bookmark));
            }
        }

        // ParameterClass parameterClass.setAttribute(String attribute);
        public class ParameterClassParameterClassAttribute implements Output {
            private String name;
            public ParameterClassParameterClassAttribute(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekParameterClass().setAttribute(source.get(bookmark));
            }
        }

        // parameterClass.addArgument(ParameterArgClass parameterArgClass);
        public class ParameterClassParameterClassParameterArgClass implements Output {
            private String name;
            public ParameterClassParameterClassParameterArgClass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushParameterArgClass(); }
            public void set(Source source, int bookmark) {
                peekParameterClass().addArgument(popParameterArgClass());
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

        // creator.addParameterClass(ParameterClass pclass);
        public class CreatorCreatorPclass implements Output {
            private String name;
            public CreatorCreatorPclass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushParameterClass(); }
            public void set(Source source, int bookmark) {
                peekCreator().addParameterClass(popParameterClass());
            }
        }

        public class CreatorCreatorParameterClass implements Output {
            private String name;
            public CreatorCreatorParameterClass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushParameterClass(); }
            public void set(Source source, int bookmark) {
                popParameterClass();
            }
        }
    }
}
