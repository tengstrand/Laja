package net.sf.laja.example.car.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public interface VehicleSizeState {
    int getLengthInCentimeters();
    void setLengthInCentimeters(int lengthInCentimeters);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean valueEquals(Object o);
    int valueHashCode();
    void encapsulate();
    Certificate certificate();
}
