package net.sf.laja.cdd.stateconverter;

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
}
