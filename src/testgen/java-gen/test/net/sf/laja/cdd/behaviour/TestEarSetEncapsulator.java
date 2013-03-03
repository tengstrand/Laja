package net.sf.laja.cdd.behaviour;

import java.util.*;
import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.state.ear.EarState;

public class TestEarSetEncapsulator implements Iterable<TestEarEncapsulator> {
    public EarStateSetBuilder stateSetBuilder = new EarStateSetBuilder();
    private List<TestEarEncapsulator> encapsulators = new ArrayList<TestEarEncapsulator>();

    public void add(TestEarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public TestEarSetEncapsulator(TestEarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestEarEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TestEarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TestEarSet asTestEarSet() {
        List<TestEar> result = new ArrayList<TestEar>();

        for (TestEarEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTestEar());
        }
        return new TestEarHashSet(result);
    }

    public boolean isValid() {
        for (TestEarEncapsulator encapsulator : encapsulators) {
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
