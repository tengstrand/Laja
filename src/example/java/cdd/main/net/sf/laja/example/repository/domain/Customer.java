package net.sf.laja.example.repository.domain;

import net.sf.laja.example.repository.persistence.CustomerInDb;
import net.sf.laja.example.repository.state.CustomerState;

import static net.sf.laja.example.repository.domain.CustomerCreator.CustomerBehaviour;

public class Customer extends CustomerBehaviour {
    private final Address address;

    public Customer(CustomerState state) {
        super(state);
        address = new Address(state.getAddress());
    }

    /**
     * Its up to the designer of a class to decide if a context should have knowledge about
     * another context. The persistence code is isolated in CustomerInDb, so the code
     * is still quite loose coupled and the save method will increase the readability of the code.
     *
     * We could also have decided to remove this method, but the downside would be code duplication
     * (the statement "new CustomerInDb(customer.state)" will be repeated) leading to less readable code e.g.
     * "new CustomerInDb(customer.state).save()" instead of customer.save().
     */
    public void save() {
        new CustomerInDb(s);
    }
}
