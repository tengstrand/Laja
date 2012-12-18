package net.sf.laja.cdd.behaviour.foot;

import net.sf.laja.cdd.behaviour.toe.ToeListEncapsulator;
import net.sf.laja.cdd.state.foot.FootState;
import net.sf.laja.cdd.state.foot.FootStateBuilder;
import net.sf.laja.cdd.state.foot.FootStateBuilderImpl;
import net.sf.laja.cdd.state.foot.FootStateImpl;

public class FootBuilder {
    public final FootStateBuilder builder;

    public FootBuilder() {
        builder = FootStateImpl.build();
    }

    public FootBuilder(FootState state) {
        builder = new FootStateBuilderImpl(state);
    }

    public FootBuilder(FootState state, Object encapsulator) {
        builder = new FootStateBuilderImpl(state, encapsulator);
    }

    public FootBuilder withArea(int area) {
        builder.withArea(area);
        return this;
    }

    public FootBuilder withToes(ToeListEncapsulator toes) {
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
