package net.sf.laja.cdd.behaviour.ear;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.cdd.state.ear.*;
import java.util.Arrays;
import net.sf.laja.cdd.state.ear.EarState;
import java.util.ArrayList;

public class EarValueFactory extends EarValue {

    public EarValueFactory(EarState state) {
        super(state);
    }

    public EarValueFactory(EarState state, EarStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static EarEncapsulator create() {
        return new EarCreator().create();
    }

    public static EarBuilder build() {
        return new EarBuilder();
    }

    public static EarListEncapsulator createList(EarEncapsulator... encapsulators) {
        return new EarListEncapsulator(encapsulators);
    }

    public static class EarFactory_ implements EarStateBehaviourFactory {
        private final EarStateBuilder builder;

        public EarFactory_(EarStateBuilder builder) {
            this.builder = builder;
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
