package net.sf.laja.example.person.behaviour;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import net.sf.laja.example.person.state.*;
import java.util.ArrayList;
import net.sf.laja.example.person.state.PersonState;

public class PersonValueFactory extends PersonValue {

    public PersonValueFactory(PersonState state) {
        super(state);
    }

    public PersonValueFactory(PersonState state, PersonStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static PersonCreator.Surname_ givenName(String givenName) {
        return new PersonCreator().new GivenName_().givenName(givenName);
    }

    public static PersonBuilder build() {
        return new PersonBuilder();
    }

    public static PersonListEncapsulator createList(PersonEncapsulator... encapsulators) {
        return new PersonListEncapsulator(encapsulators);
    }

    public static class PersonFactory_ implements PersonStateBehaviourFactory {
        private final PersonStateBuilder stateBuilder;

        public PersonFactory_(PersonStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

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
