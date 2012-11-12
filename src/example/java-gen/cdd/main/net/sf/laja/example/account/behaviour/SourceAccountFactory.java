package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.AccountState;
import net.sf.laja.example.account.state.AccountStateBuilder;

public class SourceAccountFactory extends AccountValueFactory {
    public SourceAccountFactory(AccountState state) {
        super(state);
    }

    public SourceAccountFactory(AccountState state, AccountStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
