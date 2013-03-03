package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.behaviour.Behaviour;
import net.sf.laja.parser.cdd.behaviour.BehaviourFactory;
import net.sf.laja.parser.cdd.behaviour.BehaviourParser;
import net.sf.laja.parser.cdd.behaviour.constructor.Constructor;
import net.sf.laja.parser.cdd.behaviour.constructor.ConstructorFactory;
import net.sf.laja.parser.cdd.behaviour.constructor.ConstructorParser;
import net.sf.laja.parser.cdd.statetemplate.StateTemplate;
import net.sf.laja.parser.cdd.statetemplate.StateTemplateFactory;
import net.sf.laja.parser.cdd.statetemplate.StateTemplateParser;
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

    public StateTemplate parseStateTemplate(final String filePath) {
        StateTemplateParser parser = new StateTemplateParser(new StateTemplateParser.IStateTemplateFactoryFactory() {
            public StateTemplateParser.IStateTemplateFactory getFactory(int phase) {
                String filename = new File(filePath).getName();
                String classname = filename.substring(0, filename.length()-".java".length());
                return new StateTemplateFactory(classname);
            }
        });

        ParsingResult result = parser.parse(new FileSource(filePath));

        if (!result.success()) {
            return null;
        }

        StateTemplateFactory stateTemplateFactory = (StateTemplateFactory)parser.getFactory();
        StateTemplate stateTemplate = stateTemplateFactory.getStateTemplate();

        if (stateTemplate.isValidStatement != null) {
            stateTemplate.isValidStatement = stateTemplate.isValidStatement.trim();
        }

        return stateTemplate;
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
