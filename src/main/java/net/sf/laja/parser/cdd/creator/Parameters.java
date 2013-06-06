package net.sf.laja.parser.cdd.creator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parameters implements CreatorParser.IParameters, Iterable<Parameter> {
    private List<Parameter> parameters = new ArrayList<Parameter>();
    private String stringValue = "";

    public void addParameter(CreatorParser.IParameter iparameter) {
        Parameter parameter = (Parameter)iparameter;

        if (parameters.isEmpty()) {
            stringValue = parameter.toString();
        } else {
            stringValue += ", " + parameter;
        }
        parameters.add(parameter);
    }

    public Iterator<Parameter> iterator() {
        return parameters.iterator();
    }

    public String arguments() {
        String result = "";
        String delimiter = "";
        for (Parameter parameter : parameters) {
            result += delimiter + parameter.variable;
            delimiter = ", ";
        }
        return result;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
