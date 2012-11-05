package net.sf.laja.cdd.behaviour.toe;

import java.util.List;
import net.sf.laja.cdd.state.toe.ToeStateList;

public class ToeList extends ToeArrayList {
    public ToeList(Toe... list) {
        super(list);
    }

    public ToeList(List<Toe> list) {
        super(list);
    }

    public ToeList(ToeStateList stateList) {
        super(stateList);
    }
}
