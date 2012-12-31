package net.sf.laja.example.account.state;

import net.sf.laja.example.account.state.Certificate;

import java.util.ArrayList;
import java.util.List;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public final class AccountStateListBuilder {
    private final Certificate certificate;
    private final AccountStateList states;

    public AccountStateListBuilder() {
        certificate = Certificate.get(new AccountStateImpl());
        states = AccountStateListImpl.emptyList();
    }

    public AccountStateListBuilder(AccountStateList states) {
        this.states = states;
        certificate = Certificate.get(new AccountStateImpl());
    }

    public AccountStateList getStateList(Certificate certificate) {
        return states;
    }

    public List<AccountStateBuilder> getStateBuilders() {
        List<AccountStateBuilder> builders = new ArrayList<AccountStateBuilder>(states.size());

        for (AccountState state : states) {
            builders.add(new AccountStateBuilderImpl(state));
        }
        return builders;
    }

    public int size() {
        return states.size();
    }

    public void clear() {
        states.clear();
    }

    public void add(AccountStateBuilder builder) {
        states.add(builder.getAccountState(certificate));
    }

    public void add(AccountState state) {
        states.add(state);
    }

    public void add(int index, AccountState state) {
        states.add(index, state);
    }

    public void addAll(int index, AccountStateListBuilder listBuilder) {
        states.addAll(index, listBuilder.states);
    }

    public void set(int index, AccountState state) {
        states.set(index, state);
    }

    public boolean remove(AccountState state) {
        return states.remove(state);
    }

    public void remove(int index) {
        states.remove(index);
    }

    public void retainAll(AccountStateListBuilder retainStates) {
        states.retainAll(retainStates.states);
    }

    @Override
    public String toString() {
        return "AccountStateListBuilder{" + states + "}";
    }
}
