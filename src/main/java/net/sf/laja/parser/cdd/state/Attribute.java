package net.sf.laja.parser.cdd.state;

import org.apache.commons.lang.StringUtils;

public class Attribute implements StateParser.IAttribute {
    public String type;
    public String variable;
    public String variableAsClass;
    public String comment = "";

    public void setType(String type) {
        this.type = type;
    }

    public void setVariable(String variable) {
        this.variable = variable;
        this.variableAsClass = StringUtils.capitalize(variable);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "type='" + type + '\'' +
                ", variable='" + variable + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
