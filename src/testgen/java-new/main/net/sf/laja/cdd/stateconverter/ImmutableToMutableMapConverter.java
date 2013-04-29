package net.sf.laja.cdd.stateconverter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ImmutableToMutableMapConverter implements TypeConverter {

    public Map convert(Object from, TypeConverter... converters) {
        if (from == null) {
            return null;
        }
        Map result = new HashMap();

        if (converters.length == 0) {
            result.putAll((Map)from);
        } else {
            TypeConverter typeConverter = converters[0];
            TypeConverter[] typeConverters = Arrays.copyOfRange(converters, 1, converters.length);

            for (Object object : ((Map)from).entrySet()) {
                Map.Entry entry = (Map.Entry)object;
                result.put(entry.getKey(), typeConverter.convert(entry.getValue(), typeConverters));
            }
        }
        return result;
    }
}
