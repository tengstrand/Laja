package net.sf.laja.example.repository.behaviour.domain;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.repository.state.AddressState;
import net.sf.laja.example.repository.state.*;
import java.util.Arrays;
import java.util.ArrayList;

public class AddressValueFactory extends AddressValue {

    public AddressValueFactory(AddressState state) {
        super(state);
    }

    public AddressValueFactory(AddressState state, AddressStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

// 2
      // 2.3
    public static AddressCreator.Zipcode_ streetName(String streetName) {
        return new AddressCreator().new StreetName_().streetName(streetName);
    }

    public static AddressBuilder build() {
        return new AddressBuilder();
    }

    public static AddressListCreator createList(AddressEncapsulator... encapsulators) {
        return new AddressListCreator(encapsulators);
    }

    public static class AddressFactory_ implements AddressStateBehaviourFactory {
        private final AddressStateBuilder builder;

        public AddressFactory_(AddressStateBuilder builder) {
            this.builder = builder;
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
