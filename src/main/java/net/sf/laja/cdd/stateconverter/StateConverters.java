package net.sf.laja.cdd.stateconverter;

public class StateConverters {
    public static ImmutableToMutableConverter toMutable = new ImmutableToMutableConverter();
    public static ImmutableToMutableListConverter toMutableList = new ImmutableToMutableListConverter();
    public static ImmutableToMutableMapConverter toMutableMap = new ImmutableToMutableMapConverter();
    public static ImmutableToMutableSetConverter toMutableSet = new ImmutableToMutableSetConverter();
    public static MutableToImmutableConverter toImmutable = new MutableToImmutableConverter();
    public static MutableToImmutableListConverter toImmutableList = new MutableToImmutableListConverter();
    public static MutableToImmutableMapConverter toImmutableMap = new MutableToImmutableMapConverter();
    public static MutableToImmutableSetConverter toImmutableSet = new MutableToImmutableSetConverter();
}
