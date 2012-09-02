package net.sf.laja.cdd.behaviour.animal;

import net.sf.laja.cdd.state.animal.*;
import net.sf.laja.cdd.state.animal.AnimalState;

public class AnimalEncapsulator {
    public final AnimalStateBuilder builder;

    public AnimalEncapsulator(AnimalStateBuilder builder) {
        this.builder = builder;
    }

    public Animal asAnimal() {
        return (Animal)builder.as(new AnimalFactory.AnimalFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
