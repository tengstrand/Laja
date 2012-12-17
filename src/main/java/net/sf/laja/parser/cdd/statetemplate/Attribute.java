package net.sf.laja.parser.cdd.statetemplate;

import net.sf.laja.parser.cdd.Type;
import org.apache.commons.lang.StringUtils;

public class Attribute implements StateTemplateParser.IAttribute {
    public String type;
    public String cleanedStateType;
    public String variable;
    public String variableAsClass;
    public String getter;
    public String setter;
    public String withMethod;
    public String stateMethod;
    public String initialValue;
    public String initialStatement = "";
    public String comment = "";
    public boolean isId;
    public boolean isKey;
    public boolean isExpand;
    public boolean isExclude;
    public boolean isState;
    public boolean isStateList;
    public boolean isHidden;
    public boolean isOptional;
    public boolean isMandatory = true;

    public boolean isValidType() {
        return isPrimitive() || isImmutableObject() || isState;
    }

    public boolean isPrimitive() {
        return Type.isPrimitive(type);
    }

    public boolean isImmutableObject() {
        return Type.isImmutableObject(type);
    }

    public boolean isObject() {
        return !isPrimitive() && !isState;
    }

    public boolean isBuilderMethod() {
        return !isHidden;
    }

    public boolean isExplicitAssigned() {
        return initialValue != null;
    }

    public String typeAsStateImpl() {
        if (isState) {
            return cleanedStateType + (isStateList ? "StateListImpl" : "StateImpl");
        }
        return type;
    }

    public String getBuilder() {
        return cleanedStateType + "Builder";
    }

    public String getEncapsulator() {
        return cleanedStateType + "Encapsulator";
    }

    public String getListEncapsulator() {
        return cleanedStateType + "ListEncapsulator";
    }

    public String getStateBuilder() {
        return isStateList ? cleanedStateType + "StateListBuilder" : cleanedStateType + "StateBuilder";
    }

    public String getStateBuilderImpl() {
        return getStateBuilder() + (isStateList ? "" : "Impl");
    }

    public String getStateBuilderVariable() {
        return variable + (isStateList ? "StateListBuilder" : "StateBuilder");
    }

    public String getStateBuilderGetter() {
        return "get" + StringUtils.capitalize(getStateBuilderVariable());
    }

    public void setType(String type) {
        final String state = "State";
        final String stateList = "StateList";

        this.type = type.trim();
        isStateList = type.endsWith(stateList);
        isState = isStateList || type.endsWith(state);
        if (isState) {
            if (isStateList) {
                cleanedStateType = type.substring(0, type.length() - stateList.length());
            } else {
                cleanedStateType = type.substring(0, type.length() - state.length());
            }
        }
        stateMethod = "get" + cleanedStateType + "State";
    }

    public void setVariable(String variable) {
        if (variable.startsWith("$")) {
            isExpand = true;
        }
        String variableClass = StringUtils.capitalize(variable);
        this.variable = variable;
        this.variableAsClass = variableClass;
        this.getter = "get" + variableClass;
        this.setter = "set" + variableClass;
        this.withMethod = "with" + variableClass;
    }

    public void setInitialValue(String value) {
        initialStatement = " = " + value.trim();
    }

    public void setComment(String comment) {
        this.comment = comment;
        isId = comment.contains("(id)");
        isKey = comment.contains("(key)");
        isHidden = comment.contains("(hide)");
        isExclude = comment.contains("(exclude)") || isId;
        isOptional = isExclude || comment.contains("(optional)");
        isMandatory = !isOptional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute attribute = (Attribute) o;

        if (type != null ? !type.equals(attribute.type) : attribute.type != null) return false;
        if (variable != null ? !variable.equals(attribute.variable) : attribute.variable != null) return false;

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
        return "Attribute{" +
                "type='" + type + '\'' +
                ", cleanedStateType='" + cleanedStateType + '\'' +
                ", variable='" + variable + '\'' +
                ", variableAsClass='" + variableAsClass + '\'' +
                ", getter='" + getter + '\'' +
                ", setter='" + setter + '\'' +
                ", withMethod='" + withMethod + '\'' +
                ", stateMethod='" + stateMethod + '\'' +
                ", initialValue='" + initialValue + '\'' +
                ", initialStatement='" + initialStatement + '\'' +
                ", comment='" + comment + '\'' +
                ", isExpand=" + isExpand +
                ", isExclude=" + isExclude +
                ", isState=" + isState +
                ", isStateList=" + isStateList +
                ", isHidden=" + isHidden +
                ", isOptional=" + isOptional +
                ", isMandatory=" + isMandatory +
                '}';
    }
}
