package net.sf.laja.parser.cdd.creator;

public class Parameter implements CreatorParser.IParameter {
    public String type;
    public String variable;

    public void setType(String type) {
        this.type = type;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "type='" + type + '\'' +
                ", variable='" + variable + '\'' +
                '}';
    }
}
