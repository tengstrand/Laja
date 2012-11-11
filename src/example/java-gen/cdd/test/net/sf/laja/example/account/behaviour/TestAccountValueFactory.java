package net.sf.laja.example.account.behaviour;

import java.util.List;
import java.util.Iterator;
import net.sf.laja.example.account.state.*;
import java.util.Arrays;
import net.sf.laja.example.account.state.AccountState;
import java.util.ArrayList;

public class TestAccountValueFactory extends AccountValue {

    public TestAccountValueFactory(AccountState state) {
        super(state);
    }

    public TestAccountValueFactory(AccountState state, AccountStateBuilder stateBuilder) {
        super(state, stateBuilder);
    }

  // 1
    public static TestAccountEncapsulator balance(double balance) {
        return new TestAccountCreator().new Balance_().balance(balance);
    }

    public static TestAccountBuilder build() {
        return new TestAccountBuilder();
    }

    public static TestAccountListCreator createList(TestAccountEncapsulator... encapsulators) {
        return new TestAccountListCreator(encapsulators);
    }

    public static class TestAccountFactory_ implements AccountStateBehaviourFactory {
        private final AccountStateBuilder builder;

        public TestAccountFactory_(AccountStateBuilder builder) {
            this.builder = builder;
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
