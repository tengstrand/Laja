package net.sf.laja.cdd.behaviour.mouth;

import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.state.mouth.MouthBehaviour;
import net.sf.laja.cdd.state.mouth.MouthState;
import net.sf.laja.cdd.state.mouth.MouthStateBuilder;
// Toe

public class MouthEncapsulator implements MouthStateComparable {
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
    public int hashCode() {
        return builder.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return builder.equals(obj);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
