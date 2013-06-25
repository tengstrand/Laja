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
 * Auto generated 2013-06-25 by Laja:
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
        Data.PackageStatementPackageStatement packageStatementPackageStatement = data2.new PackageStatementPackageStatement("packageStatementPackageStatement");
        Data.ImportstatementImportstatement importstatementImportstatement = data2.new ImportstatementImportstatement("importstatementImportstatement");
        Data.AnnotationsAnnotations annotationsAnnotations = data2.new AnnotationsAnnotations("annotationsAnnotations");
        Data.PackageStatementPackageStatementPackagename packageStatementPackageStatementPackagename = data2.new PackageStatementPackageStatementPackagename("packageStatementPackageStatementPackagename");
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
        Data.StateClassStatementValidateMethod stateClassStatementValidateMethod = data2.new StateClassStatementValidateMethod("stateClassStatementValidateMethod");
        Data.StateStatePackageStatement stateStatePackageStatement = data2.new StateStatePackageStatement("stateStatePackageStatement");
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
        ElementList packageStatement = new ElementList(12, "packageStatement", packageStatementPackageStatement);
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
        ElementList body = new ElementList(28, "body");
        ElementList validateMethod = new ElementList(29, "validateMethod");
        Repeat version = new Repeat(30, "version");
        ElementList classStatement = new ElementList(31, "classStatement");
        ElementList state = new ElementList(32, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(34, new Str(33, "\r\n"));
        newline.add(36, new Str(35, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(37, "comment_1");
        comment_1.add(39, new Str(38, "/*"));
        Optional comment_1_1 = new Optional(40, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(41, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(42, "comment_1_1_1_1");
        comment_1_1_1_1.add(43, comment);
        comment_1_1_1_1.add(45, new Str(44, "*/", NOT));
        comment_1_1_1.add(46, comment_1_1_1_1);
        comment_1_1.add(47, comment_1_1_1);
        comment_1.add(48, comment_1_1);
        comment_1.add(50, new Str(49, "*/"));
        comment.add(51, comment_1);
        ElementList comment_2 = new ElementList(52, "comment_2");
        comment_2.add(54, new Str(53, "//"));
        Optional comment_2_1 = new Optional(55, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(56, "comment_2_1_1");
        comment_2_1_1.add(57, newline, NOT);
        comment_2_1.add(58, comment_2_1_1);
        comment_2.add(59, comment_2_1);
        OrList comment_2_2 = new OrList(60, "comment_2_2");
        comment_2_2.add(61, newline);
        comment_2_2.add(63, new End(62, "comment_2_2"));
        comment_2.add(64, comment_2_2);
        comment.add(65, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(66, "ws_1");
        ws_1.add(67, newline);
        ws_1.add(69, new Str(68, " "));
        ws_1.add(71, new Str(70, "\t"));
        ws_1.add(72, comment);
        ws.add(73, ws_1);

        // s = [ws]
        s.add(74, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(75, ff);
        Repeat str_1 = new Repeat(76, "str_1");
        OrList str_1_1 = new OrList(77, "str_1_1");
        str_1_1.add(79, new Str(78, "\\\""));
        OrList str_1_1_1 = new OrList(80, "str_1_1_1", NOT);
        str_1_1_1.add(81, ff);
        str_1_1_1.add(82, newline);
        str_1_1.add(83, str_1_1_1);
        str_1.add(84, str_1_1);
        str.add(85, str_1);
        str.add(86, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(88, new Range(87, "letter", "a", "z"));
        letter.add(90, new Range(89, "letter", "A", "Z"));
        letter.add(92, new Str(91, "_"));
        letter.add(94, new Str(93, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(95, letter);
        Optional name_1 = new Optional(96, "name_1");
        Repeat name_1_1 = new Repeat(97, "name_1_1");
        OrList name_1_1_1 = new OrList(98, "name_1_1_1");
        name_1_1_1.add(99, letter);
        name_1_1_1.add(100, digit);
        name_1_1.add(101, name_1_1_1);
        name_1.add(102, name_1_1);
        name.add(103, name_1);

        // public = ["public" ws]
        _public.add(105, new Str(104, "public"));
        _public.add(106, ws);

        // packagename = name ["." name|"*"]+
        packagename.add(107, name);
        Optional packagename_1 = new Optional(108, "packagename_1");
        Repeat packagename_1_1 = new Repeat(109, "packagename_1_1");
        packagename_1_1.add(111, new Str(110, "."));
        OrList packagename_1_1_1 = new OrList(112, "packagename_1_1_1");
        packagename_1_1_1.add(113, name);
        packagename_1_1_1.add(115, new Str(114, "*"));
        packagename_1_1.add(116, packagename_1_1_1);
        packagename_1.add(117, packagename_1_1);
        packagename.add(118, packagename_1);

        // packageStatement = "package" ws packagename s ";"
        packageStatement.add(120, new Str(119, "package"));
        packageStatement.add(121, ws);
        packageStatement.add(122, packagename, packageStatementPackageStatementPackagename);
        packageStatement.add(123, s);
        packageStatement.add(125, new Str(124, ";"));

        // fullclassname = packagename
        fullclassname.add(126, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(128, new Str(127, "import"));
        importstatement.add(129, ws);
        Optional importstatement_1 = new Optional(130, "importstatement_1");
        importstatement_1.add(132, new Str(131, "static", importstatementImportstatementStatic));
        importstatement_1.add(133, ws);
        importstatement.add(134, importstatement_1);
        importstatement.add(135, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(136, s);
        importstatement.add(138, new Str(137, ";"));
        importstatement.add(139, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(140, "imports_1");
        imports_1.add(141, importstatement, importsImportsImportstatement);
        imports.add(142, imports_1);

        // value = str | (!(ws | ")" | ",")+)
        value.add(143, str);
        Repeat value_1 = new Repeat(144, "value_1");
        OrList value_1_1 = new OrList(145, "value_1_1");
        value_1_1.add(146, ws);
        value_1_1.add(148, new Str(147, ")"));
        value_1_1.add(150, new Str(149, ","));
        value_1.add(151, value_1_1, NOT);
        value.add(152, value_1);

        // annotationAttribute = name s "=" s value
        annotationAttribute.add(153, name, annotationAttributeAnnotationAttributeName);
        annotationAttribute.add(154, s);
        annotationAttribute.add(156, new Str(155, "="));
        annotationAttribute.add(157, s);
        annotationAttribute.add(158, value, annotationAttributeAnnotationAttributeValue);

        // annotation = "@" name s ["(" s annotationAttribute [s "," s annotationAttribute]+ s ")" s]
        annotation.add(160, new Str(159, "@"));
        annotation.add(161, name, annotationAnnotationName);
        annotation.add(162, s);
        Optional annotation_1 = new Optional(163, "annotation_1");
        annotation_1.add(165, new Str(164, "("));
        annotation_1.add(166, s);
        annotation_1.add(167, annotationAttribute, annotationAnnotationAnnotationAttribute);
        Optional annotation_1_1 = new Optional(168, "annotation_1_1");
        Repeat annotation_1_1_1 = new Repeat(169, "annotation_1_1_1");
        annotation_1_1_1.add(170, s);
        annotation_1_1_1.add(172, new Str(171, ","));
        annotation_1_1_1.add(173, s);
        annotation_1_1_1.add(174, annotationAttribute, annotationAnnotationAnnotationAttribute);
        annotation_1_1.add(175, annotation_1_1_1);
        annotation_1.add(176, annotation_1_1);
        annotation_1.add(177, s);
        annotation_1.add(179, new Str(178, ")"));
        annotation_1.add(180, s);
        annotation.add(181, annotation_1);

        // annotations = [annotation]+
        Repeat annotations_1 = new Repeat(182, "annotations_1");
        annotations_1.add(183, annotation, annotationsAnnotationsAnnotation);
        annotations.add(184, annotations_1);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(185, "keywords_1");
        OrList keywords_1_1 = new OrList(186, "keywords_1_1");
        keywords_1_1.add(188, new Str(187, "public "));
        keywords_1_1.add(190, new Str(189, "private "));
        keywords_1_1.add(192, new Str(191, "final "));
        keywords_1.add(193, keywords_1_1);
        keywords_1.add(194, s);
        keywords.add(195, keywords_1);

        // collectionType = s "<" s type s ">"
        collectionType.add(196, s);
        collectionType.add(198, new Str(197, "<"));
        collectionType.add(199, s);
        collectionType.add(200, type, collectionTypeCollectionTypeType);
        collectionType.add(201, s);
        collectionType.add(203, new Str(202, ">"));

        // mapType = s "<" s type:key s "," s type:entry s ">"
        mapType.add(204, s);
        mapType.add(206, new Str(205, "<"));
        mapType.add(207, s);
        mapType.add(208, type, mapTypeMapTypeKey);
        mapType.add(209, s);
        mapType.add(211, new Str(210, ","));
        mapType.add(212, s);
        mapType.add(213, type, mapTypeMapTypeEntry);
        mapType.add(214, s);
        mapType.add(216, new Str(215, ">"));

        // type = name [collectionType | mapType]
        type.add(217, name, typeTypeName);
        Optional type_1 = new Optional(218, "type_1");
        OrList type_1_1 = new OrList(219, "type_1_1");
        type_1_1.add(220, collectionType, typeTypeCollectionType);
        type_1_1.add(221, mapType, typeTypeMapType);
        type_1.add(222, type_1_1);
        type.add(223, type_1);

        // attribute = s annotations s keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(224, s);
        attribute.add(225, annotations, attributeAttributeAnnotations);
        attribute.add(226, s);
        attribute.add(227, keywords);
        attribute.add(228, s);
        attribute.add(229, type, attributeAttributeType);
        attribute.add(230, ws);
        attribute.add(231, name, attributeAttributeVariable);
        attribute.add(232, s);
        attribute.add(234, new Str(233, ";"));
        Optional attribute_1 = new Optional(235, "attribute_1");
        Repeat attribute_1_1 = new Repeat(236, "attribute_1_1");
        attribute_1_1.add(237, newline, NOT);
        attribute_1.add(238, attribute_1_1);
        attribute.add(239, attribute_1);
        attribute.add(240, newline);

        // manualEnd = ("}" s END)
        manualEnd.add(242, new Str(241, "}"));
        manualEnd.add(243, s);
        manualEnd.add(245, new End(244, "manualEnd"));

        // generatedEnd = "//" s  ["*"+ | "-"+ | "="+] s "Generated" [!newline+]
        generatedEnd.add(247, new Str(246, "//"));
        generatedEnd.add(248, s);
        Optional generatedEnd_1 = new Optional(249, "generatedEnd_1");
        OrList generatedEnd_1_1 = new OrList(250, "generatedEnd_1_1");
        Repeat generatedEnd_1_1_1 = new Repeat(251, "generatedEnd_1_1_1");
        generatedEnd_1_1_1.add(253, new Str(252, "*"));
        generatedEnd_1_1.add(254, generatedEnd_1_1_1);
        Repeat generatedEnd_1_1_2 = new Repeat(255, "generatedEnd_1_1_2");
        generatedEnd_1_1_2.add(257, new Str(256, "-"));
        generatedEnd_1_1.add(258, generatedEnd_1_1_2);
        Repeat generatedEnd_1_1_3 = new Repeat(259, "generatedEnd_1_1_3");
        generatedEnd_1_1_3.add(261, new Str(260, "="));
        generatedEnd_1_1.add(262, generatedEnd_1_1_3);
        generatedEnd_1.add(263, generatedEnd_1_1);
        generatedEnd.add(264, generatedEnd_1);
        generatedEnd.add(265, s);
        generatedEnd.add(267, new Str(266, "Generated"));
        Optional generatedEnd_2 = new Optional(268, "generatedEnd_2");
        Repeat generatedEnd_2_1 = new Repeat(269, "generatedEnd_2_1");
        generatedEnd_2_1.add(270, newline, NOT);
        generatedEnd_2.add(271, generatedEnd_2_1);
        generatedEnd.add(272, generatedEnd_2);

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(273, "manualCode_1");
        manualCode_1.add(274, manualEnd);
        manualCode_1.add(275, generatedEnd);
        manualCode.add(276, manualCode_1, NOT);

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(278, new Str(277, "{"));
        body.add(279, s);
        Optional body_1 = new Optional(280, "body_1");
        Repeat body_1_1 = new Repeat(281, "body_1_1");
        OrList body_1_1_1 = new OrList(282, "body_1_1_1");
        body_1_1_1.add(283, body);
        body_1_1_1.add(284, str);
        body_1_1_1.add(286, new Str(285, "}", NOT));
        body_1_1.add(287, body_1_1_1);
        body_1.add(288, body_1_1);
        body.add(289, body_1);
        body.add(291, new Str(290, "}"));

        // validateMethod = s "private void validate(Object rootElement, String parent, ValidationErrors.Builder errors)" s body
        validateMethod.add(292, s);
        validateMethod.add(294, new Str(293, "private void validate(Object rootElement, String parent, ValidationErrors.Builder errors)"));
        validateMethod.add(295, s);
        validateMethod.add(296, body);

        // version = digit+
        version.add(297, digit);

        // classStatement =
        //   "@State" [s "(" s "version" s "=" s version s ")"] ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ [manualCode]
        //   manualEnd|generatedEnd [!validateMethod:m+ validateMethod] *
        classStatement.add(299, new Str(298, "@State"));
        Optional classStatement_1 = new Optional(300, "classStatement_1");
        classStatement_1.add(301, s);
        classStatement_1.add(303, new Str(302, "("));
        classStatement_1.add(304, s);
        classStatement_1.add(306, new Str(305, "version"));
        classStatement_1.add(307, s);
        classStatement_1.add(309, new Str(308, "="));
        classStatement_1.add(310, s);
        classStatement_1.add(311, version, classStatementClassStatementVersion);
        classStatement_1.add(312, s);
        classStatement_1.add(314, new Str(313, ")"));
        classStatement.add(315, classStatement_1);
        classStatement.add(316, ws);
        classStatement.add(317, _public);
        classStatement.add(319, new Str(318, "class"));
        classStatement.add(320, ws);
        classStatement.add(321, name, classStatementClassStatementClassname);
        classStatement.add(322, s);
        Optional classStatement_2 = new Optional(323, "classStatement_2");
        classStatement_2.add(325, new Str(324, "extends"));
        classStatement_2.add(326, ws);
        classStatement_2.add(327, name);
        classStatement_2.add(328, s);
        classStatement.add(329, classStatement_2);
        Optional classStatement_3 = new Optional(330, "classStatement_3");
        classStatement_3.add(332, new Str(331, "implements"));
        classStatement_3.add(333, ws);
        classStatement_3.add(334, name);
        Optional classStatement_3_1 = new Optional(335, "classStatement_3_1");
        Repeat classStatement_3_1_1 = new Repeat(336, "classStatement_3_1_1");
        classStatement_3_1_1.add(337, s);
        classStatement_3_1_1.add(339, new Str(338, ","));
        classStatement_3_1_1.add(340, s);
        classStatement_3_1_1.add(341, name);
        classStatement_3_1.add(342, classStatement_3_1_1);
        classStatement_3.add(343, classStatement_3_1);
        classStatement_3.add(344, s);
        classStatement.add(345, classStatement_3);
        classStatement.add(347, new Str(346, "{"));
        classStatement.add(348, s);
        Optional classStatement_4 = new Optional(349, "classStatement_4");
        Repeat classStatement_4_1 = new Repeat(350, "classStatement_4_1");
        classStatement_4_1.add(351, attribute, classStatementClassStatementAttribute);
        classStatement_4.add(352, classStatement_4_1);
        classStatement.add(353, classStatement_4);
        Optional classStatement_5 = new Optional(354, "classStatement_5");
        classStatement_5.add(355, manualCode, classStatementClassStatementManualCode);
        classStatement.add(356, classStatement_5);
        OrList classStatement_6 = new OrList(357, "classStatement_6");
        classStatement_6.add(358, manualEnd);
        classStatement_6.add(359, generatedEnd, classStatementClassStatementGeneratedEnd);
        classStatement.add(360, classStatement_6);
        Optional classStatement_7 = new Optional(361, "classStatement_7");
        Repeat classStatement_7_1 = new Repeat(362, "classStatement_7_1");
        classStatement_7_1.add(363, validateMethod, NOT, stateClassStatementValidateMethod);
        classStatement_7.add(364, classStatement_7_1);
        classStatement_7.add(365, validateMethod, stateClassStatementValidateMethod);
        classStatement.add(366, classStatement_7);
        classStatement.add(368, new Complete(367, "classStatement"));

        // state = [s [packageStatement] s] imports s classStatement s
        Optional state_1 = new Optional(369, "state_1");
        state_1.add(370, s);
        Optional state_1_1 = new Optional(371, "state_1_1");
        state_1_1.add(372, packageStatement, stateStatePackageStatement);
        state_1.add(373, state_1_1);
        state_1.add(374, s);
        state.add(375, state_1);
        state.add(376, imports, stateStateImports);
        state.add(377, s);
        state.add(378, classStatement, stateStateClassStatement);
        state.add(379, s);

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
        ElementList packageStatement = new ElementList(12, "packageStatement");
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
        ElementList body = new ElementList(28, "body");
        ElementList validateMethod = new ElementList(29, "validateMethod");
        Repeat version = new Repeat(30, "version");
        ElementList classStatement = new ElementList(31, "classStatement");
        ElementList state = new ElementList(32, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(34, new Str(33, "\r\n"));
        newline.add(36, new Str(35, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(37, "comment_1");
        comment_1.add(39, new Str(38, "/*"));
        Optional comment_1_1 = new Optional(40, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(41, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(42, "comment_1_1_1_1");
        comment_1_1_1_1.add(43, comment);
        comment_1_1_1_1.add(45, new Str(44, "*/", NOT));
        comment_1_1_1.add(46, comment_1_1_1_1);
        comment_1_1.add(47, comment_1_1_1);
        comment_1.add(48, comment_1_1);
        comment_1.add(50, new Str(49, "*/"));
        comment.add(51, comment_1);
        ElementList comment_2 = new ElementList(52, "comment_2");
        comment_2.add(54, new Str(53, "//"));
        Optional comment_2_1 = new Optional(55, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(56, "comment_2_1_1");
        comment_2_1_1.add(57, newline, NOT);
        comment_2_1.add(58, comment_2_1_1);
        comment_2.add(59, comment_2_1);
        OrList comment_2_2 = new OrList(60, "comment_2_2");
        comment_2_2.add(61, newline);
        comment_2_2.add(63, new End(62, "comment_2_2"));
        comment_2.add(64, comment_2_2);
        comment.add(65, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(66, "ws_1");
        ws_1.add(67, newline);
        ws_1.add(69, new Str(68, " "));
        ws_1.add(71, new Str(70, "\t"));
        ws_1.add(72, comment);
        ws.add(73, ws_1);

        // s = [ws]
        s.add(74, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(75, ff);
        Repeat str_1 = new Repeat(76, "str_1");
        OrList str_1_1 = new OrList(77, "str_1_1");
        str_1_1.add(79, new Str(78, "\\\""));
        OrList str_1_1_1 = new OrList(80, "str_1_1_1", NOT);
        str_1_1_1.add(81, ff);
        str_1_1_1.add(82, newline);
        str_1_1.add(83, str_1_1_1);
        str_1.add(84, str_1_1);
        str.add(85, str_1);
        str.add(86, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(88, new Range(87, "letter", "a", "z"));
        letter.add(90, new Range(89, "letter", "A", "Z"));
        letter.add(92, new Str(91, "_"));
        letter.add(94, new Str(93, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(95, letter);
        Optional name_1 = new Optional(96, "name_1");
        Repeat name_1_1 = new Repeat(97, "name_1_1");
        OrList name_1_1_1 = new OrList(98, "name_1_1_1");
        name_1_1_1.add(99, letter);
        name_1_1_1.add(100, digit);
        name_1_1.add(101, name_1_1_1);
        name_1.add(102, name_1_1);
        name.add(103, name_1);

        // public = ["public" ws]
        _public.add(105, new Str(104, "public"));
        _public.add(106, ws);

        // packagename = name ["." name|"*"]+
        packagename.add(107, name);
        Optional packagename_1 = new Optional(108, "packagename_1");
        Repeat packagename_1_1 = new Repeat(109, "packagename_1_1");
        packagename_1_1.add(111, new Str(110, "."));
        OrList packagename_1_1_1 = new OrList(112, "packagename_1_1_1");
        packagename_1_1_1.add(113, name);
        packagename_1_1_1.add(115, new Str(114, "*"));
        packagename_1_1.add(116, packagename_1_1_1);
        packagename_1.add(117, packagename_1_1);
        packagename.add(118, packagename_1);

        // packageStatement = "package" ws packagename s ";"
        packageStatement.add(120, new Str(119, "package"));
        packageStatement.add(121, ws);
        packageStatement.add(122, packagename);
        packageStatement.add(123, s);
        packageStatement.add(125, new Str(124, ";"));

        // fullclassname = packagename
        fullclassname.add(126, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(128, new Str(127, "import"));
        importstatement.add(129, ws);
        Optional importstatement_1 = new Optional(130, "importstatement_1");
        importstatement_1.add(132, new Str(131, "static"));
        importstatement_1.add(133, ws);
        importstatement.add(134, importstatement_1);
        importstatement.add(135, fullclassname);
        importstatement.add(136, s);
        importstatement.add(138, new Str(137, ";"));
        importstatement.add(139, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(140, "imports_1");
        imports_1.add(141, importstatement);
        imports.add(142, imports_1);

        // value = str | (!(ws | ")" | ",")+)
        value.add(143, str);
        Repeat value_1 = new Repeat(144, "value_1");
        OrList value_1_1 = new OrList(145, "value_1_1");
        value_1_1.add(146, ws);
        value_1_1.add(148, new Str(147, ")"));
        value_1_1.add(150, new Str(149, ","));
        value_1.add(151, value_1_1, NOT);
        value.add(152, value_1);

        // annotationAttribute = name s "=" s value
        annotationAttribute.add(153, name);
        annotationAttribute.add(154, s);
        annotationAttribute.add(156, new Str(155, "="));
        annotationAttribute.add(157, s);
        annotationAttribute.add(158, value);

        // annotation = "@" name s ["(" s annotationAttribute [s "," s annotationAttribute]+ s ")" s]
        annotation.add(160, new Str(159, "@"));
        annotation.add(161, name);
        annotation.add(162, s);
        Optional annotation_1 = new Optional(163, "annotation_1");
        annotation_1.add(165, new Str(164, "("));
        annotation_1.add(166, s);
        annotation_1.add(167, annotationAttribute);
        Optional annotation_1_1 = new Optional(168, "annotation_1_1");
        Repeat annotation_1_1_1 = new Repeat(169, "annotation_1_1_1");
        annotation_1_1_1.add(170, s);
        annotation_1_1_1.add(172, new Str(171, ","));
        annotation_1_1_1.add(173, s);
        annotation_1_1_1.add(174, annotationAttribute);
        annotation_1_1.add(175, annotation_1_1_1);
        annotation_1.add(176, annotation_1_1);
        annotation_1.add(177, s);
        annotation_1.add(179, new Str(178, ")"));
        annotation_1.add(180, s);
        annotation.add(181, annotation_1);

        // annotations = [annotation]+
        Repeat annotations_1 = new Repeat(182, "annotations_1");
        annotations_1.add(183, annotation);
        annotations.add(184, annotations_1);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(185, "keywords_1");
        OrList keywords_1_1 = new OrList(186, "keywords_1_1");
        keywords_1_1.add(188, new Str(187, "public "));
        keywords_1_1.add(190, new Str(189, "private "));
        keywords_1_1.add(192, new Str(191, "final "));
        keywords_1.add(193, keywords_1_1);
        keywords_1.add(194, s);
        keywords.add(195, keywords_1);

        // collectionType = s "<" s type s ">"
        collectionType.add(196, s);
        collectionType.add(198, new Str(197, "<"));
        collectionType.add(199, s);
        collectionType.add(200, type);
        collectionType.add(201, s);
        collectionType.add(203, new Str(202, ">"));

        // mapType = s "<" s type:key s "," s type:entry s ">"
        mapType.add(204, s);
        mapType.add(206, new Str(205, "<"));
        mapType.add(207, s);
        mapType.add(208, type);
        mapType.add(209, s);
        mapType.add(211, new Str(210, ","));
        mapType.add(212, s);
        mapType.add(213, type);
        mapType.add(214, s);
        mapType.add(216, new Str(215, ">"));

        // type = name [collectionType | mapType]
        type.add(217, name);
        Optional type_1 = new Optional(218, "type_1");
        OrList type_1_1 = new OrList(219, "type_1_1");
        type_1_1.add(220, collectionType);
        type_1_1.add(221, mapType);
        type_1.add(222, type_1_1);
        type.add(223, type_1);

        // attribute = s annotations s keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(224, s);
        attribute.add(225, annotations);
        attribute.add(226, s);
        attribute.add(227, keywords);
        attribute.add(228, s);
        attribute.add(229, type);
        attribute.add(230, ws);
        attribute.add(231, name);
        attribute.add(232, s);
        attribute.add(234, new Str(233, ";"));
        Optional attribute_1 = new Optional(235, "attribute_1");
        Repeat attribute_1_1 = new Repeat(236, "attribute_1_1");
        attribute_1_1.add(237, newline, NOT);
        attribute_1.add(238, attribute_1_1);
        attribute.add(239, attribute_1);
        attribute.add(240, newline);

        // manualEnd = ("}" s END)
        manualEnd.add(242, new Str(241, "}"));
        manualEnd.add(243, s);
        manualEnd.add(245, new End(244, "manualEnd"));

        // generatedEnd = "//" s  ["*"+ | "-"+ | "="+] s "Generated" [!newline+]
        generatedEnd.add(247, new Str(246, "//"));
        generatedEnd.add(248, s);
        Optional generatedEnd_1 = new Optional(249, "generatedEnd_1");
        OrList generatedEnd_1_1 = new OrList(250, "generatedEnd_1_1");
        Repeat generatedEnd_1_1_1 = new Repeat(251, "generatedEnd_1_1_1");
        generatedEnd_1_1_1.add(253, new Str(252, "*"));
        generatedEnd_1_1.add(254, generatedEnd_1_1_1);
        Repeat generatedEnd_1_1_2 = new Repeat(255, "generatedEnd_1_1_2");
        generatedEnd_1_1_2.add(257, new Str(256, "-"));
        generatedEnd_1_1.add(258, generatedEnd_1_1_2);
        Repeat generatedEnd_1_1_3 = new Repeat(259, "generatedEnd_1_1_3");
        generatedEnd_1_1_3.add(261, new Str(260, "="));
        generatedEnd_1_1.add(262, generatedEnd_1_1_3);
        generatedEnd_1.add(263, generatedEnd_1_1);
        generatedEnd.add(264, generatedEnd_1);
        generatedEnd.add(265, s);
        generatedEnd.add(267, new Str(266, "Generated"));
        Optional generatedEnd_2 = new Optional(268, "generatedEnd_2");
        Repeat generatedEnd_2_1 = new Repeat(269, "generatedEnd_2_1");
        generatedEnd_2_1.add(270, newline, NOT);
        generatedEnd_2.add(271, generatedEnd_2_1);
        generatedEnd.add(272, generatedEnd_2);

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(273, "manualCode_1");
        manualCode_1.add(274, manualEnd);
        manualCode_1.add(275, generatedEnd);
        manualCode.add(276, manualCode_1, NOT);

        // body = "{" s [(body | str | !"}")+]:innerStatement "}"
        body.add(278, new Str(277, "{"));
        body.add(279, s);
        Optional body_1 = new Optional(280, "body_1");
        Repeat body_1_1 = new Repeat(281, "body_1_1");
        OrList body_1_1_1 = new OrList(282, "body_1_1_1");
        body_1_1_1.add(283, body);
        body_1_1_1.add(284, str);
        body_1_1_1.add(286, new Str(285, "}", NOT));
        body_1_1.add(287, body_1_1_1);
        body_1.add(288, body_1_1);
        body.add(289, body_1);
        body.add(291, new Str(290, "}"));

        // validateMethod = s "private void validate(Object rootElement, String parent, ValidationErrors.Builder errors)" s body
        validateMethod.add(292, s);
        validateMethod.add(294, new Str(293, "private void validate(Object rootElement, String parent, ValidationErrors.Builder errors)"));
        validateMethod.add(295, s);
        validateMethod.add(296, body);

        // version = digit+
        version.add(297, digit);

        // classStatement =
        //   "@State" [s "(" s "version" s "=" s version s ")"] ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ [manualCode]
        //   manualEnd|generatedEnd [!validateMethod:m+ validateMethod] *
        classStatement.add(299, new Str(298, "@State"));
        Optional classStatement_1 = new Optional(300, "classStatement_1");
        classStatement_1.add(301, s);
        classStatement_1.add(303, new Str(302, "("));
        classStatement_1.add(304, s);
        classStatement_1.add(306, new Str(305, "version"));
        classStatement_1.add(307, s);
        classStatement_1.add(309, new Str(308, "="));
        classStatement_1.add(310, s);
        classStatement_1.add(311, version);
        classStatement_1.add(312, s);
        classStatement_1.add(314, new Str(313, ")"));
        classStatement.add(315, classStatement_1);
        classStatement.add(316, ws);
        classStatement.add(317, _public);
        classStatement.add(319, new Str(318, "class"));
        classStatement.add(320, ws);
        classStatement.add(321, name);
        classStatement.add(322, s);
        Optional classStatement_2 = new Optional(323, "classStatement_2");
        classStatement_2.add(325, new Str(324, "extends"));
        classStatement_2.add(326, ws);
        classStatement_2.add(327, name);
        classStatement_2.add(328, s);
        classStatement.add(329, classStatement_2);
        Optional classStatement_3 = new Optional(330, "classStatement_3");
        classStatement_3.add(332, new Str(331, "implements"));
        classStatement_3.add(333, ws);
        classStatement_3.add(334, name);
        Optional classStatement_3_1 = new Optional(335, "classStatement_3_1");
        Repeat classStatement_3_1_1 = new Repeat(336, "classStatement_3_1_1");
        classStatement_3_1_1.add(337, s);
        classStatement_3_1_1.add(339, new Str(338, ","));
        classStatement_3_1_1.add(340, s);
        classStatement_3_1_1.add(341, name);
        classStatement_3_1.add(342, classStatement_3_1_1);
        classStatement_3.add(343, classStatement_3_1);
        classStatement_3.add(344, s);
        classStatement.add(345, classStatement_3);
        classStatement.add(347, new Str(346, "{"));
        classStatement.add(348, s);
        Optional classStatement_4 = new Optional(349, "classStatement_4");
        Repeat classStatement_4_1 = new Repeat(350, "classStatement_4_1");
        classStatement_4_1.add(351, attribute);
        classStatement_4.add(352, classStatement_4_1);
        classStatement.add(353, classStatement_4);
        Optional classStatement_5 = new Optional(354, "classStatement_5");
        classStatement_5.add(355, manualCode);
        classStatement.add(356, classStatement_5);
        OrList classStatement_6 = new OrList(357, "classStatement_6");
        classStatement_6.add(358, manualEnd);
        classStatement_6.add(359, generatedEnd);
        classStatement.add(360, classStatement_6);
        Optional classStatement_7 = new Optional(361, "classStatement_7");
        Repeat classStatement_7_1 = new Repeat(362, "classStatement_7_1");
        classStatement_7_1.add(363, validateMethod, NOT);
        classStatement_7.add(364, classStatement_7_1);
        classStatement_7.add(365, validateMethod);
        classStatement.add(366, classStatement_7);
        classStatement.add(368, new Complete(367, "classStatement"));

        // state = [s [packageStatement] s] imports s classStatement s
        Optional state_1 = new Optional(369, "state_1");
        state_1.add(370, s);
        Optional state_1_1 = new Optional(371, "state_1_1");
        state_1_1.add(372, packageStatement);
        state_1.add(373, state_1_1);
        state_1.add(374, s);
        state.add(375, state_1);
        state.add(376, imports);
        state.add(377, s);
        state.add(378, classStatement);
        state.add(379, s);

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
        StateParser.IPackageStatement createPackageStatement();
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
    // PackageStatement
    public interface IPackageStatement {
        public void setPackagename(String packagename);
        public void setContent(String packageStatement);
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
        public void setPackageStatement(IPackageStatement ipackageStatement);
        public void setImports(IImports iimports);
        public void setClassStatement(IClassStatement iclassStatement);
        public void setValidateMethod(String validateMethod);
    }

    // *** Data ***
    public static final class Data {
        private StateParser.IStateFactory factory;
        private Stack<IPackageStatement> packageStatementStack = new Stack<IPackageStatement>();
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

        // PackageStatement
        public void pushPackageStatement() { packageStatementStack.push(factory.createPackageStatement()); }
        public StateParser.IPackageStatement popPackageStatement() { return (StateParser.IPackageStatement)packageStatementStack.pop(); }
        public StateParser.IPackageStatement peekPackageStatement() {
            if (packageStatementStack.empty()) { return null; }
            return packageStatementStack.peek();
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

        // state.setValidateMethod(String classStatement.validateMethod);
        public class StateClassStatementValidateMethod implements Output {
            private String name;
            public StateClassStatementValidateMethod(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekState().setValidateMethod(source.get(bookmark));
            }
        }

        // State state.setPackageStatement(PackageStatement packageStatement);
        public class StateStatePackageStatement implements Output {
            private String name;
            public StateStatePackageStatement(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { pushPackageStatement(); }
            public void set(Source source, int bookmark) {
                peekState().setPackageStatement(popPackageStatement());
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
