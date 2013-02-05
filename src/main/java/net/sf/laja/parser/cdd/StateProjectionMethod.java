package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.statetemplate.StateMethod;

import java.util.Map;

public class StateProjectionMethod {
    public String classname;
    public String getter;
    public String returnclass;

    private Map<String,String> statements;

    public StateProjectionMethod(StateMethod method) {
        this.classname = method.classname;
        this.getter = method.getter;
        this.returnclass = method.returnclass;
        this.statements = method.statements;
    }

    public String getStatement(String attribute) {
        return statements.get(attribute);
    }
}
