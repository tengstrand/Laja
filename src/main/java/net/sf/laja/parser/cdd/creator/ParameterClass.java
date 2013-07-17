package net.sf.laja.parser.cdd.creator;

import java.util.ArrayList;
import java.util.List;

public class ParameterClass implements CreatorParser.IParameterClass {
    public String attribute;
    public List<ParameterArgClass> parameterArgClasses = new ArrayList<ParameterArgClass>();

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void addArgument(CreatorParser.IParameterArgClass iparameterArgClass) {
        parameterArgClasses.add((ParameterArgClass)iparameterArgClass);
    }

    @Override
    public String toString() {
        return "ParameterClass{" +
                "attribute='" + attribute + '\'' +
                ", parameterArgClasses=" + parameterArgClasses +
                '}';
    }
}
