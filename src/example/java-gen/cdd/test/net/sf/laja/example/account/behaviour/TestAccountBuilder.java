package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class TestAccountBuilder {
    public final AccountStateBuilder builder;

    public TestAccountBuilder() {
        builder = AccountStateImpl.build();
    }

    public TestAccountBuilder(AccountState state) {
        builder = new AccountStateBuilderImpl(state);
    }

    public TestAccountBuilder(AccountState state, Object encapsulator) {
        builder = new AccountStateBuilderImpl(state, encapsulator);
    }

    public TestAccountBuilder withBalance(double balance) {
        builder.withBalance(balance);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public TestAccount asTestAccount() {
        return (TestAccount)builder.as(new TestAccountFactory.TestAccountFactory_());
    }
}
