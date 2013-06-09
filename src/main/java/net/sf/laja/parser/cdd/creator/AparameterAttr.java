package net.sf.laja.parser.cdd.creator;

public class AparameterAttr implements CreatorParser.IAparameterAttr{
    public String variable;
    public String value;

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AparameterAttr{" +
                "variable='" + variable + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
