package net.sf.laja.example.car.state;

import net.sf.laja.example.car.behaviour.CarColor;
import net.sf.laja.example.car.state.VehicleSizeStateBuilder;
import net.sf.laja.example.car.state.OwnerStateBuilder;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface CarStateBuilder extends VehicleSizeStateBuilder {
    void withLengthInCentimeters(int lengthInCentimeters);
    void withName(String name);
    void withOwner(OwnerStateBuilder owner);
    void withColor(CarColor color);
    void withColor(String color);
    OwnerStateBuilder getOwnerStateBuilder();
    boolean isValid();
    Object as(CarStateBehaviourFactory factory, Object... args);
    CarState getCarState(net.sf.laja.example.car.state.Certificate certificate);
}
