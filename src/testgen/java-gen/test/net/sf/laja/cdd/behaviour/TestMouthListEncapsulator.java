package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.mouth.MouthStateListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestMouthListEncapsulator implements Iterable<TestMouthEncapsulator> {
    public MouthStateListBuilder stateList = new MouthStateListBuilder();
    private List<TestMouthEncapsulator> encapsulators = new ArrayList<TestMouthEncapsulator>();

    public void add(TestMouthEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public TestMouthListEncapsulator(TestMouthEncapsulator... encapsulators) {
        this.encapsulators.addAll(Arrays.asList(encapsulators));

        for (TestMouthEncapsulator encapsulator : encapsulators) {
            stateList.add(encapsulator.builder);
        }
    }

    public Iterator<TestMouthEncapsulator> iterator() {
        return encapsulators.iterator();
    }

    public TestMouthList asTestMouthList() {
        List<TestMouth> result = new ArrayList<TestMouth>();

        for (TestMouthEncapsulator encapsulator : encapsulators) {
            result.add(encapsulator.asTestMouth());
        }
        return new TestMouthArrayList(result);
    }

    public boolean isValid() {
        for (TestMouthEncapsulator encapsulator : encapsulators) {
            if (!encapsulator.isValid()) {
                return false;
            }
        }
        return true;
    }
}
