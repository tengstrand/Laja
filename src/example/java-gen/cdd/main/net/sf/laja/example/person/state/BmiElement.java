package net.sf.laja.example.person.state;

public interface BmiElement {
    public void addToList(BmiStateList stateList);
    public void addToList(BmiStateListBuilder listBuilder);
    public void addToList(BmiStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, BmiStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, BmiStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(BmiStateListBuilder listBuilder, Object mutator);
}
