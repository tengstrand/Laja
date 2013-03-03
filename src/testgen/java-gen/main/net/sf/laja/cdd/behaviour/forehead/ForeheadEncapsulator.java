package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
// Toe
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.TheEarEncapsulator;
import net.sf.laja.cdd.behaviour.ear.TheEarSetEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;

public class ForeheadEncapsulator implements ForeheadStateComparable {
    public final ForeheadStateBuilder builder;

    public ForeheadEncapsulator(ForeheadStateBuilder builder) {
        this.builder = builder;
    }

    public Forehead asForehead() {
        return (Forehead)builder.as(new ForeheadFactory.ForeheadFactory_(builder));
    }

    public ForeheadWithBigBrows asForeheadWithBigBrows() {
        return (ForeheadWithBigBrows)builder.as(new ForeheadFactory.ForeheadWithBigBrowsFactory_(builder));
    }

    public ForeheadEncapsulator withBrows(BrowEncapsulator... brows) {
        BrowListEncapsulator encapsulator = new BrowListEncapsulator(brows);
        builder.withBrows(encapsulator.stateListBuilder);
        return this;
    }

    public ForeheadEncapsulator withEars(TheEarEncapsulator... ears) {
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
