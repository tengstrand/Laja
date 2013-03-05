package net.sf.laja.example.repository.behaviour.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.example.repository.behaviour.gui.CustomerInGui;
import net.sf.laja.example.repository.behaviour.persistence.CustomerInDb;
import net.sf.laja.example.repository.behaviour.persistence.CustomerMatcher;
import net.sf.laja.example.repository.state.*;
import net.sf.laja.example.repository.state.CustomerState;

public class CustomerFactory extends CustomerBehaviour {

    public CustomerFactory(CustomerState state) {
        super(state);
    }

    public static CustomerCreator.GivenName_ ssn(long ssn) {
        return new CustomerCreator().new Ssn_().ssn(ssn);
    }

    public static CustomerBuilder build() {
        return new CustomerBuilder();
    }

    public static CustomerSetEncapsulator createSet(CustomerEncapsulator... encapsulators) {
        return new CustomerSetEncapsulator(encapsulators);
    }

    public static CustomerListEncapsulator createList(CustomerEncapsulator... encapsulators) {
        return new CustomerListEncapsulator(encapsulators);
    }

    public static class CustomerFactory_ implements CustomerBehaviourFactory {

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

    public static class CustomerMatcherFactory_ implements CustomerBehaviourFactory {

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
