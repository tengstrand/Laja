package net.sf.laja.example.repository.persistence;

import net.sf.laja.example.repository.state.CustomerState;

import static net.sf.laja.example.repository.domain.CustomerCreator.CustomerBehaviour;

public class CustomerInDb extends CustomerBehaviour {
    public CustomerInDb(CustomerState state) {
        super(state);
    }

    public void save() {
        System.out.println("Saved the customer: " + state);
    }
}
