package net.sf.laja.example.repository;

import com.google.common.collect.ImmutableList;
import net.sf.laja.example.repository.domain.Customer;
import net.sf.laja.example.repository.gui.CustomerInGui;
import net.sf.laja.example.repository.persistence.CustomerRepository;

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
        CustomerInGui customerInGui = new CustomerInGui(customer.s.asMutable());

        customerInGui.setAge("-1");
        System.out.println("Edit in GUI, is valid: " + customerInGui.isValid());
        customerInGui.setAge("20");
        System.out.println("Edit in GUI, is valid: " + customerInGui.isValid());

        // 3. Save to database.
        customer.save();
    }
}
