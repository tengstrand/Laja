package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.PersonMutableState;

public class PersonIntegratorTemplate {
    PersonMutableState state;

    public Person asPerson() {
        return new Person(state.asImmutable());
    }

    public PersonMutable asMutablePerson() {
        return new PersonMutable(state);
    }
}
