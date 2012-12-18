package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class TestBrowEncapsulator {
    public final BrowStateBuilder builder;

    public TestBrowEncapsulator(BrowStateBuilder builder) {
        this.builder = builder;
    }

    public TestBrow asTestBrow() {
        return (TestBrow)builder.as(new TestBrowFactory.TestBrowFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
