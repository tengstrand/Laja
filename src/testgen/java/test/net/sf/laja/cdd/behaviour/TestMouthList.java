package net.sf.laja.cdd.behaviour;

import java.util.List;
import net.sf.laja.cdd.state.mouth.MouthStateList;

public class TestMouthList extends TestMouthAbstractList {
    public TestMouthList(TestMouth... list) {
        super(list);
    }

    public TestMouthList(List<TestMouth> list) {
        super(list);
    }

    public TestMouthList(MouthStateList stateList) {
        super(stateList);
    }
}
