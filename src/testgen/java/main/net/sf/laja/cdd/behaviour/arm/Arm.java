package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.state.arm.ArmState;

public class Arm extends ArmFactory {

    public Arm(ArmState state) {
        super(state);
    }

    // (factory) (list)
    public Arm asArm() {
        return new Arm(state);
    }
}
