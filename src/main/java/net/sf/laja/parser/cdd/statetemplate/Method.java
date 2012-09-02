package net.sf.laja.parser.cdd.statetemplate;

import org.apache.commons.lang.StringUtils;

public class Method implements StateTemplateParser.IMethod {
    public String variable;

    public void setVariable(String variable) {
        this.variable = StringUtils.uncapitalize(variable);
    }

    @Override
    public String toString() {
        return "Method{" +
                "variable='" + variable + '\'' +
                '}';
    }
}
