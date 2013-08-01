package net.sf.laja.cdd.state.converter;

public class StringToBooleanPrimitiveConverter implements StateConverter {

    public Boolean convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? false : Boolean.valueOf((String) from);
    }
}
