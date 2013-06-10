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
 * Auto generated 2013-06-09 by Laja:
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
        Data.AparametersAparameters aparametersAparameters = data2.new AparametersAparameters("aparametersAparameters");
        Data.CreatorPackagestatementPackagename creatorPackagestatementPackagename = data2.new CreatorPackagestatementPackagename("creatorPackagestatementPackagename");
        Data.ParameterParameterType parameterParameterType = data2.new ParameterParameterType("parameterParameterType");
        Data.ParameterParameterVariable parameterParameterVariable = data2.new ParameterParameterVariable("parameterParameterVariable");
        Data.ParametersParametersParameter parametersParametersParameter = data2.new ParametersParametersParameter("parametersParametersParameter");
        Data.AsMethodAsMethodSpaces asMethodAsMethodSpaces = data2.new AsMethodAsMethodSpaces("asMethodAsMethodSpaces");
        Data.AsMethodAsMethodReturnclass asMethodAsMethodReturnclass = data2.new AsMethodAsMethodReturnclass("asMethodAsMethodReturnclass");
        Data.AsMethodAsMethodMethodName asMethodAsMethodMethodName = data2.new AsMethodAsMethodMethodName("asMethodAsMethodMethodName");
        Data.AsMethodAsMethodParameters asMethodAsMethodParameters = data2.new AsMethodAsMethodParameters("asMethodAsMethodParameters");
        Data.AsMethodAsMethodStatement asMethodAsMethodStatement = data2.new AsMethodAsMethodStatement("asMethodAsMethodStatement");
        Data.AparameterAttrAparameterAttrVariable aparameterAttrAparameterAttrVariable = data2.new AparameterAttrAparameterAttrVariable("aparameterAttrAparameterAttrVariable");
        Data.AparameterAttrAparameterAttrValue aparameterAttrAparameterAttrValue = data2.new AparameterAttrAparameterAttrValue("aparameterAttrAparameterAttrValue");
        Data.AparameterAparameterAparameterAttr aparameterAparameterAparameterAttr = data2.new AparameterAparameterAparameterAttr("aparameterAparameterAparameterAttr");
        Data.AparametersAparametersAparameter aparametersAparametersAparameter = data2.new AparametersAparametersAparameter("aparametersAparametersAparameter");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementStateClass classStatementClassStatementStateClass = data2.new ClassStatementClassStatementStateClass("classStatementClassStatementStateClass");
        Data.ClassStatementClassStatementAsMethod classStatementClassStatementAsMethod = data2.new ClassStatementClassStatementAsMethod("classStatementClassStatementAsMethod");
        Data.ClassStatementClassStatementAparameters classStatementClassStatementAparameters = data2.new ClassStatementClassStatementAparameters("classStatementClassStatementAparameters");
        Data.CreatorCreatorImports creatorCreatorImports = data2.new CreatorCreatorImports("creatorCreatorImports");
        Data.CreatorCreatorClassStatement creatorCreatorClassStatement = data2.new CreatorCreatorClassStatement("creatorCreatorClassStatement");
        Data.CreatorCreatorManualCode creatorCreatorManualCode = data2.new CreatorCreatorManualCode("creatorCreatorManualCode");

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
        ElementList packagestatement = new ElementList(12, "packagestatement");
        ElementList fullclassname = new ElementList(13, "fullclassname");
        ElementList importstatement = new ElementList(14, "importstatement");
        Optional imports = new Optional(15, "imports");
        ElementList statement = new ElementList(16, "statement");
        ElementList parameter = new ElementList(17, "parameter");
        ElementList parameters = new ElementList(18, "parameters");
        ElementList asMethod = new ElementList(19, "asMethod");
        ElementList aparameterAttr = new ElementList(20, "aparameterAttr");
        ElementList aparameter = new ElementList(21, "aparameter");
        ElementList aparameters = new ElementList(22, "aparameters", aparametersAparameters);
        ElementList classStatement = new ElementList(23, "classStatement");
        ElementList manualEnd = new ElementList(24, "manualEnd");
        Str generatedEnd = new Str(25, "// ===== Generated code =====");
        Repeat manualCode = new Repeat(26, "manualCode");
        ElementList creator = new ElementList(27, "creator");

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

        // packagename = name ["." name|"*"]+
        packagename.add(102, name);
        Optional packagename_1 = new Optional(103, "packagename_1");
        Repeat packagename_1_1 = new Repeat(104, "packagename_1_1");
        packagename_1_1.add(106, new Str(105, "."));
        OrList packagename_1_1_1 = new OrList(107, "packagename_1_1_1");
        packagename_1_1_1.add(108, name);
        packagename_1_1_1.add(110, new Str(109, "*"));
        packagename_1_1.add(111, packagename_1_1_1);
        packagename_1.add(112, packagename_1_1);
        packagename.add(113, packagename_1);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(115, new Str(114, "package"));
        packagestatement.add(116, ws);
        packagestatement.add(117, packagename, creatorPackagestatementPackagename);
        packagestatement.add(118, s);
        packagestatement.add(120, new Str(119, ";"));

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

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(139, new Str(138, "{"));
        statement.add(140, s);
        Optional statement_1 = new Optional(141, "statement_1");
        Repeat statement_1_1 = new Repeat(142, "statement_1_1");
        OrList statement_1_1_1 = new OrList(143, "statement_1_1_1");
        statement_1_1_1.add(144, statement);
        statement_1_1_1.add(145, str);
        statement_1_1_1.add(147, new Str(146, "}", NOT));
        statement_1_1.add(148, statement_1_1_1);
        statement_1.add(149, statement_1_1);
        statement.add(150, statement_1);
        statement.add(152, new Str(151, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(153, s);
        parameter.add(154, name, parameterParameterType);
        parameter.add(155, ws);
        parameter.add(156, name, parameterParameterVariable);
        parameter.add(157, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(158, "parameters_1");
        parameters_1.add(159, parameter, parametersParametersParameter);
        parameters.add(160, parameters_1);
        Optional parameters_2 = new Optional(161, "parameters_2");
        Repeat parameters_2_1 = new Repeat(162, "parameters_2_1");
        parameters_2_1.add(164, new Str(163, ","));
        parameters_2_1.add(165, s);
        parameters_2_1.add(166, parameter, parametersParametersParameter);
        parameters_2.add(167, parameters_2_1);
        parameters.add(168, parameters_2);

        // asMethod = s:spaces "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s statement
        asMethod.add(169, s, asMethodAsMethodSpaces);
        asMethod.add(171, new Str(170, "public"));
        asMethod.add(172, s);
        asMethod.add(173, name, asMethodAsMethodReturnclass);
        asMethod.add(174, ws);
        ElementList asMethod_1 = new ElementList(175, "asMethod_1", asMethodAsMethodMethodName);
        asMethod_1.add(177, new Str(176, "as"));
        asMethod_1.add(178, name);
        asMethod.add(179, asMethod_1);
        asMethod.add(180, s);
        asMethod.add(182, new Str(181, "("));
        asMethod.add(183, s);
        asMethod.add(184, parameters, asMethodAsMethodParameters);
        asMethod.add(185, s);
        asMethod.add(187, new Str(186, ")"));
        asMethod.add(188, s);
        asMethod.add(189, statement, asMethodAsMethodStatement);

        // aparameterAttr = ("name"|"value"|"next"|"method"|"signature"):variable s "=" s (name|str):value
        OrList aparameterAttr_1 = new OrList(190, "aparameterAttr_1", aparameterAttrAparameterAttrVariable);
        aparameterAttr_1.add(192, new Str(191, "name"));
        aparameterAttr_1.add(194, new Str(193, "value"));
        aparameterAttr_1.add(196, new Str(195, "next"));
        aparameterAttr_1.add(198, new Str(197, "method"));
        aparameterAttr_1.add(200, new Str(199, "signature"));
        aparameterAttr.add(201, aparameterAttr_1);
        aparameterAttr.add(202, s);
        aparameterAttr.add(204, new Str(203, "="));
        aparameterAttr.add(205, s);
        OrList aparameterAttr_2 = new OrList(206, "aparameterAttr_2", aparameterAttrAparameterAttrValue);
        aparameterAttr_2.add(207, name);
        aparameterAttr_2.add(208, str);
        aparameterAttr.add(209, aparameterAttr_2);

        // aparameter = "@Parameter" s "(" s aparameterAttr [s "," s aparameterAttr]+ s ")"
        aparameter.add(211, new Str(210, "@Parameter"));
        aparameter.add(212, s);
        aparameter.add(214, new Str(213, "("));
        aparameter.add(215, s);
        aparameter.add(216, aparameterAttr, aparameterAparameterAparameterAttr);
        Optional aparameter_1 = new Optional(217, "aparameter_1");
        Repeat aparameter_1_1 = new Repeat(218, "aparameter_1_1");
        aparameter_1_1.add(219, s);
        aparameter_1_1.add(221, new Str(220, ","));
        aparameter_1_1.add(222, s);
        aparameter_1_1.add(223, aparameterAttr, aparameterAparameterAparameterAttr);
        aparameter_1.add(224, aparameter_1_1);
        aparameter.add(225, aparameter_1);
        aparameter.add(226, s);
        aparameter.add(228, new Str(227, ")"));

        // aparameters = s "@Parameters" s "(" s "{" s aparameter [s "," s aparameter]+ s "}" s ")"
        aparameters.add(229, s);
        aparameters.add(231, new Str(230, "@Parameters"));
        aparameters.add(232, s);
        aparameters.add(234, new Str(233, "("));
        aparameters.add(235, s);
        aparameters.add(237, new Str(236, "{"));
        aparameters.add(238, s);
        aparameters.add(239, aparameter, aparametersAparametersAparameter);
        Optional aparameters_1 = new Optional(240, "aparameters_1");
        Repeat aparameters_1_1 = new Repeat(241, "aparameters_1_1");
        aparameters_1_1.add(242, s);
        aparameters_1_1.add(244, new Str(243, ","));
        aparameters_1_1.add(245, s);
        aparameters_1_1.add(246, aparameter, aparametersAparametersAparameter);
        aparameters_1.add(247, aparameters_1_1);
        aparameters.add(248, aparameters_1);
        aparameters.add(249, s);
        aparameters.add(251, new Str(250, "}"));
        aparameters.add(252, s);
        aparameters.add(254, new Str(253, ")"));

        // classStatement =
        //   "@Creator" ws public "class" ws name:classname s "implements" s name s "{" s
        //   "private final" s name:stateClass s "state;" [asMethod|aparameters]+
        classStatement.add(256, new Str(255, "@Creator"));
        classStatement.add(257, ws);
        classStatement.add(258, _public);
        classStatement.add(260, new Str(259, "class"));
        classStatement.add(261, ws);
        classStatement.add(262, name, classStatementClassStatementClassname);
        classStatement.add(263, s);
        classStatement.add(265, new Str(264, "implements"));
        classStatement.add(266, s);
        classStatement.add(267, name);
        classStatement.add(268, s);
        classStatement.add(270, new Str(269, "{"));
        classStatement.add(271, s);
        classStatement.add(273, new Str(272, "private final"));
        classStatement.add(274, s);
        classStatement.add(275, name, classStatementClassStatementStateClass);
        classStatement.add(276, s);
        classStatement.add(278, new Str(277, "state;"));
        Optional classStatement_1 = new Optional(279, "classStatement_1");
        Repeat classStatement_1_1 = new Repeat(280, "classStatement_1_1");
        OrList classStatement_1_1_1 = new OrList(281, "classStatement_1_1_1");
        classStatement_1_1_1.add(282, asMethod, classStatementClassStatementAsMethod);
        classStatement_1_1_1.add(283, aparameters, classStatementClassStatementAparameters);
        classStatement_1_1.add(284, classStatement_1_1_1);
        classStatement_1.add(285, classStatement_1_1);
        classStatement.add(286, classStatement_1);

        // manualEnd = ("}" s END)
        manualEnd.add(288, new Str(287, "}"));
        manualEnd.add(289, s);
        manualEnd.add(291, new End(290, "manualEnd"));

        // generatedEnd = "// ===== Generated code ====="

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(292, "manualCode_1");
        manualCode_1.add(293, manualEnd);
        manualCode_1.add(294, generatedEnd);
        manualCode.add(295, manualCode_1, NOT);

        // creator = packagestatement s imports s classStatement manualCode *
        creator.add(296, packagestatement);
        creator.add(297, s);
        creator.add(298, imports, creatorCreatorImports);
        creator.add(299, s);
        creator.add(300, classStatement, creatorCreatorClassStatement);
        creator.add(301, manualCode, creatorCreatorManualCode);
        creator.add(303, new Complete(302, "creator"));

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
        ElementList packagestatement = new ElementList(12, "packagestatement");
        ElementList fullclassname = new ElementList(13, "fullclassname");
        ElementList importstatement = new ElementList(14, "importstatement");
        Optional imports = new Optional(15, "imports");
        ElementList statement = new ElementList(16, "statement");
        ElementList parameter = new ElementList(17, "parameter");
        ElementList parameters = new ElementList(18, "parameters");
        ElementList asMethod = new ElementList(19, "asMethod");
        ElementList aparameterAttr = new ElementList(20, "aparameterAttr");
        ElementList aparameter = new ElementList(21, "aparameter");
        ElementList aparameters = new ElementList(22, "aparameters");
        ElementList classStatement = new ElementList(23, "classStatement");
        ElementList manualEnd = new ElementList(24, "manualEnd");
        Str generatedEnd = new Str(25, "// ===== Generated code =====");
        Repeat manualCode = new Repeat(26, "manualCode");
        ElementList creator = new ElementList(27, "creator");

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

        // packagename = name ["." name|"*"]+
        packagename.add(102, name);
        Optional packagename_1 = new Optional(103, "packagename_1");
        Repeat packagename_1_1 = new Repeat(104, "packagename_1_1");
        packagename_1_1.add(106, new Str(105, "."));
        OrList packagename_1_1_1 = new OrList(107, "packagename_1_1_1");
        packagename_1_1_1.add(108, name);
        packagename_1_1_1.add(110, new Str(109, "*"));
        packagename_1_1.add(111, packagename_1_1_1);
        packagename_1.add(112, packagename_1_1);
        packagename.add(113, packagename_1);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(115, new Str(114, "package"));
        packagestatement.add(116, ws);
        packagestatement.add(117, packagename);
        packagestatement.add(118, s);
        packagestatement.add(120, new Str(119, ";"));

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

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(139, new Str(138, "{"));
        statement.add(140, s);
        Optional statement_1 = new Optional(141, "statement_1");
        Repeat statement_1_1 = new Repeat(142, "statement_1_1");
        OrList statement_1_1_1 = new OrList(143, "statement_1_1_1");
        statement_1_1_1.add(144, statement);
        statement_1_1_1.add(145, str);
        statement_1_1_1.add(147, new Str(146, "}", NOT));
        statement_1_1.add(148, statement_1_1_1);
        statement_1.add(149, statement_1_1);
        statement.add(150, statement_1);
        statement.add(152, new Str(151, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(153, s);
        parameter.add(154, name);
        parameter.add(155, ws);
        parameter.add(156, name);
        parameter.add(157, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(158, "parameters_1");
        parameters_1.add(159, parameter);
        parameters.add(160, parameters_1);
        Optional parameters_2 = new Optional(161, "parameters_2");
        Repeat parameters_2_1 = new Repeat(162, "parameters_2_1");
        parameters_2_1.add(164, new Str(163, ","));
        parameters_2_1.add(165, s);
        parameters_2_1.add(166, parameter);
        parameters_2.add(167, parameters_2_1);
        parameters.add(168, parameters_2);

        // asMethod = s:spaces "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s statement
        asMethod.add(169, s);
        asMethod.add(171, new Str(170, "public"));
        asMethod.add(172, s);
        asMethod.add(173, name);
        asMethod.add(174, ws);
        ElementList asMethod_1 = new ElementList(175, "asMethod_1");
        asMethod_1.add(177, new Str(176, "as"));
        asMethod_1.add(178, name);
        asMethod.add(179, asMethod_1);
        asMethod.add(180, s);
        asMethod.add(182, new Str(181, "("));
        asMethod.add(183, s);
        asMethod.add(184, parameters);
        asMethod.add(185, s);
        asMethod.add(187, new Str(186, ")"));
        asMethod.add(188, s);
        asMethod.add(189, statement);

        // aparameterAttr = ("name"|"value"|"next"|"method"|"signature"):variable s "=" s (name|str):value
        OrList aparameterAttr_1 = new OrList(190, "aparameterAttr_1");
        aparameterAttr_1.add(192, new Str(191, "name"));
        aparameterAttr_1.add(194, new Str(193, "value"));
        aparameterAttr_1.add(196, new Str(195, "next"));
        aparameterAttr_1.add(198, new Str(197, "method"));
        aparameterAttr_1.add(200, new Str(199, "signature"));
        aparameterAttr.add(201, aparameterAttr_1);
        aparameterAttr.add(202, s);
        aparameterAttr.add(204, new Str(203, "="));
        aparameterAttr.add(205, s);
        OrList aparameterAttr_2 = new OrList(206, "aparameterAttr_2");
        aparameterAttr_2.add(207, name);
        aparameterAttr_2.add(208, str);
        aparameterAttr.add(209, aparameterAttr_2);

        // aparameter = "@Parameter" s "(" s aparameterAttr [s "," s aparameterAttr]+ s ")"
        aparameter.add(211, new Str(210, "@Parameter"));
        aparameter.add(212, s);
        aparameter.add(214, new Str(213, "("));
        aparameter.add(215, s);
        aparameter.add(216, aparameterAttr);
        Optional aparameter_1 = new Optional(217, "aparameter_1");
        Repeat aparameter_1_1 = new Repeat(218, "aparameter_1_1");
        aparameter_1_1.add(219, s);
        aparameter_1_1.add(221, new Str(220, ","));
        aparameter_1_1.add(222, s);
        aparameter_1_1.add(223, aparameterAttr);
        aparameter_1.add(224, aparameter_1_1);
        aparameter.add(225, aparameter_1);
        aparameter.add(226, s);
        aparameter.add(228, new Str(227, ")"));

        // aparameters = s "@Parameters" s "(" s "{" s aparameter [s "," s aparameter]+ s "}" s ")"
        aparameters.add(229, s);
        aparameters.add(231, new Str(230, "@Parameters"));
        aparameters.add(232, s);
        aparameters.add(234, new Str(233, "("));
        aparameters.add(235, s);
        aparameters.add(237, new Str(236, "{"));
        aparameters.add(238, s);
        aparameters.add(239, aparameter);
        Optional aparameters_1 = new Optional(240, "aparameters_1");
        Repeat aparameters_1_1 = new Repeat(241, "aparameters_1_1");
        aparameters_1_1.add(242, s);
        aparameters_1_1.add(244, new Str(243, ","));
        aparameters_1_1.add(245, s);
        aparameters_1_1.add(246, aparameter);
        aparameters_1.add(247, aparameters_1_1);
        aparameters.add(248, aparameters_1);
        aparameters.add(249, s);
        aparameters.add(251, new Str(250, "}"));
        aparameters.add(252, s);
        aparameters.add(254, new Str(253, ")"));

        // classStatement =
        //   "@Creator" ws public "class" ws name:classname s "implements" s name s "{" s
        //   "private final" s name:stateClass s "state;" [asMethod|aparameters]+
        classStatement.add(256, new Str(255, "@Creator"));
        classStatement.add(257, ws);
        classStatement.add(258, _public);
        classStatement.add(260, new Str(259, "class"));
        classStatement.add(261, ws);
        classStatement.add(262, name);
        classStatement.add(263, s);
        classStatement.add(265, new Str(264, "implements"));
        classStatement.add(266, s);
        classStatement.add(267, name);
        classStatement.add(268, s);
        classStatement.add(270, new Str(269, "{"));
        classStatement.add(271, s);
        classStatement.add(273, new Str(272, "private final"));
        classStatement.add(274, s);
        classStatement.add(275, name);
        classStatement.add(276, s);
        classStatement.add(278, new Str(277, "state;"));
        Optional classStatement_1 = new Optional(279, "classStatement_1");
        Repeat classStatement_1_1 = new Repeat(280, "classStatement_1_1");
        OrList classStatement_1_1_1 = new OrList(281, "classStatement_1_1_1");
        classStatement_1_1_1.add(282, asMethod);
        classStatement_1_1_1.add(283, aparameters);
        classStatement_1_1.add(284, classStatement_1_1_1);
        classStatement_1.add(285, classStatement_1_1);
        classStatement.add(286, classStatement_1);

        // manualEnd = ("}" s END)
        manualEnd.add(288, new Str(287, "}"));
        manualEnd.add(289, s);
        manualEnd.add(291, new End(290, "manualEnd"));

        // generatedEnd = "// ===== Generated code ====="

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(292, "manualCode_1");
        manualCode_1.add(293, manualEnd);
        manualCode_1.add(294, generatedEnd);
        manualCode.add(295, manualCode_1, NOT);

        // creator = packagestatement s imports s classStatement manualCode *
        creator.add(296, packagestatement);
        creator.add(297, s);
        creator.add(298, imports);
        creator.add(299, s);
        creator.add(300, classStatement);
        creator.add(301, manualCode);
        creator.add(303, new Complete(302, "creator"));

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
        public void setStatement(String statement);
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
        public void setPackagename(String packagename);
        public void setImports(String imports);
        public void setClassStatement(IClassStatement iclassStatement);
        public void setManualCode(String manualCode);
    }

    // *** Data ***
    public static final class Data {
        private CreatorParser.ICreatorFactory factory;
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

        // Creator creator.setPackagename(String packagestatement.packagename);
        public class CreatorPackagestatementPackagename implements Output {
            private String name;
            public CreatorPackagestatementPackagename(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekCreator().setPackagename(source.get(bookmark));
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

        // asMethod.setStatement(String statement);
        public class AsMethodAsMethodStatement implements Output {
            private String name;
            public AsMethodAsMethodStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAsMethod().setStatement(source.get(bookmark));
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
    }
}
