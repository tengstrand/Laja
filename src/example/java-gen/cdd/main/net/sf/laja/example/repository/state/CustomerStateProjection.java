package net.sf.laja.example.repository.state;

import net.sf.laja.example.repository.state.AddressStateList;
import net.sf.laja.example.repository.state.AddressStateArrayList;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class CustomerStateProjection {

    CustomerStateProjection() {
    }

    public static CustomerStateProjection.GivenName_ ssn(long ssn) {
        return new CustomerStateProjection().new GivenName_();
    }

    public class Ssn_ {
        public GivenName_ ssn(long ssn) {
            return new GivenName_();
        }
    }

    public class GivenName_ {
        public Surname_ givenName(String givenName) {
            return new Surname_();
        }
    }

    public class Surname_ {
        public Age_ surname(String surname) {
            return new Age_();
        }
    }

    public class Age_ {
        public Pet_ age(int age) {
            return new Pet_();
        }
    }

    public class Pet_ {
        public AddressId_ pet(String pet) {
            return new AddressId_();
        }
    }

    public class AddressId_ {
        public StreetName_ addressId(int addressId) {
            return new StreetName_();
        }
    }

    public class StreetName_ {
        public Zipcode_ streetName(String streetName) {
            return new Zipcode_();
        }
    }

    public class Zipcode_ {
        public City_ zipcode(int zipcode) {
            return new City_();
        }
    }

    public class City_ {
        public OldAddresses_ city(String city) {
            return new OldAddresses_();
        }
    }

    public class OldAddresses_ {
        public CustomerStateProjection oldAddresses(AddressStateList oldAddresses) {
            return CustomerStateProjection.this;
        }
    }
}
