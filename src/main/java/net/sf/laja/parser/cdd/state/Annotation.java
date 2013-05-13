package net.sf.laja.parser.cdd.state;

import java.util.ArrayList;
import java.util.List;

public class Annotation {
    private final String name;

    private static final List<String> annotations = new ArrayList<String>();

    public static final String ID = "@Id";
    public static final String KEY = "@Key";
    public static final String OPTIONAL = "@Optional";

    static {
        annotations.add(ID);
        annotations.add(KEY);
        annotations.add(OPTIONAL);
    }

    public static boolean isValid(String annotation) {
        return annotation != null && annotations.contains(annotation);
    }

    public Annotation(String name) {
        this.name = name.trim();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Annotation that = (Annotation) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Annotation{" +
                "name='" + name + '\'' +
                '}';
    }
}
