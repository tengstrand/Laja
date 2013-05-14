package net.sf.laja.parser.cdd.state;

import org.apache.commons.lang.StringUtils;

public class Attribute implements StateParser.IAttribute {
    public Type type;
    public String typeContent;
    public String name;
    public String nameAsClass;
    public Annotations annotations;

    public void setAnnotations(StateParser.IAnnotations iannotations) {
        annotations = (Annotations)iannotations;
    }

    public void setType(StateParser.IType itype) {
        type = (Type)itype;
    }

    public void setVariable(String variable) {
        name = variable;
        nameAsClass = StringUtils.capitalize(variable);
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public String getAnnotationsContent() {
        return annotations.content;
    }

    public boolean isPrimitive() {
        return type.isPrimitive();
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
                ", typeContent='" + typeContent + '\'' +
                ", name='" + name + '\'' +
                ", nameAsClass='" + nameAsClass + '\'' +
                ", annotations=" + annotations +
                '}';
    }
}
