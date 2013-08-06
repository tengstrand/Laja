package net.sf.laja.example.account;

import static net.sf.laja.example.account.AccountCreator.AccountMutableBehaviour;
import static net.sf.laja.example.account.AccountState.AccountMutableState;
import static net.sf.laja.example.account.AccountState.BALANCE;

public class SourceAccount extends AccountMutableBehaviour {
    private final AccountMutableState state;

    public SourceAccount(AccountMutableState state) {
        super(state);
        this.state = state;

        assertThat(state.balance >= 0, BALANCE);
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
        if (state.balance < amount) {
            throw new IllegalStateException("Not enough money on the source account");
        }
        state.setBalance(state.balance - amount);
    }
}
