package net.sf.laja.cdd.state.converter;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class MutableToImmutableMapConverter implements StateConverter {

    public ImmutableMap convert(Object from, int index, StateConverter... converters) {
        if (from == null) {
            return null;
        }
        ImmutableMap.Builder builder = ImmutableMap.builder();

        if (index == converters.length) {
            builder.putAll((Map) from);
        } else {
            StateConverter typeConverter = converters[index];

            for (Object object : ((Map)from).entrySet()) {
                Map.Entry entry = (Map.Entry)object;
                builder.put(entry.getKey(), typeConverter.convert(entry.getValue(), index + 1, converters));
            }
        }
        return builder.build();
    }
}
