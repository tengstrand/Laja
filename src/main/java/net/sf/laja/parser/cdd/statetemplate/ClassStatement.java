package net.sf.laja.parser.cdd.statetemplate;

import java.util.ArrayList;
import java.util.List;

public class ClassStatement implements StateTemplateParser.IClassStatement {
    public String classname;
    public IsValid isValid;
    public List<Attribute> attributes = new ArrayList<Attribute>();

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void addAttribute(StateTemplateParser.IAttribute iattribute) {
        attributes.add((Attribute)iattribute);
    }

    public void setIsValid(StateTemplateParser.IIsValid iisvalid) {
        isValid = (IsValid)iisvalid;
    }

    @Override
    public String toString() {
        return "ClassStatement{" +
                "classname='" + classname + '\'' +
                ", isValid=" + isValid +
                ", attributes=" + attributes +
                '}';
    }
}
