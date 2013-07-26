package net.sf.laja.cdd.stateconverter;

public class StringToBytePrimitiveConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).trim().isEmpty() ? (byte)0 : Byte.valueOf((String) from);
    }
}
