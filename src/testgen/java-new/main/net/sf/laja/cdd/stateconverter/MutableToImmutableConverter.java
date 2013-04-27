package net.sf.laja.cdd.stateconverter;

import net.sf.laja.cdd.ImmutableState;
import net.sf.laja.cdd.MutableState;

public class MutableToImmutableConverter implements TypeConverter {

    public ImmutableState convert(Object from, TypeConverter... converters) {
        return ((MutableState)from).asImmutable();
    }
}
