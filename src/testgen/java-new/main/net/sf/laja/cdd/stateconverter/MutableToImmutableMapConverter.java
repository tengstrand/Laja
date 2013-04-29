package net.sf.laja.cdd.stateconverter;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Map;

public class MutableToImmutableMapConverter implements TypeConverter {

    public ImmutableMap convert(Object from, TypeConverter... converters) {
        if (from == null) {
            return null;
        }
        ImmutableMap.Builder builder = ImmutableMap.builder();

        if (converters.length == 0) {
            builder.putAll((Map) from);
        } else {
            TypeConverter typeConverter = converters[0];
            TypeConverter[] typeConverters = Arrays.copyOfRange(converters, 1, converters.length);

            for (Object object : ((Map)from).entrySet()) {
                Map.Entry entry = (Map.Entry)object;
                builder.put(entry.getKey(), typeConverter.convert(entry.getValue(), typeConverters));
            }
        }
        return builder.build();
    }
}
