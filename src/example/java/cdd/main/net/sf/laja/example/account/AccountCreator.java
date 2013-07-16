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

@Creator
public class AccountCreator implements AccountCreatorMaker {
    private final AccountMutableState state;

    public SourceAccount asSourceAccount() {
        return new SourceAccount(state);
    }

    public DestinationAccount asDestinationAccount() {
        return new DestinationAccount(state);
    }

    // ===== Generated code =====

    public static AccountFactory createAccount() {
        return new AccountCreator(new AccountMutableState()).new AccountFactory();
    }

    public static AccountBuilder buildAccount() {
        return new AccountBuilder();
    }

    public static AccountListBuilder createAccountList(AccountCreator... creators) {
        return new AccountListBuilder(creators);
    }

    public static AccountSetBuilder createAccountSet(AccountCreator... creators) {
        return new AccountSetBuilder(creators);
    }

    public static AccountMapBuilder createAccountMap(AccountMapEntryBuilder... builders) {
        return new AccountMapBuilder(builders);
    }

    public static AccountMapEntryBuilder createAccountEntry(Object key, AccountCreator creator) {
        return new AccountMapEntryBuilder(key, creator);
    }

    public static AccountMapEntryBuilder createAccountEntry(Object key, AccountBuilder builder) {
        return new AccountMapEntryBuilder(key, builder);
    }

    // --- Factory ----

    public class AccountFactory {

        public AccountCreator balance(double balance) {
            return new _Balance().balance(balance);
        }

        // balance
        public class _Balance {
            public AccountCreator balance(double balance) {
                state.balance = balance;
                return new AccountCreator(state);
            }
        }
    }

    // --- Constructor ---

    public AccountCreator(AccountMutableState state) {
        this.state = state;
    }

    public AccountState asState() {
        return state.asImmutable();
    }

    public AccountMutableState asMutableState() {
        return state;
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
        if (that == null || !(that instanceof AccountCreator)) return false;

        return state.equals(((AccountCreator)that).state);
    }

    @Override public String toString() {
        return "AccountCreator" + state;
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

    public static class AccountBuilder implements AccountCreatorMaker {
        private final AccountMutableState state;

        public AccountBuilder() {
            this.state = new AccountMutableState();
        }

        public AccountBuilder(AccountMutableState state) {
            this.state = state;
        }

        public AccountBuilder withBalance(double balance) { state.balance = balance; return this; }

        public SourceAccount asSourceAccount() {
            return new SourceAccount(state);
        }

        public DestinationAccount asDestinationAccount() {
            return new DestinationAccount(state);
        }

        public AccountState asState() {
            return state.asImmutable();
        }

        public AccountMutableState asMutableState() {
            return state;
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

    // --- ListBuilder ---

    public static class AccountListBuilder implements Iterable<AccountCreator> {
        private List<AccountCreator> creators;

        public AccountListBuilder(AccountCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public AccountListBuilder(Collection<AccountCreator> creators) {
            this.creators = new ArrayList<AccountCreator>();
            this.creators.addAll(creators);
        }

        // asSourceAccountList() : ImmutableList<SourceAccount>

        public ImmutableList<SourceAccount> asSourceAccountList() {
            ImmutableList.Builder<SourceAccount> builder = ImmutableList.builder();

            for (AccountCreator creator : creators) {
                builder.add(creator.asSourceAccount());
            }
            return builder.build();
        }

        // asSourceAccountMutableList() : List<SourceAccount>

        public List<SourceAccount> asSourceAccountMutableList() {
            List<SourceAccount> result = new ArrayList<SourceAccount>();

            for (AccountCreator creator : creators) {
                result.add(creator.asSourceAccount());
            }
            return result;
        }

        // asDestinationAccountList() : ImmutableList<DestinationAccount>

        public ImmutableList<DestinationAccount> asDestinationAccountList() {
            ImmutableList.Builder<DestinationAccount> builder = ImmutableList.builder();

            for (AccountCreator creator : creators) {
                builder.add(creator.asDestinationAccount());
            }
            return builder.build();
        }

        // asDestinationAccountMutableList() : List<DestinationAccount>

        public List<DestinationAccount> asDestinationAccountMutableList() {
            List<DestinationAccount> result = new ArrayList<DestinationAccount>();

            for (AccountCreator creator : creators) {
                result.add(creator.asDestinationAccount());
            }
            return result;
        }

        // asStateList() : ImmutableList<AccountState>

        public ImmutableList<AccountState> asStateList() {
            ImmutableList.Builder<AccountState> builder = ImmutableList.builder();

            for (AccountCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableStateList() : List<AccountMutableState>

        public List<AccountMutableState> asMutableStateList() {
            List<AccountMutableState> result = new ArrayList<AccountMutableState>();

            for (AccountCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<AccountCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- SetBuilder ---

    public static class AccountSetBuilder implements Iterable<AccountCreator> {
        private List<AccountCreator> creators;

        public AccountSetBuilder(AccountCreator... creators) {
            this.creators = Arrays.asList(creators);
        }

        public AccountSetBuilder(Collection<AccountCreator> creators) {
            this.creators = new ArrayList<AccountCreator>();
            this.creators.addAll(creators);
        }

        // asSourceAccountSet() : ImmutableSet<SourceAccount>

        public ImmutableSet<SourceAccount> asSourceAccountSet() {
            ImmutableSet.Builder<SourceAccount> builder = ImmutableSet.builder();

            for (AccountCreator creator : creators) {
                builder.add(creator.asSourceAccount());
            }
            return builder.build();
        }

        // asSourceAccountMutableSet() : Set<SourceAccount>

        public Set<SourceAccount> asSourceAccountMutableSet() {
            Set<SourceAccount> result = new HashSet<SourceAccount>();

            for (AccountCreator creator : creators) {
                result.add(creator.asSourceAccount());
            }
            return result;
        }

        // asDestinationAccountSet() : ImmutableSet<DestinationAccount>

        public ImmutableSet<DestinationAccount> asDestinationAccountSet() {
            ImmutableSet.Builder<DestinationAccount> builder = ImmutableSet.builder();

            for (AccountCreator creator : creators) {
                builder.add(creator.asDestinationAccount());
            }
            return builder.build();
        }

        // asDestinationAccountMutableSet() : Set<DestinationAccount>

        public Set<DestinationAccount> asDestinationAccountMutableSet() {
            Set<DestinationAccount> result = new HashSet<DestinationAccount>();

            for (AccountCreator creator : creators) {
                result.add(creator.asDestinationAccount());
            }
            return result;
        }

        // asState()

        public ImmutableSet<AccountState> asStateSet() {
            ImmutableSet.Builder<AccountState> builder = ImmutableSet.builder();

            for (AccountCreator creator : creators) {
                builder.add(creator.asState());
            }
            return builder.build();
        }

        // asMutableState()

        public Set<AccountMutableState> asMutableStateSet() {
            Set<AccountMutableState> result = new HashSet<AccountMutableState>();

            for (AccountCreator creator : creators) {
                result.add(creator.asMutableState());
            }
            return result;
        }

        public Iterator<AccountCreator> iterator() {
            return creators.iterator();
        }
    }

    // --- MapEntryBuilder ---

    public static class AccountMapEntryBuilder {
        private final Object key;
        private final AccountCreatorMaker maker;

        public AccountMapEntryBuilder(Object key, AccountCreatorMaker maker) {
            this.key = key;
            this.maker = maker;
        }

        public SourceAccount asSourceAccount() {
            return maker.asSourceAccount();
        }

        public DestinationAccount asDestinationAccount() {
            return maker.asDestinationAccount();
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

        // asSourceAccountMap() : ImmutableMap

        public ImmutableMap asSourceAccountMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AccountMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asSourceAccount());
            }
            return builder.build();
        }

        // asSourceAccountMutableMap() : Map

        public Map asSourceAccountMutableMap() {
            Map result = new HashMap();

            for (AccountMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asSourceAccount());
            }
            return result;
        }

        // asDestinationAccountMap() : ImmutableMap

        public ImmutableMap asDestinationAccountMap() {
            ImmutableMap.Builder builder = ImmutableMap.builder();

            for (AccountMapEntryBuilder entry : entries) {
                builder.put(entry.key, entry.asDestinationAccount());
            }
            return builder.build();
        }

        // asDestinationAccountMutableMap() : Map

        public Map asDestinationAccountMutableMap() {
            Map result = new HashMap();

            for (AccountMapEntryBuilder entry : entries) {
                result.put(entry.key, entry.asDestinationAccount());
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

interface AccountCreatorMaker {
    SourceAccount asSourceAccount();
    DestinationAccount asDestinationAccount();

    AccountState asState();
    AccountMutableState asMutableState();
    void assertIsValid();
    boolean isValid();
    ValidationErrors validate(Validator... validators);
}
