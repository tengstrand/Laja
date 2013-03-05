package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;
// Account

public class AccountEncapsulator implements AccountStateComparable {
    public final AccountStateBuilder builder;

    public AccountEncapsulator(AccountStateBuilder builder) {
        this.builder = builder;
    }

    public SourceAccount asSourceAccount() {
        return (SourceAccount)builder.as(new AccountFactory.SourceAccountFactory_());
    }

    public DestinationAccount asDestinationAccount() {
        return (DestinationAccount)builder.as(new AccountFactory.DestinationAccountFactory_());
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
