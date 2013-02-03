package net.sf.laja.parser.cdd.behaviour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Behaviour implements BehaviourParser.IBehaviour {
    public boolean exists = true;
    public String packagename;
    public Imports imports;
    public boolean isValue;
    public List<AsMethod> asMethods = new ArrayList<AsMethod>();
    public String srcDir;
    public String sourceDir;
    public String outDir;
    public String outputDir;
    public String srcFilename;
    public String classname;
    public String interfacename;
    public String builderClass;
    public String creatorClass;
    public String factoryClass;
    public String stateClass;
    public String stateImplClass;
    public String stateComparable;
    public String cleanedStateClass;
    public String method;
    public Parameters parameters;

    public void setPackageStatement(String statement) {
        this.packagename = statement;
    }

    public void setImports(BehaviourParser.IImports iimports) {
        imports = (Imports)iimports;
    }

    public void setExtendsClass(String extendsClass) {
        isValue = extendsClass.endsWith("Value") || extendsClass.endsWith("ValueFactory");
    }

    public void setStateClass(String stateClass) {
        final String state = "State";
        if (stateClass != null && stateClass.endsWith(state)) {
            this.cleanedStateClass = stateClass.substring(0, stateClass.length() - state.length());
            this.stateClass = stateClass;
            this.stateImplClass = stateClass + "Impl";
            this.stateComparable = stateClass + "Comparable";
        }
    }

    public void setParameters(BehaviourParser.IParameters iparameters) {
        parameters = (Parameters)iparameters;
    }

    // TODO: remove this setter when the bug in Laja is solved.
    public void setSrcDir(String srcDir) {
        this.srcDir = srcDir;
    }

    // TODO: remove this setter when the bug in Laja is solved.
    public void setSourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    // TODO: remove this setter when the bug in Laja is solved.
    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }

    // TODO: remove this setter when the bug in Laja is solved.
    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    // TODO: remove this setter when the bug in Laja is solved.
    public void setSrcFilename(String srcFilename) {
        this.srcFilename = srcFilename;
    }

    public void setClassname(String classname) {
        final String[] CLASS_SUFFIX = new String[] { "Template", "Entity", "Value" };

        for (String suffix : CLASS_SUFFIX) {
            if (classname.endsWith(suffix)) {
                classname = classname.substring(0, classname.length() - suffix.length());
                break;
            }
        }
        this.classname = classname;

        if (classname.endsWith("Impl")) {
            classname = classname.substring(0, classname.length() - 4);
            interfacename = classname;
        }

        builderClass = classname + "Builder";
        creatorClass = classname + "Creator";
        factoryClass = classname + "Factory";
    }

    /**
     * Update the name of the factory class if the returning type of the
     * first as-method is not a behaviour class (assumes it is an interface).
     *
     * @param behaviourClasses
     */
    public void updateFactoryClassIfNeeded(Collection<String> behaviourClasses) {
        if (!behaviourClasses.contains(classname)) {
            for (AsMethod method : asMethods) {
                if (method.isFactory) {
                    factoryClass = method.returnclass + "Factory";
                    break;
                }
            }
        }
    }

    public void addMethod(BehaviourParser.IBehaviourMethod imethod) {
        BehaviourMethod behaviourMethod = (BehaviourMethod)imethod;
        asMethods.add(behaviourMethod.asMethod);
    }

    public boolean isFactory() {
        for (AsMethod method : asMethods) {
            if (method.isFactory) {
                return true;
            }
        }
        return false;
    }

    public boolean isStateBuilderConstructor() {
        for (Parameter parameter : parameters) {
            if (parameter.isStateBuilder(classname)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Behaviour{" +
                "exists=" + exists +
                ", packagename='" + packagename + '\'' +
                ", imports=" + imports +
                ", asMethods=" + asMethods +
                ", sourceDir='" + sourceDir + '\'' +
                ", outputDir='" + outputDir + '\'' +
                ", srcFilename='" + srcFilename + '\'' +
                ", classname='" + classname + '\'' +
                ", builderClass='" + builderClass + '\'' +
                ", creatorClass='" + creatorClass + '\'' +
                ", factoryClass='" + factoryClass + '\'' +
                ", stateClass='" + stateClass + '\'' +
                ", stateImplClass='" + stateImplClass + '\'' +
                ", cleanedStateClass='" + cleanedStateClass + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
