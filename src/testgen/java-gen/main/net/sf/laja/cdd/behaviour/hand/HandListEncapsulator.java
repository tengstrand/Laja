package net.sf.laja.cdd.behaviour.hand;

import net.sf.laja.cdd.state.hand.HandStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HandListEncapsulator implements Iterable<HandEncapsulator> {
    public HandStateListBuilder stateList = new HandStateListBuilder();
    private List<HandEncapsulator> encapsulators = new ArrayList<HandEncapsulator>();

    public void add(HandEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public HandListEncapsulator(HandEncapsulator... encapsulators) {
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
}
