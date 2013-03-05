package net.sf.laja.example.repository.behaviour.domain;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.repository.state.AddressState;
import net.sf.laja.example.repository.state.*;
import java.util.Arrays;
import java.util.ArrayList;

public class AddressFactory extends AddressBehaviour {

    public AddressFactory(AddressState state) {
        super(state);
    }

    public static AddressCreator.Zipcode_ streetName(String streetName) {
        return new AddressCreator().new StreetName_().streetName(streetName);
    }

    public static AddressBuilder build() {
        return new AddressBuilder();
    }

    public static AddressSetEncapsulator createSet(AddressEncapsulator... encapsulators) {
        return new AddressSetEncapsulator(encapsulators);
    }

    public static AddressListEncapsulator createList(AddressEncapsulator... encapsulators) {
        return new AddressListEncapsulator(encapsulators);
    }

    public static class AddressFactory_ implements AddressBehaviourFactory {
        private final AddressStateBuilder stateBuilder;

        public AddressFactory_(AddressStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(AddressState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Address'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(AddressState state, Object... args) {
        return new Address(state);
    
      }
    }
}
