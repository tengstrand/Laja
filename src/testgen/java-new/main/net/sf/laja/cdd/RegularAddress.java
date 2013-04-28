package net.sf.laja.cdd;

import net.sf.laja.cdd.state.AddressState;

public class RegularAddress implements Address {
    public final AddressState state;

    public RegularAddress(AddressState state) {
        this.state = state;
    }

    public boolean isFromUppsala() {
        return "Uppsala".equals(state.city);
    }

    @Override public boolean equals(Object that) {
        return this == that ? true : that == null || getClass() != that.getClass() ? false :
                state.equals(((RegularAddress)that).state);
    }
    @Override public int hashCode() { return state.hashCode(); }
    @Override public String toString() { return getClass().getSimpleName() + state; }
}
