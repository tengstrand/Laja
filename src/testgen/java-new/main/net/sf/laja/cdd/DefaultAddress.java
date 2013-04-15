package net.sf.laja.cdd;

import net.sf.laja.cdd.state.AddressState;

public class DefaultAddress implements Address {
    public final AddressState state;

    public DefaultAddress(AddressState state) {
        this.state = state;
    }

    public boolean isFromUppsala() {
        return "Uppsala".equals(state.city);
    }

    @Override public boolean equals(Object o) { return state.equals(o); }
    @Override public int hashCode() { return state.hashCode(); }
    @Override public String toString() { return getClass().getSimpleName() + state; }
}
