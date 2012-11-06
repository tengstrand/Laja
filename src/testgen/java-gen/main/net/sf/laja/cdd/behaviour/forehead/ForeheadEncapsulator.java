package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListCreator;

public class ForeheadEncapsulator {
    public final ForeheadStateBuilder builder;

    public ForeheadEncapsulator(ForeheadStateBuilder builder) {
        this.builder = builder;
    }

    public Forehead asForehead() {
        return (Forehead)builder.as(new ForeheadFactory.ForeheadFactory_(builder));
    }

    public ForeheadEncapsulator withBrows(BrowEncapsulator... brows) {
        BrowListCreator creator = new BrowListCreator(brows);
        builder.withBrows(creator.stateList);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
