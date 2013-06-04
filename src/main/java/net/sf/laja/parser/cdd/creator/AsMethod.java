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

    public String getTabbedStatement(String tab) {
        String input = statement.trim();
        if (input.startsWith("{")) {
            input = input.substring(1).trim();
        }
        if (input.endsWith("}")) {
            input = input.substring(0, input.length()-1).trim();
        }
        String[] rows = input.split("\n");
        String result = "";

        for (String row : rows) {
            result += tab + row.trim() + "\n";
        }
        return result;
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
