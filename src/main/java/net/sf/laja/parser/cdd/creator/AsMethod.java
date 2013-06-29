package net.sf.laja.parser.cdd.creator;

import org.apache.commons.lang.StringUtils;

public class AsMethod implements CreatorParser.IAsMethod {
    public String spaces;
    public String returnclass;
    public String methodName;
    public Parameters parameters;
    public String body;

    public void setSpaces(String spaces) {
        this.spaces = spaces;
    }

    public void setReturnclass(String returnclass) {
        this.returnclass = returnclass;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getActionName(String action) {
        if (methodName.startsWith("as") && methodName.length() > 2) {
            if (action.isEmpty()) {
                return StringUtils.uncapitalize(methodName.substring(2));
            }
            return action + methodName.substring(2);
        }
        return action + StringUtils.capitalize(methodName);
    }

    public void setParameters(CreatorParser.IParameters iparameters) {
        parameters = (Parameters)iparameters;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getArguments() {
        return parameters.arguments();
    }

    public String getTabbedBody(String tab) {
        String input = body.trim();
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
                ", body='" + body + '\'' +
                '}';
    }
}
