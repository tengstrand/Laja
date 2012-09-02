package net.sf.laja.cdd.behaviour.animal;

import net.sf.laja.cdd.state.animal.AnimalState;

public class Animal extends AnimalFactory {
    public Animal(AnimalState state) {
        super(state);
    }

    // (factory)
    public Animal asAnimal() {
        return new Animal(state);
    }
}
