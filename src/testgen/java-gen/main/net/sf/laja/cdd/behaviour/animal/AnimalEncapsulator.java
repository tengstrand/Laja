package net.sf.laja.cdd.behaviour.animal;

import net.sf.laja.cdd.state.animal.*;
import net.sf.laja.cdd.state.animal.AnimalState;
// Toe

public class AnimalEncapsulator implements AnimalStateComparable {
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
