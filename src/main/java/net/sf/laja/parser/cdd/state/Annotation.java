package net.sf.laja.parser.cdd.state;

import java.util.ArrayList;
import java.util.List;

public class Annotation implements StateParser.IAnnotation{
    public String name;
    public List<AnnotationAttribute> annotationAttributes = new ArrayList<AnnotationAttribute>();

    public static final String ID = "Id";
    public static final String KEY = "Key";
    public static final String OPTIONAL = "Optional";

    private static final List<String> annotations = new ArrayList<String>();

    static {
        annotations.add(ID);
        annotations.add(KEY);
        annotations.add(OPTIONAL);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAnnotationAttribute(StateParser.IAnnotationAttribute iannotationAttribute) {
        AnnotationAttribute annotationAttribute = (AnnotationAttribute)iannotationAttribute;
        String value = annotationAttribute.value;

        if (value.startsWith("\"")) {
            annotationAttribute.value = value.substring(1, value.length() - 1);
        } else if (value.endsWith(".class")) {
            annotationAttribute.value = value.substring(0, value.length() - ".class".length());
        } else {
            annotationAttribute.value = value;
        }
        annotationAttributes.add(annotationAttribute);
    }

    public String getValueFor(String name) {
        for (AnnotationAttribute annotationAttribute : annotationAttributes) {
            if (annotationAttribute.name.equals(name)) {
                return annotationAttribute.value;
            }
        }
        return null;
    }

    public Annotation asMutableString() {
        Annotation result = new Annotation();
        result.setName(name);

        for (AnnotationAttribute attribute : annotationAttributes) {
            result.addAnnotationAttribute(attribute.asMutableString());
        }
        return result;
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
        result = 31 * result + (annotationAttributes != null ? annotationAttributes.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Annotation that = (Annotation) o;

        if (annotationAttributes != null ? !annotationAttributes.equals(that.annotationAttributes) : that.annotationAttributes != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Annotation{" +
                "name='" + name + '\'' +
                ", annotationAttributes=" + annotationAttributes +
                '}';
    }
}
