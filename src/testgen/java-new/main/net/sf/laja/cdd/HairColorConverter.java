package net.sf.laja.cdd;

import net.sf.laja.cdd.annotation.TypeConverter;

@TypeConverter
public class HairColorConverter {

    public int convert(HairColor hairColor) {
        return hairColor.id;
    }
}
