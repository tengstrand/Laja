package net.sf.laja.cdd.stateconverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmutableToMutableListConverter implements TypeConverter {
    public List convert(Object from, TypeConverter... converters) {
        List result = new ArrayList();

        if (from != null) {
            if (converters.length == 0) {
                result.addAll((List)from);
            } else {
                TypeConverter typeConverter = converters[0];
                TypeConverter[] typeConverters = Arrays.copyOfRange(converters, 1, converters.length);

                for (Object element : (List)from) {
                    result.add(typeConverter.convert(element, typeConverters));
                }
            }
        }
        return result;
    }
}
