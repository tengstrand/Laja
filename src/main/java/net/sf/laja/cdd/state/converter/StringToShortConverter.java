package net.sf.laja.cdd.state.converter;

public class StringToShortConverter implements StateConverter {

    public Short convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Short.valueOf((String) from);
    }
}
