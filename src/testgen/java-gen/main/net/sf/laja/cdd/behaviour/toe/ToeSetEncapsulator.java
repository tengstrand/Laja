package net.sf.laja.cdd.behaviour.toe;

import java.util.*;
import net.sf.laja.cdd.state.toe.*;
import net.sf.laja.cdd.state.toe.ToeState;

public class ToeSetEncapsulator implements Iterable<ToeEncapsulator> {
    public ToeStateSetBuilder stateSetBuilder = new ToeStateSetBuilder();
    private List<ToeEncapsulator> encapsulators = new ArrayList<ToeEncapsulator>();

    public void add(ToeEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public ToeSetEncapsulator(ToeEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (ToeEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<ToeEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public ToeSet asToeSet() {
        List<Toe> result = new ArrayList<Toe>();

        for (ToeEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asToe());
        }
        return new ToeHashSet(result);
    }

    public boolean isValid() {
        for (ToeEncapsulator encapsulator : encapsulators) {
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
