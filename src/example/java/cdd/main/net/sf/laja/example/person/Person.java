package net.sf.laja.example.person;

import net.sf.laja.example.person.state.BmiState;
import net.sf.laja.example.person.state.PersonState;

import static net.sf.laja.example.person.PersonCreator.PersonBehaviour;

public class Person extends PersonBehaviour {
    private final BodyMassIndex bmi;

    public Person(PersonState state) {
        super(state);
        bmi = new BodyMassIndex(new BmiState(state.heightInCentimeters, state.weightInKilograms));
    }

    public double calculateBmi() {
        return bmi.calculateBmi();
    }

    public boolean hasNormalWeight() {
        return bmi.hasNormalWeight();
    }
}
