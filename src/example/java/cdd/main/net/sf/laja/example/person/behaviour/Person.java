package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.PersonState;

import static net.sf.laja.example.person.behaviour.PersonCreator.PersonBehaviour;

public class Person extends PersonBehaviour {
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
