package net.sf.laja.example.car.state;

import net.sf.laja.example.car.behaviour.CarColor;

public class CarStateTemplate {
    VehicleSizeState $size;
    String name;
    OwnerState owner;
    CarColor color;

    CarColor convertColor(String color) {
        return CarColor.valueOf(color.toUpperCase());
    }
}
