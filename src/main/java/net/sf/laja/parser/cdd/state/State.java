package net.sf.laja.parser.cdd.state;

import net.sf.laja.parser.cdd.creator.Creator;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class State implements StateParser.IState {
    public String packagename;
    public String packageContent;
    public int version;
    public String name;
    public String classname;
    public String classvariable;
    public String validator;
    public String mapClass;
    public String mutableClass;
    public String stringClass;
    public List<Attribute> attributes;
    public Imports imports;
    public String manualCode;
    public String generatedEnd;

    public boolean isEntity;
    public String filename;
    public Creator creator;

    // Workaround a bug in Laja.
    public void setFilename(String filename) {
        this.filename = filename;
    }

    // Workaround a bug in Laja.
    public void setCreator(Creator creator) {
        if (this.creator == null) {
            this.creator = creator;
        } else if (creator.isMain && !this.creator.isMain) {
            this.creator = creator;
        }
    }

    public List<Attribute> mutableAttributes() {
        List<Attribute> result = new ArrayList<Attribute>();
        for (Attribute attribute : attributes) {
            result.add(attribute.asMutable());
        }
        return result;
    }

    public List<Attribute> mutableStringAttributes() {
        List<Attribute> result = new ArrayList<Attribute>();
        for (Attribute attribute : attributes) {
            result.add(attribute.asMutableString());
        }
        return result;
    }

    public void setPackageName(String packagename) {
        this.packagename = packagename;
    }

    public void setPackageContent(String packageContent) {
        this.packageContent = packageContent;
    }

    public void setImports(StateParser.IImports iimports) {
        imports = (Imports)iimports;
    }

    public void setClassStatement(StateParser.IClassStatement iclassStatement) {
        ClassStatement classStatement = (ClassStatement)iclassStatement;
        version = classStatement.version;
        classname = classStatement.classname;
        classvariable = StringUtils.uncapitalize(classname);
        name = StringUtils.left(classname, classname.length() - "State".length());
        validator = name + "Validator";
        mapClass = name + "MapState";
        mutableClass = name + "MutableState";
        stringClass = name + "StringState";
        attributes = classStatement.attributes;
        manualCode = classStatement.manualCode;
        generatedEnd = classStatement.generatedEnd;

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

    public boolean hasMandatoryObjectAttribute() {
        for (Attribute attribute : attributes) {
            if (attribute.isMandatory() && !attribute.isPrimitive()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "State{" +
                "filename='" + filename + '\'' +
                ", packagename='" + packagename + '\'' +
                ", packageContent='" + packageContent + '\'' +
                ", name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                ", classvariable='" + classvariable + '\'' +
                ", mutableClass='" + mutableClass + '\'' +
                ", attributes=" + attributes +
                ", imports=" + imports +
                ", manualCode='" + manualCode + '\'' +
                ", creator=" + (creator == null ? null : '\'' + creator.classname + '\'') +
                '}';
    }
}
