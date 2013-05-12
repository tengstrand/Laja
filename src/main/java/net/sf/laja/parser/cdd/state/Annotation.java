package net.sf.laja.parser.cdd.state;

import java.util.ArrayList;
import java.util.List;

public class Annotation {
    private final String name;

    private static final List<String> annotations = new ArrayList<String>();

    static {
        annotations.add("Id");
        annotations.add("Key");
        annotations.add("Optional");
    }

    public static boolean isValid(String annotation) {
        return annotation != null && annotations.contains(annotation);
    }

    public Annotation(String name) {
        this.name = name;
    }

    public boolean isId() {
        return name.equals("Id");
    }

    public boolean isKey() {
        return name.equals("Key");
    }

    public boolean isOptional() {
        return name.equals("Optional");
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
