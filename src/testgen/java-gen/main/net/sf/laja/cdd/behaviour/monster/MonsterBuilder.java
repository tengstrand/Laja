package net.sf.laja.cdd.behaviour.monster;

import net.sf.laja.cdd.state.monster.*;
import net.sf.laja.cdd.behaviour.terrestrial.Terrestrial;
import net.sf.laja.cdd.behaviour.head.Head;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;
import net.sf.laja.cdd.state.monster.MonsterState;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.eye.EyeStateProjection;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateProjection;
import java.math.BigDecimal;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.behaviour.ear.EarBuilder;
import net.sf.laja.cdd.behaviour.arm.ArmBuilder;
import net.sf.laja.cdd.behaviour.brow.BrowBuilder;
import net.sf.laja.cdd.behaviour.nose.NoseBuilder;
import net.sf.laja.cdd.behaviour.mouth.MouthBuilder;
import net.sf.laja.cdd.behaviour.eye.EyeBuilder;
import net.sf.laja.cdd.behaviour.nose.NoseListEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarListEncapsulator;
import net.sf.laja.cdd.behaviour.mouth.MouthListEncapsulator;

public class MonsterBuilder {
    public final MonsterStateBuilder builder;

    public MonsterBuilder() {
        builder = MonsterStateImpl.build();
    }

    public MonsterBuilder(MonsterState state) {
        builder = new MonsterStateBuilderImpl(state);
    }

    public MonsterBuilder(MonsterState state, Object encapsulator) {
        builder = new MonsterStateBuilderImpl(state, encapsulator);
    }

    public MonsterBuilder withNumberOfLegs(int numberOfLegs) {
        builder.withNumberOfLegs(numberOfLegs);
        return this;
    }

    public MonsterBuilder withNumberOfOwnWings(int numberOfOwnWings) {
        builder.withNumberOfOwnWings(numberOfOwnWings);
        return this;
    }

    public MonsterBuilder withHeadWeightInGrams(double headWeightInGrams) {
        builder.withHeadWeightInGrams(headWeightInGrams);
        return this;
    }

    public MonsterBuilder withLeftEye(EyeBuilder leftEye) {
        builder.withLeftEye(leftEye.builder);
        return this;
    }

    public MonsterBuilder withRightEye(EyeBuilder rightEye) {
        builder.withRightEye(rightEye.builder);
        return this;
    }

    public MonsterBuilder withMidEye(EyeBuilder midEye) {
        builder.withMidEye(midEye.builder);
        return this;
    }

    public MonsterBuilder withEyeWeightInGrams(int eyeWeightInGrams) {
        builder.withEyeWeightInGrams(eyeWeightInGrams);
        return this;
    }

    public MonsterBuilder withColor(String color) {
        builder.withColor(color);
        return this;
    }

    public MonsterBuilder withNoses(NoseListEncapsulator noses) {
        builder.withNoses(noses.stateListBuilder);
        return this;
    }

    public MonsterBuilder withBrows(BrowListEncapsulator brows) {
        builder.withBrows(brows.stateListBuilder);
        return this;
    }

    public MonsterBuilder withLength(int length) {
        builder.withLength(length);
        return this;
    }

    public MonsterBuilder withA(boolean a) {
        builder.withA(a);
        return this;
    }

    public MonsterBuilder withB(byte b) {
        builder.withB(b);
        return this;
    }

    public MonsterBuilder withC(short c) {
        builder.withC(c);
        return this;
    }

    public MonsterBuilder withD(char d) {
        builder.withD(d);
        return this;
    }

    public MonsterBuilder withE(int e) {
        builder.withE(e);
        return this;
    }

    public MonsterBuilder withF(long f) {
        builder.withF(f);
        return this;
    }

    public MonsterBuilder withG(float g) {
        builder.withG(g);
        return this;
    }

    public MonsterBuilder withH(double h) {
        builder.withH(h);
        return this;
    }

    public MonsterBuilder withEars(EarListEncapsulator ears) {
        builder.withEars(ears.stateListBuilder);
        return this;
    }

    public MonsterBuilder withMouths(MouthListEncapsulator mouths) {
        builder.withMouths(mouths.stateListBuilder);
        return this;
    }

    public MonsterBuilder withWeight(int weight) {
        builder.withWeight(weight);
        return this;
    }

    public MonsterBuilder withHasEar(Boolean hasEar) {
        builder.withHasEar(hasEar);
        return this;
    }

    public MonsterBuilder withHeadWeight(double headWeight) {
        builder.withHeadWeight(headWeight);
        return this;
    }

    public MonsterBuilder withLeftArm(ArmBuilder leftArm) {
        builder.withLeftArm(leftArm.builder);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Monster asMonster() {
        return (Monster)builder.as(new MonsterFactory.MonsterFactory_(builder));
    }
}
