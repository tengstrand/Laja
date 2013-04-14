package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.PersonState;

public class Person extends PersonFactory {
    public PersonState state;

    public Person(PersonState state) {
        this.state = state;
    }

    public void setName(String name) {
        state = state.withName(name);
    }

    public boolean isFromUppsala() {
        return new DefaultAddress(state.address).isFromUppsala();
    }

    public boolean isAdult() {
        return state.age >= 18;
    }

    public boolean equals(Object o) { return state.equals(o); }
    public int hashCode() { return state.hashCode(); }
    public String toString() { return getClass().getSimpleName() + state; }
}
