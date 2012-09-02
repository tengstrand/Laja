package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.HeightState;

public class HeightValueFactory extends HeightValue {

    public HeightValueFactory(HeightState state) {
        super(state);
    }

    public HeightValueFactory(HeightState state, HeightStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static HeightEncapsulator heightInCentimeters(int heightInCentimeters) {
        return new HeightCreator().new HeightInCentimeters_().heightInCentimeters(heightInCentimeters);
    }

    public static HeightBuilder build() {
        return new HeightBuilder();
    }

    public static class HeightFactory_ implements HeightStateBehaviourFactory {
        private final HeightStateBuilder builder;

        public HeightFactory_(HeightStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(HeightState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Height'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(HeightState state, Object... args) {
        return new Height(state);
    
      }
    }
}
