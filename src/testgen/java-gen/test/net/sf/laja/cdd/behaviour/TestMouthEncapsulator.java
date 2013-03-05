package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.mouth.*;
import net.sf.laja.cdd.behaviour.mouth.CuteMouth;
import net.sf.laja.cdd.state.mouth.MouthState;
// Toe

public class TestMouthEncapsulator implements MouthStateComparable {
    public final MouthStateBuilder builder;

    public TestMouthEncapsulator(MouthStateBuilder builder) {
        this.builder = builder;
    }

    public TestMouth asTestMouth() {
        return (TestMouth)builder.as(new TestMouthFactory.TestMouthFactory_());
    }

    public TestMouthEncapsulator withNumberOfTeeth(int numberOfTeeth) {
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
