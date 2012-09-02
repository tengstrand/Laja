package net.sf.laja.example.person.state;

public interface PersonElement {
    public void addToList(PersonStateList stateList);
    public void addToList(PersonStateListBuilder listBuilder);
    public void addToList(PersonStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, PersonStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, PersonStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(PersonStateListBuilder listBuilder, Object mutator);
}
