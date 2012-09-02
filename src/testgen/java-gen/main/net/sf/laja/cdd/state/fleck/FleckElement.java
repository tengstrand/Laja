package net.sf.laja.cdd.state.fleck;

public interface FleckElement {
    public void addToList(FleckStateList stateList);
    public void addToList(FleckStateListBuilder listBuilder);
    public void addToList(FleckStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, FleckStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, FleckStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(FleckStateListBuilder listBuilder, Object mutator);
}
