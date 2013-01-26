package net.sf.laja.cdd.behaviour.leg;

import java.util.*;
import net.sf.laja.cdd.state.leg.*;
import net.sf.laja.cdd.state.leg.LegState;

public class LegSetEncapsulator implements Iterable<LegEncapsulator> {
    public LegStateSetBuilder stateSetBuilder = new LegStateSetBuilder();
    private List<LegEncapsulator> encapsulators = new ArrayList<LegEncapsulator>();

    public void add(LegEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public LegSetEncapsulator(LegEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (LegEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<LegEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public LegSet asLegSet() {
        List<Leg> result = new ArrayList<Leg>();

        for (LegEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asLeg());
        }
        return new LegHashSet(result);
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
        return stateSetBuilder.toString();
    }
}
