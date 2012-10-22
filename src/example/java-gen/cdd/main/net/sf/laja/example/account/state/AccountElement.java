package net.sf.laja.example.account.state;

public interface AccountElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(AccountStateList stateList);
    void addToList(AccountStateList stateList);
}
