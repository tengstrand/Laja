package net.sf.laja.cdd.state.arm;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class ArmStateHashSet extends HashSet<ArmState> implements ArmStateSet {
    private Object encapsulator;

    public ArmStateHashSet() {
    }

    public ArmStateHashSet(int size) {
        super(size);
    }

    public static ArmStateSet emptySet() {
        return new ArmStateHashSet();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (ArmState state : this) {
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
