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

    public String getArguments() {
        return parameters.arguments();
    }

    public String getTabbedStatement(String tab) {
        String input = statement.trim();
        String[] rows = input.split("\n");
        String result = "";

        if (rows.length >= 2) {
            for (int i=1; i<rows.length-1; i++) {
                result += tab + rows[i] + "\n";
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "AsMethod{" +
                "spaces='" + spaces + '\'' +
                ", returnclass='" + returnclass + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameters=(" + parameters + ")" +
                ", statement='" + statement + '\'' +
                '}';
    }
}
