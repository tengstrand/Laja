package net.sf.laja.parser.cdd.creator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parameters implements CreatorParser.IParameters, Iterable<Parameter> {
    private List<Parameter> parameters = new ArrayList<Parameter>();

    public void addParameter(CreatorParser.IParameter iparameter) {
        parameters.add((Parameter)iparameter);
    }

    public Iterator<Parameter> iterator() {
        return parameters.iterator();
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "parameters=" + parameters +
                '}';
    }
}
