package net.sf.laja.cdd.behaviour.hand;

import java.util.*;
import net.sf.laja.cdd.state.hand.*;
import net.sf.laja.cdd.state.hand.HandState;

public class HandListEncapsulator implements Iterable<HandEncapsulator> {
    public HandStateListBuilder stateListBuilder = new HandStateListBuilder();
    private List<HandEncapsulator> encapsulators = new ArrayList<HandEncapsulator>();

    public void add(HandEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public HandListEncapsulator(HandEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (HandEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
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
        return new HandArrayList(result);
    }

    public boolean isValid() {
        for (HandEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return stateListBuilder.toString();
    }
}
