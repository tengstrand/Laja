package net.sf.laja.parser.cdd;

import java.util.Arrays;
import java.util.List;

public class Type {
    private static final List<String> primitiveIntegers = Arrays.asList("byte", "char", "short", "int");
    private static final List<String> primitives = Arrays.asList("boolean", "byte", "short", "char", "int", "long", "float", "double");
    private static final List<String> immutableObjects = Arrays.asList("Boolean", "Byte", "Short", "Character", "Integer", "Long", "Float", "Double", "BigInteger", "BigDecimal", "String", "DateTime", "DateMidnight");

    public static boolean isPrimitiveInteger(String type) {
        return primitiveIntegers.contains(type);
    }

    public static boolean isPrimitive(String type) {
        return primitives.contains(type);
    }

    public static boolean isImmutableObject(String type) {
        return immutableObjects.contains(type);
    }

    public static String typeAsObject(String type) {
        if (!isPrimitive(type)) {
            return type;
        }
        return immutableObjects.get(primitives.indexOf(type));
    }
}
