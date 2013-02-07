package net.sf.laja.cdd.behaviour.xhand;

import java.util.*;
import net.sf.laja.cdd.state.xhand.*;
import net.sf.laja.cdd.state.xhand.XHandState;
import net.sf.laja.cdd.state.finger.FingerState;
import net.sf.laja.cdd.state.nail.NailState;

public class XHandSetEncapsulator implements Iterable<XHandEncapsulator> {
    public XHandStateSetBuilder stateSetBuilder = new XHandStateSetBuilder();
    private List<XHandEncapsulator> encapsulators = new ArrayList<XHandEncapsulator>();

    public void add(XHandEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public XHandSetEncapsulator(XHandEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (XHandEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<XHandEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public XHandSet asXHandSet() {
        List<XHand> result = new ArrayList<XHand>();

        for (XHandEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asXHand());
        }
        return new XHandHashSet(result);
    }

    public boolean isValid() {
        for (XHandEncapsulator encapsulator : encapsulators) {
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
