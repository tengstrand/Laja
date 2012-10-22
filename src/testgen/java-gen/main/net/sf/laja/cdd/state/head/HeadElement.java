package net.sf.laja.cdd.state.head;

public interface HeadElement {
    boolean syncState();
    boolean isStateInSync();
    boolean contains(HeadStateList stateList);
    void addToList(HeadStateList stateList);
}
