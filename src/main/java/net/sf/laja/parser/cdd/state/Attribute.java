package net.sf.laja.parser.cdd.state;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Attribute implements StateParser.IAttribute {
    public Type type;
    public String typeContent;
    public String variable;
    public String variableAsClass;
    public String allAnnotations;
    public List<String> annotations = new ArrayList<String>();

    public void setAnnotations(String annotations) {
        allAnnotations = annotations;
    }

    public void addAnnotation(String annotation) {
        annotations.add(annotation);
    }

    public void setType(StateParser.IType itype) {
        type = (Type)itype;
    }

    public void setVariable(String variable) {
        this.variable = variable;
        variableAsClass = StringUtils.capitalize(variable);
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "type='" + type + '\'' +
                ", typeContent='" + typeContent + '\'' +
                ", variable='" + variable + '\'' +
                ", variableAsClass='" + variableAsClass + '\'' +
                ", allAnnotations=" + allAnnotations +
                ", annotations=" + annotations +
                '}';
    }
}
