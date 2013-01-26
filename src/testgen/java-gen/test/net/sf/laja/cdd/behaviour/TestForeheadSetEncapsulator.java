package net.sf.laja.cdd.behaviour;

import java.util.*;
import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;

public class TestForeheadSetEncapsulator implements Iterable<TestForeheadEncapsulator> {
    public ForeheadStateSetBuilder stateSetBuilder = new ForeheadStateSetBuilder();
    private List<TestForeheadEncapsulator> encapsulators = new ArrayList<TestForeheadEncapsulator>();

    public void add(TestForeheadEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public TestForeheadSetEncapsulator(TestForeheadEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestForeheadEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TestForeheadEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TestForeheadSet asTestForeheadSet() {
        List<TestForehead> result = new ArrayList<TestForehead>();

        for (TestForeheadEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTestForehead());
        }
        return new TestForeheadHashSet(result);
    }

    public boolean isValid() {
        for (TestForeheadEncapsulator encapsulator : encapsulators) {
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
