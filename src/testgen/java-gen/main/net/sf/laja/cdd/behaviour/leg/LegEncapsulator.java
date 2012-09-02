package net.sf.laja.cdd.behaviour.leg;

import net.sf.laja.cdd.state.leg.*;
import net.sf.laja.cdd.state.leg.LegState;

public class LegEncapsulator {
    public final LegStateBuilder builder;

    public LegEncapsulator(LegStateBuilder builder) {
        this.builder = builder;
    }

    public Leg asLeg() {
        return (Leg)builder.as(new LegFactory.LegFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
