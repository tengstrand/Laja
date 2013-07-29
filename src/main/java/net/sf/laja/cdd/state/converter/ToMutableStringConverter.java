package net.sf.laja.cdd.state.converter;

import net.sf.laja.cdd.testgen.MutableState;

public class ToMutableStringConverter implements StateConverter {
    public Object convert(Object from, int index, StateConverter... converters) {
        return from == null ? null : ((MutableState)from).asStringState();
    }
}
