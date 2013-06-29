package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.example.ImmutableState;
import net.sf.laja.cdd.example.MutableState;

public class ImmutableToMutableConverter implements StateConverter {

    public MutableState convert(Object from, int index, StateConverter... converters) {
        return from == null ? null : ((ImmutableState)from).asMutable();
    }
}
