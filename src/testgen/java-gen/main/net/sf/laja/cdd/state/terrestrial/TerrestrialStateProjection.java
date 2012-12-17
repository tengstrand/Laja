package net.sf.laja.cdd.state.terrestrial;

import net.sf.laja.cdd.state.eye.EyeState;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class TerrestrialStateProjection {

    TerrestrialStateProjection() {
    }

    public static TerrestrialStateProjection.NumberOfWings_ numberOfLegs(int numberOfLegs) {
        return new TerrestrialStateProjection().new NumberOfWings_();
    }

    public class NumberOfLegs_ {
        public NumberOfWings_ numberOfLegs(int numberOfLegs) {
            return new NumberOfWings_();
        }
    }

    public class NumberOfWings_ {
        public LeftEye_ numberOfWings(int numberOfWings) {
            return new LeftEye_();
        }
    }

    public class LeftEye_ {
        public RightEye_ leftEye(EyeState leftEye) {
            return new RightEye_();
        }
    }

    public class RightEye_ {
        public MiddleEye_ rightEye(EyeState rightEye) {
            return new MiddleEye_();
        }
    }

    public class MiddleEye_ {
        public Weight_ middleEye(EyeState middleEye) {
            return new Weight_();
        }
    }

    public class Weight_ {
        public TerrestrialStateProjection weight(int weight) {
            return TerrestrialStateProjection.this;
        }
    }
}
