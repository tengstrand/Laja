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
        public HeightInCentimeters_ surname(String surname) {
            builder.withSurname(surname);
            return new HeightInCentimeters_();
        }
    }

    public class HeightInCentimeters_ {
        public WeightInKilograms_ heightInCentimeters(int heightInCentimeters) {
            builder.withHeightInCentimeters(heightInCentimeters);
            return new WeightInKilograms_();
        }
    }

    public class WeightInKilograms_ {
        public PersonEncapsulator weightInKilograms(int weightInKilograms) {
            builder.withWeightInKilograms(weightInKilograms);
            return create();
        }
    }

    public PersonEncapsulator create() {
        return new PersonEncapsulator(builder);
     }
}
