package net.sf.laja.example.person.state;

public interface HeightElement {
    public void addToList(HeightStateList stateList);
    public void addToList(HeightStateListBuilder listBuilder);
    public void addToList(HeightStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, HeightStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, HeightStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(HeightStateListBuilder listBuilder, Object mutator);
}
