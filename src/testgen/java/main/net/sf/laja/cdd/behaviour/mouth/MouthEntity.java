package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.MouthBehaviour;
import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;

public class MouthEntity extends MouthBehaviour {
    public MouthEntity(MouthState state) {
        super(state);
    }

    // (factory)
    public Mouth asMouth(MouthSize size) {
        if (size == MouthSize.SMALL) {
            return new SmallMouth(state);
        }
        return new BigMouth(state);
    }

    public CuteMouth asCuteMouth(MouthSize size, int x) {
        return new CuteMouth(state);
    }
}
