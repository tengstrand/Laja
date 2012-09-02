package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class TestAccountEncapsulator {
    public final AccountStateBuilder builder;

    public TestAccountEncapsulator(AccountStateBuilder builder) {
        this.builder = builder;
    }

    public TestAccount asTestAccount() {
        return (TestAccount)builder.as(new TestAccountFactory.TestAccountFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
