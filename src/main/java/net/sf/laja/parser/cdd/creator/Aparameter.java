package net.sf.laja.parser.cdd.creator;

public class Aparameter implements CreatorParser.IAparameter {
    public String name;
    public String next = "";
    public String value = "";
    public String method = "";
    public String signature = "";

    public void addParameterAttr(CreatorParser.IAparameterAttr iaparameterAttr) {
        AparameterAttr attr = (AparameterAttr)iaparameterAttr;
        String variable = attr.variable;

        String value = attr.value;
        if (value.endsWith(";")) {
            value = value.substring(0, value.length() - 1).trim();
        }
        if (value.startsWith("\"")) {
            value = value.substring(1, value.length()-1);
        } else if (value.endsWith("_")) {
            value = value.substring(0, value.length() - 1);
        }

        if (variable.equals("name")) {
            name = value;
            if (method.isEmpty()) {
                method = name;
            }
        } else if (variable.equals("next")) {
            next = value;
        } else if (variable.equals("value")) {
            this.value = value;
        } else if (variable.equals("method")) {
            method = value;
        } else if (variable.equals("signature")) {
            signature = value;
        }
    }

    public boolean isLastAttribute() {
        return next.equals("*");
    }

    @Override
    public String toString() {
        return "Aparameter{" +
                "name='" + name + '\'' +
                ", next='" + next + '\'' +
                ", value='" + value + '\'' +
                ", method='" + method + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
