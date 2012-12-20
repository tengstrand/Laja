package net.sf.laja.cdd.state.brow;

import java.util.*;
import net.sf.laja.cdd.state.Certificate;

/**
 * Code generated by Laja - Do not change!
 *
 *   http://laja.sf.net
 */
public class BrowStateListImpl extends ArrayList<BrowState> implements BrowStateList {
    private Object encapsulator;

    public BrowStateListImpl() {
    }

    public BrowStateListImpl(int size) {
        super(size);
    }

    public static BrowStateList emptyList() {
        return new BrowStateListImpl();
    }

    public Certificate certificate() {
        return Certificate.get(this);
    }

    public boolean isValid() {
        for (BrowState state : this) {
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
