package net.sf.laja.cdd.behaviour.ear;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.ear.*;
import java.util.Arrays;
import net.sf.laja.cdd.state.ear.EarState;
import java.util.ArrayList;

public class TheEarFactory extends EarBehaviour {

    public TheEarFactory(EarState state) {
        super(state);
    }

    public static TheEarEncapsulator weight(int weight) {
        return new TheEarCreator().new Weight_().weight(weight);
    }

    public static TheEarBuilder build() {
        return new TheEarBuilder();
    }

    public static TheEarSetEncapsulator createSet(TheEarEncapsulator... encapsulators) {
        return new TheEarSetEncapsulator(encapsulators);
    }

    public static TheEarListEncapsulator createList(TheEarEncapsulator... encapsulators) {
        return new TheEarListEncapsulator(encapsulators);
    }

    public static class TheEarFactory_ implements EarBehaviourFactory {

        public Object create(EarState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'TheEar'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(EarState state, Object... args) {
        return new TheEar(state);
    
      }
    }
}
