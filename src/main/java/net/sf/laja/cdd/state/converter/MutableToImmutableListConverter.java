package net.sf.laja.cdd.state.converter;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class MutableToImmutableListConverter implements StateConverter {

    public ImmutableList convert(Object from, int index, StateConverter... converters) {
        if (from == null) {
            return null;
        }
        ImmutableList.Builder<Object> builder = ImmutableList.builder();

        if (index == converters.length) {
            builder.addAll((List) from);
        } else {
            StateConverter typeConverter = converters[index];

            for (Object element : (List)from) {
                builder.add(typeConverter.convert(element, index + 1, converters));
            }
        }
        return builder.build();
    }
}
