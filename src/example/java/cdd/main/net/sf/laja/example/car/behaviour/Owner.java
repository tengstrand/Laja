package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.OwnerState;

public class Owner extends OwnerFactory {
    public Owner(OwnerState state) {
        super(state);
    }

    // (factory)
    public Owner asOwner() {
        return new Owner(state);
    }
}
