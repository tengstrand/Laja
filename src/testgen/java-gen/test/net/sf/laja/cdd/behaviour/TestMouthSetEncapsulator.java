package net.sf.laja.cdd.behaviour;

import java.util.*;
import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.state.mouth.MouthState;

public class TestMouthSetEncapsulator implements Iterable<TestMouthEncapsulator> {
    public MouthStateSetBuilder stateSetBuilder = new MouthStateSetBuilder();
    private List<TestMouthEncapsulator> encapsulators = new ArrayList<TestMouthEncapsulator>();

    public void add(TestMouthEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateSetBuilder.add(encapsulator.builder);
    }

    public TestMouthSetEncapsulator(TestMouthEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestMouthEncapsulator encapsulator : encapsulators) {
            stateSetBuilder.add(encapsulator.builder);
        }
    }

    public Iterator<TestMouthEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TestMouthSet asTestMouthSet() {
        List<TestMouth> result = new ArrayList<TestMouth>();

        for (TestMouthEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTestMouth());
        }
        return new TestMouthHashSet(result);
    }

    public boolean isValid() {
        for (TestMouthEncapsulator encapsulator : encapsulators) {
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
