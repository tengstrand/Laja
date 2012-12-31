package net.sf.laja.example.repository.state;

import java.util.*;
import net.sf.laja.example.repository.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class CustomerStateListImpl extends ArrayList<CustomerState> implements CustomerStateList {
    private Object encapsulator;

    public CustomerStateListImpl() {
    }

    public CustomerStateListImpl(int size) {
        super(size);
    }

    public static CustomerStateList emptyList() {
        return new CustomerStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (CustomerState state : this) {
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
