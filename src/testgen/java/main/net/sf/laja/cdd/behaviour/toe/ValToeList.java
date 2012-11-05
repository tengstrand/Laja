package net.sf.laja.cdd.behaviour.toe;

import java.util.List;
import net.sf.laja.cdd.state.toe.ToeStateList;

public class ValToeList extends ValToeArrayList {
    public ValToeList(ValToe... list) {
        super(list);
    }

    public ValToeList(List<ValToe> list) {
        super(list);
    }

    public ValToeList(ToeStateList stateList) {
        super(stateList);
    }
}
