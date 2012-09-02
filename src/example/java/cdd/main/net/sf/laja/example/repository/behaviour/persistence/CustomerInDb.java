package net.sf.laja.example.repository.behaviour.persistence;

import net.sf.laja.example.repository.state.CustomerState;
import net.sf.laja.example.repository.state.CustomerValue;

public class CustomerInDb extends CustomerValue {
    public CustomerInDb(CustomerState state,  Object... args) {
        super(state);
    }

    public void save() {
        System.out.println("Saved the customer: " + state);
    }
}
