package net.sf.laja.example.repository.persistence;

import net.sf.laja.example.repository.state.CustomerState;

import static net.sf.laja.example.repository.domain.CustomerCreator.CustomerBehaviour;

public class CustomerMatcher extends CustomerBehaviour {
    public CustomerMatcher(CustomerState state) {
        super(state);
    }

    public boolean hasMatchingSurname(String surname) {
        return state.surname.equals(surname);
    }
}
