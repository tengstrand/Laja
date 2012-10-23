package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.behaviour.hand.HandList;
import net.sf.laja.cdd.state.arm.ArmState;

public class Arm extends ArmFactory {
    private final HandList hands;

    public Arm(ArmState state) {
        super(state);
        hands = new HandList(state.getHands());
    }

    // (factory) (list)
    public Arm asArm() {
        return new Arm(state);
    }

    public int numberOfStateHands() {
        return state.getHands().size();
    }

    public HandList getHands() {
        return hands;
    }

    @Override
    public boolean syncState() {
        return hands.syncState();
    }
}
