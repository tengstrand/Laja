package net.sf.laja.example.car;

import net.sf.laja.example.car.state.OwnerState;

public class Owner extends OwnerCreator.OwnerBehaviour {
    public Owner(OwnerState state) {
        super(state);
    }
}
