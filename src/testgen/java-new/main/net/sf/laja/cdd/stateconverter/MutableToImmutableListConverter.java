package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.List;

public class MutableToImmutableListConverter implements TypeConverter {

    public ImmutableList convert(Object from, TypeConverter... converters) {
        if (from == null) {
            return null;
        }
        ImmutableList.Builder<Object> builder = ImmutableList.builder();

        if (converters.length == 0) {
            builder.addAll((List) from);
        } else {
            TypeConverter typeConverter = converters[0];
            TypeConverter[] typeConverters = Arrays.copyOfRange(converters, 1, converters.length);

            for (Object element : (List)from) {
                builder.add(typeConverter.convert(element, typeConverters));
            }
        }
        return builder.build();
    }
}
