package net.sf.laja.cdd.behaviour.arm;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import net.sf.laja.cdd.state.arm.*;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.behaviour.hand.HandArrayList;
import net.sf.laja.cdd.behaviour.hand.HandHashSet;
import java.util.ArrayList;
import net.sf.laja.cdd.behaviour.hand.HandSet;
import net.sf.laja.cdd.behaviour.hand.HandList;
import net.sf.laja.cdd.behaviour.hand.Hand;

public class ArmFactory extends ArmBehaviour {

    public ArmFactory(ArmState state) {
        super(state);
    }

    public static ArmCreator.Hands_ armWeight(double armWeight) {
        return new ArmCreator().new ArmWeight_().armWeight(armWeight);
    }

    public static ArmBuilder build() {
        return new ArmBuilder();
    }

    public static ArmSetEncapsulator createSet(ArmEncapsulator... encapsulators) {
        return new ArmSetEncapsulator(encapsulators);
    }

    public static ArmListEncapsulator createList(ArmEncapsulator... encapsulators) {
        return new ArmListEncapsulator(encapsulators);
    }

    public static class ArmFactory_ implements ArmBehaviourFactory {

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
