package net.sf.laja.parser.cdd.creator;

import java.util.ArrayList;
import java.util.List;

public class ClassStatement implements CreatorParser.IClassStatement {
    public String classname;
    public List<AsMethod> asMethods = new ArrayList<AsMethod>();

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void addAsMethod(CreatorParser.IAsMethod iasMethod) {
        asMethods.add((AsMethod)iasMethod);
    }

    @Override
    public String toString() {
        return "ClassStatement{" +
                "classname='" + classname + '\'' +
                ", asMethods=" + asMethods +
                '}';
    }
}
