package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.ImmutableState;
import net.sf.laja.cdd.MutableState;

public class MutableToImmutableConverter implements TypeConverter {

    public ImmutableState convert(Object from, int index, TypeConverter... converters) {
        return from == null ? null : ((MutableState)from).asImmutable();
    }
}
