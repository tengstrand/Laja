package net.sf.laja.cdd.behaviour.brow;

import java.util.*;
import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class BrowListEncapsulator implements Iterable<BrowEncapsulator> {
    public BrowStateListBuilder stateListBuilder = new BrowStateListBuilder();
    private List<BrowEncapsulator> encapsulators = new ArrayList<BrowEncapsulator>();

    public void add(BrowEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public BrowListEncapsulator(BrowEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (BrowEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
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

    @Override
    public String toString() {
        return stateListBuilder.toString();
    }
}
