package net.sf.laja.parser.cdd.state;

public class StateFactory implements StateParser.IStateFactory {
    public final String stateClassname;
    public State state;

    public StateFactory(String stateClassname) {
        this.stateClassname = stateClassname;
    }

    public StateParser.IImportstatement createImportstatement() {
        return new ImportStatement();
    }

    public StateParser.IImports createImports() {
        return new Imports();
    }

    public StateParser.IAttribute createAttribute() {
        return new Attribute();
    }

    public StateParser.IClassStatement createClassStatement() {
        return new ClassStatement();
    }

    public StateParser.IState createState() {
        return state = new State();
    }
}
