package net.sf.laja.cdd.behaviour;

import java.util.*;
import net.sf.laja.cdd.state.ear.*;
import net.sf.laja.cdd.behaviour.ear.EarFactory;
import net.sf.laja.cdd.state.ear.EarState;

public class TestEarListEncapsulator implements Iterable<TestEarEncapsulator> {
    public EarStateListBuilder stateListBuilder = new EarStateListBuilder();
    private List<TestEarEncapsulator> encapsulators = new ArrayList<TestEarEncapsulator>();

    public void add(TestEarEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateListBuilder.add(encapsulator.builder);
    }

    public TestEarListEncapsulator(TestEarEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestEarEncapsulator encapsulator : encapsulators) {
            stateListBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TestEarEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TestEarList asTestEarList() {
        List<TestEar> result = new ArrayList<TestEar>();

        for (TestEarEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTestEar());
        }
        return new TestEarArrayList(result);
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
        return stateListBuilder.toString();
    }
}
