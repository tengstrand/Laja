package net.sf.laja.parser.cdd.creator;

import java.util.List;

public class Creator implements CreatorParser.ICreator{
    public String packagename;
    public String imports;
    public String classname;
    public String state;
    public String manualCode;
    public List<AsMethod> asMethods;

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
        asMethods = classStatement.asMethods;
    }

    public void setManualCode(String manualCode) {
        this.manualCode = manualCode;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "packagename='" + packagename + '\'' +
                ", imports='" + imports + '\'' +
                ", classname='" + classname + '\'' +
                ", state='" + state + '\'' +
                ", manualCode='" + manualCode + '\'' +
                ", asMethods=" + asMethods +
                '}';
    }
}