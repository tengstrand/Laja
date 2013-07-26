package net.sf.laja.cdd.stateconverter;

public class StringToLongConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Long.valueOf((String) from);
    }
}
