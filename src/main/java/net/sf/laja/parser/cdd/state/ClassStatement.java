package net.sf.laja.parser.cdd.state;

import java.util.ArrayList;
import java.util.List;

public class ClassStatement implements StateParser.IClassStatement {
    public int version;
    public String classname;
    public final List<Attribute> attributes = new ArrayList<Attribute>();
    public String manualCode;
    public String generatedText;

    public void setVersion(String version) {
        this.version = Integer.parseInt(version);
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void addAttribute(StateParser.IAttribute iattribute) {
        attributes.add((Attribute)iattribute);
    }

    public void setManualCode(String manualCode) {
        this.manualCode = manualCode;
    }

    public void setGeneratedText(String generatedText) {
        this.generatedText = generatedText;
    }

    @Override
    public String toString() {
        return "ClassStatement{" +
                "classname='" + classname + '\'' +
                ", attributes=" + attributes +
                ", manualCode='" + manualCode + '\'' +
                ", generatedText='" + generatedText + '\'' +
                '}';
    }
}
