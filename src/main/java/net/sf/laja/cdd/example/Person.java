package net.sf.laja.cdd.example;

import net.sf.laja.cdd.annotation.Behaviour;
import net.sf.laja.cdd.state.PersonState;
import org.joda.time.DateMidnight;
import org.joda.time.Period;

@Behaviour
public class Person extends PersonCreator.PersonBehaviour {
    private final HairColor hairColor;

    public Person(PersonState s) {
        super(s);
        hairColor = HairColor.valueOf(s.hairColor);
    }

    public Person withName(String name) {
        return new Person(s.withName(name));
    }

    public boolean isRedHaired() {
        return hairColor.isRedHaired();
    }

    public boolean hasLongName() {
        return s.name.length() > 8;
    }

    public boolean isFromUppsala() {
        return new RegularAddress(s.address).isFromUppsala();
    }

    public boolean isTeenager() {
        int years = new Period(s.birthday, new DateMidnight()).getYears();
        return years >= 13 && years <= 19;
    }
}
