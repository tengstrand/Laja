package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.AddressState;

public class AddressBehaviour {
    public final AddressState state;

    public AddressBehaviour(AddressState state) {
        this.state = state;
    }

    @Override public boolean equals(Object o) { return state.equals(o); }
    @Override public int hashCode() { return state.hashCode(); }
    @Override public String toString() { return "Person" + state; }
}
