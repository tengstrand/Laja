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
 * Auto generated 2013-05-14 by Laja:
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
        Data.AnnotationsAnnotations annotationsAnnotations = data2.new AnnotationsAnnotations("annotationsAnnotations");
        Data.AttributeType attributeType = data2.new AttributeType("attributeType");
        Data.StatePackagestatementPackagename statePackagestatementPackagename = data2.new StatePackagestatementPackagename("statePackagestatementPackagename");
        Data.ImportstatementImportstatementStatic importstatementImportstatementStatic = data2.new ImportstatementImportstatementStatic("importstatementImportstatementStatic");
        Data.ImportstatementImportstatementFullclassname importstatementImportstatementFullclassname = data2.new ImportstatementImportstatementFullclassname("importstatementImportstatementFullclassname");
        Data.ImportsImportsImportstatement importsImportsImportstatement = data2.new ImportsImportsImportstatement("importsImportsImportstatement");
        Data.AnnotationsAnnotationsAnnotation annotationsAnnotationsAnnotation = data2.new AnnotationsAnnotationsAnnotation("annotationsAnnotationsAnnotation");
        Data.CollectionTypeCollectionTypeType collectionTypeCollectionTypeType = data2.new CollectionTypeCollectionTypeType("collectionTypeCollectionTypeType");
        Data.MapTypeMapTypeKey mapTypeMapTypeKey = data2.new MapTypeMapTypeKey("mapTypeMapTypeKey");
        Data.MapTypeMapTypeEntry mapTypeMapTypeEntry = data2.new MapTypeMapTypeEntry("mapTypeMapTypeEntry");
        Data.TypeTypeName typeTypeName = data2.new TypeTypeName("typeTypeName");
        Data.TypeTypeCollectionType typeTypeCollectionType = data2.new TypeTypeCollectionType("typeTypeCollectionType");
        Data.TypeTypeMapType typeTypeMapType = data2.new TypeTypeMapType("typeTypeMapType");
        Data.AttributeAttributeAnnotations attributeAttributeAnnotations = data2.new AttributeAttributeAnnotations("attributeAttributeAnnotations");
        Data.AttributeAttributeType attributeAttributeType = data2.new AttributeAttributeType("attributeAttributeType");
        Data.AttributeAttributeVariable attributeAttributeVariable = data2.new AttributeAttributeVariable("attributeAttributeVariable");
        Data.ClassStatementGeneratedEndGeneratedText classStatementGeneratedEndGeneratedText = data2.new ClassStatementGeneratedEndGeneratedText("classStatementGeneratedEndGeneratedText");
        Data.ClassStatementClassStatementClassname classStatementClassStatementClassname = data2.new ClassStatementClassStatementClassname("classStatementClassStatementClassname");
        Data.ClassStatementClassStatementAttribute classStatementClassStatementAttribute = data2.new ClassStatementClassStatementAttribute("classStatementClassStatementAttribute");
        Data.ClassStatementClassStatementManualCode classStatementClassStatementManualCode = data2.new ClassStatementClassStatementManualCode("classStatementClassStatementManualCode");
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
        Optional annotations = new Optional(16, "annotations", annotationsAnnotations);
        Optional keywords = new Optional(17, "keywords");
        ElementList collectionType = new ElementList(18, "collectionType");
        ElementList mapType = new ElementList(19, "mapType");
        ElementList type = new ElementList(20, "type", attributeType);
        ElementList attribute = new ElementList(21, "attribute");
        ElementList uname = new ElementList(22, "uname");
        ElementList body = new ElementList(23, "body");
        ElementList manualEnd = new ElementList(24, "manualEnd");
        ElementList generatedEnd = new ElementList(25, "generatedEnd");
        Repeat manualCode = new Repeat(26, "manualCode");
        ElementList classStatement = new ElementList(27, "classStatement");
        ElementList state = new ElementList(28, "state");

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

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(104, new Str(103, "package"));
        packagestatement.add(105, ws);
        packagestatement.add(106, packagename, statePackagestatementPackagename);
        packagestatement.add(107, s);
        packagestatement.add(109, new Str(108, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(110, name);
        Optional packagename_1 = new Optional(111, "packagename_1");
        Repeat packagename_1_1 = new Repeat(112, "packagename_1_1");
        packagename_1_1.add(114, new Str(113, "."));
        OrList packagename_1_1_1 = new OrList(115, "packagename_1_1_1");
        packagename_1_1_1.add(116, name);
        packagename_1_1_1.add(118, new Str(117, "*"));
        packagename_1_1.add(119, packagename_1_1_1);
        packagename_1.add(120, packagename_1_1);
        packagename.add(121, packagename_1);

        // fullclassname = packagename
        fullclassname.add(122, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(124, new Str(123, "import"));
        importstatement.add(125, ws);
        Optional importstatement_1 = new Optional(126, "importstatement_1");
        importstatement_1.add(128, new Str(127, "static", importstatementImportstatementStatic));
        importstatement_1.add(129, ws);
        importstatement.add(130, importstatement_1);
        importstatement.add(131, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(132, s);
        importstatement.add(134, new Str(133, ";"));
        importstatement.add(135, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(136, "imports_1");
        imports_1.add(137, importstatement, importsImportsImportstatement);
        imports.add(138, imports_1);

        // annotations = [("@" name s):annotation+]
        Repeat annotations_1 = new Repeat(139, "annotations_1");
        annotations_1.add(141, new Str(140, "@"));
        annotations_1.add(142, name);
        annotations_1.add(143, s);
        annotations.add(144, annotations_1, annotationsAnnotationsAnnotation);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(145, "keywords_1");
        OrList keywords_1_1 = new OrList(146, "keywords_1_1");
        keywords_1_1.add(148, new Str(147, "public "));
        keywords_1_1.add(150, new Str(149, "private "));
        keywords_1_1.add(152, new Str(151, "final "));
        keywords_1.add(153, keywords_1_1);
        keywords_1.add(154, s);
        keywords.add(155, keywords_1);

        // collectionType = s "<" s type s ">"
        collectionType.add(156, s);
        collectionType.add(158, new Str(157, "<"));
        collectionType.add(159, s);
        collectionType.add(160, type, collectionTypeCollectionTypeType);
        collectionType.add(161, s);
        collectionType.add(163, new Str(162, ">"));

        // mapType = s "<" s type:key s "," s type:entry s ">"
        mapType.add(164, s);
        mapType.add(166, new Str(165, "<"));
        mapType.add(167, s);
        mapType.add(168, type, mapTypeMapTypeKey);
        mapType.add(169, s);
        mapType.add(171, new Str(170, ","));
        mapType.add(172, s);
        mapType.add(173, type, mapTypeMapTypeEntry);
        mapType.add(174, s);
        mapType.add(176, new Str(175, ">"));

        // type = name  [collectionType | mapType]
        type.add(177, name, typeTypeName);
        Optional type_1 = new Optional(178, "type_1");
        OrList type_1_1 = new OrList(179, "type_1_1");
        type_1_1.add(180, collectionType, typeTypeCollectionType);
        type_1_1.add(181, mapType, typeTypeMapType);
        type_1.add(182, type_1_1);
        type.add(183, type_1);

        // attribute = s annotations keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(184, s);
        attribute.add(185, annotations, attributeAttributeAnnotations);
        attribute.add(186, keywords);
        attribute.add(187, s);
        attribute.add(188, type, attributeAttributeType);
        attribute.add(189, ws);
        attribute.add(190, name, attributeAttributeVariable);
        attribute.add(191, s);
        attribute.add(193, new Str(192, ";"));
        Optional attribute_1 = new Optional(194, "attribute_1");
        Repeat attribute_1_1 = new Repeat(195, "attribute_1_1");
        attribute_1_1.add(196, newline, NOT);
        attribute_1.add(197, attribute_1_1);
        attribute.add(198, attribute_1);
        attribute.add(199, newline);

        // uname = "A".."Z" [letter | digit]+
        uname.add(201, new Range(200, "uname", "A", "Z"));
        Optional uname_1 = new Optional(202, "uname_1");
        Repeat uname_1_1 = new Repeat(203, "uname_1_1");
        OrList uname_1_1_1 = new OrList(204, "uname_1_1_1");
        uname_1_1_1.add(205, letter);
        uname_1_1_1.add(206, digit);
        uname_1_1.add(207, uname_1_1_1);
        uname_1.add(208, uname_1_1);
        uname.add(209, uname_1);

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(211, new Str(210, "{"));
        body.add(212, s);
        Optional body_1 = new Optional(213, "body_1");
        Repeat body_1_1 = new Repeat(214, "body_1_1");
        OrList body_1_1_1 = new OrList(215, "body_1_1_1");
        body_1_1_1.add(216, body);
        body_1_1_1.add(217, str);
        body_1_1_1.add(219, new Str(218, "}", NOT));
        body_1_1.add(220, body_1_1_1);
        body_1.add(221, body_1_1);
        body.add(222, body_1);
        body.add(224, new Str(223, "}"));

        // manualEnd = ("}" s END)
        manualEnd.add(226, new Str(225, "}"));
        manualEnd.add(227, s);
        manualEnd.add(229, new End(228, "manualEnd"));

        // generatedEnd = ("//" s  ["*"+ | "-"+ | "="+] s "Generated" [!newline+]):generatedText *
        ElementList generatedEnd_1 = new ElementList(230, "generatedEnd_1", classStatementGeneratedEndGeneratedText);
        generatedEnd_1.add(232, new Str(231, "//"));
        generatedEnd_1.add(233, s);
        Optional generatedEnd_1_1 = new Optional(234, "generatedEnd_1_1");
        OrList generatedEnd_1_1_1 = new OrList(235, "generatedEnd_1_1_1");
        Repeat generatedEnd_1_1_1_1 = new Repeat(236, "generatedEnd_1_1_1_1");
        generatedEnd_1_1_1_1.add(238, new Str(237, "*"));
        generatedEnd_1_1_1.add(239, generatedEnd_1_1_1_1);
        Repeat generatedEnd_1_1_1_2 = new Repeat(240, "generatedEnd_1_1_1_2");
        generatedEnd_1_1_1_2.add(242, new Str(241, "-"));
        generatedEnd_1_1_1.add(243, generatedEnd_1_1_1_2);
        Repeat generatedEnd_1_1_1_3 = new Repeat(244, "generatedEnd_1_1_1_3");
        generatedEnd_1_1_1_3.add(246, new Str(245, "="));
        generatedEnd_1_1_1.add(247, generatedEnd_1_1_1_3);
        generatedEnd_1_1.add(248, generatedEnd_1_1_1);
        generatedEnd_1.add(249, generatedEnd_1_1);
        generatedEnd_1.add(250, s);
        generatedEnd_1.add(252, new Str(251, "Generated"));
        Optional generatedEnd_1_2 = new Optional(253, "generatedEnd_1_2");
        Repeat generatedEnd_1_2_1 = new Repeat(254, "generatedEnd_1_2_1");
        generatedEnd_1_2_1.add(255, newline, NOT);
        generatedEnd_1_2.add(256, generatedEnd_1_2_1);
        generatedEnd_1.add(257, generatedEnd_1_2);
        generatedEnd.add(258, generatedEnd_1);
        generatedEnd.add(260, new Complete(259, "generatedEnd"));

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(261, "manualCode_1");
        manualCode_1.add(262, manualEnd);
        manualCode_1.add(263, generatedEnd);
        manualCode.add(264, manualCode_1, NOT);

        // classStatement =
        //   "@State" ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ manualCode
        //   manualEnd|generatedEnd *
        classStatement.add(266, new Str(265, "@State"));
        classStatement.add(267, ws);
        classStatement.add(268, _public);
        classStatement.add(270, new Str(269, "class"));
        classStatement.add(271, ws);
        classStatement.add(272, name, classStatementClassStatementClassname);
        classStatement.add(273, s);
        Optional classStatement_1 = new Optional(274, "classStatement_1");
        classStatement_1.add(276, new Str(275, "extends"));
        classStatement_1.add(277, ws);
        classStatement_1.add(278, name);
        classStatement_1.add(279, s);
        classStatement.add(280, classStatement_1);
        Optional classStatement_2 = new Optional(281, "classStatement_2");
        classStatement_2.add(283, new Str(282, "implements"));
        classStatement_2.add(284, ws);
        classStatement_2.add(285, name);
        Optional classStatement_2_1 = new Optional(286, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(287, "classStatement_2_1_1");
        classStatement_2_1_1.add(288, s);
        classStatement_2_1_1.add(290, new Str(289, ","));
        classStatement_2_1_1.add(291, s);
        classStatement_2_1_1.add(292, name);
        classStatement_2_1.add(293, classStatement_2_1_1);
        classStatement_2.add(294, classStatement_2_1);
        classStatement_2.add(295, s);
        classStatement.add(296, classStatement_2);
        classStatement.add(298, new Str(297, "{"));
        classStatement.add(299, s);
        Optional classStatement_3 = new Optional(300, "classStatement_3");
        Repeat classStatement_3_1 = new Repeat(301, "classStatement_3_1");
        classStatement_3_1.add(302, attribute, classStatementClassStatementAttribute);
        classStatement_3.add(303, classStatement_3_1);
        classStatement.add(304, classStatement_3);
        classStatement.add(305, manualCode, classStatementClassStatementManualCode);
        OrList classStatement_4 = new OrList(306, "classStatement_4");
        classStatement_4.add(307, manualEnd);
        classStatement_4.add(308, generatedEnd);
        classStatement.add(309, classStatement_4);
        classStatement.add(311, new Complete(310, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(312, s);
        state.add(313, packagestatement);
        state.add(314, s);
        state.add(315, imports, stateStateImports);
        state.add(316, s);
        state.add(317, classStatement, stateStateClassStatement);
        state.add(318, s);

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
        ElementList body = new ElementList(23, "body");
        ElementList manualEnd = new ElementList(24, "manualEnd");
        ElementList generatedEnd = new ElementList(25, "generatedEnd");
        Repeat manualCode = new Repeat(26, "manualCode");
        ElementList classStatement = new ElementList(27, "classStatement");
        ElementList state = new ElementList(28, "state");

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

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(104, new Str(103, "package"));
        packagestatement.add(105, ws);
        packagestatement.add(106, packagename);
        packagestatement.add(107, s);
        packagestatement.add(109, new Str(108, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(110, name);
        Optional packagename_1 = new Optional(111, "packagename_1");
        Repeat packagename_1_1 = new Repeat(112, "packagename_1_1");
        packagename_1_1.add(114, new Str(113, "."));
        OrList packagename_1_1_1 = new OrList(115, "packagename_1_1_1");
        packagename_1_1_1.add(116, name);
        packagename_1_1_1.add(118, new Str(117, "*"));
        packagename_1_1.add(119, packagename_1_1_1);
        packagename_1.add(120, packagename_1_1);
        packagename.add(121, packagename_1);

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

        // annotations = [("@" name s):annotation+]
        Repeat annotations_1 = new Repeat(139, "annotations_1");
        annotations_1.add(141, new Str(140, "@"));
        annotations_1.add(142, name);
        annotations_1.add(143, s);
        annotations.add(144, annotations_1);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(145, "keywords_1");
        OrList keywords_1_1 = new OrList(146, "keywords_1_1");
        keywords_1_1.add(148, new Str(147, "public "));
        keywords_1_1.add(150, new Str(149, "private "));
        keywords_1_1.add(152, new Str(151, "final "));
        keywords_1.add(153, keywords_1_1);
        keywords_1.add(154, s);
        keywords.add(155, keywords_1);

        // collectionType = s "<" s type s ">"
        collectionType.add(156, s);
        collectionType.add(158, new Str(157, "<"));
        collectionType.add(159, s);
        collectionType.add(160, type);
        collectionType.add(161, s);
        collectionType.add(163, new Str(162, ">"));

        // mapType = s "<" s type:key s "," s type:entry s ">"
        mapType.add(164, s);
        mapType.add(166, new Str(165, "<"));
        mapType.add(167, s);
        mapType.add(168, type);
        mapType.add(169, s);
        mapType.add(171, new Str(170, ","));
        mapType.add(172, s);
        mapType.add(173, type);
        mapType.add(174, s);
        mapType.add(176, new Str(175, ">"));

        // type = name  [collectionType | mapType]
        type.add(177, name);
        Optional type_1 = new Optional(178, "type_1");
        OrList type_1_1 = new OrList(179, "type_1_1");
        type_1_1.add(180, collectionType);
        type_1_1.add(181, mapType);
        type_1.add(182, type_1_1);
        type.add(183, type_1);

        // attribute = s annotations keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(184, s);
        attribute.add(185, annotations);
        attribute.add(186, keywords);
        attribute.add(187, s);
        attribute.add(188, type);
        attribute.add(189, ws);
        attribute.add(190, name);
        attribute.add(191, s);
        attribute.add(193, new Str(192, ";"));
        Optional attribute_1 = new Optional(194, "attribute_1");
        Repeat attribute_1_1 = new Repeat(195, "attribute_1_1");
        attribute_1_1.add(196, newline, NOT);
        attribute_1.add(197, attribute_1_1);
        attribute.add(198, attribute_1);
        attribute.add(199, newline);

        // uname = "A".."Z" [letter | digit]+
        uname.add(201, new Range(200, "uname", "A", "Z"));
        Optional uname_1 = new Optional(202, "uname_1");
        Repeat uname_1_1 = new Repeat(203, "uname_1_1");
        OrList uname_1_1_1 = new OrList(204, "uname_1_1_1");
        uname_1_1_1.add(205, letter);
        uname_1_1_1.add(206, digit);
        uname_1_1.add(207, uname_1_1_1);
        uname_1.add(208, uname_1_1);
        uname.add(209, uname_1);

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(211, new Str(210, "{"));
        body.add(212, s);
        Optional body_1 = new Optional(213, "body_1");
        Repeat body_1_1 = new Repeat(214, "body_1_1");
        OrList body_1_1_1 = new OrList(215, "body_1_1_1");
        body_1_1_1.add(216, body);
        body_1_1_1.add(217, str);
        body_1_1_1.add(219, new Str(218, "}", NOT));
        body_1_1.add(220, body_1_1_1);
        body_1.add(221, body_1_1);
        body.add(222, body_1);
        body.add(224, new Str(223, "}"));

        // manualEnd = ("}" s END)
        manualEnd.add(226, new Str(225, "}"));
        manualEnd.add(227, s);
        manualEnd.add(229, new End(228, "manualEnd"));

        // generatedEnd = ("//" s  ["*"+ | "-"+ | "="+] s "Generated" [!newline+]):generatedText *
        ElementList generatedEnd_1 = new ElementList(230, "generatedEnd_1");
        generatedEnd_1.add(232, new Str(231, "//"));
        generatedEnd_1.add(233, s);
        Optional generatedEnd_1_1 = new Optional(234, "generatedEnd_1_1");
        OrList generatedEnd_1_1_1 = new OrList(235, "generatedEnd_1_1_1");
        Repeat generatedEnd_1_1_1_1 = new Repeat(236, "generatedEnd_1_1_1_1");
        generatedEnd_1_1_1_1.add(238, new Str(237, "*"));
        generatedEnd_1_1_1.add(239, generatedEnd_1_1_1_1);
        Repeat generatedEnd_1_1_1_2 = new Repeat(240, "generatedEnd_1_1_1_2");
        generatedEnd_1_1_1_2.add(242, new Str(241, "-"));
        generatedEnd_1_1_1.add(243, generatedEnd_1_1_1_2);
        Repeat generatedEnd_1_1_1_3 = new Repeat(244, "generatedEnd_1_1_1_3");
        generatedEnd_1_1_1_3.add(246, new Str(245, "="));
        generatedEnd_1_1_1.add(247, generatedEnd_1_1_1_3);
        generatedEnd_1_1.add(248, generatedEnd_1_1_1);
        generatedEnd_1.add(249, generatedEnd_1_1);
        generatedEnd_1.add(250, s);
        generatedEnd_1.add(252, new Str(251, "Generated"));
        Optional generatedEnd_1_2 = new Optional(253, "generatedEnd_1_2");
        Repeat generatedEnd_1_2_1 = new Repeat(254, "generatedEnd_1_2_1");
        generatedEnd_1_2_1.add(255, newline, NOT);
        generatedEnd_1_2.add(256, generatedEnd_1_2_1);
        generatedEnd_1.add(257, generatedEnd_1_2);
        generatedEnd.add(258, generatedEnd_1);
        generatedEnd.add(260, new Complete(259, "generatedEnd"));

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(261, "manualCode_1");
        manualCode_1.add(262, manualEnd);
        manualCode_1.add(263, generatedEnd);
        manualCode.add(264, manualCode_1, NOT);

        // classStatement =
        //   "@State" ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ manualCode
        //   manualEnd|generatedEnd *
        classStatement.add(266, new Str(265, "@State"));
        classStatement.add(267, ws);
        classStatement.add(268, _public);
        classStatement.add(270, new Str(269, "class"));
        classStatement.add(271, ws);
        classStatement.add(272, name);
        classStatement.add(273, s);
        Optional classStatement_1 = new Optional(274, "classStatement_1");
        classStatement_1.add(276, new Str(275, "extends"));
        classStatement_1.add(277, ws);
        classStatement_1.add(278, name);
        classStatement_1.add(279, s);
        classStatement.add(280, classStatement_1);
        Optional classStatement_2 = new Optional(281, "classStatement_2");
        classStatement_2.add(283, new Str(282, "implements"));
        classStatement_2.add(284, ws);
        classStatement_2.add(285, name);
        Optional classStatement_2_1 = new Optional(286, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(287, "classStatement_2_1_1");
        classStatement_2_1_1.add(288, s);
        classStatement_2_1_1.add(290, new Str(289, ","));
        classStatement_2_1_1.add(291, s);
        classStatement_2_1_1.add(292, name);
        classStatement_2_1.add(293, classStatement_2_1_1);
        classStatement_2.add(294, classStatement_2_1);
        classStatement_2.add(295, s);
        classStatement.add(296, classStatement_2);
        classStatement.add(298, new Str(297, "{"));
        classStatement.add(299, s);
        Optional classStatement_3 = new Optional(300, "classStatement_3");
        Repeat classStatement_3_1 = new Repeat(301, "classStatement_3_1");
        classStatement_3_1.add(302, attribute);
        classStatement_3.add(303, classStatement_3_1);
        classStatement.add(304, classStatement_3);
        classStatement.add(305, manualCode);
        OrList classStatement_4 = new OrList(306, "classStatement_4");
        classStatement_4.add(307, manualEnd);
        classStatement_4.add(308, generatedEnd);
        classStatement.add(309, classStatement_4);
        classStatement.add(311, new Complete(310, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(312, s);
        state.add(313, packagestatement);
        state.add(314, s);
        state.add(315, imports);
        state.add(316, s);
        state.add(317, classStatement);
        state.add(318, s);

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
        StateParser.IAnnotations createAnnotations();
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

    // Annotations
    public interface IAnnotations {
        public void addAnnotation(String annotation);
        public void setContent(String annotations);
    }

    // Attribute
    public interface IAttribute {
        public void setAnnotations(IAnnotations iannotations);
        public void setType(IType itype);
        public void setVariable(String variable);
        public void setTypeContent(String type);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setClassname(String classname);
        public void addAttribute(IAttribute iattribute);
        public void setManualCode(String manualCode);
        public void setGeneratedText(String generatedText);
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
        private Stack<IAnnotations> annotationsStack = new Stack<IAnnotations>();
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

        // Annotations
        public void pushAnnotations() { annotationsStack.push(factory.createAnnotations()); }
        public StateParser.IAnnotations popAnnotations() { return (StateParser.IAnnotations)annotationsStack.pop(); }
        public StateParser.IAnnotations peekAnnotations() {
            if (annotationsStack.empty()) { return null; }
            return annotationsStack.peek();
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

        // annotations.setContent(String *);
        public class AnnotationsAnnotations implements Output {
            private String name;
            public AnnotationsAnnotations(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAnnotations().setContent(source.get(bookmark));
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

        // Annotations annotations.addAnnotation(String annotation);
        public class AnnotationsAnnotationsAnnotation implements Output {
            private String name;
            public AnnotationsAnnotationsAnnotation(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAnnotations().addAnnotation(source.get(bookmark));
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

        // Attribute attribute.setAnnotations(Annotations annotations);
        public class AttributeAttributeAnnotations implements Output {
            private String name;
            public AttributeAttributeAnnotations(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAnnotations(); }
            public void set(Source source, int bookmark) {
                peekAttribute().setAnnotations(popAnnotations());
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

        // classStatement.setGeneratedText(String generatedEnd.generatedText);
        public class ClassStatementGeneratedEndGeneratedText implements Output {
            private String name;
            public ClassStatementGeneratedEndGeneratedText(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassStatement().setGeneratedText(source.get(bookmark));
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
