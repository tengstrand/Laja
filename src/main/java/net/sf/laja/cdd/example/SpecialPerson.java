package net.sf.laja.cdd.example;

import net.sf.laja.cdd.annotation.Behaviour;
import org.joda.time.DateMidnight;

import static net.sf.laja.cdd.example.PersonCreator.PersonMutableBehaviour;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;

@Behaviour
public class SpecialPerson extends PersonMutableBehaviour {
    private final PersonMutableState s;

    public SpecialPerson(PersonMutableState s) {
        super(s);
        this.s = s;
    }

    public boolean isSpecial() {
        return new DateMidnight(1999,9,9).equals(s.birthday);
    }
}
