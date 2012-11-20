package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.forehead.ForeheadStateBuilder;
import net.sf.laja.cdd.state.forehead.ForeheadStateImpl;

public class TestForeheadBuilder {
    public final ForeheadStateBuilder builder;

    public TestForeheadBuilder() {
        builder = ForeheadStateImpl.build();
    }

    public TestForeheadBuilder(ForeheadState state) {
        builder = ForeheadStateImpl.build(state);
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
