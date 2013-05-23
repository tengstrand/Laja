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
        Data.CreatorCreatorImports creatorCreatorImports = data2.new CreatorCreatorImports("creatorCreatorImports");

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
        ElementList classStatement = new ElementList(16, "classStatement");
        ElementList creator = new ElementList(17, "creator");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(19, new Str(18, "\r\n"));
        newline.add(21, new Str(20, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(22, "comment_1");
        comment_1.add(24, new Str(23, "/*"));
        Optional comment_1_1 = new Optional(25, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(26, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(27, "comment_1_1_1_1");
        comment_1_1_1_1.add(28, comment);
        comment_1_1_1_1.add(30, new Str(29, "*/", NOT));
        comment_1_1_1.add(31, comment_1_1_1_1);
        comment_1_1.add(32, comment_1_1_1);
        comment_1.add(33, comment_1_1);
        comment_1.add(35, new Str(34, "*/"));
        comment.add(36, comment_1);
        ElementList comment_2 = new ElementList(37, "comment_2");
        comment_2.add(39, new Str(38, "//"));
        Optional comment_2_1 = new Optional(40, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(41, "comment_2_1_1");
        comment_2_1_1.add(42, newline, NOT);
        comment_2_1.add(43, comment_2_1_1);
        comment_2.add(44, comment_2_1);
        OrList comment_2_2 = new OrList(45, "comment_2_2");
        comment_2_2.add(46, newline);
        comment_2_2.add(48, new End(47, "comment_2_2"));
        comment_2.add(49, comment_2_2);
        comment.add(50, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(51, "ws_1");
        ws_1.add(52, newline);
        ws_1.add(54, new Str(53, " "));
        ws_1.add(56, new Str(55, "\t"));
        ws_1.add(57, comment);
        ws.add(58, ws_1);

        // s = [ws]
        s.add(59, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(60, ff);
        Repeat str_1 = new Repeat(61, "str_1");
        OrList str_1_1 = new OrList(62, "str_1_1");
        str_1_1.add(64, new Str(63, "\\\""));
        OrList str_1_1_1 = new OrList(65, "str_1_1_1", NOT);
        str_1_1_1.add(66, ff);
        str_1_1_1.add(67, newline);
        str_1_1.add(68, str_1_1_1);
        str_1.add(69, str_1_1);
        str.add(70, str_1);
        str.add(71, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(73, new Range(72, "letter", "a", "z"));
        letter.add(75, new Range(74, "letter", "A", "Z"));
        letter.add(77, new Str(76, "_"));
        letter.add(79, new Str(78, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(80, letter);
        Optional name_1 = new Optional(81, "name_1");
        Repeat name_1_1 = new Repeat(82, "name_1_1");
        OrList name_1_1_1 = new OrList(83, "name_1_1_1");
        name_1_1_1.add(84, letter);
        name_1_1_1.add(85, digit);
        name_1_1.add(86, name_1_1_1);
        name_1.add(87, name_1_1);
        name.add(88, name_1);

        // public = ["public" ws]
        _public.add(90, new Str(89, "public"));
        _public.add(91, ws);

        // packagename = name ["." name|"*"]+
        packagename.add(92, name);
        Optional packagename_1 = new Optional(93, "packagename_1");
        Repeat packagename_1_1 = new Repeat(94, "packagename_1_1");
        packagename_1_1.add(96, new Str(95, "."));
        OrList packagename_1_1_1 = new OrList(97, "packagename_1_1_1");
        packagename_1_1_1.add(98, name);
        packagename_1_1_1.add(100, new Str(99, "*"));
        packagename_1_1.add(101, packagename_1_1_1);
        packagename_1.add(102, packagename_1_1);
        packagename.add(103, packagename_1);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(105, new Str(104, "package"));
        packagestatement.add(106, ws);
        packagestatement.add(107, packagename);
        packagestatement.add(108, s);
        packagestatement.add(110, new Str(109, ";"));

        // fullclassname = packagename
        fullclassname.add(111, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(113, new Str(112, "import"));
        importstatement.add(114, ws);
        Optional importstatement_1 = new Optional(115, "importstatement_1");
        importstatement_1.add(117, new Str(116, "static"));
        importstatement_1.add(118, ws);
        importstatement.add(119, importstatement_1);
        importstatement.add(120, fullclassname);
        importstatement.add(121, s);
        importstatement.add(123, new Str(122, ";"));
        importstatement.add(124, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(125, "imports_1");
        imports_1.add(126, importstatement);
        imports.add(127, imports_1);

        // classStatement =
        //   "@Creator" ws public "class" ws name:classname s "implements" s name s "{" s
        //   "private final" s name s "state;" s *
        classStatement.add(129, new Str(128, "@Creator"));
        classStatement.add(130, ws);
        classStatement.add(131, _public);
        classStatement.add(133, new Str(132, "class"));
        classStatement.add(134, ws);
        classStatement.add(135, name);
        classStatement.add(136, s);
        classStatement.add(138, new Str(137, "implements"));
        classStatement.add(139, s);
        classStatement.add(140, name);
        classStatement.add(141, s);
        classStatement.add(143, new Str(142, "{"));
        classStatement.add(144, s);
        classStatement.add(146, new Str(145, "private final"));
        classStatement.add(147, s);
        classStatement.add(148, name);
        classStatement.add(149, s);
        classStatement.add(151, new Str(150, "state;"));
        classStatement.add(152, s);
        classStatement.add(154, new Complete(153, "classStatement"));

        // creator = packagestatement s imports s classStatement
        creator.add(155, packagestatement);
        creator.add(156, s);
        creator.add(157, imports, creatorCreatorImports);
        creator.add(158, s);
        creator.add(159, classStatement);

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
        ElementList classStatement = new ElementList(16, "classStatement");
        ElementList creator = new ElementList(17, "creator");

        // *** Statements ***

        // newline = "\r\n" | "\n"
        newline.add(19, new Str(18, "\r\n"));
        newline.add(21, new Str(20, "\n"));

        // comment = ("/*" [(comment | !"*/")+] "*/") | ("//" [!newline+] newline|END)
        ElementList comment_1 = new ElementList(22, "comment_1");
        comment_1.add(24, new Str(23, "/*"));
        Optional comment_1_1 = new Optional(25, "comment_1_1");
        Repeat comment_1_1_1 = new Repeat(26, "comment_1_1_1");
        OrList comment_1_1_1_1 = new OrList(27, "comment_1_1_1_1");
        comment_1_1_1_1.add(28, comment);
        comment_1_1_1_1.add(30, new Str(29, "*/", NOT));
        comment_1_1_1.add(31, comment_1_1_1_1);
        comment_1_1.add(32, comment_1_1_1);
        comment_1.add(33, comment_1_1);
        comment_1.add(35, new Str(34, "*/"));
        comment.add(36, comment_1);
        ElementList comment_2 = new ElementList(37, "comment_2");
        comment_2.add(39, new Str(38, "//"));
        Optional comment_2_1 = new Optional(40, "comment_2_1");
        Repeat comment_2_1_1 = new Repeat(41, "comment_2_1_1");
        comment_2_1_1.add(42, newline, NOT);
        comment_2_1.add(43, comment_2_1_1);
        comment_2.add(44, comment_2_1);
        OrList comment_2_2 = new OrList(45, "comment_2_2");
        comment_2_2.add(46, newline);
        comment_2_2.add(48, new End(47, "comment_2_2"));
        comment_2.add(49, comment_2_2);
        comment.add(50, comment_2);

        // ws = (newline | " " | "\t" | comment)+
        OrList ws_1 = new OrList(51, "ws_1");
        ws_1.add(52, newline);
        ws_1.add(54, new Str(53, " "));
        ws_1.add(56, new Str(55, "\t"));
        ws_1.add(57, comment);
        ws.add(58, ws_1);

        // s = [ws]
        s.add(59, ws);

        // ff = "\""

        // str = ff (("\\\"" | !(ff|newline))+):strval ff
        str.add(60, ff);
        Repeat str_1 = new Repeat(61, "str_1");
        OrList str_1_1 = new OrList(62, "str_1_1");
        str_1_1.add(64, new Str(63, "\\\""));
        OrList str_1_1_1 = new OrList(65, "str_1_1_1", NOT);
        str_1_1_1.add(66, ff);
        str_1_1_1.add(67, newline);
        str_1_1.add(68, str_1_1_1);
        str_1.add(69, str_1_1);
        str.add(70, str_1);
        str.add(71, ff);

        // letter = "a".."z" | "A".."Z" | "_" | "$"
        letter.add(73, new Range(72, "letter", "a", "z"));
        letter.add(75, new Range(74, "letter", "A", "Z"));
        letter.add(77, new Str(76, "_"));
        letter.add(79, new Str(78, "$"));

        // digit = "0".."9"

        // name = letter [letter | digit]+
        name.add(80, letter);
        Optional name_1 = new Optional(81, "name_1");
        Repeat name_1_1 = new Repeat(82, "name_1_1");
        OrList name_1_1_1 = new OrList(83, "name_1_1_1");
        name_1_1_1.add(84, letter);
        name_1_1_1.add(85, digit);
        name_1_1.add(86, name_1_1_1);
        name_1.add(87, name_1_1);
        name.add(88, name_1);

        // public = ["public" ws]
        _public.add(90, new Str(89, "public"));
        _public.add(91, ws);

        // packagename = name ["." name|"*"]+
        packagename.add(92, name);
        Optional packagename_1 = new Optional(93, "packagename_1");
        Repeat packagename_1_1 = new Repeat(94, "packagename_1_1");
        packagename_1_1.add(96, new Str(95, "."));
        OrList packagename_1_1_1 = new OrList(97, "packagename_1_1_1");
        packagename_1_1_1.add(98, name);
        packagename_1_1_1.add(100, new Str(99, "*"));
        packagename_1_1.add(101, packagename_1_1_1);
        packagename_1.add(102, packagename_1_1);
        packagename.add(103, packagename_1);

        // packagestatement = "package" ws packagename s ";"
        packagestatement.add(105, new Str(104, "package"));
        packagestatement.add(106, ws);
        packagestatement.add(107, packagename);
        packagestatement.add(108, s);
        packagestatement.add(110, new Str(109, ";"));

        // fullclassname = packagename
        fullclassname.add(111, packagename);

        // importstatement = "import" ws ["static":static ws] fullclassname s ";" s
        importstatement.add(113, new Str(112, "import"));
        importstatement.add(114, ws);
        Optional importstatement_1 = new Optional(115, "importstatement_1");
        importstatement_1.add(117, new Str(116, "static"));
        importstatement_1.add(118, ws);
        importstatement.add(119, importstatement_1);
        importstatement.add(120, fullclassname);
        importstatement.add(121, s);
        importstatement.add(123, new Str(122, ";"));
        importstatement.add(124, s);

        // imports = [importstatement+]
        Repeat imports_1 = new Repeat(125, "imports_1");
        imports_1.add(126, importstatement);
        imports.add(127, imports_1);

        // classStatement =
        //   "@Creator" ws public "class" ws name:classname s "implements" s name s "{" s
        //   "private final" s name s "state;" s *
        classStatement.add(129, new Str(128, "@Creator"));
        classStatement.add(130, ws);
        classStatement.add(131, _public);
        classStatement.add(133, new Str(132, "class"));
        classStatement.add(134, ws);
        classStatement.add(135, name);
        classStatement.add(136, s);
        classStatement.add(138, new Str(137, "implements"));
        classStatement.add(139, s);
        classStatement.add(140, name);
        classStatement.add(141, s);
        classStatement.add(143, new Str(142, "{"));
        classStatement.add(144, s);
        classStatement.add(146, new Str(145, "private final"));
        classStatement.add(147, s);
        classStatement.add(148, name);
        classStatement.add(149, s);
        classStatement.add(151, new Str(150, "state;"));
        classStatement.add(152, s);
        classStatement.add(154, new Complete(153, "classStatement"));

        // creator = packagestatement s imports s classStatement
        creator.add(155, packagestatement);
        creator.add(156, s);
        creator.add(157, imports);
        creator.add(158, s);
        creator.add(159, classStatement);

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
        CreatorParser.ICreator createCreator();
    }

    // *** Interfaces ***
    // Creator
    public interface ICreator {
        public void setImports(String imports);
    }

    // *** Data ***
    public static final class Data {
        private CreatorParser.ICreatorFactory factory;
        private Stack<ICreator> creatorStack = new Stack<ICreator>();

        public Data(CreatorParser.ICreatorFactory factory) {
            this.factory = factory;
        }

        // Creator
        public void pushCreator() { creatorStack.push(factory.createCreator()); }
        public CreatorParser.ICreator popCreator() { return (CreatorParser.ICreator)creatorStack.pop(); }
        public CreatorParser.ICreator peekCreator() {
            if (creatorStack.empty()) { return null; }
            return creatorStack.peek();
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
    }
}
