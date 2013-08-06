package net.sf.laja.parser.cdd.state;

import net.sf.laja.parser.cdd.creator.Creator;
import org.apache.commons.lang.StringUtils;

public class Attribute implements StateParser.IAttribute {
    // When adding new attributes, also remember to add them to the methods asMutable() and asImmutable!
    public Type type;
    public String name;
    public String nameAsClass;
    public Annotations annotations;
    public String annotationsContent;
    public State state;

    private AttributeToConstantConverter converter = new AttributeToConstantConverter();

    // Workaround - bug in Laja
    public void setState(State state) {
        this.state = state;
    }

    public State stateObject() {
        return state;
    }

    public Creator getCreator() {
        return state.creator;
    }

    public Attribute asImmutable() {
        Attribute result = new Attribute();
        result.type = type.asImmutable();
        copyTypes(result);

        return result;
    }

    public Attribute asMutable() {
        Attribute result = new Attribute();
        result.type = type.asMutable();
        copyTypes(result);

        return result;
    }

    public Attribute asMap() {
        Attribute result = new Attribute();
        result.type = type.asMap();
        copyTypes(result);

        return result;
    }

    public Attribute asMutableString() {
        Attribute result = new Attribute();
        result.type = type.asMutableString();
        copyTypes(result, true);

        return result;
    }

    private void copyTypes(Attribute attribute) {
        copyTypes(attribute, false);
    }

    private void copyTypes(Attribute attribute, boolean isMutableString) {
        attribute.name = name;
        attribute.nameAsClass = nameAsClass;
        attribute.annotations = isMutableString ? annotations.asMutableString() : annotations;
        attribute.state = state;

        if (annotationsContent.contains("\n")) {
            attribute.annotationsContent = annotationsContent + "    ";
        } else {
            attribute.annotationsContent = annotationsContent;
        }

        if (isMutableString) {
            attribute.annotationsContent = attribute.annotationsContent.replaceAll("MutableState", "StringState");
        }
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

    public String withMethod() {
        return "with" + nameAsClass;
    }

    public String getConstantName() {
        return converter.toConstant(name);
    }

    public String getBuilder() {
        if (state != null && state.creator != null) {
            return state.creator.classname + "." + state.creator.getBuilder();
        }
        String type = this.type.asImmutable().name;
        return state == null ? "[error - could not find state '" + type + "']" : "[error - could not find creator for state '" + type + "']";
    }

    public String getStringBuilder() {
        if (state != null && state.creator != null) {
            return state.creator.classname + "." + state.creator.getStringBuilder();
        }
        String type = this.type.asImmutable().name;
        return state == null ? "[error - could not find state '" + type + "']" : "[error - could not find creator for state '" + type + "']";
    }

    public boolean isValidType() {
        return type.isValid();
    }

    public boolean isObject() {
        return type.isObject();
    }

    public boolean isPrimitive() {
        return type.isPrimitive();
    }

    public boolean isPrimitiveInteger() {
        return type.isPrimitiveInteger();
    }

    public boolean isBoolean() {
        return type.isBoolean();
    }

    public boolean isLong() {
        return type.isLong();
    }

    public boolean isPrimitiveFloatingPoint() {
        return type.isPrimitiveFloatingPoint();
    }

    public boolean isDate() {
        return type.isDate();
    }

    public boolean isState() {
        return type.isState();
    }

    public boolean isList() {
        return type.isList();
    }

    public boolean isSet() {
        return type.isSet();
    }

    public boolean isCollection() {
        return type.isCollection();
    }

    public boolean isMap() {
        return type.isMap();
    }

    public boolean isCollectionOrMap() {
        return isCollection() || isMap();
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

    public boolean isOptionalOrId() {
        return annotations.isOptional() || annotations.isId();
    }

    public boolean isMandatory() {
        return !isOptional() && !isId();
    }

    public Annotation getOptional() {
        return annotations.getOptional();
    }

    public boolean isEntity() {
        return annotations.isEntity();
    }

    public boolean isCollectionOrMapWithState() {
        return type.isCollectionOrMapWithState();
    }

    public boolean isLeafState() {
        return type.isLeafState();
    }

    public String getLeafState() {
        return type.getLeafState();
    }

    public String collectionOrMapType() {
        return type.collectionOrMapType();
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", nameAsClass='" + nameAsClass + '\'' +
                ", annotations=" + annotations +
                ", state=" + (state == null ? null : state.classname) +
                '}';
    }
}
