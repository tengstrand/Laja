package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.BusState;
// Bus

public class BusEncapsulator implements BusStateComparable {
    public final BusStateBuilder builder;

    public BusEncapsulator(BusStateBuilder builder) {
        this.builder = builder;
    }

    public Bus asBus() {
        return (Bus)builder.as(new BusFactory.BusFactory_());
    }

    public BusEncapsulator withWeightInKilograms(int weightInKilograms) {
        builder.withWeightInKilograms(weightInKilograms);
        return this;
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
