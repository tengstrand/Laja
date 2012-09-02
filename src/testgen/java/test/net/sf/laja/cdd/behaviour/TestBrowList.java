package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.BrowStateList;

import java.util.ArrayList;
import java.util.List;

public class TestBrowList extends TestBrowAbstractList {
    public TestBrowList(TestBrow... list) {
        super(list);
    }

    public TestBrowList(List<TestBrow> list) {
        super(list);
    }

    public TestBrowList(BrowStateList stateList) {
        super(stateList);
    }

    public List<Integer> areas() {
        List<Integer> result = new ArrayList<Integer>();
        for (TestBrow brow : this) {
            result.add(brow.getArea());
        }
        return result;
    }
}
