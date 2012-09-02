package net.sf.laja.example.repository.behaviour.persistence;

import net.sf.laja.example.repository.state.CustomerState;
import net.sf.laja.example.repository.state.CustomerValue;

public class CustomerMatcher extends CustomerValue {
    public CustomerMatcher(CustomerState state) {
        super(state);
    }

    public boolean hasMatchingSurname(String surname) {
        return state.getSurname().equals(surname);
    }
}
