package net.sf.laja.example.person.behaviour;

import java.util.*;
import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.PersonState;

public class PersonSetEncapsulator implements Iterable<PersonEncapsulator> {
    public PersonStateSetBuilder stateSetBuilder = new PersonStateSetBuilder();
    private List<PersonEncapsulator> encapsulators = new ArrayList<PersonEncapsulator>();

    public void add(PersonEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public PersonSetEncapsulator(PersonEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (PersonEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<PersonEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public PersonSet asPersonSet() {
        List<Person> result = new ArrayList<Person>();

        for (PersonEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asPerson());
        }
        return new PersonHashSet(result);
    }

    public boolean isValid() {
        for (PersonEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return stateSetBuilder.toString();
    }
}
