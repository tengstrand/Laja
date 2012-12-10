package net.sf.laja.cdd.behaviour.head;

import net.sf.laja.cdd.state.head.HeadStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HeadListEncapsulator implements Iterable<HeadEncapsulator> {
    public HeadStateListBuilder stateList = new HeadStateListBuilder();
    private List<HeadEncapsulator> encapsulators = new ArrayList<HeadEncapsulator>();

    public void add(HeadEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public HeadListEncapsulator(HeadEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (HeadEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<HeadEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public HeadList asHeadList() {
        List<Head> result = new ArrayList<Head>();

        for (HeadEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asHead());
        }
        return new HeadArrayList(result);
    }

    public boolean isValid() {
        for (HeadEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
