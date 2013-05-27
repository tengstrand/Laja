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
 * Auto generated 2013-05-27 by Laja:
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
        Data.StatePackagestatementPackagename statePackagestatementPackagename = data2.new StatePackagestatementPackagename("statePackagestatementPackagename");
        Data.ImportstatementImportstatementStatic importstatementImportstatementStatic = data2.new ImportstatementImportstatementStatic("importstatementImportstatementStatic");
        Data.ImportstatementImportstatementFullclassname importstatementImportstatementFullclassname = data2.new ImportstatementImportstatementFullclassname("importstatementImportstatementFullclassname");
        Data.ImportsImportsImportstatement importsImportsImportstatement = data2.new ImportsImportsImportstatement("importsImportsImportstatement");
        Data.AnnotationAttributeAnnotationAttributeName annotationAttributeAnnotationAttributeName = data2.new AnnotationAttributeAnnotationAttributeName("annotationAttributeAnnotationAttributeName");
        Data.AnnotationAttributeAnnotationAttributeValue annotationAttributeAnnotationAttributeValue = data2.new AnnotationAttributeAnnotationAttributeValue("annotationAttributeAnnotationAttributeValue");
        Data.AnnotationAnnotationName annotationAnnotationName = data2.new AnnotationAnnotationName("annotationAnnotationName");
        Data.AnnotationAnnotationAnnotationAttribute annotationAnnotationAnnotationAttribute = data2.new AnnotationAnnotationAnnotationAttribute("annotationAnnotationAnnotationAttribute");
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
        Data.ClassStatementClassStatementVersion classStatementClassStatementVersion = data2.new ClassStatementClassStatementVersion("classStatementClassStatementVersion");
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
        ElementList packagename = new ElementList(11, "packagename");
        ElementList packagestatement = new ElementList(12, "packagestatement");
        ElementList fullclassname = new ElementList(13, "fullclassname");
        ElementList importstatement = new ElementList(14, "importstatement", importstatementImportstatement);
        Optional imports = new Optional(15, "imports");
        OrList value = new OrList(16, "value");
        ElementList annotationAttribute = new ElementList(17, "annotationAttribute");
        ElementList annotation = new ElementList(18, "annotation");
        Optional annotations = new Optional(19, "annotations", annotationsAnnotations);
        Optional keywords = new Optional(20, "keywords");
        ElementList collectionType = new ElementList(21, "collectionType");
        ElementList mapType = new ElementList(22, "mapType");
        ElementList type = new ElementList(23, "type");
        ElementList attribute = new ElementList(24, "attribute");
        ElementList manualEnd = new ElementList(25, "manualEnd");
        ElementList generatedEnd = new ElementList(26, "generatedEnd");
        Repeat manualCode = new Repeat(27, "manualCode");
        Repeat version = new Repeat(28, "version");
        ElementList classStatement = new ElementList(29, "classStatement");
        ElementList state = new ElementList(30, "state");

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

        // packagename = name ["." name|"*"]+
        packagename.add(105, name);
        Optional packagename_1 = new Optional(106, "packagename_1");
        Repeat packagename_1_1 = new Repeat(107, "packagename_1_1");
        packagename_1_1.add(109, new Str(108, "."));
        OrList packagename_1_1_1 = new OrList(110, "packagename_1_1_1");
        packagename_1_1_1.add(111, name);
        packagename_1_1_1.add(113, new Str(112, "*"));
        packagename_1_1.add(114, packagename_1_1_1);
        packagename_1.add(115, packagename_1_1);
        packagename.add(116, packagename_1);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(118, new Str(117, "package"));
        packagestatement.add(119, ws);
        packagestatement.add(120, packagename, statePackagestatementPackagename);
        packagestatement.add(121, s);
        packagestatement.add(123, new Str(122, ";"));

        // fullclassname = packagename
        fullclassname.add(124, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(126, new Str(125, "import"));
        importstatement.add(127, ws);
        Optional importstatement_1 = new Optional(128, "importstatement_1");
        importstatement_1.add(130, new Str(129, "static", importstatementImportstatementStatic));
        importstatement_1.add(131, ws);
        importstatement.add(132, importstatement_1);
        importstatement.add(133, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(134, s);
        importstatement.add(136, new Str(135, ";"));
        importstatement.add(137, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(138, "imports_1");
        imports_1.add(139, importstatement, importsImportsImportstatement);
        imports.add(140, imports_1);

        // value = str | (!(ws | ")" | ",")+)
        value.add(141, str);
        Repeat value_1 = new Repeat(142, "value_1");
        OrList value_1_1 = new OrList(143, "value_1_1");
        value_1_1.add(144, ws);
        value_1_1.add(146, new Str(145, ")"));
        value_1_1.add(148, new Str(147, ","));
        value_1.add(149, value_1_1, NOT);
        value.add(150, value_1);

        // annotationAttribute = name s "=" s value
        annotationAttribute.add(151, name, annotationAttributeAnnotationAttributeName);
        annotationAttribute.add(152, s);
        annotationAttribute.add(154, new Str(153, "="));
        annotationAttribute.add(155, s);
        annotationAttribute.add(156, value, annotationAttributeAnnotationAttributeValue);

        // annotation = "@" name s ["(" s annotationAttribute [s "," s annotationAttribute]+ s ")" s]
        annotation.add(158, new Str(157, "@"));
        annotation.add(159, name, annotationAnnotationName);
        annotation.add(160, s);
        Optional annotation_1 = new Optional(161, "annotation_1");
        annotation_1.add(163, new Str(162, "("));
        annotation_1.add(164, s);
        annotation_1.add(165, annotationAttribute, annotationAnnotationAnnotationAttribute);
        Optional annotation_1_1 = new Optional(166, "annotation_1_1");
        Repeat annotation_1_1_1 = new Repeat(167, "annotation_1_1_1");
        annotation_1_1_1.add(168, s);
        annotation_1_1_1.add(170, new Str(169, ","));
        annotation_1_1_1.add(171, s);
        annotation_1_1_1.add(172, annotationAttribute, annotationAnnotationAnnotationAttribute);
        annotation_1_1.add(173, annotation_1_1_1);
        annotation_1.add(174, annotation_1_1);
        annotation_1.add(175, s);
        annotation_1.add(177, new Str(176, ")"));
        annotation_1.add(178, s);
        annotation.add(179, annotation_1);

        // annotations = [annotation]+
        Repeat annotations_1 = new Repeat(180, "annotations_1");
        annotations_1.add(181, annotation, annotationsAnnotationsAnnotation);
        annotations.add(182, annotations_1);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(183, "keywords_1");
        OrList keywords_1_1 = new OrList(184, "keywords_1_1");
        keywords_1_1.add(186, new Str(185, "public "));
        keywords_1_1.add(188, new Str(187, "private "));
        keywords_1_1.add(190, new Str(189, "final "));
        keywords_1.add(191, keywords_1_1);
        keywords_1.add(192, s);
        keywords.add(193, keywords_1);

        // collectionType = s "<" s type s ">"
        collectionType.add(194, s);
        collectionType.add(196, new Str(195, "<"));
        collectionType.add(197, s);
        collectionType.add(198, type, collectionTypeCollectionTypeType);
        collectionType.add(199, s);
        collectionType.add(201, new Str(200, ">"));

        // mapType = s "<" s type:key s "," s type:entry s ">"
        mapType.add(202, s);
        mapType.add(204, new Str(203, "<"));
        mapType.add(205, s);
        mapType.add(206, type, mapTypeMapTypeKey);
        mapType.add(207, s);
        mapType.add(209, new Str(208, ","));
        mapType.add(210, s);
        mapType.add(211, type, mapTypeMapTypeEntry);
        mapType.add(212, s);
        mapType.add(214, new Str(213, ">"));

        // type = name [collectionType | mapType]
        type.add(215, name, typeTypeName);
        Optional type_1 = new Optional(216, "type_1");
        OrList type_1_1 = new OrList(217, "type_1_1");
        type_1_1.add(218, collectionType, typeTypeCollectionType);
        type_1_1.add(219, mapType, typeTypeMapType);
        type_1.add(220, type_1_1);
        type.add(221, type_1);

        // attribute = s annotations s keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(222, s);
        attribute.add(223, annotations, attributeAttributeAnnotations);
        attribute.add(224, s);
        attribute.add(225, keywords);
        attribute.add(226, s);
        attribute.add(227, type, attributeAttributeType);
        attribute.add(228, ws);
        attribute.add(229, name, attributeAttributeVariable);
        attribute.add(230, s);
        attribute.add(232, new Str(231, ";"));
        Optional attribute_1 = new Optional(233, "attribute_1");
        Repeat attribute_1_1 = new Repeat(234, "attribute_1_1");
        attribute_1_1.add(235, newline, NOT);
        attribute_1.add(236, attribute_1_1);
        attribute.add(237, attribute_1);
        attribute.add(238, newline);

        // manualEnd = ("}" s END)
        manualEnd.add(240, new Str(239, "}"));
        manualEnd.add(241, s);
        manualEnd.add(243, new End(242, "manualEnd"));

        // generatedEnd = "//" s  ["*"+ | "-"+ | "="+] s "Generated" [!newline+]
        generatedEnd.add(245, new Str(244, "//"));
        generatedEnd.add(246, s);
        Optional generatedEnd_1 = new Optional(247, "generatedEnd_1");
        OrList generatedEnd_1_1 = new OrList(248, "generatedEnd_1_1");
        Repeat generatedEnd_1_1_1 = new Repeat(249, "generatedEnd_1_1_1");
        generatedEnd_1_1_1.add(251, new Str(250, "*"));
        generatedEnd_1_1.add(252, generatedEnd_1_1_1);
        Repeat generatedEnd_1_1_2 = new Repeat(253, "generatedEnd_1_1_2");
        generatedEnd_1_1_2.add(255, new Str(254, "-"));
        generatedEnd_1_1.add(256, generatedEnd_1_1_2);
        Repeat generatedEnd_1_1_3 = new Repeat(257, "generatedEnd_1_1_3");
        generatedEnd_1_1_3.add(259, new Str(258, "="));
        generatedEnd_1_1.add(260, generatedEnd_1_1_3);
        generatedEnd_1.add(261, generatedEnd_1_1);
        generatedEnd.add(262, generatedEnd_1);
        generatedEnd.add(263, s);
        generatedEnd.add(265, new Str(264, "Generated"));
        Optional generatedEnd_2 = new Optional(266, "generatedEnd_2");
        Repeat generatedEnd_2_1 = new Repeat(267, "generatedEnd_2_1");
        generatedEnd_2_1.add(268, newline, NOT);
        generatedEnd_2.add(269, generatedEnd_2_1);
        generatedEnd.add(270, generatedEnd_2);

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(271, "manualCode_1");
        manualCode_1.add(272, manualEnd);
        manualCode_1.add(273, generatedEnd);
        manualCode.add(274, manualCode_1, NOT);

        // version = digit+
        version.add(275, digit);

        // classStatement =
        //   "@State" [s "(" s "version" s "=" s version s ")"] ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ manualCode
        //   manualEnd|generatedEnd *
        classStatement.add(277, new Str(276, "@State"));
        Optional classStatement_1 = new Optional(278, "classStatement_1");
        classStatement_1.add(279, s);
        classStatement_1.add(281, new Str(280, "("));
        classStatement_1.add(282, s);
        classStatement_1.add(284, new Str(283, "version"));
        classStatement_1.add(285, s);
        classStatement_1.add(287, new Str(286, "="));
        classStatement_1.add(288, s);
        classStatement_1.add(289, version, classStatementClassStatementVersion);
        classStatement_1.add(290, s);
        classStatement_1.add(292, new Str(291, ")"));
        classStatement.add(293, classStatement_1);
        classStatement.add(294, ws);
        classStatement.add(295, _public);
        classStatement.add(297, new Str(296, "class"));
        classStatement.add(298, ws);
        classStatement.add(299, name, classStatementClassStatementClassname);
        classStatement.add(300, s);
        Optional classStatement_2 = new Optional(301, "classStatement_2");
        classStatement_2.add(303, new Str(302, "extends"));
        classStatement_2.add(304, ws);
        classStatement_2.add(305, name);
        classStatement_2.add(306, s);
        classStatement.add(307, classStatement_2);
        Optional classStatement_3 = new Optional(308, "classStatement_3");
        classStatement_3.add(310, new Str(309, "implements"));
        classStatement_3.add(311, ws);
        classStatement_3.add(312, name);
        Optional classStatement_3_1 = new Optional(313, "classStatement_3_1");
        Repeat classStatement_3_1_1 = new Repeat(314, "classStatement_3_1_1");
        classStatement_3_1_1.add(315, s);
        classStatement_3_1_1.add(317, new Str(316, ","));
        classStatement_3_1_1.add(318, s);
        classStatement_3_1_1.add(319, name);
        classStatement_3_1.add(320, classStatement_3_1_1);
        classStatement_3.add(321, classStatement_3_1);
        classStatement_3.add(322, s);
        classStatement.add(323, classStatement_3);
        classStatement.add(325, new Str(324, "{"));
        classStatement.add(326, s);
        Optional classStatement_4 = new Optional(327, "classStatement_4");
        Repeat classStatement_4_1 = new Repeat(328, "classStatement_4_1");
        classStatement_4_1.add(329, attribute, classStatementClassStatementAttribute);
        classStatement_4.add(330, classStatement_4_1);
        classStatement.add(331, classStatement_4);
        classStatement.add(332, manualCode, classStatementClassStatementManualCode);
        OrList classStatement_5 = new OrList(333, "classStatement_5");
        classStatement_5.add(334, manualEnd);
        classStatement_5.add(335, generatedEnd, classStatementClassStatementGeneratedEnd);
        classStatement.add(336, classStatement_5);
        classStatement.add(338, new Complete(337, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(339, s);
        state.add(340, packagestatement);
        state.add(341, s);
        state.add(342, imports, stateStateImports);
        state.add(343, s);
        state.add(344, classStatement, stateStateClassStatement);
        state.add(345, s);

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
        ElementList packagename = new ElementList(11, "packagename");
        ElementList packagestatement = new ElementList(12, "packagestatement");
        ElementList fullclassname = new ElementList(13, "fullclassname");
        ElementList importstatement = new ElementList(14, "importstatement");
        Optional imports = new Optional(15, "imports");
        OrList value = new OrList(16, "value");
        ElementList annotationAttribute = new ElementList(17, "annotationAttribute");
        ElementList annotation = new ElementList(18, "annotation");
        Optional annotations = new Optional(19, "annotations");
        Optional keywords = new Optional(20, "keywords");
        ElementList collectionType = new ElementList(21, "collectionType");
        ElementList mapType = new ElementList(22, "mapType");
        ElementList type = new ElementList(23, "type");
        ElementList attribute = new ElementList(24, "attribute");
        ElementList manualEnd = new ElementList(25, "manualEnd");
        ElementList generatedEnd = new ElementList(26, "generatedEnd");
        Repeat manualCode = new Repeat(27, "manualCode");
        Repeat version = new Repeat(28, "version");
        ElementList classStatement = new ElementList(29, "classStatement");
        ElementList state = new ElementList(30, "state");

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

        // packagename = name ["." name|"*"]+
        packagename.add(105, name);
        Optional packagename_1 = new Optional(106, "packagename_1");
        Repeat packagename_1_1 = new Repeat(107, "packagename_1_1");
        packagename_1_1.add(109, new Str(108, "."));
        OrList packagename_1_1_1 = new OrList(110, "packagename_1_1_1");
        packagename_1_1_1.add(111, name);
        packagename_1_1_1.add(113, new Str(112, "*"));
        packagename_1_1.add(114, packagename_1_1_1);
        packagename_1.add(115, packagename_1_1);
        packagename.add(116, packagename_1);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(118, new Str(117, "package"));
        packagestatement.add(119, ws);
        packagestatement.add(120, packagename);
        packagestatement.add(121, s);
        packagestatement.add(123, new Str(122, ";"));

        // fullclassname = packagename
        fullclassname.add(124, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(126, new Str(125, "import"));
        importstatement.add(127, ws);
        Optional importstatement_1 = new Optional(128, "importstatement_1");
        importstatement_1.add(130, new Str(129, "static"));
        importstatement_1.add(131, ws);
        importstatement.add(132, importstatement_1);
        importstatement.add(133, fullclassname);
        importstatement.add(134, s);
        importstatement.add(136, new Str(135, ";"));
        importstatement.add(137, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(138, "imports_1");
        imports_1.add(139, importstatement);
        imports.add(140, imports_1);

        // value = str | (!(ws | ")" | ",")+)
        value.add(141, str);
        Repeat value_1 = new Repeat(142, "value_1");
        OrList value_1_1 = new OrList(143, "value_1_1");
        value_1_1.add(144, ws);
        value_1_1.add(146, new Str(145, ")"));
        value_1_1.add(148, new Str(147, ","));
        value_1.add(149, value_1_1, NOT);
        value.add(150, value_1);

        // annotationAttribute = name s "=" s value
        annotationAttribute.add(151, name);
        annotationAttribute.add(152, s);
        annotationAttribute.add(154, new Str(153, "="));
        annotationAttribute.add(155, s);
        annotationAttribute.add(156, value);

        // annotation = "@" name s ["(" s annotationAttribute [s "," s annotationAttribute]+ s ")" s]
        annotation.add(158, new Str(157, "@"));
        annotation.add(159, name);
        annotation.add(160, s);
        Optional annotation_1 = new Optional(161, "annotation_1");
        annotation_1.add(163, new Str(162, "("));
        annotation_1.add(164, s);
        annotation_1.add(165, annotationAttribute);
        Optional annotation_1_1 = new Optional(166, "annotation_1_1");
        Repeat annotation_1_1_1 = new Repeat(167, "annotation_1_1_1");
        annotation_1_1_1.add(168, s);
        annotation_1_1_1.add(170, new Str(169, ","));
        annotation_1_1_1.add(171, s);
        annotation_1_1_1.add(172, annotationAttribute);
        annotation_1_1.add(173, annotation_1_1_1);
        annotation_1.add(174, annotation_1_1);
        annotation_1.add(175, s);
        annotation_1.add(177, new Str(176, ")"));
        annotation_1.add(178, s);
        annotation.add(179, annotation_1);

        // annotations = [annotation]+
        Repeat annotations_1 = new Repeat(180, "annotations_1");
        annotations_1.add(181, annotation);
        annotations.add(182, annotations_1);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(183, "keywords_1");
        OrList keywords_1_1 = new OrList(184, "keywords_1_1");
        keywords_1_1.add(186, new Str(185, "public "));
        keywords_1_1.add(188, new Str(187, "private "));
        keywords_1_1.add(190, new Str(189, "final "));
        keywords_1.add(191, keywords_1_1);
        keywords_1.add(192, s);
        keywords.add(193, keywords_1);

        // collectionType = s "<" s type s ">"
        collectionType.add(194, s);
        collectionType.add(196, new Str(195, "<"));
        collectionType.add(197, s);
        collectionType.add(198, type);
        collectionType.add(199, s);
        collectionType.add(201, new Str(200, ">"));

        // mapType = s "<" s type:key s "," s type:entry s ">"
        mapType.add(202, s);
        mapType.add(204, new Str(203, "<"));
        mapType.add(205, s);
        mapType.add(206, type);
        mapType.add(207, s);
        mapType.add(209, new Str(208, ","));
        mapType.add(210, s);
        mapType.add(211, type);
        mapType.add(212, s);
        mapType.add(214, new Str(213, ">"));

        // type = name [collectionType | mapType]
        type.add(215, name);
        Optional type_1 = new Optional(216, "type_1");
        OrList type_1_1 = new OrList(217, "type_1_1");
        type_1_1.add(218, collectionType);
        type_1_1.add(219, mapType);
        type_1.add(220, type_1_1);
        type.add(221, type_1);

        // attribute = s annotations s keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(222, s);
        attribute.add(223, annotations);
        attribute.add(224, s);
        attribute.add(225, keywords);
        attribute.add(226, s);
        attribute.add(227, type);
        attribute.add(228, ws);
        attribute.add(229, name);
        attribute.add(230, s);
        attribute.add(232, new Str(231, ";"));
        Optional attribute_1 = new Optional(233, "attribute_1");
        Repeat attribute_1_1 = new Repeat(234, "attribute_1_1");
        attribute_1_1.add(235, newline, NOT);
        attribute_1.add(236, attribute_1_1);
        attribute.add(237, attribute_1);
        attribute.add(238, newline);

        // manualEnd = ("}" s END)
        manualEnd.add(240, new Str(239, "}"));
        manualEnd.add(241, s);
        manualEnd.add(243, new End(242, "manualEnd"));

        // generatedEnd = "//" s  ["*"+ | "-"+ | "="+] s "Generated" [!newline+]
        generatedEnd.add(245, new Str(244, "//"));
        generatedEnd.add(246, s);
        Optional generatedEnd_1 = new Optional(247, "generatedEnd_1");
        OrList generatedEnd_1_1 = new OrList(248, "generatedEnd_1_1");
        Repeat generatedEnd_1_1_1 = new Repeat(249, "generatedEnd_1_1_1");
        generatedEnd_1_1_1.add(251, new Str(250, "*"));
        generatedEnd_1_1.add(252, generatedEnd_1_1_1);
        Repeat generatedEnd_1_1_2 = new Repeat(253, "generatedEnd_1_1_2");
        generatedEnd_1_1_2.add(255, new Str(254, "-"));
        generatedEnd_1_1.add(256, generatedEnd_1_1_2);
        Repeat generatedEnd_1_1_3 = new Repeat(257, "generatedEnd_1_1_3");
        generatedEnd_1_1_3.add(259, new Str(258, "="));
        generatedEnd_1_1.add(260, generatedEnd_1_1_3);
        generatedEnd_1.add(261, generatedEnd_1_1);
        generatedEnd.add(262, generatedEnd_1);
        generatedEnd.add(263, s);
        generatedEnd.add(265, new Str(264, "Generated"));
        Optional generatedEnd_2 = new Optional(266, "generatedEnd_2");
        Repeat generatedEnd_2_1 = new Repeat(267, "generatedEnd_2_1");
        generatedEnd_2_1.add(268, newline, NOT);
        generatedEnd_2.add(269, generatedEnd_2_1);
        generatedEnd.add(270, generatedEnd_2);

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(271, "manualCode_1");
        manualCode_1.add(272, manualEnd);
        manualCode_1.add(273, generatedEnd);
        manualCode.add(274, manualCode_1, NOT);

        // version = digit+
        version.add(275, digit);

        // classStatement =
        //   "@State" [s "(" s "version" s "=" s version s ")"] ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ manualCode
        //   manualEnd|generatedEnd *
        classStatement.add(277, new Str(276, "@State"));
        Optional classStatement_1 = new Optional(278, "classStatement_1");
        classStatement_1.add(279, s);
        classStatement_1.add(281, new Str(280, "("));
        classStatement_1.add(282, s);
        classStatement_1.add(284, new Str(283, "version"));
        classStatement_1.add(285, s);
        classStatement_1.add(287, new Str(286, "="));
        classStatement_1.add(288, s);
        classStatement_1.add(289, version);
        classStatement_1.add(290, s);
        classStatement_1.add(292, new Str(291, ")"));
        classStatement.add(293, classStatement_1);
        classStatement.add(294, ws);
        classStatement.add(295, _public);
        classStatement.add(297, new Str(296, "class"));
        classStatement.add(298, ws);
        classStatement.add(299, name);
        classStatement.add(300, s);
        Optional classStatement_2 = new Optional(301, "classStatement_2");
        classStatement_2.add(303, new Str(302, "extends"));
        classStatement_2.add(304, ws);
        classStatement_2.add(305, name);
        classStatement_2.add(306, s);
        classStatement.add(307, classStatement_2);
        Optional classStatement_3 = new Optional(308, "classStatement_3");
        classStatement_3.add(310, new Str(309, "implements"));
        classStatement_3.add(311, ws);
        classStatement_3.add(312, name);
        Optional classStatement_3_1 = new Optional(313, "classStatement_3_1");
        Repeat classStatement_3_1_1 = new Repeat(314, "classStatement_3_1_1");
        classStatement_3_1_1.add(315, s);
        classStatement_3_1_1.add(317, new Str(316, ","));
        classStatement_3_1_1.add(318, s);
        classStatement_3_1_1.add(319, name);
        classStatement_3_1.add(320, classStatement_3_1_1);
        classStatement_3.add(321, classStatement_3_1);
        classStatement_3.add(322, s);
        classStatement.add(323, classStatement_3);
        classStatement.add(325, new Str(324, "{"));
        classStatement.add(326, s);
        Optional classStatement_4 = new Optional(327, "classStatement_4");
        Repeat classStatement_4_1 = new Repeat(328, "classStatement_4_1");
        classStatement_4_1.add(329, attribute);
        classStatement_4.add(330, classStatement_4_1);
        classStatement.add(331, classStatement_4);
        classStatement.add(332, manualCode);
        OrList classStatement_5 = new OrList(333, "classStatement_5");
        classStatement_5.add(334, manualEnd);
        classStatement_5.add(335, generatedEnd);
        classStatement.add(336, classStatement_5);
        classStatement.add(338, new Complete(337, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(339, s);
        state.add(340, packagestatement);
        state.add(341, s);
        state.add(342, imports);
        state.add(343, s);
        state.add(344, classStatement);
        state.add(345, s);

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
        StateParser.IAnnotationAttribute createAnnotationAttribute();
        StateParser.IAnnotation createAnnotation();
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

    // AnnotationAttribute
    public interface IAnnotationAttribute {
        public void setName(String name);
        public void setValue(String value);
    }

    // Annotation
    public interface IAnnotation {
        public void setName(String name);
        public void addAnnotationAttribute(IAnnotationAttribute iannotationAttribute);
    }

    // Annotations
    public interface IAnnotations {
        public void addAnnotation(IAnnotation iannotation);
        public void setContent(String annotations);
    }

    // Attribute
    public interface IAttribute {
        public void setAnnotations(IAnnotations iannotations);
        public void setType(IType itype);
        public void setVariable(String variable);
    }

    // ClassStatement
    public interface IClassStatement {
        public void setVersion(String version);
        public void setClassname(String classname);
        public void addAttribute(IAttribute iattribute);
        public void setManualCode(String manualCode);
        public void setGeneratedEnd(String generatedEnd);
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
        private Stack<IAnnotationAttribute> annotationAttributeStack = new Stack<IAnnotationAttribute>();
        private Stack<IAnnotation> annotationStack = new Stack<IAnnotation>();
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

        // AnnotationAttribute
        public void pushAnnotationAttribute() { annotationAttributeStack.push(factory.createAnnotationAttribute()); }
        public StateParser.IAnnotationAttribute popAnnotationAttribute() { return (StateParser.IAnnotationAttribute)annotationAttributeStack.pop(); }
        public StateParser.IAnnotationAttribute peekAnnotationAttribute() {
            if (annotationAttributeStack.empty()) { return null; }
            return annotationAttributeStack.peek();
        }

        // Annotation
        public void pushAnnotation() { annotationStack.push(factory.createAnnotation()); }
        public StateParser.IAnnotation popAnnotation() { return (StateParser.IAnnotation)annotationStack.pop(); }
        public StateParser.IAnnotation peekAnnotation() {
            if (annotationStack.empty()) { return null; }
            return annotationStack.peek();
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

        // AnnotationAttribute annotationAttribute.setName(String name);
        public class AnnotationAttributeAnnotationAttributeName implements Output {
            private String name;
            public AnnotationAttributeAnnotationAttributeName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAnnotationAttribute().setName(source.get(bookmark));
            }
        }

        // annotationAttribute.setValue(String value);
        public class AnnotationAttributeAnnotationAttributeValue implements Output {
            private String name;
            public AnnotationAttributeAnnotationAttributeValue(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAnnotationAttribute().setValue(source.get(bookmark));
            }
        }

        // Annotation annotation.setName(String name);
        public class AnnotationAnnotationName implements Output {
            private String name;
            public AnnotationAnnotationName(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekAnnotation().setName(source.get(bookmark));
            }
        }

        // annotation.addAnnotationAttribute(AnnotationAttribute annotationAttribute);
        public class AnnotationAnnotationAnnotationAttribute implements Output {
            private String name;
            public AnnotationAnnotationAnnotationAttribute(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAnnotationAttribute(); }
            public void set(Source source, int bookmark) {
                peekAnnotation().addAnnotationAttribute(popAnnotationAttribute());
            }
        }

        // Annotations annotations.addAnnotation(Annotation annotation);
        public class AnnotationsAnnotationsAnnotation implements Output {
            private String name;
            public AnnotationsAnnotationsAnnotation(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushAnnotation(); }
            public void set(Source source, int bookmark) {
                peekAnnotations().addAnnotation(popAnnotation());
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

        // ClassStatement classStatement.setVersion(String version);
        public class ClassStatementClassStatementVersion implements Output {
            private String name;
            public ClassStatementClassStatementVersion(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassStatement().setVersion(source.get(bookmark));
            }
        }

        // classStatement.setClassname(String classname);
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

        // classStatement.setGeneratedEnd(String generatedEnd);
        public class ClassStatementClassStatementGeneratedEnd implements Output {
            private String name;
            public ClassStatementClassStatementGeneratedEnd(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekClassStatement().setGeneratedEnd(source.get(bookmark));
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
