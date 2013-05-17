package net.sf.laja.parser.cdd.state;

import org.apache.commons.lang.StringUtils;

public class Attribute implements StateParser.IAttribute {
    public Type type;
    public String name;
    public String nameAsClass;
    public Annotations annotations;
    public String annotationsContent;

    public Attribute asMutable() {
        Attribute result = new Attribute();
        result.type = type.asMutable();
        result.name = name;
        result.nameAsClass = nameAsClass;
        result.annotations = annotations;

        if (annotationsContent.contains("\n")) {
            result.annotationsContent = annotationsContent + "    ";
        } else {
            result.annotationsContent = annotationsContent;
        }

        return result;
    }

    public void setAnnotations(StateParser.IAnnotations iannotations) {
        annotations = (Annotations)iannotations;
        annotationsContent = annotations.content;
    }

    public void setType(StateParser.IType itype) {
        type = ((Type)itype).asImmutable();
    }

    public void setVariable(String variable) {
        name = variable;
        nameAsClass = StringUtils.capitalize(variable);
    }

    public boolean isPrimitive() {
        return type.isPrimitive();
    }

    public boolean isState() {
        return type.isState();
    }

    public boolean isCollection() {
        return type.isCollection();
    }

    public boolean isMap() {
        return type.isMap();
    }

    public boolean isString() {
        return type.isString();
    }

    public boolean isId() {
        return annotations.isId();
    }

    public boolean isKey() {
        return annotations.isKey();
    }

    public boolean isMandatory() {
        return !isOptional();
    }

    public boolean isOptional() {
        return annotations.isOptional();
    }

    public boolean isEntity() {
        return annotations.isEntity();
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", nameAsClass='" + nameAsClass + '\'' +
                ", annotations=" + annotations +
                '}';
    }
}
