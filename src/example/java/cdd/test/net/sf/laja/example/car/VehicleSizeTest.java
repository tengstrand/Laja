package net.sf.laja.example.car;

import net.sf.laja.example.car.behaviour.VehicleSize;
import org.junit.Test;

import static net.sf.laja.example.car.behaviour.VehicleSizeCreator.createVehicleSize;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VehicleSizeTest {

    @Test
    public void isSmall() {
        VehicleSize vehicleSize = createVehicleSize().lengthInCentimeters(100).asVehicleSize();

        assertTrue(vehicleSize.isSmall());
    }

    @Test
    public void isSmall_not() {
        VehicleSize vehicleSize = createVehicleSize().lengthInCentimeters(300).asVehicleSize();

        assertFalse(vehicleSize.isSmall());
    }

    @Test
    public void isBig() {
        VehicleSize vehicleSize = createVehicleSize().lengthInCentimeters(400).asVehicleSize();

        assertTrue(vehicleSize.isBig());
    }

    @Test
    public void isBig_not() {
        VehicleSize vehicleSize = createVehicleSize().lengthInCentimeters(100).asVehicleSize();

        assertFalse(vehicleSize.isBig());
    }

    @Test
    public void isNormalSize() {
        VehicleSize vehicleSize = createVehicleSize().lengthInCentimeters(350).asVehicleSize();

        assertTrue(vehicleSize.isNormalSize());
    }
}
