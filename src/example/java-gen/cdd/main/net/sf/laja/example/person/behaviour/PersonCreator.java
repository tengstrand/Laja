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
        public Size_ surname(String surname) {
            builder.withSurname(surname);
            return new Size_();
        }
    }

    public class Size_ {
        public PersonEncapsulator size(BodyMassIndexEncapsulator size) {
            builder.withSize(size.builder);
            return create();
        }
    }

    public PersonEncapsulator create() {
        return new PersonEncapsulator(builder);
     }
}
