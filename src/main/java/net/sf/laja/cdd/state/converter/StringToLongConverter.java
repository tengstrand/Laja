package net.sf.laja.cdd.state.converter;

public class StringToLongConverter implements StateConverter {

    public Long convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Long.valueOf((String) from);
    }
}
