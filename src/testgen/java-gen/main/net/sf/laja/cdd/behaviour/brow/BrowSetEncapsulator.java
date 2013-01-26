package net.sf.laja.cdd.behaviour.brow;

import java.util.*;
import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class BrowSetEncapsulator implements Iterable<BrowEncapsulator> {
    public BrowStateSetBuilder stateSetBuilder = new BrowStateSetBuilder();
    private List<BrowEncapsulator> encapsulators = new ArrayList<BrowEncapsulator>();

    public void add(BrowEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public BrowSetEncapsulator(BrowEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (BrowEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<BrowEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public BrowSet asBrowSet() {
        List<Brow> result = new ArrayList<Brow>();

        for (BrowEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asBrow());
        }
        return new BrowHashSet(result);
    }

    public BigBrowSet asBigBrowSet() {
        List<BigBrow> result = new ArrayList<BigBrow>();

        for (BrowEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asBigBrow());
        }
        return new BigBrowHashSet(result);
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
        return stateSetBuilder.toString();
    }
}
