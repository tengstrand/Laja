package net.sf.laja.cdd.stateconverter;

public class StateConverters {
    public static ToMutableConverter toMutable = new ToMutableConverter();
    public static ToMutableListConverter toMutableList = new ToMutableListConverter();
    public static ToMutableMapConverter toMutableMap = new ToMutableMapConverter();
    public static ToMutableSetConverter toMutableSet = new ToMutableSetConverter();
    public static MutableToImmutableConverter toImmutable = new MutableToImmutableConverter();
    public static MutableToImmutableListConverter toImmutableList = new MutableToImmutableListConverter();
    public static MutableToImmutableMapConverter toImmutableMap = new MutableToImmutableMapConverter();
    public static MutableToImmutableSetConverter toImmutableSet = new MutableToImmutableSetConverter();

    public static StringToIntegerConverter toInteger = new StringToIntegerConverter();
}
