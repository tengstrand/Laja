package net.sf.laja.cdd.behaviour.finger;

import net.sf.laja.cdd.state.finger.*;
import net.sf.laja.cdd.state.finger.FingerState;
import net.sf.laja.cdd.state.nail.NailState;
// Toe

public class FingerEncapsulator implements FingerStateComparable {
    public final FingerStateBuilder builder;

    public FingerEncapsulator(FingerStateBuilder builder) {
        this.builder = builder;
    }

    public Finger asFinger() {
        return (Finger)builder.as(new FingerFactory.FingerFactory_(builder));
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
