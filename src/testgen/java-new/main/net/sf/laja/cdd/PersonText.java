package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;

public class PersonText {
    private PersonState state;

    public PersonText(PersonState state) {
        this.state = state;
    }

    @Override public boolean equals(Object o) { return state.equals(o); }
    @Override public int hashCode() { return state.hashCode(); }
    @Override public String toString() { return "PersonAsText" + state; }
}
