package net.sf.laja.cdd.behaviour.foot;

import net.sf.laja.cdd.state.foot.*;
import net.sf.laja.cdd.behaviour.toe.ToeArrayList;
import net.sf.laja.cdd.behaviour.toe.ToeList;
import net.sf.laja.cdd.state.foot.FootState;
import net.sf.laja.cdd.state.toe.ToeStateList;
import net.sf.laja.cdd.behaviour.toe.ToeEncapsulator;
import net.sf.laja.cdd.behaviour.toe.ToeListEncapsulator;

public class FootCreator {
    private final FootStateBuilder builder = FootStateImpl.build();

    public class Area_ {
        public Toes_ area(int area) {
            builder.withArea(area);
            return new Toes_();
        }
    }

    public class Toes_ {
        public FootEncapsulator toes(ToeEncapsulator... toes) {
            ToeListEncapsulator encapsulator = new ToeListEncapsulator(toes);
            builder.withToes(encapsulator.stateListBuilder);
            return create();
        }
    }

    public FootEncapsulator create() {
        return new FootEncapsulator(builder);
     }
}
