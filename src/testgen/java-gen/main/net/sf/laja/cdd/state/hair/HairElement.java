package net.sf.laja.cdd.state.hair;

public interface HairElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(HairStateList stateList);
    void addToList(HairStateList stateList);
}
