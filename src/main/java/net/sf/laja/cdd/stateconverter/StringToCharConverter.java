package net.sf.laja.cdd.stateconverter;

public class StringToCharConverter implements StateConverter {

    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).isEmpty() ? (char)0 : ((String)from).charAt(0);
    }
}
