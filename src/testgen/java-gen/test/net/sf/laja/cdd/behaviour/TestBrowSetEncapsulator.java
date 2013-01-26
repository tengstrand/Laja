package net.sf.laja.cdd.behaviour;

import java.util.*;
import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class TestBrowSetEncapsulator implements Iterable<TestBrowEncapsulator> {
    public BrowStateSetBuilder stateSetBuilder = new BrowStateSetBuilder();
    private List<TestBrowEncapsulator> encapsulators = new ArrayList<TestBrowEncapsulator>();

    public void add(TestBrowEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public TestBrowSetEncapsulator(TestBrowEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestBrowEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TestBrowEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TestBrowSet asTestBrowSet() {
        List<TestBrow> result = new ArrayList<TestBrow>();

        for (TestBrowEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTestBrow());
        }
        return new TestBrowHashSet(result);
    }

    public boolean isValid() {
        for (TestBrowEncapsulator encapsulator : encapsulators) {
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
