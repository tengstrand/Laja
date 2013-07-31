package net.sf.laja.cdd.state.converter;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.MutableState;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StateConverters {
    public static ToMutableConverter toMutable = new ToMutableConverter();
    public static ToMutableStringConverter toMutableString = new ToMutableStringConverter();
    public static ToMutableListConverter toMutableList = new ToMutableListConverter();
    public static ToMutableMapConverter toMutableMap = new ToMutableMapConverter();
    public static ToMutableSetConverter toMutableSet = new ToMutableSetConverter();
    public static MutableToImmutableConverter toImmutable = new MutableToImmutableConverter();
    public static MutableToImmutableListConverter toImmutableList = new MutableToImmutableListConverter();
    public static MutableToImmutableMapConverter toImmutableMap = new MutableToImmutableMapConverter();
    public static MutableToImmutableSetConverter toImmutableSet = new MutableToImmutableSetConverter();

    public static StringToBooleanPrimitiveConverter toBooleanPrimitive = new StringToBooleanPrimitiveConverter();
    public static StringToBytePrimitiveConverter toBytePrimitive = new StringToBytePrimitiveConverter();
    public static StringToShortPrimitiveConverter toShortPrimitive = new StringToShortPrimitiveConverter();
    public static StringToLongPrimitiveConverter toLongPrimitive = new StringToLongPrimitiveConverter();
    public static StringToFloatPrimitiveConverter toFloatPrimitive = new StringToFloatPrimitiveConverter();
    public static StringToDoublePrimitiveConverter toDoublePrimitive = new StringToDoublePrimitiveConverter();
    public static StringToCharConverter toChar = new StringToCharConverter();
    public static StringToIntConverter toInt = new StringToIntConverter();
    public static StringToBooleanConverter toBoolean = new StringToBooleanConverter();
    public static StringToByteConverter toByte = new StringToByteConverter();
    public static StringToShortConverter toShort = new StringToShortConverter();
    public static StringToCharacterConverter toCharacter = new StringToCharacterConverter();
    public static StringToIntegerConverter toInteger = new StringToIntegerConverter();
    public static StringToLongConverter toLong = new StringToLongConverter();
    public static StringToFloatConverter toFloat = new StringToFloatConverter();
    public static StringToDoubleConverter toDouble = new StringToDoubleConverter();

    public static ImmutableState asImmutable(MutableState from) { return toImmutable.convert(from, 0); }
    public static MutableState asMutable(ImmutableState from) { return toMutable.convert(from, 0); }

    public static Set asMutableSet(Object from, StateConverter... converters) { return toMutableSet.convert(from, 0, converters); }
    public static ImmutableSet asImmutableSet(Object from, StateConverter... converters) { return toImmutableSet.convert(from, 0, converters); }

    public static List asMutableList(Object from, StateConverter... converters) { return toMutableList.convert(from, 0, converters); }
    public static ImmutableList asImmutableList(Object from, StateConverter... converters) { return toImmutableList.convert(from, 0, converters); }

    public static Map asMutableMap(Object from, StateConverter... converters) { return toMutableMap.convert(from, 0, converters); }
    public static ImmutableMap asImmutableMap(Object from, StateConverter... converters) { return toImmutableMap.convert(from, 0, converters); }

}
