package net.sf.laja.parser.cdd.creator;

import java.util.ArrayList;
import java.util.List;

public class ParameterClass implements CreatorParser.IParameterClass {
    public String attribute;
    public List<ParameterArgClass> parameterArgClasses = new ArrayList<ParameterArgClass>();

    public boolean isEmpty() {
        return parameterArgClasses.isEmpty();
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void addArgument(CreatorParser.IParameterArgClass iparameterArgClass) {
        ParameterArgClass parameterArgClass = (ParameterArgClass)iparameterArgClass;

        if (parameterArgClass.isAdd) {
            parameterArgClasses.add(parameterArgClass);
        }
    }

    public List<Aparameter> asAParameters() {
        List<Aparameter> result = new ArrayList<Aparameter>();

        for (ParameterArgClass parameterArgClass : parameterArgClasses) {
            result.add(parameterArgClass.asAParameter(attribute));
        }
        return result;
    }

    @Override
    public String toString() {
        return "ParameterClass{" +
                "attribute='" + attribute + '\'' +
                ", parameterArgClasses=" + parameterArgClasses +
                '}';
    }
}
