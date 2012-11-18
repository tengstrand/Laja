package net.sf.laja.parser.cdd.behaviour;

import net.sf.laja.parser.cdd.behaviour.constructor.Importstatement;

public class BehaviourFactory implements BehaviourParser.IBehaviourFactory {
    private Behaviour behaviour;

    public Behaviour getBehaviour() {
        return behaviour;
    }

    public BehaviourParser.IStatement createStatement() {
        return new Statement();
    }

    public BehaviourParser.IImportstatement createImportstatement() {
        return new Importstatement();
    }

    public BehaviourParser.IImports createImports() {
        return new Imports();
    }

    public BehaviourParser.IStateStatement createStateStatement() {
        return new StateStatement();
    }

    public BehaviourParser.IStateConstructor createStateConstructor() {
        return new StateConstructor();
    }

    public BehaviourParser.IParameter createParameter() {
        return new Parameter();
    }

    public BehaviourParser.IParameters createParameters() {
        return new Parameters();
    }

    public BehaviourParser.IAsMethod createAsMethod() {
        return new AsMethod();
    }

    public BehaviourParser.IBehaviourMethod createBehaviourMethod() {
        return new BehaviourMethod();
    }

    public BehaviourParser.IBehaviour createBehaviour() {
        return behaviour = new Behaviour();
    }
}
