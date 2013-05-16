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
 * Auto generated 2013-05-16 by Laja:
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
        ElementList type = new ElementList(20, "type");
        ElementList attribute = new ElementList(21, "attribute");
        ElementList manualEnd = new ElementList(22, "manualEnd");
        ElementList generatedEnd = new ElementList(23, "generatedEnd");
        Repeat manualCode = new Repeat(24, "manualCode");
        ElementList classStatement = new ElementList(25, "classStatement");
        ElementList state = new ElementList(26, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(28, new Str(27, "\r\n"));
        newline.add(30, new Str(29, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(31, "comment_1");
        comment_1.add(33, new Str(32, "/*"));
        Optional comment_1_1 = new Optional(34, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(35, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(36, "comment_1_1_1_1");
        comment_1_1_1_1.add(37, comment);
        comment_1_1_1_1.add(39, new Str(38, "*/", NOT));
        comment_1_1_1.add(40, comment_1_1_1_1);
        comment_1_1.add(41, comment_1_1_1);
        comment_1.add(42, comment_1_1);
        comment_1.add(44, new Str(43, "*/"));
        comment.add(45, comment_1);
        ElementList comment_2 = new ElementList(46, "comment_2");
        comment_2.add(48, new Str(47, "//"));
        Optional comment_2_1 = new Optional(49, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(50, "comment_2_1_1");
        comment_2_1_1.add(51, newline, NOT);
        comment_2_1.add(52, comment_2_1_1);
        comment_2.add(53, comment_2_1);
        OrList comment_2_2 = new OrList(54, "comment_2_2");
        comment_2_2.add(55, newline);
        comment_2_2.add(57, new End(56, "comment_2_2"));
        comment_2.add(58, comment_2_2);
        comment.add(59, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(60, "ws_1");
        ws_1.add(61, newline);
        ws_1.add(63, new Str(62, " "));
        ws_1.add(65, new Str(64, "\t"));
        ws_1.add(66, comment);
        ws.add(67, ws_1);

        // s = [ws]
        s.add(68, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(69, ff);
        Repeat str_1 = new Repeat(70, "str_1");
        OrList str_1_1 = new OrList(71, "str_1_1");
        str_1_1.add(73, new Str(72, "\\\""));
        OrList str_1_1_1 = new OrList(74, "str_1_1_1", NOT);
        str_1_1_1.add(75, ff);
        str_1_1_1.add(76, newline);
        str_1_1.add(77, str_1_1_1);
        str_1.add(78, str_1_1);
        str.add(79, str_1);
        str.add(80, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(82, new Range(81, "letter", "a", "z"));
        letter.add(84, new Range(83, "letter", "A", "Z"));
        letter.add(86, new Str(85, "_"));
        letter.add(88, new Str(87, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(89, letter);
        Optional name_1 = new Optional(90, "name_1");
        Repeat name_1_1 = new Repeat(91, "name_1_1");
        OrList name_1_1_1 = new OrList(92, "name_1_1_1");
        name_1_1_1.add(93, letter);
        name_1_1_1.add(94, digit);
        name_1_1.add(95, name_1_1_1);
        name_1.add(96, name_1_1);
        name.add(97, name_1);

        // public = ["public" ws]
        _public.add(99, new Str(98, "public"));
        _public.add(100, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(102, new Str(101, "package"));
        packagestatement.add(103, ws);
        packagestatement.add(104, packagename, statePackagestatementPackagename);
        packagestatement.add(105, s);
        packagestatement.add(107, new Str(106, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(108, name);
        Optional packagename_1 = new Optional(109, "packagename_1");
        Repeat packagename_1_1 = new Repeat(110, "packagename_1_1");
        packagename_1_1.add(112, new Str(111, "."));
        OrList packagename_1_1_1 = new OrList(113, "packagename_1_1_1");
        packagename_1_1_1.add(114, name);
        packagename_1_1_1.add(116, new Str(115, "*"));
        packagename_1_1.add(117, packagename_1_1_1);
        packagename_1.add(118, packagename_1_1);
        packagename.add(119, packagename_1);

        // fullclassname = packagename
        fullclassname.add(120, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(122, new Str(121, "import"));
        importstatement.add(123, ws);
        Optional importstatement_1 = new Optional(124, "importstatement_1");
        importstatement_1.add(126, new Str(125, "static", importstatementImportstatementStatic));
        importstatement_1.add(127, ws);
        importstatement.add(128, importstatement_1);
        importstatement.add(129, fullclassname, importstatementImportstatementFullclassname);
        importstatement.add(130, s);
        importstatement.add(132, new Str(131, ";"));
        importstatement.add(133, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(134, "imports_1");
        imports_1.add(135, importstatement, importsImportsImportstatement);
        imports.add(136, imports_1);

        // annotations = [("@" name s):annotation+]
        Repeat annotations_1 = new Repeat(137, "annotations_1");
        annotations_1.add(139, new Str(138, "@"));
        annotations_1.add(140, name);
        annotations_1.add(141, s);
        annotations.add(142, annotations_1, annotationsAnnotationsAnnotation);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(143, "keywords_1");
        OrList keywords_1_1 = new OrList(144, "keywords_1_1");
        keywords_1_1.add(146, new Str(145, "public "));
        keywords_1_1.add(148, new Str(147, "private "));
        keywords_1_1.add(150, new Str(149, "final "));
        keywords_1.add(151, keywords_1_1);
        keywords_1.add(152, s);
        keywords.add(153, keywords_1);

        // collectionType = s "<" s type s ">"
        collectionType.add(154, s);
        collectionType.add(156, new Str(155, "<"));
        collectionType.add(157, s);
        collectionType.add(158, type, collectionTypeCollectionTypeType);
        collectionType.add(159, s);
        collectionType.add(161, new Str(160, ">"));

        // mapType = s "<" s type:key s "," s type:entry s ">"
        mapType.add(162, s);
        mapType.add(164, new Str(163, "<"));
        mapType.add(165, s);
        mapType.add(166, type, mapTypeMapTypeKey);
        mapType.add(167, s);
        mapType.add(169, new Str(168, ","));
        mapType.add(170, s);
        mapType.add(171, type, mapTypeMapTypeEntry);
        mapType.add(172, s);
        mapType.add(174, new Str(173, ">"));

        // type = name [collectionType | mapType]
        type.add(175, name, typeTypeName);
        Optional type_1 = new Optional(176, "type_1");
        OrList type_1_1 = new OrList(177, "type_1_1");
        type_1_1.add(178, collectionType, typeTypeCollectionType);
        type_1_1.add(179, mapType, typeTypeMapType);
        type_1.add(180, type_1_1);
        type.add(181, type_1);

        // attribute = s annotations keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(182, s);
        attribute.add(183, annotations, attributeAttributeAnnotations);
        attribute.add(184, keywords);
        attribute.add(185, s);
        attribute.add(186, type, attributeAttributeType);
        attribute.add(187, ws);
        attribute.add(188, name, attributeAttributeVariable);
        attribute.add(189, s);
        attribute.add(191, new Str(190, ";"));
        Optional attribute_1 = new Optional(192, "attribute_1");
        Repeat attribute_1_1 = new Repeat(193, "attribute_1_1");
        attribute_1_1.add(194, newline, NOT);
        attribute_1.add(195, attribute_1_1);
        attribute.add(196, attribute_1);
        attribute.add(197, newline);

        // manualEnd = ("}" s END)
        manualEnd.add(199, new Str(198, "}"));
        manualEnd.add(200, s);
        manualEnd.add(202, new End(201, "manualEnd"));

        // generatedEnd = ("//" s  ["*"+ | "-"+ | "="+] s "Generated" [!newline+]):generatedText *
        ElementList generatedEnd_1 = new ElementList(203, "generatedEnd_1", classStatementGeneratedEndGeneratedText);
        generatedEnd_1.add(205, new Str(204, "//"));
        generatedEnd_1.add(206, s);
        Optional generatedEnd_1_1 = new Optional(207, "generatedEnd_1_1");
        OrList generatedEnd_1_1_1 = new OrList(208, "generatedEnd_1_1_1");
        Repeat generatedEnd_1_1_1_1 = new Repeat(209, "generatedEnd_1_1_1_1");
        generatedEnd_1_1_1_1.add(211, new Str(210, "*"));
        generatedEnd_1_1_1.add(212, generatedEnd_1_1_1_1);
        Repeat generatedEnd_1_1_1_2 = new Repeat(213, "generatedEnd_1_1_1_2");
        generatedEnd_1_1_1_2.add(215, new Str(214, "-"));
        generatedEnd_1_1_1.add(216, generatedEnd_1_1_1_2);
        Repeat generatedEnd_1_1_1_3 = new Repeat(217, "generatedEnd_1_1_1_3");
        generatedEnd_1_1_1_3.add(219, new Str(218, "="));
        generatedEnd_1_1_1.add(220, generatedEnd_1_1_1_3);
        generatedEnd_1_1.add(221, generatedEnd_1_1_1);
        generatedEnd_1.add(222, generatedEnd_1_1);
        generatedEnd_1.add(223, s);
        generatedEnd_1.add(225, new Str(224, "Generated"));
        Optional generatedEnd_1_2 = new Optional(226, "generatedEnd_1_2");
        Repeat generatedEnd_1_2_1 = new Repeat(227, "generatedEnd_1_2_1");
        generatedEnd_1_2_1.add(228, newline, NOT);
        generatedEnd_1_2.add(229, generatedEnd_1_2_1);
        generatedEnd_1.add(230, generatedEnd_1_2);
        generatedEnd.add(231, generatedEnd_1);
        generatedEnd.add(233, new Complete(232, "generatedEnd"));

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(234, "manualCode_1");
        manualCode_1.add(235, manualEnd);
        manualCode_1.add(236, generatedEnd);
        manualCode.add(237, manualCode_1, NOT);

        // classStatement =
        //   "@State" ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ manualCode
        //   manualEnd|generatedEnd *
        classStatement.add(239, new Str(238, "@State"));
        classStatement.add(240, ws);
        classStatement.add(241, _public);
        classStatement.add(243, new Str(242, "class"));
        classStatement.add(244, ws);
        classStatement.add(245, name, classStatementClassStatementClassname);
        classStatement.add(246, s);
        Optional classStatement_1 = new Optional(247, "classStatement_1");
        classStatement_1.add(249, new Str(248, "extends"));
        classStatement_1.add(250, ws);
        classStatement_1.add(251, name);
        classStatement_1.add(252, s);
        classStatement.add(253, classStatement_1);
        Optional classStatement_2 = new Optional(254, "classStatement_2");
        classStatement_2.add(256, new Str(255, "implements"));
        classStatement_2.add(257, ws);
        classStatement_2.add(258, name);
        Optional classStatement_2_1 = new Optional(259, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(260, "classStatement_2_1_1");
        classStatement_2_1_1.add(261, s);
        classStatement_2_1_1.add(263, new Str(262, ","));
        classStatement_2_1_1.add(264, s);
        classStatement_2_1_1.add(265, name);
        classStatement_2_1.add(266, classStatement_2_1_1);
        classStatement_2.add(267, classStatement_2_1);
        classStatement_2.add(268, s);
        classStatement.add(269, classStatement_2);
        classStatement.add(271, new Str(270, "{"));
        classStatement.add(272, s);
        Optional classStatement_3 = new Optional(273, "classStatement_3");
        Repeat classStatement_3_1 = new Repeat(274, "classStatement_3_1");
        classStatement_3_1.add(275, attribute, classStatementClassStatementAttribute);
        classStatement_3.add(276, classStatement_3_1);
        classStatement.add(277, classStatement_3);
        classStatement.add(278, manualCode, classStatementClassStatementManualCode);
        OrList classStatement_4 = new OrList(279, "classStatement_4");
        classStatement_4.add(280, manualEnd);
        classStatement_4.add(281, generatedEnd);
        classStatement.add(282, classStatement_4);
        classStatement.add(284, new Complete(283, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(285, s);
        state.add(286, packagestatement);
        state.add(287, s);
        state.add(288, imports, stateStateImports);
        state.add(289, s);
        state.add(290, classStatement, stateStateClassStatement);
        state.add(291, s);

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
        ElementList manualEnd = new ElementList(22, "manualEnd");
        ElementList generatedEnd = new ElementList(23, "generatedEnd");
        Repeat manualCode = new Repeat(24, "manualCode");
        ElementList classStatement = new ElementList(25, "classStatement");
        ElementList state = new ElementList(26, "state");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(28, new Str(27, "\r\n"));
        newline.add(30, new Str(29, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(31, "comment_1");
        comment_1.add(33, new Str(32, "/*"));
        Optional comment_1_1 = new Optional(34, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(35, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(36, "comment_1_1_1_1");
        comment_1_1_1_1.add(37, comment);
        comment_1_1_1_1.add(39, new Str(38, "*/", NOT));
        comment_1_1_1.add(40, comment_1_1_1_1);
        comment_1_1.add(41, comment_1_1_1);
        comment_1.add(42, comment_1_1);
        comment_1.add(44, new Str(43, "*/"));
        comment.add(45, comment_1);
        ElementList comment_2 = new ElementList(46, "comment_2");
        comment_2.add(48, new Str(47, "//"));
        Optional comment_2_1 = new Optional(49, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(50, "comment_2_1_1");
        comment_2_1_1.add(51, newline, NOT);
        comment_2_1.add(52, comment_2_1_1);
        comment_2.add(53, comment_2_1);
        OrList comment_2_2 = new OrList(54, "comment_2_2");
        comment_2_2.add(55, newline);
        comment_2_2.add(57, new End(56, "comment_2_2"));
        comment_2.add(58, comment_2_2);
        comment.add(59, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(60, "ws_1");
        ws_1.add(61, newline);
        ws_1.add(63, new Str(62, " "));
        ws_1.add(65, new Str(64, "\t"));
        ws_1.add(66, comment);
        ws.add(67, ws_1);

        // s = [ws]
        s.add(68, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(69, ff);
        Repeat str_1 = new Repeat(70, "str_1");
        OrList str_1_1 = new OrList(71, "str_1_1");
        str_1_1.add(73, new Str(72, "\\\""));
        OrList str_1_1_1 = new OrList(74, "str_1_1_1", NOT);
        str_1_1_1.add(75, ff);
        str_1_1_1.add(76, newline);
        str_1_1.add(77, str_1_1_1);
        str_1.add(78, str_1_1);
        str.add(79, str_1);
        str.add(80, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(82, new Range(81, "letter", "a", "z"));
        letter.add(84, new Range(83, "letter", "A", "Z"));
        letter.add(86, new Str(85, "_"));
        letter.add(88, new Str(87, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(89, letter);
        Optional name_1 = new Optional(90, "name_1");
        Repeat name_1_1 = new Repeat(91, "name_1_1");
        OrList name_1_1_1 = new OrList(92, "name_1_1_1");
        name_1_1_1.add(93, letter);
        name_1_1_1.add(94, digit);
        name_1_1.add(95, name_1_1_1);
        name_1.add(96, name_1_1);
        name.add(97, name_1);

        // public = ["public" ws]
        _public.add(99, new Str(98, "public"));
        _public.add(100, ws);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(102, new Str(101, "package"));
        packagestatement.add(103, ws);
        packagestatement.add(104, packagename);
        packagestatement.add(105, s);
        packagestatement.add(107, new Str(106, ";"));

        // packagename = name ["." name|"*"]+
        packagename.add(108, name);
        Optional packagename_1 = new Optional(109, "packagename_1");
        Repeat packagename_1_1 = new Repeat(110, "packagename_1_1");
        packagename_1_1.add(112, new Str(111, "."));
        OrList packagename_1_1_1 = new OrList(113, "packagename_1_1_1");
        packagename_1_1_1.add(114, name);
        packagename_1_1_1.add(116, new Str(115, "*"));
        packagename_1_1.add(117, packagename_1_1_1);
        packagename_1.add(118, packagename_1_1);
        packagename.add(119, packagename_1);

        // fullclassname = packagename
        fullclassname.add(120, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(122, new Str(121, "import"));
        importstatement.add(123, ws);
        Optional importstatement_1 = new Optional(124, "importstatement_1");
        importstatement_1.add(126, new Str(125, "static"));
        importstatement_1.add(127, ws);
        importstatement.add(128, importstatement_1);
        importstatement.add(129, fullclassname);
        importstatement.add(130, s);
        importstatement.add(132, new Str(131, ";"));
        importstatement.add(133, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(134, "imports_1");
        imports_1.add(135, importstatement);
        imports.add(136, imports_1);

        // annotations = [("@" name s):annotation+]
        Repeat annotations_1 = new Repeat(137, "annotations_1");
        annotations_1.add(139, new Str(138, "@"));
        annotations_1.add(140, name);
        annotations_1.add(141, s);
        annotations.add(142, annotations_1);

        // keywords = ["public "|"private "|"final " s]+
        Repeat keywords_1 = new Repeat(143, "keywords_1");
        OrList keywords_1_1 = new OrList(144, "keywords_1_1");
        keywords_1_1.add(146, new Str(145, "public "));
        keywords_1_1.add(148, new Str(147, "private "));
        keywords_1_1.add(150, new Str(149, "final "));
        keywords_1.add(151, keywords_1_1);
        keywords_1.add(152, s);
        keywords.add(153, keywords_1);

        // collectionType = s "<" s type s ">"
        collectionType.add(154, s);
        collectionType.add(156, new Str(155, "<"));
        collectionType.add(157, s);
        collectionType.add(158, type);
        collectionType.add(159, s);
        collectionType.add(161, new Str(160, ">"));

        // mapType = s "<" s type:key s "," s type:entry s ">"
        mapType.add(162, s);
        mapType.add(164, new Str(163, "<"));
        mapType.add(165, s);
        mapType.add(166, type);
        mapType.add(167, s);
        mapType.add(169, new Str(168, ","));
        mapType.add(170, s);
        mapType.add(171, type);
        mapType.add(172, s);
        mapType.add(174, new Str(173, ">"));

        // type = name [collectionType | mapType]
        type.add(175, name);
        Optional type_1 = new Optional(176, "type_1");
        OrList type_1_1 = new OrList(177, "type_1_1");
        type_1_1.add(178, collectionType);
        type_1_1.add(179, mapType);
        type_1.add(180, type_1_1);
        type.add(181, type_1);

        // attribute = s annotations keywords s type ws name:variable s ";" [!newline+] newline
        attribute.add(182, s);
        attribute.add(183, annotations);
        attribute.add(184, keywords);
        attribute.add(185, s);
        attribute.add(186, type);
        attribute.add(187, ws);
        attribute.add(188, name);
        attribute.add(189, s);
        attribute.add(191, new Str(190, ";"));
        Optional attribute_1 = new Optional(192, "attribute_1");
        Repeat attribute_1_1 = new Repeat(193, "attribute_1_1");
        attribute_1_1.add(194, newline, NOT);
        attribute_1.add(195, attribute_1_1);
        attribute.add(196, attribute_1);
        attribute.add(197, newline);

        // manualEnd = ("}" s END)
        manualEnd.add(199, new Str(198, "}"));
        manualEnd.add(200, s);
        manualEnd.add(202, new End(201, "manualEnd"));

        // generatedEnd = ("//" s  ["*"+ | "-"+ | "="+] s "Generated" [!newline+]):generatedText *
        ElementList generatedEnd_1 = new ElementList(203, "generatedEnd_1");
        generatedEnd_1.add(205, new Str(204, "//"));
        generatedEnd_1.add(206, s);
        Optional generatedEnd_1_1 = new Optional(207, "generatedEnd_1_1");
        OrList generatedEnd_1_1_1 = new OrList(208, "generatedEnd_1_1_1");
        Repeat generatedEnd_1_1_1_1 = new Repeat(209, "generatedEnd_1_1_1_1");
        generatedEnd_1_1_1_1.add(211, new Str(210, "*"));
        generatedEnd_1_1_1.add(212, generatedEnd_1_1_1_1);
        Repeat generatedEnd_1_1_1_2 = new Repeat(213, "generatedEnd_1_1_1_2");
        generatedEnd_1_1_1_2.add(215, new Str(214, "-"));
        generatedEnd_1_1_1.add(216, generatedEnd_1_1_1_2);
        Repeat generatedEnd_1_1_1_3 = new Repeat(217, "generatedEnd_1_1_1_3");
        generatedEnd_1_1_1_3.add(219, new Str(218, "="));
        generatedEnd_1_1_1.add(220, generatedEnd_1_1_1_3);
        generatedEnd_1_1.add(221, generatedEnd_1_1_1);
        generatedEnd_1.add(222, generatedEnd_1_1);
        generatedEnd_1.add(223, s);
        generatedEnd_1.add(225, new Str(224, "Generated"));
        Optional generatedEnd_1_2 = new Optional(226, "generatedEnd_1_2");
        Repeat generatedEnd_1_2_1 = new Repeat(227, "generatedEnd_1_2_1");
        generatedEnd_1_2_1.add(228, newline, NOT);
        generatedEnd_1_2.add(229, generatedEnd_1_2_1);
        generatedEnd_1.add(230, generatedEnd_1_2);
        generatedEnd.add(231, generatedEnd_1);
        generatedEnd.add(233, new Complete(232, "generatedEnd"));

        // manualCode = !(manualEnd | generatedEnd)+
        OrList manualCode_1 = new OrList(234, "manualCode_1");
        manualCode_1.add(235, manualEnd);
        manualCode_1.add(236, generatedEnd);
        manualCode.add(237, manualCode_1, NOT);

        // classStatement =
        //   "@State" ws public "class" ws name:classname s ["extends" ws name s]
        //   ["implements" ws name [s "," s name]+ s] "{" s [attribute]+ manualCode
        //   manualEnd|generatedEnd *
        classStatement.add(239, new Str(238, "@State"));
        classStatement.add(240, ws);
        classStatement.add(241, _public);
        classStatement.add(243, new Str(242, "class"));
        classStatement.add(244, ws);
        classStatement.add(245, name);
        classStatement.add(246, s);
        Optional classStatement_1 = new Optional(247, "classStatement_1");
        classStatement_1.add(249, new Str(248, "extends"));
        classStatement_1.add(250, ws);
        classStatement_1.add(251, name);
        classStatement_1.add(252, s);
        classStatement.add(253, classStatement_1);
        Optional classStatement_2 = new Optional(254, "classStatement_2");
        classStatement_2.add(256, new Str(255, "implements"));
        classStatement_2.add(257, ws);
        classStatement_2.add(258, name);
        Optional classStatement_2_1 = new Optional(259, "classStatement_2_1");
        Repeat classStatement_2_1_1 = new Repeat(260, "classStatement_2_1_1");
        classStatement_2_1_1.add(261, s);
        classStatement_2_1_1.add(263, new Str(262, ","));
        classStatement_2_1_1.add(264, s);
        classStatement_2_1_1.add(265, name);
        classStatement_2_1.add(266, classStatement_2_1_1);
        classStatement_2.add(267, classStatement_2_1);
        classStatement_2.add(268, s);
        classStatement.add(269, classStatement_2);
        classStatement.add(271, new Str(270, "{"));
        classStatement.add(272, s);
        Optional classStatement_3 = new Optional(273, "classStatement_3");
        Repeat classStatement_3_1 = new Repeat(274, "classStatement_3_1");
        classStatement_3_1.add(275, attribute);
        classStatement_3.add(276, classStatement_3_1);
        classStatement.add(277, classStatement_3);
        classStatement.add(278, manualCode);
        OrList classStatement_4 = new OrList(279, "classStatement_4");
        classStatement_4.add(280, manualEnd);
        classStatement_4.add(281, generatedEnd);
        classStatement.add(282, classStatement_4);
        classStatement.add(284, new Complete(283, "classStatement"));

        // state = s packagestatement s imports s classStatement s
        state.add(285, s);
        state.add(286, packagestatement);
        state.add(287, s);
        state.add(288, imports);
        state.add(289, s);
        state.add(290, classStatement);
        state.add(291, s);

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
