package net.sf.laja.example.person.state;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class BmiStateProjection {

    BmiStateProjection() {
    }

    public static BmiStateProjection.WeightInKilograms_ heightInCentimeters(int heightInCentimeters) {
        return new BmiStateProjection().new WeightInKilograms_();
    }

    public class HeightInCentimeters_ {
        public WeightInKilograms_ heightInCentimeters(int heightInCentimeters) {
            return new WeightInKilograms_();
        }
    }

    public class WeightInKilograms_ {
        public BmiStateProjection weightInKilograms(int weightInKilograms) {
            return BmiStateProjection.this;
        }
    }
}
