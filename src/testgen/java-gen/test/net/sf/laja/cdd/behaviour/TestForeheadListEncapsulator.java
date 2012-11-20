package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.forehead.ForeheadStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestForeheadListEncapsulator implements Iterable<TestForeheadEncapsulator> {
    public ForeheadStateListBuilder stateList = new ForeheadStateListBuilder();
    private List<TestForeheadEncapsulator> encapsulators = new ArrayList<TestForeheadEncapsulator>();

    public void add(TestForeheadEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public TestForeheadListEncapsulator(TestForeheadEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestForeheadEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<TestForeheadEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TestForeheadList asTestForeheadList() {
        List<TestForehead> result = new ArrayList<TestForehead>();

        for (TestForeheadEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTestForehead());
        }
        return new TestForeheadArrayList(result);
    }

    public boolean isValid() {
        for (TestForeheadEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
