package net.sf.laja.parser.cdd.state;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class State implements StateParser.IState {
    public String packagename;
    public String classname;
    public String classvariable;
    public String mutableClass;
    public List<Attribute> attributes;
    public Imports imports;
    public String manualCode;
    public String generatedText;

    public boolean isEntity;

    public List<Attribute> mutableAttributes() {
        List<Attribute> result = new ArrayList<Attribute>();
        for (Attribute attribute : attributes) {
            result.add(attribute.asMutable());
        }
        return result;
    }

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
        mutableClass = StringUtils.left(classname, classname.length() - 5) + "MutableState";
        attributes = classStatement.attributes;
        manualCode = classStatement.manualCode;
        generatedText = classStatement.generatedText;

        for (Attribute attribute : attributes) {
            if (attribute.isEntity()) {
                isEntity = true;
            }
        }
    }

    public boolean hasObjectAttribute() {
        for (Attribute attribute : attributes) {
            if (!attribute.isPrimitive()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "State{" +
                "packagename='" + packagename + '\'' +
                ", classname='" + classname + '\'' +
                ", classvariable='" + classvariable + '\'' +
                ", mutableClass='" + mutableClass + '\'' +
                ", attributes=" + attributes +
                ", imports=" + imports +
                ", manualCode='" + manualCode + '\'' +
                '}';
    }
}
