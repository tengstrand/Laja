package net.sf.laja.example.account.state;

import java.util.*;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.tengstrand.nu
 */
public class AccountStateHashSet extends HashSet<AccountState> implements AccountStateSet {
    private Object encapsulator;

    public AccountStateHashSet() {
    }

    public AccountStateHashSet(int size) {
        super(size);
    }

    public static AccountStateSet emptySet() {
        return new AccountStateHashSet();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (AccountState state : this) {
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
        if (this.encapsulator != null && this.encapsulator != encapsulator) {
            if (encapsulator != null && encapsulator.getClass() == this.encapsulator.getClass()) {
                throw new IllegalStateException("The state has been encapsulated by another instance of " + this.encapsulator.getClass().getSimpleName() + " and can not be mutated by this behaviour instance");
            }
            String thatEncapsulator = encapsulator == null ? null : encapsulator.getClass().getSimpleName();
            String thisEncapsulator = this.encapsulator == null ? null : this.encapsulator.getClass().getSimpleName();
            throw new IllegalStateException("The state has been encapsulated by an instance of " + thisEncapsulator + " and can not be mutated by an instance of " + thatEncapsulator);
        }
    }
}
