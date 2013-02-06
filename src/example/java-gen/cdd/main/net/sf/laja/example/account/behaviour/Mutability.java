package net.sf.laja.example.account.behaviour;

public enum Mutability {
    MUTABLE(true), READONLY(false);

    public final boolean mutable;

    private Mutability(boolean mutable) {
        this.mutable = mutable;
    }
}
