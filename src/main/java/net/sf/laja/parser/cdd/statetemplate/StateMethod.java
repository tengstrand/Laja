package net.sf.laja.parser.cdd.statetemplate;

import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class StateMethod implements StateTemplateParser.IStateMethod {
    public String classname;
    public String classVariable;
    public String getter;
    public String returnclass;
    public String variable;
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
        final String suffix = "StateProjection";

        if (!returnclass.endsWith(suffix)) {
            errors.addMessage("State projection method must return a StateProjection class, but was '" + returnclass + "'.");
            return;
        }
        classname = StringUtils.chomp(returnclass, suffix);
        this.returnclass = classname + "State";
        stateBuilderClass = classname + "StateBuilder";
        stateBuilderImplClass = classname + "StateBuilderImpl";
        getter = "get" + this.returnclass;
        variable = StringUtils.uncapitalize(this.returnclass);
        classVariable = StringUtils.uncapitalize(this.returnclass);
    }

    public void setMethodName(String methodname) {
        variable = methodname;
        stateBuilderVariable = variable + "StateBuilder";
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
                ", stateBuilderVariable='" + stateBuilderVariable + '\'' +
                ", stateBuilderClass='" + stateBuilderClass + '\'' +
                ", statements=" + statements +
                ", templateClassname='" + templateClassname + '\'' +
                ", errors=" + errors +
                '}';
    }
}
