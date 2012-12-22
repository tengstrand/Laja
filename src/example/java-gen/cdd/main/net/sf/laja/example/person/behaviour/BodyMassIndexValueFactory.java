package net.sf.laja.example.person.behaviour;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import java.math.BigDecimal;
import java.math.RoundingMode;
import net.sf.laja.example.person.state.*;
import java.util.ArrayList;
import net.sf.laja.example.person.state.BmiState;

public class BodyMassIndexValueFactory extends BmiValue {

    public BodyMassIndexValueFactory(BmiState state) {
        super(state);
    }

    public BodyMassIndexValueFactory(BmiState state, BmiStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static BodyMassIndexCreator.WeightInKilograms_ heightInCentimeters(int heightInCentimeters) {
        return new BodyMassIndexCreator().new HeightInCentimeters_().heightInCentimeters(heightInCentimeters);
    }

    public static BodyMassIndexBuilder build() {
        return new BodyMassIndexBuilder();
    }

    public static BodyMassIndexListEncapsulator createList(BodyMassIndexEncapsulator... encapsulators) {
        return new BodyMassIndexListEncapsulator(encapsulators);
    }

    public static class BodyMassIndexFactory_ implements BmiStateBehaviourFactory {
        private final BmiStateBuilder stateBuilder;

        public BodyMassIndexFactory_(BmiStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(BmiState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'BodyMassIndex'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(BmiState state, Object... args) {
        return new BodyMassIndex(state);
    
      }
    }
}
