package net.sf.laja.cdd.state.forehead;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ForeheadStateListImpl extends ArrayList<ForeheadState> implements ForeheadStateList {
    private Object encapsulator;

    public ForeheadStateListImpl() {
    }

    public ForeheadStateListImpl(int size) {
        super(size);
    }

    public static ForeheadStateList emptyList() {
        return new ForeheadStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (ForeheadState state : this) {
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
            String thatEcapsulator = encapsulator == null ? null : encapsulator.getClass().getSimpleName();
            String thisEcapsulator = this.encapsulator == null ? null : this.encapsulator.getClass().getSimpleName();
            throw new IllegalStateException("The state has been encapsulated by an instance of " + thisEcapsulator + " and can not be mutated by an instance of " + thatEcapsulator);
        }
    }
}
