package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;
import net.sf.laja.cdd.state.PersonValidator;

public class Person {
    public PersonState state;

    public Person(PersonState state) {
        this.state = state;
        PersonValidator.throwExceptionIfNotValid(state);
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
