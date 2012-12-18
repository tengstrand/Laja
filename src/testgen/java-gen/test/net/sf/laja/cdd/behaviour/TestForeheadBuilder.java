package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.behaviour.brow.BrowBuilder;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;

public class TestForeheadBuilder {
    public final ForeheadStateBuilder builder;

    public TestForeheadBuilder() {
        builder = ForeheadStateImpl.build();
    }

    public TestForeheadBuilder(ForeheadState state) {
        builder = new ForeheadStateBuilderImpl(state);
    }

    public TestForeheadBuilder(ForeheadState state, Object encapsulator) {
        builder = new ForeheadStateBuilderImpl(state, encapsulator);
    }

    public TestForeheadBuilder withBrows(BrowListEncapsulator brows) {
        builder.withBrows(brows.stateList);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public TestForehead asTestForehead() {
        return (TestForehead)builder.as(new TestForeheadFactory.TestForeheadFactory_(builder));
    }
}
