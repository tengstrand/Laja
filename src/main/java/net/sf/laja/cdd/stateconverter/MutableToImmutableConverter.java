package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.state.ImmutableState;
import net.sf.laja.cdd.testgen.MutableState;

public class MutableToImmutableConverter implements StateConverter {

    public ImmutableState convert(Object from, int index, StateConverter... converters) {
        return from == null ? null : ((MutableState)from).asImmutable();
    }
}
