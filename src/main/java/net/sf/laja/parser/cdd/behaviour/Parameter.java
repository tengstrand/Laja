package net.sf.laja.parser.cdd.behaviour;

import net.sf.laja.parser.cdd.Type;

public class Parameter implements BehaviourParser.IParameter {
    public String type;
    public String variable;
    
    public void setType(String type) {
        this.type = type;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getTypeAsObject() {
        return Type.typeAsObject(type);
    }

    public boolean isStateBuilder(String classname) {
        return type.equals(classname + "StateBuilder") && variable.equals("stateBuilder");
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "type='" + type + '\'' +
                ", variable='" + variable + '\'' +
                '}';
    }
}
