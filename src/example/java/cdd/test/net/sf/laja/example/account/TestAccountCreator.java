package net.sf.laja.example.account;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.sf.laja.cdd.annotation.Creator;
import net.sf.laja.cdd.validator.ValidationErrors;
import net.sf.laja.cdd.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.sf.laja.example.account.AccountState.AccountMutableState;
import static net.sf.laja.example.account.AccountState.AccountStringState;

@Creator
public class TestAccountCreator implements TestAccountCreatorMaker {
    private final AccountMutableState state;

    public TestAccount asTestAccount() {
        return new TestAccount(state);
    }

    // ===== Generated code =====

    public static AccountFactory createTestAccount() {
        return new TestAccountCreator(new AccountMutableState()).new AccountFactory();
    }

    public static AccountBuilder buildTestAccount() {
        return new AccountBuilder();
    }

    public static AccountStringBuilder buildStringTestAccount() {
        return new AccountStringBuilder();
    }

    public static AccountListBuilder createTestAccountList(TestAccountCreator... creators) {
        return new AccountListBuilder(creators);
    }

    public static AccountSetBuilder createTestAccountSet(TestAccountCreator... creators) {
        return new AccountSetBuilder(creators);
    }

    public static AccountMapBuilder createTestAccountMap(AccountMapEntryBuilder... builders) {
        return new AccountMapBuilder(builders);
    }

    public static AccountMapEntryBuilder createTestAccountEntry(Object key, TestAccountCreator creator) {
        return new AccountMapEntryBuilder(key, creator);
    }

    public static AccountMapEntryBuilder createTestAccountEntry(Object key, AccountBuilder builder) {
        return new AccountMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class AccountFactory {

        public TestAccountCreator balance(double balance) {
            return new _Balance().balance(balance);
        }

        // balance
        public class _Balance {
            public TestAccountCreator balance(double balance) {
                state.balance = balance;
                return new TestAccountCreator(state);
            }
        }
    }

    // --- Constructor ---

    public TestAccountCreator(AccountMutableState state) {
        this.state = state;
    }

    public AccountState asState() {
        return state.asImmutable();
    }

    public AccountMutableState asMutableState() {
        return state;
    }

        public AccountStringState asStringState() {
            return state.asStringState();
        }

    // --- With methods ---

    // --- Validate ---

    public void assertIsValid() {
        state.assertIsValid();
    }

    public boolean isValid() {
        return state.isValid();
    }

    public ValidationErrors validate(Validator... validators) {
        return state.validate(validators);
    }

    @Override public int hashCode() {
        return state.hashCode();
    }

    @Override public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || !(that instanceof TestAccountCreator)) return false;

        return state.equals(((TestAccountCreator)that).state);
    }

    @Override public String toString() {
        return "TestAccountCreator" + state;
    }

    // --- Behaviour ---

    public static class AccountBehaviour {
        public final AccountState state;

        public AccountBehaviour(AccountState state) {
            this.state = state;
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof AccountBehaviour)) return false;

            return state.equals(((AccountBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- MutableBehaviour ---

    public static class AccountMutableBehaviour {
        private AccountMutableState state;

        public AccountMutableBehaviour(AccountMutableState state) {
            this.state = state;
        }

        public AccountState asState() {
            return state.asImmutable();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof AccountMutableBehaviour)) return false;

            return state.equals(((AccountMutableBehaviour)that).state);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public String toString() {
            return getClass().getSimpleName() + state;
        }
    }

    // --- Builder ---

    public static class AccountBuilder implements TestAccountCreatorMaker {
        private final AccountMutableState state;

        public AccountBuilder() {
            this.state = new AccountMutableState();
        }

        public AccountBuilder(AccountMutableState state) {
            this.state = state;
        }

        public AccountBuilder withBalance(double balance) { state.balance = balance; return this; }

        public TestAccount asTestAccount() {
            return new TestAccount(state);
        }

        public AccountState asState() {
            return state.asImmutable();
        }

        public AccountMutableState asMutableState() {
            return state;
        }

        public AccountStringState asStringState() {
            return state.asStringState();
        }

        public void assertIsValid() {
            state.assertIsValid();
        }

        public boolean isValid() {
            return state.isValid();
        }

        public ValidationErrors validate(Validator... validators) {
            return state.validate(validators);
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof AccountBuilder)) return false;

            return state.equals(((AccountBuilder)that).state);
        }

        @Override public String toString() {
            return "AccountBuilder" + state;
        }
    }

    // --- String builder ---

    public static class AccountStringBuilder {
        private final AccountStringState state;

        public AccountStringBuilder() {
            this.state = new AccountStringState();
        }

        public AccountStringBuilder(AccountStringState state) {
            this.state = state;
        }

        public AccountStringBuilder withBalance(String balance) { state.balance = balance; return this; }

        public TestAccount asTestAccount() {
            return new AccountBuilder(state.asMutable()).asTestAccount();
        }

        public AccountState asState() {
            return state.asImmutable();
        }

        public AccountMutableState asMutableState() {
            return state.asMutable();
        }

        public AccountStringState asStringState() {
            return state;
        }

        @Override public int hashCode() {
            return state.hashCode();
        }

        @Override public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || !(that instanceof AccountStringBuilder)) return false;

            return state.equals(((AccountStringBuilder)that).state);
        }

        @Override public String toString() {
            return "AccountStringBuilder" + state;
        }
    }

    // --- ListBuilder ---

    public static class AccountListBuilder implements Iterable<TestAccountCreator> {
        private List<TestAccountCreator> creators;

        public AccountListBuilder(TestAccountCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public AccountListBuilder(Collection<TestAccountCreator> creators) {
            this.creators = new ArrayList<TestAccountCreator>();
            this.creators.addAll(creators);
        }

        // asTestAccountList() : ImmutableList<TestAccount>

        public ImmutableList<TestAccount> asTestAccountList() {
            ImmutableList.Builder<TestAccount> builder = ImmutableList.builder();

            for (TestAccountCreator creator : creators) {
                builder.add(creator.asTestAccount());
            }
            return builder.build();
        }

        // asTestAccountMutableList() : List<TestAccount>

        public List<TestAccount> asTestAccountMutableList() {
            List<TestAccount> result = new ArrayList<TestAccount>();

            for (TestAccountCreator creator : creators) {
                result.add(creator.asTestAccount());
            }
            return result;
        }

        // asStateList() : ImmutableList<AccountState>

        public ImmutableList<AccountState> asStateList() {
            ImmutableList.Builder<AccountState> builder = ImmutableList.builder();

            for (TestAccountCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<AccountMutableState>

        public List<AccountMutableState> asMutableStateList() {
            List<AccountMutableState> result = new ArrayList<AccountMutableState>();

            for (TestAccountCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<TestAccountCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class AccountSetBuilder implements Iterable<TestAccountCreator> {
        private List<TestAccountCreator> creators;

        public AccountSetBuilder(TestAccountCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public AccountSetBuilder(Collection<TestAccountCreator> creators) {
            this.creators = new ArrayList<TestAccountCreator>();
            this.creators.addAll(creators);
        }

        // asTestAccountSet() : ImmutableSet<TestAccount>

        public ImmutableSet<TestAccount> asTestAccountSet() {
            ImmutableSet.Builder<TestAccount> builder = ImmutableSet.builder();

            for (TestAccountCreator creator : creators) {
                builder.add(creator.asTestAccount());
            }
            return builder.build();
        }

        // asTestAccountMutableSet() : Set<TestAccount>

        public Set<TestAccount> asTestAccountMutableSet() {
            Set<TestAccount> result = new HashSet<TestAccount>();

            for (TestAccountCreator creator : creators) {
                result.add(creator.asTestAccount());
            }
            return result;
        }

        // asState()

        public ImmutableSet<AccountState> asStateSet() {
            ImmutableSet.Builder<AccountState> builder = ImmutableSet.builder();

            for (TestAccountCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<AccountMutableState> asMutableStateSet() {
            Set<AccountMutableState> result = new HashSet<AccountMutableState>();

            for (TestAccountCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<TestAccountCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class AccountMapEntryBuilder {
        private final Object key;
        private final TestAccountCreatorMaker maker;

        public AccountMapEntryBuilder(Object key, TestAccountCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public TestAccount asTestAccount() {
            return maker.asTestAccount();
        }

        public AccountState asState() {
            return maker.asState();
        }

        public AccountMutableState asMutableState() {
            return maker.asMutableState();
        }
    }

    // --- MapBuilder ---

    public static class AccountMapBuilder {
        private final AccountMapEntryBuilder[] entries;

        public AccountMapBuilder(AccountMapEntryBuilder... entries) {
            this.entries = entries;
        }

        // asTestAccountMap() : ImmutableMap

        public ImmutableMap asTestAccountMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AccountMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asTestAccount());
            }
            return builder.build();
        }

        // asTestAccountMutableMap() : Map

        public Map asTestAccountMutableMap() {
            Map result = new HashMap();

            for (AccountMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asTestAccount());
            }
            return result;
        }

        // asStateMap() : ImmutableMap

        public ImmutableMap asStateMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AccountMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asState());
            }
            return builder.build();
        }

        // asMutableStateMap() : Map

        public Map asMutableStateMap() {
            Map result = new HashMap();

            for (AccountMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asMutableState());
            }
            return result;
        }
    }
}

// --- Maker ---

interface TestAccountCreatorMaker {
    TestAccount asTestAccount();

    AccountState asState();
    AccountMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
