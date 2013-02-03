package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.state.arm.*;
import net.sf.laja.cdd.behaviour.hand.Hand;
import net.sf.laja.cdd.behaviour.hand.HandArrayList;
import net.sf.laja.cdd.behaviour.hand.HandHashSet;
import net.sf.laja.cdd.behaviour.hand.HandList;
import net.sf.laja.cdd.behaviour.hand.HandSet;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.hand.HandStateList;
// Toe
import net.sf.laja.cdd.behaviour.hand.HandListEncapsulator;

public class ArmEncapsulator implements ArmStateComparable {
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
