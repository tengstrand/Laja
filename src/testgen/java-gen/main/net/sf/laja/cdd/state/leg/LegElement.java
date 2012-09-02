package net.sf.laja.cdd.state.leg;

public interface LegElement {
    public void addToList(LegStateList stateList);
    public void addToList(LegStateListBuilder listBuilder);
    public void addToList(LegStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, LegStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, LegStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(LegStateListBuilder listBuilder, Object mutator);
}
