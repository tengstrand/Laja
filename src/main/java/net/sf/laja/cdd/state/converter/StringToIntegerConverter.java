package net.sf.laja.cdd.state.converter;

public class StringToIntegerConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Integer.valueOf((String) from);
    }
}
