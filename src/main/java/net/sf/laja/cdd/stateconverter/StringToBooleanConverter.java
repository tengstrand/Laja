package net.sf.laja.cdd.stateconverter;

public class StringToBooleanConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Boolean.valueOf((String) from);
    }
}
