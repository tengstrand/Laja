package net.sf.laja.example.account.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.account.state.*;
import java.util.Arrays;
import net.sf.laja.example.account.state.AccountState;
import java.util.ArrayList;

public class AccountValueFactory extends AccountValue {

    public AccountValueFactory(AccountState state) {
        super(state);
    }

    public AccountValueFactory(AccountState state, AccountStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

  // 1
    public static AccountEncapsulator balance(double balance) {
        return new AccountCreator().new Balance_().balance(balance);
    }

    public static AccountBuilder build() {
        return new AccountBuilder();
    }

    public static AccountListCreator createList(AccountEncapsulator... encapsulators) {
        return new AccountListCreator(encapsulators);
    }

    public static class SourceAccountFactory_ implements AccountStateBehaviourFactory {
        private final AccountStateBuilder builder;

        public SourceAccountFactory_(AccountStateBuilder builder) {
            this.builder = builder;
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
        private final AccountStateBuilder builder;

        public DestinationAccountFactory_(AccountStateBuilder builder) {
            this.builder = builder;
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
