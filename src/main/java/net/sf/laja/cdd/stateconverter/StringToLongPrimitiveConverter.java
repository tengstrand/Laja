package net.sf.laja.cdd.stateconverter;

public class StringToLongPrimitiveConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? 0L : Long.valueOf((String) from);
    }
}
