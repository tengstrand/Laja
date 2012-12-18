package net.sf.laja.cdd.behaviour.toe;

import net.sf.laja.cdd.state.toe.*;
import net.sf.laja.cdd.state.toe.ToeState;

public class ToeBuilder {
    public final ToeStateBuilder builder;

    public ToeBuilder() {
        builder = ToeStateImpl.build();
    }

    public ToeBuilder(ToeState state) {
        builder = new ToeStateBuilderImpl(state);
    }

    public ToeBuilder(ToeState state, Object encapsulator) {
        builder = new ToeStateBuilderImpl(state, encapsulator);
    }

    public ToeBuilder withLength(int length) {
        builder.withLength(length);
        return this;
    }

    public ToeBuilder withWeight(int weight) {
        builder.withWeight(weight);
        return this;
    }

    public boolean isValid() {
        return builder.isValid();
    }

    public Toe asToe() {
        return (Toe)builder.as(new ToeFactory.ToeFactory_(builder));
    }

    public ValToe asValToe() {
        return (ValToe)builder.as(new ToeFactory.ValToeFactory_(builder));
    }
}
