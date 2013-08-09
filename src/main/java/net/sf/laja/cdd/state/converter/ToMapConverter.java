package net.sf.laja.cdd.state.converter;

import net.sf.laja.cdd.state.MutableState;

import java.util.Map;

public class ToMapConverter implements StateConverter {

    public Map convert(Object from, int index, StateConverter... converters) {
        return from == null ? null : ((MutableState)from).asMap();
    }
}
