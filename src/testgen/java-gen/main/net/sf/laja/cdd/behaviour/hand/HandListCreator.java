package net.sf.laja.cdd.behaviour.hand;

import java.util.*;
import net.sf.laja.cdd.state.hand.*;
import net.sf.laja.cdd.state.hand.HandState;

public class HandListCreator implements Iterable<HandEncapsulator> {
    public HandStateListBuilder stateList = new HandStateListBuilder();
    private List<HandEncapsulator> encapsulators = new ArrayList<HandEncapsulator>();

    public void add(HandEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public HandListCreator(HandEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (HandEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<HandEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public HandList asHandList() {
        List<Hand> result = new ArrayList<Hand>();

        for (HandEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asHand());
        }
        return new HandList(result);
    }

    public boolean isValid() {
        for (HandEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
