package net.sf.laja.example.account;

import static net.sf.laja.example.account.state.AccountState.AccountMutableState;

public class DestinationAccount extends AccountCreator.AccountMutableBehaviour {
    private final AccountMutableState state;

    public DestinationAccount(AccountMutableState state) {
        super(state);
        this.state = state;
    }

    public void deposit(double amount) {
        state.setBalance(state.balance + amount);
    }

    public void log(String message) {
        System.out.println(message);
    }
}
