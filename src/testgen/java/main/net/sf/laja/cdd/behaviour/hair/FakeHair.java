package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.HairBehaviour;
import net.sf.laja.cdd.state.hair.HairState;

public class FakeHair extends HairBehaviour {
    public FakeHair(HairState state) {
        super(state);
    }

    public boolean hasColor(String color) {
        return state.getColor().equals(color);
    }

    public void mutate() {
        state.setLength(1, this);
    }
}
