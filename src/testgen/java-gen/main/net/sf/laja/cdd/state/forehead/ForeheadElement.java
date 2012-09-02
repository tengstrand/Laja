package net.sf.laja.cdd.state.forehead;

public interface ForeheadElement {
    public void addToList(ForeheadStateList stateList);
    public void addToList(ForeheadStateListBuilder listBuilder);
    public void addToList(ForeheadStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, ForeheadStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, ForeheadStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(ForeheadStateListBuilder listBuilder, Object mutator);
}
