package net.sf.laja.parser.cdd.behaviour;

import org.apache.commons.lang.StringUtils;

public class AsMethod implements BehaviourParser.IAsMethod {
    public boolean isFactory;
    public String returnclass;
    public String methodName;
    public String listInterface;
    public String arrayListClass;
    public Parameters parameters;
    public String statement;

    public void setComment(String comment) {
        isFactory = comment.contains("(factory)");
    }

    public void setReturnclass(String returnclass) {
        this.returnclass = returnclass;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
        String methodAsClass = StringUtils.capitalize(methodName.substring(2));
        listInterface = methodAsClass + "List";
        arrayListClass = methodAsClass + "ArrayList";
    }

    public void setParameters(BehaviourParser.IParameters iparameters) {
        this.parameters = (Parameters)iparameters;
    }

    public void setStatement(BehaviourParser.IStatement istatement) {
        this.statement = ((Statement)istatement).innerStatement;
    }

    @Override
    public String toString() {
        return "AsMethod{" +
                "isFactory=" + isFactory +
                ", returnclass='" + returnclass + '\'' +
                ", methodName='" + methodName + '\'' +
                ", listInterface='" + listInterface + '\'' +
                ", arrayListClass='" + arrayListClass + '\'' +
                ", parameters=" + parameters +
                ", statement='" + statement + '\'' +
                '}';
    }
}
