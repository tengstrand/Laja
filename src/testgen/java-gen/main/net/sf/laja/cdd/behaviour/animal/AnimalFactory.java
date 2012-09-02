package net.sf.laja.cdd.behaviour.animal;

import net.sf.laja.cdd.state.animal.AnimalState;
import net.sf.laja.cdd.state.animal.AnimalStateBuilder;

public class AnimalFactory extends AnimalValueFactory {
    public AnimalFactory(AnimalState state) {
        super(state);
    }

    public AnimalFactory(AnimalState state, AnimalStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
