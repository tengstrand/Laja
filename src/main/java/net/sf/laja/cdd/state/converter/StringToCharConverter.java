package net.sf.laja.cdd.state.converter;

public class StringToCharConverter implements StateConverter {

    public Character convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).isEmpty() ? (char)0 : ((String)from).charAt(0);
    }
}
