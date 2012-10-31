package net.sf.laja.example.account.state;

public interface AccountElement {
    AccountState getState(AccountStateList stateList);
    boolean contains(AccountStateList stateList);
    void addToList(AccountStateList stateList);
}
