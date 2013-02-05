package net.sf.laja.parser.cdd.statetemplate;

import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class StateMethod implements StateTemplateParser.IStateMethod {
    public String classname;
    public String getter;
    public String classVariable;
    public String returnclass;
    public String variable;
    public String methodName;
    public String getMethod;
    public String parameters;
    public String implclass;
    public String stateBuilderVariable;
    public String stateBuilderClass;
    public String stateBuilderImplClass;
    public Map<String,String> statements = new LinkedHashMap<String,String>();

    private String templateClassname;
    private String params;
    private StateTemplateErrors errors;

    private static final String suffix = "StateProjection";

    public StateMethod(StateTemplate stateTemplate) {
        errors = stateTemplate.errors;
        templateClassname = stateTemplate.templateClassname;
    }

    public void setReturnclass(String returnclass) {
        if (!returnclass.endsWith(suffix)) {
            this.returnclass = returnclass;
            params = parameters != null ? parameters : "";
            return;
        }
        classname = returnclass.substring(0, returnclass.length() - suffix.length());
        this.returnclass = classname + "State";
        stateBuilderClass = classname + "StateBuilder";
        stateBuilderImplClass = classname + "StateBuilderImpl";
        getter = "get" + this.returnclass;
        classVariable = StringUtils.uncapitalize(this.returnclass);
    }

    public void setUname(String uname) {
        methodName = "state" + uname;
        getMethod = "get" + uname + "State";
        variable = StringUtils.uncapitalize(uname);
        stateBuilderVariable = variable + "StateBuilder";
        if (params != null) {
            errors.addMessage("The method " + methodName + "(" + params + ") in class " + templateClassname + " must return a " + suffix + " class, but returned '" + returnclass + "'.");
        }
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public void setImplClass(String implclass) {
        this.implclass = implclass;
    }

    public void addMethod(StateTemplateParser.IMethod imethod, String statement) {
        Method method = (Method)imethod;
        statement = statement.trim();
        int index = statement.indexOf('(');
        statement = statement.substring(index + 1, statement.length() - 1);

        statements.put(method.variable, statement);
    }

    @Override
    public String toString() {
        return "StateMethod{" +
                "classname='" + classname + '\'' +
                ", classVariable='" + classVariable + '\'' +
                ", returnclass='" + returnclass + '\'' +
                ", variable='" + variable + '\'' +
                ", methodName='" + methodName + '\'' +
                ", getMethod='" + getMethod + '\'' +
                ", parameters='" + parameters + '\'' +
                ", implclass='" + implclass + '\'' +
                ", stateBuilderVariable='" + stateBuilderVariable + '\'' +
                ", stateBuilderClass='" + stateBuilderClass + '\'' +
                ", statements=" + statements +
                ", templateClassname='" + templateClassname + '\'' +
                ", params='" + params + '\'' +
                ", errors=" + errors +
                '}';
    }
}
