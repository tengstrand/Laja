package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.behaviour.ear.Ear;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarHashSet;
import net.sf.laja.cdd.behaviour.ear.EarSet;
import net.sf.laja.cdd.state.ear.EarState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarSetEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;

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
        builder.withBrows(encapsulator.stateListBuilder);
        return this;
    }

    public TestForeheadEncapsulator withEars(EarEncapsulator... ears) {
        EarSetEncapsulator encapsulator = new EarSetEncapsulator(ears);
        builder.withEars(encapsulator.stateSetBuilder);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
