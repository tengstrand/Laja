package net.sf.laja.cdd.state.converter;

public class StringToDoublePrimitiveConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? 0.0 : Double.valueOf((String) from);
    }
}
