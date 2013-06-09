package net.sf.laja.parser.cdd.creator;

import java.util.ArrayList;
import java.util.List;

public class Aparameters implements CreatorParser.IAparameters {
    public String content = "";
    public List<Aparameter> parameters = new ArrayList<Aparameter>();

    public void setContent(String content) {
        this.content = content;
    }

    public void addParameter(CreatorParser.IAparameter iaparameter) {
        parameters.add((Aparameter)iaparameter);
    }

    @Override
    public String toString() {
        return "Aparameters{" +
                "parameters=" + parameters +
                '}';
    }
}
