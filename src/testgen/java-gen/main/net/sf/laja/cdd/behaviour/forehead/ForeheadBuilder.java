package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.behaviour.brow.BrowBuilder;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;

public class ForeheadBuilder {
    public final ForeheadStateBuilder builder;

    public ForeheadBuilder() {
        builder = ForeheadStateImpl.build();
    }

    public ForeheadBuilder(ForeheadState state) {
        builder = new ForeheadStateBuilderImpl(state);
    }

    public ForeheadBuilder(ForeheadState state, Object encapsulator) {
        builder = new ForeheadStateBuilderImpl(state, encapsulator);
    }

    public ForeheadBuilder withBrows(BrowListEncapsulator brows) {
        builder.withBrows(brows.stateListBuilder);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Forehead asForehead() {
        return (Forehead)builder.as(new ForeheadFactory.ForeheadFactory_(builder));
    }
}
