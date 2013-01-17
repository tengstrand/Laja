package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.AccountBehaviour;
import net.sf.laja.example.account.state.AccountState;

public class DestinationAccount extends AccountBehaviour {
    public DestinationAccount(final AccountState state) {
        super(state);
    }

    public void deposit(double amount) {
        state.setBalance(state.getBalance() + amount, this);
    }

    public void log(String message) {
        System.out.println(message);
    }
}
