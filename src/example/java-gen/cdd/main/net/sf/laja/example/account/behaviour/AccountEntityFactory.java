package net.sf.laja.example.account.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.account.state.*;
import java.util.Arrays;
import net.sf.laja.example.account.state.AccountState;
import java.util.ArrayList;

public class AccountEntityFactory extends AccountEntity {

    public AccountEntityFactory(AccountState state) {
        super(state);
    }

    public AccountEntityFactory(AccountState state, AccountStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

    public static AccountEncapsulator balance(double balance) {
        return new AccountCreator().new Balance_().balance(balance);
    }

    public static AccountBuilder build() {
        return new AccountBuilder();
    }

    public static AccountListEncapsulator createList(AccountEncapsulator... encapsulators) {
        return new AccountListEncapsulator(encapsulators);
    }

    public static class SourceAccountFactory_ implements AccountStateBehaviourFactory {
        private final AccountStateBuilder stateBuilder;

        public SourceAccountFactory_(AccountStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(AccountState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'SourceAccount'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(AccountState state, Object... args) {
        return new SourceAccount(state);
    
      }
    }

    public static class DestinationAccountFactory_ implements AccountStateBehaviourFactory {
        private final AccountStateBuilder stateBuilder;

        public DestinationAccountFactory_(AccountStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(AccountState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'DestinationAccount'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(AccountState state, Object... args) {
        return new DestinationAccount(state);
    
      }
    }
}
