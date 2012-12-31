package net.sf.laja.cdd.state.head;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class HeadStateListImpl extends ArrayList<HeadState> implements HeadStateList {
    private Object encapsulator;

    public HeadStateListImpl() {
    }

    public HeadStateListImpl(int size) {
        super(size);
    }

    public static HeadStateList emptyList() {
        return new HeadStateListImpl();
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
            throw new IllegalStateException("The state has been encapsulated by an instance of " + this.encapsulator.getClass().getSimpleName() + " and can not be operated by " + encapsulator.getClass().getSimpleName());
        }
    }
}
