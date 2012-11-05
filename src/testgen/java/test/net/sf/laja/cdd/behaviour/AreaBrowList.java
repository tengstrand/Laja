package net.sf.laja.cdd.behaviour;

import java.util.ArrayList;
import java.util.List;

public class AreaBrowList extends TestBrowArrayList {
    public AreaBrowList(TestBrow... list) {
        super(list);
    }

    public AreaBrowList(List<TestBrow> list) {
        super(list);
    }

    public List<Integer> areas() {
        List<Integer> result = new ArrayList<Integer>();
        for (TestBrow brow : this) {
            result.add(brow.getArea());
        }
        return result;
    }
}
