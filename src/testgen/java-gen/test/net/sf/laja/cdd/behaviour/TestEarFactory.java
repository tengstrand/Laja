package net.sf.laja.cdd.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.ear.*;
import java.util.Arrays;
import net.sf.laja.cdd.state.ear.EarState;
import java.util.ArrayList;

public class TestEarFactory extends EarBehaviour {

    public TestEarFactory(EarState state) {
        super(state);
    }

    public TestEarFactory(EarState state, EarStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static TestEarEncapsulator weight(int weight) {
        return new TestEarCreator().new Weight_().weight(weight);
    }

    public static TestEarBuilder build() {
        return new TestEarBuilder();
    }

    public static TestEarSetEncapsulator createSet(TestEarEncapsulator... encapsulators) {
        return new TestEarSetEncapsulator(encapsulators);
    }

    public static TestEarListEncapsulator createList(TestEarEncapsulator... encapsulators) {
        return new TestEarListEncapsulator(encapsulators);
    }

    public static class TestEarFactory_ implements EarBehaviourFactory {
        private final EarStateBuilder stateBuilder;

        public TestEarFactory_(EarStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(EarState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'TestEar'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(EarState state, Object... args) {
        return new TestEar(state);
    
      }
    }
}
