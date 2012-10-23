package net.sf.laja.cdd.state.arm;

import net.sf.laja.cdd.state.hand.HandStateList;

/**
 * This class should have only one attribute and one converter.
 */
public class ArmStateTemplate {
    int armLength = -1; // (optional)
    double armWeight;
    HandStateList hands;

    double convertWeight(String armWeight) {
        return Double.valueOf(armWeight);
    }
}
