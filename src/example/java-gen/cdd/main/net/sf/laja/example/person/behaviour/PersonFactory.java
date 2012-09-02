package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.PersonState;
import net.sf.laja.example.person.state.PersonStateBuilder;

public class PersonFactory extends PersonValueFactory {
    public PersonFactory(PersonState state) {
        super(state);
    }

    public PersonFactory(PersonState state, PersonStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
