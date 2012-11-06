package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListCreator;

public class TestForeheadEncapsulator {
    public final ForeheadStateBuilder builder;

    public TestForeheadEncapsulator(ForeheadStateBuilder builder) {
        this.builder = builder;
    }

    public TestForehead asTestForehead() {
        return (TestForehead)builder.as(new TestForeheadFactory.TestForeheadFactory_(builder));
    }

    public TestForeheadEncapsulator withBrows(BrowEncapsulator... brows) {
        BrowListCreator creator = new BrowListCreator(brows);
        builder.withBrows(creator.stateList);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
