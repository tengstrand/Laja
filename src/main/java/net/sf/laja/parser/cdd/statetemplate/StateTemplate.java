package net.sf.laja.parser.cdd.statetemplate;

import net.sf.laja.exception.LajaException;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class StateTemplate implements StateTemplateParser.IStateTemplate {
    public String classname;
    public String classvariable;
    public String packagename;
    public Imports imports;
    public Imports allImports;
    public String stateClass;
    public String stateImplClass;
    public String isValidStatement;
    public List<Attribute> attributes;
    public List<StateMethod> stateMethods = new ArrayList<StateMethod>();

    public String rootSrcDir;
    public String rootOutDir;
    public String rootStatePackage;
    public String rootBehaviourPackage;
    public String sourceDir;
    public String outputDir;
    public String templateClassname;
    public Set<ExpandedType> expandedTypes = new LinkedHashSet<ExpandedType>();
    public Set<ExpandedType> allExpandedTypes = new LinkedHashSet<ExpandedType>();
    public StateTemplateErrors errors = new StateTemplateErrors();

    // Workaround a bug in Laja.
    public void setRootSrcDir(String rootSrcDir) {
        this.rootSrcDir = rootSrcDir;
    }

    // Workaround a bug in Laja.
    public void setRootOutDir(String rootOutDir) {
        this.rootOutDir = rootOutDir;
    }

    // Workaround a bug in Laja.
    public void setRootStatePackage(String rootStatePackage) {
        this.rootStatePackage = rootStatePackage;
    }

    // Workaround a bug in Laja.
    public void setRootBehaviourPackage(String rootBehaviourPackage) {
        this.rootBehaviourPackage = rootBehaviourPackage;
    }

    // Workaround a bug in Laja.
    public void setSourceDir(String dir) {
        this.sourceDir = dir;
    }

    // Workaround a bug in Laja.
    public void setOutputDir(String dir) {
        this.outputDir = dir;
    }

    // Workaround a bug in Laja
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public StateTemplate(String templateClassname) {
        this.templateClassname = templateClassname;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public void setImports(StateTemplateParser.IImports iimports) {
        imports = (Imports)iimports;
        allImports = new Imports(imports);
    }

    public void setClassStatement(StateTemplateParser.IClassStatement iclassStatement) {
        ClassStatement classStatement = (ClassStatement)iclassStatement;
        classname = calculateClassName(classStatement.classname);
        classvariable = StringUtils.uncapitalize(classname);
        stateClass = classname + "State";
        stateImplClass = classname + "StateImpl";
        attributes = classStatement.attributes;
        stateMethods = classStatement.stateMethods;
        isValidStatement = classStatement.isValid != null ? classStatement.isValid.getStatement() : null;
    }

    private String calculateClassName(String classname) {
        final String stateTemplate = "StateTemplate";
        final int length = stateTemplate.length();

        if (!classname.endsWith(stateTemplate) || classname.length() == length) {
            throw new LajaException("The class name must end with '" + stateTemplate + "', but was: " + classname);
        }
        return classname.substring(0, classname.length() - length);
    }
    
    public void setClassname(String classname) {
        final String stateTemplate = "StateTemplate";
        final int length = stateTemplate.length();

        if (!classname.endsWith(stateTemplate) || classname.length() == length) {
            throw new LajaException("The class name must end with '" + stateTemplate + "', but was: " + classname);
        }
        this.classname = classname.substring(0, classname.length() - length);
    }

    public void addAttribute(StateTemplateParser.IAttribute iattribute) {
        attributes.add((Attribute)iattribute);
    }

    public void setIsValidStatement(String statement) {
        isValidStatement = statement;
    }

    public boolean isEntity() {
        for (Attribute attribute : attributes) {
            if (attribute.isKey) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateTemplate that = (StateTemplate) o;

        if (classname != null ? !classname.equals(that.classname) : that.classname != null) return false;
        if (packagename != null ? !packagename.equals(that.packagename) : that.packagename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classname != null ? classname.hashCode() : 0;
        result = 31 * result + (packagename != null ? packagename.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StateTemplate{" +
                "classname='" + classname + '\'' +
                ", classvariable='" + classvariable + '\'' +
                ", packagename='" + packagename + '\'' +
                ", imports=" + imports +
                ", stateClass='" + stateClass + '\'' +
                ", stateImplClass='" + stateImplClass + '\'' +
                ", isValidStatement='" + isValidStatement + '\'' +
                ", attributes=" + attributes +
                ", stateMethods=" + stateMethods +
                ", sourceDir='" + sourceDir + '\'' +
                ", outputDir='" + outputDir + '\'' +
                ", templateClassname='" + templateClassname + '\'' +
                ", expandedTypes=" + expandedTypes +
                ", errors=" + errors +
                ", isEntity=" + isEntity() +
                '}';
    }
}
