package net.sf.laja.example.account.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.account.state.*;
import java.util.Arrays;
import net.sf.laja.example.account.state.AccountState;
import java.util.ArrayList;

public class TestAccountFactory extends AccountBehaviour {

    public TestAccountFactory(AccountState state) {
        super(state);
    }

    public static TestAccountEncapsulator balance(double balance) {
        return new TestAccountCreator().new Balance_().balance(balance);
    }

    public static TestAccountBuilder build() {
        return new TestAccountBuilder();
    }

    public static TestAccountSetEncapsulator createSet(TestAccountEncapsulator... encapsulators) {
        return new TestAccountSetEncapsulator(encapsulators);
    }

    public static TestAccountListEncapsulator createList(TestAccountEncapsulator... encapsulators) {
        return new TestAccountListEncapsulator(encapsulators);
    }

    public static class TestAccountFactory_ implements AccountBehaviourFactory {
        private final AccountStateBuilder stateBuilder;

        public TestAccountFactory_(AccountStateBuilder stateBuilder) {
            this.stateBuilder = stateBuilder;
        }

        public Object create(AccountState state, Object... args) {
            Object result = create_(state, args);

            if (!state.isValidAsEncapsulated()) {
                throw new IllegalStateException("Illegal state, could not create behaviour class 'TestAccount'");
            }
            state.encapsulate();

            return result;
        }

      private Object create_(AccountState state, Object... args) {
        return new TestAccount(state);
    
      }
    }
}
