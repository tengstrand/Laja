package net.sf.laja.cdd.behaviour.terrestrial;

import net.sf.laja.cdd.state.terrestrial.*;
import net.sf.laja.cdd.behaviour.eye.Eye;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;

public class TerrestrialCreator {
    private final TerrestrialStateBuilder builder = TerrestrialStateImpl.build();

    public class NumberOfLegs_ {
        public LeftEye_ numberOfLegs(int numberOfLegs) {
            builder.withNumberOfLegs(numberOfLegs);
            return new LeftEye_();
        }
    }

    public class LeftEye_ {
        public TerrestrialEncapsulator leftEye(EyeEncapsulator leftEye) {
            builder.withLeftEye(leftEye.builder);
            return create();
        }
    }

    public TerrestrialEncapsulator create() {
        return new TerrestrialEncapsulator(builder);
     }
}
