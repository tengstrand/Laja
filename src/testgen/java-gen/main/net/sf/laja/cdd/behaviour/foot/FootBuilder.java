package net.sf.laja.cdd.behaviour.foot;

import net.sf.laja.cdd.state.foot.*;
import net.sf.laja.cdd.behaviour.toe.ToeList;
import net.sf.laja.cdd.state.foot.FootState;
import net.sf.laja.cdd.state.toe.ToeStateList;
import net.sf.laja.cdd.behaviour.toe.ToeBuilder;
import net.sf.laja.cdd.behaviour.toe.ToeListCreator;

public class FootBuilder {
    public final FootStateBuilder builder;

    public FootBuilder() {
        builder = FootStateImpl.build();
    }

    public FootBuilder(FootState state) {
        builder = FootStateImpl.build(state);
    }

    public FootBuilder withArea(int area) {
        builder.withArea(area);
        return this;
    }

    public FootBuilder withToes(ToeListCreator toes) {
        builder.withToes(toes.stateList);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Foot asFoot() {
        return (Foot)builder.as(new FootFactory.FootFactory_(builder));
    }
}
