package net.sf.laja.cdd.behaviour.head;

import net.sf.laja.cdd.state.head.*;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.mouth.MouthArrayList;
import net.sf.laja.cdd.behaviour.mouth.MouthList;
import net.sf.laja.cdd.behaviour.mouth.MouthSize;
import net.sf.laja.cdd.state.head.HeadStateBuilder;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;
import net.sf.laja.cdd.behaviour.nose.NoseListEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarListEncapsulator;
import net.sf.laja.cdd.behaviour.mouth.MouthListEncapsulator;

public class HeadEncapsulator {
    public final HeadStateBuilder builder;

    public HeadEncapsulator(HeadStateBuilder builder) {
        this.builder = builder;
    }

    public Head asHead() {
        return (Head)builder.as(new HeadFactory.HeadFactory_(builder));
    }

    public HeadEncapsulator withMidEye(EyeEncapsulator midEye) {
        builder.withMidEye(midEye.builder);
        return this;
    }

    public HeadEncapsulator withHasEar(Boolean hasEar) {
        builder.withHasEar(hasEar);
        return this;
    }

    public HeadEncapsulator withBrows(BrowEncapsulator... brows) {
        BrowListEncapsulator encapsulator = new BrowListEncapsulator(brows);
        builder.withBrows(encapsulator.stateList);
        return this;
    }

    public HeadEncapsulator withLength(int length) {
        builder.withLength(length);
        return this;
    }

    public HeadEncapsulator withEars(EarEncapsulator... ears) {
        EarListEncapsulator encapsulator = new EarListEncapsulator(ears);
        builder.withEars(encapsulator.stateList);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
