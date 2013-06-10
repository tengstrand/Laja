package net.sf.laja.cdd.stateconverter;

import java.util.HashMap;
import java.util.Map;

public class ImmutableToMutableMapConverter implements StateConverter {

    public Map convert(Object from, int index, StateConverter... converters) {
        if (from == null) {
            return null;
        }
        Map result = new HashMap();

        if (index == converters.length) {
            result.putAll((Map)from);
        } else {
            StateConverter typeConverter = converters[index];

            for (Object object : ((Map)from).entrySet()) {
                Map.Entry entry = (Map.Entry)object;
                result.put(entry.getKey(), typeConverter.convert(entry.getValue(), index + 1, converters));
            }
        }
        return result;
    }
}
