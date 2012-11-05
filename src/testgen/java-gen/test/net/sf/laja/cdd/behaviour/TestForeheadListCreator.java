package net.sf.laja.cdd.behaviour;

import java.util.*;
import net.sf.laja.cdd.state.forehead.*;
import net.sf.laja.cdd.state.brow.BrowStateList;
import net.sf.laja.cdd.state.forehead.ForeheadState;
import net.sf.laja.cdd.state.brow.BrowStateList;

public class TestForeheadListCreator implements Iterable<TestForeheadEncapsulator> {
    public ForeheadStateListBuilder stateList = new ForeheadStateListBuilder();
    private List<TestForeheadEncapsulator> encapsulators = new ArrayList<TestForeheadEncapsulator>();

    public void add(TestForeheadEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public TestForeheadListCreator(TestForeheadEncapsulator... encapsulators) {
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
