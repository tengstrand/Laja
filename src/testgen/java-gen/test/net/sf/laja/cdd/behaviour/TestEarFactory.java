package net.sf.laja.cdd.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class TestEarFactory extends EarBehaviour {

    public TestEarFactory(EarState state) {
        super(state);
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
