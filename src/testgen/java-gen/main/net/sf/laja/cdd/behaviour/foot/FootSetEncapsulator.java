package net.sf.laja.cdd.behaviour.foot;

import java.util.*;
import net.sf.laja.cdd.state.foot.*;
import net.sf.laja.cdd.behaviour.toe.ToeArrayList;
import net.sf.laja.cdd.behaviour.toe.ToeList;
import net.sf.laja.cdd.behaviour.toe.ValToeList;
import net.sf.laja.cdd.state.foot.FootState;
import net.sf.laja.cdd.state.toe.ToeStateList;

public class FootSetEncapsulator implements Iterable<FootEncapsulator> {
    public FootStateSetBuilder stateSetBuilder = new FootStateSetBuilder();
    private List<FootEncapsulator> encapsulators = new ArrayList<FootEncapsulator>();

    public void add(FootEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public FootSetEncapsulator(FootEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (FootEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<FootEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public FootSet asFootSet() {
        List<Foot> result = new ArrayList<Foot>();

        for (FootEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asFoot());
        }
        return new FootHashSet(result);
    }

    public boolean isValid() {
        for (FootEncapsulator encapsulator : encapsulators) {
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
