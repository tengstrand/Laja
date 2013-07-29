package net.sf.laja.cdd.state.converter;

public class StringToLongPrimitiveConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? 0L : Long.valueOf((String) from);
    }
}
