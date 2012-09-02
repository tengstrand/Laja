package net.sf.laja.cdd.state.animal;

public interface AnimalElement {
    public void addToList(AnimalStateList stateList);
    public void addToList(AnimalStateListBuilder listBuilder);
    public void addToList(AnimalStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, AnimalStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, AnimalStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(AnimalStateListBuilder listBuilder, Object mutator);
}
