package net.sf.laja.cdd.state.converter;

import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.state.MutableState;

public class ToMutableConverter implements StateConverter {

    public MutableState convert(Object from, int index, StateConverter... converters) {
        return from == null ? null : ((ImmutableState)from).asMutable();
    }
}
