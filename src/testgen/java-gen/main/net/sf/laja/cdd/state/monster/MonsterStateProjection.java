package net.sf.laja.cdd.state.monster;

import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.eye.EyeStateProjection;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateProjection;
import java.math.BigDecimal;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.ear.EarStateHashSet;
import net.sf.laja.cdd.state.nose.NoseStateArrayList;
import net.sf.laja.cdd.state.brow.BrowStateArrayList;
import net.sf.laja.cdd.state.ear.EarStateArrayList;
import net.sf.laja.cdd.state.mouth.MouthStateArrayList;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class MonsterStateProjection {

    MonsterStateProjection() {
    }

    public static MonsterStateProjection.NumberOfOwnWings_ numberOfLegs(int numberOfLegs) {
        return new MonsterStateProjection().new NumberOfOwnWings_();
    }

    public class NumberOfLegs_ {
        public NumberOfOwnWings_ numberOfLegs(int numberOfLegs) {
            return new NumberOfOwnWings_();
        }
    }

    public class NumberOfOwnWings_ {
        public HeadWeightInGrams_ numberOfOwnWings(int numberOfOwnWings) {
            return new HeadWeightInGrams_();
        }
    }

    public class HeadWeightInGrams_ {
        public LeftEye_ headWeightInGrams(double headWeightInGrams) {
            return new LeftEye_();
        }
    }

    public class LeftEye_ {
        public RightEye_ leftEye(EyeState leftEye) {
            return new RightEye_();
        }
    }

    public class RightEye_ {
        public MidEye_ rightEye(EyeState rightEye) {
            return new MidEye_();
        }
    }

    public class MidEye_ {
        public EyeWeightInGrams_ midEye(EyeState midEye) {
            return new EyeWeightInGrams_();
        }
    }

    public class EyeWeightInGrams_ {
        public Color_ eyeWeightInGrams(int eyeWeightInGrams) {
            return new Color_();
        }
    }

    public class Color_ {
        public Decease_ color(String color) {
            return new Decease_();
        }
    }

    public class Decease_ {
        public Noses_ decease(String decease) {
            return new Noses_();
        }
    }

    public class Noses_ {
        public Brows_ noses(NoseStateList noses) {
            return new Brows_();
        }
    }

    public class Brows_ {
        public Ears_ brows(BrowStateList brows) {
            return new Ears_();
        }
    }

    public class Ears_ {
        public Length_ ears(EarStateSet ears) {
            return new Length_();
        }
    }

    public class Length_ {
        public A_ length(int length) {
            return new A_();
        }
    }

    public class A_ {
        public B_ a(boolean a) {
            return new B_();
        }
    }

    public class B_ {
        public C_ b(byte b) {
            return new C_();
        }
    }

    public class C_ {
        public D_ c(short c) {
            return new D_();
        }
    }

    public class D_ {
        public E_ d(char d) {
            return new E_();
        }
    }

    public class E_ {
        public F_ e(int e) {
            return new F_();
        }
    }

    public class F_ {
        public G_ f(long f) {
            return new G_();
        }
    }

    public class G_ {
        public H_ g(float g) {
            return new H_();
        }
    }

    public class H_ {
        public OptionalEars_ h(double h) {
            return new OptionalEars_();
        }
    }

    public class OptionalEars_ {
        public Mouths_ optionalEars(EarStateList optionalEars) {
            return new Mouths_();
        }
    }

    public class Mouths_ {
        public Weight_ mouths(MouthStateList mouths) {
            return new Weight_();
        }
    }

    public class Weight_ {
        public HasEar_ weight(int weight) {
            return new HasEar_();
        }
    }

    public class HasEar_ {
        public HeadWeight_ hasEar(Boolean hasEar) {
            return new HeadWeight_();
        }
    }

    public class HeadWeight_ {
        public LeftArm_ headWeight(double headWeight) {
            return new LeftArm_();
        }
    }

    public class LeftArm_ {
        public MonsterStateProjection leftArm(ArmState leftArm) {
            return MonsterStateProjection.this;
        }
    }
}
