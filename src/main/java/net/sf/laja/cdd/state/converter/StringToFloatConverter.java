package net.sf.laja.cdd.state.converter;

public class StringToFloatConverter implements StateConverter {

    public Float convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Float.valueOf((String) from);
    }
}
