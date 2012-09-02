package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.AccountState;
import net.sf.laja.example.account.state.AccountStateBuilder;

public class AccountFactory extends AccountValueFactory {
    public AccountFactory(AccountState state) {
        super(state);
    }

    public AccountFactory(AccountState state, AccountStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }
}
