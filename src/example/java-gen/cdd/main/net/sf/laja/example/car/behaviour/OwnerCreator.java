package net.sf.laja.example.car.behaviour;

import net.sf.laja.example.car.state.*;
import net.sf.laja.example.car.state.OwnerState;

public class OwnerCreator {
    private final OwnerStateBuilder builder = OwnerStateImpl.build();

    public class Ssn_ {
        public Name_ ssn(long ssn) {
            builder.withSsn(ssn);
            return new Name_();
        }

        public Name_ ssn(String ssn) {
            builder.withSsn(ssn);
            return new Name_();
        }
    }

    public class Name_ {
        public OwnerEncapsulator name(String name) {
            builder.withName(name);
            return create();
        }
    }

    public OwnerEncapsulator create() {
        return new OwnerEncapsulator(builder);
     }
}
