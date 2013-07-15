package net.sf.laja.example.account;

import net.sf.laja.example.account.behaviour.DestinationAccount;
import net.sf.laja.example.account.behaviour.SourceAccount;

import static net.sf.laja.example.account.behaviour.AccountCreator.AccountMutableBehaviour;
import static net.sf.laja.example.account.state.AccountState.AccountMutableState;

public class TestAccount extends AccountMutableBehaviour {
    private final AccountMutableState state;

    public TestAccount(AccountMutableState state) {
        super(state);
        this.state = state;
    }

    public SourceAccount asSourceAccount() {
        return new SourceAccount(state);
    }

    public DestinationAccount asDestinationAccount() {
        return new DestinationAccount(state);
    }

    public double balance() {
        return state.balance;
    }
}
