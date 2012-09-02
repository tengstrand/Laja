package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.PersonState;

public class PersonEncapsulator {
    public final PersonStateBuilder builder;

    public PersonEncapsulator(PersonStateBuilder builder) {
        this.builder = builder;
    }

    public Person asPerson() {
        return (Person)builder.as(new PersonFactory.PersonFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
