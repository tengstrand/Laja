package net.sf.laja.cdd;

import org.joda.time.DateMidnight;

import static net.sf.laja.cdd.PersonCreator.PersonMutableBehaviour;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;

public class SpecialPerson extends PersonMutableBehaviour {
    private final PersonMutableState state;

    public SpecialPerson(PersonMutableState state) {
        super(state);
        this.state = state;
    }

    public boolean isSpecial() {
        return new DateMidnight(1999,9,9).equals(state.getBirthday());
    }
}
