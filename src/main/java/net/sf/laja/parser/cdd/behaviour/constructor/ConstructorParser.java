package net.sf.laja.parser.cdd.behaviour.constructor;

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
 * Auto generated 2012-04-01 by Laja:
 *    http://laja.sf.net
 *
 * Version: laja2-006
 */
public final class ConstructorParser implements net.sf.laja.parser.engine2.Parser {
    private static int NOT = net.sf.laja.parser.engine2.element.Element.NOT;
    private static int CS = net.sf.laja.parser.engine2.element.Element.CS;
    private static int CI = net.sf.laja.parser.engine2.element.Element.CI;

    private Data data1;
    private Data data2;
    private IConstructorFactory factory1;
    private IConstructorFactory factory2;
    private net.sf.laja.parser.engine2.Writer sourceRecorderLogWriter;
    private SyntaxErrorHandler syntaxErrorHandler;

    public static final int PHASE1 = 1;
    public static final int PHASE2 = 2;

    public ConstructorParser(IConstructorFactoryFactory factoryFactory) {
        init(factoryFactory);
    }

    public void init(IConstructorFactoryFactory factoryFactory) {
        syntaxErrorHandler = new DefaultSyntaxErrorHandler();
        factory1 = factoryFactory.getFactory(PHASE1);
        factory2 = factoryFactory.getFactory(PHASE2);
        data1 = new Data(factory1);
        data2 = new Data(factory2);
    }

    public ConstructorParser setSourceRecorderLogging(net.sf.laja.parser.engine2.Writer writer) {
        sourceRecorderLogWriter = writer;
        return this;
    }

    public ConstructorParser setSyntaxErrorHandler(SyntaxErrorHandler syntaxErrorHandler) {
        this.syntaxErrorHandler = syntaxErrorHandler;
        return this;
    }

    public IConstructorFactory getFactory1() {
        return factory1;
    }

    public IConstructorFactory getFactory() {
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
        Data.ConstructorConstructorCodeBlockCodeBlock constructorConstructorCodeBlockCodeBlock = data2.new ConstructorConstructorCodeBlockCodeBlock("constructorConstructorCodeBlockCodeBlock");
        Data.ConstructorConstructorFirstPart constructorConstructorFirstPart = data2.new ConstructorConstructorFirstPart("constructorConstructorFirstPart");
        Data.ConstructorConstructorLastPart constructorConstructorLastPart = data2.new ConstructorConstructorLastPart("constructorConstructorLastPart");

        // *** Declarations ***
        Str constructorComment = new Str(1, "// (constructor)");
        Str endComment = new Str(2, "// (end)");
        ElementList constructorCodeBlock = new ElementList(3, "constructorCodeBlock");
        ElementList constructor = new ElementList(4, "constructor");

        // *** Statements ***

        // constructorComment = "// (constructor)"

        // endComment = "// (end)"

        // constructorCodeBlock = !endComment+:codeBlock endComment
        Repeat constructorCodeBlock_1 = new Repeat(5, "constructorCodeBlock_1", constructorConstructorCodeBlockCodeBlock);
        constructorCodeBlock_1.add(6, endComment, NOT);
        constructorCodeBlock.add(7, constructorCodeBlock_1);
        constructorCodeBlock.add(8, endComment);

        // constructor = (!constructorComment+ constructorComment):firstPart (constructorCodeBlock *:lastPart)|(:endCodeBlock *):lastPart
        ElementList constructor_1 = new ElementList(9, "constructor_1", constructorConstructorFirstPart);
        Repeat constructor_1_1 = new Repeat(10, "constructor_1_1");
        constructor_1_1.add(11, constructorComment, NOT);
        constructor_1.add(12, constructor_1_1);
        constructor_1.add(13, constructorComment);
        constructor.add(14, constructor_1);
        OrList constructor_2 = new OrList(15, "constructor_2");
        ElementList constructor_2_1 = new ElementList(16, "constructor_2_1");
        constructor_2_1.add(17, constructorCodeBlock);
        constructor_2_1.add(19, new Complete(18, "constructor_2_1", constructorConstructorLastPart));
        constructor_2.add(20, constructor_2_1);
        ElementList constructor_2_2 = new ElementList(21, "constructor_2_2", constructorConstructorLastPart);
        constructor_2_2.add(23, new Marker(22, "endCodeBlock"));
        constructor_2_2.add(25, new Complete(24, "constructor_2_2"));
        constructor_2.add(26, constructor_2_2);
        constructor.add(27, constructor_2);

        return new TopElement(data2, constructor);
    }

    private net.sf.laja.parser.engine2.element.Element getGrammar1() {
        // *** Output classes ***

        // *** Declarations ***
        Str constructorComment = new Str(1, "// (constructor)");
        Str endComment = new Str(2, "// (end)");
        ElementList constructorCodeBlock = new ElementList(3, "constructorCodeBlock");
        ElementList constructor = new ElementList(4, "constructor");

        // *** Statements ***

        // constructorComment = "// (constructor)"

        // endComment = "// (end)"

        // constructorCodeBlock = !endComment+:codeBlock endComment
        Repeat constructorCodeBlock_1 = new Repeat(5, "constructorCodeBlock_1");
        constructorCodeBlock_1.add(6, endComment, NOT);
        constructorCodeBlock.add(7, constructorCodeBlock_1);
        constructorCodeBlock.add(8, endComment);

        // constructor = (!constructorComment+ constructorComment):firstPart (constructorCodeBlock *:lastPart)|(:endCodeBlock *):lastPart
        ElementList constructor_1 = new ElementList(9, "constructor_1");
        Repeat constructor_1_1 = new Repeat(10, "constructor_1_1");
        constructor_1_1.add(11, constructorComment, NOT);
        constructor_1.add(12, constructor_1_1);
        constructor_1.add(13, constructorComment);
        constructor.add(14, constructor_1);
        OrList constructor_2 = new OrList(15, "constructor_2");
        ElementList constructor_2_1 = new ElementList(16, "constructor_2_1");
        constructor_2_1.add(17, constructorCodeBlock);
        constructor_2_1.add(19, new Complete(18, "constructor_2_1"));
        constructor_2.add(20, constructor_2_1);
        ElementList constructor_2_2 = new ElementList(21, "constructor_2_2");
        constructor_2_2.add(23, new Marker(22, "endCodeBlock"));
        constructor_2_2.add(25, new Complete(24, "constructor_2_2"));
        constructor_2.add(26, constructor_2_2);
        constructor.add(27, constructor_2);

        return new TopElement(data1, constructor);
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
            data.pushConstructor();
            boolean match = element.parse(level, source, parentNot, caseSensitive, receive);
            data.popConstructor();
            return match;
        }
    }

    // *** IConstructorFactoryFactory
    public interface IConstructorFactoryFactory {
        public IConstructorFactory getFactory(int phase);
    }

    // *** IConstructorFactory ***
    public interface IConstructorFactory {
        ConstructorParser.IConstructor createConstructor();
    }

    // *** Interfaces ***
    // Constructor
    public interface IConstructor {
        public void setCodeBlock(String codeBlock);
        public void setFirstPart(String firstPart);
        public void setLastPart(String lastPart);
    }

    // *** Data ***
    public static final class Data {
        private ConstructorParser.IConstructorFactory factory;
        private Stack<IConstructor> constructorStack = new Stack<IConstructor>();

        public Data(ConstructorParser.IConstructorFactory factory) {
            this.factory = factory;
        }

        // Constructor
        public void pushConstructor() { constructorStack.push(factory.createConstructor()); }
        public ConstructorParser.IConstructor popConstructor() { return (ConstructorParser.IConstructor)constructorStack.pop(); }
        public ConstructorParser.IConstructor peekConstructor() {
            if (constructorStack.empty()) { return null; }
            return constructorStack.peek();
        }

        // Constructor constructor.setCodeBlock(String constructorCodeBlock.codeBlock);
        public class ConstructorConstructorCodeBlockCodeBlock implements Output {
            private String name;
            public ConstructorConstructorCodeBlockCodeBlock(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekConstructor().setCodeBlock(source.get(bookmark));
            }
        }

        // constructor.setFirstPart(String firstPart);
        public class ConstructorConstructorFirstPart implements Output {
            private String name;
            public ConstructorConstructorFirstPart(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekConstructor().setFirstPart(source.get(bookmark));
            }
        }

        // constructor.setLastPart(String lastPart);
        public class ConstructorConstructorLastPart implements Output {
            private String name;
            public ConstructorConstructorLastPart(String name) { this.name = name; }
            public boolean receive() { return false; }
            public void init(Source source) { }
            public void set(Source source, int bookmark) {
                peekConstructor().setLastPart(source.get(bookmark));
            }
        }
    }
}
