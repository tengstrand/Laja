package net.sf.laja.example.person;

import net.sf.laja.example.person.state.PersonState;

public class Person extends PersonCreator.PersonBehaviour {
    private final BodyMassIndex bmi;

    public Person(PersonState state) {
        super(state);
        bmi = new BodyMassIndex(state.size);
    }

    public double calculateBmi() {
        return bmi.calculateBmi();
    }

    public boolean hasNormalWeight() {
        return bmi.hasNormalWeight();
    }
}
