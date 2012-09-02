package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;

public class MouthEntity extends net.sf.laja.cdd.state.mouth.MouthEntity {
    public MouthEntity(MouthState state) {
        super(state);
    }

    public MouthEntity(MouthState state, MouthStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    // (factory) (list)
    public Mouth asMouth(MouthSize size) {
        if (size == MouthSize.SMALL) {
            return new SmallMouth(state);
        }
        return new BigMouth(state);
    }

    // (list)
    public CuteMouth asCuteMouth(MouthSize size, int x) {
        return new CuteMouth(state);
    }
}
