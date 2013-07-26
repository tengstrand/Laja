package net.sf.laja.cdd.stateconverter;

public class StringToShortPrimitiveConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? (short)0 : Short.valueOf((String) from);
    }
}
