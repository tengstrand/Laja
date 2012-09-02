package net.sf.laja.cdd.state.hair;

public interface HairElement {
    public void addToList(HairStateList stateList);
    public void addToList(HairStateListBuilder listBuilder);
    public void addToList(HairStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, HairStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, HairStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(HairStateListBuilder listBuilder, Object mutator);
}
