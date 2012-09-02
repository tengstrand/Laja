package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.AccountState;
import net.sf.laja.example.account.state.AccountValue;

public class DestinationAccount extends AccountValue {
    public DestinationAccount(final AccountState state) {
        super(state);
    }

    public void deposit(double amount) {
        state.setBalance(state.getBalance() + amount);
    }

    public void log(String message) {
        System.out.println(message);
    }
}
