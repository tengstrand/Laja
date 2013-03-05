package net.sf.laja.cdd.behaviour.forehead;

import java.util.*;
import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;

public class ForeheadSetEncapsulator implements Iterable<ForeheadEncapsulator> {
    public ForeheadStateSetBuilder stateSetBuilder = new ForeheadStateSetBuilder();
    private List<ForeheadEncapsulator> encapsulators = new ArrayList<ForeheadEncapsulator>();

    public void add(ForeheadEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public ForeheadSetEncapsulator(ForeheadEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (ForeheadEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<ForeheadEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public ForeheadSet asForeheadSet() {
        List<Forehead> result = new ArrayList<Forehead>();

        for (ForeheadEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asForehead());
        }
        return new ForeheadHashSet(result);
    }

    public ForeheadWithBigBrowsSet asForeheadWithBigBrowsSet() {
        List<ForeheadWithBigBrows> result = new ArrayList<ForeheadWithBigBrows>();

        for (ForeheadEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asForeheadWithBigBrows());
        }
        return new ForeheadWithBigBrowsHashSet(result);
    }

    public boolean isValid() {
        for (ForeheadEncapsulator encapsulator : encapsulators) {
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
