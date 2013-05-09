package net.sf.laja.parser.cdd.state;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Attribute implements StateParser.IAttribute {
    public String type;
    public String variable;
    public String variableAsClass;
    public String allAnnotations;
    public List<String> annotations = new ArrayList<String>();

    public boolean isList;

    public void setAnnotations(String annotations) {
        allAnnotations = annotations;
    }

    public void addAnnotation(String annotation) {
        annotations.add(annotation);
    }

    public void setType(String type) {
        this.type = type;

        isList = type.endsWith("List");
    }

    public void setVariable(String variable) {
        this.variable = variable;
        variableAsClass = StringUtils.capitalize(variable);
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "type='" + type + '\'' +
                ", variable='" + variable + '\'' +
                ", variableAsClass='" + variableAsClass + '\'' +
                ", allAnnotations=" + allAnnotations +
                ", annotations=" + annotations +
                ", isList=" + isList +
                '}';
    }
}
