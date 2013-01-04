package net.sf.laja.example.person.state;

import java.util.*;
import net.sf.laja.example.person.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class HeightStateListImpl extends ArrayList<HeightState> implements HeightStateList {
    private Object encapsulator;

    public HeightStateListImpl() {
    }

    public HeightStateListImpl(int size) {
        super(size);
    }

    public static HeightStateList emptyList() {
        return new HeightStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (HeightState state : this) {
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
