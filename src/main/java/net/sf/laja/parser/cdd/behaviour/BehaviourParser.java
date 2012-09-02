package net.sf.laja.parser.cdd.behaviour;

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
 * Auto generated 2012-08-23 by Laja:
 *    http://laja.sf.net
 *
 * Version: laja2-006
 */
public final class BehaviourParser implements net.sf.laja.parser.engine2.Parser {
    private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
    private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
    private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

    private Data data1;
    private Data data2;
    private IBehaviourFactory factory1;
    private IBehaviourFactory factory2;
    private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
    private SyntaxErrorHandler syntaxErrorHandler;

    public static final int PHASE1 = 1;
    public static final int PHASE2 = 2;

    public BehaviourParser(IBehaviourFactoryFactory factoryFactory) {
        init(factoryFactory);
    }

    public void init(IBehaviourFactoryFactory factoryFactory) {
        syntaxErrorHandler = new DefaultSyntaxErrorHandler();
        factory1 = factoryFactory.getFactory(PHASE1);
        factory2 = factoryFactory.getFactory(PHASE2);
        data1 = new Data(factory1);
        data2 = new Data(factory2);
    }

    public BehaviourParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
        sourceRecorderLogWriter = writer;
        return this;
    }

    public BehaviourParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
        this.syntaxErrorHandler = syntaxErrorHandler;
        return this;
    }

    public IBehaviourFactory getFactory1() {
        return factory1;
    }

    public IBehaviourFactory getFactory() {
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
        Data.BehaviourPackagestatementStatement behaviourPackagestatementStatement = data2.new BehaviourPackagestatementStatement("behaviourPackagestatementStatement");
        Data.ImportstatementImportstatementStatic importstatementImportstatementStatic = data2.new ImportstatementImportstatementStatic("importstatementImportstatementStatic");
        Data.ImportstatementImportstatementFullclassname importstatementImportstatementFullclassname = data2.new ImportstatementImportstatementFullclassname("importstatementImportstatementFullclassname");
        Data.ImportsImportsImportstatement importsImportsImportstatement = data2.new ImportsImportsImportstatement("importsImportsImportstatement");
        Data.ParameterParameterType parameterParameterType = data2.new ParameterParameterType("parameterParameterType");
        Data.ParameterParameterVariable parameterParameterVariable = data2.new ParameterParameterVariable("parameterParameterVariable");
        Data.ParametersParametersParameter parametersParametersParameter = data2.new ParametersParametersParameter("parametersParametersParameter");
        Data.StatementStatementInnerStatement statementStatementInnerStatement = data2.new StatementStatementInnerStatement("statementStatementInnerStatement");
        Data.StatementStatementStatement statementStatementStatement = data2.new StatementStatementStatement("statementStatementStatement");
        Data.BehaviourStateStatementExtendsClass behaviourStateStatementExtendsClass = data2.new BehaviourStateStatementExtendsClass("behaviourStateStatementExtendsClass");
        Data.BehaviourStateConstructorStateClass behaviourStateConstructorStateClass = data2.new BehaviourStateConstructorStateClass("behaviourStateConstructorStateClass");
        Data.BehaviourStateConstructorParameters behaviourStateConstructorParameters = data2.new BehaviourStateConstructorParameters("behaviourStateConstructorParameters");
        Data.AsMethodAsMethodComment asMethodAsMethodComment = data2.new AsMethodAsMethodComment("asMethodAsMethodComment");
        Data.AsMethodAsMethodReturnclass asMethodAsMethodReturnclass = data2.new AsMethodAsMethodReturnclass("asMethodAsMethodReturnclass");
        Data.AsMethodAsMethodMethodName asMethodAsMethodMethodName = data2.new AsMethodAsMethodMethodName("asMethodAsMethodMethodName");
        Data.AsMethodAsMethodParameters asMethodAsMethodParameters = data2.new AsMethodAsMethodParameters("asMethodAsMethodParameters");
        Data.AsMethodAsMethodStatement asMethodAsMethodStatement = data2.new AsMethodAsMethodStatement("asMethodAsMethodStatement");
        Data.BehaviourBehaviourMethodAsMethod behaviourBehaviourMethodAsMethod = data2.new BehaviourBehaviourMethodAsMethod("behaviourBehaviourMethodAsMethod");
        Data.BehaviourBehaviourImports behaviourBehaviourImports = data2.new BehaviourBehaviourImports("behaviourBehaviourImports");
        Data.StateConstructorStateConstructorStatement stateConstructorStateConstructorStatement = data2.new StateConstructorStateConstructorStatement("stateConstructorStateConstructorStatement");

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
        ElementList uname = new ElementList(10, "uname");
        Optional _public = new Optional(11, "public");
        ElementList packagestatement = new ElementList(12, "packagestatement");
        ElementList packagename = new ElementList(13, "packagename");
        ElementList fullclassname = new ElementList(14, "fullclassname");
        ElementList importstatement = new ElementList(15, "importstatement", importstatementImportstatement);
        Optional imports = new Optional(16, "imports");
        ElementList parameter = new ElementList(17, "parameter");
        ElementList parameters = new ElementList(18, "parameters");
        ElementList statement = new ElementList(19, "statement");
        Optional skipCurlyBrace = new Optional(20, "skipCurlyBrace");
        ElementList stateStatement = new ElementList(21, "stateStatement");
        ElementList stateConstructor = new ElementList(22, "stateConstructor");
        ElementList asMethod = new ElementList(23, "asMethod");
        ElementList behaviourMethod = new ElementList(24, "behaviourMethod");
        ElementList behaviour = new ElementList(25, "behaviour");

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

        // uname = "A".."Z" [letter | digit]+
        uname.add(98, new Range(97, "uname", "A", "Z"));
        Optional uname_1 = new Optional(99, "uname_1");
        Repeat uname_1_1 = new Repeat(100, "uname_1_1");
        OrList uname_1_1_1 = new OrList(101, "uname_1_1_1");
        uname_1_1_1.add(102, letter);
        uname_1_1_1.add(103, digit);
        uname_1_1.add(104, uname_1_1_1);
        uname_1.add(105, uname_1_1);
        uname.add(106, uname_1);

        // public = ["public" ws]
        _public.add(108, new Str(107, "public"));
        _public.add(109, ws);

        // packagestatement = "package" ws packagename:statement s ";"
        packagestatement.add(111, new Str(110, "package"));
        packagestatement.add(112, ws);
        packagestatement.add(113, packagename, behaviourPackagestatementStatement);
        packagestatement.add(114, s);
        packagestatement.add(116, new Str(115, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(117, name);
        Optional packagename_1 = new Optional(118, "packagename_1");
        Repeat packagename_1_1 = new Repeat(119, "packagename_1_1");
        packagename_1_1.add(121, new Str(120, "."));
        OrList packagename_1_1_1 = new OrList(122, "packagename_1_1_1");
        packagename_1_1_1.add(123, name);
        packagename_1_1_1.add(125, new Str(124, "*"));
        packagename_1_1.add(126, packagename_1_1_1);
        packagename_1.add(127, packagename_1_1);
        packagename.add(128, packagename_1);

        // fullclassname = packagename
        fullclassname.add(129, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";"
        importstatement.add(131, new Str(130, "import"));
        importstatement.add(132, ws);
        Optional importstatement_1 = new Optional(133, "importstatement_1");
        importstatement_1.add(135, new Str(134, "static", importstatementImportstatementStatic));
        importstatement_1.add(136, ws);
        importstatement.add(137, importstatement_1);
        importstatement.add(138, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(139, s);
        importstatement.add(141, new Str(140, ";"));

        // imports = [s importstatement]+
        Repeat imports_1 = new Repeat(142, "imports_1");
        imports_1.add(143, s);
        imports_1.add(144, importstatement, importsImportsImportstatement);
        imports.add(145, imports_1);

        // parameter = s name:type ws name:variable s
        parameter.add(146, s);
        parameter.add(147, name, parameterParameterType);
        parameter.add(148, ws);
        parameter.add(149, name, parameterParameterVariable);
        parameter.add(150, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(151, "parameters_1");
        parameters_1.add(152, parameter, parametersParametersParameter);
        parameters.add(153, parameters_1);
        Optional parameters_2 = new Optional(154, "parameters_2");
        Repeat parameters_2_1 = new Repeat(155, "parameters_2_1");
        parameters_2_1.add(157, new Str(156, ","));
        parameters_2_1.add(158, s);
        parameters_2_1.add(159, parameter, parametersParametersParameter);
        parameters_2.add(160, parameters_2_1);
        parameters.add(161, parameters_2);

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(163, new Str(162, "{"));
        statement.add(164, s);
        Optional statement_1 = new Optional(165, "statement_1", statementStatementInnerStatement);
        Repeat statement_1_1 = new Repeat(166, "statement_1_1");
        OrList statement_1_1_1 = new OrList(167, "statement_1_1_1");
        statement_1_1_1.add(168, statement, statementStatementStatement);
        statement_1_1_1.add(169, str);
        statement_1_1_1.add(171, new Str(170, "}", NOT));
        statement_1_1.add(172, statement_1_1_1);
        statement_1.add(173, statement_1_1);
        statement.add(174, statement_1);
        statement.add(176, new Str(175, "}"));

        // skipCurlyBrace = [!"{"+]
        Repeat skipCurlyBrace_1 = new Repeat(177, "skipCurlyBrace_1");
        skipCurlyBrace_1.add(179, new Str(178, "{", NOT));
        skipCurlyBrace.add(180, skipCurlyBrace_1);

        // stateStatement = public "class" ws name [ws "extends" ws uname:extendsClass] skipCurlyBrace "{" [!stateConstructor:x+] stateConstructor
        stateStatement.add(181, _public);
        stateStatement.add(183, new Str(182, "class"));
        stateStatement.add(184, ws);
        stateStatement.add(185, name);
        Optional stateStatement_1 = new Optional(186, "stateStatement_1");
        stateStatement_1.add(187, ws);
        stateStatement_1.add(189, new Str(188, "extends"));
        stateStatement_1.add(190, ws);
        stateStatement_1.add(191, uname, behaviourStateStatementExtendsClass);
        stateStatement.add(192, stateStatement_1);
        stateStatement.add(193, skipCurlyBrace);
        stateStatement.add(195, new Str(194, "{"));
        Optional stateStatement_2 = new Optional(196, "stateStatement_2");
        Repeat stateStatement_2_1 = new Repeat(197, "stateStatement_2_1");
        stateStatement_2_1.add(198, stateConstructor, NOT);
        stateStatement_2.add(199, stateStatement_2_1);
        stateStatement.add(200, stateStatement_2);
        stateStatement.add(201, stateConstructor);

        // stateConstructor = s public name s "(" s ["final" s] name:stateClass ws name parameters skipCurlyBrace statement
        stateConstructor.add(202, s);
        stateConstructor.add(203, _public);
        stateConstructor.add(204, name);
        stateConstructor.add(205, s);
        stateConstructor.add(207, new Str(206, "("));
        stateConstructor.add(208, s);
        Optional stateConstructor_1 = new Optional(209, "stateConstructor_1");
        stateConstructor_1.add(211, new Str(210, "final"));
        stateConstructor_1.add(212, s);
        stateConstructor.add(213, stateConstructor_1);
        stateConstructor.add(214, name, behaviourStateConstructorStateClass);
        stateConstructor.add(215, ws);
        stateConstructor.add(216, name);
        stateConstructor.add(217, parameters, behaviourStateConstructorParameters);
        stateConstructor.add(218, skipCurlyBrace);
        stateConstructor.add(219, statement, stateConstructorStateConstructorStatement);

        // asMethod =
        //   [!newline+ newline]:comment s
        //   ["public"|"private" ws] uname:returnclass ws ("as" uname):methodName s "(" s parameters s ")" s statement
        Optional asMethod_1 = new Optional(220, "asMethod_1", asMethodAsMethodComment);
        Repeat asMethod_1_1 = new Repeat(221, "asMethod_1_1");
        asMethod_1_1.add(222, newline, NOT);
        asMethod_1.add(223, asMethod_1_1);
        asMethod_1.add(224, newline);
        asMethod.add(225, asMethod_1);
        asMethod.add(226, s);
        Optional asMethod_2 = new Optional(227, "asMethod_2");
        OrList asMethod_2_1 = new OrList(228, "asMethod_2_1");
        asMethod_2_1.add(230, new Str(229, "public"));
        asMethod_2_1.add(232, new Str(231, "private"));
        asMethod_2.add(233, asMethod_2_1);
        asMethod_2.add(234, ws);
        asMethod.add(235, asMethod_2);
        asMethod.add(236, uname, asMethodAsMethodReturnclass);
        asMethod.add(237, ws);
        ElementList asMethod_3 = new ElementList(238, "asMethod_3", asMethodAsMethodMethodName);
        asMethod_3.add(240, new Str(239, "as"));
        asMethod_3.add(241, uname);
        asMethod.add(242, asMethod_3);
        asMethod.add(243, s);
        asMethod.add(245, new Str(244, "("));
        asMethod.add(246, s);
        asMethod.add(247, parameters, asMethodAsMethodParameters);
        asMethod.add(248, s);
        asMethod.add(250, new Str(249, ")"));
        asMethod.add(251, s);
        asMethod.add(252, statement, asMethodAsMethodStatement);

        // behaviourMethod = "//" s asMethod
        behaviourMethod.add(254, new Str(253, "//"));
        behaviourMethod.add(255, s);
        behaviourMethod.add(256, asMethod, behaviourBehaviourMethodAsMethod);

        // behaviour = [packagestatement] s [imports] s [stateStatement] [!behaviourMethod:x+|END [behaviourMethod]]+ *
        Optional behaviour_1 = new Optional(257, "behaviour_1");
        behaviour_1.add(258, packagestatement);
        behaviour.add(259, behaviour_1);
        behaviour.add(260, s);
        Optional behaviour_2 = new Optional(261, "behaviour_2");
        behaviour_2.add(262, imports, behaviourBehaviourImports);
        behaviour.add(263, behaviour_2);
        behaviour.add(264, s);
        Optional behaviour_3 = new Optional(265, "behaviour_3");
        behaviour_3.add(266, stateStatement);
        behaviour.add(267, behaviour_3);
        Optional behaviour_4 = new Optional(268, "behaviour_4");
        Repeat behaviour_4_1 = new Repeat(269, "behaviour_4_1");
        OrList behaviour_4_1_1 = new OrList(270, "behaviour_4_1_1");
        Repeat behaviour_4_1_1_1 = new Repeat(271, "behaviour_4_1_1_1");
        behaviour_4_1_1_1.add(272, behaviourMethod, NOT);
        behaviour_4_1_1.add(273, behaviour_4_1_1_1);
        behaviour_4_1_1.add(275, new End(274, "behaviour_4_1_1"));
        behaviour_4_1.add(276, behaviour_4_1_1);
        Optional behaviour_4_1_2 = new Optional(277, "behaviour_4_1_2");
        behaviour_4_1_2.add(278, behaviourMethod);
        behaviour_4_1.add(279, behaviour_4_1_2);
        behaviour_4.add(280, behaviour_4_1);
        behaviour.add(281, behaviour_4);
        behaviour.add(283, new Complete(282, "behaviour"));

        return new TopElement(data2, behaviour);
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
        ElementList uname = new ElementList(10, "uname");
        Optional _public = new Optional(11, "public");
        ElementList packagestatement = new ElementList(12, "packagestatement");
        ElementList packagename = new ElementList(13, "packagename");
        ElementList fullclassname = new ElementList(14, "fullclassname");
        ElementList importstatement = new ElementList(15, "importstatement");
        Optional imports = new Optional(16, "imports");
        ElementList parameter = new ElementList(17, "parameter");
        ElementList parameters = new ElementList(18, "parameters");
        ElementList statement = new ElementList(19, "statement");
        Optional skipCurlyBrace = new Optional(20, "skipCurlyBrace");
        ElementList stateStatement = new ElementList(21, "stateStatement");
        ElementList stateConstructor = new ElementList(22, "stateConstructor");
        ElementList asMethod = new ElementList(23, "asMethod");
        ElementList behaviourMethod = new ElementList(24, "behaviourMethod");
        ElementList behaviour = new ElementList(25, "behaviour");

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

        // uname = "A".."Z" [letter | digit]+
        uname.add(98, new Range(97, "uname", "A", "Z"));
        Optional uname_1 = new Optional(99, "uname_1");
        Repeat uname_1_1 = new Repeat(100, "uname_1_1");
        OrList uname_1_1_1 = new OrList(101, "uname_1_1_1");
        uname_1_1_1.add(102, letter);
        uname_1_1_1.add(103, digit);
        uname_1_1.add(104, uname_1_1_1);
        uname_1.add(105, uname_1_1);
        uname.add(106, uname_1);

        // public = ["public" ws]
        _public.add(108, new Str(107, "public"));
        _public.add(109, ws);

        // packagestatement = "package" ws packagename:statement s ";"
        packagestatement.add(111, new Str(110, "package"));
        packagestatement.add(112, ws);
        packagestatement.add(113, packagename);
        packagestatement.add(114, s);
        packagestatement.add(116, new Str(115, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(117, name);
        Optional packagename_1 = new Optional(118, "packagename_1");
        Repeat packagename_1_1 = new Repeat(119, "packagename_1_1");
        packagename_1_1.add(121, new Str(120, "."));
        OrList packagename_1_1_1 = new OrList(122, "packagename_1_1_1");
        packagename_1_1_1.add(123, name);
        packagename_1_1_1.add(125, new Str(124, "*"));
        packagename_1_1.add(126, packagename_1_1_1);
        packagename_1.add(127, packagename_1_1);
        packagename.add(128, packagename_1);

        // fullclassname = packagename
        fullclassname.add(129, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";"
        importstatement.add(131, new Str(130, "import"));
        importstatement.add(132, ws);
        Optional importstatement_1 = new Optional(133, "importstatement_1");
        importstatement_1.add(135, new Str(134, "static"));
        importstatement_1.add(136, ws);
        importstatement.add(137, importstatement_1);
        importstatement.add(138, fullclassname);
        importstatement.add(139, s);
        importstatement.add(141, new Str(140, ";"));

        // imports = [s importstatement]+
        Repeat imports_1 = new Repeat(142, "imports_1");
        imports_1.add(143, s);
        imports_1.add(144, importstatement);
        imports.add(145, imports_1);

        // parameter = s name:type ws name:variable s
        parameter.add(146, s);
        parameter.add(147, name);
        parameter.add(148, ws);
        parameter.add(149, name);
        parameter.add(150, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(151, "parameters_1");
        parameters_1.add(152, parameter);
        parameters.add(153, parameters_1);
        Optional parameters_2 = new Optional(154, "parameters_2");
        Repeat parameters_2_1 = new Repeat(155, "parameters_2_1");
        parameters_2_1.add(157, new Str(156, ","));
        parameters_2_1.add(158, s);
        parameters_2_1.add(159, parameter);
        parameters_2.add(160, parameters_2_1);
        parameters.add(161, parameters_2);

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(163, new Str(162, "{"));
        statement.add(164, s);
        Optional statement_1 = new Optional(165, "statement_1");
        Repeat statement_1_1 = new Repeat(166, "statement_1_1");
        OrList statement_1_1_1 = new OrList(167, "statement_1_1_1");
        statement_1_1_1.add(168, statement);
        statement_1_1_1.add(169, str);
        statement_1_1_1.add(171, new Str(170, "}", NOT));
        statement_1_1.add(172, statement_1_1_1);
        statement_1.add(173, statement_1_1);
        statement.add(174, statement_1);
        statement.add(176, new Str(175, "}"));

        // skipCurlyBrace = [!"{"+]
        Repeat skipCurlyBrace_1 = new Repeat(177, "skipCurlyBrace_1");
        skipCurlyBrace_1.add(179, new Str(178, "{", NOT));
        skipCurlyBrace.add(180, skipCurlyBrace_1);

        // stateStatement = public "class" ws name [ws "extends" ws uname:extendsClass] skipCurlyBrace "{" [!stateConstructor:x+] stateConstructor
        stateStatement.add(181, _public);
        stateStatement.add(183, new Str(182, "class"));
        stateStatement.add(184, ws);
        stateStatement.add(185, name);
        Optional stateStatement_1 = new Optional(186, "stateStatement_1");
        stateStatement_1.add(187, ws);
        stateStatement_1.add(189, new Str(188, "extends"));
        stateStatement_1.add(190, ws);
        stateStatement_1.add(191, uname);
        stateStatement.add(192, stateStatement_1);
        stateStatement.add(193, skipCurlyBrace);
        stateStatement.add(195, new Str(194, "{"));
        Optional stateStatement_2 = new Optional(196, "stateStatement_2");
        Repeat stateStatement_2_1 = new Repeat(197, "stateStatement_2_1");
        stateStatement_2_1.add(198, stateConstructor, NOT);
        stateStatement_2.add(199, stateStatement_2_1);
        stateStatement.add(200, stateStatement_2);
        stateStatement.add(201, stateConstructor);

        // stateConstructor = s public name s "(" s ["final" s] name:stateClass ws name parameters skipCurlyBrace statement
        stateConstructor.add(202, s);
        stateConstructor.add(203, _public);
        stateConstructor.add(204, name);
        stateConstructor.add(205, s);
        stateConstructor.add(207, new Str(206, "("));
        stateConstructor.add(208, s);
        Optional stateConstructor_1 = new Optional(209, "stateConstructor_1");
        stateConstructor_1.add(211, new Str(210, "final"));
        stateConstructor_1.add(212, s);
        stateConstructor.add(213, stateConstructor_1);
        stateConstructor.add(214, name);
        stateConstructor.add(215, ws);
        stateConstructor.add(216, name);
        stateConstructor.add(217, parameters);
        stateConstructor.add(218, skipCurlyBrace);
        stateConstructor.add(219, statement);

        // asMethod =
        //   [!newline+ newline]:comment s
        //   ["public"|"private" ws] uname:returnclass ws ("as" uname):methodName s "(" s parameters s ")" s statement
        Optional asMethod_1 = new Optional(220, "asMethod_1");
        Repeat asMethod_1_1 = new Repeat(221, "asMethod_1_1");
        asMethod_1_1.add(222, newline, NOT);
        asMethod_1.add(223, asMethod_1_1);
        asMethod_1.add(224, newline);
        asMethod.add(225, asMethod_1);
        asMethod.add(226, s);
        Optional asMethod_2 = new Optional(227, "asMethod_2");
        OrList asMethod_2_1 = new OrList(228, "asMethod_2_1");
        asMethod_2_1.add(230, new Str(229, "public"));
        asMethod_2_1.add(232, new Str(231, "private"));
        asMethod_2.add(233, asMethod_2_1);
        asMethod_2.add(234, ws);
        asMethod.add(235, asMethod_2);
        asMethod.add(236, uname);
        asMethod.add(237, ws);
        ElementList asMethod_3 = new ElementList(238, "asMethod_3");
        asMethod_3.add(240, new Str(239, "as"));
        asMethod_3.add(241, uname);
        asMethod.add(242, asMethod_3);
        asMethod.add(243, s);
        asMethod.add(245, new Str(244, "("));
        asMethod.add(246, s);
        asMethod.add(247, parameters);
        asMethod.add(248, s);
        asMethod.add(250, new Str(249, ")"));
        asMethod.add(251, s);
        asMethod.add(252, statement);

        // behaviourMethod = "//" s asMethod
        behaviourMethod.add(254, new Str(253, "//"));
        behaviourMethod.add(255, s);
        behaviourMethod.add(256, asMethod);

        // behaviour = [packagestatement] s [imports] s [stateStatement] [!behaviourMethod:x+|END [behaviourMethod]]+ *
        Optional behaviour_1 = new Optional(257, "behaviour_1");
        behaviour_1.add(258, packagestatement);
        behaviour.add(259, behaviour_1);
        behaviour.add(260, s);
        Optional behaviour_2 = new Optional(261, "behaviour_2");
        behaviour_2.add(262, imports);
        behaviour.add(263, behaviour_2);
        behaviour.add(264, s);
        Optional behaviour_3 = new Optional(265, "behaviour_3");
        behaviour_3.add(266, stateStatement);
        behaviour.add(267, behaviour_3);
        Optional behaviour_4 = new Optional(268, "behaviour_4");
        Repeat behaviour_4_1 = new Repeat(269, "behaviour_4_1");
        OrList behaviour_4_1_1 = new OrList(270, "behaviour_4_1_1");
        Repeat behaviour_4_1_1_1 = new Repeat(271, "behaviour_4_1_1_1");
        behaviour_4_1_1_1.add(272, behaviourMethod, NOT);
        behaviour_4_1_1.add(273, behaviour_4_1_1_1);
        behaviour_4_1_1.add(275, new End(274, "behaviour_4_1_1"));
        behaviour_4_1.add(276, behaviour_4_1_1);
        Optional behaviour_4_1_2 = new Optional(277, "behaviour_4_1_2");
        behaviour_4_1_2.add(278, behaviourMethod);
        behaviour_4_1.add(279, behaviour_4_1_2);
        behaviour_4.add(280, behaviour_4_1);
        behaviour.add(281, behaviour_4);
        behaviour.add(283, new Complete(282, "behaviour"));

        return new TopElement(data1, behaviour);
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
            data.pushBehaviour();
            boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
            data.popBehaviour();
            return match;
        }
    }

    // *** IBehaviourFactoryFactory
    public interface IBehaviourFactoryFactory {
        public IBehaviourFactory getFactory(int phase);
    }

    // *** IBehaviourFactory ***
    public interface IBehaviourFactory {
        BehaviourParser.IParameters createParameters();
        BehaviourParser.IStatement createStatement();
        BehaviourParser.IImportstatement createImportstatement();
        BehaviourParser.IImports createImports();
        BehaviourParser.IStateStatement createStateStatement();
        BehaviourParser.IStateConstructor createStateConstructor();
        BehaviourParser.IParameter createParameter();
        BehaviourParser.IAsMethod createAsMethod();
        BehaviourParser.IBehaviour createBehaviour();
    }

    // *** Interfaces ***
    // Parameters
    public interface IParameters {
        public void addParameter(IParameter iparameter);
    }

    // Statement
    public interface IStatement {
        public void setInnerStatement(String innerStatement);
        public void setStatement(String statement);
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

    // StateStatement
    public interface IStateStatement {
    }

    // StateConstructor
    public interface IStateConstructor {
    }

    // Parameter
    public interface IParameter {
        public void setType(String type);
        public void setVariable(String variable);
    }

    // AsMethod
    public interface IAsMethod {
        public void setComment(String comment);
        public void setReturnclass(String returnclass);
        public void setMethodName(String methodName);
        public void setParameters(IParameters iparameters);
        public void setStatement(IStatement istatement);
    }

    // Behaviour
    public interface IBehaviour {
        public void setPackageStatement(String statement);
        public void setImports(IImports iimports);
        public void setExtendsClass(String extendsClass);
        public void setStateClass(String stateClass);
        public void setParameters(IParameters iparameters);
        public void addAsMethod(IAsMethod iasMethod);
    }

    // *** Data ***
    public static final class Data {
        private BehaviourParser.IBehaviourFactory factory;
        private Stack<IParameters> parametersStack = new Stack<IParameters>();
        private Stack<IStatement> statementStack = new Stack<IStatement>();
        private Stack<IImportstatement> importstatementStack = new Stack<IImportstatement>();
        private Stack<IImports> importsStack = new Stack<IImports>();
        private Stack<IStateStatement> stateStatementStack = new Stack<IStateStatement>();
        private Stack<IStateConstructor> stateConstructorStack = new Stack<IStateConstructor>();
        private Stack<IParameter> parameterStack = new Stack<IParameter>();
        private Stack<IAsMethod> asMethodStack = new Stack<IAsMethod>();
        private Stack<IBehaviour> behaviourStack = new Stack<IBehaviour>();

        public Data(BehaviourParser.IBehaviourFactory factory) {
            this.factory = factory;
        }

        // Parameters
        public void pushParameters() { parametersStack.push(factory.createParameters()); }
        public BehaviourParser.IParameters popParameters() { return (BehaviourParser.IParameters)parametersStack.pop(); }
        public BehaviourParser.IParameters peekParameters() {
            if (parametersStack.empty()) { return null; }
            return parametersStack.peek();
        }

        // Statement
        public void pushStatement() { statementStack.push(factory.createStatement()); }
        public BehaviourParser.IStatement popStatement() { return (BehaviourParser.IStatement)statementStack.pop(); }
        public BehaviourParser.IStatement peekStatement() {
            if (statementStack.empty()) { return null; }
            return statementStack.peek();
        }

        // Importstatement
        public void pushImportstatement() { importstatementStack.push(factory.createImportstatement()); }
        public BehaviourParser.IImportstatement popImportstatement() { return (BehaviourParser.IImportstatement)importstatementStack.pop(); }
        public BehaviourParser.IImportstatement peekImportstatement() {
            if (importstatementStack.empty()) { return null; }
            return importstatementStack.peek();
        }

        // Imports
        public void pushImports() { importsStack.push(factory.createImports()); }
        public BehaviourParser.IImports popImports() { return (BehaviourParser.IImports)importsStack.pop(); }
        public BehaviourParser.IImports peekImports() {
            if (importsStack.empty()) { return null; }
            return importsStack.peek();
        }

        // StateStatement
        public void pushStateStatement() { stateStatementStack.push(factory.createStateStatement()); }
        public BehaviourParser.IStateStatement popStateStatement() { return (BehaviourParser.IStateStatement)stateStatementStack.pop(); }
        public BehaviourParser.IStateStatement peekStateStatement() {
            if (stateStatementStack.empty()) { return null; }
            return stateStatementStack.peek();
        }

        // StateConstructor
        public void pushStateConstructor() { stateConstructorStack.push(factory.createStateConstructor()); }
        public BehaviourParser.IStateConstructor popStateConstructor() { return (BehaviourParser.IStateConstructor)stateConstructorStack.pop(); }
        public BehaviourParser.IStateConstructor peekStateConstructor() {
            if (stateConstructorStack.empty()) { return null; }
            return stateConstructorStack.peek();
        }

        // Parameter
        public void pushParameter() { parameterStack.push(factory.createParameter()); }
        public BehaviourParser.IParameter popParameter() { return (BehaviourParser.IParameter)parameterStack.pop(); }
        public BehaviourParser.IParameter peekParameter() {
            if (parameterStack.empty()) { return null; }
            return parameterStack.peek();
        }

        // AsMethod
        public void pushAsMethod() { asMethodStack.push(factory.createAsMethod()); }
        public BehaviourParser.IAsMethod popAsMethod() { return (BehaviourParser.IAsMethod)asMethodStack.pop(); }
        public BehaviourParser.IAsMethod peekAsMethod() {
            if (asMethodStack.empty()) { return null; }
            return asMethodStack.peek();
        }

        // Behaviour
        public void pushBehaviour() { behaviourStack.push(factory.createBehaviour()); }
        public BehaviourParser.IBehaviour popBehaviour() { return (BehaviourParser.IBehaviour)behaviourStack.pop(); }
        public BehaviourParser.IBehaviour peekBehaviour() {
            if (behaviourStack.empty()) { return null; }
            return behaviourStack.peek();
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

        // Behaviour behaviour.setPackageStatement(String packagestatement.statement);
        public class BehaviourPackagestatementStatement implements Output {
            private String name;
            public BehaviourPackagestatementStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekBehaviour().setPackageStatement(source.get(bookmark));
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

        // statement.setStatement(String statement);
        public class StatementStatementStatement implements Output {
            private String name;
            public StatementStatementStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStatement(); }
            public void set(Source source, int bookmark) {
            }
        }

        // behaviour.setExtendsClass(String stateStatement.extendsClass);
        public class BehaviourStateStatementExtendsClass implements Output {
            private String name;
            public BehaviourStateStatementExtendsClass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekBehaviour().setExtendsClass(source.get(bookmark));
            }
        }

        // behaviour.setStateClass(String stateConstructor.stateClass);
        public class BehaviourStateConstructorStateClass implements Output {
            private String name;
            public BehaviourStateConstructorStateClass(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekBehaviour().setStateClass(source.get(bookmark));
            }
        }

        // behaviour.setParameters(Parameters stateConstructor.parameters);
        public class BehaviourStateConstructorParameters implements Output {
            private String name;
            public BehaviourStateConstructorParameters(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushParameters(); }
            public void set(Source source, int bookmark) {
                peekBehaviour().setParameters(popParameters());
            }
        }

        // AsMethod asMethod.setComment(String comment);
        public class AsMethodAsMethodComment implements Output {
            private String name;
            public AsMethodAsMethodComment(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAsMethod().setComment(source.get(bookmark));
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

        // asMethod.setStatement(Statement statement);
        public class AsMethodAsMethodStatement implements Output {
            private String name;
            public AsMethodAsMethodStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStatement(); }
            public void set(Source source, int bookmark) {
                peekAsMethod().setStatement(popStatement());
            }
        }

        // behaviour.addAsMethod(AsMethod behaviourMethod.asMethod);
        public class BehaviourBehaviourMethodAsMethod implements Output {
            private String name;
            public BehaviourBehaviourMethodAsMethod(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAsMethod(); }
            public void set(Source source, int bookmark) {
                peekBehaviour().addAsMethod(popAsMethod());
            }
        }

        // behaviour.setImports(Imports imports);
        public class BehaviourBehaviourImports implements Output {
            private String name;
            public BehaviourBehaviourImports(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushImports(); }
            public void set(Source source, int bookmark) {
                peekBehaviour().setImports(popImports());
            }
        }

        public class StateConstructorStateConstructorStatement implements Output {
            private String name;
            public StateConstructorStateConstructorStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushStatement(); }
            public void set(Source source, int bookmark) {
                popStatement();
            }
        }
    }
}
