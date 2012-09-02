package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.HeightState;

public class Height extends HeightFactory {
    public Height(HeightState state) {
        super(state);
    }

    // (factory)
    public Height asHeight() {
        return new Height(state);
    }
}
