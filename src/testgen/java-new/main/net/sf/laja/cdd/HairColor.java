package net.sf.laja.cdd;

import net.sf.laja.cdd.annotation.TypeConverter;

public enum HairColor {
    BLACK(0), BROWN(1), GREY(2), RED(3), BLOND(4);

    public final int id;

    private HairColor(int id) {
        this.id = id;
    }

    public static HairColor valueOf(int id) {
        for (HairColor color : values()) {
            if (color.id == id) {
                return color;
            }
        }
        throw new IllegalArgumentException("Unknown id: " + id);
    }

    public static void validate(int hairColor, String attributeName, Object rootElement, String parent, ValidationErrors.Builder errors) {
        try {
            valueOf(hairColor);
        } catch (IllegalArgumentException e) {
            errors.addError(rootElement, parent, attributeName, "Unknown hair color id: " + hairColor);
        }
    }

    @TypeConverter
    public int hairColor(HairColor hairColor) {
        return hairColor.id;
    }
}
