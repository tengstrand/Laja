package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.OwnerState;

public class OwnerEncapsulator {
    public final OwnerStateBuilder builder;

    public OwnerEncapsulator(OwnerStateBuilder builder) {
        this.builder = builder;
    }

    public Owner asOwner() {
        return (Owner)builder.as(new OwnerFactory.OwnerFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
