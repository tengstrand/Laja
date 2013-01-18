package net.sf.laja.example.repository.behaviour.persistence;

import net.sf.laja.example.repository.state.CustomerBehaviour;
import net.sf.laja.example.repository.state.CustomerState;

public class CustomerInDb extends CustomerBehaviour {
    public CustomerInDb(CustomerState state,  Object... args) {
        super(state);
    }

    public void save() {
        System.out.println("Saved the customer: " + state);
    }
}
