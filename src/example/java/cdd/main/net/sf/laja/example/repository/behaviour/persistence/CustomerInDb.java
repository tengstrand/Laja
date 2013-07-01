package net.sf.laja.example.repository.behaviour.persistence;

import net.sf.laja.example.repository.state.CustomerState;

import static net.sf.laja.example.repository.behaviour.domain.CustomerCreator.CustomerBehaviour;

public class CustomerInDb extends CustomerBehaviour {
    public CustomerInDb(CustomerState state) {
        super(state);
    }

    public void save() {
        System.out.println("Saved the customer: " + s);
    }
}
