package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface VehicleSizeStateBuilder {
    void withLengthInCentimeters(int lengthInCentimeters);
    boolean isValid();
    Object as(VehicleSizeBehaviourFactory factory, Object... args);
    VehicleSizeState getVehicleSizeState(net.sf.laja.example.car.state.Certificate certificate);
}
