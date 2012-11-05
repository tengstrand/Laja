package net.sf.laja.cdd.behaviour.hair;

import net.sf.laja.cdd.state.hair.HairStateList;

import java.util.List;

public class HairList extends HairArrayList {
    public HairList(Hair... list) {
        super(list);
    }

    public HairList(List<Hair> list) {
        super(list);
    }

    public HairList(HairStateList stateList) {
        super(stateList);
    }
}
