package net.sf.laja.parser.cdd.state;

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
 * Auto generated 2013-05-10 by Laja:
 *    http://laja.sf.net
 *
 * Version: laja2-006-alpha
 */
public final class StateParser implements net.sf.laja.parser.engine2.Parser {
    private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
    private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
    private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

    private Data data1;
    private Data data2;
    private IStateFactory factory1;
    private IStateFactory factory2;
    private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
    private SyntaxErrorHandler syntaxErrorHandler;

    public static final int PHASE1 = 1;
    public static final int PHASE2 = 2;

    public StateParser(IStateFactoryFactory factoryFactory) {
        init(factoryFactory);
    }

    public void init(IStateFactoryFactory factoryFactory) {
        syntaxErrorHandler = new DefaultSyntaxErrorHandler();
        factory1 = factoryFactory.getFactory(PHASE1);
        factory2 = factoryFactory.getFactory(PHASE2);
        data1 = new Data(factory1);
        data2 = new Data(factory2);
    }

    public StateParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
        sourceRecorderLogWriter = writer;
        return this;
    }

    public StateParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
        this.syntaxErrorHandler = syntaxErrorHandler;
        return this;
    }

    public IStateFactory getFactory1() {
        return factory1;
    }

    public IStateFactory getFactory() {
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
        Data.AttributeType attributeType = data2.new AttributeType("attributeType");
        Data.StatePackagestatementPackagename statePackagestatementPackagename = data2.new StatePackagestatementPackagename("statePackagestatementPackagename");
        Data.ImportstatementImportstatementStatic importstatementImportstatementStatic = data2.new ImportstatementImportstatementStatic("importstatementImportstatementStatic");
        Data.ImportstatementImportstatementFullclassname importstatementImportstatementFullclassname = data2.new ImportstatementImportstatementFullclassname("importstatementImportstatementFullclassname");
        Data.ImportsImportsImportstatement importsImportsImportstatement = data2.new ImportsImportsImportstatement("importsImportsImportstatement");
        Data.AttributeAnnotationsAnnotation attributeAnnotationsAnnotation = data2.new AttributeAnnotationsAnnotation("attributeAnnotationsAnnotation");
        Data.CollectionTypeCollectionTypeType collectionTypeCollectionTypeType = data2.new CollectionTypeCollectionTypeType("collectionTypeCollectionTypeType");
        Data.MapTypeMapTypeKey mapTypeMapTypeKey = data2.new MapTypeMapTypeKey("mapTypeMapTypeKey");
        Data.MapTypeMapTypeEntry mapTypeMapTypeEntry = data2.new MapTypeMapTypeEntry("mapTypeMapTypeEntry");
        Data.TypeTypeName typeTypeName = data2.new TypeTypeName("typeTypeName");
        Data.TypeTypeCollectionType typeTypeCollectionType = data2.new TypeTypeCollectionType("typeTypeCollectionType");
        Data.TypeTypeMapType typeTypeMapType = data2.new TypeTypeMapType("typeTypeMapType");
        Data.AttributeAttributeAnnotations attributeAttributeAnnotations = data2.new AttributeAttributeAnnotations("attributeAttributeAnnotations");
        Data.AttributeAttributeType attributeAttributeType = data2.new AttributeAttributeType("attributeAttributeType");
        Data.AttributeAttributeVariable attributeAttributeVariable = data2.new AttributeAttributeVariable("attributeAttributeVariable");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementAttribute classStatementClassStatementAttribute = data2.new ClassStatementClassStatementAttribute("classStatementClassStatementAttribute");
        Data.ClassStatementClassStatementManualCode classStatementClassStatementManualCode = data2.new ClassStatementClassStatementManualCode("classStatementClassStatementManualCode");
        Data.ClassStatementClassStatementGeneratedEnd classStatementClassStatementGeneratedEnd = data2.new ClassStatementClassStatementGeneratedEnd("classStatementClassStatementGeneratedEnd");
        Data.StateStateImports stateStateImports = data2.new StateStateImports("stateStateImports");
        Data.StateStateClassStatement stateStateClassStatement = data2.new StateStateClassStatement("stateStateClassStatement");

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
        Optional annotations = new Optional(16, "annotations");
        Optional keywords = new Optional(17, "keywords");
        ElementList collectionType = new ElementList(18, "collectionType");
        ElementList mapType = new ElementList(19, "mapType");
        ElementList type = new ElementList(20, "type", attributeType);
        ElementList attribute = new ElementList(21, "attribute");
        ElementList uname = new ElementList(22, "uname");
        ElementList getter = new ElementList(23, "getter");
        ElementList body = new ElementList(24, "body");
        ElementList manualEnd = new ElementList(25, "manualEnd");
        ElementList generatedEnd = new ElementList(26, "generatedEnd");
        Repeat manualCode = new Repeat(27, "manualCode");
        ElementList classStatement = new ElementList(28, "classStatement");
        ElementList state = new ElementList(29, "state");

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
        packagestatement.add(107, packagename, statePackagestatementPackagename);
        packagestatement.add(108, s);
        packagestatement.add(110, new Str(109, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(111, name);
        Optional packagename_1 = new Optional(112, "packagename_1");
        Repeat packagename_1_1 = new Repeat(113, "packagename_1_1");
        packagename_1_1.add(115, new Str(114, "."));
        OrList packagename_1_1_1 = new OrList(116, "packagename_1_1_1");
        packagename_1_1_1.add(117, name);
        packagename_1_1_1.add(119, new Str(118, "*"));
        packagename_1_1.add(120, packagename_1_1_1);
        packagename_1.add(121, packagename_1_1);
        packagename.add(122, packagename_1);

        // fullclassname = packagename
        fullclassname.add(123, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(125, new Str(124, "import"));
        importstatement.add(126, ws);
        Optional importstatement_1 = new Optional(127, "importstatement_1");
        importstatement_1.add(129, new Str(128, "static", importstatementImportstatementStatic));
        importstatement_1.add(130, ws);
        importstatement.add(131, importstatement_1);
        importstatement.add(132, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(133, s);
        importstatement.add(135, new Str(134, ";"));
        importstatement.add(136, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(137, "imports_1");
        imports_1.add(138, importstatement, importsImportsImportstatement);
        imports.add(139, imports_1);

        // annotations = [("@" name s):annotation]+
        Repeat annotations_1 = new Repeat(140, "annotations_1");
        annotations_1.add(142, new Str(141, "@"));
        annotations_1.add(143, name);
        annotations_1.add(144, s);
        annotations.add(145, annotations_1);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(146, "keywords_1");
        OrList keywords_1_1 = new OrList(147, "keywords_1_1");
        keywords_1_1.add(149, new Str(148, "public "));
        keywords_1_1.add(151, new Str(150, "private "));
        keywords_1_1.add(153, new Str(152, "final "));
        keywords_1.add(154, keywords_1_1);
        keywords_1.add(155, s);
        keywords.add(156, keywords_1);

        // collectionType = s "<" s type s ">"
        collectionType.add(157, s);
        collectionType.add(159, new Str(158, "<"));
        collectionType.add(160, s);
        collectionType.add(161, type, collectionTypeCollectionTypeType);
        collectionType.add(162, s);
        collectionType.add(164, new Str(163, ">"));

        // mapType = s "<" s type:key s "," s type:entry s ">"
        mapType.add(165, s);
        mapType.add(167, new Str(166, "<"));
        mapType.add(168, s);
        mapType.add(169, type, mapTypeMapTypeKey);
        mapType.add(170, s);
        mapType.add(172, new Str(171, ","));
        mapType.add(173, s);
        mapType.add(174, type, mapTypeMapTypeEntry);
        mapType.add(175, s);
        mapType.add(177, new Str(176, ">"));

        // type = name  [collectionType | mapType]
        type.add(178, name, typeTypeName);
        Optional type_1 = new Optional(179, "type_1");
        OrList type_1_1 = new OrList(180, "type_1_1");
        type_1_1.add(181, collectionType, typeTypeCollectionType);
        type_1_1.add(182, mapType, typeTypeMapType);
        type_1.add(183, type_1_1);
        type.add(184, type_1);

        // attribute = s annotations keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(185, s);
        attribute.add(186, annotations, attributeAttributeAnnotations);
        attribute.add(187, keywords);
        attribute.add(188, s);
        attribute.add(189, type, attributeAttributeType);
        attribute.add(190, ws);
        attribute.add(191, name, attributeAttributeVariable);
        attribute.add(192, s);
        attribute.add(194, new Str(193, ";"));
        Optional attribute_1 = new Optional(195, "attribute_1");
        Repeat attribute_1_1 = new Repeat(196, "attribute_1_1");
        attribute_1_1.add(197, newline, NOT);
        attribute_1.add(198, attribute_1_1);
        attribute.add(199, attribute_1);
        attribute.add(200, newline);

        // uname = "A".."Z" [letter | digit]+
        uname.add(202, new Range(201, "uname", "A", "Z"));
        Optional uname_1 = new Optional(203, "uname_1");
        Repeat uname_1_1 = new Repeat(204, "uname_1_1");
        OrList uname_1_1_1 = new OrList(205, "uname_1_1_1");
        uname_1_1_1.add(206, letter);
        uname_1_1_1.add(207, digit);
        uname_1_1.add(208, uname_1_1_1);
        uname_1.add(209, uname_1_1);
        uname.add(210, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(212, new Str(211, "get"));
        getter.add(213, uname);
        getter.add(214, s);
        getter.add(216, new Str(215, "("));
        getter.add(217, s);
        getter.add(219, new Str(218, ")"));

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(221, new Str(220, "{"));
        body.add(222, s);
        Optional body_1 = new Optional(223, "body_1");
        Repeat body_1_1 = new Repeat(224, "body_1_1");
        OrList body_1_1_1 = new OrList(225, "body_1_1_1");
        body_1_1_1.add(226, body);
        body_1_1_1.add(227, str);
        body_1_1_1.add(229, new Str(228, "}", NOT));
        body_1_1.add(230, body_1_1_1);
        body_1.add(231, body_1_1);
        body.add(232, body_1);
        body.add(234, new Str(233, "}"));

        // manualEnd = ("}" s END)
        manualEnd.add(236, new Str(235, "}"));
        manualEnd.add(237, s);
        manualEnd.add(239, new End(238, "manualEnd"));

        // generatedEnd = ("// Generated" *)
        generatedEnd.add(241, new Str(240, "// Generated"));
        generatedEnd.add(243, new Complete(242, "generatedEnd"));

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(244, "manualCode_1");
        manualCode_1.add(245, manualEnd);
        manualCode_1.add(246, generatedEnd);
        manualCode.add(247, manualCode_1, NOT);

        // classStatement =
        //   "@State" ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ manualCode
        //   manualEnd|generatedEnd *
        classStatement.add(249, new Str(248, "@State"));
        classStatement.add(250, ws);
        classStatement.add(251, _public);
        classStatement.add(253, new Str(252, "class"));
        classStatement.add(254, ws);
        classStatement.add(255, name, classStatementClassStatementClassname);
        classStatement.add(256, s);
        Optional classStatement_1 = new Optional(257, "classStatement_1");
        classStatement_1.add(259, new Str(258, "extends"));
        classStatement_1.add(260, ws);
        classStatement_1.add(261, name);
        classStatement_1.add(262, s);
        classStatement.add(263, classStatement_1);
        Optional classStatement_2 = new Optional(264, "classStatement_2");
        classStatement_2.add(266, new Str(265, "implements"));
        classStatement_2.add(267, ws);
        classStatement_2.add(268, name);
        Optional classStatement_2_1 = new Optional(269, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(270, "classStatement_2_1_1");
        classStatement_2_1_1.add(271, s);
        classStatement_2_1_1.add(273, new Str(272, ","));
        classStatement_2_1_1.add(274, s);
        classStatement_2_1_1.add(275, name);
        classStatement_2_1.add(276, classStatement_2_1_1);
        classStatement_2.add(277, classStatement_2_1);
        classStatement_2.add(278, s);
        classStatement.add(279, classStatement_2);
        classStatement.add(281, new Str(280, "{"));
        classStatement.add(282, s);
        Optional classStatement_3 = new Optional(283, "classStatement_3");
        Repeat classStatement_3_1 = new Repeat(284, "classStatement_3_1");
        classStatement_3_1.add(285, attribute, classStatementClassStatementAttribute);
        classStatement_3.add(286, classStatement_3_1);
        classStatement.add(287, classStatement_3);
        classStatement.add(288, manualCode, classStatementClassStatementManualCode);
        OrList classStatement_4 = new OrList(289, "classStatement_4");
        classStatement_4.add(290, manualEnd);
        classStatement_4.add(291, generatedEnd, classStatementClassStatementGeneratedEnd);
        classStatement.add(292, classStatement_4);
        classStatement.add(294, new Complete(293, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(295, s);
        state.add(296, packagestatement);
        state.add(297, s);
        state.add(298, imports, stateStateImports);
        state.add(299, s);
        state.add(300, classStatement, stateStateClassStatement);
        state.add(301, s);

        return new TopElement(data2, state);
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
        Optional annotations = new Optional(16, "annotations");
        Optional keywords = new Optional(17, "keywords");
        ElementList collectionType = new ElementList(18, "collectionType");
        ElementList mapType = new ElementList(19, "mapType");
        ElementList type = new ElementList(20, "type");
        ElementList attribute = new ElementList(21, "attribute");
        ElementList uname = new ElementList(22, "uname");
        ElementList getter = new ElementList(23, "getter");
        ElementList body = new ElementList(24, "body");
        ElementList manualEnd = new ElementList(25, "manualEnd");
        ElementList generatedEnd = new ElementList(26, "generatedEnd");
        Repeat manualCode = new Repeat(27, "manualCode");
        ElementList classStatement = new ElementList(28, "classStatement");
        ElementList state = new ElementList(29, "state");

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

        // packagename = name ["." name|"*"]+
        packagename.add(111, name);
        Optional packagename_1 = new Optional(112, "packagename_1");
        Repeat packagename_1_1 = new Repeat(113, "packagename_1_1");
        packagename_1_1.add(115, new Str(114, "."));
        OrList packagename_1_1_1 = new OrList(116, "packagename_1_1_1");
        packagename_1_1_1.add(117, name);
        packagename_1_1_1.add(119, new Str(118, "*"));
        packagename_1_1.add(120, packagename_1_1_1);
        packagename_1.add(121, packagename_1_1);
        packagename.add(122, packagename_1);

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

        // annotations = [("@" name s):annotation]+
        Repeat annotations_1 = new Repeat(140, "annotations_1");
        annotations_1.add(142, new Str(141, "@"));
        annotations_1.add(143, name);
        annotations_1.add(144, s);
        annotations.add(145, annotations_1);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(146, "keywords_1");
        OrList keywords_1_1 = new OrList(147, "keywords_1_1");
        keywords_1_1.add(149, new Str(148, "public "));
        keywords_1_1.add(151, new Str(150, "private "));
        keywords_1_1.add(153, new Str(152, "final "));
        keywords_1.add(154, keywords_1_1);
        keywords_1.add(155, s);
        keywords.add(156, keywords_1);

        // collectionType = s "<" s type s ">"
        collectionType.add(157, s);
        collectionType.add(159, new Str(158, "<"));
        collectionType.add(160, s);
        collectionType.add(161, type);
        collectionType.add(162, s);
        collectionType.add(164, new Str(163, ">"));

        // mapType = s "<" s type:key s "," s type:entry s ">"
        mapType.add(165, s);
        mapType.add(167, new Str(166, "<"));
        mapType.add(168, s);
        mapType.add(169, type);
        mapType.add(170, s);
        mapType.add(172, new Str(171, ","));
        mapType.add(173, s);
        mapType.add(174, type);
        mapType.add(175, s);
        mapType.add(177, new Str(176, ">"));

        // type = name  [collectionType | mapType]
        type.add(178, name);
        Optional type_1 = new Optional(179, "type_1");
        OrList type_1_1 = new OrList(180, "type_1_1");
        type_1_1.add(181, collectionType);
        type_1_1.add(182, mapType);
        type_1.add(183, type_1_1);
        type.add(184, type_1);

        // attribute = s annotations keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(185, s);
        attribute.add(186, annotations);
        attribute.add(187, keywords);
        attribute.add(188, s);
        attribute.add(189, type);
        attribute.add(190, ws);
        attribute.add(191, name);
        attribute.add(192, s);
        attribute.add(194, new Str(193, ";"));
        Optional attribute_1 = new Optional(195, "attribute_1");
        Repeat attribute_1_1 = new Repeat(196, "attribute_1_1");
        attribute_1_1.add(197, newline, NOT);
        attribute_1.add(198, attribute_1_1);
        attribute.add(199, attribute_1);
        attribute.add(200, newline);

        // uname = "A".."Z" [letter | digit]+
        uname.add(202, new Range(201, "uname", "A", "Z"));
        Optional uname_1 = new Optional(203, "uname_1");
        Repeat uname_1_1 = new Repeat(204, "uname_1_1");
        OrList uname_1_1_1 = new OrList(205, "uname_1_1_1");
        uname_1_1_1.add(206, letter);
        uname_1_1_1.add(207, digit);
        uname_1_1.add(208, uname_1_1_1);
        uname_1.add(209, uname_1_1);
        uname.add(210, uname_1);

        // getter = "get" uname s "(" s ")"
        getter.add(212, new Str(211, "get"));
        getter.add(213, uname);
        getter.add(214, s);
        getter.add(216, new Str(215, "("));
        getter.add(217, s);
        getter.add(219, new Str(218, ")"));

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(221, new Str(220, "{"));
        body.add(222, s);
        Optional body_1 = new Optional(223, "body_1");
        Repeat body_1_1 = new Repeat(224, "body_1_1");
        OrList body_1_1_1 = new OrList(225, "body_1_1_1");
        body_1_1_1.add(226, body);
        body_1_1_1.add(227, str);
        body_1_1_1.add(229, new Str(228, "}", NOT));
        body_1_1.add(230, body_1_1_1);
        body_1.add(231, body_1_1);
        body.add(232, body_1);
        body.add(234, new Str(233, "}"));

        // manualEnd = ("}" s END)
        manualEnd.add(236, new Str(235, "}"));
        manualEnd.add(237, s);
        manualEnd.add(239, new End(238, "manualEnd"));

        // generatedEnd = ("// Generated" *)
        generatedEnd.add(241, new Str(240, "// Generated"));
        generatedEnd.add(243, new Complete(242, "generatedEnd"));

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(244, "manualCode_1");
        manualCode_1.add(245, manualEnd);
        manualCode_1.add(246, generatedEnd);
        manualCode.add(247, manualCode_1, NOT);

        // classStatement =
        //   "@State" ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ manualCode
        //   manualEnd|generatedEnd *
        classStatement.add(249, new Str(248, "@State"));
        classStatement.add(250, ws);
        classStatement.add(251, _public);
        classStatement.add(253, new Str(252, "class"));
        classStatement.add(254, ws);
        classStatement.add(255, name);
        classStatement.add(256, s);
        Optional classStatement_1 = new Optional(257, "classStatement_1");
        classStatement_1.add(259, new Str(258, "extends"));
        classStatement_1.add(260, ws);
        classStatement_1.add(261, name);
        classStatement_1.add(262, s);
        classStatement.add(263, classStatement_1);
        Optional classStatement_2 = new Optional(264, "classStatement_2");
        classStatement_2.add(266, new Str(265, "implements"));
        classStatement_2.add(267, ws);
        classStatement_2.add(268, name);
        Optional classStatement_2_1 = new Optional(269, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(270, "classStatement_2_1_1");
        classStatement_2_1_1.add(271, s);
        classStatement_2_1_1.add(273, new Str(272, ","));
        classStatement_2_1_1.add(274, s);
        classStatement_2_1_1.add(275, name);
        classStatement_2_1.add(276, classStatement_2_1_1);
        classStatement_2.add(277, classStatement_2_1);
        classStatement_2.add(278, s);
        classStatement.add(279, classStatement_2);
        classStatement.add(281, new Str(280, "{"));
        classStatement.add(282, s);
        Optional classStatement_3 = new Optional(283, "classStatement_3");
        Repeat classStatement_3_1 = new Repeat(284, "classStatement_3_1");
        classStatement_3_1.add(285, attribute);
        classStatement_3.add(286, classStatement_3_1);
        classStatement.add(287, classStatement_3);
        classStatement.add(288, manualCode);
        OrList classStatement_4 = new OrList(289, "classStatement_4");
        classStatement_4.add(290, manualEnd);
        classStatement_4.add(291, generatedEnd);
        classStatement.add(292, classStatement_4);
        classStatement.add(294, new Complete(293, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(295, s);
        state.add(296, packagestatement);
        state.add(297, s);
        state.add(298, imports);
        state.add(299, s);
        state.add(300, classStatement);
        state.add(301, s);

        return new TopElement(data1, state);
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
            data.pushState();
            boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
            data.popState();
            return match;
        }
    }

    // *** IStateFactoryFactory
    public interface IStateFactoryFactory {
        public IStateFactory getFactory(int phase);
    }

    // *** IStateFactory ***
    public interface IStateFactory {
        StateParser.IImportstatement createImportstatement();
        StateParser.IImports createImports();
        StateParser.ICollectionType createCollectionType();
        StateParser.IMapType createMapType();
        StateParser.IType createType();
        StateParser.IAttribute createAttribute();
        StateParser.IClassStatement createClassStatement();
        StateParser.IState createState();
    }

    // *** Interfaces ***
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

    // CollectionType
    public interface ICollectionType {
        public void setType(IType itype);
    }

    // MapType
    public interface IMapType {
        public void setKey(IType ikey);
        public void setEntry(IType ientry);
    }

    // Type
    public interface IType {
        public void setName(String name);
        public void setCollectionType(ICollectionType icollectionType);
        public void setMapType(IMapType imapType);
    }

    // Attribute
    public interface IAttribute {
        public void setAnnotations(String annotations);
        public void addAnnotation(String annotation);
        public void setType(IType itype);
        public void setVariable(String variable);
        public void setTypeContent(String type);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void addAttribute(IAttribute iattribute);
        public void setManualCode(String manualCode);
        public void setGeneratedEnd();
    }

    // State
    public interface IState {
        public void setPackagename(String packagename);
        public void setImports(IImports iimports);
        public void setClassStatement(IClassStatement iclassStatement);
    }

    // *** Data ***
    public static final class Data {
        private StateParser.IStateFactory factory;
        private Stack<IImportstatement> importstatementStack = new Stack<IImportstatement>();
        private Stack<IImports> importsStack = new Stack<IImports>();
        private Stack<ICollectionType> collectionTypeStack = new Stack<ICollectionType>();
        private Stack<IMapType> mapTypeStack = new Stack<IMapType>();
        private Stack<IType> typeStack = new Stack<IType>();
        private Stack<IAttribute> attributeStack = new Stack<IAttribute>();
        private Stack<IClassStatement> classStatementStack = new Stack<IClassStatement>();
        private Stack<IState> stateStack = new Stack<IState>();

        public Data(StateParser.IStateFactory factory) {
            this.factory = factory;
        }

        // Importstatement
        public void pushImportstatement() { importstatementStack.push(factory.createImportstatement()); }
        public StateParser.IImportstatement popImportstatement() { return (StateParser.IImportstatement)importstatementStack.pop(); }
        public StateParser.IImportstatement peekImportstatement() {
            if (importstatementStack.empty()) { return null; }
            return importstatementStack.peek();
        }

        // Imports
        public void pushImports() { importsStack.push(factory.createImports()); }
        public StateParser.IImports popImports() { return (StateParser.IImports)importsStack.pop(); }
        public StateParser.IImports peekImports() {
            if (importsStack.empty()) { return null; }
            return importsStack.peek();
        }

        // CollectionType
        public void pushCollectionType() { collectionTypeStack.push(factory.createCollectionType()); }
        public StateParser.ICollectionType popCollectionType() { return (StateParser.ICollectionType)collectionTypeStack.pop(); }
        public StateParser.ICollectionType peekCollectionType() {
            if (collectionTypeStack.empty()) { return null; }
            return collectionTypeStack.peek();
        }

        // MapType
        public void pushMapType() { mapTypeStack.push(factory.createMapType()); }
        public StateParser.IMapType popMapType() { return (StateParser.IMapType)mapTypeStack.pop(); }
        public StateParser.IMapType peekMapType() {
            if (mapTypeStack.empty()) { return null; }
            return mapTypeStack.peek();
        }

        // Type
        public void pushType() { typeStack.push(factory.createType()); }
        public StateParser.IType popType() { return (StateParser.IType)typeStack.pop(); }
        public StateParser.IType peekType() {
            if (typeStack.empty()) { return null; }
            return typeStack.peek();
        }

        // Attribute
        public void pushAttribute() { attributeStack.push(factory.createAttribute()); }
        public StateParser.IAttribute popAttribute() { return (StateParser.IAttribute)attributeStack.pop(); }
        public StateParser.IAttribute peekAttribute() {
            if (attributeStack.empty()) { return null; }
            return attributeStack.peek();
        }

        // ClassStatement
        public void pushClassStatement() { classStatementStack.push(factory.createClassStatement()); }
        public StateParser.IClassStatement popClassStatement() { return (StateParser.IClassStatement)classStatementStack.pop(); }
        public StateParser.IClassStatement peekClassStatement() {
            if (classStatementStack.empty()) { return null; }
            return classStatementStack.peek();
        }

        // State
        public void pushState() { stateStack.push(factory.createState()); }
        public StateParser.IState popState() { return (StateParser.IState)stateStack.pop(); }
        public StateParser.IState peekState() {
            if (stateStack.empty()) { return null; }
            return stateStack.peek();
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

        // attribute.setTypeContent(String type.*);
        public class AttributeType implements Output {
            private String name;
            public AttributeType(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAttribute().setTypeContent(source.get(bookmark));
            }
        }

        // State state.setPackagename(String packagestatement.packagename);
        public class StatePackagestatementPackagename implements Output {
            private String name;
            public StatePackagestatementPackagename(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekState().setPackagename(source.get(bookmark));
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

        // attribute.addAnnotation(String annotations.annotation);
        public class AttributeAnnotationsAnnotation implements Output {
            private String name;
            public AttributeAnnotationsAnnotation(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAttribute().addAnnotation(source.get(bookmark));
            }
        }

        // CollectionType collectionType.setType(Type type);
        public class CollectionTypeCollectionTypeType implements Output {
            private String name;
            public CollectionTypeCollectionTypeType(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushType(); }
            public void set(Source source, int bookmark) {
                peekCollectionType().setType(popType());
            }
        }

        // MapType mapType.setKey(Type key);
        public class MapTypeMapTypeKey implements Output {
            private String name;
            public MapTypeMapTypeKey(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushType(); }
            public void set(Source source, int bookmark) {
                peekMapType().setKey(popType());
            }
        }

        // mapType.setEntry(Type entry);
        public class MapTypeMapTypeEntry implements Output {
            private String name;
            public MapTypeMapTypeEntry(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushType(); }
            public void set(Source source, int bookmark) {
                peekMapType().setEntry(popType());
            }
        }

        // Type type.setName(String name);
        public class TypeTypeName implements Output {
            private String name;
            public TypeTypeName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekType().setName(source.get(bookmark));
            }
        }

        // type.setCollectionType(CollectionType collectionType);
        public class TypeTypeCollectionType implements Output {
            private String name;
            public TypeTypeCollectionType(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushCollectionType(); }
            public void set(Source source, int bookmark) {
                peekType().setCollectionType(popCollectionType());
            }
        }

        // type.setMapType(MapType mapType);
        public class TypeTypeMapType implements Output {
            private String name;
            public TypeTypeMapType(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushMapType(); }
            public void set(Source source, int bookmark) {
                peekType().setMapType(popMapType());
            }
        }

        // Attribute attribute.setAnnotations(String annotations);
        public class AttributeAttributeAnnotations implements Output {
            private String name;
            public AttributeAttributeAnnotations(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAttribute().setAnnotations(source.get(bookmark));
            }
        }

        // attribute.setType(Type type);
        public class AttributeAttributeType implements Output {
            private String name;
            public AttributeAttributeType(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushType(); }
            public void set(Source source, int bookmark) {
                peekAttribute().setType(popType());
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

        // classStatement.setManualCode(String manualCode);
        public class ClassStatementClassStatementManualCode implements Output {
            private String name;
            public ClassStatementClassStatementManualCode(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassStatement().setManualCode(source.get(bookmark));
            }
        }

        // classStatement.setGeneratedEnd(void generatedEnd);
        public class ClassStatementClassStatementGeneratedEnd implements Output {
            private String name;
            public ClassStatementClassStatementGeneratedEnd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassStatement().setGeneratedEnd();
            }
        }

        // state.setImports(Imports imports);
        public class StateStateImports implements Output {
            private String name;
            public StateStateImports(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushImports(); }
            public void set(Source source, int bookmark) {
                peekState().setImports(popImports());
            }
        }

        // state.setClassStatement(ClassStatement classStatement);
        public class StateStateClassStatement implements Output {
            private String name;
            public StateStateClassStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushClassStatement(); }
            public void set(Source source, int bookmark) {
                peekState().setClassStatement(popClassStatement());
            }
        }
    }
}
