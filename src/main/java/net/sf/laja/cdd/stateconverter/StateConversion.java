package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.MutableState;
import org.joda.time.DateMidnight;
import org.joda.time.format.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.cdd.stateconverter.StateConverters.*;

public class StateConversion {

    public static ImmutableState asImmutable(MutableState from) { return toImmutable.convert(from, 0); }
    public static MutableState asMutable(ImmutableState from) { return toMutable.convert(from, 0); }

    public static Set asMutableSet(Object from, StateConverter... converters) { return toMutableSet.convert(from, 0, converters); }
    public static ImmutableSet asImmutableSet(Object from, StateConverter... converters) { return toImmutableSet.convert(from, 0, converters); }

    public static List asMutableList(Object from, StateConverter... converters) { return toMutableList.convert(from, 0, converters); }
    public static ImmutableList asImmutableList(Object from, StateConverter... converters) { return toImmutableList.convert(from, 0, converters); }

    public static Map asMutableMap(Object from, StateConverter... converters) { return toMutableMap.convert(from, 0, converters); }
    public static ImmutableMap asImmutableMap(Object from, StateConverter... converters) { return toImmutableMap.convert(from, 0, converters); }

    private static String DATE_MIDNIGHT_FORMAT = "yyyy-MM-dd";

    public static String intAsString(int value) {
        return String.valueOf(value);
    }

    public static String asString(DateMidnight date) {
        return new SimpleDateFormat(DATE_MIDNIGHT_FORMAT).format(date.toDate());
    }

    public static DateMidnight asDateMidnight(String date) {
        return DateTimeFormat.forPattern(DATE_MIDNIGHT_FORMAT).parseDateTime(date).toDateMidnight();
    }


    public static Boolean asBoolean(String value) {
        return value == null || value.trim().isEmpty() ? null : Boolean.valueOf(value);
    }

    public static boolean asBooleanPrimitive(String value) {
        return value == null || value.trim().isEmpty() ? false : Boolean.valueOf(value);
    }

    public static Byte asByte(String value) {
        return value == null || value.trim().isEmpty() ? null : Byte.valueOf(value);
    }

    public static byte asBytePrimitive(String value) {
        return value == null || value.trim().isEmpty() ? 0 : Byte.valueOf(value);
    }

    public static Short asShort(String value) {
        return value == null || value.trim().isEmpty() ? null : Short.valueOf(value);
    }

    public static short asShortPrimitive(String value) {
        return value == null || value.trim().isEmpty() ? 0 : Short.valueOf(value);
    }

    public static Character asCharacter(String value) {
        return value == null || value.trim().isEmpty() ? null : Character.valueOf(value.charAt(0));
    }

    public static char asChar(String value) {
        return value == null || value.trim().isEmpty() ? 0 : Character.valueOf(value.charAt(0));
    }

    public static Integer asInteger(String value) {
        return value == null || value.trim().isEmpty() ? null : Integer.valueOf(value);
    }

    public static int asInt(String value) {
        return value == null || value.trim().isEmpty() ? 0 : Integer.valueOf(value);
    }

    public static Long asLong(String value) {
        return value == null || value.trim().isEmpty() ? null : Long.valueOf(value);
    }

    public static long asLongPrimitive(String value) {
        return value == null || value.trim().isEmpty() ? 0 : Long.valueOf(value);
    }

    public static Float asFloat(String value) {
        return value == null || value.trim().isEmpty() ? null : Float.valueOf(value);
    }

    public static float asFloatPrimitive(String value) {
        return value == null || value.trim().isEmpty() ? 0 : Float.valueOf(value);
    }

    public static Double asDouble(String value) {
        return value == null || value.trim().isEmpty() ? null : Double.valueOf(value);
    }

    public static double asDoublePrimitive(String value) {
        return value == null || value.trim().isEmpty() ? 0 : Double.valueOf(value);
    }
}
