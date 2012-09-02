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
        public StreetName_ age(int age) {
            builder.withAge(age);
            return new StreetName_();
        }
    }

    public class StreetName_ {
        public Zipcode_ streetName(String streetName) {
            builder.withStreetName(streetName);
            return new Zipcode_();
        }
    }

    public class Zipcode_ {
        public City_ zipcode(int zipcode) {
            builder.withZipcode(zipcode);
            return new City_();
        }
    }

    public class City_ {
        public CustomerEncapsulator city(String city) {
            builder.withCity(city);
            return create();
        }
    }

    public CustomerEncapsulator create() {
        return new CustomerEncapsulator(builder);
     }
}
