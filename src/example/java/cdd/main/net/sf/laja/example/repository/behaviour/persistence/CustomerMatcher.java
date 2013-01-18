package net.sf.laja.example.repository.behaviour.persistence;

import net.sf.laja.example.repository.state.CustomerBehaviour;
import net.sf.laja.example.repository.state.CustomerState;

public class CustomerMatcher extends CustomerBehaviour {
    public CustomerMatcher(CustomerState state) {
        super(state);
    }

    public boolean hasMatchingSurname(String surname) {
        return state.getSurname().equals(surname);
    }
}
