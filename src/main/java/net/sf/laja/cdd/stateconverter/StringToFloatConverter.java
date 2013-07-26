package net.sf.laja.cdd.stateconverter;

public class StringToFloatConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Float.valueOf((String) from);
    }
}
