package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class AccountEncapsulator {
    public final AccountStateBuilder builder;

    public AccountEncapsulator(AccountStateBuilder builder) {
        this.builder = builder;
    }

    public SourceAccount asSourceAccount() {
        return (SourceAccount)builder.as(new AccountFactory.SourceAccountFactory_(builder));
    }

    public DestinationAccount asDestinationAccount() {
        return (DestinationAccount)builder.as(new AccountFactory.DestinationAccountFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
