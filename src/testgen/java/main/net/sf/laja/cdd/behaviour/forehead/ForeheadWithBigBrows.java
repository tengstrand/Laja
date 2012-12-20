package net.sf.laja.cdd.behaviour.forehead;

import net.sf.laja.cdd.behaviour.brow.BigBrow;
import net.sf.laja.cdd.behaviour.brow.BigBrowArrayList;
import net.sf.laja.cdd.behaviour.brow.BigBrowList;
import net.sf.laja.cdd.state.forehead.ForeheadState;

public class ForeheadWithBigBrows extends ForeheadFactory {
    private final BigBrowList bigBrowList;

    public ForeheadWithBigBrows(ForeheadState state) {
        super(state);
        bigBrowList = new BigBrowArrayList(state.getBrows());
    }

    public void mutate() {
        bigBrowList.add(BigBrow.area(1).asBigBrow());
    }
}
