package net.sf.laja.cdd.state.monster;

import net.sf.laja.cdd.state.arm.ArmState;
import net.sf.laja.cdd.state.head.HeadState;

public class MonsterStateTemplate {
    int numberOfLegs;
    int numberOfOwnWings;
    HeadState head;
    int length; // (optional))
    int weight;
    String color;
    String decease;
    Boolean hasEar;
    double headWeight;
    ArmState leftArm;
}
