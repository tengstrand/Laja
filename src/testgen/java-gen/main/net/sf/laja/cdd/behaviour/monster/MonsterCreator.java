package net.sf.laja.cdd.behaviour.monster;

import net.sf.laja.cdd.state.monster.*;
import net.sf.laja.cdd.behaviour.terrestrial.Terrestrial;
import net.sf.laja.cdd.behaviour.head.Head;
import net.sf.laja.cdd.state.monster.MonsterStateBuilder;
import net.sf.laja.cdd.state.monster.MonsterState;
import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.behaviour.head.HeadEncapsulator;
import net.sf.laja.cdd.behaviour.arm.ArmEncapsulator;

public class MonsterCreator {
    private final MonsterStateBuilder builder = MonsterStateImpl.build();

    public class NumberOfLegs_ {
        public NumberOfOwnWings_ numberOfLegs(int numberOfLegs) {
            builder.withNumberOfLegs(numberOfLegs);
            return new NumberOfOwnWings_();
        }
    }

    public class NumberOfOwnWings_ {
        public Head_ numberOfOwnWings(int numberOfOwnWings) {
            builder.withNumberOfOwnWings(numberOfOwnWings);
            return new Head_();
        }
    }

    public class Head_ {
        public Weight_ head(HeadEncapsulator head) {
            builder.withHead(head.builder);
            return new Weight_();
        }
    }

    public class Weight_ {
        public Color_ weight(int weight) {
            builder.withWeight(weight);
            return new Color_();
        }
    }

    public class Color_ {
        public Decease_ color(String color) {
            builder.withColor(color);
            return new Decease_();
        }
    }

    public class Decease_ {
        public HasEar_ decease(String decease) {
            builder.withDecease(decease);
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
