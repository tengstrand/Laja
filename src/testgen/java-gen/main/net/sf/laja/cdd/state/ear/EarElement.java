package net.sf.laja.cdd.state.ear;

public interface EarElement {
    public void addToList(EarStateList stateList);
    public void addToList(EarStateListBuilder listBuilder);
    public void addToList(EarStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, EarStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, EarStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(EarStateListBuilder listBuilder, Object mutator);
}
