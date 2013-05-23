package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.behaviour.Behaviour;
import net.sf.laja.parser.cdd.behaviour.BehaviourFactory;
import net.sf.laja.parser.cdd.behaviour.BehaviourParser;
import net.sf.laja.parser.cdd.behaviour.constructor.Constructor;
import net.sf.laja.parser.cdd.behaviour.constructor.ConstructorFactory;
import net.sf.laja.parser.cdd.behaviour.constructor.ConstructorParser;
import net.sf.laja.parser.cdd.creator.Creator;
import net.sf.laja.parser.cdd.creator.CreatorFactory;
import net.sf.laja.parser.cdd.creator.CreatorParser;
import net.sf.laja.parser.cdd.state.State;
import net.sf.laja.parser.cdd.state.StateFactory;
import net.sf.laja.parser.cdd.state.StateParser;
import net.sf.laja.parser.engine2.ParsingResult;
import net.sf.laja.parser.engine2.source.FileSource;

import java.io.File;
import java.io.IOException;

public class CddParser {

    /**
     * Only used from the IDE to test the grammar!
     */
    public static void main(String[] args) throws IOException {
        CddParser parser = new CddParser();

        try {
            Behaviour behaviour = parser.parseBehaviour("C:/Projects/MyProject/src/java/main/com/myproject/behaviour/Person.java");
            System.out.println(behaviour);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public State parseState(final String filePath) {
        StateParser parser = new StateParser(new StateParser.IStateFactoryFactory() {
            public StateParser.IStateFactory getFactory(int phase) {
                String filename = new File(filePath).getName();
                String classname = filename.substring(0, filename.length()-".java".length());
                return new StateFactory(classname);
            }
        });

        ParsingResult result = parser.parse(new FileSource(filePath));

        if (!result.success()) {
            return null;
        }

        StateFactory stateFactory = (StateFactory)parser.getFactory();

        return stateFactory.state;
    }

    public Creator parseCreator(final String filePath) {
        CreatorParser parser = new CreatorParser(new CreatorParser.ICreatorFactoryFactory() {
            public CreatorParser.ICreatorFactory getFactory(int phase) {
                String filename = new File(filePath).getName();
                String classname = filename.substring(0, filename.length()-".java".length());
                return new CreatorFactory(classname);
            }
        });

        ParsingResult result = parser.parse(new FileSource(filePath));

        if (!result.success()) {
            return null;
        }

        CreatorFactory creatorFactory = (CreatorFactory)parser.getFactory();

        return creatorFactory.creator;
    }

    public Behaviour parseBehaviour(final String filePath) {
        BehaviourParser parser = new BehaviourParser(new BehaviourParser.IBehaviourFactoryFactory() {
            public BehaviourParser.IBehaviourFactory getFactory(int phase) {
                return new BehaviourFactory();
            }
        });

        ParsingResult result = parser.parse(new FileSource(filePath));

        if (!result.success()) {
            return null;
        }

        BehaviourFactory behaviourFactory = (BehaviourFactory)parser.getFactory();
        Behaviour behaviour = behaviourFactory.getBehaviour();

        return behaviour;
    }

    public Constructor parseConstructor(final String filePath) {
        ConstructorParser parser = new ConstructorParser(new ConstructorParser.IConstructorFactoryFactory() {
            public ConstructorParser.IConstructorFactory getFactory(int phase) {
                return new ConstructorFactory();
            }
        });

        ParsingResult result = parser.parse(new FileSource(filePath));

        if (!result.success()) {
            return null;
        }

        ConstructorFactory constructorFactory = (ConstructorFactory)parser.getFactory();
        Constructor constructor = constructorFactory.getConstructor();

        return constructor;
    }
}
