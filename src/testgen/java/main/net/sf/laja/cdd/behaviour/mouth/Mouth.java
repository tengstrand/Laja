package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.MouthElement;

public interface Mouth extends MouthElement {
    CuteMouth asCuteMouth(MouthSize size, int x);
}
