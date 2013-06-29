package net.sf.laja.cdd.example;

import net.sf.laja.cdd.annotation.Behaviour;
import net.sf.laja.cdd.state.PersonState;

import static net.sf.laja.cdd.example.PersonCreator.PersonBehaviour;

@Behaviour
public class TextPerson extends PersonBehaviour {

    public TextPerson(PersonState s) {
        super(s);
    }
}
