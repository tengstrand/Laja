package net.sf.laja.example.person.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.PersonState;

public class PersonFactory extends PersonBehaviour {

    public PersonFactory(PersonState state) {
        super(state);
    }

    public static PersonCreator.Surname_ givenName(String givenName) {
        return new PersonCreator().new GivenName_().givenName(givenName);
    }

    public static PersonBuilder build() {
        return new PersonBuilder();
    }

    public static PersonSetEncapsulator createSet(PersonEncapsulator... encapsulators) {
        return new PersonSetEncapsulator(encapsulators);
    }

    public static PersonListEncapsulator createList(PersonEncapsulator... encapsulators) {
        return new PersonListEncapsulator(encapsulators);
    }

    public static class PersonFactory_ implements PersonBehaviourFactory {

        public Object create(PersonState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Person'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(PersonState state, Object... args) {
        return new Person(state);
    
      }
    }
}
