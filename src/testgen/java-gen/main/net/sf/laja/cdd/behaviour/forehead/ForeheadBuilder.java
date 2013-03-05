package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.behaviour.brow.BrowBuilder;
import net.sf.laja.cdd.behaviour.ear.TheEarBuilder;
import net.sf.laja.cdd.behaviour.ear.TheEarSetEncapsulator;
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

    public ForeheadBuilder withBrow(BrowBuilder brow) {
        builder.withBrow(brow.builder);
        return this;
    }

    public ForeheadBuilder withBrows(BrowListEncapsulator brows) {
        builder.withBrows(brows.stateListBuilder);
        return this;
    }

    public ForeheadBuilder withEars(TheEarSetEncapsulator ears) {
        builder.withEars(ears.stateSetBuilder);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Forehead asForehead() {
        return (Forehead)builder.as(new ForeheadFactory.ForeheadFactory_());
    }

    public ForeheadWithBigBrows asForeheadWithBigBrows() {
        return (ForeheadWithBigBrows)builder.as(new ForeheadFactory.ForeheadWithBigBrowsFactory_());
    }
}
