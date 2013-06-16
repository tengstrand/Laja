package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.creator.Creator;
import net.sf.laja.parser.cdd.creator.CreatorFactory;
import net.sf.laja.parser.cdd.creator.CreatorParser;
import net.sf.laja.parser.cdd.state.State;
import net.sf.laja.parser.cdd.state.StateFactory;
import net.sf.laja.parser.cdd.state.StateParser;
import net.sf.laja.parser.engine2.ParsingResult;
import net.sf.laja.parser.engine2.source.FileSource;

import java.io.File;

public class CddParser {

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
}
