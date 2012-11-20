package net.sf.laja.cdd.behaviour.brow;

import net.sf.laja.cdd.state.brow.BrowStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BrowListEncapsulator implements Iterable<BrowEncapsulator> {
    public BrowStateListBuilder stateList = new BrowStateListBuilder();
    private List<BrowEncapsulator> encapsulators = new ArrayList<BrowEncapsulator>();

    public void add(BrowEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public BrowListEncapsulator(BrowEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (BrowEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<BrowEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public BrowList asBrowList() {
        List<Brow> result = new ArrayList<Brow>();

        for (BrowEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asBrow());
        }
        return new BrowArrayList(result);
    }

    public boolean isValid() {
        for (BrowEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
