package net.sf.laja.cdd.state.converter;

public class StringToFloatPrimitiveConverter implements StateConverter {

    public Float convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? (float)0 : Float.valueOf((String) from);
    }
}
