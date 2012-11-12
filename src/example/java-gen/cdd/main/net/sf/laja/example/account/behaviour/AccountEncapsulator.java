package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class AccountEncapsulator {
    public final AccountStateBuilder builder;

    public AccountEncapsulator(AccountStateBuilder builder) {
        this.builder = builder;
    }

    public SourceAccount asSourceAccount() {
        return (SourceAccount)builder.as(new SourceAccountFactory.SourceAccountFactory_(builder));
    }

    public DestinationAccount asDestinationAccount() {
        return (DestinationAccount)builder.as(new SourceAccountFactory.DestinationAccountFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
