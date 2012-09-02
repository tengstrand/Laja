package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.BmiState;
import net.sf.laja.example.person.state.BmiStateBuilder;

public class BodyMassIndexFactory extends BodyMassIndexValueFactory {
    public BodyMassIndexFactory(BmiState state) {
        super(state);
    }

    public BodyMassIndexFactory(BmiState state, BmiStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
