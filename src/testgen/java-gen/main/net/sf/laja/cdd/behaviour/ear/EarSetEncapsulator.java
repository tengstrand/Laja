package net.sf.laja.cdd.behaviour.ear;

import java.util.*;
import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class EarSetEncapsulator implements Iterable<EarEncapsulator> {
    public EarStateSetBuilder stateSetBuilder = new EarStateSetBuilder();
    private List<EarEncapsulator> encapsulators = new ArrayList<EarEncapsulator>();

    public void add(EarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public EarSetEncapsulator(EarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (EarEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<EarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public EarSet asEarSet() {
        List<Ear> result = new ArrayList<Ear>();

        for (EarEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asEar());
        }
        return new EarHashSet(result);
    }

    public boolean isValid() {
        for (EarEncapsulator encapsulator : encapsulators) {
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
