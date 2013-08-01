package net.sf.laja.cdd.state.converter;

public class StringToByteConverter implements StateConverter {

    public Byte convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? null : Byte.valueOf((String) from);
    }
}
