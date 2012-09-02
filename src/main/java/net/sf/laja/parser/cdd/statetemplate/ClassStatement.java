package net.sf.laja.parser.cdd.statetemplate;

import java.util.ArrayList;
import java.util.List;

public class ClassStatement implements StateTemplateParser.IClassStatement {
    public String classname;
    public IsValid isValid;
    public List<Attribute> attributes = new ArrayList<Attribute>();
    public List<StateMethod> stateMethods = new ArrayList<StateMethod>();
    public List<ConvertMethod> convertMethods = new ArrayList<ConvertMethod>();

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void addAttribute(StateTemplateParser.IAttribute iattribute) {
        attributes.add((Attribute)iattribute);
    }

    public void setIsValid(StateTemplateParser.IIsValid iisvalid) {
        isValid = (IsValid)iisvalid;
    }

    public void addStateMethod(StateTemplateParser.IStateMethod iStateMethod) {
        stateMethods.add((StateMethod) iStateMethod);
    }

    public void addConvertMethod(StateTemplateParser.IConvertMethod iconvertMethod) {
        convertMethods.add((ConvertMethod)iconvertMethod);
    }

    @Override
    public String toString() {
        return "ClassStatement{" +
                "classname='" + classname + '\'' +
                ", isValid=" + isValid +
                ", attributes=" + attributes +
                ", stateMethods=" + stateMethods +
                ", convertMethods=" + convertMethods +
                '}';
    }
}
