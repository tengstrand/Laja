package net.sf.laja.cdd.behaviour.xhand;

import java.util.*;
import net.sf.laja.cdd.state.xhand.*;
import net.sf.laja.cdd.state.xhand.XHandState;
import net.sf.laja.cdd.state.finger.FingerState;

public class XHandListEncapsulator implements Iterable<XHandEncapsulator> {
    public XHandStateListBuilder stateListBuilder = new XHandStateListBuilder();
    private List<XHandEncapsulator> encapsulators = new ArrayList<XHandEncapsulator>();

    public void add(XHandEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public XHandListEncapsulator(XHandEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (XHandEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<XHandEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public XHandList asXHandList() {
        List<XHand> result = new ArrayList<XHand>();

        for (XHandEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asXHand());
        }
        return new XHandArrayList(result);
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
        return stateListBuilder.toString();
    }
}
