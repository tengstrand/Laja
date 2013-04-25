package net.sf.laja.parser.cdd.state;

public class Attribute implements StateParser.IAttribute {
    public String type;
    public String variable;
    public String comment = "";

    public void setType(String type) {
        this.type = type;
    }

    public void setVariable(String variable) {
        this.variable = variable;
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
