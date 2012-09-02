package net.sf.laja.parser.cdd.behaviour;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parameters implements BehaviourParser.IParameters, Iterable<Parameter> {
    private List<Parameter> parameters = new ArrayList<Parameter>();
    
    public void addParameter(BehaviourParser.IParameter iparameter) {
        parameters.add((Parameter)iparameter);
    }

    public Iterator<Parameter> iterator() {
        return parameters.iterator();
    }

    public int size() {
        return parameters.size();
    }

    @Override
    public String toString() {
        return "Parameters{" + parameters + '}';
    }
}
