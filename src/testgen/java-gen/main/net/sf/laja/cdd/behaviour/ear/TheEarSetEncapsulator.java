package net.sf.laja.cdd.behaviour.ear;

import java.util.*;
import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class TheEarSetEncapsulator implements Iterable<TheEarEncapsulator> {
    public EarStateSetBuilder stateSetBuilder = new EarStateSetBuilder();
    private List<TheEarEncapsulator> encapsulators = new ArrayList<TheEarEncapsulator>();

    public void add(TheEarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public TheEarSetEncapsulator(TheEarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TheEarEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TheEarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TheEarSet asTheEarSet() {
        List<TheEar> result = new ArrayList<TheEar>();

        for (TheEarEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTheEar());
        }
        return new TheEarHashSet(result);
    }

    public boolean isValid() {
        for (TheEarEncapsulator encapsulator : encapsulators) {
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
