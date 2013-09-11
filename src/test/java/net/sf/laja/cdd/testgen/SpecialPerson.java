package net.sf.laja.cdd.testgen;

import net.sf.laja.cdd.annotation.Behaviour;
import org.joda.time.LocalDate;

import static net.sf.laja.cdd.testgen.PersonCreator.PersonMutableBehaviour;
import static net.sf.laja.cdd.testgen.state.PersonState.PersonMutableState;

@Behaviour
public class SpecialPerson extends PersonMutableBehaviour {
    private final PersonMutableState state;

    public SpecialPerson(PersonMutableState state) {
        super(state);
        this.state = state;
    }

    public boolean isSpecial() {
        return new LocalDate(1999,9,9).equals(state.dateOfBirth);
    }
}
