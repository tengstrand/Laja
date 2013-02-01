package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.behaviour.hand.Hand;
import net.sf.laja.cdd.behaviour.hand.HandArrayList;
import net.sf.laja.cdd.behaviour.hand.HandHashSet;
import net.sf.laja.cdd.behaviour.hand.HandList;
import net.sf.laja.cdd.behaviour.hand.HandSet;
import net.sf.laja.cdd.state.arm.ArmState;

public class Arm extends ArmFactory {
    public Arm(ArmState state) {
        super(state);
    }

    // (factory)
    public Arm asArm() {
        return new Arm(state);
    }

    public void removeHand(Hand hand) {
        HandList list = new HandArrayList(state.getHands());
        list.remove(hand);
    }

    public HandList getHands() {
        return new HandArrayList(state.getHands());
    }
}
