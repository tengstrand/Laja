package net.sf.laja.example.car.state;

public class VehicleSizeStateTemplate {
    int lengthInCentimeters;

    public boolean isValid() {
        return lengthInCentimeters >= 0;
    }
}
