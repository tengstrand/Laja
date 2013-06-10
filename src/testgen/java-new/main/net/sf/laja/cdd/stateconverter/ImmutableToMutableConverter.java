package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.ImmutableState;
import net.sf.laja.cdd.MutableState;

public class ImmutableToMutableConverter implements StateConverter {

    public MutableState convert(Object from, int index, StateConverter... converters) {
        return from == null ? null : ((ImmutableState)from).asMutable();
    }
}
