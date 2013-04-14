package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.PersonMutableState;
import net.sf.laja.cdd.state.PersonState;

public class PersonMutable {
    private final PersonMutableState state;

    public PersonMutable(PersonMutableState state) {
        this.state = state;
    }

    public PersonState getState() {
        return state.asImmutable();
    }

    public boolean equals(Object o) { return state.equals(o); }
    public int hashCode() { return state.hashCode(); }
    public String toString() { return "PersonMutable" + state; }
}
