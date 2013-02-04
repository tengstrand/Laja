package net.sf.laja.cdd.behaviour.finger;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.finger.*;
import net.sf.laja.cdd.state.finger.FingerState;
import java.util.Arrays;
import java.util.ArrayList;

public class FingerFactory extends FingerBehaviour {

    public FingerFactory(FingerState state) {
        super(state);
    }

    public FingerFactory(FingerState state, FingerStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static FingerEncapsulator color(String color) {
        return new FingerCreator().new Color_().color(color);
    }

    public static FingerBuilder build() {
        return new FingerBuilder();
    }

    public static FingerSetEncapsulator createSet(FingerEncapsulator... encapsulators) {
        return new FingerSetEncapsulator(encapsulators);
    }

    public static FingerListEncapsulator createList(FingerEncapsulator... encapsulators) {
        return new FingerListEncapsulator(encapsulators);
    }

    public static class FingerFactory_ implements FingerBehaviourFactory {
        private final FingerStateBuilder stateBuilder;

        public FingerFactory_(FingerStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(FingerState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Finger'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(FingerState state, Object... args) {
        return new Finger(state);
    
      }
    }
}
