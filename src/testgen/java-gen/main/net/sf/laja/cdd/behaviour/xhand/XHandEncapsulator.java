package net.sf.laja.cdd.behaviour.xhand;

import net.sf.laja.cdd.state.xhand.*;
import net.sf.laja.cdd.state.xhand.XHandState;
import net.sf.laja.cdd.state.finger.FingerState;
// Toe

public class XHandEncapsulator implements XHandStateComparable {
    public final XHandStateBuilder builder;

    public XHandEncapsulator(XHandStateBuilder builder) {
        this.builder = builder;
    }

    public XHand asXHand() {
        return (XHand)builder.as(new XHandFactory.XHandFactory_(builder));
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
