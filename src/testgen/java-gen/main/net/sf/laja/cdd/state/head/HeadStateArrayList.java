package net.sf.laja.cdd.state.head;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class HeadStateArrayList extends ArrayList<HeadState> implements HeadStateList {
    private Object encapsulator;

    public HeadStateArrayList() {
    }

    public HeadStateArrayList(int size) {
        super(size);
    }

    public static HeadStateList emptyList() {
        return new HeadStateArrayList();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (HeadState state : this) {
            if (!state.isValid()) {
                return false;
            }
        }
        return true;
    }

    public void encapsulate(Object encapsulator) {
        this.encapsulator = encapsulator;
    }

    public void throwExceptionIfNotEncapsulatedBy(Object encapsulator) {
        if (encapsulator != this.encapsulator) {
            if (encapsulator != null && this.encapsulator != null && encapsulator.getClass() == this.encapsulator.getClass()) {
                throw new IllegalStateException("The state has been encapsulated by another instance of " + this.encapsulator.getClass().getSimpleName() + " and can not be mutated by this behaviour instance");
            }
            String thatEncapsulator = encapsulator == null ? null : encapsulator.getClass().getSimpleName();
            String thisEncapsulator = this.encapsulator == null ? null : this.encapsulator.getClass().getSimpleName();
            throw new IllegalStateException("The state has been encapsulated by an instance of " + thisEncapsulator + " and can not be mutated by an instance of " + thatEncapsulator);
        }
    }
}
