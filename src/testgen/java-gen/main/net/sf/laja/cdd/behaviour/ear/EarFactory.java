package net.sf.laja.cdd.behaviour.ear;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.ear.*;
import java.util.Arrays;
import net.sf.laja.cdd.state.ear.EarState;
import java.util.ArrayList;

public class EarFactory extends EarBehaviour {

    public EarFactory(EarState state) {
        super(state);
    }

    public EarFactory(EarState state, EarStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static EarEncapsulator weight(int weight) {
        return new EarCreator().new Weight_().weight(weight);
    }

    public static EarBuilder build() {
        return new EarBuilder();
    }

    public static EarSetEncapsulator createSet(EarEncapsulator... encapsulators) {
        return new EarSetEncapsulator(encapsulators);
    }

    public static EarListEncapsulator createList(EarEncapsulator... encapsulators) {
        return new EarListEncapsulator(encapsulators);
    }

    public static class EarFactory_ implements EarBehaviourFactory {
        private final EarStateBuilder stateBuilder;

        public EarFactory_(EarStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(EarState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Ear'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(EarState state, Object... args) {
        return new Ear(state);
    
      }
    }
}
