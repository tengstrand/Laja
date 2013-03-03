package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.ear.TheEar;
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
// Toe
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.TheEarEncapsulator;
import net.sf.laja.cdd.behaviour.ear.TheEarSetEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;

public class TestForeheadEncapsulator implements ForeheadStateComparable {
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

    public TestForeheadEncapsulator withEars(TheEarEncapsulator... ears) {
        TheEarSetEncapsulator encapsulator = new TheEarSetEncapsulator(ears);
        builder.withEars(encapsulator.stateSetBuilder);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
