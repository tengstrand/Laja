package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.state.mouth.MouthState;

public class TestMouthEncapsulator {
    public final MouthStateBuilder builder;

    public TestMouthEncapsulator(MouthStateBuilder builder) {
        this.builder = builder;
    }

    public TestMouth asTestMouth() {
        return (TestMouth)builder.as(new TestMouthFactory.TestMouthFactory_(builder));
    }

    public TestMouthEncapsulator withNumberOfTeeth(int numberOfTeeth) {
        builder.withNumberOfTeeth(numberOfTeeth);
        return this;
    }

    public boolean isValid() {
         return builder.isValid();
    }
}
