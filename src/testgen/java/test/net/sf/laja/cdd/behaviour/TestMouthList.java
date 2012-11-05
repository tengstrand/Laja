package net.sf.laja.cdd.behaviour;

import java.util.List;
import net.sf.laja.cdd.state.mouth.MouthStateList;

public class TestMouthList extends TestMouthArrayList {
    public TestMouthList(TestMouth... list) {
        super(list);
    }

    public TestMouthList(List<TestMouth> list) {
        super(list);
    }

    public TestMouthList(MouthStateList stateList) {
        super(stateList);
    }

    public int stateSize() {
        return stateList == null ? 0 : stateList.size();
    }
}
