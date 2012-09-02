package net.sf.laja.cdd.behaviour.leg;

import net.sf.laja.cdd.state.leg.*;
import net.sf.laja.cdd.state.leg.LegState;

public class LegBuilder {
    public final LegStateBuilder builder;

    public LegBuilder() {
        builder = LegStateImpl.build();
    }

    public LegBuilder(LegState state) {
        builder = LegStateImpl.build(state);
    }

    public LegBuilder withLegDescription(String legDescription) {
        builder.withLegDescription(legDescription);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Leg asLeg() {
        return (Leg)builder.as(new LegFactory.LegFactory_(builder));
    }
}
