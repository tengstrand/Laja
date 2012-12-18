package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.state.arm.*;
import net.sf.laja.cdd.behaviour.hand.HandArrayList;
import net.sf.laja.cdd.behaviour.hand.HandList;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.hand.HandStateList;
import net.sf.laja.cdd.behaviour.hand.HandBuilder;
import net.sf.laja.cdd.behaviour.hand.HandListEncapsulator;

public class ArmBuilder {
    public final ArmStateBuilder builder;

    public ArmBuilder() {
        builder = ArmStateImpl.build();
    }

    public ArmBuilder(ArmState state) {
        builder = new ArmStateBuilderImpl(state);
    }

    public ArmBuilder(ArmState state, Object encapsulator) {
        builder = new ArmStateBuilderImpl(state, encapsulator);
    }

    public ArmBuilder withArmLength(int armLength) {
        builder.withArmLength(armLength);
        return this;
    }

    public ArmBuilder withArmWeight(double armWeight) {
        builder.withArmWeight(armWeight);
        return this;
    }

    public ArmBuilder withArmWeight(String armWeight) {
        builder.withArmWeight(armWeight);
        return this;
    }

    public ArmBuilder withHands(HandListEncapsulator hands) {
        builder.withHands(hands.stateList);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Arm asArm() {
        return (Arm)builder.as(new ArmFactory.ArmFactory_(builder));
    }
}
