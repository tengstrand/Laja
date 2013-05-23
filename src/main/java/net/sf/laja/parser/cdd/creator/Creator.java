package net.sf.laja.parser.cdd.creator;

import java.util.List;

public class Creator implements CreatorParser.ICreator{
    public String imports;
    public String classname;
    public List<AsMethod> asMethods;

    public void setImports(String imports) {
        this.imports = imports;
    }

    public void setClassStatement(CreatorParser.IClassStatement iclassStatement) {
        ClassStatement classStatement = (ClassStatement)iclassStatement;
        classname = classStatement.classname;
        asMethods = classStatement.asMethods;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "imports='" + imports + '\'' +
                ", classname='" + classname + '\'' +
                ", asMethods=" + asMethods +
                '}';
    }
}
