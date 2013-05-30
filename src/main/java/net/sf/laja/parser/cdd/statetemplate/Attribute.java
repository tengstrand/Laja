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
    public String stateClass;
    public String stateMethod;
    public String initialValue;
    public String initialStatement = "";
    public String comment = "";
    public boolean isId;
    public boolean isKey;
    public boolean isInclude;
    public boolean isExclude;
    public boolean isState;
    public boolean isStateObject;
    public boolean isStateSet;
    public boolean isStateList;
    public boolean isHidden;
    public boolean isOptional;
    public boolean isMandatory = true;

    public boolean isValidType() {
        return isPrimitive() || isImmutableType() || isState;
    }

    public boolean isPrimitive() {
        return Type.isPrimitive(type);
    }

    public boolean isImmutableType() {
        return Type.isImmutableType(type);
    }

    public boolean isExplicitAssigned() {
        return initialValue != null;
    }

    public String typeAsStateImpl() {
        if (isState) {
            if (isStateSet) {
                return cleanedStateType + "StateHashSet";
            } else if (isStateList) {
                return cleanedStateType + "StateArrayList";
            } else {
                return cleanedStateType + "StateImpl";
            }
        }
        return type;
    }

    public String getBuilder() {
        return cleanedStateType + "Builder";
    }

    public String getEncapsulator() {
        return cleanedStateType + "Encapsulator";
    }

    public String getSetEncapsulator() {
        return cleanedStateType + "SetEncapsulator";
    }

    public String getListEncapsulator() {
        return cleanedStateType + "ListEncapsulator";
    }

    public String getStateBuilder() {
        if (isStateSet) {
            return cleanedStateType + "StateSetBuilder";
        } else if (isStateList) {
            return cleanedStateType + "StateListBuilder";
        } else {
            return cleanedStateType + "StateBuilder";
        }
    }

    public String getStateBuilderImpl() {
        return getStateBuilder() + (isStateSet || isStateList ? "" : "Impl");
    }

    public String getStateBuilderVariable() {
        if (isStateSet) {
            return variable + "StateSetBuilder";
        } else if (isStateList) {
            return variable + "StateListBuilder";
        } else {
            return variable + "StateBuilder";
        }
    }

    public String getStateBuilderGetter() {
        return "get" + StringUtils.capitalize(getStateBuilderVariable());
    }

    public String getVariableStateGetter() {
        return "get" + variableAsClass + "State";
    }

    public void setType(String type) {
        final String state = "State";
        final String stateSet = "StateSet";
        final String stateList = "StateList";

        this.type = type.trim();
        isStateSet = type.endsWith(stateSet);
        isStateList = type.endsWith(stateList);
        isState = isStateSet || isStateList || type.endsWith(state);
        isStateObject = isState && !isStateSet && !isStateList;

        if (isState) {
            if (isStateSet) {
                cleanedStateType = type.substring(0, type.length() - stateSet.length());
            } else if (isStateList) {
                cleanedStateType = type.substring(0, type.length() - stateList.length());
            } else {
                cleanedStateType = type.substring(0, type.length() - state.length());
            }
        }
        stateClass = cleanedStateType + "State";
        stateMethod = "get" + stateClass;
    }

    public void setVariable(String variable) {
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
        isInclude = comment.contains("(include)");
        isExclude = comment.contains("(exclude)");
        isOptional = comment.contains("(optional)");

        isExclude |= isId;
        isOptional |= isExclude;
        isMandatory = !isOptional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute attribute = (Attribute) o;

        return variable.equals(attribute.variable);
    }

    @Override
    public int hashCode() {
        return variable.hashCode();
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
                ", isInclude=" + isInclude +
                ", isExclude=" + isExclude +
                ", isState=" + isState +
                ", isStateSet=" + isStateSet +
                ", isStateList=" + isStateList +
                ", isHidden=" + isHidden +
                ", isOptional=" + isOptional +
                ", isMandatory=" + isMandatory +
                '}';
    }
}
