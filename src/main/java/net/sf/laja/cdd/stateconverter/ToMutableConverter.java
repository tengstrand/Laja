package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.testgen.ImmutableState;
import net.sf.laja.cdd.testgen.MutableState;

public class ToMutableConverter implements StateConverter {

    public MutableState convert(Object from, int index, StateConverter... converters) {
        return from == null ? null : ((ImmutableState)from).asMutable();
    }
}
