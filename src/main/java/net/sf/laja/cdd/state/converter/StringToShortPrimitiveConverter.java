package net.sf.laja.cdd.state.converter;

public class StringToShortPrimitiveConverter implements StateConverter {

    public Short convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? (short)0 : Short.valueOf((String) from);
    }
}
