package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.PersonState;

public class PersonBuilder {
    public final PersonStateBuilder builder;

    public PersonBuilder() {
        builder = PersonStateImpl.build();
    }

    public PersonBuilder(PersonState state) {
        builder = new PersonStateBuilderImpl(state);
    }

    public PersonBuilder(PersonState state, Object encapsulator) {
        builder = new PersonStateBuilderImpl(state, encapsulator);
    }

    public PersonBuilder withGivenName(String givenName) {
        builder.withGivenName(givenName);
        return this;
    }

    public PersonBuilder withSurname(String surname) {
        builder.withSurname(surname);
        return this;
    }

    public PersonBuilder withWeightInKilograms(int weightInKilograms) {
        builder.withWeightInKilograms(weightInKilograms);
        return this;
    }

    public PersonBuilder withHeight(HeightBuilder height) {
        builder.withHeight(height.builder);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Person asPerson() {
        return (Person)builder.as(new PersonFactory.PersonFactory_(builder));
    }
}
