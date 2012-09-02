package net.sf.laja.cdd.state.mouth;

public interface MouthElement {
    public void addToList(MouthStateList stateList);
    public void addToList(MouthStateListBuilder listBuilder);
    public void addToList(MouthStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, MouthStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, MouthStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(MouthStateListBuilder listBuilder, Object mutator);
}
