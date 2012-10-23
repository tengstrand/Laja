package net.sf.laja.cdd.behaviour.hand;

import java.util.List;
import net.sf.laja.cdd.state.hand.HandStateList;

public class HandList extends HandAbstractList {
    public HandList(Hand... list) {
        super(list);
    }

    public HandList(List<Hand> list) {
        super(list);
    }

    public HandList(HandStateList stateList) {
        super(stateList);
    }
}
