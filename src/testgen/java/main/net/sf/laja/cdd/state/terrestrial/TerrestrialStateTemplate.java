package net.sf.laja.cdd.state.terrestrial;

import net.sf.laja.cdd.state.eye.EyeState;

public class TerrestrialStateTemplate {
    int numberOfLegs;
    int numberOfWings; // (hide)
    EyeState leftEye;
    EyeState rightEye; // (hide)
    EyeState middleEye; // (optional)
    int weight; // (hide)
}
