package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.behaviour.hand.HandArrayList;
import net.sf.laja.cdd.behaviour.hand.HandList;
import net.sf.laja.cdd.state.arm.ArmState;

public class Arm extends ArmFactory {
    public final HandList hands;

    public Arm(ArmState state) {
        super(state);
        hands = new HandArrayList(state.getHands());
    }

    // (factory) (list)
    public Arm asArm() {
        return new Arm(state);
    }

    public HandList getHands() {
        return new HandArrayList(state.getHands());
    }
}
