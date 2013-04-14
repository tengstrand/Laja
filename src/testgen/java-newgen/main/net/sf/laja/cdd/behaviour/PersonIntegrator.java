package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.AddressMutableState;
import net.sf.laja.cdd.state.PersonMutableState;
import net.sf.laja.cdd.state.PersonState;

public class PersonIntegrator {
    private final PersonMutableState state;

    public PersonIntegrator(PersonMutableState state) {
        this.state = state;
    }

    public PersonState asState() {
        return state.asImmutable();
    }

    public PersonMutableState asMutableState() {
        return state;
    }

    public Person asPerson() {
        return new Person(state.asImmutable());
    }

    public PersonMutable asPersonMutable() {
        return new PersonMutable(state);
    }

    public PersonIntegrator withAddress(AddressMutableState address) {
        state.address = address;
        return this;
    }
}

