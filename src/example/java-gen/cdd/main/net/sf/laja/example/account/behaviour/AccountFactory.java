package net.sf.laja.example.account.behaviour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.sf.laja.example.account.state.*;
import net.sf.laja.example.account.state.AccountState;

public class AccountFactory extends AccountBehaviour {

    public AccountFactory(AccountState state) {
        super(state);
    }

    public static AccountEncapsulator balance(double balance) {
        return new AccountCreator().new Balance_().balance(balance);
    }

    public static AccountBuilder build() {
        return new AccountBuilder();
    }

    public static AccountSetEncapsulator createSet(AccountEncapsulator... encapsulators) {
        return new AccountSetEncapsulator(encapsulators);
    }

    public static AccountListEncapsulator createList(AccountEncapsulator... encapsulators) {
        return new AccountListEncapsulator(encapsulators);
    }

    public static class SourceAccountFactory_ implements AccountBehaviourFactory {

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

    public static class DestinationAccountFactory_ implements AccountBehaviourFactory {

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
