package net.sf.laja.parser.cdd.statetemplate;

import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StateMethod implements StateTemplateParser.IStateMethod {
    public String classname;
    public String classVariable;
    public String getter;
    public String returnclass;
    public String variable;
    public String stateBuilderGetter;
    public String stateBuilderVariable;
    public String stateBuilderClass;
    public String stateBuilderImplClass;
    public Map<String,String> statements = new LinkedHashMap<String,String>();

    private String templateClassname;
    private StateTemplateErrors errors;

    public StateMethod(StateTemplate stateTemplate) {
        errors = stateTemplate.errors;
        templateClassname = stateTemplate.templateClassname;
    }

    public void setReturnClass(String returnclass) {
        final String stateSuffix = "State";
        final String stateProjectionSuffix = "StateProjection";

        if (!returnclass.endsWith(stateSuffix) && !returnclass.endsWith(stateProjectionSuffix)) {
            errors.addMessage("State method must return a State or StateProjection class, but was '" + returnclass + "'.");
            return;
        }
        if (returnclass.endsWith(stateSuffix)) {
            classname = StringUtils.chomp(returnclass, stateSuffix);
        } else {
            classname = StringUtils.chomp(returnclass, stateProjectionSuffix);
        }
        this.returnclass = classname + "State";
        stateBuilderClass = classname + "StateBuilder";
        stateBuilderImplClass = classname + "StateBuilderImpl";
        classVariable = StringUtils.uncapitalize(this.returnclass);
    }

    public void setMethodName(String methodname) {
        variable = methodname;
        getter = "get" + StringUtils.capitalize(methodname);
        if (!getter.endsWith("State")) {
            getter += "State";
        }
        stateBuilderGetter = getter + "Builder";
        stateBuilderVariable = variable + "StateBuilder";
    }

    public void addMethod(StateTemplateParser.IMethod imethod, String statement) {
        Method method = (Method)imethod;
        statement = statement.trim();
        int index = statement.indexOf('(');
        statement = statement.substring(index + 1, statement.length() - 1);

        statements.put(method.variable, statement);
    }

    public void initStateMethodProjection(Attribute attribute) {
        setReturnClass(attribute.type);
        setMethodName(attribute.variable);
        statements.put(attribute.variable, attribute.variable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateMethod that = (StateMethod) o;

        if (variable != null ? !variable.equals(that.variable) : that.variable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return variable != null ? variable.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "StateMethod{" +
                "classname='" + classname + '\'' +
                ", classVariable='" + classVariable + '\'' +
                ", returnclass='" + returnclass + '\'' +
                ", variable='" + variable + '\'' +
                ", stateBuilderGetter='" + stateBuilderGetter + '\'' +
                ", stateBuilderVariable='" + stateBuilderVariable + '\'' +
                ", stateBuilderClass='" + stateBuilderClass + '\'' +
                ", statements=" + statements +
                ", templateClassname='" + templateClassname + '\'' +
                ", errors=" + errors +
                '}';
    }
}
