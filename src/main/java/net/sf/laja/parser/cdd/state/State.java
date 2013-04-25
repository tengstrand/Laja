package net.sf.laja.parser.cdd.state;

import org.apache.commons.lang.StringUtils;

import java.util.List;

public class State implements StateParser.IState {
    public String packagename;
    public String classname;
    public String classvariable;
    public List<Attribute> attributes;
    public Imports imports;

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public void setImports(StateParser.IImports iimports) {
        imports = (Imports)iimports;
    }

    public void setClassStatement(StateParser.IClassStatement iclassStatement) {
        ClassStatement classStatement = (ClassStatement)iclassStatement;
        classname = classStatement.classname;
        classvariable = StringUtils.uncapitalize(classname);
        attributes = classStatement.attributes;
    }

    @Override
    public String toString() {
        return "State{" +
                "packagename='" + packagename + '\'' +
                ", classname='" + classname + '\'' +
                ", classvariable='" + classvariable + '\'' +
                ", attributes=" + attributes +
                ", imports=" + imports +
                '}';
    }
}