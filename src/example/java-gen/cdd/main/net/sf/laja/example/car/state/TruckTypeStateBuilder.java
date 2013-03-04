package net.sf.laja.example.car.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface TruckTypeStateBuilder {
    void withNumberOfWheels(int numberOfWheels);
    void withTruckName(String truckName);
    boolean isValid();
    Object as(TruckTypeBehaviourFactory factory, Object... args);
    TruckTypeState getTruckTypeState(net.sf.laja.example.car.state.Certificate certificate);
}
