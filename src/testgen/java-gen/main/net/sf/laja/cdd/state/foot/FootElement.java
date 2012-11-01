package net.sf.laja.cdd.state.foot;

public interface FootElement {
    FootState getState(FootStateList stateList);
    boolean contains(FootStateList stateList);
    void addToList(FootStateList stateList);
}
