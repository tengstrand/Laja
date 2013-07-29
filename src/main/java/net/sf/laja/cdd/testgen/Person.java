package net.sf.laja.cdd.testgen;

import net.sf.laja.cdd.annotation.Behaviour;
import net.sf.laja.cdd.testgen.state.PersonState;
import org.joda.time.DateMidnight;
import org.joda.time.Period;

@Behaviour
public class Person extends PersonCreator.PersonBehaviour {
    private final HairColor hairColor;

    public Person(PersonState state) {
        super(state);
        hairColor = HairColor.valueOf(state.hairColor);
    }

    public Person withName(String name) {
        return new Person(state.withName(name));
    }

    public boolean isRedHaired() {
        return hairColor.isRedHaired();
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
