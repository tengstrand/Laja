package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.OwnerState;

import static net.sf.laja.example.car.behaviour.OwnerCreator.OwnerBehaviour;

public class Owner extends OwnerBehaviour {
    public Owner(OwnerState state) {
        super(state);
    }
}
