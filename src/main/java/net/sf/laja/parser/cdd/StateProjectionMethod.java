package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.statetemplate.Attribute;
import net.sf.laja.parser.cdd.statetemplate.StateMethod;
import net.sf.laja.parser.cdd.statetemplate.StateTemplate;

import java.util.HashMap;
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

    public StateProjectionMethod(StateTemplate template) {
        classname = template.classname;
        getter = "get" + template.stateClass;
        returnclass = template.stateClass;
        statements = new HashMap<String, String>();
        for (Attribute attribute : template.attributes) {
            statements.put(attribute.variable, attribute.variable);
        }
    }

    public String getStatement(String attribute) {
        return statements.get(attribute);
    }
}
