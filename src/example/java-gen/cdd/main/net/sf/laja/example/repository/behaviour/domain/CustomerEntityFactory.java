package net.sf.laja.example.repository.behaviour.domain;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import java.util.Arrays;
import net.sf.laja.example.repository.state.CustomerState;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import java.util.ArrayList;

public class CustomerEntityFactory extends CustomerEntity {

    public CustomerEntityFactory(CustomerState state) {
        super(state);
    }

    public CustomerEntityFactory(CustomerState state, CustomerStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static CustomerCreator.GivenName_ ssn(long ssn) {
        return new CustomerCreator().new Ssn_().ssn(ssn);
    }

    public static CustomerBuilder build() {
        return new CustomerBuilder();
    }

    public static CustomerListCreator createList(CustomerEncapsulator... encapsulators) {
        return new CustomerListCreator(encapsulators);
    }

    public static class CustomerFactory_ implements CustomerStateBehaviourFactory {
        private final CustomerStateBuilder builder;

        public CustomerFactory_(CustomerStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(CustomerState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'Customer'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(CustomerState state, Object... args) {
        return new Customer(state);
    
      }
    }

    public static class CustomerMatcherFactory_ implements CustomerStateBehaviourFactory {
        private final CustomerStateBuilder builder;

        public CustomerMatcherFactory_(CustomerStateBuilder builder) {
            this.builder = builder;
        }

        public Object create(CustomerState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'CustomerMatcher'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(CustomerState state, Object... args) {
        return new CustomerMatcher(state);
    
      }
    }
}
