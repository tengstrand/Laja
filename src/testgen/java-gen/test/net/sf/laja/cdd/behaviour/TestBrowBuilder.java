package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class TestBrowBuilder {
    public final BrowStateBuilder builder;

    public TestBrowBuilder() {
        builder = BrowStateImpl.build();
    }

    public TestBrowBuilder(BrowState state) {
        builder = new BrowStateBuilderImpl(state);
    }

    public TestBrowBuilder(BrowState state, Object encapsulator) {
        builder = new BrowStateBuilderImpl(state, encapsulator);
    }

    public TestBrowBuilder withArea(int area) {
        builder.withArea(area);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public TestBrow asTestBrow() {
        return (TestBrow)builder.as(new TestBrowFactory.TestBrowFactory_());
    }
}
