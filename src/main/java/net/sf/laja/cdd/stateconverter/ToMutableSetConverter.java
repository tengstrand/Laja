package net.sf.laja.cdd.stateconverter;

import java.util.HashSet;
import java.util.Set;

public class ToMutableSetConverter implements StateConverter {

    public Set convert(Object from, int index, StateConverter... converters) {
        if (from == null) {
            return null;
        }
        Set result = new HashSet();

        if (index == converters.length) {
            result.addAll((Set)from);
        } else {
            StateConverter typeConverter = converters[index];

            for (Object element : (Set)from) {
                result.add(typeConverter.convert(element, index + 1, converters));
            }
        }
        return result;
    }
}
