package net.sf.laja.parser.cdd.state;

public class TypeConverter {

    public String convert(String typeName) {
        if (typeName.endsWith("State")) {
            return typeName.substring(0, typeName.length()-"State".length()) + "MutableState";
        }
        if (typeName.equals("ImmutableSet")) {
            return "Set";
        }
        if (typeName.equals("ImmutableList")) {
            return "List";
        }
        if (typeName.equals("ImmutableMap")) {
            return "Map";
        }

        return typeName;
    }
}
