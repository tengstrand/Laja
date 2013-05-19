package net.sf.laja.cdd;

import net.sf.laja.cdd.annotation.Behaviour;
import org.joda.time.DateMidnight;

import static net.sf.laja.cdd.PersonCreator.PersonMutableBehaviour;
import static net.sf.laja.cdd.state.PersonState.PersonMutableState;

@Behaviour
public class SpecialPerson extends PersonMutableBehaviour {
    private final PersonMutableState s;

    public SpecialPerson(PersonMutableState state) {
        super(state);
        this.s = state;
    }

    public boolean isSpecial() {
        return new DateMidnight(1999,9,9).equals(s.birthday);
    }
}
