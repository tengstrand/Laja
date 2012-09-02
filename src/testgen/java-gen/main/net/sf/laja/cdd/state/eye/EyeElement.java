package net.sf.laja.cdd.state.eye;

public interface EyeElement {
    public void addToList(EyeStateList stateList);
    public void addToList(EyeStateListBuilder listBuilder);
    public void addToList(EyeStateListBuilder listBuilder, Object mutator);
    public void addToList(int index, EyeStateListBuilder listBuilder, Object mutator);
    public void setInList(int index, EyeStateListBuilder listBuilder, Object accessor);
    public boolean removeFromList(EyeStateListBuilder listBuilder, Object mutator);
}
