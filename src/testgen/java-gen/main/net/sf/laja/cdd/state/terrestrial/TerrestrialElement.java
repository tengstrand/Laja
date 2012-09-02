package net.sf.laja.cdd.state.terrestrial;

public interface TerrestrialElement {
    public void addToList(TerrestrialStateList stateList);
    public void addToList(TerrestrialStateListBuilder listBuilder);
    public void addToList(TerrestrialStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, TerrestrialStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, TerrestrialStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(TerrestrialStateListBuilder listBuilder, Object mutator);
}
