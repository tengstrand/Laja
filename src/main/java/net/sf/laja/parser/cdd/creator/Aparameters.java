package net.sf.laja.parser.cdd.creator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aparameters implements CreatorParser.IAparameters, Iterable<Aparameter> {
    public String content = "";
    public List<Aparameter> parameters = new ArrayList<Aparameter>();

    public boolean isEmpty() {
        return parameters.isEmpty();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addParameter(CreatorParser.IAparameter iaparameter) {
        parameters.add((Aparameter)iaparameter);
    }

    public void addParameters(List<Aparameter> parameters) {
        this.parameters.addAll(parameters);
    }

    public Iterator<Aparameter> iterator() {
        return parameters.iterator();
    }

    @Override
    public String toString() {
        return "Aparameters{" +
                "parameters=" + parameters +
                '}';
    }
}
