package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.HeightState;
import net.sf.laja.example.person.state.HeightStateBuilder;

public class HeightFactory extends HeightValueFactory {
    public HeightFactory(HeightState state) {
        super(state);
    }

    public HeightFactory(HeightState state, HeightStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
