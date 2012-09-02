package net.sf.laja.example.person.behaviour;

import java.math.BigDecimal;
import java.math.RoundingMode;
import net.sf.laja.example.person.state.*;
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

    public static class BodyMassIndexFactory_ implements BmiStateBehaviourFactory {
        private final BmiStateBuilder builder;

        public BodyMassIndexFactory_(BmiStateBuilder builder) {
            this.builder = builder;
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
