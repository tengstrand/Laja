package net.sf.laja.parser.cdd.creator;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Creator implements CreatorParser.ICreator{
    public boolean isMain;
    public String packagename;
    public String packageStatement;
    public String imports;
    public String maker;
    public String classname;
    public String state;
    public String statevariable;
    public String manualCode;
    public boolean isGeneratedCode;
    public List<AsMethod> asMethods;
    public Aparameters parameters;
    public List<ParameterClass> parameterClasses = new ArrayList<ParameterClass>();

    public String filename;
    public String buildMethod;
    public String createMethod;
    public String entryMethod;

    // Workaround a bug in Laja.
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setIsMainCreator() {
        isMain = true;
    }

    public void addParameterClass(CreatorParser.IParameterClass iparameterClass) {
        ParameterClass parameterClass = (ParameterClass)iparameterClass;
        if (!parameterClass.isEmpty()) {
            parameterClasses.add(parameterClass);
        }
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public void setPackageStatement(CreatorParser.IPackageStatement ipackageStatement) {
        PackageStatement statement = (PackageStatement)ipackageStatement;
        packagename = statement.packagename;
        packageStatement = statement.content;
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

        String name = classname.endsWith("Creator") ? classname.substring(0, classname.length() - "Creator".length()) : classname;
        maker = classname + "Maker";
        buildMethod = "build" + name;
        createMethod = "create" + name;
        entryMethod = StringUtils.uncapitalize(name) + "Entry";
    }

    public Aparameters getNewParameters() {
        Aparameters result = new Aparameters();

        for (ParameterClass parameterClass : parameterClasses) {
            result.addParameters(parameterClass.asAParameters());
        }
        return result;
    }

    public void setManualCode(String manualCode) {
        this.manualCode = manualCode;
    }

    public void setGeneratedCode() {
        isGeneratedCode = true;
    }

    public String getBuilder() {
        return state + "Builder";
    }

    @Override
    public String toString() {
        return "Creator{" +
                "filename='" + filename + '\'' +
                ", packagename='" + packagename + '\'' +
                ", imports='" + imports + '\'' +
                ", classname='" + classname + '\'' +
                ", isMain='" + isMain + '\'' +
                ", isGeneratedCode='" + isGeneratedCode + '\'' +
                ", isclassname='" + classname + '\'' +
                ", parameters='" + parameters + '\'' +
                ", state='" + state + '\'' +
                ", statevariable='" + statevariable + '\'' +
                ", manualCode='" + manualCode + '\'' +
                ", asMethods=" + asMethods +
                ", maker=" + maker +
                ", parameterClasses=" + parameterClasses +
                '}';
    }
}
