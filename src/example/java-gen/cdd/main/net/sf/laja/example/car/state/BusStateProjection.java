package net.sf.laja.example.car.state;

import net.sf.laja.example.car.state.Certificate;
/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class BusStateProjection {

    BusStateProjection() {
    }

    public static BusStateProjection.LengthInCentimeters_ name(String name) {
        return new BusStateProjection().new LengthInCentimeters_();
    }

    public class Name_ {
        public LengthInCentimeters_ name(String name) {
            return new LengthInCentimeters_();
        }
    }

    public class LengthInCentimeters_ {
        public WeightInKilograms_ lengthInCentimeters(int lengthInCentimeters) {
            return new WeightInKilograms_();
        }
    }

    public class WeightInKilograms_ {
        public BusStateProjection weightInKilograms(int weightInKilograms) {
            return BusStateProjection.this;
        }
    }
}
