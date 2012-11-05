package net.sf.laja.cdd.behaviour.leg;

import java.util.*;
import net.sf.laja.cdd.state.leg.*;
import net.sf.laja.cdd.state.leg.LegState;

public class LegListCreator implements Iterable<LegEncapsulator> {
    public LegStateListBuilder stateList = new LegStateListBuilder();
    private List<LegEncapsulator> encapsulators = new ArrayList<LegEncapsulator>();

    public void add(LegEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public LegListCreator(LegEncapsulator... encapsulators) {
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
