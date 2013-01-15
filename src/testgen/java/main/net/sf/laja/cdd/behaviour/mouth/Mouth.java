package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.Certificate;
import net.sf.laja.cdd.state.mouth.MouthState;

public interface Mouth {
    CuteMouth asCuteMouth(MouthSize size, int x);
    MouthState getState(Certificate certificate);
}
