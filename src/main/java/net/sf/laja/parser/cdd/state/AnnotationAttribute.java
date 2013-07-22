package net.sf.laja.parser.cdd.state;

public class AnnotationAttribute implements StateParser.IAnnotationAttribute {
    public String name;
    public String value;

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AnnotationAttribute asMutableString() {
        AnnotationAttribute result = new AnnotationAttribute();

        result.setName(name);
        result.setValue(value.replaceAll("MutableState", "StringState"));

        return result;
    }

    @Override
    public String toString() {
        return "AnnotationAttribute{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
