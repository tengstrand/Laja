package net.sf.laja.cdd.behaviour.hand;

import java.util.*;
import net.sf.laja.cdd.state.hand.*;
import net.sf.laja.cdd.state.hand.HandState;

public class HandSetEncapsulator implements Iterable<HandEncapsulator> {
    public HandStateSetBuilder stateSetBuilder = new HandStateSetBuilder();
    private List<HandEncapsulator> encapsulators = new ArrayList<HandEncapsulator>();

    public void add(HandEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public HandSetEncapsulator(HandEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (HandEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<HandEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public HandSet asHandSet() {
        List<Hand> result = new ArrayList<Hand>();

        for (HandEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asHand());
        }
        return new HandHashSet(result);
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
        return stateSetBuilder.toString();
    }
}
