package net.sf.laja.example.repository.behaviour.domain;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.AddressState;

public class AddressCreator {
    private final AddressStateBuilder builder = AddressStateImpl.build();

    public class StreetName_ {
        public Zipcode_ streetName(String streetName) {
            builder.withStreetName(streetName);
            return new Zipcode_();
        }
    }

    public class Zipcode_ {
        public City_ zipcode(ZipcodeEncapsulator zipcode) {
            builder.withZipcode(zipcode.builder);
            return new City_();
        }
    }

    public class City_ {
        public AddressEncapsulator city(String city) {
            builder.withCity(city);
            return create();
        }
    }

    public AddressEncapsulator create() {
        return new AddressEncapsulator(builder);
     }
}
