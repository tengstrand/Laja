package net.sf.laja.example.person.behaviour;

import net.sf.laja.example.person.state.*;
import net.sf.laja.example.person.state.PersonState;

public class PersonCreator {
    private final PersonStateBuilder builder = PersonStateImpl.build();

    public class GivenName_ {
        public Surname_ givenName(String givenName) {
            builder.withGivenName(givenName);
            return new Surname_();
        }
    }

    public class Surname_ {
        public WeightInKilograms_ surname(String surname) {
            builder.withSurname(surname);
            return new WeightInKilograms_();
        }
    }

    public class WeightInKilograms_ {
        public Height_ weightInKilograms(int weightInKilograms) {
            builder.withWeightInKilograms(weightInKilograms);
            return new Height_();
        }
    }

    public class Height_ {
        public PersonEncapsulator height(HeightEncapsulator height) {
            builder.withHeight(height.builder);
            return create();
        }
    }

    public PersonEncapsulator create() {
        return new PersonEncapsulator(builder);
     }
}
