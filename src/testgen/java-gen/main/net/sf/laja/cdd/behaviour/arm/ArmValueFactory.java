package net.sf.laja.cdd.behaviour.arm;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import net.sf.laja.cdd.state.arm.*;
import net.sf.laja.cdd.state.arm.ArmState;
import java.util.ArrayList;
import net.sf.laja.cdd.behaviour.hand.HandList;

public class ArmValueFactory extends ArmValue {

    public ArmValueFactory(ArmState state) {
        super(state);
    }

    public ArmValueFactory(ArmState state, ArmStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static ArmCreator.Hands_ armWeight(double armWeight) {
        return new ArmCreator().new ArmWeight_().armWeight(armWeight);
    }

    public static ArmCreator.Hands_ armWeight(String armWeight) {
        return new ArmCreator().new ArmWeight_().armWeight(armWeight);
    }

    public static ArmBuilder build() {
        return new ArmBuilder();
    }

    public static ArmListCreator createList(ArmEncapsulator... encapsulators) {
        return new ArmListCreator(encapsulators);
    }

    public static class ArmFactory_ implements ArmStateBehaviourFactory {
        private final ArmStateBuilder builder;

        public ArmFactory_(ArmStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(ArmState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Arm'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(ArmState state, Object... args) {
        return new Arm(state);
    
      }
    }
}
