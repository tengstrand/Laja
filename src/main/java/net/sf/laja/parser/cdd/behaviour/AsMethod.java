package net.sf.laja.parser.cdd.behaviour;

import org.apache.commons.lang.StringUtils;

public class AsMethod implements BehaviourParser.IAsMethod {
    public boolean isFactory;
    public boolean generateList;
    public String returnclass;
    public String methodName;
    public String listClass;
    public String abstractListClass;
    public Parameters parameters;
    public String statement;

    public void setComment(String comment) {
        isFactory = comment.contains("(factory)");
        generateList = comment.contains("(list)");
    }

    public void setReturnclass(String returnclass) {
        this.returnclass = returnclass;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
        String methodAsClass = StringUtils.capitalize(methodName.substring(2));
        listClass = methodAsClass + "List";
        abstractListClass = methodAsClass + "AbstractList";
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
                ", generateList=" + generateList +
                ", returnclass='" + returnclass + '\'' +
                ", methodName='" + methodName + '\'' +
                ", listClass='" + listClass + '\'' +
                ", abstractListClass='" + abstractListClass + '\'' +
                ", parameters=" + parameters +
                ", statement='" + statement + '\'' +
                '}';
    }
}
