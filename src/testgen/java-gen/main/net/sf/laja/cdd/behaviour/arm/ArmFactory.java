package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.arm.ArmStateBuilder;

public class ArmFactory extends ArmValueFactory {
    public ArmFactory(ArmState state) {
        super(state);
    }

    public ArmFactory(ArmState state, ArmStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
