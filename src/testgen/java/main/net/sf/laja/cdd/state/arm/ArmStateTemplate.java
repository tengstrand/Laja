package net.sf.laja.cdd.state.arm;

/**
 * This class should have only one attribute and one converter.
 */
public class ArmStateTemplate {
    int armLength = -1; // (optional)
    double armWeight;

    double convertWeight(String armWeight) {
        return Double.valueOf(armWeight);
    }
}
