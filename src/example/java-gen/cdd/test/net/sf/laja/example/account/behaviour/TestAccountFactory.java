package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.AccountState;
import net.sf.laja.example.account.state.AccountStateBuilder;

public class TestAccountFactory extends TestAccountValueFactory {
    public TestAccountFactory(AccountState state) {
        super(state);
    }

    public TestAccountFactory(AccountState state, AccountStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
