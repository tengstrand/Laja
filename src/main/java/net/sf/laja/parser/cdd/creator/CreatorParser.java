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
 * Auto generated 2013-05-23 by Laja:
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
        Data.ParameterParameterType parameterParameterType = data2.new ParameterParameterType("parameterParameterType");
        Data.ParameterParameterVariable parameterParameterVariable = data2.new ParameterParameterVariable("parameterParameterVariable");
        Data.ParametersParametersParameter parametersParametersParameter = data2.new ParametersParametersParameter("parametersParametersParameter");
        Data.AsMethodAsMethodReturnclass asMethodAsMethodReturnclass = data2.new AsMethodAsMethodReturnclass("asMethodAsMethodReturnclass");
        Data.AsMethodAsMethodMethodName asMethodAsMethodMethodName = data2.new AsMethodAsMethodMethodName("asMethodAsMethodMethodName");
        Data.AsMethodAsMethodParameters asMethodAsMethodParameters = data2.new AsMethodAsMethodParameters("asMethodAsMethodParameters");
        Data.AsMethodAsMethodStatement asMethodAsMethodStatement = data2.new AsMethodAsMethodStatement("asMethodAsMethodStatement");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementAsMethod classStatementClassStatementAsMethod = data2.new ClassStatementClassStatementAsMethod("classStatementClassStatementAsMethod");
        Data.CreatorCreatorImports creatorCreatorImports = data2.new CreatorCreatorImports("creatorCreatorImports");
        Data.CreatorCreatorClassStatement creatorCreatorClassStatement = data2.new CreatorCreatorClassStatement("creatorCreatorClassStatement");

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
        ElementList creator = new ElementList(21, "creator");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(23, new Str(22, "\r\n"));
        newline.add(25, new Str(24, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(26, "comment_1");
        comment_1.add(28, new Str(27, "/*"));
        Optional comment_1_1 = new Optional(29, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(30, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(31, "comment_1_1_1_1");
        comment_1_1_1_1.add(32, comment);
        comment_1_1_1_1.add(34, new Str(33, "*/", NOT));
        comment_1_1_1.add(35, comment_1_1_1_1);
        comment_1_1.add(36, comment_1_1_1);
        comment_1.add(37, comment_1_1);
        comment_1.add(39, new Str(38, "*/"));
        comment.add(40, comment_1);
        ElementList comment_2 = new ElementList(41, "comment_2");
        comment_2.add(43, new Str(42, "//"));
        Optional comment_2_1 = new Optional(44, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(45, "comment_2_1_1");
        comment_2_1_1.add(46, newline, NOT);
        comment_2_1.add(47, comment_2_1_1);
        comment_2.add(48, comment_2_1);
        OrList comment_2_2 = new OrList(49, "comment_2_2");
        comment_2_2.add(50, newline);
        comment_2_2.add(52, new End(51, "comment_2_2"));
        comment_2.add(53, comment_2_2);
        comment.add(54, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(55, "ws_1");
        ws_1.add(56, newline);
        ws_1.add(58, new Str(57, " "));
        ws_1.add(60, new Str(59, "\t"));
        ws_1.add(61, comment);
        ws.add(62, ws_1);

        // s = [ws]
        s.add(63, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(64, ff);
        Repeat str_1 = new Repeat(65, "str_1");
        OrList str_1_1 = new OrList(66, "str_1_1");
        str_1_1.add(68, new Str(67, "\\\""));
        OrList str_1_1_1 = new OrList(69, "str_1_1_1", NOT);
        str_1_1_1.add(70, ff);
        str_1_1_1.add(71, newline);
        str_1_1.add(72, str_1_1_1);
        str_1.add(73, str_1_1);
        str.add(74, str_1);
        str.add(75, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(77, new Range(76, "letter", "a", "z"));
        letter.add(79, new Range(78, "letter", "A", "Z"));
        letter.add(81, new Str(80, "_"));
        letter.add(83, new Str(82, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(84, letter);
        Optional name_1 = new Optional(85, "name_1");
        Repeat name_1_1 = new Repeat(86, "name_1_1");
        OrList name_1_1_1 = new OrList(87, "name_1_1_1");
        name_1_1_1.add(88, letter);
        name_1_1_1.add(89, digit);
        name_1_1.add(90, name_1_1_1);
        name_1.add(91, name_1_1);
        name.add(92, name_1);

        // public = ["public" ws]
        _public.add(94, new Str(93, "public"));
        _public.add(95, ws);

        // packagename = name ["." name|"*"]+
        packagename.add(96, name);
        Optional packagename_1 = new Optional(97, "packagename_1");
        Repeat packagename_1_1 = new Repeat(98, "packagename_1_1");
        packagename_1_1.add(100, new Str(99, "."));
        OrList packagename_1_1_1 = new OrList(101, "packagename_1_1_1");
        packagename_1_1_1.add(102, name);
        packagename_1_1_1.add(104, new Str(103, "*"));
        packagename_1_1.add(105, packagename_1_1_1);
        packagename_1.add(106, packagename_1_1);
        packagename.add(107, packagename_1);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(109, new Str(108, "package"));
        packagestatement.add(110, ws);
        packagestatement.add(111, packagename);
        packagestatement.add(112, s);
        packagestatement.add(114, new Str(113, ";"));

        // fullclassname = packagename
        fullclassname.add(115, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(117, new Str(116, "import"));
        importstatement.add(118, ws);
        Optional importstatement_1 = new Optional(119, "importstatement_1");
        importstatement_1.add(121, new Str(120, "static"));
        importstatement_1.add(122, ws);
        importstatement.add(123, importstatement_1);
        importstatement.add(124, fullclassname);
        importstatement.add(125, s);
        importstatement.add(127, new Str(126, ";"));
        importstatement.add(128, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(129, "imports_1");
        imports_1.add(130, importstatement);
        imports.add(131, imports_1);

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(133, new Str(132, "{"));
        statement.add(134, s);
        Optional statement_1 = new Optional(135, "statement_1");
        Repeat statement_1_1 = new Repeat(136, "statement_1_1");
        OrList statement_1_1_1 = new OrList(137, "statement_1_1_1");
        statement_1_1_1.add(138, statement);
        statement_1_1_1.add(139, str);
        statement_1_1_1.add(141, new Str(140, "}", NOT));
        statement_1_1.add(142, statement_1_1_1);
        statement_1.add(143, statement_1_1);
        statement.add(144, statement_1);
        statement.add(146, new Str(145, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(147, s);
        parameter.add(148, name, parameterParameterType);
        parameter.add(149, ws);
        parameter.add(150, name, parameterParameterVariable);
        parameter.add(151, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(152, "parameters_1");
        parameters_1.add(153, parameter, parametersParametersParameter);
        parameters.add(154, parameters_1);
        Optional parameters_2 = new Optional(155, "parameters_2");
        Repeat parameters_2_1 = new Repeat(156, "parameters_2_1");
        parameters_2_1.add(158, new Str(157, ","));
        parameters_2_1.add(159, s);
        parameters_2_1.add(160, parameter, parametersParametersParameter);
        parameters_2.add(161, parameters_2_1);
        parameters.add(162, parameters_2);

        // asMethod = "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s statement s
        asMethod.add(164, new Str(163, "public"));
        asMethod.add(165, s);
        asMethod.add(166, name, asMethodAsMethodReturnclass);
        asMethod.add(167, ws);
        ElementList asMethod_1 = new ElementList(168, "asMethod_1", asMethodAsMethodMethodName);
        asMethod_1.add(170, new Str(169, "as"));
        asMethod_1.add(171, name);
        asMethod.add(172, asMethod_1);
        asMethod.add(173, s);
        asMethod.add(175, new Str(174, "("));
        asMethod.add(176, s);
        asMethod.add(177, parameters, asMethodAsMethodParameters);
        asMethod.add(178, s);
        asMethod.add(180, new Str(179, ")"));
        asMethod.add(181, s);
        asMethod.add(182, statement, asMethodAsMethodStatement);
        asMethod.add(183, s);

        // classStatement =
        //   "@Creator" ws public "class" ws name:classname s "implements" s name s "{" s
        //   "private final" s name s "state;" s asMethod+ *
        classStatement.add(185, new Str(184, "@Creator"));
        classStatement.add(186, ws);
        classStatement.add(187, _public);
        classStatement.add(189, new Str(188, "class"));
        classStatement.add(190, ws);
        classStatement.add(191, name, classStatementClassStatementClassname);
        classStatement.add(192, s);
        classStatement.add(194, new Str(193, "implements"));
        classStatement.add(195, s);
        classStatement.add(196, name);
        classStatement.add(197, s);
        classStatement.add(199, new Str(198, "{"));
        classStatement.add(200, s);
        classStatement.add(202, new Str(201, "private final"));
        classStatement.add(203, s);
        classStatement.add(204, name);
        classStatement.add(205, s);
        classStatement.add(207, new Str(206, "state;"));
        classStatement.add(208, s);
        Repeat classStatement_1 = new Repeat(209, "classStatement_1");
        classStatement_1.add(210, asMethod, classStatementClassStatementAsMethod);
        classStatement.add(211, classStatement_1);
        classStatement.add(213, new Complete(212, "classStatement"));

        // creator = packagestatement s imports s classStatement
        creator.add(214, packagestatement);
        creator.add(215, s);
        creator.add(216, imports, creatorCreatorImports);
        creator.add(217, s);
        creator.add(218, classStatement, creatorCreatorClassStatement);

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
        ElementList creator = new ElementList(21, "creator");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(23, new Str(22, "\r\n"));
        newline.add(25, new Str(24, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(26, "comment_1");
        comment_1.add(28, new Str(27, "/*"));
        Optional comment_1_1 = new Optional(29, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(30, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(31, "comment_1_1_1_1");
        comment_1_1_1_1.add(32, comment);
        comment_1_1_1_1.add(34, new Str(33, "*/", NOT));
        comment_1_1_1.add(35, comment_1_1_1_1);
        comment_1_1.add(36, comment_1_1_1);
        comment_1.add(37, comment_1_1);
        comment_1.add(39, new Str(38, "*/"));
        comment.add(40, comment_1);
        ElementList comment_2 = new ElementList(41, "comment_2");
        comment_2.add(43, new Str(42, "//"));
        Optional comment_2_1 = new Optional(44, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(45, "comment_2_1_1");
        comment_2_1_1.add(46, newline, NOT);
        comment_2_1.add(47, comment_2_1_1);
        comment_2.add(48, comment_2_1);
        OrList comment_2_2 = new OrList(49, "comment_2_2");
        comment_2_2.add(50, newline);
        comment_2_2.add(52, new End(51, "comment_2_2"));
        comment_2.add(53, comment_2_2);
        comment.add(54, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(55, "ws_1");
        ws_1.add(56, newline);
        ws_1.add(58, new Str(57, " "));
        ws_1.add(60, new Str(59, "\t"));
        ws_1.add(61, comment);
        ws.add(62, ws_1);

        // s = [ws]
        s.add(63, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(64, ff);
        Repeat str_1 = new Repeat(65, "str_1");
        OrList str_1_1 = new OrList(66, "str_1_1");
        str_1_1.add(68, new Str(67, "\\\""));
        OrList str_1_1_1 = new OrList(69, "str_1_1_1", NOT);
        str_1_1_1.add(70, ff);
        str_1_1_1.add(71, newline);
        str_1_1.add(72, str_1_1_1);
        str_1.add(73, str_1_1);
        str.add(74, str_1);
        str.add(75, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(77, new Range(76, "letter", "a", "z"));
        letter.add(79, new Range(78, "letter", "A", "Z"));
        letter.add(81, new Str(80, "_"));
        letter.add(83, new Str(82, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(84, letter);
        Optional name_1 = new Optional(85, "name_1");
        Repeat name_1_1 = new Repeat(86, "name_1_1");
        OrList name_1_1_1 = new OrList(87, "name_1_1_1");
        name_1_1_1.add(88, letter);
        name_1_1_1.add(89, digit);
        name_1_1.add(90, name_1_1_1);
        name_1.add(91, name_1_1);
        name.add(92, name_1);

        // public = ["public" ws]
        _public.add(94, new Str(93, "public"));
        _public.add(95, ws);

        // packagename = name ["." name|"*"]+
        packagename.add(96, name);
        Optional packagename_1 = new Optional(97, "packagename_1");
        Repeat packagename_1_1 = new Repeat(98, "packagename_1_1");
        packagename_1_1.add(100, new Str(99, "."));
        OrList packagename_1_1_1 = new OrList(101, "packagename_1_1_1");
        packagename_1_1_1.add(102, name);
        packagename_1_1_1.add(104, new Str(103, "*"));
        packagename_1_1.add(105, packagename_1_1_1);
        packagename_1.add(106, packagename_1_1);
        packagename.add(107, packagename_1);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(109, new Str(108, "package"));
        packagestatement.add(110, ws);
        packagestatement.add(111, packagename);
        packagestatement.add(112, s);
        packagestatement.add(114, new Str(113, ";"));

        // fullclassname = packagename
        fullclassname.add(115, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(117, new Str(116, "import"));
        importstatement.add(118, ws);
        Optional importstatement_1 = new Optional(119, "importstatement_1");
        importstatement_1.add(121, new Str(120, "static"));
        importstatement_1.add(122, ws);
        importstatement.add(123, importstatement_1);
        importstatement.add(124, fullclassname);
        importstatement.add(125, s);
        importstatement.add(127, new Str(126, ";"));
        importstatement.add(128, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(129, "imports_1");
        imports_1.add(130, importstatement);
        imports.add(131, imports_1);

        // statement = "{" s [(statement | str | !"}")+]:innerStatement "}"
        statement.add(133, new Str(132, "{"));
        statement.add(134, s);
        Optional statement_1 = new Optional(135, "statement_1");
        Repeat statement_1_1 = new Repeat(136, "statement_1_1");
        OrList statement_1_1_1 = new OrList(137, "statement_1_1_1");
        statement_1_1_1.add(138, statement);
        statement_1_1_1.add(139, str);
        statement_1_1_1.add(141, new Str(140, "}", NOT));
        statement_1_1.add(142, statement_1_1_1);
        statement_1.add(143, statement_1_1);
        statement.add(144, statement_1);
        statement.add(146, new Str(145, "}"));

        // parameter = s name:type ws name:variable s
        parameter.add(147, s);
        parameter.add(148, name);
        parameter.add(149, ws);
        parameter.add(150, name);
        parameter.add(151, s);

        // parameters = [parameter] ["," s parameter]+
        Optional parameters_1 = new Optional(152, "parameters_1");
        parameters_1.add(153, parameter);
        parameters.add(154, parameters_1);
        Optional parameters_2 = new Optional(155, "parameters_2");
        Repeat parameters_2_1 = new Repeat(156, "parameters_2_1");
        parameters_2_1.add(158, new Str(157, ","));
        parameters_2_1.add(159, s);
        parameters_2_1.add(160, parameter);
        parameters_2.add(161, parameters_2_1);
        parameters.add(162, parameters_2);

        // asMethod = "public" s name:returnclass ws ("as" name):methodName s "(" s parameters s ")" s statement s
        asMethod.add(164, new Str(163, "public"));
        asMethod.add(165, s);
        asMethod.add(166, name);
        asMethod.add(167, ws);
        ElementList asMethod_1 = new ElementList(168, "asMethod_1");
        asMethod_1.add(170, new Str(169, "as"));
        asMethod_1.add(171, name);
        asMethod.add(172, asMethod_1);
        asMethod.add(173, s);
        asMethod.add(175, new Str(174, "("));
        asMethod.add(176, s);
        asMethod.add(177, parameters);
        asMethod.add(178, s);
        asMethod.add(180, new Str(179, ")"));
        asMethod.add(181, s);
        asMethod.add(182, statement);
        asMethod.add(183, s);

        // classStatement =
        //   "@Creator" ws public "class" ws name:classname s "implements" s name s "{" s
        //   "private final" s name s "state;" s asMethod+ *
        classStatement.add(185, new Str(184, "@Creator"));
        classStatement.add(186, ws);
        classStatement.add(187, _public);
        classStatement.add(189, new Str(188, "class"));
        classStatement.add(190, ws);
        classStatement.add(191, name);
        classStatement.add(192, s);
        classStatement.add(194, new Str(193, "implements"));
        classStatement.add(195, s);
        classStatement.add(196, name);
        classStatement.add(197, s);
        classStatement.add(199, new Str(198, "{"));
        classStatement.add(200, s);
        classStatement.add(202, new Str(201, "private final"));
        classStatement.add(203, s);
        classStatement.add(204, name);
        classStatement.add(205, s);
        classStatement.add(207, new Str(206, "state;"));
        classStatement.add(208, s);
        Repeat classStatement_1 = new Repeat(209, "classStatement_1");
        classStatement_1.add(210, asMethod);
        classStatement.add(211, classStatement_1);
        classStatement.add(213, new Complete(212, "classStatement"));

        // creator = packagestatement s imports s classStatement
        creator.add(214, packagestatement);
        creator.add(215, s);
        creator.add(216, imports);
        creator.add(217, s);
        creator.add(218, classStatement);

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
        public void setReturnclass(String returnclass);
        public void setMethodName(String methodName);
        public void setParameters(IParameters iparameters);
        public void setStatement(String statement);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void addAsMethod(IAsMethod iasMethod);
    }

    // Creator
    public interface ICreator {
        public void setImports(String imports);
        public void setClassStatement(IClassStatement iclassStatement);
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

        // AsMethod asMethod.setReturnclass(String returnclass);
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

        // Creator creator.setImports(String imports);
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
    }
}
