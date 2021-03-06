package net.sf.laja.cdd.state.converter;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class MutableToImmutableSetConverter implements StateConverter {

    public ImmutableSet convert(Object from, int index, StateConverter... converters) {
        if (from == null) {
            return null;
        }
        ImmutableSet.Builder<Object> builder = ImmutableSet.builder();

        if (index == converters.length) {
            builder.addAll((Set) from);
        } else {
            StateConverter typeConverter = converters[index];

            for (Object element : (Set)from) {
                builder.add(typeConverter.convert(element, index + 1, converters));
            }
        }
        return builder.build();
    }
}
