package net.sf.laja.cdd.behaviour.nose;

import net.sf.laja.cdd.state.nose.NoseState;
import net.sf.laja.cdd.state.nose.NoseStateBehaviourFactory;
import net.sf.laja.cdd.state.nose.NoseStateBuilder;
import net.sf.laja.cdd.state.nose.NoseValue;

public class NoseValueFactory extends NoseValue {

    public NoseValueFactory(NoseState state) {
        super(state);
    }

    public NoseValueFactory(NoseState state, NoseStateBuilder stateBuilder) {
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

    public static class NoseFactory_ implements NoseStateBehaviourFactory {
        private final NoseStateBuilder builder;

        public NoseFactory_(NoseStateBuilder builder) {
            this.builder = builder;
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
}
