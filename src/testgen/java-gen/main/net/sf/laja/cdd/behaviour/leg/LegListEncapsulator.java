package net.sf.laja.cdd.behaviour.leg;

import net.sf.laja.cdd.state.leg.LegStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LegListEncapsulator implements Iterable<LegEncapsulator> {
    public LegStateListBuilder stateList = new LegStateListBuilder();
    private List<LegEncapsulator> encapsulators = new ArrayList<LegEncapsulator>();

    public void add(LegEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public LegListEncapsulator(LegEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (LegEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<LegEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public LegList asLegList() {
        List<Leg> result = new ArrayList<Leg>();

        for (LegEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asLeg());
        }
        return new LegArrayList(result);
    }

    public boolean isValid() {
        for (LegEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
