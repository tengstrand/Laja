package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.BmiState;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BodyMassIndex extends BodyMassIndexFactory {
    public BodyMassIndex(BmiState state) {
        super(state);
    }

    // (factory)
    public BodyMassIndex asBodyMassIndex() {
        return new BodyMassIndex(state);
    }

    /**
     * @return BMI with one decimal.
     */
    public double calculateBmi() {
        double heightInMeter = state.getHeightInCentimeters() / 100.0;
        double bmi = state.getWeightInKilograms() / (heightInMeter * heightInMeter);
        return new BigDecimal(bmi).setScale(1, RoundingMode.HALF_EVEN).doubleValue();
    }

    public boolean hasNormalWeight() {
        double bmi = calculateBmi();
        return bmi >= 18.5 && bmi <= 24.9;
    }
}
