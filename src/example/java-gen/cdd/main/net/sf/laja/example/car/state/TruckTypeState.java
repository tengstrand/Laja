package net.sf.laja.example.car.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface TruckTypeState {
    int getNumberOfWheels();
    void setNumberOfWheels(int numberOfWheels);

    String getTruckName();
    void setTruckName(String truckName);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
}
