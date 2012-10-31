package net.sf.laja.cdd.state.hair;

public interface HairElement {
    HairState getState(HairStateList stateList);
    boolean contains(HairStateList stateList);
    void addToList(HairStateList stateList);
}
