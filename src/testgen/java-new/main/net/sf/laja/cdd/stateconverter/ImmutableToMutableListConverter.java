package net.sf.laja.cdd.stateconverter;

import java.util.ArrayList;
import java.util.List;

public class ImmutableToMutableListConverter implements TypeConverter {

    public List convert(Object from, int index, TypeConverter... converters) {
        if (from == null) {
            return null;
        }
        List result = new ArrayList();

        if (index == converters.length) {
            result.addAll((List)from);
        } else {
            TypeConverter typeConverter = converters[index];

            for (Object element : (List)from) {
                result.add(typeConverter.convert(element, index + 1, converters));
            }
        }
        return result;
    }
}
