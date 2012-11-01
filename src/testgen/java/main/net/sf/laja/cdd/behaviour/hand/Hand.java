package net.sf.laja.cdd.behaviour.hand;

import net.sf.laja.cdd.state.hand.HandState;

public class Hand extends HandFactory implements Comparable<Hand>{
    public Hand(HandState state) {
        super(state);
    }

    // (factory) (list)
    public Hand asHand() {
        return new Hand(state);
    }

    public int compareTo(Hand hand) {
        return state.getArea() - hand.state.getArea();
    }
}
