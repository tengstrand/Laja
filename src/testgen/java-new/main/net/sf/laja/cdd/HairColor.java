package net.sf.laja.cdd;

public enum HairColor {
    BLACK, BROWN, GREY, RED, BLOND;

    public boolean isRedHaired() {
        return this == RED;
    }
}
