package net.sf.laja.cdd;

import net.sf.laja.cdd.state.PersonState;
import org.joda.time.DateMidnight;
import org.joda.time.Period;

public class Person {
    public PersonState state;

    public Person(PersonState state) {
        state.assertIsValid();
        this.state = state;
    }

    public void setName(String name) {
        state = state.withName(name);
    }

    public boolean hasLongName() {
        return state.name.length() > 8;
    }

    public boolean isFromUppsala() {
        return new DefaultAddress(state.address).isFromUppsala();
    }

    public boolean isAdult() {
        return new Period(state.birthday, new DateMidnight()).getYears() >= 18;
    }

    @Override public boolean equals(Object o) { return state.equals(o); }
    @Override public int hashCode() { return state.hashCode(); }
    @Override public String toString() { return getClass().getSimpleName() + state; }
}
