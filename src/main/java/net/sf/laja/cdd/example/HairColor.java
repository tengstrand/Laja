package net.sf.laja.cdd.example;

public enum HairColor {
    BLACK, BROWN, GREY, RED, BLOND;

    public boolean isRedHaired() {
        return this == RED;
    }
}
