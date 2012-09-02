package net.sf.laja.cdd.behaviour.arm;

import net.sf.laja.cdd.state.arm.*;
import net.sf.laja.cdd.state.arm.ArmState;

public class ArmCreator {
    private final ArmStateBuilder builder = ArmStateImpl.build();

    public class ArmWeight_ {
        public ArmEncapsulator armWeight(double armWeight) {
            builder.withArmWeight(armWeight);
            return create();
        }

        public ArmEncapsulator armWeight(String armWeight) {
            builder.withArmWeight(Double.valueOf(armWeight));
            return create();
        }
    }

    public ArmEncapsulator create() {
        return new ArmEncapsulator(builder);
     }
}
