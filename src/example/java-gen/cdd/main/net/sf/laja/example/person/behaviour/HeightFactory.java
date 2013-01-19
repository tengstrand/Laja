package net.sf.laja.example.person.behaviour;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.HeightState;
import java.util.ArrayList;

public class HeightFactory extends HeightBehaviour {

    public HeightFactory(HeightState state) {
        super(state);
    }

    public HeightFactory(HeightState state, HeightStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static HeightEncapsulator heightInCentimeters(int heightInCentimeters) {
        return new HeightCreator().new HeightInCentimeters_().heightInCentimeters(heightInCentimeters);
    }

    public static HeightBuilder build() {
        return new HeightBuilder();
    }

    public static HeightListEncapsulator createList(HeightEncapsulator... encapsulators) {
        return new HeightListEncapsulator(encapsulators);
    }

    public static class HeightFactory_ implements HeightBehaviourFactory {
        private final HeightStateBuilder stateBuilder;

        public HeightFactory_(HeightStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
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
