package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.BrowState;
import net.sf.laja.cdd.state.brow.BrowStateBuilder;
import net.sf.laja.cdd.state.brow.BrowStateBuilderImpl;
import net.sf.laja.cdd.state.brow.BrowStateImpl;

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
        return (TestBrow)builder.as(new TestBrowFactory.TestBrowFactory_(builder));
    }
}
