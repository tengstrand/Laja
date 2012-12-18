package net.sf.laja.cdd.behaviour.foot;

import java.util.*;
import net.sf.laja.cdd.state.foot.*;
import net.sf.laja.cdd.behaviour.toe.ToeArrayList;
import net.sf.laja.cdd.behaviour.toe.ToeList;
import net.sf.laja.cdd.state.foot.FootState;
import net.sf.laja.cdd.state.toe.ToeStateList;

public class FootListEncapsulator implements Iterable<FootEncapsulator> {
    public FootStateListBuilder stateListBuilder = new FootStateListBuilder();
    private List<FootEncapsulator> encapsulators = new ArrayList<FootEncapsulator>();

    public void add(FootEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public FootListEncapsulator(FootEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (FootEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<FootEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public FootList asFootList() {
        List<Foot> result = new ArrayList<Foot>();

        for (FootEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asFoot());
        }
        return new FootArrayList(result);
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
        return stateListBuilder.toString();
    }
}
