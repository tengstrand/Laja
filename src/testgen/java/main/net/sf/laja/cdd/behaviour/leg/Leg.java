package net.sf.laja.cdd.behaviour.leg;

import net.sf.laja.cdd.state.leg.LegState;

public class Leg extends LegFactory {
    public Leg(LegState state) {
        super(state);
    }

    // (factory)
    public Leg asLeg() {
        return new Leg(state);
    }
}
