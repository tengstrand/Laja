package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;
import net.sf.laja.cdd.state.forehead.ForeheadStateBuilder;

public class TestForeheadEncapsulator {
    public final ForeheadStateBuilder builder;

    public TestForeheadEncapsulator(ForeheadStateBuilder builder) {
        this.builder = builder;
    }

    public TestForehead asTestForehead() {
        return (TestForehead)builder.as(new TestForeheadFactory.TestForeheadFactory_(builder));
    }

    public TestForeheadEncapsulator withBrows(BrowEncapsulator... brows) {
        BrowListEncapsulator encapsulator = new BrowListEncapsulator(brows);
        builder.withBrows(encapsulator.stateList);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
