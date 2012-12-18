package net.sf.laja.cdd.behaviour;

import java.util.*;
import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;

public class TestBrowListEncapsulator implements Iterable<TestBrowEncapsulator> {
    public BrowStateListBuilder stateListBuilder = new BrowStateListBuilder();
    private List<TestBrowEncapsulator> encapsulators = new ArrayList<TestBrowEncapsulator>();

    public void add(TestBrowEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public TestBrowListEncapsulator(TestBrowEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestBrowEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TestBrowEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TestBrowList asTestBrowList() {
        List<TestBrow> result = new ArrayList<TestBrow>();

        for (TestBrowEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTestBrow());
        }
        return new TestBrowArrayList(result);
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
        return stateListBuilder.toString();
    }
}
