package net.sf.laja.cdd;

import net.sf.laja.cdd.annotation.TypeConverter;

@TypeConverter(behaviours = { Person.class, TextPerson.class, SpecialPerson.class })
public enum HairColor {
    BLACK, BROWN, GREY, RED, BLOND;

    public boolean isRedHaired() {
        return this == RED;
    }
}
