package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.AccountState;

public class TestAccount extends TestAccountFactory {
    public TestAccount(AccountState state) {
        super(state);
    }

    // (factory)
    public TestAccount asTestAccount() {
        return new TestAccount(state);
    }

    public SourceAccount asSourceAccount() {
        return new SourceAccount(state);
    }

    public DestinationAccount asDestinationAccount() {
        return new DestinationAccount(state);
    }

    public double balance() {
        return state.getBalance();
    }
}
