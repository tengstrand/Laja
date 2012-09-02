package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.BmiState;
import net.sf.laja.example.person.state.HeightStateBuilder;
import net.sf.laja.example.person.state.BmiStateBuilderImpl;
import net.sf.laja.example.person.state.BmiStateBuilder;
import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class PersonStateBuilderImpl implements PersonStateBuilder {
    private boolean encapsulated;
    private PersonState state;
    private final Certificate certificate;
    private boolean trusted;

    PersonStateBuilderImpl() {
        state = new PersonStateImpl();
        certificate = Certificate.get(this);
    }

    public PersonStateBuilderImpl(PersonState state) {
        this.state = state;
        certificate = Certificate.get(this);
        trusted = true;
    }

    public BmiStateBuilder bmiStateBuilder() {
        return new BmiStateBuilderImpl(state.bmiState());
    }

    public void withGivenName(String givenName) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setGivenName(givenName);
    }

    public void withSurname(String surname) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setSurname(surname);
    }

    public void withWeightInKilograms(int weightInKilograms) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setWeightInKilograms(weightInKilograms);
    }

    public void withHeight(HeightStateBuilder height) {
        if (!trusted && encapsulated) throwEncapsulationException();
        state.setHeight(height.getHeightState(certificate));
    }

    private void throwEncapsulationException() {
        throw new IllegalStateException("The state has been encapsulated and can only be changed from within behaviour classes of type \"Person\"");
    }

    public boolean isValid() {
        return state.isValid();
    }

    public Object as(PersonStateBehaviourFactory factory, Object... args) {
        Object encapsulatedObject = factory.create(state, args);
        if (!trusted) {
            encapsulated = true;
        }
        return encapsulatedObject;
    }

    public PersonState getPersonState(net.sf.laja.example.person.state.Certificate certificate) {
        return state;
    }
}
