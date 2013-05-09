package net.sf.laja.parser.cdd.state;

import org.apache.commons.lang.StringUtils;

public class Attribute implements StateParser.IAttribute {
    public String type;
    public String variable;
    public String variableAsClass;

    public boolean isList;

    public void setType(String type) {
        this.type = type;

        isList = type.endsWith("List");
    }

    public void setVariable(String variable) {
        this.variable = variable;
        variableAsClass = StringUtils.capitalize(variable);
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "type='" + type + '\'' +
                ", variable='" + variable + '\'' +
                '}';
    }
}
