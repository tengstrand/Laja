package net.sf.laja.example.person.behaviour;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BodyMassIndexTest {

    @Test
    public void calculateBmi() {
        BodyMassIndex bmi = BodyMassIndex.heightInCentimeters(180).weightInKilograms(80).asBodyMassIndex();

        assertEquals(24.7, bmi.calculateBmi());
    }

    @Test
    public void hasNormalWeight() {
        BodyMassIndex bmi = BodyMassIndex.heightInCentimeters(180).weightInKilograms(75).asBodyMassIndex();

        assertTrue(bmi.hasNormalWeight());
    }

    @Test
    public void hasNormalWeight_not() {
        BodyMassIndex bmi = BodyMassIndex.heightInCentimeters(180).weightInKilograms(110).asBodyMassIndex();

        assertFalse(bmi.hasNormalWeight());
    }
}
