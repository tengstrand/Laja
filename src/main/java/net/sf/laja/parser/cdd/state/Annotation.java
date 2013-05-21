package net.sf.laja.parser.cdd.state;

import java.util.ArrayList;
import java.util.List;

public class Annotation implements StateParser.IAnnotation{
    public String name;
    public String attribute;
    public String value;

    private static final List<String> annotations = new ArrayList<String>();

    public static final String ID = "Id";
    public static final String KEY = "Key";
    public static final String OPTIONAL = "Optional";

    static {
        annotations.add(ID);
        annotations.add(KEY);
        annotations.add(OPTIONAL);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setValue(String value) {
        this.value = value.substring(1, value.length()-1);
    }

    public boolean isValid() {
        return name != null && annotations.contains(name);
    }

    public boolean is(String annotation) {
        return name.equals(annotation);
    }

    public boolean isId() {
        return name.equals(ID);
    }

    public boolean isKey() {
        return name.equals(KEY);
    }

    public boolean isOptional() {
        return name.equals(OPTIONAL);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Annotation that = (Annotation) o;

        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Annotation{" +
                "name='" + name + '\'' +
                ", attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
