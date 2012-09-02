package net.sf.laja.example.account.state;

public interface AccountElement {
    public void addToList(AccountStateList stateList);
    public void addToList(AccountStateListBuilder listBuilder);
    public void addToList(AccountStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, AccountStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, AccountStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(AccountStateListBuilder listBuilder, Object mutator);
}
