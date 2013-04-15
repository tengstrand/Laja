package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;
import net.sf.laja.cdd.state.PersonStateValidator;

public class Person {
    public PersonState state;

    public Person(PersonState state) {
        this.state = state;
        PersonStateValidator.throwExceptionIfInvalid(state);
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

    @Override public boolean equals(Object o) { return state.equals(o); }
    @Override public int hashCode() { return state.hashCode(); }
    @Override public String toString() { return getClass().getSimpleName() + state; }
}
