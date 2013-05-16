package net.sf.laja.parser.cdd.state;

public class TypeConverter {

    public String asMutable(String typeName) {
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

    public String asImmutable(String typeName) {
        if (typeName.endsWith("MutableState")) {
            return typeName.substring(0, typeName.length()-"MutableState".length()) + "State";
        }
        if (typeName.equals("Set")) {
            return "ImmutableSet";
        }
        if (typeName.equals("List")) {
            return "ImmutableList";
        }
        if (typeName.equals("Map")) {
            return "ImmutableMap";
        }

        return typeName;
    }
}
