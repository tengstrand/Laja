package net.sf.laja.example.repository.behaviour.domain;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.state.CustomerState;

public class CustomerCreator {
    private final CustomerStateBuilder builder = CustomerStateImpl.build();

    public class Ssn_ {
        public GivenName_ ssn(long ssn) {
            builder.withSsn(ssn);
            return new GivenName_();
        }
    }

    public class GivenName_ {
        public Age_ givenName(String givenName) {
            builder.withGivenName(givenName);
            return new Age_();
        }
    }

    public class Age_ {
        public Address_ age(int age) {
            builder.withAge(age);
            return new Address_();
        }
    }

    public class Address_ {
        public CustomerEncapsulator address(AddressEncapsulator address) {
            builder.withAddress(address.builder);
            return create();
        }
    }

    public CustomerEncapsulator create() {
        return new CustomerEncapsulator(builder);
     }
}
