package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.OwnerState;
// Bus

public class OwnerEncapsulator implements OwnerStateComparable {
    public final OwnerStateBuilder builder;

    public OwnerEncapsulator(OwnerStateBuilder builder) {
        this.builder = builder;
    }

    public Owner asOwner() {
        return (Owner)builder.as(new OwnerFactory.OwnerFactory_());
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
