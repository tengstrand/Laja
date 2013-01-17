package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.AccountBehaviour;
import net.sf.laja.example.account.state.AccountState;

public class SourceAccount extends AccountBehaviour {
    public SourceAccount(AccountState state) {
        super(state);
    }

    public void transferTo(DestinationAccount destination, double amount) {
        withdraw(amount);
        log("Withdrawing " + amount);
        destination.deposit(amount);
        destination.log("Depositing " + amount);
    }

    private void log(String message) {
        System.out.println(message);
    }

    private void withdraw(double amount) {
        if (state.getBalance() < amount) {
            throw new IllegalStateException("Not enough money on the source account");
        }
        state.setBalance(state.getBalance() - amount, this);
    }
}
