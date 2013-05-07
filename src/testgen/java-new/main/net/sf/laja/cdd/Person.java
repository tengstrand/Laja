package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;
import org.joda.time.DateMidnight;
import org.joda.time.Period;

import static net.sf.laja.cdd.PersonCreator.PersonBehaviour;

public class Person extends PersonBehaviour {

    public Person(PersonState state) {
        super(state);
    }

    public Person withName(String name) {
        return new Person(state.withName(name));
    }

    public boolean hasLongName() {
        return state.name.length() > 8;
    }

    public boolean isFromUppsala() {
        return new RegularAddress(state.address).isFromUppsala();
    }

    public boolean isTeenager() {
        int years = new Period(state.birthday, new DateMidnight()).getYears();
        return years >= 13 && years <= 19;
    }
}
