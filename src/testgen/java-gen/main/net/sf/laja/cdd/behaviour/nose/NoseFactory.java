package net.sf.laja.cdd.behaviour.nose;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import net.sf.laja.cdd.state.nose.*;
import java.util.ArrayList;
import net.sf.laja.cdd.state.nose.NoseState;

public class NoseFactory extends NoseBehaviour {

    public NoseFactory(NoseState state) {
        super(state);
    }

    public NoseFactory(NoseState state, NoseStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static NoseCreator.Details_ noseDescription(String noseDescription) {
        return new NoseCreator().new NoseDescription_().noseDescription(noseDescription);
    }

    public static NoseBuilder build() {
        return new NoseBuilder();
    }

    public static NoseListEncapsulator createList(NoseEncapsulator... encapsulators) {
        return new NoseListEncapsulator(encapsulators);
    }

    public static class NoseFactory_ implements NoseBehaviourFactory {
        private final NoseStateBuilder stateBuilder;

        public NoseFactory_(NoseStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(NoseState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Nose'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(NoseState state, Object... args) {
        int extraParameter = (Integer)args[0];

        return new Nose(state, extraParameter);
    
      }
    }

    public static class BigNoseFactory_ implements NoseBehaviourFactory {
        private final NoseStateBuilder stateBuilder;

        public BigNoseFactory_(NoseStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(NoseState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'BigNose'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(NoseState state, Object... args) {
        return new BigNose(state, stateBuilder);
    
      }
    }
}
