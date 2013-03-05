package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.PersonState;
// Person

public class PersonEncapsulator implements PersonStateComparable {
    public final PersonStateBuilder builder;

    public PersonEncapsulator(PersonStateBuilder builder) {
        this.builder = builder;
    }

    public Person asPerson() {
        return (Person)builder.as(new PersonFactory.PersonFactory_());
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
