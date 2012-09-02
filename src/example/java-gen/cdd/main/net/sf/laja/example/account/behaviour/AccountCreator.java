package net.sf.laja.example.account.behaviour;

import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class AccountCreator {
    private final AccountStateBuilder builder = AccountStateImpl.build();

    public class Balance_ {
        public AccountEncapsulator balance(double balance) {
            builder.withBalance(balance);
            return create();
        }
    }

    public AccountEncapsulator create() {
        return new AccountEncapsulator(builder);
     }
}
