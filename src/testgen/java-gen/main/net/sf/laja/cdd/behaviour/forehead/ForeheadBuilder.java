package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.forehead.ForeheadStateBuilder;
import net.sf.laja.cdd.state.forehead.ForeheadStateImpl;

public class ForeheadBuilder {
    public final ForeheadStateBuilder builder;

    public ForeheadBuilder() {
        builder = ForeheadStateImpl.build();
    }

    public ForeheadBuilder(ForeheadState state) {
        builder = ForeheadStateImpl.build(state);
    }

    public ForeheadBuilder withBrows(BrowListEncapsulator brows) {
        builder.withBrows(brows.stateList);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Forehead asForehead() {
        return (Forehead)builder.as(new ForeheadFactory.ForeheadFactory_(builder));
    }
}
