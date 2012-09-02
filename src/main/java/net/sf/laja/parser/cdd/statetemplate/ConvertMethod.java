package net.sf.laja.parser.cdd.statetemplate;

public class ConvertMethod implements StateTemplateParser.IConvertMethod {
    public String type;
    public String variable;
    public String statement;

    public void setType(String type) {
        this.type = type;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConvertMethod that = (ConvertMethod) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (variable != null ? !variable.equals(that.variable) : that.variable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (variable != null ? variable.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ConvertMethod{" +
                "type='" + type + '\'' +
                ", variable='" + variable + '\'' +
                ", statement='" + statement + '\'' +
                '}';
    }
}
