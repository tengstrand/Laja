package net.sf.laja.parser.cdd;

import java.util.Arrays;
import java.util.List;

public class Type {
    private static final List<String> types = Arrays.asList("byte", "short", "int", "long", "float", "double", "boolean", "char");
    private static final List<String> typesAsObjects = Arrays.asList("Byte", "Short", "Integer", "Long", "Float", "Double", "Boolean", "Character");

    public static boolean isPrimitive(String type) {
        return types.contains(type);
    }

    public static String typeAsObject(String type) {
        if (!isPrimitive(type)) {
            return type;
        }
        return typesAsObjects.get(types.indexOf(type));
    }
}
