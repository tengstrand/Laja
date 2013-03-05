package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;
// Account

public class TestAccountEncapsulator implements AccountStateComparable {
    public final AccountStateBuilder builder;

    public TestAccountEncapsulator(AccountStateBuilder builder) {
        this.builder = builder;
    }

    public TestAccount asTestAccount() {
        return (TestAccount)builder.as(new TestAccountFactory.TestAccountFactory_());
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
