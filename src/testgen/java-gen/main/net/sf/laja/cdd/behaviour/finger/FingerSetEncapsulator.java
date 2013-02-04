package net.sf.laja.cdd.behaviour.finger;

import java.util.*;
import net.sf.laja.cdd.state.finger.*;
import net.sf.laja.cdd.state.finger.FingerState;
import net.sf.laja.cdd.state.nail.NailState;

public class FingerSetEncapsulator implements Iterable<FingerEncapsulator> {
    public FingerStateSetBuilder stateSetBuilder = new FingerStateSetBuilder();
    private List<FingerEncapsulator> encapsulators = new ArrayList<FingerEncapsulator>();

    public void add(FingerEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public FingerSetEncapsulator(FingerEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (FingerEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<FingerEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public FingerSet asFingerSet() {
        List<Finger> result = new ArrayList<Finger>();

        for (FingerEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asFinger());
        }
        return new FingerHashSet(result);
    }

    public boolean isValid() {
        for (FingerEncapsulator encapsulator : encapsulators) {
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
