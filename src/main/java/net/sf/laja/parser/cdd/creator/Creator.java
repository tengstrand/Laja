package net.sf.laja.parser.cdd.creator;

import org.apache.commons.lang.StringUtils;

import java.util.List;

public class Creator implements CreatorParser.ICreator{
    public String packagename;
    public String imports;
    public String maker;
    public String classname;
    public String state;
    public String statevariable;
    public String manualCode;
    public List<AsMethod> asMethods;
    public Aparameters parameters;

    public String filename;

    // Workaround a bug in Laja.
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public void setImports(String imports) {
        this.imports = imports;
    }

    public void setClassStatement(CreatorParser.IClassStatement iclassStatement) {
        ClassStatement classStatement = (ClassStatement)iclassStatement;
        classname = classStatement.classname;
        state = classStatement.state;
        statevariable = StringUtils.uncapitalize(state);
        asMethods = classStatement.asMethods;
        parameters = classStatement.parameters;

        if (classname.endsWith("Creator")) {
            maker = classname.substring(0, classname.length() - "Creator".length()) + "Maker";
        } else {
            maker = classname + "Maker";
        }
    }

    public void setManualCode(String manualCode) {
        this.manualCode = manualCode;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "filename='" + filename + '\'' +
                ", packagename='" + packagename + '\'' +
                ", imports='" + imports + '\'' +
                ", classname='" + classname + '\'' +
                ", state='" + state + '\'' +
                ", statevariable='" + statevariable + '\'' +
                ", manualCode='" + manualCode + '\'' +
                ", asMethods=" + asMethods +
                '}';
    }
}
