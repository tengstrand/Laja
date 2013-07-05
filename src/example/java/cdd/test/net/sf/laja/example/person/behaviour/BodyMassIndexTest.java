package net.sf.laja.example.person.behaviour;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static net.sf.laja.example.person.behaviour.BodyMassIndexCreator.createBodyMassIndex;
import static org.junit.Assert.assertFalse;

public class BodyMassIndexTest {

    @Test
    public void calculateBmi() {
        BodyMassIndex bmi = createBodyMassIndex().heightInCentimeters(180).weightInKilograms(80).asBmi();

        assertEquals(24.7, bmi.calculateBmi());
    }

    @Test
    public void hasNormalWeight() {
        BodyMassIndex bmi = createBodyMassIndex().heightInCentimeters(180).weightInKilograms(75).asBmi();

        assertTrue(bmi.hasNormalWeight());
    }

    @Test
    public void hasNormalWeight_not() {
        BodyMassIndex bmi = createBodyMassIndex().heightInCentimeters(180).weightInKilograms(110).asBmi();

        assertFalse(bmi.hasNormalWeight());
    }
}
