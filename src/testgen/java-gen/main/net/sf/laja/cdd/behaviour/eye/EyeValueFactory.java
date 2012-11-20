package net.sf.laja.cdd.behaviour.eye;

import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeStateBehaviourFactory;
import net.sf.laja.cdd.state.eye.EyeStateBuilder;
import net.sf.laja.cdd.state.eye.EyeValue;

public class EyeValueFactory extends EyeValue {

    public EyeValueFactory(EyeState state) {
        super(state);
    }

    public EyeValueFactory(EyeState state, EyeStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static EyeCreator.Color_ eyeWeightInGrams(int eyeWeightInGrams) {
        return new EyeCreator().new EyeWeightInGrams_().eyeWeightInGrams(eyeWeightInGrams);
    }

    public static EyeCreator.Color_ eyeWeightInGrams(String eyeWeightInGrams) {
        return new EyeCreator().new EyeWeightInGrams_().eyeWeightInGrams(eyeWeightInGrams);
    }

    public static EyeBuilder build() {
        return new EyeBuilder();
    }

    public static EyeListEncapsulator createList(EyeEncapsulator... encapsulators) {
        return new EyeListEncapsulator(encapsulators);
    }

    public static class EyeFactory_ implements EyeStateBehaviourFactory {
        private final EyeStateBuilder builder;

        public EyeFactory_(EyeStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(EyeState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Eye'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(EyeState state, Object... args) {
        return new Eye(state);
    
      }
    }
}
