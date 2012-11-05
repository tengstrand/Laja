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
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.behaviour.ear.EarBuilder;
import net.sf.laja.cdd.behaviour.brow.BrowBuilder;
import net.sf.laja.cdd.behaviour.nose.NoseBuilder;
import net.sf.laja.cdd.behaviour.mouth.MouthBuilder;
import net.sf.laja.cdd.behaviour.eye.EyeBuilder;
import net.sf.laja.cdd.behaviour.nose.NoseListCreator;
import net.sf.laja.cdd.behaviour.brow.BrowListCreator;
import net.sf.laja.cdd.behaviour.ear.EarListCreator;
import net.sf.laja.cdd.behaviour.mouth.MouthListCreator;

public class HeadBuilder {
    public final HeadStateBuilder builder;

    public HeadBuilder() {
        builder = HeadStateImpl.build();
    }

    public HeadBuilder(HeadState state) {
        builder = HeadStateImpl.build(state);
    }

    public HeadBuilder withHeadWeightInGrams(double headWeightInGrams) {
        builder.withHeadWeightInGrams(headWeightInGrams);
        return this;
    }

    public HeadBuilder withLeftEye(EyeBuilder leftEye) {
        builder.withLeftEye(leftEye.builder);
        return this;
    }

    public HeadBuilder withRightEye(EyeBuilder rightEye) {
        builder.withRightEye(rightEye.builder);
        return this;
    }

    public HeadBuilder withMidEye(EyeBuilder midEye) {
        builder.withMidEye(midEye.builder);
        return this;
    }

    public HeadBuilder withEyeWeightInGrams(int eyeWeightInGrams) {
        builder.withEyeWeightInGrams(eyeWeightInGrams);
        return this;
    }

    public HeadBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public HeadBuilder withHasEar(Boolean hasEar) {
        builder.withHasEar(hasEar);
        return this;
    }

    public HeadBuilder withNoses(NoseListCreator noses) {
        builder.withNoses(noses.stateList);
        return this;
    }

    public HeadBuilder withBrows(BrowListCreator brows) {
        builder.withBrows(brows.stateList);
        return this;
    }

    public HeadBuilder withLength(int length) {
        builder.withLength(length);
        return this;
    }

    public HeadBuilder withA(boolean a) {
        builder.withA(a);
        return this;
    }

    public HeadBuilder withB(byte b) {
        builder.withB(b);
        return this;
    }

    public HeadBuilder withC(short c) {
        builder.withC(c);
        return this;
    }

    public HeadBuilder withD(char d) {
        builder.withD(d);
        return this;
    }

    public HeadBuilder withE(int e) {
        builder.withE(e);
        return this;
    }

    public HeadBuilder withF(long f) {
        builder.withF(f);
        return this;
    }

    public HeadBuilder withG(float g) {
        builder.withG(g);
        return this;
    }

    public HeadBuilder withH(double h) {
        builder.withH(h);
        return this;
    }

    public HeadBuilder withEars(EarListCreator ears) {
        builder.withEars(ears.stateList);
        return this;
    }

    public HeadBuilder withMouths(MouthListCreator mouths) {
        builder.withMouths(mouths.stateList);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Head asHead() {
        return (Head)builder.as(new HeadFactory.HeadFactory_(builder));
    }
}
