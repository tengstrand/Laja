package net.sf.laja.parser.cdd.creator;

import java.util.ArrayList;
import java.util.List;

public class ClassStatement implements CreatorParser.IClassStatement {
    public String classname;
    public String state;
    public List<AsMethod> asMethods = new ArrayList<AsMethod>();
    public Aparameters parameters;

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void setStateClass(String stateClass) {
        if (stateClass.endsWith("MutableState")) {
            state = stateClass.substring(0, stateClass.length() - "MutableState".length());
        } else {
            state = "state-class-must-end-with-MutableState:" + stateClass;
        }
    }

    public void addAsMethod(CreatorParser.IAsMethod iasMethod) {
        asMethods.add((AsMethod)iasMethod);
    }

    public void setAParameters(CreatorParser.IAparameters iaparameters) {
        parameters = (Aparameters)iaparameters;
    }

    @Override
    public String toString() {
        return "ClassStatement{" +
                "classname='" + classname + '\'' +
                ", state='" + state + '\'' +
                ", asMethods=" + asMethods +
                ", parameters=" + parameters +
                '}';
    }
}
