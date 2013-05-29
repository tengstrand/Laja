package net.sf.laja.cdd;

public enum HairColor implements ValueConverter<Integer> {
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

    public Integer asValue() {
        return id;
    }
}
