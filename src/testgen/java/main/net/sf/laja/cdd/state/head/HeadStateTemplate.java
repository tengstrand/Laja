package net.sf.laja.cdd.state.head;

import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.mouth.MouthStateList;
import net.sf.laja.cdd.state.nose.NoseStateList;
import net.sf.laja.cdd.state.ear.EarStateList;
import net.sf.laja.cdd.state.eye.EyeState;

public class HeadStateTemplate extends HeadStateImpl {
    double headWeightInGrams;
    EyeState leftEye;
    EyeState rightEye;
    EyeState midEye; // (optional)
    EyeState $eye;
    NoseStateList noses;
    ForeheadState $foreheadState;
    int length; // (optional)
    boolean a;
    byte b;
    short c;
    char d;
    int e; // (hidden)
    long f;
    float g;
    double h;
    EarStateList ears; // (optional)
    MouthStateList mouths;

    public boolean isValid() {
        return headWeightInGrams >= 0.5 && eyeWeightInGrams > 0;
    }
}
