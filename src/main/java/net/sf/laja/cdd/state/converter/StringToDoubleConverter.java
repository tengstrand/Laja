package net.sf.laja.cdd.state.converter;

public class StringToDoubleConverter implements StateConverter {

    public Double convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Double.valueOf((String) from);
    }
}
