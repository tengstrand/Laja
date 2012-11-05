package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.state.arm.*;
import net.sf.laja.cdd.behaviour.hand.HandArrayList;
import net.sf.laja.cdd.behaviour.hand.HandList;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.hand.HandStateList;
import net.sf.laja.cdd.behaviour.hand.HandListCreator;

public class ArmEncapsulator {
    public final ArmStateBuilder builder;

    public ArmEncapsulator(ArmStateBuilder builder) {
        this.builder = builder;
    }

    public Arm asArm() {
        return (Arm)builder.as(new ArmFactory.ArmFactory_(builder));
    }

    public ArmEncapsulator withArmLength(int armLength) {
        builder.withArmLength(armLength);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
