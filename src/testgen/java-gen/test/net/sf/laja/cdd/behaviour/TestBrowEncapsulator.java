package net.sf.laja.cdd.behaviour;

import net.sf.laja.cdd.state.brow.*;
import net.sf.laja.cdd.state.brow.BrowState;
// Toe

public class TestBrowEncapsulator implements BrowStateComparable {
    public final BrowStateBuilder builder;

    public TestBrowEncapsulator(BrowStateBuilder builder) {
        this.builder = builder;
    }

    public TestBrow asTestBrow() {
        return (TestBrow)builder.as(new TestBrowFactory.TestBrowFactory_());
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
