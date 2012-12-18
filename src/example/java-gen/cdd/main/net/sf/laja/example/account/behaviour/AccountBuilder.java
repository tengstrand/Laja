package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class AccountBuilder {
    public final AccountStateBuilder builder;

    public AccountBuilder() {
        builder = AccountStateImpl.build();
    }

    public AccountBuilder(AccountState state) {
        builder = new AccountStateBuilderImpl(state);
    }

    public AccountBuilder(AccountState state, Object encapsulator) {
        builder = new AccountStateBuilderImpl(state, encapsulator);
    }

    public AccountBuilder withBalance(double balance) {
        builder.withBalance(balance);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public SourceAccount asSourceAccount() {
        return (SourceAccount)builder.as(new AccountFactory.SourceAccountFactory_(builder));
    }

    public DestinationAccount asDestinationAccount() {
        return (DestinationAccount)builder.as(new AccountFactory.DestinationAccountFactory_(builder));
    }
}
