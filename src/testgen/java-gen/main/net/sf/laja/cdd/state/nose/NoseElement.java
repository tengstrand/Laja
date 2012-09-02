package net.sf.laja.cdd.state.nose;

public interface NoseElement {
    public void addToList(NoseStateList stateList);
    public void addToList(NoseStateListBuilder listBuilder);
    public void addToList(NoseStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, NoseStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, NoseStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(NoseStateListBuilder listBuilder, Object mutator);
}
