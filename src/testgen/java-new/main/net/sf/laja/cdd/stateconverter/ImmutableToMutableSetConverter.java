package net.sf.laja.cdd.stateconverter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ImmutableToMutableSetConverter implements TypeConverter {

    public Set convert(Object from, TypeConverter... converters) {
        if (from == null) {
            return null;
        }
        Set result = new HashSet();

        if (converters.length == 0) {
            result.addAll((Set)from);
        } else {
            TypeConverter typeConverter = converters[0];
            TypeConverter[] typeConverters = Arrays.copyOfRange(converters, 1, converters.length);

            for (Object element : (Set)from) {
                result.add(typeConverter.convert(element, typeConverters));
            }
        }
        return result;
    }
}
