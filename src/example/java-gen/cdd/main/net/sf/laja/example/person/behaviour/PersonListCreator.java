package net.sf.laja.example.person.behaviour;

import java.util.*;
import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.PersonState;

public class PersonListCreator implements Iterable<PersonEncapsulator> {
    public PersonStateListBuilder stateList = new PersonStateListBuilder();
    private List<PersonEncapsulator> encapsulators = new ArrayList<PersonEncapsulator>();

    public void add(PersonEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public PersonListCreator(PersonEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (PersonEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<PersonEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public PersonList asPersonList() {
        List<Person> result = new ArrayList<Person>();

        for (PersonEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asPerson());
        }
        return new PersonArrayList(result);
    }

    public boolean isValid() {
        for (PersonEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
