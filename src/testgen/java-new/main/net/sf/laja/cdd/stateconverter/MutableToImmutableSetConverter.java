package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.Set;

public class MutableToImmutableSetConverter {

    public ImmutableSet convert(Object from, TypeConverter... converters) {
        ImmutableSet.Builder<Object> builder = ImmutableSet.builder();

        if (from != null) {
            if (converters.length == 0) {
                builder.addAll((Set) from);
            } else {
                TypeConverter typeConverter = converters[0];
                TypeConverter[] typeConverters = Arrays.copyOfRange(converters, 1, converters.length);

                for (Object element : (Set)from) {
                    builder.add(typeConverter.convert(element, typeConverters));
                }
            }
        }
        return builder.build();
    }
}
