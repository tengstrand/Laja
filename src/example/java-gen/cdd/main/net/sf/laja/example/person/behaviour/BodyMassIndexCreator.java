package net.sf.laja.example.person.behaviour;
import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.BmiState;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BodyMassIndexCreator {
    private final BmiStateBuilder builder = BmiStateImpl.build();

    public class HeightInCentimeters_ {
        public WeightInKilograms_ heightInCentimeters(int heightInCentimeters) {
            builder.withHeightInCentimeters(heightInCentimeters);
            return new WeightInKilograms_();
        }
    }

    public class WeightInKilograms_ {
        public BodyMassIndexEncapsulator weightInKilograms(int weightInKilograms) {
            builder.withWeightInKilograms(weightInKilograms);
            return create();
        }
    }

    public BodyMassIndexEncapsulator create() {
        return new BodyMassIndexEncapsulator(builder);
     }
}
