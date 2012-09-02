package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthValue;

public class CuteMouth extends MouthValue {
    public CuteMouth(MouthState state) {
        super(state);
    }

    public boolean hasColor(String color) {
        return state.getColor().equals(color);
    }
}
