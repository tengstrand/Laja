package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;

public class MouthEncapsulator {
    public final MouthStateBuilder builder;

    public MouthEncapsulator(MouthStateBuilder builder) {
        this.builder = builder;
    }

    public Mouth asMouth(MouthSize size) {
        return (Mouth)builder.as(new MouthFactory.MouthFactory_(builder), size);
    }

    public MouthEncapsulator withNumberOfTeeth(int numberOfTeeth) {
        builder.withNumberOfTeeth(numberOfTeeth);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
