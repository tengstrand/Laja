package net.sf.laja.cdd.state.monster;

import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.head.HeadState;
import net.sf.laja.cdd.state.terrestrial.TerrestrialStateProjection;

public class MonsterStateTemplate extends MonsterStateImpl {
    int numberOfLegs;
    int numberOfOwnWings;
    HeadState $head;
    int length; // (optional))
    int weight;
    String color;
    String decease;
    Boolean hasEar;
    double headWeight;
    ArmState leftArm;

    void terrestrial() {
        TerrestrialStateProjection.numberOfLegs(numberOfLegs).numberOfWings(numberOfOwnWings).leftEye(leftEye)
                .rightEye(rightEye).middleEye(midEye).weight(weight);
    }
}
