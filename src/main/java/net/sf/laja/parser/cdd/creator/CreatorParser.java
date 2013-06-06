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
 * Auto generated 2013-06-06 by Laja:
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
        Data.CreatorPackagestatementPackagename creatorPackagestatementPackagename = data2.new CreatorPackagestatementPackagename("creatorPackagestatementPackagename");
        Data.ParameterParameterType parameterParameterType = data2.new ParameterParameterType("parameterParameterType");
        Data.ParameterParameterVariable parameterParameterVariable = data2.new ParameterParameterVariable("parameterParameterVariable");
        Data.ParametersParametersParameter parametersParametersParameter = data2.new ParametersParametersParameter("parametersParametersParameter");
        Data.AsMethodAsMethodSpaces asMethodAsMethodSpaces = data2.new AsMethodAsMethodSpaces("asMethodAsMethodSpaces");
        Data.AsMethodAsMethodReturnclass asMethodAsMethodReturnclass = data2.new AsMethodAsMethodReturnclass("asMethodAsMethodReturnclass");
        Data.AsMethodAsMethodMethodName asMethodAsMethodMethodName = data2.new AsMethodAsMethodMethodName("asMethodAsMethodMethodName");
        Data.AsMethodAsMethodParameters asMethodAsMethodParameters = data2.new AsMethodAsMethodParameters("asMethodAsMethodParameters");
        Data.AsMethodAsMethodStatement asMethodAsMethodStatement = data2.new AsMethodAsMethodStatement("asMethodAsMethodStatement");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementStateClass classStatementClassStatementStateClass = data2.new ClassStatementClassStatementStateClass("classStatementClassStatementStateClass");
        Data.ClassStatementClassStatementAsMethod classStatementClassStatementAsMethod = data2.new ClassStatementClassStatementAsMethod("classStatementClassStatementAsMethod");
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
        ElementList classStatement = new ElementList(20, "classStatement");
        ElementList manualEnd = new ElementList(21, "manualEnd");
        Str generatedEnd = new Str(22, "// ===== Constructors =====");
        Repeat manualCode = new Repeat(23, "manualCode");
        ElementList creator = new ElementList(24, "creator");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(26, new Str(25, "\r\n"));
        newline.add(28, new Str(27, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(29, "comment_1");
        comment_1.add(31, new Str(30, "/*"));
        Optional comment_1_1 = new Optional(32, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(33, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(34, "comment_1_1_1_1");
        comment_1_1_1_1.add(35, comment);
        comment_1_1_1_1.add(37, new Str(36, "*/", NOT));
        comment_1_1_1.add(38, comment_1_1_1_1);
        comment_1_1.add(39, comment_1_1_1);
        comment_1.add(40, comment_1_1);
        comment_1.add(42, new Str(41, "*/"));
        comment.add(43, comment_1);
        ElementList comment_2 = new ElementList(44, "comment_2");
        comment_2.add(46, new Str(45, "//"));
        Optional comment_2_1 = new Optional(47, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(48, "comment_2_1_1");
        comment_2_1_1.add(49, newline, NOT);
        comment_2_1.add(50, comment_2_1_1);
        comment_2.add(51, comment_2_1);
        OrList comment_2_2 = new OrList(52, "comment_2_2");
        comment_2_2.add(53, newline);
        comment_2_2.add(55, new End(54, "comment_2_2"));
        comment_2.add(56, comment_2_2);
        comment.add(57, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(58, "ws_1");
        ws_1.add(59, newline);
        ws_1.add(61, new Str(60, " "));
        ws_1.add(63, new Str(62, "\t"));
        ws_1.add(64, comment);
        ws.add(65, ws_1);

        // s = [ws]
        s.add(66, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(67, ff);
        Repeat str_1 = new Repeat(68, "str_1");
        OrList str_1_1 = new OrList(69, "str_1_1");
        str_1_1.add(71, new Str(70, "\\\""));
        OrList str_1_1_1 = new OrList(72, "str_1_1_1", NOT);
        str_1_1_1.add(73, ff);
        str_1_1_1.add(74, newline);
        str_1_1.add(75, str_1_1_1);
        str_1.add(76, str_1_1);
        str.add(77, str_1);
        str.add(78, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(80, new Range(79, "letter", "a", "z"));
        letter.add(82, new Range(81, "letter", "A", "Z"));
        letter.add(84, new Str(83, "_"));
        letter.add(86, new Str(85, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(87, letter);
        Optional name_1 = new Optional(88, "name_1");
        Repeat name_1_1 = new Repeat(89, "name_1_1");
        OrList name_1_1_1 = new OrList(90, "name_1_1_1");
        name_1_1_1.add(91, letter);
        name_1_1_1.add(92, digit);
        name_1_1.add(93, name_1_1_1);
        name_1.add(94, name_1_1);
        name.add(95, name_1);

        // public = ["public" ws]
        _public.add(97, new Str(96, "public"));
        _public.add(98, ws);

        // packagename = name ["." name|"*"]+
        packagename.add(99, name);
        Optional packagename_1 = new Optional(100, "packagename_1");
        Repeat packagename_1_1 = new Repeat(101, "packagename_1_1");
        packagename_1_1.add(103, new Str(102, "."));
        OrList packagename_1_1_1 = new OrList(104, "packagename_1_1_1");
        packagename_1_1_1.add(105, name);
        packagename_1_1_1.add(107, new Str(106, "*"));
        packagename_1_1.add(108, packagename_1_1_1);
        packagename_1.add(109, packagename_1_1);
        packagename.add(110, packagename_1);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(112, new Str(111, "package"));
        packagestatement.add(113, ws);
        packagestatement.add(114, packagename, creatorPackagestatementPackagename);
        packagestatement.add(115, s);
        packagestatement.add(117, new Str(116, ";"));

        // fullclassname = packagename
        fullclassname.add(118, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(120, new Str(119, "import"));
        importstatement.add(121, ws);
        Optional importstatement_1 = new Optional(122, "importstatement_1");
        importstatement_1.add(124, new Str(123, "static"));
        importstatement_1.add(125, ws);
        importstatement.add(126, importstatement_1);
        importstatement.add(127, fullclassname);
        importstatement.add(128, s);
        importstatement.add(130, new Str(129, ";"));
        importstatement.add(131, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(132, "imports_1");
        imports_1.add(133, importstatement);
        imports.add(134, imports_1);

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(136, new Str(135, "{"));
        statement.add(137, s);
        Optional statement_1 = new Optional(138, "statement_1");
        Repeat statement_1_1 = new Repeat(139, "statement_1_1");
        OrList statement_1_1_1 = new OrList(140, "statement_1_1_1");
        statement_1_1_1.add(141, statement);
        statement_1_1_1.add(142, str);
        statement_1_1_1.add(144, new Str(143, "}", NOT));
        statement_1_1.add(145, statement_1_1_1);
        statement_1.add(146, statement_1_1);
        statement.add(147, statement_1);
        statement.add(149, new Str(148, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(150, s);
        parameter.add(151, name, parameterParameterType);
        parameter.add(152, ws);
        parameter.add(153, name, parameterParameterVariable);
        parameter.add(154, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(155, "parameters_1");
        parameters_1.add(156, parameter, parametersParametersParameter);
        parameters.add(157, parameters_1);
        Optional parameters_2 = new Optional(158, "parameters_2");
        Repeat parameters_2_1 = new Repeat(159, "parameters_2_1");
        parameters_2_1.add(161, new Str(160, ","));
        parameters_2_1.add(162, s);
        parameters_2_1.add(163, parameter, parametersParametersParameter);
        parameters_2.add(164, parameters_2_1);
        parameters.add(165, parameters_2);

        // asMethod = s:spaces "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s statement
        asMethod.add(166, s, asMethodAsMethodSpaces);
        asMethod.add(168, new Str(167, "public"));
        asMethod.add(169, s);
        asMethod.add(170, name, asMethodAsMethodReturnclass);
        asMethod.add(171, ws);
        ElementList asMethod_1 = new ElementList(172, "asMethod_1", asMethodAsMethodMethodName);
        asMethod_1.add(174, new Str(173, "as"));
        asMethod_1.add(175, name);
        asMethod.add(176, asMethod_1);
        asMethod.add(177, s);
        asMethod.add(179, new Str(178, "("));
        asMethod.add(180, s);
        asMethod.add(181, parameters, asMethodAsMethodParameters);
        asMethod.add(182, s);
        asMethod.add(184, new Str(183, ")"));
        asMethod.add(185, s);
        asMethod.add(186, statement, asMethodAsMethodStatement);

        // classStatement =
        //   "@Creator" ws public "class" ws name:classname s "implements" s name s "{" s
        //   "private final" s name:stateClass s "state;" asMethod+
        classStatement.add(188, new Str(187, "@Creator"));
        classStatement.add(189, ws);
        classStatement.add(190, _public);
        classStatement.add(192, new Str(191, "class"));
        classStatement.add(193, ws);
        classStatement.add(194, name, classStatementClassStatementClassname);
        classStatement.add(195, s);
        classStatement.add(197, new Str(196, "implements"));
        classStatement.add(198, s);
        classStatement.add(199, name);
        classStatement.add(200, s);
        classStatement.add(202, new Str(201, "{"));
        classStatement.add(203, s);
        classStatement.add(205, new Str(204, "private final"));
        classStatement.add(206, s);
        classStatement.add(207, name, classStatementClassStatementStateClass);
        classStatement.add(208, s);
        classStatement.add(210, new Str(209, "state;"));
        Repeat classStatement_1 = new Repeat(211, "classStatement_1");
        classStatement_1.add(212, asMethod, classStatementClassStatementAsMethod);
        classStatement.add(213, classStatement_1);

        // manualEnd = ("}" s END)
        manualEnd.add(215, new Str(214, "}"));
        manualEnd.add(216, s);
        manualEnd.add(218, new End(217, "manualEnd"));

        // generatedEnd = "// ===== Constructors ====="

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(219, "manualCode_1");
        manualCode_1.add(220, manualEnd);
        manualCode_1.add(221, generatedEnd);
        manualCode.add(222, manualCode_1, NOT);

        // creator = packagestatement s imports s classStatement manualCode *
        creator.add(223, packagestatement);
        creator.add(224, s);
        creator.add(225, imports, creatorCreatorImports);
        creator.add(226, s);
        creator.add(227, classStatement, creatorCreatorClassStatement);
        creator.add(228, manualCode, creatorCreatorManualCode);
        creator.add(230, new Complete(229, "creator"));

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
        ElementList classStatement = new ElementList(20, "classStatement");
        ElementList manualEnd = new ElementList(21, "manualEnd");
        Str generatedEnd = new Str(22, "// ===== Constructors =====");
        Repeat manualCode = new Repeat(23, "manualCode");
        ElementList creator = new ElementList(24, "creator");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(26, new Str(25, "\r\n"));
        newline.add(28, new Str(27, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(29, "comment_1");
        comment_1.add(31, new Str(30, "/*"));
        Optional comment_1_1 = new Optional(32, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(33, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(34, "comment_1_1_1_1");
        comment_1_1_1_1.add(35, comment);
        comment_1_1_1_1.add(37, new Str(36, "*/", NOT));
        comment_1_1_1.add(38, comment_1_1_1_1);
        comment_1_1.add(39, comment_1_1_1);
        comment_1.add(40, comment_1_1);
        comment_1.add(42, new Str(41, "*/"));
        comment.add(43, comment_1);
        ElementList comment_2 = new ElementList(44, "comment_2");
        comment_2.add(46, new Str(45, "//"));
        Optional comment_2_1 = new Optional(47, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(48, "comment_2_1_1");
        comment_2_1_1.add(49, newline, NOT);
        comment_2_1.add(50, comment_2_1_1);
        comment_2.add(51, comment_2_1);
        OrList comment_2_2 = new OrList(52, "comment_2_2");
        comment_2_2.add(53, newline);
        comment_2_2.add(55, new End(54, "comment_2_2"));
        comment_2.add(56, comment_2_2);
        comment.add(57, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(58, "ws_1");
        ws_1.add(59, newline);
        ws_1.add(61, new Str(60, " "));
        ws_1.add(63, new Str(62, "\t"));
        ws_1.add(64, comment);
        ws.add(65, ws_1);

        // s = [ws]
        s.add(66, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(67, ff);
        Repeat str_1 = new Repeat(68, "str_1");
        OrList str_1_1 = new OrList(69, "str_1_1");
        str_1_1.add(71, new Str(70, "\\\""));
        OrList str_1_1_1 = new OrList(72, "str_1_1_1", NOT);
        str_1_1_1.add(73, ff);
        str_1_1_1.add(74, newline);
        str_1_1.add(75, str_1_1_1);
        str_1.add(76, str_1_1);
        str.add(77, str_1);
        str.add(78, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(80, new Range(79, "letter", "a", "z"));
        letter.add(82, new Range(81, "letter", "A", "Z"));
        letter.add(84, new Str(83, "_"));
        letter.add(86, new Str(85, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(87, letter);
        Optional name_1 = new Optional(88, "name_1");
        Repeat name_1_1 = new Repeat(89, "name_1_1");
        OrList name_1_1_1 = new OrList(90, "name_1_1_1");
        name_1_1_1.add(91, letter);
        name_1_1_1.add(92, digit);
        name_1_1.add(93, name_1_1_1);
        name_1.add(94, name_1_1);
        name.add(95, name_1);

        // public = ["public" ws]
        _public.add(97, new Str(96, "public"));
        _public.add(98, ws);

        // packagename = name ["." name|"*"]+
        packagename.add(99, name);
        Optional packagename_1 = new Optional(100, "packagename_1");
        Repeat packagename_1_1 = new Repeat(101, "packagename_1_1");
        packagename_1_1.add(103, new Str(102, "."));
        OrList packagename_1_1_1 = new OrList(104, "packagename_1_1_1");
        packagename_1_1_1.add(105, name);
        packagename_1_1_1.add(107, new Str(106, "*"));
        packagename_1_1.add(108, packagename_1_1_1);
        packagename_1.add(109, packagename_1_1);
        packagename.add(110, packagename_1);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(112, new Str(111, "package"));
        packagestatement.add(113, ws);
        packagestatement.add(114, packagename);
        packagestatement.add(115, s);
        packagestatement.add(117, new Str(116, ";"));

        // fullclassname = packagename
        fullclassname.add(118, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(120, new Str(119, "import"));
        importstatement.add(121, ws);
        Optional importstatement_1 = new Optional(122, "importstatement_1");
        importstatement_1.add(124, new Str(123, "static"));
        importstatement_1.add(125, ws);
        importstatement.add(126, importstatement_1);
        importstatement.add(127, fullclassname);
        importstatement.add(128, s);
        importstatement.add(130, new Str(129, ";"));
        importstatement.add(131, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(132, "imports_1");
        imports_1.add(133, importstatement);
        imports.add(134, imports_1);

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(136, new Str(135, "{"));
        statement.add(137, s);
        Optional statement_1 = new Optional(138, "statement_1");
        Repeat statement_1_1 = new Repeat(139, "statement_1_1");
        OrList statement_1_1_1 = new OrList(140, "statement_1_1_1");
        statement_1_1_1.add(141, statement);
        statement_1_1_1.add(142, str);
        statement_1_1_1.add(144, new Str(143, "}", NOT));
        statement_1_1.add(145, statement_1_1_1);
        statement_1.add(146, statement_1_1);
        statement.add(147, statement_1);
        statement.add(149, new Str(148, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(150, s);
        parameter.add(151, name);
        parameter.add(152, ws);
        parameter.add(153, name);
        parameter.add(154, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(155, "parameters_1");
        parameters_1.add(156, parameter);
        parameters.add(157, parameters_1);
        Optional parameters_2 = new Optional(158, "parameters_2");
        Repeat parameters_2_1 = new Repeat(159, "parameters_2_1");
        parameters_2_1.add(161, new Str(160, ","));
        parameters_2_1.add(162, s);
        parameters_2_1.add(163, parameter);
        parameters_2.add(164, parameters_2_1);
        parameters.add(165, parameters_2);

        // asMethod = s:spaces "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s statement
        asMethod.add(166, s);
        asMethod.add(168, new Str(167, "public"));
        asMethod.add(169, s);
        asMethod.add(170, name);
        asMethod.add(171, ws);
        ElementList asMethod_1 = new ElementList(172, "asMethod_1");
        asMethod_1.add(174, new Str(173, "as"));
        asMethod_1.add(175, name);
        asMethod.add(176, asMethod_1);
        asMethod.add(177, s);
        asMethod.add(179, new Str(178, "("));
        asMethod.add(180, s);
        asMethod.add(181, parameters);
        asMethod.add(182, s);
        asMethod.add(184, new Str(183, ")"));
        asMethod.add(185, s);
        asMethod.add(186, statement);

        // classStatement =
        //   "@Creator" ws public "class" ws name:classname s "implements" s name s "{" s
        //   "private final" s name:stateClass s "state;" asMethod+
        classStatement.add(188, new Str(187, "@Creator"));
        classStatement.add(189, ws);
        classStatement.add(190, _public);
        classStatement.add(192, new Str(191, "class"));
        classStatement.add(193, ws);
        classStatement.add(194, name);
        classStatement.add(195, s);
        classStatement.add(197, new Str(196, "implements"));
        classStatement.add(198, s);
        classStatement.add(199, name);
        classStatement.add(200, s);
        classStatement.add(202, new Str(201, "{"));
        classStatement.add(203, s);
        classStatement.add(205, new Str(204, "private final"));
        classStatement.add(206, s);
        classStatement.add(207, name);
        classStatement.add(208, s);
        classStatement.add(210, new Str(209, "state;"));
        Repeat classStatement_1 = new Repeat(211, "classStatement_1");
        classStatement_1.add(212, asMethod);
        classStatement.add(213, classStatement_1);

        // manualEnd = ("}" s END)
        manualEnd.add(215, new Str(214, "}"));
        manualEnd.add(216, s);
        manualEnd.add(218, new End(217, "manualEnd"));

        // generatedEnd = "// ===== Constructors ====="

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(219, "manualCode_1");
        manualCode_1.add(220, manualEnd);
        manualCode_1.add(221, generatedEnd);
        manualCode.add(222, manualCode_1, NOT);

        // creator = packagestatement s imports s classStatement manualCode *
        creator.add(223, packagestatement);
        creator.add(224, s);
        creator.add(225, imports);
        creator.add(226, s);
        creator.add(227, classStatement);
        creator.add(228, manualCode);
        creator.add(230, new Complete(229, "creator"));

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

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void setStateClass(String stateClass);
        public void addAsMethod(IAsMethod iasMethod);
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
