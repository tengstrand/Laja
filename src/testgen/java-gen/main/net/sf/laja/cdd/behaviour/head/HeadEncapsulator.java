package net.sf.laja.cdd.behaviour.head;

import net.sf.laja.cdd.state.head.*;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.behaviour.mouth.MouthList;
import net.sf.laja.cdd.behaviour.mouth.MouthSize;
import net.sf.laja.cdd.state.head.HeadStateBuilder;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;
import net.sf.laja.cdd.behaviour.nose.NoseListCreator;
import net.sf.laja.cdd.behaviour.brow.BrowListCreator;
import net.sf.laja.cdd.behaviour.ear.EarListCreator;
import net.sf.laja.cdd.behaviour.mouth.MouthListCreator;

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

    public HeadEncapsulator withBrows(BrowListCreator brows) {
        builder.withBrows(brows.stateList);
        return this;
    }

    public HeadEncapsulator withLength(int length) {
        builder.withLength(length);
        return this;
    }

    public HeadEncapsulator withEars(EarListCreator ears) {
        builder.withEars(ears.stateList);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
