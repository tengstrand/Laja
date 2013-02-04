package net.sf.laja.cdd.behaviour.finger;

import java.util.*;
import net.sf.laja.cdd.state.finger.*;
import net.sf.laja.cdd.state.finger.FingerState;
import net.sf.laja.cdd.state.nail.NailState;

public class FingerListEncapsulator implements Iterable<FingerEncapsulator> {
    public FingerStateListBuilder stateListBuilder = new FingerStateListBuilder();
    private List<FingerEncapsulator> encapsulators = new ArrayList<FingerEncapsulator>();

    public void add(FingerEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public FingerListEncapsulator(FingerEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (FingerEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<FingerEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public FingerList asFingerList() {
        List<Finger> result = new ArrayList<Finger>();

        for (FingerEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asFinger());
        }
        return new FingerArrayList(result);
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
        return stateListBuilder.toString();
    }
}
