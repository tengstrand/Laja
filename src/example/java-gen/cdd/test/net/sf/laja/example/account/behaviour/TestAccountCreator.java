package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class TestAccountCreator {
    private final AccountStateBuilder builder = AccountStateImpl.build();

    public class Balance_ {
        public TestAccountEncapsulator balance(double balance) {
            builder.withBalance(balance);
            return create();
        }
    }

    public TestAccountEncapsulator create() {
        return new TestAccountEncapsulator(builder);
     }
}
