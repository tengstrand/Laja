package net.sf.laja.example.repository;

import com.google.common.collect.ImmutableList;
import net.sf.laja.example.repository.domain.Customer;
import net.sf.laja.example.repository.persistence.CustomerInDb;
import net.sf.laja.example.repository.persistence.CustomerRepository;

import static net.sf.laja.example.repository.state.CustomerState.CustomerStringState;

public class RepositoryExample {

    /**
     * Example how to work in different architectural layers.
     * We just fake the GUI and DB layer in this example.
     */
    public static void main(String... args) {
        CustomerRepository customerRepository = new CustomerRepository();

        // 1. Get a list of customers from the repository, note that the decision to wrap
        //    the list as Customers is not taken by the repository!
        //    We could have called isValid() before calling asCustomerList() to validate the list
        //    (an IllegalStateException is thrown if the state is invalid when calling asCustomerList).
        ImmutableList<Customer> customers = customerRepository.findBySurname("Karlsson").asCustomerList();

        // 2. Take the first customer and edit it in the GUI.
        Customer customer = customers.get(0);
        CustomerStringState customerInGui = customer.state.asStringState();
        customerInGui.pet = "Cat";

        // 3. Save to database.
        new CustomerInDb(customerInGui.asImmutable()).save();
    }
}
