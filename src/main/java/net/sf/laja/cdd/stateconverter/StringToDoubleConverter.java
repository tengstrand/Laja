package net.sf.laja.cdd.stateconverter;

public class StringToDoubleConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Double.valueOf((String) from);
    }
}
