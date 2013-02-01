package net.sf.laja.cdd.behaviour.forehead;

import java.util.*;
import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.behaviour.brow.Brow;
import net.sf.laja.cdd.behaviour.brow.BrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.ear.EarStateSet;

public class ForeheadListEncapsulator implements Iterable<ForeheadEncapsulator> {
    public ForeheadStateListBuilder stateListBuilder = new ForeheadStateListBuilder();
    private List<ForeheadEncapsulator> encapsulators = new ArrayList<ForeheadEncapsulator>();

    public void add(ForeheadEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public ForeheadListEncapsulator(ForeheadEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (ForeheadEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<ForeheadEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public ForeheadList asForeheadList() {
        List<Forehead> result = new ArrayList<Forehead>();

        for (ForeheadEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asForehead());
        }
        return new ForeheadArrayList(result);
    }

    public ForeheadWithBigBrowsList asForeheadWithBigBrowsList() {
        List<ForeheadWithBigBrows> result = new ArrayList<ForeheadWithBigBrows>();

        for (ForeheadEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asForeheadWithBigBrows());
        }
        return new ForeheadWithBigBrowsArrayList(result);
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
        return stateListBuilder.toString();
    }
}
