package net.sf.laja.parser.cdd;

import net.sf.laja.parser.cdd.behaviour.AsMethod;
import net.sf.laja.parser.cdd.behaviour.Behaviour;
import net.sf.laja.parser.cdd.behaviour.Imports;
import net.sf.laja.parser.cdd.behaviour.Parameters;
import net.sf.laja.parser.cdd.behaviour.Statement;
import net.sf.laja.parser.cdd.behaviour.constructor.Importstatement;
import net.sf.laja.parser.cdd.statetemplate.StateTemplate;
import org.apache.commons.lang.Validate;

public class BehaviourCreator {
    private DirectoryConverter directoryConverter = new DirectoryConverter();

    public Behaviour asBehaviour(StateTemplate template) {
        String packagename = asBehaviourPackage(template.rootStatePackage, template.packagename, template.rootBehaviourPackage);

        Behaviour behaviour = new Behaviour();
        behaviour.exists = false;
        behaviour.packagename = packagename;
        behaviour.sourceDir = directoryConverter.asDirectoryPath(template.rootSrcDir, packagename);
        behaviour.outputDir = directoryConverter.asDirectoryPath(template.rootOutDir, packagename);
        behaviour.srcFilename = behaviour.sourceDir + "/" + template.classname + ".java";
        behaviour.setClassname(template.classname);
        behaviour.setStateClass(template.classname + "State");
        behaviour.setParameters(new Parameters());

        AsMethod asMethod = new AsMethod();
        asMethod.setComment("(factory)");
        asMethod.setMethodName("as" + template.classname);
        asMethod.setReturnclass(template.classname);
        Statement statement = new Statement();
        statement.setInnerStatement("return new " + behaviour.classname + "(state);\n    ");
        asMethod.setStatement(statement);
        asMethod.setParameters(new Parameters());
        behaviour.addAsMethod(asMethod);

        Imports imports = new Imports();
        Importstatement importstatement = new Importstatement();
        String fullclassname = template.packagename + "." + template.stateClass;
        importstatement.setFullclassname(fullclassname);
        importstatement.setStatement("import " + fullclassname + ";");
        imports.addImportstatement(importstatement);
        behaviour.setImports(imports);

        return behaviour;
    }

    String asBehaviourPackage(String rootStatePackage, String statePackage, String rootBehaviourPackage) {
        Validate.notEmpty(statePackage, "State package is missing");
        Validate.notEmpty(rootStatePackage, "Root state package is missing");

        if (statePackage.equals(rootStatePackage)) {
            return rootBehaviourPackage;
        }
        if (!statePackage.startsWith(rootStatePackage)) {
            throw new IllegalArgumentException("State package '" + statePackage + "' did not start with '" + rootBehaviourPackage);
        }
        return rootBehaviourPackage + statePackage.substring(rootStatePackage.length());
    }
}
