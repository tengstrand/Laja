package net.sf.laja.cdd.stateconverter;

public class StringToDoubleConverter implements StateConverter {

    public Object convert(Object from, int index) {
        return convert(from, index, new StateConverter[0]);
    }

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null ? null : Double.valueOf((String) from);
    }
}
