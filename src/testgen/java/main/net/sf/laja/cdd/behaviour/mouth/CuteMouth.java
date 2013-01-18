package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.MouthBehaviour;
import net.sf.laja.cdd.state.mouth.MouthState;

public class CuteMouth extends MouthBehaviour {
    public CuteMouth(MouthState state) {
        super(state);
    }

    public boolean hasColor(String color) {
        return state.getColor().equals(color);
    }
}
