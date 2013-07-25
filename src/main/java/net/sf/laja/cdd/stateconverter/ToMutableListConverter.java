package net.sf.laja.cdd.stateconverter;

import java.util.ArrayList;
import java.util.List;

public class ToMutableListConverter implements StateConverter {

    public List convert(Object from, int index, StateConverter... converters) {
        if (from == null) {
            return null;
        }
        List result = new ArrayList();

        if (index == converters.length) {
            result.addAll((List)from);
        } else {
            StateConverter typeConverter = converters[index];

            for (Object element : (List)from) {
                result.add(typeConverter.convert(element, index + 1, converters));
            }
        }
        return result;
    }
}
