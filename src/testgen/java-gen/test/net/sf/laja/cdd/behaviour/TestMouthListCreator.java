package net.sf.laja.cdd.behaviour;

import java.util.*;
import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.state.mouth.MouthState;

public class TestMouthListCreator implements Iterable<TestMouthEncapsulator> {
    public MouthStateListBuilder stateList = new MouthStateListBuilder();
    private List<TestMouthEncapsulator> encapsulators = new ArrayList<TestMouthEncapsulator>();

    public void add(TestMouthEncapsulator encapsulator) {
        encapsulators.add(encapsulator);
        stateList.add(encapsulator.builder);
    }

    public TestMouthListCreator(TestMouthEncapsulator... encapsulators) {
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
        return new TestMouthList(result);
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
