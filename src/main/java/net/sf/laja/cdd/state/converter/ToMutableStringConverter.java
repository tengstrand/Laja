package net.sf.laja.cdd.state.converter;

import net.sf.laja.cdd.state.MutableState;
import net.sf.laja.cdd.state.StringState;

public class ToMutableStringConverter implements StateConverter {
    public StringState convert(Object from, int index, StateConverter... converters) {
        return from == null ? null : ((MutableState)from).asStringState();
    }
}
