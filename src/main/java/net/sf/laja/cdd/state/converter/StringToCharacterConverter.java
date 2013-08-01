package net.sf.laja.cdd.state.converter;

public class StringToCharacterConverter implements StateConverter {

    public Character convert(Object from, int index, StateConverter... converters) {
        return from == null || ((String) from).isEmpty() ? null : ((String)from).charAt(0);
    }
}
