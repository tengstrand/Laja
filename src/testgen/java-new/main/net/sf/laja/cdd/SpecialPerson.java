package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;

import static net.sf.laja.cdd.state.PersonState.PersonMutableState;

public class SpecialPerson {
    private final PersonMutableState state;

    public SpecialPerson(PersonMutableState state) {
        this.state = state;
    }

    public PersonState getState() {
        return state.asImmutable();
    }

    public boolean equals(Object o) { return state.equals(o); }
    public int hashCode() { return state.hashCode(); }
    public String toString() { return "PersonMutable" + state; }
}
