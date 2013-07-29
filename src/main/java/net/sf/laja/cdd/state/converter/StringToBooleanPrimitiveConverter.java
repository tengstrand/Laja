package net.sf.laja.cdd.state.converter;

public class StringToBooleanPrimitiveConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? false : Boolean.valueOf((String) from);
    }
}
