package net.sf.laja.example.person.state;

import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public interface BmiStateBuilder {
    void withHeightInCentimeters(int heightInCentimeters);
    void withWeightInKilograms(int weightInKilograms);
    boolean isValid();
    Object as(BmiStateBehaviourFactory factory, Object... args);
    BmiState getBmiState(net.sf.laja.example.person.state.Certificate certificate);
}
