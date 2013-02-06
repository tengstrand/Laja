package net.sf.laja.cdd.behaviour.monster;

import net.sf.laja.cdd.state.monster.*;
import net.sf.laja.cdd.behaviour.terrestrial.Terrestrial;
import net.sf.laja.cdd.behaviour.head.Head;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;
import net.sf.laja.cdd.state.monster.MonsterState;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateProjection;
import net.sf.laja.cdd.state.eye.EyeState;
import net.sf.laja.cdd.behaviour.brow.BrowEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarEncapsulator;
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;
import net.sf.laja.cdd.behaviour.eye.EyeEncapsulator;
import net.sf.laja.cdd.behaviour.nose.NoseEncapsulator;
import net.sf.laja.cdd.behaviour.mouth.MouthEncapsulator;
import net.sf.laja.cdd.behaviour.arm.ArmEncapsulator;
import net.sf.laja.cdd.behaviour.nose.NoseListEncapsulator;
import net.sf.laja.cdd.behaviour.brow.BrowListEncapsulator;
import net.sf.laja.cdd.behaviour.ear.EarListEncapsulator;
import net.sf.laja.cdd.behaviour.mouth.MouthListEncapsulator;

public class MonsterCreator {
    private final MonsterStateBuilder builder = MonsterStateImpl.build();

    public class NumberOfLegs_ {
        public NumberOfOwnWings_ numberOfLegs(int numberOfLegs) {
            builder.withNumberOfLegs(numberOfLegs);
            return new NumberOfOwnWings_();
        }
    }

    public class NumberOfOwnWings_ {
        public HeadWeightInGrams_ numberOfOwnWings(int numberOfOwnWings) {
            builder.withNumberOfOwnWings(numberOfOwnWings);
            return new HeadWeightInGrams_();
        }
    }

    public class HeadWeightInGrams_ {
        public LeftEye_ headWeightInGrams(double headWeightInGrams) {
            builder.withHeadWeightInGrams(headWeightInGrams);
            return new LeftEye_();
        }
    }

    public class LeftEye_ {
        public RightEye_ leftEye(EyeEncapsulator leftEye) {
            builder.withLeftEye(leftEye.builder);
            return new RightEye_();
        }
    }

    public class RightEye_ {
        public EyeWeightInGrams_ rightEye(EyeEncapsulator rightEye) {
            builder.withRightEye(rightEye.builder);
            return new EyeWeightInGrams_();
        }
    }

    public class EyeWeightInGrams_ {
        public Color_ eyeWeightInGrams(int eyeWeightInGrams) {
            builder.withEyeWeightInGrams(eyeWeightInGrams);
            return new Color_();
        }
    }

    public class Color_ {
        public Noses_ color(String color) {
            builder.withColor(color);
            return new Noses_();
        }
    }

    public class Noses_ {
        public A_ noses() {
            return new A_();
        }

        public A_ noses(NoseListEncapsulator noses) {
            builder.withNoses(noses.stateListBuilder);
            return new A_();
        }
    }

    public class A_ {
        public B_ a(boolean a) {
            builder.withA(a);
            return new B_();
        }
    }

    public class B_ {
        public C_ b(byte b) {
            builder.withB(b);
            return new C_();
        }
    }

    public class C_ {
        public D_ c(short c) {
            builder.withC(c);
            return new D_();
        }
    }

    public class D_ {
        public E_ d(char d) {
            builder.withD(d);
            return new E_();
        }
    }

    public class E_ {
        public F_ e(int e) {
            builder.withE(e);
            return new F_();
        }
    }

    public class F_ {
        public G_ f(long f) {
            builder.withF(f);
            return new G_();
        }
    }

    public class G_ {
        public H_ g(float g) {
            builder.withG(g);
            return new H_();
        }
    }

    public class H_ {
        public Mouths_ h(double h) {
            builder.withH(h);
            return new Mouths_();
        }
    }

    public class Mouths_ {
        public Weight_ mouths() {
            return new Weight_();
        }

        public Weight_ mouths(MouthListEncapsulator mouths) {
            builder.withMouths(mouths.stateListBuilder);
            return new Weight_();
        }
    }

    public class Weight_ {
        public HasEar_ weight(int weight) {
            builder.withWeight(weight);
            return new HasEar_();
        }
    }

    public class HasEar_ {
        public HeadWeight_ hasEar(Boolean hasEar) {
            builder.withHasEar(hasEar);
            return new HeadWeight_();
        }
    }

    public class HeadWeight_ {
        public LeftArm_ headWeight(double headWeight) {
            builder.withHeadWeight(headWeight);
            return new LeftArm_();
        }
    }

    public class LeftArm_ {
        public MonsterEncapsulator leftArm(ArmEncapsulator leftArm) {
            builder.withLeftArm(leftArm.builder);
            return create();
        }
    }

    public MonsterEncapsulator create() {
        return new MonsterEncapsulator(builder);
     }
}
