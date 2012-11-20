package net.sf.laja.cdd.behaviour.foot;

import net.sf.laja.cdd.state.foot.FootStateBuilder;

public class FootEncapsulator {
    public final FootStateBuilder builder;

    public FootEncapsulator(FootStateBuilder builder) {
        this.builder = builder;
    }

    public Foot asFoot() {
        return (Foot)builder.as(new FootFactory.FootFactory_(builder));
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
