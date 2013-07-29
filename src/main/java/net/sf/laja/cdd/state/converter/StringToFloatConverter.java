package net.sf.laja.cdd.state.converter;

public class StringToFloatConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Float.valueOf((String) from);
    }
}
