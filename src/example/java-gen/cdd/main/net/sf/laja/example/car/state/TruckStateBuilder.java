package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.VehicleSizeStateBuilder;
import net.sf.laja.example.car.state.TruckTypeStateBuilder;
import net.sf.laja.example.car.state.OwnerStateBuilder;
import net.sf.laja.example.car.state.CarStateBuilder;
import net.sf.laja.example.car.state.VehicleSizeStateBuilder;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface TruckStateBuilder {
    CarStateBuilder getCarStateBuilder();
    VehicleSizeStateBuilder getSizeStateBuilder();
    void withLengthInCentimeters(int lengthInCentimeters);
    void withWeightInKilograms(int weightInKilograms);
    void withType(TruckTypeStateBuilder type);
    void withColor(String color);
    void withOwner(OwnerStateBuilder owner);
    TruckTypeStateBuilder getTypeStateBuilder();
    OwnerStateBuilder getOwnerStateBuilder();
    boolean isValid();
    Object as(TruckBehaviourFactory factory, Object... args);
    TruckState getTruckState(net.sf.laja.example.car.state.Certificate certificate);
}
