package net.sf.laja.cdd;

import net.sf.laja.cdd.annotation.Behaviour;
import net.sf.laja.cdd.state.PersonState;

import static net.sf.laja.cdd.PersonCreator.PersonBehaviour;

@Behaviour
public class TextPerson extends PersonBehaviour {

    public TextPerson(PersonState state) {
        super(state);
    }
}
