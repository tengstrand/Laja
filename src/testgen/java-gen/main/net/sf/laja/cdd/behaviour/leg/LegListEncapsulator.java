package net.sf.laja.cdd.behaviour.leg;

import java.util.*;
import net.sf.laja.cdd.state.leg.*;
import net.sf.laja.cdd.state.leg.LegState;

public class LegListEncapsulator implements Iterable<LegEncapsulator> {
    public LegStateListBuilder stateListBuilder = new LegStateListBuilder();
    private List<LegEncapsulator> encapsulators = new ArrayList<LegEncapsulator>();

    public void add(LegEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public LegListEncapsulator(LegEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (LegEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
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

    @Override
    public String toString() {
        return stateListBuilder.toString();
    }
}
