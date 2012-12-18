package net.sf.laja.cdd.behaviour.leg;

import net.sf.laja.cdd.state.leg.LegState;
import net.sf.laja.cdd.state.leg.LegStateBuilder;
import net.sf.laja.cdd.state.leg.LegStateBuilderImpl;
import net.sf.laja.cdd.state.leg.LegStateImpl;

public class LegBuilder {
    public final LegStateBuilder builder;

    public LegBuilder() {
        builder = LegStateImpl.build();
    }

    public LegBuilder(LegState state) {
        builder = new LegStateBuilderImpl(state);
    }

    public LegBuilder(LegState state, Object encapsulator) {
        builder = new LegStateBuilderImpl(state, encapsulator);
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
