package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.VehicleSizeState;
import net.sf.laja.example.car.state.OwnerState;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class CarStateProjection {

    CarStateProjection() {
    }

    public static CarStateProjection.Name_ lengthInCentimeters(int lengthInCentimeters) {
        return new CarStateProjection().new Name_();
    }

    public class LengthInCentimeters_ {
        public Name_ lengthInCentimeters(int lengthInCentimeters) {
            return new Name_();
        }
    }

    public class Name_ {
        public Owner_ name(String name) {
            return new Owner_();
        }
    }

    public class Owner_ {
        public Color_ owner(OwnerState owner) {
            return new Color_();
        }
    }

    public class Color_ {
        public CarStateProjection color(String color) {
            return CarStateProjection.this;
        }
    }
}
