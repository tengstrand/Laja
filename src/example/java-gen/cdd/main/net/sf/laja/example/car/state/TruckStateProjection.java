package net.sf.laja.example.car.state;

import net.sf.laja.example.car.behaviour.CarColor;
import net.sf.laja.example.car.state.CarState;
import net.sf.laja.example.car.state.TruckTypeState;
import net.sf.laja.example.car.state.OwnerState;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class TruckStateProjection {

    TruckStateProjection() {
    }

    public static TruckStateProjection.WeightInKilograms_ lengthInCentimeters(int lengthInCentimeters) {
        return new TruckStateProjection().new WeightInKilograms_();
    }

    public class LengthInCentimeters_ {
        public WeightInKilograms_ lengthInCentimeters(int lengthInCentimeters) {
            return new WeightInKilograms_();
        }
    }

    public class WeightInKilograms_ {
        public Type_ weightInKilograms(int weightInKilograms) {
            return new Type_();
        }
    }

    public class Type_ {
        public Color_ type(TruckTypeState type) {
            return new Color_();
        }
    }

    public class Color_ {
        public Owner_ color(CarColor color) {
            return new Owner_();
        }
    }

    public class Owner_ {
        public TruckStateProjection owner(OwnerState owner) {
            return TruckStateProjection.this;
        }
    }
}
