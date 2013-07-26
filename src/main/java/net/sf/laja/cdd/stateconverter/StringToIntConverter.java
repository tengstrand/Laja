package net.sf.laja.cdd.stateconverter;

public class StringToIntConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? 0 : Integer.valueOf((String) from);
    }
}
