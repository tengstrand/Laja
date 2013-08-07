package net.sf.laja.parser.cdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Type {
    private static final List<String> primitiveIntegers = Arrays.asList("byte", "char", "short", "int");
    private static final List<String> primitives = Arrays.asList("boolean", "byte", "short", "char", "int", "long", "float", "double");

    // Note, the list of types must match the order of primitives: boolean, byte, short...!
    private static final List<String> immutableTypes = Arrays.asList(
            "Boolean",
            "Byte",
            "Short",
            "Character",
            "Integer",
            "Long",
            "Float",
            "Double",
            "BigInteger",
            "BigDecimal",
            "String",
            "Instant",
            "DateTime",
            "DateMidnight",
            "LocalDate",
            "LocalTime",
            "LocalDateTime",
            "YearMonth",
            "MonthDay",
            "Interval",
            "Duration",
            "Period",
            "Years",
            "Months",
            "Weeks",
            "Days",
            "Hours",
            "Minutes",
            "Seconds"
            );

    private static final List<String> dates = Arrays.asList("LocalDate", "DateMidnight");

    public static boolean isPrimitiveInteger(String type) {
        return primitiveIntegers.contains(type);
    }

    public static boolean isPrimitive(String type) {
        return primitives.contains(type);
    }

    public static boolean isObject(String type) {
        return immutableTypes.contains(type);
    }

    public static boolean isDate(String type) {
        return dates.contains(type);
    }

    public static boolean isValid(String type) {
        return isPrimitive(type) || immutableTypes.contains(type);
    }

    public static String typeAsObject(String type) {
        if (!isPrimitive(type)) {
            return type;
        }
        return immutableTypes.get(primitives.indexOf(type));
    }

    public static String getTypesAsString() {
        String result = "";
        String separator = "";
        List<String> types = new ArrayList<String>(primitives);
        types.addAll(immutableTypes);
        for (String type : types) {
            result += separator + type;
            separator = ", ";
        }
        return result;
    }
}
