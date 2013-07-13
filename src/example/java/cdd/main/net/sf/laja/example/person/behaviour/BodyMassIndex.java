package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.BmiState;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static net.sf.laja.example.person.behaviour.BmiCreator.BmiBehaviour;

public class BodyMassIndex extends BmiBehaviour{
    public BodyMassIndex(BmiState state) {
        super(state);
    }

    /**
     * @return BMI with one decimal.
     */
    public double calculateBmi() {
        double heightInMeter = s.heightInCentimeters / 100.0;
        double bmi = s.weightInKilograms / (heightInMeter * heightInMeter);
        return new BigDecimal(bmi).setScale(1, RoundingMode.HALF_EVEN).doubleValue();
    }

    public boolean hasNormalWeight() {
        double bmi = calculateBmi();
        return bmi >= 18.5 && bmi <= 24.9;
    }
}
