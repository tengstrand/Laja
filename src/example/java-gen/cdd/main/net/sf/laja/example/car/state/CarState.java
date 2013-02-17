package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.OwnerState;
import net.sf.laja.example.car.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface CarState {
    int getLengthInCentimeters();
    void setLengthInCentimeters(int lengthInCentimeters, Object mutator);

    String getName();
    void setName(String name, Object mutator);

    OwnerState getOwner();
    void setOwner(OwnerState owner, Object mutator);

    String getColor();
    void setColor(String color, Object mutator);

    VehicleSizeState getSizeState();

    boolean isValid();
    boolean isValidAsEncapsulated();
    boolean equalsValue(Object obj);
    void encapsulate();
    void setEncapsulator(Object encapsulator);
    Certificate certificate();
}
