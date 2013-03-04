package net.sf.laja.example.car.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface TruckState {
    VehicleSizeState getSize();
    void setSize(VehicleSizeState size, Object mutator);

    int getWeightInKilograms();
    void setWeightInKilograms(int weightInKilograms, Object mutator);

    TruckTypeState getType();
    void setType(TruckTypeState type, Object mutator);

    String getColor();
    void setColor(String color, Object mutator);

    OwnerState getOwner();
    void setOwner(OwnerState owner, Object mutator);

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean equalsValue(Object obj);
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
