package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.ear.*;
import net.sf.laja.cdd.state.ear.EarState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.sf.laja.cdd.state.brow.BrowState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.behaviour.brow.BrowBuilder;
import net.sf.laja.cdd.behaviour.ear.TheEarBuilder;
import net.sf.laja.cdd.behaviour.ear.TheEarSetEncapsulator;
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

    public TestForeheadBuilder withBrow(BrowBuilder brow) {
        builder.withBrow(brow.builder);
        return this;
    }

    public TestForeheadBuilder withBrows(BrowListEncapsulator brows) {
        builder.withBrows(brows.stateListBuilder);
        return this;
    }

    public TestForeheadBuilder withEars(TheEarSetEncapsulator ears) {
        builder.withEars(ears.stateSetBuilder);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public TestForehead asTestForehead() {
        return (TestForehead)builder.as(new TestForeheadFactory.TestForeheadFactory_());
    }
}
