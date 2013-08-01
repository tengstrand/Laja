package net.sf.laja.cdd.state.converter;

public class StringToBytePrimitiveConverter implements StateConverter {

    public Byte convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? (byte)0 : Byte.valueOf((String) from);
    }
}
