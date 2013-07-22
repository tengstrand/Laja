package net.sf.laja.cdd.stateconverter;

public class StringToIntegerConverter implements StateConverter {

    public Object convert(Object from, int index) {
        return convert(from, index, new StateConverter[0]);
    }

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null ? null : Integer.valueOf((String) from);
    }
}
