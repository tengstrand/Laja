package net.sf.laja.parser.cdd.creator;

public class AsMethod implements CreatorParser.IAsMethod {
    public String spaces;
    public String returnclass;
    public String methodName;
    public Parameters parameters;
    public String statement;

    public void setSpaces(String spaces) {
        this.spaces = spaces;
    }

    public void setReturnclass(String returnclass) {
        this.returnclass = returnclass;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setParameters(CreatorParser.IParameters iparameters) {
        parameters = (Parameters)iparameters;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    @Override
    public String toString() {
        return "AsMethod{" +
                "spaces='" + spaces + '\'' +
                ", returnclass='" + returnclass + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameters=" + parameters +
                ", statement='" + statement + '\'' +
                '}';
    }
}
