package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.state.forehead.ForeheadStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForeheadListEncapsulator implements Iterable<ForeheadEncapsulator> {
    public ForeheadStateListBuilder stateList = new ForeheadStateListBuilder();
    private List<ForeheadEncapsulator> encapsulators = new ArrayList<ForeheadEncapsulator>();

    public void add(ForeheadEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public ForeheadListEncapsulator(ForeheadEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (ForeheadEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
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

    public boolean isValid() {
        for (ForeheadEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
