package net.sf.laja.parser.cdd.statetemplate;

public class ExpandedType {
    public final String variable;
    public final String type;
    public final String importStatement;

    public ExpandedType(String variable, String type, String importStatement) {
        this.variable = variable;
        this.type = type;
        this.importStatement = importStatement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpandedType that = (ExpandedType) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ExpandedType{" +
                "variable='" + variable + '\'' +
                ", type='" + type + '\'' +
                ", importStatement='" + importStatement + '\'' +
                '}';
    }
}
