package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.AccountState;

/**
 * Factory class for SourceAccount and DestinationAccount.
 */
public class Account extends AccountFactory {
    public Account(AccountState state) {
        super(state);
    }

    // (factory)
    public SourceAccount asSourceAccount() {
        return new SourceAccount(state);
    }

    // (factory)
    public DestinationAccount asDestinationAccount() {
        return new DestinationAccount(state);
    }
}
