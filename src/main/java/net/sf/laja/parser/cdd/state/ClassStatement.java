package net.sf.laja.parser.cdd.state;

import java.util.ArrayList;
import java.util.List;

public class ClassStatement implements StateParser.IClassStatement {
    public String classname;
    public final List<Attribute> attributes = new ArrayList<Attribute>();

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void addAttribute(StateParser.IAttribute iattribute) {
        attributes.add((Attribute)iattribute);
    }

    @Override
    public String toString() {
        return "ClassStatement{" +
                "classname='" + classname + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}